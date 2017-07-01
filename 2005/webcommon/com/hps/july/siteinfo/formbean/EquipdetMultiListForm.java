package com.hps.july.siteinfo.formbean;

import com.hps.july.persistence.*;

/**
 * Список состава оборудования на позиции
 */
public class EquipdetMultiListForm
	extends com.hps.july.web.util.BrowseForm
{
	private int position;
	private java.lang.String posname;
	private java.lang.String posid;

	private Integer[] equiplist;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public EquipdetMultiListForm() {
//	this.setFinderMethodName( "findByStorageNotAgregatedOrderByResourceAsc" );
	this.setFinderMethodName( "findEquipmentAgregatesList" );
	position = 0;
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
 * @return java.lang.Integer[]
 */
public java.lang.Integer[] getEquiplist() {
	return equiplist;
}
public java.lang.Object[] getFilterParams() {
if(equiplist != null) {
for(int i = 0; i < equiplist.length; i++) {
	System.out.println("EQUIPLIST["+i+"]:"+equiplist[i]);
}
} else {
	equiplist = new Integer[] {};
}

	return new Object[] { equiplist, new Integer(1) };
}
public String getFinderMethodName() {
	return "findEquipmentAgregatesList";
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
 * 
 * @return int
 */
public int getPosition() {
	return position;
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
 * 
 * @param newEquiplist java.lang.Integer[]
 */
public void setEquiplist(java.lang.Integer[] newEquiplist) {
System.out.println("SET EQLIST:"+newEquiplist);
	equiplist = newEquiplist;
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
 * 
 * @param newPosition int
 */
public void setPosition(int newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (04.06.2002 19:12:30)
 * @param newPosname java.lang.String
 */
public void setPosname(java.lang.String newPosname) {
	posname = newPosname;
}
}
