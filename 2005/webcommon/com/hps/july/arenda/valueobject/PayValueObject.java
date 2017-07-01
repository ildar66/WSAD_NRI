package com.hps.july.arenda.valueobject;

import java.math.BigDecimal;
import java.sql.*;
/**
 * Контейнер "платежи".
 */
public class PayValueObject {
	private Integer pay;
	private String number;
	private java.sql.Date date;
	private String purpose;
	private BigDecimal sumrub;
/**
 * PayValueObject constructor comment.
 */
public PayValueObject() {
	super();
}
public PayValueObject(ResultSet rs) {
	super();
	try {
		pay = new Integer(rs.getInt("pay"));
		if(rs.wasNull()) {
			pay = null;
		}
		date = rs.getDate("paydate");
		number = rs.getString("paynumber");
		purpose = rs.getString("paypurpose");
		sumrub = rs.getBigDecimal("paysumrub");
	} catch(Exception e) {
		System.out.println("PAYVALUE: Error while initialize object. Exception "+e.getClass().getName());
	}
}
/**
 * 
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getPay() {
	return pay;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getPurpose() {
	return purpose;
}
/**
 * 
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumrub() {
	return sumrub;
}
/**
 * 
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date = newDate;
}
/**
 * 
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * 
 * @param newPay java.lang.Integer
 */
public void setPay(java.lang.Integer newPay) {
	pay = newPay;
}
/**
 * 
 * @param newPurpose java.lang.String
 */
public void setPurpose(java.lang.String newPurpose) {
	purpose = newPurpose;
}
/**
 * 
 * @param newSumrub java.math.BigDecimal
 */
public void setSumrub(java.math.BigDecimal newSumrub) {
	sumrub = newSumrub;
}
}
