package com.hps.july.arenda.valueobject;

/**
 * Bean-Wrapper "истории начислений договора"
 * Creation date: (10.11.2003 14:53:34)
 * @author: Dmitry Dneprov
 */
public class DogHistChargeObject {
	private java.sql.Date actdate;
	private java.lang.String billnumber;
	private java.sql.Date billdate;
	private java.math.BigDecimal summ;
	private java.lang.String currname;
	private java.sql.Date sdate;
	private java.sql.Date edate;
	private java.lang.Integer leasebill;
	private java.lang.Integer idchargeabonent;
	private java.lang.Integer idpayabonent;
	private java.lang.Integer idresourceabonent;
	private java.math.BigDecimal crate;
	private boolean sumchanged;
	private java.lang.String resname;
/**
 * DogHistChargeObject constructor comment.
 */
public DogHistChargeObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:53:57)
 * @return java.sql.Date
 */
public java.sql.Date getActdate() {
	return actdate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:54:41)
 * @return java.sql.Date
 */
public java.sql.Date getBilldate() {
	return billdate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:54:18)
 * @return java.lang.String
 */
public java.lang.String getBillnumber() {
	return billnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2003 10:39:28)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getCrate() {
	return crate;
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
 * Creation date: (10.11.2003 14:59:24)
 * @return java.sql.Date
 */
public java.sql.Date getEdate() {
	return edate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 17:57:31)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdchargeabonent() {
	return idchargeabonent;
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
 * Creation date: (10.11.2003 15:00:40)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeasebill() {
	return leasebill;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2003 16:25:58)
 * @return java.lang.String
 */
public java.lang.String getResname() {
	return resname;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:59:08)
 * @return java.sql.Date
 */
public java.sql.Date getSdate() {
	return sdate;
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
 * Creation date: (02.12.2003 10:40:31)
 * @return boolean
 */
public boolean isSumchanged() {
	return sumchanged;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:53:57)
 * @param newActdate java.sql.Date
 */
public void setActdate(java.sql.Date newActdate) {
	actdate = newActdate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:54:41)
 * @param newBilldate java.sql.Date
 */
public void setBilldate(java.sql.Date newBilldate) {
	billdate = newBilldate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:54:18)
 * @param newBillnumber java.lang.String
 */
public void setBillnumber(java.lang.String newBillnumber) {
	billnumber = newBillnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2003 10:39:28)
 * @param newCrate java.math.BigDecimal
 */
public void setCrate(java.math.BigDecimal newCrate) {
	crate = newCrate;
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
 * Creation date: (10.11.2003 14:59:24)
 * @param newEdate java.sql.Date
 */
public void setEdate(java.sql.Date newEdate) {
	edate = newEdate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 17:57:31)
 * @param newIdchargeabonent java.lang.Integer
 */
public void setIdchargeabonent(java.lang.Integer newIdchargeabonent) {
	idchargeabonent = newIdchargeabonent;
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
 * Creation date: (10.11.2003 15:00:40)
 * @param newLeasebill java.lang.Integer
 */
public void setLeasebill(java.lang.Integer newLeasebill) {
	leasebill = newLeasebill;
}
/**
 * Insert the method's description here.
 * Creation date: (03.12.2003 16:25:58)
 * @param newResname java.lang.String
 */
public void setResname(java.lang.String newResname) {
	resname = newResname;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:59:08)
 * @param newSdate java.sql.Date
 */
public void setSdate(java.sql.Date newSdate) {
	sdate = newSdate;
}
/**
 * Insert the method's description here.
 * Creation date: (02.12.2003 10:40:31)
 * @param newSumchanged boolean
 */
public void setSumchanged(boolean newSumchanged) {
	sumchanged = newSumchanged;
}
/**
 * Insert the method's description here.
 * Creation date: (10.11.2003 14:57:53)
 * @param newSumm java.math.BigDecimal
 */
public void setSumm(java.math.BigDecimal newSumm) {
	summ = newSumm;
}
}
