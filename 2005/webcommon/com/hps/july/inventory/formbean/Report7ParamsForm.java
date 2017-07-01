package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта "Расход оборудования с объекта"
 */
public class Report7ParamsForm extends ReportForm {
	private String storagetype; // Storage type: 1 - Position, 2 - storage, 3 - equipment
	private StringAndIntegerProperty position;
	private String positionid;
	private String positionname;
	private StringAndIntegerProperty storage;
	private String storagename;
	private StringAndIntegerProperty equipment;
	private String equipmentname;
	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	private Boolean showContract;

	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;

	private Boolean docAll;
	private Boolean docInwaybill;
	private Boolean docDeassact;
	private Boolean docDeassactb;
	private Boolean docPayoff;
	private Boolean docInv;
public Report7ParamsForm() {
	position = new StringAndIntegerProperty();
	storage = new StringAndIntegerProperty();
	equipment = new StringAndIntegerProperty();

	resource = new StringAndIntegerProperty();

	datefrom = new StringAndSqlDateProperty();
	dateto = new StringAndSqlDateProperty();

	showContract = Boolean.FALSE;
	docAll = Boolean.TRUE;
	docInwaybill = Boolean.FALSE;
	docDeassact = Boolean.FALSE;
	docDeassactb = Boolean.FALSE;
	docPayoff = Boolean.FALSE;
	docInv = Boolean.FALSE;

	storagetype = "1";
}
public java.sql.Date getDatefrom() {
	return datefrom.getSqlDate();
}
public String getDatefromFrm() {
	return datefrom.getString();
}
public java.sql.Date getDateto() {
	return dateto.getSqlDate();
}
public String getDatetoFrm() {
	return dateto.getString();
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocAll() {
	return docAll;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocDeassact() {
	return docDeassact;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocDeassactb() {
	return docDeassactb;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocInv() {
	return docInv;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocInwaybill() {
	return docInwaybill;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocPayoff() {
	return docPayoff;
}
public Integer getEquipment() {
	return equipment.getInteger();
}
public String getEquipmentFrm() {
	return equipment.getString();
}
public java.lang.String getEquipmentname() {
	return equipmentname;
}
public Integer getPosition() {
	return position.getInteger();
}
public String getPositionFrm() {
	return position.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
public String getResourcecode() {
	return resource.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowContract() {
	return showContract;
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT7PARAMS;
}
public Integer getStorage() {
	return storage.getInteger();
}
public String getStorageFrm() {
	return storage.getString();
}
public java.lang.String getStoragename() {
	return storagename;
}
public java.util.Enumeration getStorages() {
	try {
		StorageAccessBean bean = new StorageAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public java.lang.String getStoragetype() {
	return storagetype;
}
public void setDatefrom(java.sql.Date newDate) {
	datefrom.setSqlDate(newDate);
}
public void setDatefromFrm(String newDate) {
	datefrom.setString(newDate);
}
public void setDateto(java.sql.Date newDate) {
	dateto.setSqlDate(newDate);
}
public void setDatetoFrm(String newDate) {
	dateto.setString(newDate);
}
/**
 * 
 * @param newDocAll java.lang.Boolean
 */
public void setDocAll(java.lang.Boolean newDocAll) {
	docAll = newDocAll;
}
/**
 * 
 * @param newDocDeassact java.lang.Boolean
 */
public void setDocDeassact(java.lang.Boolean newDocDeassact) {
	docDeassact = newDocDeassact;
}
/**
 * 
 * @param newDocDeassactb java.lang.Boolean
 */
public void setDocDeassactb(java.lang.Boolean newDocDeassactb) {
	docDeassactb = newDocDeassactb;
}
/**
 * 
 * @param newDocInv java.lang.Boolean
 */
public void setDocInv(java.lang.Boolean newDocInv) {
	docInv = newDocInv;
}
/**
 * 
 * @param newDocInwaybill java.lang.Boolean
 */
public void setDocInwaybill(java.lang.Boolean newDocInwaybill) {
	docInwaybill = newDocInwaybill;
}
/**
 * 
 * @param newDocPayoff java.lang.Boolean
 */
public void setDocPayoff(java.lang.Boolean newDocPayoff) {
	docPayoff = newDocPayoff;
}
public void setEquipment(Integer newEquipment) {
	equipment.setInteger(newEquipment);
}
public void setEquipmentFrm(String newEquipment) {
	equipment.setString(newEquipment);
}
public void setEquipmentname(java.lang.String newEquipmentname) {
	equipmentname = newEquipmentname;
}
public void setPosition(Integer newPosition) {
	position.setInteger(newPosition);
}
public void setPositionFrm(String newPosition) {
	position.setString(newPosition);
}
/**
 * 
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * 
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
public void setResourcecode(String newResource) {
	resource.setString(newResource);
}
/**
 * 
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * 
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * 
 * @param newShowContract java.lang.Boolean
 */
public void setShowContract(java.lang.Boolean newShowContract) {
	showContract = newShowContract;
}
public void setStorage(Integer newStorage) {
	storage.setInteger(newStorage);
}
public void setStorageFrm(String newStorage) {
	storage.setString(newStorage);
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
public void setStoragetype(java.lang.String newStoragetype) {
	storagetype = newStoragetype;
}
}
