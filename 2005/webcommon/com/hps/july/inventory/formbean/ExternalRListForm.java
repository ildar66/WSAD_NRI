package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка документов "Внешние расходные накладные"
 */
public class ExternalRListForm
	extends BaseStorageListForm
{
	private StringAndIntegerProperty recipient;
	private String recipientname;
	private Boolean isrecipient;
public ExternalRListForm()
{
	super();
	recipient = new StringAndIntegerProperty();
	recipientname = "";
	isrecipient = Boolean.TRUE;
	this.setFinderMethodName( "listExternalStorageOutDocuments" );
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:26:22)
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
		Boolean.TRUE.equals(isrecipient)?Boolean.FALSE:Boolean.TRUE, (recipient.getInteger() == null)?new Integer(0):recipient.getInteger(),
		get_isadmin(), (get_username() != null?get_username():""),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listExternalStorageOutDocuments";
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 13:35:50)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsrecipient() {
	return isrecipient;
}
public Integer getRecipient() {
	return recipient.getInteger();
}
public String getRecipientcode() {
	return recipient.getString();
}
public java.lang.String getRecipientname() {
	return recipientname;
}
public ActionForward initBrowse(ActionMapping mapping, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
	throws java.io.IOException, javax.servlet.ServletException
{
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.EORLIST);
	if(getRecipient() != null) {
		try {
			OrganizationAccessBean bean = new OrganizationAccessBean();
			bean.setInitKey_organization(getRecipient().intValue());
			bean.refreshCopyHelper();
			setRecipientname(bean.getName());
		} catch(Exception e) {
//			e.printStackTrace(System.out);
		}
	}
	return super.initBrowse(mapping,request,response);
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 13:35:50)
 * @param newIsrecipient java.lang.Boolean
 */
public void setIsrecipient(java.lang.Boolean newIsrecipient) {
	isrecipient = newIsrecipient;
}
public void setRecipientcode(String newRecipient) {
	recipient.setString(newRecipient);
}
public void setRecipientname(java.lang.String newRecipientname) {
	recipientname = newRecipientname;
}
}
