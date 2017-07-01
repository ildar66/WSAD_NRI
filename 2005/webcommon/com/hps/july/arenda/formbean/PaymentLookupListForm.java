package com.hps.july.arenda.formbean;

import java.sql.Date;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма "Поиск платежей".
 * Creation date: (27.01.2003 10:09:57)
 * @author: Sergey Gourov
 */
public class PaymentLookupListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndSqlDateProperty fromDate;
	private StringAndSqlDateProperty toDate;
	private java.lang.Boolean isDate;
	private java.lang.Boolean isResource;
	private int resourcecode;
	private java.lang.Integer leaseContract;
	private int currencycode;
/**
 * PaymentLookupListForm constructor comment.
 */
public PaymentLookupListForm() {
	super();
	setFinderMethodName("findByQBE");

	setIsDate(new Boolean(true));
	setIsResource(new Boolean(true));
	fromDate = new StringAndSqlDateProperty();
	fromDate.setSqlDate(new Date(System.currentTimeMillis()));
	toDate = new StringAndSqlDateProperty();
	toDate.setSqlDate(new Date(System.currentTimeMillis()));
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:21:07)
 * @return int
 */
public int getCurrencycode() {
	return currencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 10:09:57)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
/*Boolean isLeaseContract, Integer leaseContract,
	Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, 
	Boolean isResource, Integer resource,
	Integer order*/
	
	return new Object[] { new Boolean(true), getLeaseContract(),
		getIsDate().booleanValue() ? Boolean.FALSE : Boolean.TRUE, getFromDate(), getToDate(),
		getIsResource().booleanValue() ? Boolean.FALSE : Boolean.TRUE, new Integer(getResourcecode()),
		new Integer(1) };
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
 * Creation date: (27.01.2003 10:55:02)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDate() {
	return isDate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 10:55:23)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsResource() {
	return isResource;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:06:34)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 10:56:46)
 * @return int
 */
public int getResourcecode() {
	return resourcecode;
}
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
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
 * Creation date: (27.01.2003 17:21:07)
 * @param newCurrencycode int
 */
public void setCurrencycode(int newCurrencycode) {
	currencycode = newCurrencycode;
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
 * Creation date: (27.01.2003 10:55:02)
 * @param newIsDate java.lang.Boolean
 */
public void setIsDate(java.lang.Boolean newIsDate) {
	isDate = newIsDate;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 10:55:23)
 * @param newIsResource java.lang.Boolean
 */
public void setIsResource(java.lang.Boolean newIsResource) {
	isResource = newIsResource;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:06:34)
 * @param newLeaseContract java.lang.Integer
 */
public void setLeaseContract(java.lang.Integer newLeaseContract) {
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 10:56:46)
 * @param newResourcecode int
 */
public void setResourcecode(int newResourcecode) {
	resourcecode = newResourcecode;
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
