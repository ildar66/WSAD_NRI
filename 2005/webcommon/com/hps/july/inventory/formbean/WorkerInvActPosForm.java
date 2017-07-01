package com.hps.july.inventory.formbean;

import com.hps.july.inventory.sessionbean.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Позиции акта инвентаризации у сотрудника/подрядчика.
 * Creation date: (06.06.2005 17:20:25)
 * @author: Dmitry Dneprov
 */
public class WorkerInvActPosForm extends InvActPosForm {
/**
 * WorkerInvActPosForm constructor comment.
 */
public WorkerInvActPosForm() {
	super();
}
/**
 * Текущий режим приложения.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.inventory.APPStates.WRKINVPOS;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	WorkerInvActForm f = (WorkerInvActForm)request.getSession().getAttribute( "WorkerInvActForm" );
	setDocument(f.getDocument());
	setOwnercode(f.getOwnercode());
	OrganizationAccessBean org = new OrganizationAccessBean();
	if (getOwnercode() != null) {
		org.setInitKey_organization(getOwnercode().intValue());
		try {
			org.refreshCopyHelper();
			setOwnername(org.getName());
		} catch (Exception e) {
			setOwnername("");
			e.printStackTrace(System.out);
		}
	}
	//storage = f.getStoragecode();
	super.positionstate = "N";
	super.agregate = f.getEquipcode();
	setAgregatename(f.getEquipname());
	setAgregatemodel(""); //f.getAgregatemodel();
	setOrder(0);
	setUseplace(new Boolean("A".equals(f.getType())));
	try {
		DocumentPositionAccessBean fbean = new DocumentPositionAccessBean();
		DocumentPositionAccessBean bean = fbean.findMaxOrderPosition(new Integer(getDocument()));
		setOrder(bean.getOrder() + 1);
	} catch(Exception e) {
		setOrder(1);
	}
	if(getCopydocpos() != null) {
		// copy properties here from other document position
		try {
			int oldorder = order;
			I13nActPositionAccessBean copy = new I13nActPositionAccessBean();
			copy.setInitKey_docposition(getCopydocpos().intValue());
			copy.refreshCopyHelper();
			com.hps.july.util.BeanUtils.copyProperties(this,copy);
			setOrder(oldorder);
		} catch(Exception e) {
		}
	}
	setCopydocpos(null);
}

/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	WorkerInvActForm f = (WorkerInvActForm)request.getSession().getAttribute("WorkerInvActForm");
	setDocument(f.getDocument());
	setPositionState("N");
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setDocposition(keyGen.getNextKey("tables.docpositions"));
	I13nActPositionAccessBean bean = new I13nActPositionAccessBean(
		getDocposition(),		
		getResourcecode(),
		getOwnercode(),
		new Integer(getDocument()),
		getOrder(),
		getQty(),
		getPrice(),
		getBoxed(),
		getBoxed(),
		getBroken(),
		getBroken(),
		getPositionState(),
		Boolean.FALSE, Boolean.FALSE
	);
	return bean;
}

/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	WorkerInvActForm f = (WorkerInvActForm)request.getSession().getAttribute( "WorkerInvActForm" );
	setDocument(f.getDocument());
	setOwnercode(f.getOwnercode());
	setOwnername(f.getOwnername());
	//storage = f.getStoragecode();
	positionstate = "N";
	agregate = f.getEquipcode();
	agregatename = f.getEquipname();
	agregatemodel = ""; //f.getAgregatemodel();
	setUseplace(new Boolean("A".equals(f.getType())));
	I13nActPositionAccessBean bean = new I13nActPositionAccessBean();
	bean.setInitKey_docposition(getDocposition());
	return bean;
}
}
