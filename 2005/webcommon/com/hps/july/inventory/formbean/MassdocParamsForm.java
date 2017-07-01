package com.hps.july.inventory.formbean;

import com.hps.july.inventory.actionbean.MassCalcAction;
import com.hps.july.inventory.actionbean.MassCalcThread;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров отчёта о необсчитанных документах
 */
public class MassdocParamsForm extends ReportForm {
	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	
	private String storagetype;
	
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

	private Boolean isowner;
	private StringAndIntegerProperty owner;
	private String ownername;

	private String sorttype;
		
	private Boolean incAll;
		private Boolean incSAll;
/*
			private Boolean incSInternal;
			private Boolean incSExternal;
			private Boolean incSInternalr;
			private Boolean incSExternalr;
			private Boolean incSInvact;
			private Boolean incSChange;
			private Boolean incSAssactb;
			private Boolean incSDassactb;
			private Boolean incSPayoff;
*/
		private Boolean incPAll;
/*
			private Boolean incPAssact;
			private Boolean incPDassact;
			private Boolean incPAssactb;
			private Boolean incPDassactb;
			private Boolean incPInvact;
			private Boolean incPChange;
*/
	private Boolean[] incDocs;

	private String protocol;
public MassdocParamsForm() {
	datefrom = new StringAndSqlDateProperty();
	dateto = new StringAndSqlDateProperty();
	organization = new StringAndIntegerProperty();
	position = new StringAndIntegerProperty();
	storage = new StringAndIntegerProperty();
	worker = new StringAndIntegerProperty();
	owner = new StringAndIntegerProperty();

	storagetype = "0";
	
	isowner = Boolean.TRUE;

	incAll = Boolean.TRUE;
	incDocs = new Boolean[15];
	for(int i = 0; i < 15; i++) {
		incDocs[i] = Boolean.FALSE;
	}
	protocol = "E"; // "D" is detailed report
	sorttype = "1";
}
public void afterUpdate(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception
{
  	if(request.getSession().getAttribute(MassCalcAction.CALC_THREAD_NAME) != null) {
		MassCalcThread mct = (MassCalcThread)request.getSession().getAttribute(MassCalcAction.CALC_THREAD_NAME);
	  	if(mct.isFinished()) {
		  	request.getSession().removeAttribute(MassCalcAction.CALC_THREAD_NAME);
	  	}
  	}
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
public int getDocsize() {
	return incDocs.length;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncAll() {
	return incAll;
}
public String getIncDocsString() {
	String result = "";
	String[] doctypes = {
		"'W'", "'TS'", "'NS'", "'O'", "'IS'", "'AAS'", "'ADS'", "'P'", "'HS'", // 0 - 8
		"'TP'", "'NP'", "'AAP'", "'ADP'", "'IP'", "'HP'" // 9 - 14
	};
	boolean comma = false;
	boolean all = incAll.booleanValue();
	boolean alls = incSAll.booleanValue();
	boolean allp = incPAll.booleanValue();
	
	for(int i = 0; i < 9; i++) {
		if(all || alls || incDocs[i].booleanValue()) {
			if(comma) result += ",";
			result += doctypes[i];
			comma = true;
		}
	}
	for(int i = 9; i < 15; i++) {
		if(all || allp || incDocs[i].booleanValue()) {
			if(comma) result += ",";
			result += doctypes[i];
			comma = true;
		}
	}
	return result;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPAll() {
	return incPAll;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPAssact() {
	return incDocs[9];
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPAssactb() {
	return incDocs[11];
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPChange() {
	return incDocs[14];
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPDassact() {
	return incDocs[10];
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPDassactb() {
	return incDocs[12];
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPInvact() {
	return incDocs[13];
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSAll() {
	return incSAll;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSAssactb() {
	return incDocs[5]; //incSAssactb;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSChange() {
	return incDocs[8]; //incSChange;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSDassactb() {
	return incDocs[6]; //incSDassactb;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSExternal() {
	return incDocs[0];
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSExternalr() {
	return incDocs[3]; //incSExternalr;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSInternal() {
	return incDocs[1];//incSInternal;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSInternalr() {
	return incDocs[2];//incSInternalr;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSInvact() {
	return incDocs[4]; //incSInvact;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSPayoff() {
	return incDocs[7]; // incSPayoff;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsowner() {
	return isowner;
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
public Integer getOwner() {
	return owner.getInteger();
}
public String getOwnerFrm() {
	return owner.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
public java.util.Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
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
 * @return java.lang.String
 */
public java.lang.String getProtocol() {
	return protocol;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getSorttype() {
	return sorttype;
}
public int getState() {
	return com.hps.july.inventory.APPStates.MASSDOCPARAMS;
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
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 16:12:27)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getStorages() {
	try {
		StorageAccessBean bean = new StorageAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * 
 * @return java.lang.String
 */
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
 * @param newIncAll java.lang.Boolean
 */
public void setIncAll(java.lang.Boolean newIncAll) {
	incAll = newIncAll;
}
/**
 * 
 * @param newIncPAll java.lang.Boolean
 */
public void setIncPAll(java.lang.Boolean newIncPAll) {
	incPAll = newIncPAll;
}
/**
 * 
 * @param newIncPAssact java.lang.Boolean
 */
public void setIncPAssact(java.lang.Boolean newIncPAssact) {
	incDocs[9] = newIncPAssact;
}
/**
 * 
 * @param newIncPAssactb java.lang.Boolean
 */
public void setIncPAssactb(java.lang.Boolean newIncPAssactb) {
	incDocs[11] = newIncPAssactb;
}
/**
 * 
 * @param newIncPChange java.lang.Boolean
 */
public void setIncPChange(java.lang.Boolean newIncPChange) {
	incDocs[14] = newIncPChange;
}
/**
 * 
 * @param newIncPDassact java.lang.Boolean
 */
public void setIncPDassact(java.lang.Boolean newIncPDassact) {
	incDocs[10] = newIncPDassact;
}
/**
 * 
 * @param newIncPDassactb java.lang.Boolean
 */
public void setIncPDassactb(java.lang.Boolean newIncPDassactb) {
	incDocs[12] = newIncPDassactb;
}
/**
 * 
 * @param newIncPInvact java.lang.Boolean
 */
public void setIncPInvact(java.lang.Boolean newIncPInvact) {
	incDocs[13] = newIncPInvact;
}
/**
 * 
 * @param newIncSAll java.lang.Boolean
 */
public void setIncSAll(java.lang.Boolean newIncSAll) {
	incSAll = newIncSAll;
}
/**
 * 
 * @param newIncSAssactb java.lang.Boolean
 */
public void setIncSAssactb(java.lang.Boolean newIncSAssactb) {
	incDocs[5] = newIncSAssactb;
}
/**
 * 
 * @param newIncSChange java.lang.Boolean
 */
public void setIncSChange(java.lang.Boolean newIncSChange) {
	incDocs[8] = newIncSChange;
}
/**
 * 
 * @param newIncSDassactb java.lang.Boolean
 */
public void setIncSDassactb(java.lang.Boolean newIncSDassactb) {
	incDocs[6] = newIncSDassactb;
}
/**
 * 
 * @param newIncSExternal java.lang.Boolean
 */
public void setIncSExternal(java.lang.Boolean newIncSExternal) {
	incDocs[0] = newIncSExternal;
}
/**
 * 
 * @param newIncSExternalr java.lang.Boolean
 */
public void setIncSExternalr(java.lang.Boolean newIncSExternalr) {
	incDocs[3] = newIncSExternalr;
}
/**
 * 
 * @param newIncSInternal java.lang.Boolean
 */
public void setIncSInternal(java.lang.Boolean newIncSInternal) {
	incDocs[1] = newIncSInternal;
}
/**
 * 
 * @param newIncSInternalr java.lang.Boolean
 */
public void setIncSInternalr(java.lang.Boolean newIncSInternalr) {
	incDocs[2] = newIncSInternalr;
}
/**
 * 
 * @param newIncSInvact java.lang.Boolean
 */
public void setIncSInvact(java.lang.Boolean newIncSInvact) {
	incDocs[4] = newIncSInvact;
}
/**
 * 
 * @param newIncSPayoff java.lang.Boolean
 */
public void setIncSPayoff(java.lang.Boolean newIncSPayoff) {
	incDocs[7] = newIncSPayoff;
}
/**
 * 
 * @param newIsowner java.lang.Boolean
 */
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
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
public void setOwner(Integer newOwner) {
	owner.setInteger(newOwner);
}
public void setOwnerFrm(String newOwner) {
	owner.setString(newOwner);
}
/**
 * 
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
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
 * @param newProtocol java.lang.String
 */
public void setProtocol(java.lang.String newProtocol) {
	protocol = newProtocol;
}
/**
 * 
 * @param newSorttype java.lang.String
 */
public void setSorttype(java.lang.String newSorttype) {
	sorttype = newSorttype;
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
/**
 * 
 * @param newStoragetype java.lang.String
 */
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
	try {
		OrganizationAccessBean org = new OrganizationAccessBean();
		org.setInitKey_organization(owner.getInteger().intValue());
		org.refreshCopyHelper();
		ownername = org.getName();
	} catch(Exception e) {
		ownername = "?";
	}

	try {
		if(position.getInteger() != null) {
			PositionAccessBean p = new PositionAccessBean();
			p.setInitKey_storageplace(position.getInteger().intValue());
			p.refreshCopyHelper();
			positionname = p.getName();
			positionid = "";
			if(p.getDampsid() != null) {
				positionid += "A"+p.getDampsid()+" ";
			}
			if(p.getGsmid() != null) {
				positionid += "D"+p.getGsmid()+" ";
			}
		}
	} catch(Exception e) {
		positionid = "";
		positionname = "?";
	}

	try {
		storagename = "";
		if(storage.getInteger() != null) {
			StorageAccessBean s = new StorageAccessBean();
			s.setInitKey_storageplace(storage.getInteger().intValue());
			s.refreshCopyHelper();
			storagename = s.getName();
		}
	} catch(Exception e) {
		storagename = "?";
	}

	try {
		if(worker.getInteger() != null) {
			WorkerAccessBean w = new WorkerAccessBean();
			w.setInitKey_worker(worker.getInteger().intValue());
			w.refreshCopyHelper();
			workername = w.getMan().getFullName();
			workertitle = w.getPosition().getName();
		}
	} catch(Exception e) {
		workername = "?";
		workertitle = "";
	}
	
	try {
		if(organization.getInteger() != null) {
			OrganizationAccessBean org = new OrganizationAccessBean();
			org.setInitKey_organization(organization.getInteger().intValue());
			org.refreshCopyHelper();
			organizationname = org.getName();
		}
	} catch(Exception e) {
		organizationname = "?";
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
