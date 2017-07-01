package com.hps.july.arenda.formbean;

import java.text.*;
import java.util.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
/**
 * Form-Bean "редактирования абонента"
 */
public class AbonentEditForm extends com.hps.july.web.util.EditForm {
	private int leaseDocument;
	private java.lang.String documentNumber;
	private java.lang.String bil_inn;
	private java.lang.String bil_name;
	private com.hps.july.persistence.OrganizationAccessBean orgCustomer;
	private java.lang.String orgCustomername;
	private java.lang.String orgCustomerInn;
	private java.lang.String bil_acctypename;
	private java.lang.String bil_contrstname;
	private java.sql.Date bil_contrstdate;
	private StringAndSqlDateProperty documentDate;
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty bil_suspdate;
	private java.lang.String bil_billaddress;
/**
 * Insert the method's description here.
 * Creation date: (07.10.2002 10:59:40)
 */
public AbonentEditForm() {
	documentDate = new StringAndSqlDateProperty();
	startDate = new StringAndSqlDateProperty();
	bil_suspdate = new StringAndSqlDateProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:32:20)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:32:20)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:50:17)
 * @return java.lang.String
 */
public java.lang.String getBil_acctypename() {
	return bil_acctypename;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:02:58)
 * @return java.lang.String
 */
public java.lang.String getBil_billaddress() {
	return bil_billaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:58:06)
 * @return int
 */
public java.sql.Date getBil_contrstdate() {
	return bil_contrstdate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:58:06)
 * @return int
 */
public java.sql.Date getBil_contrstdateFrm() {
	return getBil_contrstdate();
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 14:53:00)
 * @return java.lang.String
 */
public java.lang.String getBil_contrstname() {
	return bil_contrstname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:39:18)
 * @return java.lang.String
 */
public java.lang.String getBil_inn() {
	return bil_inn;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:41:09)
 * @return java.lang.String
 */
public java.lang.String getBil_name() {
	return bil_name;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:02:24)
 * @return java.sql.Date
 */
public java.sql.Date getBil_suspdate() {
	return bil_suspdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:02:24)
 * @return java.sql.Date
 */
public String getBil_suspdateFrm() {
	return bil_suspdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:32:20)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseAbonentBANAccessBean bean = new LeaseAbonentBANAccessBean();
	bean.setInitKey_leaseDocument(getLeaseDocument());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:59:23)
 * @return java.sql.Date
 */
public java.sql.Date getDocumentDate() {
	return documentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:59:23)
 * @return java.sql.Date
 */
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:38:26)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:35:30)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:42:41)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public Organization getOrgCustomer() throws Exception {
	/*OrganizationAccessBean bean = constructCustomer();
	if (bean != null) {
		return (Organization) bean.getEJBRef();
	} else {*/
		return null;
	//}
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:48:30)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomerInn() {
	return orgCustomerInn;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:45:47)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomername() {
	return orgCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:00:07)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:00:07)
 * @return java.sql.Date
 */
public String getStartDateFrm() {
	return startDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:32:20)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ABONENT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	if (getAction().equals("View")) {
		Enumeration e = new LeaseAbonentPhoneAccessBean().findByLeaseDocumentOrderByPhoneNumberAsc(new Integer(getLeaseDocument()));
		if (e.hasMoreElements()) {
			request.setAttribute("abonentphonesList", e);
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:50:17)
 * @param newBil_acctypename java.lang.String
 */
public void setBil_acctypename(java.lang.String newBil_acctypename) {
	bil_acctypename = newBil_acctypename;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:02:58)
 * @param newBil_billaddress java.lang.String
 */
public void setBil_billaddress(java.lang.String newBil_billaddress) {
	bil_billaddress = newBil_billaddress;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:58:06)
 * @param newBil_contrstdate int
 */
public void setBil_contrstdate(java.sql.Date newBil_contrstdate) {
	bil_contrstdate = newBil_contrstdate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 14:53:00)
 * @param newBil_contrstname java.lang.String
 */
public void setBil_contrstname(java.lang.String newBil_contrstname) {
	bil_contrstname = newBil_contrstname;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:39:18)
 * @param newBil_inn java.lang.String
 */
public void setBil_inn(java.lang.String newBil_inn) {
	bil_inn = newBil_inn;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:41:09)
 * @param newBil_name java.lang.String
 */
public void setBil_name(java.lang.String newBil_name) {
	bil_name = newBil_name;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:02:24)
 * @param newBil_suspdate java.sql.Date
 */
public void setBil_suspdate(java.sql.Date newBil_suspdate) {
	bil_suspdate.setSqlDate(newBil_suspdate);
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:02:24)
 * @param newBil_suspdate java.sql.Date
 */
public void setBil_suspdateFrm(String newBil_suspdate) {
	bil_suspdate.setString(newBil_suspdate);
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:59:23)
 * @param newDocumentDate java.sql.Date
 */
public void setDocumentDate(java.sql.Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:59:23)
 * @param newDocumentDate java.sql.Date
 */
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:38:26)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:35:30)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:42:41)
 * @param newOrgCustomer com.hps.july.persistence.OrganizationAccessBean
 */
public void setOrgCustomer(com.hps.july.persistence.OrganizationAccessBean newOrgCustomer) throws Exception {
	if (newOrgCustomer == null) {
		orgCustomername = "";
		orgCustomerInn = "";
	} else {
		orgCustomername = newOrgCustomer.getName();
		orgCustomerInn = newOrgCustomer.getInn();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:48:30)
 * @param newOrgCustomerInn java.lang.String
 */
public void setOrgCustomerInn(java.lang.String newOrgCustomerInn) {
	orgCustomerInn = newOrgCustomerInn;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 11:45:47)
 * @param newOrgCustomername java.lang.String
 */
public void setOrgCustomername(java.lang.String newOrgCustomername) {
	orgCustomername = newOrgCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:00:07)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate.setSqlDate(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (04.10.2002 12:00:07)
 * @param newStartDate java.sql.Date
 */
public void setStartDateFrm(String newStartDate) {
	startDate.setString(newStartDate);
}
}
