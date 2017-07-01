package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import java.sql.Date;
import java.util.*;
import java.math.*;
import com.hps.july.web.util.*;
import com.hps.july.cdbc.lib.*;
import com.hps.july.arenda.valueobject.*;
/**
 * form-bean
 * форма для начислений(лист)
 * Creation date: (05.07.2002 11:18:01)
 * @author: Sergey Gourov
 */
public class ChargesListForm extends com.hps.july.web.util.BrowseForm {
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
	private java.lang.String curr1;
	private java.lang.String curr2;
	private java.lang.Integer orgCustomercode;
	private java.lang.Integer orgExecutorcode;
	private String stateOfContract;
	private java.lang.Boolean isResource;
	private int resource;
	private java.sql.Date documentDate;
	private java.lang.String mainPosition;
/**
 * PayRulesListForm constructor comment.
 */
public ChargesListForm() {
	super();
	setFinderMethodName("findByQBE5");
	
	setIsDate(new Boolean(true));
	setIsResource(new Boolean(true));
	
	setResource(0);
	//setResourcename("");
	
	GregorianCalendar c = new GregorianCalendar();
	c.clear(Calendar.HOUR_OF_DAY);
	c.clear(Calendar.MINUTE);
	c.clear(Calendar.SECOND);
	c.clear(Calendar.MILLISECOND);

	java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	toDate = new StringAndSqlDateProperty();
	toDate.setSqlDate(new Date(c.getTime().getTime()));
	
	c.set(Calendar.MONTH, 0);
	c.set(Calendar.DAY_OF_MONTH, 1);
	fromDate = new StringAndSqlDateProperty();
	fromDate.setSqlDate(new Date(c.getTime().getTime()));
	
	/*java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	toDate = new StringAndSqlDateProperty();
	toDate.setSqlDate(date);*/
}
/**
 * Creation date: (15.04.2004 16:35:23)
 * @return java.lang.Object
 * @param o java.lang.Object
 */
public Object constructRowModelBean(Object o) {
	return new LeaseChargeVO((com.hps.july.cdbc.lib.CDBCRowObject)o);
}
/**
 * Возвращает имя bean для броуза.
 * Creation date: (22.01.2002 11:33:25)
 * @return java.lang.String
 */
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCLeaseChargesObject";
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:27:45)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:27:45)
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
 * Creation date: (04.02.2003 11:41:08)
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
/*Boolean isLeaseContract, Integer leaseContract,
            Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, 
            Boolean isResource, Integer resource,
            Boolean isDocposvid, String[] docposvid, 
            Integer order*/

	return new Object[] { Boolean.TRUE, new Integer(getLeaseContract()),
		getIsDate().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getFromDate(), getToDate(),
		getIsResource().booleanValue() ? Boolean.FALSE : Boolean.TRUE, new Integer(getResource()),
		new Boolean(true), new String[] { "N", "C" },
		new Integer(2) };
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
 * Creation date: (15.12.2002 20:15:35)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsResource() {
	return isResource;
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
 * Creation date: (01.03.2004 13:45:02)
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
 * Creation date: (06.08.2002 19:22:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrgCustomercode() {
	return orgCustomercode;
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
 * Creation date: (06.08.2002 19:23:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrgExecutorcode() {
	return orgExecutorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 20:20:01)
 * @return int
 */
public int getResource() {
	return resource;
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return (new ResourceAccessBean()).findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
}
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
 * Creation date: (20.11.2002 10:36:01)
 * @return int
 */
public String getStateOfContract() {
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
 * Creation date: (03.08.2002 13:27:45)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (03.08.2002 13:27:45)
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
 * Creation date: (04.02.2003 11:41:08)
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
 * Creation date: (15.12.2002 20:15:35)
 * @param newIsResource java.lang.Boolean
 */
public void setIsResource(java.lang.Boolean newIsResource) {
	isResource = newIsResource;
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
 * Creation date: (01.03.2004 13:45:02)
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
 * Creation date: (06.08.2002 19:22:59)
 * @param newOrgCustomercode java.lang.Integer
 */
public void setOrgCustomercode(java.lang.Integer newOrgCustomercode) {
	orgCustomercode = newOrgCustomercode;
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
 * Creation date: (06.08.2002 19:23:53)
 * @param newOrgExecutorcode java.lang.Integer
 */
public void setOrgExecutorcode(java.lang.Integer newOrgExecutorcode) {
	orgExecutorcode = newOrgExecutorcode;
}
/**
 * Insert the method's description here.
 * Creation date: (15.12.2002 20:20:01)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
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
 * Creation date: (20.11.2002 10:36:01)
 * @param newStateOfContract int
 */
public void setStateOfContract(String newStateOfContract) {
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
