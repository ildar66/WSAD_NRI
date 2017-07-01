package com.hps.july.siteinfo.formbean;

import com.hps.july.persistence.*;

/**
 * Список состава оборудования на позиции
 */
public class EquipdetListForm extends com.hps.july.web.util.BrowseForm {
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
	private String equipmentname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public EquipdetListForm() {
//	this.setFinderMethodName( "findByStorageNotAgregatedOrderByResourceAsc" );
	this.setFinderMethodName( "findEquipmentAgregates" );
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
 * 
 * @return java.lang.String
 */
public java.lang.String getEquipmentname() {
	return equipmentname;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(storageplace), new Integer(1) };
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
 * 
 * @param newEquipmentname java.lang.String
 */
public void setEquipmentname(java.lang.String newEquipmentname) {
	equipmentname = newEquipmentname;
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
