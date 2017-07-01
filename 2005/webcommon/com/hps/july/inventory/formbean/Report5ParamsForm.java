package com.hps.july.inventory.formbean;

import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта "Приход оборудования на объект"
 */
public class Report5ParamsForm extends ReportForm {
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
	private Boolean docIntincome;
	private Boolean docExtincome;
	private Boolean docAssact;
	private Boolean docAssactb;
	private Boolean docInvextra;
public Report5ParamsForm() {
	position = new StringAndIntegerProperty();
	storage = new StringAndIntegerProperty();
	equipment = new StringAndIntegerProperty();

	resource = new StringAndIntegerProperty();

	datefrom = new StringAndSqlDateProperty();
	dateto = new StringAndSqlDateProperty();

	showContract = Boolean.FALSE;
	docAll = Boolean.TRUE;
	docAssact = Boolean.FALSE;
	docAssactb = Boolean.FALSE;
	docExtincome = Boolean.FALSE;
	docIntincome = Boolean.FALSE;
	docInvextra = Boolean.FALSE;

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
public java.lang.Boolean getDocAssact() {
	return docAssact;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocAssactb() {
	return docAssactb;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocExtincome() {
	return docExtincome;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocIntincome() {
	return docIntincome;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getDocInvextra() {
	return docInvextra;
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
	return com.hps.july.inventory.APPStates.RPT5PARAMS;
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
 * @param newDocAssact java.lang.Boolean
 */
public void setDocAssact(java.lang.Boolean newDocAssact) {
	docAssact = newDocAssact;
}
/**
 * 
 * @param newDocAssactb java.lang.Boolean
 */
public void setDocAssactb(java.lang.Boolean newDocAssactb) {
	docAssactb = newDocAssactb;
}
/**
 * 
 * @param newDocExtincome java.lang.Boolean
 */
public void setDocExtincome(java.lang.Boolean newDocExtincome) {
	docExtincome = newDocExtincome;
}
/**
 * 
 * @param newDocIntincome java.lang.Boolean
 */
public void setDocIntincome(java.lang.Boolean newDocIntincome) {
	docIntincome = newDocIntincome;
}
/**
 * 
 * @param newDocInvextra java.lang.Boolean
 */
public void setDocInvextra(java.lang.Boolean newDocInvextra) {
	docInvextra = newDocInvextra;
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
	
	if(resource.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.report5.resource"));
	} else if(!resource.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.report5.resource"));
	} else {
		try {
			ResourceAccessBean bean = new ResourceAccessBean();
			bean.setInitKey_resource(resource.getInteger().intValue());
			bean.refreshCopyHelper();
			resourcename = bean.getName();
			resourcemodel = bean.getModel();
		} catch(Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notexist.report5.resource"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
