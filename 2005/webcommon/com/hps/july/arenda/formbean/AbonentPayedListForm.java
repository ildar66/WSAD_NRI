package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.sql.*;
import java.math.*;
/**
 * Form-Bean 
 * лист "абонентских платежей".
 * Creation date: (04.10.2002 11:32:20)
 * @author: Sergey Gourov
 */
public class AbonentPayedListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseDocument;
	private String ban;
	private String customername;
	private String customerinn;
	private java.lang.String customernameBill;
	private java.lang.String customerinnBill;

	private int pay;
	private java.sql.Date paydate;
	private String paynumber;
	private BigDecimal paysumm;

	private Integer order;
	private java.lang.String paytype;
/**
 * AbonentBillsListForm constructor comment.
 */
public AbonentPayedListForm() {
	super();
	setFinderMethodName("1");
	order = new Integer(1);
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return java.lang.String
 */
public java.lang.String getBan() {
	return ban;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return java.lang.String
 */
public java.lang.String getCustomerinn() {
	return customerinn;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return java.lang.String
 */
public java.lang.String getCustomerinnBill() {
	return customerinnBill;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return java.lang.String
 */
public java.lang.String getCustomername() {
	return customername;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return java.lang.String
 */
public java.lang.String getCustomernameBill() {
	return customernameBill;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.AbonentPaymentKey(pay) };
}
public java.lang.String getFinderMethodName() {
	return "findLeaseAbonentDNOPsByAbonentpayment";
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return int
 */
public int getLeaseDocument() {
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return int
 */
public int getPay() {
	return pay;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return java.sql.Date
 */
public java.sql.Date getPaydate() {
	return paydate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return java.lang.String
 */
public java.lang.String getPaynumber() {
	return paynumber;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @return BigDecimal
 */
public BigDecimal getPaysumm() {
	return paysumm;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2003 14:58:24)
 * @return java.lang.String
 */
public java.lang.String getPaytype() {
	return paytype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newBan java.lang.String
 */
public void setBan(java.lang.String newBan) {
	ban = newBan;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newCustomerinn java.lang.String
 */
public void setCustomerinn(java.lang.String newCustomerinn) {
	customerinn = newCustomerinn;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newCustomerinnBill java.lang.String
 */
public void setCustomerinnBill(java.lang.String newCustomerinnBill) {
	customerinnBill = newCustomerinnBill;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newCustomername java.lang.String
 */
public void setCustomername(java.lang.String newCustomername) {
	customername = newCustomername;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newCustomernameBill java.lang.String
 */
public void setCustomernameBill(java.lang.String newCustomernameBill) {
	customernameBill = newCustomernameBill;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newLeaseDocument int
 */
public void setLeaseDocument(int newLeaseDocument) {
	leaseDocument = newLeaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newPay int
 */
public void setPay(int newPay) {
	pay = newPay;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newPaydate java.sql.Date
 */
public void setPaydate(java.sql.Date newPaydate) {
	paydate = newPaydate;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newPaynumber java.lang.String
 */
public void setPaynumber(java.lang.String newPaynumber) {
	paynumber = newPaynumber;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2003 13:19:07)
 * @param newPaysumm BigDecimal
 */
public void setPaysumm(BigDecimal newPaysumm) {
	paysumm = newPaysumm;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2003 14:58:24)
 * @param newPaytype java.lang.String
 */
public void setPaytype(java.lang.String newPaytype) {
	paytype = newPaytype;
}
}
