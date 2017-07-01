package com.hps.july.inventory.valueobject;

import com.hps.july.persistence.*;

/**
 * Служебный класс для вывода данных списка документов "Акт монтажа АФС"
 * Создаётся из бина AfsMountActAccessBean
 */
public class AfsValue {
	private com.hps.july.persistence.AfsMountActAccessBean so;
	private String expedition;
	private String expeditioncode;
	private String type;
	private String position;
	private String equipment;
	private Integer positioncode;
	private String ownername;
public AfsValue(Object o) {
	expedition = "?";
	expeditioncode = "";
	type = "";
	position = "";
	positioncode = null;
	
	if(o instanceof AfsMountActAccessBean) {
		so = (AfsMountActAccessBean)o;
		try {
			so.refreshCopyHelper();
			ExpeditionAccessBean exp = new ExpeditionAccessBean();
			exp.setInitKey_storageplace(so.getFrom().getStorageplace());
			exp.refreshCopyHelper();
			if(exp.getExpeditor() != null) {
				expedition = exp.getExpeditor().getMan().getFullName();
				expeditioncode = ""+exp.getExpeditor().getWorker();
				type = "W";
			} else if(exp.getOrganization() != null) {
				expedition = exp.getOrganization().getName();
				expeditioncode = ""+exp.getOrganization().getOrganization();
				type = "P";
			}
			StoragePlaceAccessBean s = so.getTo();
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
			if(so.getOwner() != null) {
				ownername = so.getOwner().getName();
			} else {
				ownername = "";
			}
			equipment = EquipmentObject.getShortEquipmentTypeName(equ);
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	} else {
		so = null;
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
public java.lang.String getExpedition() {
	return expedition;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getExpeditioncode() {
	return expeditioncode;
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
 * @return com.hps.july.persistence.AfsMountActAccessBean
 */
public com.hps.july.persistence.AfsMountActAccessBean getSo() {
	return so;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
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
 * @param newExpedition java.lang.String
 */
public void setExpedition(java.lang.String newExpedition) {
	expedition = newExpedition;
}
/**
 * 
 * @param newExpeditioncode java.lang.String
 */
public void setExpeditioncode(java.lang.String newExpeditioncode) {
	expeditioncode = newExpeditioncode;
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
/**
 * 
 * @param newSo com.hps.july.persistence.AfsMountActAccessBean
 */
public void setSo(com.hps.july.persistence.AfsMountActAccessBean newSo) {
	so = newSo;
}
/**
 * 
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
