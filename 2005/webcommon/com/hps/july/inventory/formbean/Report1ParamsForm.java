package com.hps.july.inventory.formbean;

import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта "Наличие оборудования"
 */
public class Report1ParamsForm extends ReportForm {
	private String storagetype; // Storage type: 1 - Position, 2 - storage, 3 - worker, 4 - organization;
	private StringAndIntegerProperty position;
	private String positionid;
	private String positionname;
	private StringAndIntegerProperty storage;
	private String storagename;
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;
	private StringAndIntegerProperty organization;
	private String organizationname;

	private String reporttype; // Report type: E - group by position complects, T - group by resource types and subtypes

	private Boolean incAll;
	private Boolean incDamps;
	private Boolean incGsm;
	private Boolean incDcs;
	private Boolean incControllers;
	private Boolean incSwitches;
	private Boolean incRepeaters;
	private Boolean incComs;
	private Boolean incOthers;
	private Boolean incWlans;

	// /!\ Specify "include selected resource types"
	// /!\ "include selected resource subtypes"
	private Boolean incttypes;
	private Boolean incvtypes;
	
	private String statetype; // C - current date, D - given date
	private StringAndSqlDateProperty stateDate;

	private Boolean showAgregateContent;
	private Boolean showByResourceSets;
	private Boolean showWithContract;
	private Boolean showWithDelivery;
public Report1ParamsForm() {
	organization = new StringAndIntegerProperty();
	position = new StringAndIntegerProperty();
	stateDate = new StringAndSqlDateProperty();
	stateDate.setSqlDate(new java.sql.Date((new java.util.Date()).getTime()));
	storage = new StringAndIntegerProperty();
	worker = new StringAndIntegerProperty();

	storagetype = "P";
	reporttype = "T";
	statetype = "C";

	incAll = Boolean.TRUE;
	incDamps = Boolean.FALSE;
	incGsm = Boolean.FALSE;
	incDcs = Boolean.FALSE;
	incControllers = Boolean.FALSE;
	incSwitches = Boolean.FALSE;
	incRepeaters = Boolean.FALSE;
	incComs = Boolean.FALSE;
	incOthers = Boolean.FALSE;
	incWlans = Boolean.FALSE;

	showAgregateContent = Boolean.FALSE;
	showByResourceSets = Boolean.FALSE;
	showWithContract = Boolean.FALSE;
	showWithDelivery = Boolean.FALSE;
}
public String getComplectsString() {
	String r = "";
	if(incAll != null && incAll.booleanValue()) {
		r = "*";
	} else {
		if(incDamps != null && incDamps.booleanValue()) { r += "A"; }
		if(incGsm != null && incGsm.booleanValue()) { r += "G"; }
		if(incDcs != null && incDcs.booleanValue()) { r += "D"; }
		if(incControllers != null && incControllers.booleanValue()) { r += "C"; }
		if(incSwitches != null && incSwitches.booleanValue()) { r += "S"; }
		if(incRepeaters != null && incRepeaters.booleanValue()) { r += "R"; }
		if(incComs != null && incComs.booleanValue()) { r += "M"; }
		if(incOthers != null && incOthers.booleanValue()) { r += "O"; }
		if(incWlans != null && incWlans.booleanValue()) { r += "W"; }
	}
	return r;
}
public java.lang.Boolean getIncAll() {
	return incAll;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncComs() {
	return incComs;
}
public java.lang.Boolean getIncControllers() {
	return incControllers;
}
public java.lang.Boolean getIncDamps() {
	return incDamps;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncDcs() {
	return incDcs;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncGsm() {
	return incGsm;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncOthers() {
	return incOthers;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncRepeaters() {
	return incRepeaters;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSwitches() {
	return incSwitches;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncttypes() {
	return incttypes;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncvtypes() {
	return incvtypes;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncWlans() {
	return incWlans;
}
public Integer getOrganization() {
	return organization.getInteger();
}
public String getOrganizationFrm() {
	return organization.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOrganizationname() {
	return organizationname;
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
public java.lang.String getReporttype() {
	return reporttype;
}
public java.lang.Boolean getShowAgregateContent() {
	return showAgregateContent;
}
public java.lang.Boolean getShowByResourceSets() {
	return showByResourceSets;
}
public java.lang.Boolean getShowWithContract() {
	return showWithContract;
}
public java.lang.Boolean getShowWithDelivery() {
	return showWithDelivery;
}
public int getState() {
	return com.hps.july.inventory.APPStates.RPT1PARAMS;
}
public java.sql.Date getStateDate() {
	return stateDate.getSqlDate();
}
public String getStateDateFrm() {
	return stateDate.getString();
}
public java.lang.String getStatetype() {
	return statetype;
}
public String getStCode() {
	String r = "";
	if("P".equals(storagetype)) {
		r += getPositionFrm();
	} else if("S".equals(storagetype)) {
		r += getStorageFrm();
	} else if("E".equals(storagetype)) {
		r += getWorkerFrm();
	} else if("O".equals(storagetype)) {
		r += getOrganizationFrm();
	}
	return r;
}
public Integer getStorage() {
	return storage.getInteger();
}
public String getStorageFrm() {
	return storage.getString();
}
/**
 * 
 * @return java.lang.String
 */
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
public Integer getWorker() {
	return worker.getInteger();
}
public String getWorkerFrm() {
	return worker.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
public void setIncAll(java.lang.Boolean newIncAll) {
	incAll = newIncAll;
}
/**
 * 
 * @param newIncComs java.lang.Boolean
 */
public void setIncComs(java.lang.Boolean newIncComs) {
	incComs = newIncComs;
}
public void setIncControllers(java.lang.Boolean newIncControllers) {
	incControllers = newIncControllers;
}
public void setIncDamps(java.lang.Boolean newIncDamps) {
	incDamps = newIncDamps;
}
/**
 * 
 * @param newIncDcs java.lang.Boolean
 */
public void setIncDcs(java.lang.Boolean newIncDcs) {
	incDcs = newIncDcs;
}
/**
 * 
 * @param newIncGsm java.lang.Boolean
 */
public void setIncGsm(java.lang.Boolean newIncGsm) {
	incGsm = newIncGsm;
}
/**
 * 
 * @param newIncOthers java.lang.Boolean
 */
public void setIncOthers(java.lang.Boolean newIncOthers) {
	incOthers = newIncOthers;
}
/**
 * 
 * @param newIncRepeaters java.lang.Boolean
 */
public void setIncRepeaters(java.lang.Boolean newIncRepeaters) {
	incRepeaters = newIncRepeaters;
}
/**
 * 
 * @param newIncSwitches java.lang.Boolean
 */
public void setIncSwitches(java.lang.Boolean newIncSwitches) {
	incSwitches = newIncSwitches;
}
/**
 * 
 * @param newIncttypes java.lang.Boolean
 */
public void setIncttypes(java.lang.Boolean newIncttypes) {
	incttypes = newIncttypes;
}
/**
 * 
 * @param newIncvtypes java.lang.Boolean
 */
public void setIncvtypes(java.lang.Boolean newIncvtypes) {
	incvtypes = newIncvtypes;
}
/**
 * 
 * @param newIncWlans java.lang.Boolean
 */
public void setIncWlans(java.lang.Boolean newIncWlans) {
	incWlans = newIncWlans;
}
public void setOrganization(Integer newOrganization) {
	organization.setInteger(newOrganization);
}
public void setOrganizationFrm(String newOrganization) {
	organization.setString(newOrganization);
}
/**
 * 
 * @param newOrganizationname java.lang.String
 */
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
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
public void setReporttype(java.lang.String newReporttype) {
	reporttype = newReporttype;
}
public void setShowAgregateContent(java.lang.Boolean newShowAgregateContent) {
	showAgregateContent = newShowAgregateContent;
}
public void setShowByResourceSets(java.lang.Boolean newShowByResourceSets) {
	showByResourceSets = newShowByResourceSets;
}
public void setShowWithContract(java.lang.Boolean newShowWithContract) {
	showWithContract = newShowWithContract;
}
public void setShowWithDelivery(java.lang.Boolean newShowWithDelivery) {
	showWithDelivery = newShowWithDelivery;
}
public void setStateDate(java.sql.Date newStateDate) {
	stateDate.setSqlDate(newStateDate);
}
public void setStateDateFrm(String newStateDate) {
	stateDate.setString(newStateDate);
}
public void setStatetype(java.lang.String newStatetype) {
	statetype = newStatetype;
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
public void setWorker(Integer newWorker) {
	worker.setInteger(newWorker);
}
public void setWorkerFrm(String newWorker) {
	worker.setString(newWorker);
}
/**
 * 
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * 
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if("P".equals(storagetype)) {
		if(position.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.emptyposition"));
		} else if(!position.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.badposition"));
		} else {
			try {
				PositionAccessBean p = new PositionAccessBean();
				p.setInitKey_storageplace(position.getInteger().intValue());
				p.refreshCopyHelper();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.unknownposition"));
			}
		}
		
	} else
	if("S".equals(storagetype)) {
		if(storage.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.emptystorage"));
		} else if(!storage.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.badstorage"));
		} else {
			try {
				StorageAccessBean s = new StorageAccessBean();
				s.setInitKey_storageplace(storage.getInteger().intValue());
				s.refreshCopyHelper();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.unknownstorage"));
			}
		}
	} else
	if("E".equals(storagetype)) {
		if(worker.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.emptyworker"));
		} else if(!worker.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.badworker"));
		} else {
			try {
				WorkerAccessBean s = new WorkerAccessBean();
				s.setInitKey_worker(worker.getInteger().intValue());
				s.refreshCopyHelper();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.unknownworker"));
			}
		}
	} else
	if("O".equals(storagetype)) {
		if(organization.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.emptyorganization"));
		} else if(!organization.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.badorganization"));
		} else {
			try {
				OrganizationAccessBean s = new OrganizationAccessBean();
				s.setInitKey_organization(organization.getInteger().intValue());
				s.refreshCopyHelper();
			} catch(Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report1.unknownorganization"));
			}
		}
	}
	
	if (!errors.empty())
		throw new ValidationException();
}
}
