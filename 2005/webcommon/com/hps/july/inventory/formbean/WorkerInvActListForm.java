package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка документов "Акты инвентаризации у сотрудника/подрядчика"
 */
public class WorkerInvActListForm
	extends BrowseForm
{
	private StringAndSqlDateProperty datefrom = new StringAndSqlDateProperty();
	private StringAndSqlDateProperty dateto = new StringAndSqlDateProperty();
	private java.lang.Integer owner;
//	private java.lang.String ownername;
//	private java.lang.Integer place;
//	private java.lang.Integer placename;
//	private java.lang.Boolean showallowner;
//	private java.lang.Boolean showallstorage;
	private java.lang.Integer order;
	private Integer sortType = new Integer(1);
	private java.lang.Boolean isowner;
	private java.lang.Boolean isexpedition;
	private java.lang.String expedtype;
	private StringAndIntegerProperty workercode = new StringAndIntegerProperty();
	private java.lang.String workername;
	private StringAndIntegerProperty orgcode = new StringAndIntegerProperty();
	private java.lang.String orgname;
public WorkerInvActListForm() {
	super();
	expedtype = "W";
	isowner = Boolean.FALSE;
	datefrom.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	dateto.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	setFinderMethodName( "4" );
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
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
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:44:34)
 * @return java.lang.String
 */
public java.lang.String getExpedtype() {
	return expedtype;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		getDatefrom(), getDateto(),
		getIsowner().booleanValue()?Boolean.FALSE:Boolean.TRUE, getOwnercode() != null?getOwnercode():new Integer(0),
		"W".equals(getExpedtype())?Boolean.TRUE:Boolean.FALSE, workercode.isOk()&&!workercode.isEmpty()?workercode.getInteger():new Integer(0),
		"O".equals(getExpedtype())?Boolean.TRUE:Boolean.FALSE, orgcode.isOk()&&!orgcode.isEmpty()?orgcode.getInteger():new Integer(0),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listExpeditionInventoryDocuments";
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 16:43:05)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsexpedition() {
	return isexpedition;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 16:42:46)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsowner() {
	return isowner;
}
public Integer getOrderBy() {
	if(sortType == null) {
		sortType = new Integer(1);
	}
	return sortType;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:46:48)
 * @return java.lang.String
 */
public java.lang.String getOrgcode() {
	return orgcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:47:03)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 16:43:27)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwnercode() {
	return owner;
}
/**
 * Получение списка организаций-владельцев.
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
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:46:14)
 * @return java.lang.String
 */
public java.lang.String getWorkercode() {
	return workercode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:46:30)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
public ActionForward initBrowse(ActionMapping mapping, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	throws java.io.IOException, javax.servlet.ServletException
{
	ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.WRKINVLIST);
	return super.initBrowse(mapping,request,response);
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
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:44:34)
 * @param newExpedtype java.lang.String
 */
public void setExpedtype(java.lang.String newExpedtype) {
	expedtype = newExpedtype;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 16:43:05)
 * @param newIsexpedition java.lang.Boolean
 */
public void setIsexpedition(java.lang.Boolean newIsexpedition) {
	isexpedition = newIsexpedition;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 16:42:46)
 * @param newIsowner java.lang.Boolean
 */
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:46:48)
 * @param newOrgcode java.lang.String
 */
public void setOrgcode(java.lang.String newOrgcode) {
	orgcode.setString(newOrgcode);
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:47:03)
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 16:43:27)
 * @param newOwner java.lang.Integer
 */
public void setOwnercode(java.lang.Integer newOwner) {
	owner = newOwner;
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:46:14)
 * @param newWorkercode java.lang.String
 */
public void setWorkercode(java.lang.String newWorkercode) {
	workercode.setString(newWorkercode);
}
/**
 * Insert the method's description here.
 * Creation date: (02.06.2005 18:46:30)
 * @param newWorkername java.lang.String
 */
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
}
