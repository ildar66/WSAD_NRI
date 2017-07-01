package com.hps.july.arenda.valueobject;

/**
 * Bean-Wrapper "Содержимое акта"
 * Creation date: (11.12.2003 12:59:27)
 * @author: Dmitry Dneprov
 */
public class ActContentsValueObject {
	private int resource;
	private java.lang.String resname;
	private java.sql.Date begindate;
	private java.sql.Date enddate;
	private java.math.BigDecimal summ;
	private int currency;
	private java.lang.String currname;
	private java.lang.String billnumber;
	private java.sql.Date billdate;
	private int leasedocposition;
	private java.lang.String docnumber;
	private java.sql.Date docdate;
	private int leasedocument;
	private java.lang.String orgname;
	private java.lang.String contracttype;
	private java.lang.String ban;
	private java.lang.String ben;
	private int willbeinact;
/**
 * ActContentsValueObject constructor comment.
 */
public ActContentsValueObject() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 10:14:40)
 * @return java.lang.String
 */
public java.lang.String getBan() {
	return ban;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:01:56)
 * @return java.sql.Date
 */
public java.sql.Date getBegindate() {
	return begindate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 10:14:53)
 * @return java.lang.String
 */
public java.lang.String getBen() {
	return ben;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:04:55)
 * @return java.sql.Date
 */
public java.sql.Date getBilldate() {
	return billdate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:04:33)
 * @return java.lang.String
 */
public java.lang.String getBillnumber() {
	return billnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 15:04:27)
 * @return java.lang.String
 */
public java.lang.String getContracttype() {
	return contracttype;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:03:23)
 * @return int
 */
public int getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:03:36)
 * @return java.lang.String
 */
public java.lang.String getCurrname() {
	return currname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:07:37)
 * @return java.sql.Date
 */
public java.sql.Date getDocdate() {
	return docdate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:07:17)
 * @return java.lang.String
 */
public java.lang.String getDocnumber() {
	return docnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:02:10)
 * @return java.sql.Date
 */
public java.sql.Date getEnddate() {
	return enddate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:06:57)
 * @return int
 */
public int getLeasedocposition() {
	return leasedocposition;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:08:22)
 * @return int
 */
public int getLeasedocument() {
	return leasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:09:10)
 * @return java.lang.String
 */
public java.lang.String getOrgname() {
	return orgname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:00:57)
 * @return java.lang.String
 */
public java.lang.String getResname() {
	return resname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:00:42)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:03:09)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumm() {
	return summ;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 13:28:06)
 * @return int
 */
public int getWillbeinact() {
	return willbeinact;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 10:14:40)
 * @param newBan java.lang.String
 */
public void setBan(java.lang.String newBan) {
	ban = newBan;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:01:56)
 * @param newBegindate java.sql.Date
 */
public void setBegindate(java.sql.Date newBegindate) {
	begindate = newBegindate;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 10:14:53)
 * @param newBen java.lang.String
 */
public void setBen(java.lang.String newBen) {
	ben = newBen;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:04:55)
 * @param newBilldate java.sql.Date
 */
public void setBilldate(java.sql.Date newBilldate) {
	billdate = newBilldate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:04:33)
 * @param newBillnumber java.lang.String
 */
public void setBillnumber(java.lang.String newBillnumber) {
	billnumber = newBillnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 15:04:27)
 * @param newContracttype java.lang.String
 */
public void setContracttype(java.lang.String newContracttype) {
	contracttype = newContracttype;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:03:23)
 * @param newCurrency int
 */
public void setCurrency(int newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:03:36)
 * @param newCurrname java.lang.String
 */
public void setCurrname(java.lang.String newCurrname) {
	currname = newCurrname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:07:37)
 * @param newDocdate java.sql.Date
 */
public void setDocdate(java.sql.Date newDocdate) {
	docdate = newDocdate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:07:17)
 * @param newDocnumber java.lang.String
 */
public void setDocnumber(java.lang.String newDocnumber) {
	docnumber = newDocnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:02:10)
 * @param newEnddate java.sql.Date
 */
public void setEnddate(java.sql.Date newEnddate) {
	enddate = newEnddate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:06:57)
 * @param newLeasedocposition int
 */
public void setLeasedocposition(int newLeasedocposition) {
	leasedocposition = newLeasedocposition;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:08:22)
 * @param newLeasedocument int
 */
public void setLeasedocument(int newLeasedocument) {
	leasedocument = newLeasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:09:10)
 * @param newOrgname java.lang.String
 */
public void setOrgname(java.lang.String newOrgname) {
	orgname = newOrgname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:00:57)
 * @param newResname java.lang.String
 */
public void setResname(java.lang.String newResname) {
	resname = newResname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:00:42)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (11.12.2003 13:03:09)
 * @param newSumm java.math.BigDecimal
 */
public void setSumm(java.math.BigDecimal newSumm) {
	summ = newSumm;
}
/**
 * Insert the method's description here.
 * Creation date: (24.12.2003 13:28:06)
 * @param newWillbeinact int
 */
public void setWillbeinact(int newWillbeinact) {
	willbeinact = newWillbeinact;
}
}
