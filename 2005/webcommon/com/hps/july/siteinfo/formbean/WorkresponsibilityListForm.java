package com.hps.july.siteinfo.formbean;

import com.hps.july.persistence.*;

/**
 * ‘орма списка видов ответственности сотрудника
 */
public class WorkresponsibilityListForm extends com.hps.july.web.util.BrowseForm {
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
	private java.lang.String searchstate;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkresponsibilityListForm() {
	this.setFinderMethodName("findByQBE");
	storageplace = 0;
	posname = "";
	setSearchstate("0");
	}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
    java.util.ArrayList roles = new java.util.ArrayList();
    roles.add("administrator");
    roles.add("siteExploitor");
    roles.add("siteProjector");
    roles.add("ArendaManager");
    roles.add("supregAdmin");
    roles.add("regionAdmin");

    //alexshr 09.09.03
    roles.add("ArendaEconomist");
    roles.add("ArendaMainEconomist");
    roles.add("ArendaMainManager");

    return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		new Boolean(true), new Integer(getStorageplace()),	// Boolean isStorageplace, Integer storageplace
		"0".equals(getSearchstate()) ? new Boolean(false) : new Boolean(true), new Integer(getSearchstate()),	// Boolean isType, Integer type
		new Integer(1)										// Integer order
	};
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:07:32)
 * @return java.lang.String
 */
public java.lang.String getPosid() {
	return posid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @return java.lang.String
 */
public java.lang.String getPosname() {
	return posname;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2003 19:25:28)
 * @return java.lang.String
 */
public java.lang.String getSearchstate() {
	return searchstate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:14)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (04.07.2002 12:07:32)
 * @param newPosid java.lang.String
 */
public void setPosid(java.lang.String newPosid) {
	posid = newPosid;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
/**
 * Insert the method's description here.
 * Creation date: (07.07.2003 19:25:28)
 * @param newSearchstate java.lang.String
 */
public void setSearchstate(java.lang.String newSearchstate) {
	searchstate = newSearchstate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:14)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
