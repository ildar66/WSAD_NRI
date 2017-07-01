package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка документов "Fault Report"
 */
public class FaultListForm extends com.hps.july.web.util.BrowseForm {
	private Boolean isdate;
	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	
	private Boolean isowner;
	private StringAndIntegerProperty owner;
	private String ownername;
	
	private Boolean isdivision;
	private StringAndIntegerProperty division;
	private String divisionname;
	
	private Boolean isworker;
	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private Boolean isposition;
	private StringAndIntegerProperty position;
	private String positionname;
	private String positionid;

	private Boolean isresource;
	private StringAndIntegerProperty resource;
	private String resourcename;
	private String resourcemodel;
	private Integer sortType = new Integer(1);
public FaultListForm() {
	setLastVisited(true);
	datefrom = new StringAndSqlDateProperty();
	java.util.Calendar c = java.util.Calendar.getInstance();
	c.setTime(new java.util.Date());
	c.set(java.util.Calendar.DAY_OF_MONTH,1);
	datefrom.setSqlDate(new java.sql.Date(c.getTime().getTime()));
	dateto = new StringAndSqlDateProperty();
	dateto.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	
	isowner = Boolean.FALSE;
	owner = new StringAndIntegerProperty();
	ownername = "";
	try {
		java.util.Enumeration eno = getOwners();
		if (eno.hasMoreElements()) {
			try {
				OrganizationAccessBean org = (OrganizationAccessBean)eno.nextElement();
				owner.setInteger(new Integer(org.getOrganization()));
				ownername = org.getName();
			} catch (Exception ex) {
			}
		}
	} catch(Exception e) {
	}

	isdivision = Boolean.FALSE;
	division = new StringAndIntegerProperty();
	divisionname = "";

	isworker = Boolean.TRUE;
	worker = new StringAndIntegerProperty();
	workername = "";
	workertitle = "";

	isposition = Boolean.FALSE;
	position = new StringAndIntegerProperty();
	positionname = "";
	positionid = "";
	
	isresource = Boolean.TRUE;
	resource = new StringAndIntegerProperty();
	resourcename = "";
	resourcemodel = "";

	this.setFinderMethodName( "findByQBE" );

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
 * Creation date: (10.09.2002 11:49:14)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("TechStuff");
	roles.add("siteExploitor");
	roles.add("siteStation");
	roles.add("siteTransport");
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
		Boolean.TRUE.equals(isowner)?Boolean.FALSE:Boolean.TRUE, (owner.getInteger() == null)?new Integer(0):owner.getInteger(),
		Boolean.TRUE.equals(isdivision)?Boolean.FALSE:Boolean.TRUE, (division.getInteger() == null)?new Integer(0):division.getInteger(),
		Boolean.TRUE.equals(isworker)?Boolean.FALSE:Boolean.TRUE, (worker.getInteger() == null)?new Integer(0):worker.getInteger(),
//		Boolean.TRUE.equals(isposition)?Boolean.FALSE:Boolean.TRUE, (position.getInteger() == null)?new Integer(0):position.getInteger(),
		Boolean.FALSE, new Integer(0),
		Boolean.TRUE.equals(isresource)?Boolean.FALSE:Boolean.TRUE, (resource.getInteger() == null)?new Integer(0):resource.getInteger(),
		sortType
	};
}
public String getFinderMethodName() {
	return "findByQBE";
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsdate() {
	return isdate;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsdivision() {
	return isdivision;
}
public java.lang.Boolean getIsowner() {
	return isowner;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsposition() {
	return isposition;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsresource() {
	return isresource;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsworker() {
	return isworker;
}
public String getOwnercode() {
	return owner.getString();
}
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 16:12:47)
 * @return java.util.Enumeration
 */
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
public Integer getResource() {
	return resource.getInteger();
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
public Integer getWroker() {
	return worker.getInteger();
}
public String getWrokercode() {
	return worker.getString();
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
 * @param newIsdate java.lang.Boolean
 */
public void setIsdate(java.lang.Boolean newIsdate) {
	isdate = newIsdate;
}
/**
 * 
 * @param newIsdivision java.lang.Boolean
 */
public void setIsdivision(java.lang.Boolean newIsdivision) {
	isdivision = newIsdivision;
}
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
}
/**
 * 
 * @param newIsposition java.lang.Boolean
 */
public void setIsposition(java.lang.Boolean newIsposition) {
	isposition = newIsposition;
}
/**
 * 
 * @param newIsresource java.lang.Boolean
 */
public void setIsresource(java.lang.Boolean newIsresource) {
	isresource = newIsresource;
}
/**
 * 
 * @param newIsworker java.lang.Boolean
 */
public void setIsworker(java.lang.Boolean newIsworker) {
	isworker = newIsworker;
}
public void setOwnercode(String newOwner) {
	owner.setString(newOwner);
}
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
public void setPosition(Integer newPosition) {
	position.setInteger(newPosition);
}
public void setPositioncode(String newPosition) {
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
public void setResource(Integer newResource) {
	resource.setInteger(newResource);
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
}
