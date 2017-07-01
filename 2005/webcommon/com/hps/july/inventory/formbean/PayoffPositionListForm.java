package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк документа "Акт списания"
 */
public class PayoffPositionListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndIntegerProperty document;

	private String blanknumber;
	private int blankindex;
	private StringAndSqlDateProperty blankdate;

	private StringAndIntegerProperty owner;
	private String ownername;

	private StringAndIntegerProperty storage;
	private String storagename;

	private java.lang.Boolean readonly;
public PayoffPositionListForm() {
	document = new StringAndIntegerProperty();
	blanknumber = null;
	blankdate = new StringAndSqlDateProperty();
	owner = new StringAndIntegerProperty();
	ownername = null;
	storage = new StringAndIntegerProperty();
	storagename = null;

	readonly = Boolean.FALSE;

	this.setFinderMethodName( "findDocPositionsByDocOrderByOrderAsc" );
}
public java.sql.Date getBlankdate() {
	return blankdate.getSqlDate();
}
public String getBlankdatestr() {
	return blankdate.getString();
}
/**
 * 
 * @return int
 */
public int getBlankindex() {
	return blankindex;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
public Integer getDocument() {
	return document.getInteger();
}
public String getDocumentstr() {
	return document.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:27:51)
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
		document.getInteger()
	};
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
public void setBlankdate(java.sql.Date newDate)
{
	blankdate.setSqlDate(newDate);
}
public void setBlankdatestr(String newDate)
{
	blankdate.setString(newDate);
}
/**
 * 
 * @param newBlankindex int
 */
public void setBlankindex(int newBlankindex) {
	blankindex = newBlankindex;
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
public void setDocument(Integer newDocument)
{
	document.setInteger(newDocument);
}
public void setDocumentstr(String newDate)
{
	document.setString(newDate);
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
}
