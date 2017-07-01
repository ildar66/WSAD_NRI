package com.hps.july.arenda.formbean;

import java.sql.Date;
import java.math.*;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма "Лист платежей".
 * Creation date: (05.07.2002 11:18:01)
 * @author: Sergey Gourov
 */
public class PaymentsListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseContract;

	private int sourceContract;
	
	private java.lang.String documentNumber;
	private java.sql.Date startDate;
	private java.sql.Date endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private BigDecimal currency1;
	private BigDecimal currency2;
	private java.lang.Boolean isDate;
	private StringAndSqlDateProperty fromDate;
	private StringAndSqlDateProperty toDate;
	private int orgExecutorcode;
	private java.lang.String curr1;
	private java.lang.String curr2;
	private java.lang.String stateOfContract;
	private java.sql.Date documentDate;
	private int order;
	private boolean isSyncnriplatinumarenda;
	private java.lang.String mainPosition;
/**
 * PayRulesListForm constructor comment.
 */
public PaymentsListForm() {
	super();
	//setFinderMethodName("2");
	order = 2;

	setIsDate(new Boolean(true));

	toDate = new StringAndSqlDateProperty();
	fromDate = new StringAndSqlDateProperty();
	
	java.util.GregorianCalendar c = new java.util.GregorianCalendar();
	toDate.setSqlDate(new Date(c.getTime().getTime()));
	c.add(java.util.Calendar.YEAR, -1);
	fromDate.setSqlDate(new Date(c.getTime().getTime()));
}
/**
 * Creation date: (22.05.2002 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	return o;
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCLeasePaymentObject";
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:34:04)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:34:04)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @return com.ibm.math.BigDecimal
 */
public BigDecimal getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @return com.ibm.math.BigDecimal
 */
public BigDecimal getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 11:46:09)
 * @return java.sql.Date
 */
public java.sql.Date getDocumentDate() {
	return documentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
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
 * Creation date: (05.07.2002 12:26:10)
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
	try {
		order = Integer.parseInt(super.getFinderMethodName());
	} catch (NumberFormatException e) {}
	
	return new Object[] { Boolean.TRUE, new Integer(getLeaseContract()),	// Boolean isLeaseContract, Integer leaseContract
		getIsDate().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getFromDate(), getToDate(),	// Boolean isDate, Date fromDate, Date toDate
		new Boolean(false), new Integer(0),									// Boolean isResource, Integer resource
		new Boolean(true), new String[] { "N", "C" },						// Boolean isDocposvid, String[] docposvid
		new Integer(order) };												// Integer order
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE5";
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:43:17)
 * @return java.sql.Date
 */
public java.sql.Date getFromDate() {
	return fromDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:43:17)
 * @return java.sql.Date
 */
public String getFromDateFrm() {
	return fromDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:41:34)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate() {
	return isDate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2003 9:54:23)
 * @return boolean
 */
final public boolean getIsSyncnriplatinumarenda() {
	return isSyncnriplatinumarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 10:52:27)
 * @return int
 */
public int getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (01.03.2004 15:21:15)
 * @return java.lang.String
 */
public java.lang.String getMainPosition() {
	return mainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 16:24:14)
 * @return int
 */
public int getOrgExecutorcode() {
	return orgExecutorcode;
}
/**
 * 
 * @return int
 */
public int getSourceContract() {
	return sourceContract;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Insert the method's description here.
 * Creation date: (20.11.2002 10:57:07)
 * @return java.lang.String
 */
public java.lang.String getStateOfContract() {
	return stateOfContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:55:01)
 * @return java.sql.Date
 */
public java.sql.Date getToDate() {
	return toDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:55:01)
 * @return java.sql.Date
 */
public String getToDateFrm() {
	return toDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:34:04)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:34:04)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @param newCurrency1 com.ibm.math.BigDecimal
 */
public void setCurrency1(BigDecimal newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @param newCurrency2 com.ibm.math.BigDecimal
 */
public void setCurrency2(BigDecimal newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (04.02.2003 11:46:09)
 * @param newDocumentDate java.sql.Date
 */
public void setDocumentDate(java.sql.Date newDocumentDate) {
	documentDate = newDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @param newEndDate java.sql.Date
 */
public void setEndDate(java.sql.Date newEndDate) {
	endDate = newEndDate;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:43:17)
 * @param newFromDate java.sql.Date
 */
public void setFromDate(java.sql.Date newFromDate) {
	fromDate.setSqlDate(newFromDate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:43:17)
 * @param newFromDate java.sql.Date
 */
public void setFromDateFrm(String newFromDate) {
	fromDate.setString(newFromDate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:41:34)
 * @param newIsDate java.lang.Boolean
 */
public void setIsDate(java.lang.Boolean newIsDate) {
	isDate = newIsDate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.08.2003 9:54:23)
 * @param newIsSyncnriplatinumarenda boolean
 */
final public void setIsSyncnriplatinumarenda(boolean newIsSyncnriplatinumarenda) {
	isSyncnriplatinumarenda = newIsSyncnriplatinumarenda;
}
/**
 * Insert the method's description here.
 * Creation date: (18.07.2002 10:52:27)
 * @param newLeaseContract int
 */
public void setLeaseContract(int newLeaseContract) {
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (01.03.2004 15:21:15)
 * @param newMainPosition java.lang.String
 */
public void setMainPosition(java.lang.String newMainPosition) {
	mainPosition = newMainPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (29.01.2003 16:24:14)
 * @param newOrgExecutorcode int
 */
public void setOrgExecutorcode(int newOrgExecutorcode) {
	orgExecutorcode = newOrgExecutorcode;
}
/**
 * 
 * @param newSourceContract int
 */
public void setSourceContract(int newSourceContract) {
	sourceContract = newSourceContract;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 12:26:10)
 * @param newStartDate java.sql.Date
 */
public void setStartDate(java.sql.Date newStartDate) {
	startDate = newStartDate;
}
/**
 * Insert the method's description here.
 * Creation date: (20.11.2002 10:57:07)
 * @param newStateOfContract java.lang.String
 */
public void setStateOfContract(java.lang.String newStateOfContract) {
	stateOfContract = newStateOfContract;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:55:01)
 * @param newToDate java.sql.Date
 */
public void setToDate(java.sql.Date newToDate) {
	toDate.setSqlDate(newToDate);
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2002 10:55:01)
 * @param newToDate java.sql.Date
 */
public void setToDateFrm(String newToDate) {
	toDate.setString(newToDate);
}
}
