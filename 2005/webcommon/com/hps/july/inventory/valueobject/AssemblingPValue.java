package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Акты монтажа на позиции"
 */
public class AssemblingPValue extends InternalValue {
	private String position;
	private Integer positioncode;
	private String ownername;
	private String equipment;
public AssemblingPValue(Object o) {
	super(o);
	try {
		InternalWayBillAccessBean bean = getSo();
//		bean.refreshCopyHelper();
		StoragePlaceAccessBean s = bean.getTo();
		EquipmentSetAccessBean equ = new EquipmentSetAccessBean();
		equ.setInitKey_storageplace(s.getStorageplace());
		equ.refreshCopyHelper();
		PositionAccessBean p = equ.getPosition();
		String positionid = "";
		if(p.getGsmid() != null) {
			positionid = "D"+p.getGsmid()+" ";
		}
		if(p.getDampsid() != null) {
			positionid += "A"+p.getDampsid()+" ";
		}
		position = positionid + " " + p.getName();
		positioncode = new Integer(equ.getPosition().getStorageplace());
		ownername = bean.getOwner().getName();
		equipment = EquipmentObject.getShortEquipmentTypeName(equ);
	} catch(Exception e) {
		position = "";
		positioncode = null;
		ownername = "";
		equipment = "";
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEquipment() {
	return equipment;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 14:59:06)
 * @return java.lang.String
 */
public java.lang.String getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 14:59:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getPositioncode() {
	return positioncode;
}
/**
 * 
 * @param newEquipment java.lang.String
 */
public void setEquipment(java.lang.String newEquipment) {
	equipment = newEquipment;
}
/**
 * 
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 14:59:06)
 * @param newPosition java.lang.String
 */
public void setPosition(java.lang.String newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (14.08.2002 14:59:06)
 * @param newPositioncode java.lang.Integer
 */
public void setPositioncode(java.lang.Integer newPositioncode) {
	positioncode = newPositioncode;
}
}
