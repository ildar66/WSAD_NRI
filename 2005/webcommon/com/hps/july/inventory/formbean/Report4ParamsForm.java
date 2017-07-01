package com.hps.july.inventory.formbean;

import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта "Приход на объект"
 */
public class Report4ParamsForm extends ReportForm {
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
	private Boolean detailedReport;
	private Boolean showContract;
	private Boolean showSupplies;
public Report4ParamsForm() {
	position = new StringAndIntegerProperty();
	storage = new StringAndIntegerProperty();
	equipment = new StringAndIntegerProperty();

	datefrom = new StringAndSqlDateProperty();
	dateto = new StringAndSqlDateProperty();
	detailedReport = Boolean.FALSE;
	showContract = Boolean.FALSE;
	showSupplies = Boolean.FALSE;

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
public java.lang.Boolean getDetailedReport() {
	return detailedReport;
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
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowContract() {
	return showContract;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowSupplies() {
	return showSupplies;
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT4PARAMS;
}
public Integer getStorage() {
	return storage.getInteger();
}
public String getStorageFrm() {
	return storage.getString();
}
public java.lang.String getStoragename() throws Exception {
	StorageAccessBean sab = new StorageAccessBean();	
	sab.setInitKey_storageplace(getStorage().intValue());
	return sab.getName();
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
 * @param newDetailedReport java.lang.Boolean
 */
public void setDetailedReport(java.lang.Boolean newDetailedReport) {
	detailedReport = newDetailedReport;
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
/**
 * 
 * @param newShowContract java.lang.Boolean
 */
public void setShowContract(java.lang.Boolean newShowContract) {
	showContract = newShowContract;
}
/**
 * 
 * @param newShowSupplies java.lang.Boolean
 */
public void setShowSupplies(java.lang.Boolean newShowSupplies) {
	showSupplies = newShowSupplies;
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
public void validateValues(ActionErrors errors) throws Exception 
{
	if("1".equals(storagetype)) {
		if(position.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.emptyposition"));
		} else if(!position.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.badposition"));
		} 		
	} else
	if("2".equals(storagetype)) {
		if(storage.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.emptystorage"));
		} else if(!storage.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.badstorage"));
		} 
	} 
	
	if (!errors.empty())
		throw new ValidationException();
}
}
