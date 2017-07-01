package com.hps.july.siteinfo.valueobject;

import com.hps.july.persistence.*;
import com.hps.july.trailcom.beans.*;

/**
 * Служебный класс с параметрами линии связи
 * @author: Maxim Gerasimov
 */
public class HopsObject {
	private int hopsid;
	private String hopstype = null;
	private String fromPosName = null;
	private String destPosName = null;
/**
 * HopsObject constructor comment.
 */
public HopsObject(HopAccessBean hop){

	try {
		hopsid = hop.getHopsid();
		hopstype = hop.getHopstype();

		EquipmentSetAccessBean equip1 = new EquipmentSetAccessBean();
		equip1.setInitKey_storageplace(hop.getEquipmentid_enda());
		equip1.refreshCopyHelper();
		fromPosName = equip1.getPosition().getName();

		EquipmentSetAccessBean equip2 = new EquipmentSetAccessBean();
		equip2.setInitKey_storageplace(hop.getEquipmentid_endb());
		equip2.refreshCopyHelper();
		destPosName = equip2.getPosition().getName();

	} catch (Exception e) {
		System.out.println("Error in HopsObject.constructor");
		e.printStackTrace(System.out);
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 11:42:09)
 * @return java.lang.String
 */
public java.lang.String getDestPosName() {
	return destPosName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 11:42:09)
 * @return java.lang.String
 */
public java.lang.String getFromPosName() {
	return fromPosName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 11:42:09)
 * @return int
 */
public int getHopsid() {
	return hopsid;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 11:42:09)
 * @return java.lang.String
 */
public java.lang.String getHopstype() {
	return hopstype;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 11:42:09)
 * @param newDestPosName java.lang.String
 */
public void setDestPosName(java.lang.String newDestPosName) {
	destPosName = newDestPosName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 11:42:09)
 * @param newFromPosName java.lang.String
 */
public void setFromPosName(java.lang.String newFromPosName) {
	fromPosName = newFromPosName;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 11:42:09)
 * @param newHopsid int
 */
public void setHopsid(int newHopsid) {
	hopsid = newHopsid;
}
/**
 * Insert the method's description here.
 * Creation date: (29.09.2003 11:42:09)
 * @param newHopstype java.lang.String
 */
public void setHopstype(java.lang.String newHopstype) {
	hopstype = newHopstype;
}
}
