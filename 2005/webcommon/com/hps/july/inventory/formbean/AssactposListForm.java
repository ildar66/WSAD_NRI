package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк документа "Акт монтажа блоков на складе"
 */
public class AssactposListForm
	extends com.hps.july.web.util.BrowseForm
{
	private Integer document;

	private String blanknumber;
	private int blankindex;
	private java.sql.Date blankdate;

	private Integer owner;
	private String ownername;

	private Integer storage;
	private String storagename;

	private String type;
	
	private java.lang.Boolean readonly;
	private java.lang.Integer agregate;
	private java.lang.String agregatename;
public AssactposListForm() {
	document = new Integer(0);
	blanknumber = "";
	blankindex = 0;
	owner = new Integer(0);
	ownername = "";
	storage = new Integer(0);
	storagename = "";

	readonly = Boolean.FALSE;

	this.setFinderMethodName( "findDocPositionsByDocOrderByOrderAsc" );
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 11:10:51)
 * @return java.lang.Integer
 */
public java.lang.Integer getAgregate() {
	return agregate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 11:11:26)
 * @return java.lang.String
 */
public java.lang.String getAgregatename() {
	return agregatename;
}
public java.sql.Date getBlankdate() {
	return blankdate;
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
	return document;
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		(document != null)?document:new Integer(0)
	};
}
public java.lang.Integer getOwner() {
	return owner;
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
	return storage;
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
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 11:10:51)
 * @param newAgregate java.lang.Integer
 */
public void setAgregate(java.lang.Integer newAgregate) {
	agregate = newAgregate;
}
/**
 * Insert the method's description here.
 * Creation date: (25.07.2002 11:11:26)
 * @param newAgregatename java.lang.String
 */
public void setAgregatename(java.lang.String newAgregatename) {
	agregatename = newAgregatename;
}
public void setBlankdate(java.sql.Date newDate)
{
	blankdate = newDate;
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
	document = newDocument;
}
public void setOwner(java.lang.Integer newOwner) {
	owner = newOwner;
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
	storage = newStorage;
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
