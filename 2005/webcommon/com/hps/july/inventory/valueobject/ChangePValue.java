package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Акты замены/модернизации на позиции"
 */
public class ChangePValue {
	private com.hps.july.persistence.ChangeActAccessBean so;
	private String position;
public ChangePValue(Object o) {
	position = "?";
	if(o instanceof ChangeActAccessBean) {
		so = (ChangeActAccessBean)o;
		try {
			so.refreshCopyHelper();
			EquipmentSetAccessBean exp = new EquipmentSetAccessBean();
			exp.setInitKey_storageplace(so.getFrom().getStorageplace());
			exp.refreshCopyHelper();
			position = "";
			try {
				PositionAccessBean pos = exp.getPosition();
				String positionid = "";
				if(pos.getDampsid() != null) {
					positionid = positionid + "A" + pos.getDampsid() + " ";
				}
				if(pos.getGsmid() != null) {
					positionid = positionid + "D" + pos.getGsmid() + " ";
				}
				position = positionid + pos.getName();
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} else {
		so = null;
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 16:03:25)
 * @return com.hps.july.persistence.ChangeActAccessBean
 */
public com.hps.july.persistence.ChangeActAccessBean getSo() {
	return so;
}
/**
 * 
 * @param newPosition java.lang.String
 */
public void setPosition(java.lang.String newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (26.07.2002 16:03:25)
 * @param newSo com.hps.july.persistence.ChangeActAccessBean
 */
public void setSo(com.hps.july.persistence.ChangeActAccessBean newSo) {
	so = newSo;
}
}
