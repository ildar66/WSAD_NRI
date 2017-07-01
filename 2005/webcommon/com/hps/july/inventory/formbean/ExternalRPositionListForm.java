package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * ‘орма списка строк документа "¬нешн€€ расходна€ накладна€"
 */
public class ExternalRPositionListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndIntegerProperty document;

	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	private StringAndSqlDateProperty blankdate;

	private StringAndIntegerProperty owner;
	private String ownername;

	private StringAndIntegerProperty storage;
	private String storagename;

	private String type;
	
	private String recipientname;
	private String insuranseMan;
	private String insuranceact;
	private StringAndSqlDateProperty insurancedate;

	private String currencyshortname;

	private java.lang.Boolean readonly;
public ExternalRPositionListForm() {
	document = new StringAndIntegerProperty();
	blanknumber = null;
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	owner = new StringAndIntegerProperty();
	ownername = null;
	storage = new StringAndIntegerProperty();
	storagename = null;
	recipientname = null;
	insurancedate = new StringAndSqlDateProperty();

	readonly = Boolean.FALSE;

	//this.setFinderMethodName( "findDocumentPositionByDocument" );
	this.setFinderMethodName( "findDocPositionsByDocOrderByOrderAsc" );
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
 * @return java.lang.String
 */
public java.lang.String getCurrencyshortname() {
	return currencyshortname;
}
public Integer getDocument() {
	return document.getInteger();
}
public String getDocumentstr() {
	return document.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:26:29)
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
 * Creation date: (26.06.2002 10:41:56)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getReadonly() {
	return readonly;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 17:22:44)
 * @return java.lang.String
 */
public java.lang.String getRecipientname() {
	return recipientname;
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
 * @param newCurrencyshortname java.lang.String
 */
public void setCurrencyshortname(java.lang.String newCurrencyshortname) {
	currencyshortname = newCurrencyshortname;
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
 * Creation date: (26.06.2002 10:41:56)
 * @param newReadonly java.lang.Boolean
 */
public void setReadonly(java.lang.Boolean newReadonly) {
	readonly = newReadonly;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 17:22:44)
 * @param newRecipientname java.lang.String
 */
public void setRecipientname(java.lang.String newRecipientname) {
	recipientname = newRecipientname;
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
}
