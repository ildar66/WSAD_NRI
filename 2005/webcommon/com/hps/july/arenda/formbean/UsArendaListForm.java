package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
/**
 * Bean-form
 * Форма"у нас арендуют"(лист).
 * Creation date: (02.07.2002 15:42:33)
 * @author: Sergey Gourov
 */
public class UsArendaListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Boolean isCustomer;
	private java.lang.Boolean isExecutor;
	private java.lang.Integer customercode;
	private java.lang.String customername;
	private java.lang.Integer executorcode;
	private java.lang.String executorname;
	private java.lang.Boolean isEconomist;
	private java.lang.Integer economistcode;
	private java.lang.String economistname;
	private java.lang.Boolean isDocnumber;
	private java.lang.String docnumber;
/**
 * UsArendaListForm constructor comment.
 */
public UsArendaListForm() {
	super();
	setFinderMethodName("findByQBE");

	setIsCustomer(new Boolean(true));
	setCustomercode(new Integer(0));
	setCustomername("");

	setIsExecutor(new Boolean(true));
	setExecutorcode(new Integer(0));
	setExecutorname("");

	setIsEconomist(new Boolean(true));
	setEconomistcode(new Integer(0));
	setEconomistname("");

	setIsDocnumber(new Boolean(false));
	setDocnumber("");
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:52:52)
 * @return java.lang.Integer
 */
public java.lang.Integer getCustomercode() {
	return customercode;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:53:32)
 * @return java.lang.String
 */
public java.lang.String getCustomername() {
	return customername;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 16:00:52)
 * @return java.lang.String
 */
public java.lang.String getDocnumber() {
	return docnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:58:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getEconomistcode() {
	return economistcode;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:59:05)
 * @return java.lang.String
 */
public java.lang.String getEconomistname() {
	return economistname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("ArendaMainEconomist");
	roles.add("ArendaEconomist");
	roles.add("administrator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:54:17)
 * @return java.lang.Integer
 */
public java.lang.Integer getExecutorcode() {
	return executorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:54:35)
 * @return java.lang.String
 */
public java.lang.String getExecutorname() {
	return executorname;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:06:43)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getExecutors() {
	try {
		return new OrganizationAccessBean().findOurOrganizations();
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:42:33)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {

	/*String contractType,
	java.lang.Boolean isOrgCustomer, 		java.lang.Integer orgCustomer, 
	java.lang.Boolean isOrgExecutor, 		java.lang.Integer orgExecutor, 
	java.lang.Boolean isMainEconomist, 		java.lang.Integer mainEconomist, 
	java.lang.Boolean isDocNumber, 			java.lang.String docNumber, 
	java.lang.Integer order */
	
	return new Object[] { "B",
		getIsCustomer().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getCustomercode(),
		getIsExecutor().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getExecutorcode(),
		getIsEconomist().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getEconomistcode(),
		getIsDocnumber().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getDocnumber(),
		new Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:51:15)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsCustomer() {
	return isCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 16:00:22)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDocnumber() {
	return isDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:58:15)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsEconomist() {
	return isEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:51:45)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsExecutor() {
	return isExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:52:52)
 * @param newCustomercode java.lang.Integer
 */
public void setCustomercode(java.lang.Integer newCustomercode) {
	customercode = newCustomercode;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:53:32)
 * @param newCustomername java.lang.String
 */
public void setCustomername(java.lang.String newCustomername) {
	customername = newCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 16:00:52)
 * @param newDocnumber java.lang.String
 */
public void setDocnumber(java.lang.String newDocnumber) {
	docnumber = newDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:58:42)
 * @param newMaineconomistcode java.lang.Integer
 */
public void setEconomistcode(java.lang.Integer newEconomistcode) {
	economistcode = newEconomistcode;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:59:05)
 * @param newMaineconomistname java.lang.String
 */
public void setEconomistname(java.lang.String newEconomistname) {
	economistname = newEconomistname;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:54:17)
 * @param newExecutorcode java.lang.Integer
 */
public void setExecutorcode(java.lang.Integer newExecutorcode) {
	executorcode = newExecutorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:54:35)
 * @param newExecutorname java.lang.String
 */
public void setExecutorname(java.lang.String newExecutorname) {
	executorname = newExecutorname;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:51:15)
 * @param newIsCustomer java.lang.Boolean
 */
public void setIsCustomer(java.lang.Boolean newIsCustomer) {
	isCustomer = newIsCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 16:00:22)
 * @param newIsDocnumber java.lang.Boolean
 */
public void setIsDocnumber(java.lang.Boolean newIsDocnumber) {
	isDocnumber = newIsDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:58:15)
 * @param newIsMaineconomist java.lang.Boolean
 */
public void setIsEconomist(java.lang.Boolean newIsEconomist) {
	isEconomist = newIsEconomist;
}
/**
 * Insert the method's description here.
 * Creation date: (02.07.2002 15:51:45)
 * @param newIsExecutor java.lang.Boolean
 */
public void setIsExecutor(java.lang.Boolean newIsExecutor) {
	isExecutor = newIsExecutor;
}
}
