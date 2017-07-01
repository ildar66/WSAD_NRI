package com.hps.july.arenda.valueobject;

/**
 * Bean-Wrapper "Информация о доставке счетов".
 * Creation date: (20.01.2005 10:59:53)
 * @author: Shafigullin Ildar
 */
public class CourierDelivery_VO {
	private java.lang.Integer idrecord;
	private java.lang.Integer leasedocument;
	private java.lang.Integer ban;
	private java.lang.Integer ben;
	private java.sql.Timestamp sys_creation_date;
	private java.lang.String document_no;
	private java.lang.String document_type;
	private java.sql.Date delivery_date;
	private java.lang.String delivery_status;
	private java.lang.String courier_code;
	private java.lang.String memo;
	private java.lang.String record_status;
/**
 * CourierDelivery_VO constructor comment.
 */
public CourierDelivery_VO() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:36:43)
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public CourierDelivery_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
    setIdrecord((Integer) ro.getColumn("idrecord").asObject());
    setLeasedocument((Integer)ro.getColumn("leasedocument").asObject());
    setBen((Integer)ro.getColumn("ben").asObject());
    setDocument_no(ro.getColumn("document_no").asString());
    setDelivery_date((java.sql.Date)ro.getColumn("delivery_date").asObject());
    setMemo(ro.getColumn("memo").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:02:41)
 * @return java.lang.Integer
 */
public java.lang.Integer getBan() {
	return ban;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:03:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getBen() {
	return ben;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:06:26)
 * @return java.lang.String
 */
public java.lang.String getCourier_code() {
	return courier_code;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:05:52)
 * @return java.sql.Date
 */
public java.sql.Date getDelivery_date() {
	return delivery_date;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:06:10)
 * @return java.lang.String
 */
public java.lang.String getDelivery_status() {
	return delivery_status;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:04:46)
 * @return java.lang.String
 */
public java.lang.String getDocument_no() {
	return document_no;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:05:09)
 * @return java.lang.String
 */
public java.lang.String getDocument_type() {
	return document_type;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:01:53)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdrecord() {
	return idrecord;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:02:13)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeasedocument() {
	return leasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:06:40)
 * @return java.lang.String
 */
public java.lang.String getMemo() {
	return memo;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:07:00)
 * @return java.lang.String
 */
public java.lang.String getRecord_status() {
	return record_status;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:04:24)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getSys_creation_date() {
	return sys_creation_date;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:02:41)
 * @param newBan java.lang.Integer
 */
public void setBan(java.lang.Integer newBan) {
	ban = newBan;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:03:50)
 * @param newBen java.lang.Integer
 */
public void setBen(java.lang.Integer newBen) {
	ben = newBen;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:06:26)
 * @param newCourier_code java.lang.String
 */
public void setCourier_code(java.lang.String newCourier_code) {
	courier_code = newCourier_code;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:05:52)
 * @param newDelivery_date java.sql.Date
 */
public void setDelivery_date(java.sql.Date newDelivery_date) {
	delivery_date = newDelivery_date;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:06:10)
 * @param newDelivery_status java.lang.String
 */
public void setDelivery_status(java.lang.String newDelivery_status) {
	delivery_status = newDelivery_status;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:04:46)
 * @param newDocument_no java.lang.String
 */
public void setDocument_no(java.lang.String newDocument_no) {
	document_no = newDocument_no;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:05:09)
 * @param newDocument_type java.lang.String
 */
public void setDocument_type(java.lang.String newDocument_type) {
	document_type = newDocument_type;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:01:53)
 * @param newIdrecord java.lang.Integer
 */
public void setIdrecord(java.lang.Integer newIdrecord) {
	idrecord = newIdrecord;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:02:13)
 * @param newLeasedocument java.lang.Integer
 */
public void setLeasedocument(java.lang.Integer newLeasedocument) {
	leasedocument = newLeasedocument;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:06:40)
 * @param newMemo java.lang.String
 */
public void setMemo(java.lang.String newMemo) {
	memo = newMemo;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:07:00)
 * @param newRecord_status java.lang.String
 */
public void setRecord_status(java.lang.String newRecord_status) {
	record_status = newRecord_status;
}
/**
 * Insert the method's description here.
 * Creation date: (20.01.2005 11:04:24)
 * @param newSys_creation_date java.sql.Timestamp
 */
public void setSys_creation_date(java.sql.Timestamp newSys_creation_date) {
	sys_creation_date = newSys_creation_date;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	// Insert code to print the receiver here.
	// This implementation forwards the message to super. You may replace or supplement this.
	return super.toString();
}
}
