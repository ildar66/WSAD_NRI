package com.hps.july.arenda.formbean;

import java.math.*;
/**
 * лист "Оплаты начислений"
 * Form-Bean.
 * Creation date: (24.01.2003 14:33:24)
 * @author: Sergey Gourov
 */
public class ChargeDnopListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseDocPosition;
	private java.lang.String documentNumber;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private java.math.BigDecimal currency1;
	private java.math.BigDecimal currency2;
	private java.lang.String curr1;
	private java.lang.String curr2;
	private java.sql.Date chargedate;
	private java.sql.Date chargeBeginDate;
	private java.sql.Date chargeEndDate;
	private java.lang.String resourcename;
	private java.math.BigDecimal sum;
	private java.lang.String chargecurrency;
	private java.math.BigDecimal notremaindersum;
	private java.math.BigDecimal remaindersum;
	private java.math.BigDecimal remainderratetorur;
/**
 * ChargeDnopListForm constructor comment.
 */
public ChargeDnopListForm() {
	super();
	setFinderMethodName("findLeaseDNOPByLeaseCharge");
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getChargeBeginDate() {
	return chargeBeginDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.lang.String
 */
public java.lang.String getChargecurrency() {
	return chargecurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.sql.Date
 */
public java.sql.Date getChargedate() {
	return chargedate;
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getChargeEndDate() {
	return chargeEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return BigDecimal
 */
public BigDecimal getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return BigDecimal
 */
public BigDecimal getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
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
 * Creation date: (24.01.2003 17:17:37)
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 14:33:24)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.LeaseDocPositionKey(getLeaseDocPosition()) };
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 14:41:52)
 * @return int
 */
public int getLeaseDocPosition() {
	return leaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNotremaindersum() {
	return notremaindersum;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRemainderratetorur() {
	return remainderratetorur;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRemaindersum() {
	return remaindersum;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return sum;
}
/**
 * 
 * @param newChargeBeginDate java.sql.Date
 */
public void setChargeBeginDate(java.sql.Date newChargeBeginDate) {
	chargeBeginDate = newChargeBeginDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newChargecurrency java.lang.String
 */
public void setChargecurrency(java.lang.String newChargecurrency) {
	chargecurrency = newChargecurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newChargedate java.sql.Date
 */
public void setChargedate(java.sql.Date newChargedate) {
	chargedate = newChargedate;
}
/**
 * 
 * @param newChargeEndDate java.sql.Date
 */
public void setChargeEndDate(java.sql.Date newChargeEndDate) {
	chargeEndDate = newChargeEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newCurrency1 BigDecimal
 */
public void setCurrency1(BigDecimal newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newCurrency2 BigDecimal
 */
public void setCurrency2(BigDecimal newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 14:41:52)
 * @param newLeaseDocPosition int
 */
public void setLeaseDocPosition(int newLeaseDocPosition) {
	leaseDocPosition = newLeaseDocPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newNotremaindersum java.math.BigDecimal
 */
public void setNotremaindersum(java.math.BigDecimal newNotremaindersum) {
	notremaindersum = newNotremaindersum;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newRemainderratetorur java.math.BigDecimal
 */
public void setRemainderratetorur(java.math.BigDecimal newRemainderratetorur) {
	remainderratetorur = newRemainderratetorur;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newRemaindersum java.math.BigDecimal
 */
public void setRemaindersum(java.math.BigDecimal newRemaindersum) {
	remaindersum = newRemaindersum;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate = newStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.01.2003 17:17:37)
 * @param newSum java.math.BigDecimal
 */
public void setSum(java.math.BigDecimal newSum) {
	sum = newSum;
}
}
