package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;
import com.hps.july.siteinfo.valueobject.*;

/**
 * Форма списка состава элемента оборудования
 */
public class EquipsdetListForm extends com.hps.july.web.util.BrowseForm {
	private int storageplace;
	private java.lang.String posname;
	private java.lang.String posid;
	private int storagecard;
	private java.lang.String cardname;
	private java.lang.String complectname;
	private com.hps.july.siteinfo.valueobject.EquipmentObject eqobj;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public EquipsdetListForm() {
	this.setFinderMethodName( "findByMainAgregateOrderByResourceAsc" );
	storageplace = 0;
	posname = "";
	posid = "";
	cardname = "";
	complectname = "";
	storagecard = 0;
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
 * Creation date: (02.12.2002 11:51:26)
 * @return java.lang.String
 */
public java.lang.String getCardname() {
	return cardname;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2002 11:59:25)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
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
 * Creation date: (05.12.2002 15:20:32)
 * @return com.hps.july.siteinfo.valueobject.EquipmentObject
 */
public com.hps.july.siteinfo.valueobject.EquipmentObject getEqobj() {
	return eqobj;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(storagecard) };
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
 * Creation date: (02.12.2002 11:50:07)
 * @return int
 */
public int getStoragecard() {
	return storagecard;
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
 * Creation date: (02.12.2002 11:51:26)
 * @param newCardname java.lang.String
 */
public void setCardname(java.lang.String newCardname) {
	cardname = newCardname;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2002 11:59:25)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 15:20:32)
 * @param newEqobj com.hps.july.siteinfo.valueobject.EquipmentObject
 */
public void setEqobj(com.hps.july.siteinfo.valueobject.EquipmentObject newEqobj) {
	eqobj = newEqobj;
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
 * Creation date: (02.12.2002 11:50:07)
 * @param newStoragecard int
 */
public void setStoragecard(int newStoragecard) {
	storagecard = newStoragecard;
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
