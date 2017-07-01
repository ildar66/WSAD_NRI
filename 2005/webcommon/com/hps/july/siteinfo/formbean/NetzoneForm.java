package com.hps.july.siteinfo.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования зоны сети
 */
public class NetzoneForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private int netzone;
	private java.lang.String zonecode;
	private int superregionid;
	private int regionid;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setNetzone(keyGen.getNextKey("tables.netzones"));
    NetZoneAccessBean bean = new NetZoneAccessBean(getNetzone(), getName(),	getZonecode(), getRegionid() );
	return bean;
}
public void fillRecord(AbstractEntityAccessBean bean)
{
	try {
		RegionAccessBean r = new RegionAccessBean();
		r.setInitKey_regionid(getRegionid());
		r.refreshCopyHelper();
		superregionid = r.getSuperregion().getSupregid();
	} catch(Exception e) {
		superregionid = 0;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	NetZoneAccessBean bean = new NetZoneAccessBean();
	bean.setInitKey_netzone( getNetzone() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 16:32:46)
 * @return int
 */
public int getNetzone() {
	return netzone;
}
public int getRegionid() {
	return regionid;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.EDITNZONE;
}
public int getSuperregionid() {
	return superregionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 16:33:00)
 * @return java.lang.String
 */
public java.lang.String getZonecode() {
	return zonecode;
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception
{
	NetzoneListForm nzf = (NetzoneListForm)request.getSession().getAttribute("NetzoneListForm");
	com.hps.july.siteinfo.valueobject.RegionsSelector rs = nzf.getRegionsSelector();
	if(!rs.isAllRegions()) {
		Integer[] r = rs.getRegioncodes();
		if(r != null && r.length > 0 && r[0] != null) {
			regionid = r[0].intValue();
		}
	}
	try {
		RegionAccessBean ra = new RegionAccessBean();
		ra.setInitKey_regionid(regionid);
		ra.refreshCopyHelper();
		superregionid = ra.getSuperregion().getSupregid();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 16:32:46)
 * @param newNetzone int
 */
public void setNetzone(int newNetzone) {
	netzone = newNetzone;
}
public void setRegionid(int newRegionid) {
	regionid = newRegionid;
}
public void setSuperregionid(int newSuperregionid) {
	superregionid = newSuperregionid;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 16:33:00)
 * @param newZonecode java.lang.String
 */
public void setZonecode(java.lang.String newZonecode) {
	zonecode = newZonecode;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getName() == null) || (getName().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.netzone.name"));
	}
	
	if ((getZonecode() == null) || (getZonecode().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.netzone.zonecode"));
	}
	  
	if ((getZonecode() != null) && (getZonecode().length() > 5)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.netzone.zonecode"));
	}

	try {
		RegionAccessBean ra = new RegionAccessBean();
		ra.setInitKey_regionid(getRegionid());
		ra.refreshCopyHelper();
	} catch(Exception e) {
		e.printStackTrace(System.out);
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.netzone.region"));
	}

	  

	if (!errors.empty())
		throw new ValidationException();
}
}
