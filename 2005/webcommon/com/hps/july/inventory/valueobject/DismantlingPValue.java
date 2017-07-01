package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Акты демонтажа на позиции"
 */
public class DismantlingPValue extends InternalRValue {
	private String position;
	private String equipment;
	private Integer positioncode;
public DismantlingPValue(Object o) {
	super(o);
	try {
		InternalOutBillAccessBean bean = getSo();
		EquipmentSetAccessBean equ = new EquipmentSetAccessBean();
		equ.setInitKey_storageplace(bean.getFrom().getStorageplace());
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
		equipment = EquipmentObject.getShortEquipmentTypeName(equ);
	} catch(Exception e) {
		position = "";
		positioncode = null;
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
