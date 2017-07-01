package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка оборудования позиции
 */
public class PosEquipmentListForm extends com.hps.july.web.util.BrowseForm {
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public PosEquipmentListForm() {
	this.setFinderMethodName( "findEquipmentSetByPosition" );
	storageplace = 0;
	posname = "";
	posid = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getBsRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteStation");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getComRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteTransport");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteTransport");
	roles.add("siteExploitor");
	roles.add("siteStation");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.StoragePlaceKey(storageplace) };
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getOtherRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("siteExploitor");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 18:31:02)
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
 * Creation date: (04.06.2002 19:12:14)
 * @return int
 */
public int getStorageplace() {
	return storageplace;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 18:31:02)
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
 * Creation date: (04.06.2002 19:12:14)
 * @param newStorageplace int
 */
public void setStorageplace(int newStorageplace) {
	storageplace = newStorageplace;
}
}
