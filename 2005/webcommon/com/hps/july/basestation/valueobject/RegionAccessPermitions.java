package com.hps.july.basestation.valueobject;

import java.util.*;
import com.hps.july.persistence.*;

/**
 *  ласс-контейнер с информацией о правах доступа дл€ региона
 */
public class RegionAccessPermitions
{
	private boolean editPlan;
	private boolean editFact;
	private boolean viewPlan;
	private boolean viewFact;
private RegionAccessPermitions() {
	editFact = false;
	editPlan = false;
	viewPlan = false;
	viewFact = false;
}
public static RegionAccessPermitions getForRegion(String login, int region)
	throws Exception
{
	Enumeration en;
	RegionAccessPermitions rap = new RegionAccessPermitions();
	try {
		OperatorAccessBean op = (new OperatorAccessBean()).findByLogin(login);
		int operator = op.getOperator();

		SuperRegionAccAccessBean sregaccess = null;
		RegionAccAccessBean regaccess = null;
		RegionAccessBean r = new RegionAccessBean();
		r.setInitKey_regionid(region);
		r.refreshCopyHelper();
		int sreg = r.getSuperregion().getSupregid();
		en = (new SuperRegionAccAccessBean()).findByOperatorAndId(new Integer(operator),new Integer(sreg));
		if(en.hasMoreElements()) {
			sregaccess = (SuperRegionAccAccessBean)en.nextElement();
			regaccess = new RegionAccAccessBean();
			try {
				en = regaccess.findByOperatorAndId(new Integer(operator),new Integer(region));
				if(en.hasMoreElements()) {
					regaccess = (RegionAccAccessBean)en.nextElement();
				}
			} catch(Exception e) {
			}
		} else {
			throw new javax.ejb.ObjectNotFoundException("No access permissions for superregion for user:"+login);
		}

		// ѕроверка просмотра плановых данных
		if(sregaccess != null) {
			if(sregaccess.getViewplan()) {
				if(regaccess != null) {
					rap.setViewPlan(regaccess.getViewplan());
				} else {
					rap.setViewPlan(true);
				}
			} else {
				rap.setViewPlan(false);
			}
			
			// ѕроверка редактировани€ плановых данных
			if(sregaccess.getEditplan()) {
				if(regaccess != null) {
					rap.setEditPlan(regaccess.getEditplan());
				} else {
					rap.setEditPlan(true);
				}
			} else {
				rap.setEditPlan(false);
			}

			// ѕроверка просмотра фактических данных
			if(sregaccess.getViewfact()) {
				if(regaccess != null) {
					rap.setViewFact(regaccess.getViewfact());
				} else {
					rap.setViewFact(true);
				}
			} else {
				rap.setViewFact(false);
			}
			
			// ѕроверка редактировани€ фактических данных
			if(sregaccess.getEditfact()) {
				if(regaccess != null) {
					rap.setEditFact(regaccess.getEditfact());
				} else {
					rap.setEditFact(true);
				}
			} else {
				rap.setEditFact(false);
			}
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return rap;
}
public static RegionAccessPermitions getForSuperregion(String login, int superregion)
	throws Exception
{
	RegionAccessPermitions rap = new RegionAccessPermitions();
	try {
		OperatorAccessBean op = (new OperatorAccessBean()).findByLogin(login);
		int operator = op.getOperator();

		Enumeration en = (new SuperRegionAccAccessBean()).findByOperatorAndId(new Integer(operator),new Integer(superregion));
		if(en.hasMoreElements()) {
			SuperRegionAccAccessBean sregaccess = (SuperRegionAccAccessBean)en.nextElement();
	
			rap.setViewPlan(sregaccess.getViewplan());
			rap.setEditPlan(sregaccess.getEditplan());
			rap.setViewFact(sregaccess.getViewfact());
			rap.setEditFact(sregaccess.getEditfact());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	return rap;
}
public boolean isEditFact()
{
	return editFact;
}
public boolean isEditPlan()
{
	return editPlan;
}
public boolean isViewFact()
{
	return viewFact;
}
public boolean isViewPlan()
{
	return viewPlan;
}
protected void setEditFact(boolean newEditFact)
{
	editFact = newEditFact;
}
protected void setEditPlan(boolean newEditPlan)
{
	editPlan = newEditPlan;
}
protected void setViewFact(boolean newViewFact)
{
	viewFact = newViewFact;
}
protected void setViewPlan(boolean newViewPlan)
{
	viewPlan = newViewPlan;
}
}
