package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Акты демонтажа блоков на позиции"
 */
public class DAssactBValue {
	private AssemblingActAccessBean so;
	private String positionname;
	private Integer position;
	private String positionid;
	private Integer complect;
	private String complectname;
public DAssactBValue(Object o) {
	position = new Integer(0);
	positionname = "";
	if(o instanceof AssemblingActAccessBean) {
		so = (AssemblingActAccessBean)o;
		try {
			so.refreshCopyHelper();
			EquipmentSetAccessBean e = new EquipmentSetAccessBean();
			e.setInitKey_storageplace(so.getFrom().getStorageplace());
			e.refreshCopyHelper();
			complect = new Integer(e.getStorageplace());
			complectname = EquipmentObject.getEquipmentSetName(e);
			PositionAccessBean p = e.getPosition();
			position = new Integer(p.getStorageplace());
			positionid = "";
			if(p.getGsmid() != null) {
				positionid = "D"+p.getGsmid()+" ";
			}
			if(p.getDampsid() != null) {
				positionid += "A"+p.getDampsid()+" ";
			}
			positionname = p.getName();
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	} else {
		so = null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:07:34)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplect() {
	return complect;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:06:23)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:07:34)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:06:23)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:01:20)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:01:20)
 * @return com.hps.july.persistence.AssemblingActAccessBean
 */
public com.hps.july.persistence.AssemblingActAccessBean getSo() {
	return so;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:07:34)
 * @param newComplect java.lang.Integer
 */
public void setComplect(java.lang.Integer newComplect) {
	complect = newComplect;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:06:23)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:07:34)
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:06:23)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:01:20)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:01:20)
 * @param newSo com.hps.july.persistence.AssemblingActAccessBean
 */
public void setSo(com.hps.july.persistence.AssemblingActAccessBean newSo) {
	so = newSo;
}
}
