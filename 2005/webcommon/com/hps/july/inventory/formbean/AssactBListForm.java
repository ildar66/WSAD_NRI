package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import java.util.*;

/**
 * Форма списка документов "Акты монтажа блоков на позиции"
 */
public class AssactBListForm
	extends com.hps.july.web.util.BrowseForm
{
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;
	private java.lang.Integer organization;
	private StringAndIntegerProperty position;
	private String positionid;
	private String positionname;
	private java.lang.Boolean isposition;
	private java.lang.Boolean isowner;
	private Integer sortType = new Integer(1);
public AssactBListForm() {
	setLastVisited(true);
	this.setFinderMethodName("listMountBlocksDocuments");
	startDate = new StringAndSqlDateProperty();
	GregorianCalendar calendar = new GregorianCalendar();
	calendar.setTime(new Date());
	endDate = new StringAndSqlDateProperty();
	endDate.setSqlDate(new java.sql.Date(calendar.getTime().getTime()));
	calendar.set(calendar.DAY_OF_MONTH, 1);
	startDate.setSqlDate(new java.sql.Date(calendar.getTime().getTime()));
	isposition = new Boolean(false);
	isowner = new Boolean(false);
	organization = new Integer(0);
	java.util.Enumeration eno = getOwners();
	position = new StringAndIntegerProperty();
	if (eno.hasMoreElements()) {
		try {
			OrganizationAccessBean org = (OrganizationAccessBean)eno.nextElement();
			organization = new Integer(org.getOrganization());
		} catch (Exception ex) {
		}
	}
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
//	return "com.hps.july.persistence.AssemblingActAccessBean";
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
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
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:56:36)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 14:36:59)
 * @return java.lang.String
 */
public java.lang.String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	String s = super.getFinderMethodName();
	try {
		sortType = Integer.valueOf(s);
	} catch (NumberFormatException e) {
	}
	
	return new Object[] {
		Boolean.TRUE, getStartDate(), getEndDate(), 
		new Boolean(!isowner.booleanValue()), (getOrganization() != null)?getOrganization():new Integer(0),
		new Boolean(!isposition.booleanValue()),(getPosition() != null)?getPosition():new Integer(0),
		sortType //new Integer(2)
	};
}
public String getFinderMethodName() {
	return "listMountBlocksDocuments";
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:33:35)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsowner() {
	return isowner;
}
public java.lang.Boolean getIsposition() {
	return isposition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:00:22)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrganization() {
	return organization;
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
public java.lang.Integer getPosition() {
	return position.getInteger();
}
public String getPositionFrm() {
	return position.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 12:19:37)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 12:19:37)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:56:36)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 14:36:28)
 * @return java.lang.String
 */
public java.lang.String getStartDateFrm() {
	return startDate.getString();
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
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:56:36)
 * @param newStartDate java.sql.Date
 */
public void setEndDate(java.sql.Date newStartDate) {
	endDate.setSqlDate(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 14:36:59)
 * @param newEndDateFrm java.lang.String
 */
public void setEndDateFrm(java.lang.String newEndDateFrm) {
	endDate.setString(newEndDateFrm);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:33:35)
 * @param newIsowner java.lang.Boolean
 */
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
}
public void setIsposition(java.lang.Boolean newIsposition) {
	isposition = newIsposition;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 12:00:22)
 * @param newOrganization java.lang.Integer
 */
public void setOrganization(java.lang.Integer newOrganization) {
	organization = newOrganization;
}
public void setPosition(java.lang.Integer newPosition) {
	System.out.println("%$%: setPosition:"+newPosition);
	position.setInteger(newPosition);
}
public void setPositionFrm(String newPosition) {
	System.out.println("%$%: setPositionFrm:"+newPosition);
	position.setString(newPosition);
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 12:19:37)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 12:19:37)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 11:56:36)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate.setSqlDate(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (24.07.2002 14:36:28)
 * @param newStartDateFrm java.lang.String
 */
public void setStartDateFrm(java.lang.String newStartDateFrm) {
	startDate.setString(newStartDateFrm);
}
}
