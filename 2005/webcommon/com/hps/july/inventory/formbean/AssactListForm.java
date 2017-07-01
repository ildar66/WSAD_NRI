package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import java.util.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Форма списка документов "Акт монтажа блоков на складе"
 */
public class AssactListForm
	extends BaseStorageListForm
{
public AssactListForm() {
	this.setFinderMethodName("4");
/*
	startDate = new StringAndSqlDateProperty();
	GregorianCalendar calendar = new GregorianCalendar();
	calendar.setTime(new Date());
	endDate = new StringAndSqlDateProperty();
	endDate.setSqlDate(new java.sql.Date(calendar.getTime().getTime()));
	calendar.set(calendar.DAY_OF_MONTH, 1);
	startDate.setSqlDate(new java.sql.Date(calendar.getTime().getTime()));
	isstorage = new Boolean(false);
	isowner = new Boolean(false);
	organization = new Integer(0);
	java.util.Enumeration eno = getOwners();
	if (eno.hasMoreElements()) {
		try {
			OrganizationAccessBean org = (OrganizationAccessBean)eno.nextElement();
			organization = new Integer(org.getOrganization());
		} catch (Exception ex) {
		}
	}
	
	java.util.Enumeration en = getStorages();
	storage = new Integer(0);
	if (en.hasMoreElements()) {
		try {
			StorageAccessBean stor = (StorageAccessBean)en.nextElement();
			storage = new Integer(stor.getStorageplace());
		} catch (Exception ex) {
		}
	}
*/
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		Boolean.TRUE, getDatefrom(), getDateto(), 
		getIsowner().booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, getOwner().getInteger()!=null?getOwner().getInteger():new Integer(0),
		getIsstorage().booleanValue()?java.lang.Boolean.FALSE:java.lang.Boolean.TRUE, getStorage().getInteger()!=null?getStorage().getInteger():new Integer(0) ,
		get_isadmin(), (get_username() != null)?get_username():"",
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listStorageMountDocuments";
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	ParamsParser.setState( request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.ASSLIST );
	return super.initBrowse(mapping,request,response);
}
}
