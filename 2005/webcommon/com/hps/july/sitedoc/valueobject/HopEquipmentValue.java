package com.hps.july.sitedoc.valueobject;

import com.hps.july.trailcom.beans.*;
import com.hps.july.persistence.*;

/**
 * Служебный класс-контейнер с параметрами оборудования одного из концов линии связи
 */
public class HopEquipmentValue {
	private String regionName = "";
	private String zoneName = "";
	private String address = "";
	private String positionName = "";
	private String equipmentName = "";
public HopEquipmentValue(ComEquipmentAccessBean src) {
	try {
		equipmentName += src.getName();
		
		PositionAccessBean pos = src.getPosition();
		if(pos != null) {
			positionName += constructPositionName(pos);
			address += pos.getAddress();
			regionName += pos.getRegion().getRegname();
			zoneName += pos.getNetZone().getName();
		}
	} catch(Exception e) {
		equipmentName = "";
		positionName = "";
		address = "";
		regionName = "";
		zoneName = "";
	}
}
public static String constructPositionName(PositionAccessBean pos) {
	String posname = "";
	if(pos == null) {
		return posname;
	}
	try {
		String gsm = pos.getGsmid() != null ? "D" + pos.getGsmid() : "";
		String damps = pos.getDampsid() != null ? "A" + pos.getDampsid() : "";

		posname = gsm
			+ (gsm.length() > 0 && damps.length() > 0 ? " " : "")
			+ damps
			+ (gsm.length() > 0 || damps.length() > 0 ? " " : "")
			+ pos.getName();
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}

	return posname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAddress() {
	return address;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getEquipmentName() {
	return equipmentName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionName() {
	return positionName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getRegionName() {
	return regionName;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getZoneName() {
	return zoneName;
}
/**
 * 
 * @param newAddress java.lang.String
 */
public void setAddress(java.lang.String newAddress) {
	address = newAddress;
}
/**
 * 
 * @param newEquipmentName java.lang.String
 */
public void setEquipmentName(java.lang.String newEquipmentName) {
	equipmentName = newEquipmentName;
}
/**
 * 
 * @param newPositionName java.lang.String
 */
public void setPositionName(java.lang.String newPositionName) {
	positionName = newPositionName;
}
/**
 * 
 * @param newRegionName java.lang.String
 */
public void setRegionName(java.lang.String newRegionName) {
	regionName = newRegionName;
}
/**
 * 
 * @param newZoneName java.lang.String
 */
public void setZoneName(java.lang.String newZoneName) {
	zoneName = newZoneName;
}
}
