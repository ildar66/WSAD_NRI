package com.hps.july.arenda.valueobject;

/**
 * Bean-Wrapper "истории платежей договора"
 * Creation date: (10.11.2003 14:53:34)
 * @author: Dmitry Dneprov
 */
public class DogHistPayObject {
	private java.math.BigDecimal summ;
	private java.lang.String currname;
	private java.lang.Integer idpayabonent;
	private java.lang.Integer idresourceabonent;
	private java.lang.String resname;
	private java.lang.String number;
	private java.sql.Date date;
	private java.math.BigDecimal summrub;
	private java.math.BigDecimal rate;
	private java.lang.String state;
/**
 * DogHistChargeObject constructor comment.
 */
public DogHistPayObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:58:30)
 * @return java.lang.String
 */
public java.lang.String getCurrname() {
	return currname;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:30:31)
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 17:57:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdpayabonent() {
	return idpayabonent;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 17:58:10)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdresourceabonent() {
	return idresourceabonent;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:30:16)
 * @return java.lang.String
 */
public java.lang.String getNumber() {
	return number;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:31:30)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRate() {
	return rate;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:28:39)
 * @return java.lang.String
 */
public java.lang.String getResname() {
	return resname;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 18:09:00)
 * @return java.lang.String
 */
public java.lang.String getState() {
	return state;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:57:53)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm() {
	return summ;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:31:02)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSummrub() {
	return summrub;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:58:30)
 * @param newCurrname java.lang.String
 */
public void setCurrname(java.lang.String newCurrname) {
	currname = newCurrname;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:30:31)
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date = newDate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 17:57:50)
 * @param newIdpayabonent java.lang.Integer
 */
public void setIdpayabonent(java.lang.Integer newIdpayabonent) {
	idpayabonent = newIdpayabonent;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 17:58:10)
 * @param newIdresourceabonent java.lang.Integer
 */
public void setIdresourceabonent(java.lang.Integer newIdresourceabonent) {
	idresourceabonent = newIdresourceabonent;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:30:16)
 * @param newNumber java.lang.String
 */
public void setNumber(java.lang.String newNumber) {
	number = newNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:31:30)
 * @param newRate java.math.BigDecimal
 */
public void setRate(java.math.BigDecimal newRate) {
	rate = newRate;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:28:39)
 * @param newResname java.lang.String
 */
public void setResname(java.lang.String newResname) {
	resname = newResname;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 18:09:00)
 * @param newState java.lang.String
 */
public void setState(java.lang.String newState) {
	state = newState;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:57:53)
 * @param newSumm java.math.BigDecimal
 */
public void setSumm(java.math.BigDecimal newSumm) {
	summ = newSumm;
}
/**
 * Insert the method's description here.
 * Creation date: (12.11.2003 17:31:02)
 * @param newSummrub java.math.BigDecimal
 */
public void setSummrub(java.math.BigDecimal newSummrub) {
	summrub = newSummrub;
}
}
