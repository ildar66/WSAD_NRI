package com.hps.july.arenda.formbean;

import java.math.*;
/**
 * Bean-form
 * Форма "Правила платежа(лист)".
 * Creation date: (05.07.2002 11:18:01)
 * @author: Sergey Gourov
 */
public class PayRulesListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseDocument;
	private java.lang.String documentNumber;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private BigDecimal currency1;
	private BigDecimal currency2;
	private int orgExecutorcode;
	private java.lang.String curr1;
	private java.lang.Integer currencyCode1;
	private java.lang.String curr2;
	private java.lang.String stateOfContract;
	private java.lang.String rateCalcRule;
	private java.lang.Short rateCalcRuleDay;
	private java.math.BigDecimal rateDelta;
/**
 * PayRulesListForm constructor comment.
 */
public PayRulesListForm() {
	super();
	setFinderMethodName("findByLeaseDocument");
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:15:42)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:15:42)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:20:50)
 * @return com.ibm.math.BigDecimal
 */
public BigDecimal getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:21:05)
 * @return com.ibm.math.BigDecimal
 */
public BigDecimal getCurrency2() {
	return currency2;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrencyCode1() {
	return currencyCode1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:03:30)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.10.2002 16:41:54)
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
 * Creation date: (05.07.2002 12:05:43)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 11:18:01)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Integer(getLeaseDocument()), new Boolean(false), new Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 11:45:30)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:06:03)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:06:19)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:51:11)
 * @return int
 */
public int getOrgExecutorcode() {
	return orgExecutorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2002 18:04:55)
 * @return java.lang.String
 */
public java.lang.String getRateCalcRule() {
	return rateCalcRule;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2002 18:05:53)
 * @return java.lang.Short
 */
public java.lang.Short getRateCalcRuleDay() {
	return rateCalcRuleDay;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2002 18:06:23)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRateDelta() {
	return rateDelta;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:05:28)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 11:15:00)
 * @return java.lang.String
 */
public java.lang.String getStateOfContract() {
	return stateOfContract;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:15:42)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:15:42)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:20:50)
 * @param newCurrency1 com.ibm.math.BigDecimal
 */
public void setCurrency1(BigDecimal newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:21:05)
 * @param newCurrency2 com.ibm.math.BigDecimal
 */
public void setCurrency2(BigDecimal newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * 
 * @param newCurrencyCode1 java.lang.Integer
 */
public void setCurrencyCode1(java.lang.Integer newCurrencyCode1) {
	currencyCode1 = newCurrencyCode1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:03:30)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:05:43)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 11:45:30)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:06:03)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:06:19)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 17:51:11)
 * @param newOrgExecutorcode int
 */
public void setOrgExecutorcode(int newOrgExecutorcode) {
	orgExecutorcode = newOrgExecutorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2002 18:04:55)
 * @param newRateCalcRule java.lang.String
 */
public void setRateCalcRule(java.lang.String newRateCalcRule) {
	rateCalcRule = newRateCalcRule;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2002 18:05:53)
 * @param newRateCalcRuleDay java.lang.Short
 */
public void setRateCalcRuleDay(java.lang.Short newRateCalcRuleDay) {
	rateCalcRuleDay = newRateCalcRuleDay;
}
/**
 * Insert the method's description here.
 * Creation date: (29.11.2002 18:06:23)
 * @param newRatedelta java.math.BigDecimal
 */
public void setRateDelta(java.math.BigDecimal newRateDelta) {
	rateDelta = newRateDelta;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:05:28)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate = newStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (14.10.2002 11:15:00)
 * @param newStateOfContract java.lang.String
 */
public void setStateOfContract(java.lang.String newStateOfContract) {
	stateOfContract = newStateOfContract;
}
}
