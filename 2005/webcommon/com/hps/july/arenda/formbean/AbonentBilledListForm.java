package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.sql.*;
import java.math.*;
/**
 *  Form-Bean.
 * "Лист счетов по абоненстским договорам".
 */
public class AbonentBilledListForm extends com.hps.july.web.util.BrowseForm {
	private int leaseBill;
	private java.lang.String ban;
	private String customername;
	private String customerinn;
	private java.lang.String customernameBill;
	private java.lang.String customerinnBill;
	private java.lang.String billNumber;
	private java.sql.Date billDate;
	private StringAndBigDecimalProperty sum;
	private StringAndBigDecimalProperty sumnds;
	private StringAndBigDecimalProperty sumnsp;

	private Integer order;
public AbonentBilledListForm() {
	super();
	setFinderMethodName("1");
	order = new Integer(1);
	java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
	sum = new StringAndBigDecimalProperty();
	sumnds = new StringAndBigDecimalProperty();
	sumnsp = new StringAndBigDecimalProperty();
}
public java.lang.String getBan() {
	return ban;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 14:17:46)
 * @return java.sql.Date
 */
public java.sql.Date getBillDate() {
	return billDate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 14:17:46)
 * @return java.lang.String
 */
public java.lang.String getBillNumber() {
	return billNumber;
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
	return new Object[] { new com.hps.july.persistence.AbonentBillKey(leaseBill) };
}
public java.lang.String getFinderMethodName() {
	return "findLeaseAbonentDNOPsByAbonentbill";
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 14:17:46)
 * @return int
 */
public int getLeaseBill() {
	return leaseBill;
}
public BigDecimal getSum() {
	return sum.getBigDecimal();
}
public String getSumFrm() {
	return sum.getString();
}
public BigDecimal getSumnds() {
	return sumnds.getBigDecimal();
}
public String getSumndsFrm() {
	return sumnds.getString();
}
public BigDecimal getSumnsp() {
	return sumnsp.getBigDecimal();
}
public String getSumnspFrm() {
	return sumnsp.getString();
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
 * Creation date: (04.03.2003 14:17:46)
 * @param newBillDate java.sql.Date
 */
public void setBillDate(java.sql.Date newBillDate) {
	billDate = newBillDate;
}
/**
 * Insert the method's description here.
 * Creation date: (04.03.2003 14:17:46)
 * @param newBillNumber java.lang.String
 */
public void setBillNumber(java.lang.String newBillNumber) {
	billNumber = newBillNumber;
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
 * Creation date: (04.03.2003 14:17:46)
 * @param newLeaseBill int
 */
public void setLeaseBill(int newLeaseBill) {
	leaseBill = newLeaseBill;
}
/**
 * Insert the method's description here.
 * Creation date: (09.10.2002 10:49:18)
 * @param newSum java.math.BigDecimal
 */
public void setSum(java.math.BigDecimal newSum) {
	sum.setBigDecimal(newSum);
}
/**
 * Insert the method's description here.
 * Creation date: (09.10.2002 10:49:18)
 * @param newSum java.math.BigDecimal
 */
public void setSumFrm(String newSum) {
	sum.setString(newSum);
}
public void setSumnds(java.math.BigDecimal newSumnds) {
	sumnds.setBigDecimal(newSumnds);
}
public void setSumndsFrm(String newSumnds) {
	sumnds.setString(newSumnds);
}
public void setSumnsp(java.math.BigDecimal newSumnsp) {
	sumnsp.setBigDecimal(newSumnsp);
}
public void setSumnspFrm(String newSumnsp) {
	sumnsp.setString(newSumnsp);
}
}
