package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * Форма списка документов "Внешние приходные ордера"
 */
public class ExternalListForm
	extends BaseStorageListForm
{
	private StringAndIntegerProperty supplier;
	private String suppliername;
	private Boolean issupplier;
	private Boolean iscordocnum;
	private String cordocnum;
public ExternalListForm()
{
	super();
	supplier = new StringAndIntegerProperty();
	suppliername = "";
	issupplier = Boolean.TRUE;
	iscordocnum = Boolean.TRUE;
	setLastVisited(true);
	this.setFinderMethodName( "istExternalStorageInDocuments" );
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
//	return "com.hps.july.persistence.InwayBillAccessBean";
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getCordocnum() {
	return cordocnum;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:17:43)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return getFilterParams(Boolean.FALSE);
}
protected java.lang.Object[] getFilterParams(Boolean dacts) {
	return new Object[] {
		getIsstorage().booleanValue()?Boolean.FALSE:Boolean.TRUE,
		(getStorage().getInteger() != null)?getStorage().getInteger():new Integer(0),
		getDatefrom(), getDateto(),
		getIscordocnum().booleanValue()?Boolean.FALSE:Boolean.TRUE,(cordocnum != null)?cordocnum:"",
		getIsowner().booleanValue()?Boolean.FALSE:Boolean.TRUE,
		(getOwner().getInteger() != null)?getOwner().getInteger():new Integer(0),
		getIssupplier().booleanValue()?Boolean.FALSE:Boolean.TRUE,
		(supplier.getInteger() != null)?supplier.getInteger():new Integer(0),
		dacts,
		get_isadmin(),(get_username() == null)?"":get_username(),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listExternalStorageInDocuments";
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIscordocnum() {
	return iscordocnum;
}
public java.lang.Boolean getIssupplier() {
	return issupplier;
}
public Integer getSupplier() {
	return supplier.getInteger();
}
public String getSuppliercode() {
	return supplier.getString();
}
public java.lang.String getSuppliername() {
	return suppliername;
}
public java.util.Enumeration getYears() {
	java.util.Calendar c = java.util.Calendar.getInstance();
	c.setTime(new java.util.Date());
	java.util.Vector v = new java.util.Vector(20);
	for(int i = -4; i < 5; i++) {
		v.add(""+(i+c.get(java.util.Calendar.YEAR)));
		v.add(""+(i+c.get(java.util.Calendar.YEAR)));
	}
	return v.elements();
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.EOLIST);
	if(getSupplier() != null) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(getSupplier().intValue());
			bean.refreshCopyHelper();
			setSuppliername(bean.getName());
		} catch(Exception e) {
		}
	}
	return super.initBrowse(mapping,request,response);
}
/**
 * 
 * @param newCordocnum java.lang.String
 */
public void setCordocnum(java.lang.String newCordocnum) {
	cordocnum = newCordocnum;
}
/**
 * 
 * @param newIscordocnum java.lang.Boolean
 */
public void setIscordocnum(java.lang.Boolean newIscordocnum) {
	iscordocnum = newIscordocnum;
}
public void setIssupplier(java.lang.Boolean newIssupplier) {
	issupplier = newIssupplier;
}
public void setSuppliercode(String newSupplier) {
	supplier.setString(newSupplier);
}
public void setSuppliername(java.lang.String newSuppliername) {
	suppliername = newSuppliername;
}
}
