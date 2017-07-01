package com.hps.july.arenda.formbean;

import java.sql.Date;
import java.math.*;
/**
 * Bean-form
 * Форма "сальдо"(лист).
 * Creation date: (23.12.2002 10:29:49)
 * @author: Sergey Gourov
 */
public class SaldoListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseContract;
	private java.lang.String documentNumber;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private BigDecimal currency1;
	private BigDecimal currency2;
	private java.lang.String curr1;
	private java.lang.String curr2;
/**
 * SaldoListForm constructor comment.
 */
public SaldoListForm() {
	super();
	setFinderMethodName("findByQBE");
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @return BigDecimal
 */
public BigDecimal getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @return BigDecimal
 */
public BigDecimal getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:06:50)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
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
 * Creation date: (23.12.2002 11:09:07)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 10:29:49)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(getLeaseContract()), new Boolean(false), new Date(0), new Date(0), new Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 10:44:56)
 * @return int
 */
public int getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:08:22)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @param newCurrency1 BigDecimal
 */
public void setCurrency1(BigDecimal newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @param newCurrency2 BigDecimal
 */
public void setCurrency2(BigDecimal newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:06:50)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:09:07)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 10:44:56)
 * @param newLeaseContract int
 */
public void setLeaseContract(int newLeaseContract) {
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:11:13)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (23.12.2002 11:08:22)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate = newStartDate;
}
}
