package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * ‘орма списка строк документа "¬нутренн€€ расходна€ накладна€"
 */
public class InternalRPositionListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndIntegerProperty document;

	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	private StringAndSqlDateProperty blankdate;

	private StringAndIntegerProperty owner;
	private String ownername;

	private StringAndIntegerProperty storage;
	private String storagename;

	private String type;
	
	private StringAndIntegerProperty renter;
	private String rentername;
	private String insuranseMan;
	private String insuranceact;
	private StringAndSqlDateProperty insurancedate;

	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private StringAndIntegerProperty position;
	private String positionname;
	
	private java.lang.Boolean readonly;
	private int brokentype;
public InternalRPositionListForm() {
	document = new StringAndIntegerProperty();
	blanknumber = null;
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	owner = new StringAndIntegerProperty();
	ownername = null;
	storage = new StringAndIntegerProperty();
	storagename = null;
	renter = new StringAndIntegerProperty();
	rentername = null;
	insurancedate = new StringAndSqlDateProperty();
	worker = new StringAndIntegerProperty();
	position = new StringAndIntegerProperty();

	readonly = Boolean.FALSE;

	//this.setFinderMethodName( "findDocumentPositionByDocument" );
	this.setFinderMethodName( "findDocPositionsByDocOrderByOrderAsc" );

	brokentype = 1;
}
public java.sql.Date getBlankdate() {
	return blankdate.getSqlDate();
}
public String getBlankdatestr() {
	return blankdate.getString();
}
public int getBlankindex() {
	if(!blankindex.isEmpty() && blankindex.isOk())
		return blankindex.getInteger().intValue();
	else
		return 0;
}
public String getBlankindexFrm() {
	return blankindex.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
/**
 * 
 * @return int
 */
public int getBrokentype() {
	return brokentype;
}
public Integer getDocument() {
	return document.getInteger();
}
public String getDocumentstr() {
	return document.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:28:48)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		(document.getInteger() != null)?document.getInteger():new Integer(0)
		//new DocumentKey( document.getInteger().intValue() )
	};
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getInsuranceact() {
	return insuranceact;
}
public java.sql.Date getInsurancedate() {
	return insurancedate.getSqlDate();
}
public String getInsurancedatestr() {
	return insurancedate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getInsuranseMan() {
	return insuranseMan;
}
public java.lang.Integer getOwner() {
	return owner.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 10:41:56)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getReadonly() {
	return readonly;
}
public java.lang.Integer getRenter() {
	return renter.getInteger();
}
public java.lang.String getRentername() {
	return rentername;
}
public java.lang.Integer getStorage() {
	return storage.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
public java.lang.Integer getWorker() {
	return worker.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getWorkername() {
	return workername;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getWorkertitle() {
	return workertitle;
}
public void setBlankdate(java.sql.Date newDate)
{
	blankdate.setSqlDate(newDate);
}
public void setBlankdatestr(String newDate)
{
	blankdate.setString(newDate);
}
public void setBlankindex(int newBlankindex) {
	blankindex.setInteger(new Integer(newBlankindex));
}
public void setBlankindexFrm(String newBlankindex) {
	blankindex.setString(newBlankindex);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
/**
 * 
 * @param newBrokentype int
 */
public void setBrokentype(int newBrokentype) {
	brokentype = newBrokentype;
}
public void setDocument(Integer newDocument)
{
	document.setInteger(newDocument);
}
public void setDocumentstr(String newDate)
{
	document.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @param newInsuranceact java.lang.String
 */
public void setInsuranceact(java.lang.String newInsuranceact) {
	insuranceact = newInsuranceact;
}
public void setInsurancedate(java.sql.Date newDate)
{
	insurancedate.setSqlDate(newDate);
}
public void setInsurancedatestr(String newDate)
{
	insurancedate.setString(newDate);
}
public void setInsuranseMan(java.lang.String newInsuranseMan) {
	insuranseMan = newInsuranseMan;
}
public void setOwner(java.lang.Integer newOwner) {
	owner.setInteger(newOwner);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @param newPositionname java.lang.String
 */
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.06.2002 10:41:56)
 * @param newReadonly java.lang.Boolean
 */
public void setReadonly(java.lang.Boolean newReadonly) {
	readonly = newReadonly;
}
public void setRenter(java.lang.Integer newRenter) {
	renter.setInteger(newRenter);
}
public void setRentername(java.lang.String newRentername) {
	rentername = newRentername;
}
public void setStorage(java.lang.Integer newStorage) {
	storage.setInteger(newStorage);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
public void setWorker(java.lang.Integer newWorker) {
	worker.setInteger(newWorker);
}
public void setWorkername(java.lang.String newWorkername) {
	workername = newWorkername;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @param newWorkertitle java.lang.String
 */
public void setWorkertitle(java.lang.String newWorkertitle) {
	workertitle = newWorkertitle;
}
}
