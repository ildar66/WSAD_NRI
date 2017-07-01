package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Форма списка документов "Акты списания"
 */
public class PayoffListForm
	extends BaseStorageListForm
{
public PayoffListForm() {
	this.setFinderMethodName("4");
/*
	datefrom = new StringAndSqlDateProperty();
	java.util.Calendar c = java.util.Calendar.getInstance();
	c.setTime(new java.util.Date());
	c.set(java.util.Calendar.DAY_OF_MONTH,1);
	datefrom.setSqlDate(new java.sql.Date(c.getTime().getTime()));
	dateto = new StringAndSqlDateProperty();
	dateto.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	isowner = Boolean.FALSE;
	isstorage = Boolean.FALSE;
	storage = new StringAndIntegerProperty();
	storagename = "";
	owner = new StringAndIntegerProperty();
	ownername = "";
	this.setFinderMethodName( "findDocumentByQBE" );
	try {
		java.util.Enumeration eno = getOwners();
		if (eno.hasMoreElements()) {
			try {
				OrganizationAccessBean org = (OrganizationAccessBean)eno.nextElement();
				owner.setInteger(new Integer(org.getOrganization()));
			} catch (Exception ex) {
			}
		}
	} catch(Exception e) {
	}

	try {	
		java.util.Enumeration en = getStorages();
		if (en.hasMoreElements()) {
			try {
				StorageAccessBean stor = (StorageAccessBean)en.nextElement();
				storage.setInteger(new Integer(stor.getStorageplace()));
			} catch (Exception ex) {
			}
		}
	} catch(Exception e) {
	}
*/
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:28:00)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { 
		Boolean.TRUE, getDatefrom(), getDateto(),
		Boolean.TRUE.equals(getIsowner())?Boolean.FALSE:Boolean.TRUE, (getOwner().getInteger() == null)?new Integer(0):getOwner().getInteger(),
		Boolean.TRUE.equals(getIsstorage())?Boolean.FALSE:Boolean.TRUE, (getStorage().getInteger() == null)?new Integer(0):getStorage().getInteger(),
		get_isadmin(), get_username(),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listStoragePayoffDocuments";
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	ActionForward afw = super.initBrowse(mapping,request,response);
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.POLIST);
	return afw;
}
}
