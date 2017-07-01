package com.hps.july.arenda.valueobject;

/**
 * Контейнер "Соответствие между ресурсами Billing & NRI".
 * Creation date: (09.09.2004 12:34:29)
 * @author: Shafigullin Ildar
 */
public class LeaseResBil2nri_VO {
	private java.lang.Integer idrecord;//уникальный код записи
	private java.lang.String idresbilling;//код услуги в биллинге
	private java.lang.Integer resource;//код услуги в NRI
	private String billresname;//наименование услуги NRI
	private java.lang.String record_status;//статус записи(A-active; D-deleted)
	private java.lang.String typeRes;// тип записи ('E' - оборудование, 'S' - услуги, 'C' - карты связи, 
	private java.lang.String isActive;//Y, N - признак активности
/**
 * LeaseResBil2nri_VO constructor comment.
 */
public LeaseResBil2nri_VO() {
	super();
}
/**
 * LeaseResBil2nri_VO constructor comment.
 * @param ro com.hps.july.cdbc.lib.CDBCRowObject
 */
public LeaseResBil2nri_VO(com.hps.july.cdbc.lib.CDBCRowObject ro) {
	super();
	idrecord = (Integer) ro.getColumn("idrecord").asObject();
	setIdresbilling(ro.getColumn("idresbilling").asString());
	setResource((Integer) ro.getColumn("resource").asObject());
	setBillresname(ro.getColumn("billresname").asString());
	setRecord_status(ro.getColumn("record_status").asString());
	setTypeRes(ro.getColumn("typeres").asString());
	setIsActive(ro.getColumn("isactive").asString());
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:39:33)
 * @return String
 */
public String getBillresname() {
	return billresname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:36:54)
 * @return java.lang.Integer
 */
public java.lang.Integer getIdrecord() {
	return idrecord;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:38:38)
 * @return java.lang.String
 */
public java.lang.String getIdresbilling() {
	return idresbilling;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 13:48:41)
 * @return java.lang.String
 */
public java.lang.String getIsActive() {
	return isActive;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:40:03)
 * @return java.lang.String
 */
public java.lang.String getRecord_status() {
	return record_status;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:39:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 13:48:00)
 * @return java.lang.String
 */
public java.lang.String getTypeRes() {
	return typeRes;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:39:33)
 * @param newBillresname String
 */
public void setBillresname(String newBillresname) {
	billresname = newBillresname;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:36:54)
 * @param newIdrecord java.lang.Integer
 */
public void setIdrecord(java.lang.Integer newIdrecord) {
	idrecord = newIdrecord;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:38:38)
 * @param newIdresbilling java.lang.String
 */
public void setIdresbilling(java.lang.String newIdresbilling) {
	idresbilling = newIdresbilling;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 13:48:41)
 * @param newIsActive java.lang.String
 */
public void setIsActive(java.lang.String newIsActive) {
	isActive = newIsActive;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:40:03)
 * @param newRecord_status java.lang.String
 */
public void setRecord_status(java.lang.String newRecord_status) {
	record_status = newRecord_status;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 12:39:06)
 * @param newResource java.lang.Integer
 */
public void setResource(java.lang.Integer newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (09.09.2004 13:48:00)
 * @param newTypeRes java.lang.String
 */
public void setTypeRes(java.lang.String newTypeRes) {
	typeRes = newTypeRes;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "LeaseResBil2nri_VO: id=" + getIdresbilling() + "; name: " + getBillresname();
}
}
