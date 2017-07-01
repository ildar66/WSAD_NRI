package com.hps.july.inventory.formbean;

import com.hps.july.inventory.actionbean.MassCalcAction;
import com.hps.july.inventory.actionbean.MassCalcThread;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма параметров массового обсчёта
 */
public class MassCalcParamsForm extends ReportForm {
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
	
	private Boolean incAll;
		private Boolean incSAll;
			private Boolean incSInternal;
			private Boolean incSExternal;
			private Boolean incSInternalr;
			private Boolean incSExternalr;
			private Boolean incSInvact;
			private Boolean incSChange;
			private Boolean incSAssactb;
			private Boolean incSDassactb;
			private Boolean incSPayoff;
		private Boolean incPAll;
			private Boolean incPAssact;
			private Boolean incPDassact;
			private Boolean incPAssactb;
			private Boolean incPDassactb;
			private Boolean incPInvact;
			private Boolean incPChange;

	private String protocol;
	private StringAndIntegerProperty maxcount;
public MassCalcParamsForm() {
	datefrom = new StringAndSqlDateProperty();
	dateto = new StringAndSqlDateProperty();
	organization = new StringAndIntegerProperty();
	position = new StringAndIntegerProperty();
	storage = new StringAndIntegerProperty();
	worker = new StringAndIntegerProperty();
	owner = new StringAndIntegerProperty();

	maxcount = new StringAndIntegerProperty();

	storagetype = "0";
	
	isowner = Boolean.TRUE;

	incAll = Boolean.TRUE;
	protocol = "E"; // "D" is detailed report
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
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncAll() {
	return incAll;
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
	return incPAssact;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPAssactb() {
	return incPAssactb;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPChange() {
	return incPChange;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPDassact() {
	return incPDassact;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPDassactb() {
	return incPDassactb;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncPInvact() {
	return incPInvact;
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
	return incSAssactb;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSChange() {
	return incSChange;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSDassactb() {
	return incSDassactb;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSExternal() {
	return incSExternal;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSExternalr() {
	return incSExternalr;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSInternal() {
	return incSInternal;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSInternalr() {
	return incSInternalr;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSInvact() {
	return incSInvact;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIncSPayoff() {
	return incSPayoff;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsowner() {
	return isowner;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getMaxcount() {
	return maxcount;
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
public int getState() {
	return com.hps.july.inventory.APPStates.MASSCALCPARAMS;
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
	incPAssact = newIncPAssact;
}
/**
 * 
 * @param newIncPAssactb java.lang.Boolean
 */
public void setIncPAssactb(java.lang.Boolean newIncPAssactb) {
	incPAssactb = newIncPAssactb;
}
/**
 * 
 * @param newIncPChange java.lang.Boolean
 */
public void setIncPChange(java.lang.Boolean newIncPChange) {
	incPChange = newIncPChange;
}
/**
 * 
 * @param newIncPDassact java.lang.Boolean
 */
public void setIncPDassact(java.lang.Boolean newIncPDassact) {
	incPDassact = newIncPDassact;
}
/**
 * 
 * @param newIncPDassactb java.lang.Boolean
 */
public void setIncPDassactb(java.lang.Boolean newIncPDassactb) {
	incPDassactb = newIncPDassactb;
}
/**
 * 
 * @param newIncPInvact java.lang.Boolean
 */
public void setIncPInvact(java.lang.Boolean newIncPInvact) {
	incPInvact = newIncPInvact;
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
	incSAssactb = newIncSAssactb;
}
/**
 * 
 * @param newIncSChange java.lang.Boolean
 */
public void setIncSChange(java.lang.Boolean newIncSChange) {
	incSChange = newIncSChange;
}
/**
 * 
 * @param newIncSDassactb java.lang.Boolean
 */
public void setIncSDassactb(java.lang.Boolean newIncSDassactb) {
	incSDassactb = newIncSDassactb;
}
/**
 * 
 * @param newIncSExternal java.lang.Boolean
 */
public void setIncSExternal(java.lang.Boolean newIncSExternal) {
	incSExternal = newIncSExternal;
}
/**
 * 
 * @param newIncSExternalr java.lang.Boolean
 */
public void setIncSExternalr(java.lang.Boolean newIncSExternalr) {
	incSExternalr = newIncSExternalr;
}
/**
 * 
 * @param newIncSInternal java.lang.Boolean
 */
public void setIncSInternal(java.lang.Boolean newIncSInternal) {
	incSInternal = newIncSInternal;
}
/**
 * 
 * @param newIncSInternalr java.lang.Boolean
 */
public void setIncSInternalr(java.lang.Boolean newIncSInternalr) {
	incSInternalr = newIncSInternalr;
}
/**
 * 
 * @param newIncSInvact java.lang.Boolean
 */
public void setIncSInvact(java.lang.Boolean newIncSInvact) {
	incSInvact = newIncSInvact;
}
/**
 * 
 * @param newIncSPayoff java.lang.Boolean
 */
public void setIncSPayoff(java.lang.Boolean newIncSPayoff) {
	incSPayoff = newIncSPayoff;
}
/**
 * 
 * @param newIsowner java.lang.Boolean
 */
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
}
/**
 * 
 * @param newMaxcount com.hps.july.web.util.StringAndIntegerProperty
 */
public void setMaxcount(com.hps.july.web.util.StringAndIntegerProperty newMaxcount) {
	maxcount = newMaxcount;
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
	/*
	if (dActNumber == null || "".equals(dActNumber)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mismatch.dactnumber"));
	} else
	if (dActNumber.length() > 20) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mismatch.dactnumber"));
	}
	*/
//	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("label.all"));
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
