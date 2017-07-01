package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка документов "Требования"
 */
public class ReqListForm extends com.hps.july.web.util.BrowseForm {
	private Boolean isdivision;
	private StringAndIntegerProperty division;
	private String divisionname;
	
	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	
	private Boolean isposition;
	private StringAndIntegerProperty position;
	private String positionname;
	private String positionid;
	
	private Boolean isowner;
	private StringAndIntegerProperty owner;
	private String ownername;
	
	private String type;

	private Boolean isorganization;
	private StringAndIntegerProperty organization;
	private String organizationname;

	private Boolean isworker;
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private Integer company;
	private Integer sortType = new Integer(1);
public ReqListForm() {
	setLastVisited(true);
	datefrom = new StringAndSqlDateProperty();
	java.util.Calendar c = java.util.Calendar.getInstance();
	c.setTime(new java.util.Date());
	c.set(java.util.Calendar.DAY_OF_MONTH,1);
	datefrom.setSqlDate(new java.sql.Date(c.getTime().getTime()));
	dateto = new StringAndSqlDateProperty();
	dateto.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	isdivision = Boolean.FALSE;
	division = new StringAndIntegerProperty();
	divisionname = "";
	isowner = Boolean.FALSE;
	owner = new StringAndIntegerProperty();
	ownername = "";
	isworker = Boolean.TRUE;
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";
	isorganization = Boolean.TRUE;
	organization = new StringAndIntegerProperty();
	organizationname = "";
	type = "A";
	this.setFinderMethodName( "listRequestDocuments" );
	isposition = Boolean.FALSE;
	position = new StringAndIntegerProperty();
	positionname = "";
	positionid = "";
}
public java.lang.String getBrowseBeanName() {
//	return "com.hps.july.persistence.RequestAccessBean";
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @return java.lang.Integer
 */
public java.lang.Integer getCompany() {
	return company;
}
public java.sql.Date getDatefrom() {
	return datefrom.getSqlDate();
}
public String getDatefromstr() {
	return datefrom.getString();
}
public java.sql.Date getDateto() {
	return dateto.getSqlDate();
}
public String getDatetostr() {
	return dateto.getString();
}
public Integer getDivision() {
	return division.getInteger();
}
public String getDivisioncode() {
	return division.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getDivisionname() {
	return divisionname;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:27:37)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	String s = super.getFinderMethodName();
	try {
		sortType = Integer.valueOf(s);
	} catch (NumberFormatException e) {
	}
	return new Object[] {
		Boolean.TRUE, getDatefrom(), getDateto(),
		Boolean.TRUE.equals(isdivision)?Boolean.FALSE:Boolean.TRUE, (division.getInteger() == null)?new Integer(0):division.getInteger(),
		Boolean.TRUE.equals(isposition)?Boolean.FALSE:Boolean.TRUE, (position.getInteger() == null)?new Integer(0):position.getInteger(),
		type,
		Boolean.TRUE.equals(isorganization)?Boolean.FALSE:Boolean.TRUE, (organization.getInteger() == null)?new Integer(0):organization.getInteger(),
		Boolean.TRUE.equals(isworker)?Boolean.FALSE:Boolean.TRUE, (worker.getInteger() == null)?new Integer(0):worker.getInteger(),
		Boolean.FALSE,
		sortType
	};
}
public String getFinderMethodName() {
	return "listRequestDocuments";
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsdivision() {
	return isdivision;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsorganization() {
	return isorganization;
}
public java.lang.Boolean getIsowner() {
	return isowner;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsposition() {
	return isposition;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsworker() {
	return isworker;
}
public Integer getOrganization() {
	return organization.getInteger();
}
public String getOrganizationcode() {
	return organization.getString();
}
public java.lang.String getOrganizationname() {
	return organizationname;
}
public String getOwnercode() {
	return owner.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
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
public String getPositioncode() {
	return position.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
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
public String getType() {
	return type;
}
public Integer getWorker() {
	return worker.getInteger();
}
public String getWorkercode() {
	return worker.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
public ActionForward initBrowse(ActionMapping mapping, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	throws java.io.IOException, javax.servlet.ServletException
{
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.REQLIST);
	return super.initBrowse(mapping,request,response);
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @param newCompany java.lang.Integer
 */
public void setCompany(java.lang.Integer newCompany) {
	company = newCompany;
}
public void setDatefrom(java.sql.Date newDate) {
	datefrom.setSqlDate(newDate);
}
public void setDatefromstr(String newDate) {
	datefrom.setString(newDate);
}
public void setDateto(java.sql.Date newDate) {
	dateto.setSqlDate(newDate);
}
public void setDatetostr(String newDate) {
	dateto.setString(newDate);
}
public void setDivision(Integer newDivision) {
	division.setInteger(newDivision);
}
public void setDivisioncode(String newDivision) {
	division.setString(newDivision);
}
/**
 * 
 * @param newDivisionname java.lang.String
 */
public void setDivisionname(java.lang.String newDivisionname) {
	divisionname = newDivisionname;
}
/**
 * 
 * @param newIsdivision java.lang.Boolean
 */
public void setIsdivision(java.lang.Boolean newIsdivision) {
	isdivision = newIsdivision;
}
/**
 * 
 * @param newIsorganization java.lang.Boolean
 */
public void setIsorganization(java.lang.Boolean newIsorganization) {
	isorganization = newIsorganization;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @param newIsowner java.lang.Boolean
 */
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @param newIsposition java.lang.Boolean
 */
public void setIsposition(java.lang.Boolean newIsposition) {
	isposition = newIsposition;
}
/**
 * 
 * @param newIsworker java.lang.Boolean
 */
public void setIsworker(java.lang.Boolean newIsworker) {
	isworker = newIsworker;
}
public void setOrganizationcode(String newOrganization) {
	organization.setString(newOrganization);
}
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
public void setOwnercode(String newOwner) {
	owner.setString(newOwner);
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
public void setPositioncode(String newPosition) {
	position.setString(newPosition);
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (21.08.2002 18:18:30)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void setWorker(Integer newWorker) {
	worker.setInteger(newWorker);
}
public void setWorkercode(String newWorker) {
	worker.setString(newWorker);
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 11:13:51)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
public void validateValues(ActionErrors errors)
	throws Exception 
{
	ReqListForm aform = this;
	try {
		if(aform.getDivision() != null) {
			DivisionAccessBean bean = new DivisionAccessBean();
			bean.setInitKey_division(aform.getDivision().intValue());
			bean.refreshCopyHelper();
			aform.setDivisionname(bean.getName());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	try {
		if(aform.getPosition() != null) {
			PositionAccessBean bean = new PositionAccessBean();
			bean.setInitKey_storageplace(aform.getPosition().intValue());
			bean.refreshCopyHelper();
			aform.setPositionname(bean.getName());
			String positionid="";
			if(bean.getGsmid() != null) {
				positionid = "D"+bean.getGsmid()+" ";
			}
			if(bean.getDampsid() != null) {
				positionid += "A"+bean.getDampsid();
			}
			aform.setPositionid(positionid);
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	try {
		if(aform.getOrganization() != null) {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(aform.getOrganization().intValue());
			bean.refreshCopyHelper();
			aform.setOrganizationname(bean.getName());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
	try {
		if(aform.getWorker() != null) {
			WorkerAccessBean bean = new WorkerAccessBean();
			bean.setInitKey_worker(aform.getWorker().intValue());
			bean.refreshCopyHelper();
			aform.setWorkername(bean.getMan().getFullName());
			aform.setWorkertitle(bean.getPosition().getName());
		}
	} catch(Exception e) {
		e.printStackTrace(System.out);
	}
}
}
