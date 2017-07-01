package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.math.*;
/**
 * Bean-form
 * Форма "Ставки платежей"(лист).
 * Creation date: (09.01.2003 16:07:25)
 * @author: Sergey Gourov
 */
public class PaymentRatesListForm extends com.hps.july.web.util.BrowseForm {
	private int docpositioncode;
	private java.lang.String documentNumber;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private BigDecimal currency1;
	private BigDecimal currency2;
	private java.lang.String curr1;
	private java.lang.String curr2;
	private java.math.BigDecimal sumrub;
	private java.math.BigDecimal sum;
	private java.lang.String paycurrency;
	private java.math.BigDecimal payrate;
	private java.lang.String paymentState;

	private boolean usedinact;
/**
 * PaymentRatesListForm constructor comment.
 */
public PaymentRatesListForm() {
	super();
	setFinderMethodName("findLeaseCalcRatesByDocposition");
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @return BigDecimal
 */
public BigDecimal getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @return BigDecimal
 */
public BigDecimal getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:28:57)
 * @return int
 */
public int getDocpositioncode() {
	return docpositioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
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
 * Creation date: (09.01.2003 16:48:54)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:07:25)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new LeaseDocPositionKey(getDocpositioncode()) };
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 18:10:57)
 * @return java.lang.String
 */
public java.lang.String getPaycurrency() {
	return paycurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2003 15:02:41)
 * @return java.lang.String
 */
public java.lang.String getPaymentState() {
	return paymentState;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 18:11:27)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPayrate() {
	return payrate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 18:09:55)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return sum;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 18:08:19)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumrub() {
	return sumrub;
}
/**
 * 
 * @return boolean
 */
public boolean isUsedinact() {
	return usedinact;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newCurrency1 BigDecimal
 */
public void setCurrency1(BigDecimal newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newCurrency2 BigDecimal
 */
public void setCurrency2(BigDecimal newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:28:57)
 * @param newDocpositioncode int
 */
public void setDocpositioncode(int newDocpositioncode) {
	docpositioncode = newDocpositioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 18:10:57)
 * @param newPaycurrency java.lang.String
 */
public void setPaycurrency(java.lang.String newPaycurrency) {
	paycurrency = newPaycurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (18.01.2003 15:02:41)
 * @param newPaymentState java.lang.String
 */
public void setPaymentState(java.lang.String newPaymentState) {
	paymentState = newPaymentState;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 18:11:27)
 * @param newPayrate java.math.BigDecimal
 */
public void setPayrate(java.math.BigDecimal newPayrate) {
	payrate = newPayrate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:48:54)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate = newStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 18:09:55)
 * @param newSum java.math.BigDecimal
 */
public void setSum(java.math.BigDecimal newSum) {
	sum = newSum;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 18:08:19)
 * @param newSumrub java.math.BigDecimal
 */
public void setSumrub(java.math.BigDecimal newSumrub) {
	sumrub = newSumrub;
}
/**
 * 
 * @param newUsedinact boolean
 */
public void setUsedinact(boolean newUsedinact) {
	usedinact = newUsedinact;
}
}
