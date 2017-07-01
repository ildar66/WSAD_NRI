package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк документа "Акт инвентаризации на складе"
 */
public class InvActPosListForm extends com.hps.july.web.util.BrowseForm {
	private int document;
	private java.lang.String type;
	private StringAndSqlDateProperty blankdate;
	private String blanknumber;
	private int blankindex;
	private Integer owner;
	private String ownername;
	private Integer storage;
	private String storagename;
	private boolean readonly;
	private Integer agregate;
	private String agregatemodel;
	private String agregatename;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public InvActPosListForm() {
	this.setFinderMethodName( "findDocPositionsByDocOrderByOrderAsc" );
	blankdate = new StringAndSqlDateProperty();
	type = "F";
	readonly = false;
	agregate = new Integer(0);
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 17:41:49)
 * @return java.lang.Integer
 */
public java.lang.Integer getAgregate() {
	return agregate;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 17:41:49)
 * @return java.lang.String
 */
public java.lang.String getAgregatemodel() {
	return agregatemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 17:41:49)
 * @return java.lang.String
 */
public java.lang.String getAgregatename() {
	return agregatename;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:15:56)
 * @return java.sql.Date
 */
public java.sql.Date getBlankdate() {
	return blankdate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:39:53)
 * @return java.lang.String
 */
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
 * Creation date: (22.05.2002 16:41:42)
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:04:10)
 * @return java.lang.Integer
 */
public int getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:28:30)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	log("getFilterParams called");
	log("getFilterParams return("+getDocument()+")");
	return new Object[] { new Integer(getDocument()) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getOwner() {
	return owner;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @return java.lang.String
 */
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @return java.lang.Integer
 */
public java.lang.Integer getStorage() {
	return storage;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:07:40)
 * @return java.lang.String
 */
public java.lang.String getType() {
	if(type == null)
		return "F";
	else 
		return type;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 12:14:42)
 * @return boolean
 */
public boolean isReadonly() {
	return readonly;
}
public void log(String arg) {
    //System.out.println("*#* InvActPosListForm."+arg);
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 17:41:49)
 * @param newAgregate java.lang.Integer
 */
public void setAgregate(java.lang.Integer newAgregate) {
	agregate = newAgregate;
    log("setAgregate("+newAgregate+")");
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 17:41:49)
 * @param newAgregatemodel java.lang.String
 */
public void setAgregatemodel(java.lang.String newAgregatemodel) {
	agregatemodel = newAgregatemodel;
    log("setAgregatemodel("+newAgregatemodel+")");
}
/**
 * Insert the method's description here.
 * Creation date: (08.08.2002 17:41:49)
 * @param newAgregatename java.lang.String
 */
public void setAgregatename(java.lang.String newAgregatename) {
	agregatename = newAgregatename;
    log("setAgregatename("+newAgregatename+")");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:16:16)
 * @param newDate java.sql.Date
 */
public void setBlankdate(java.sql.Date newDate)
{
	blankdate.setSqlDate(newDate);
    log("setBlankdate("+newDate+")");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:40:20)
 * @param newDate java.lang.String
 */
public void setBlankdatestr(String newDate)
{
	blankdate.setString(newDate);
    log("setBlankdatestr("+newDate+")");
}
/**
 * 
 * @param newBlankindex int
 */
public void setBlankindex(int newBlankindex) {
	blankindex = newBlankindex;
    log("setBlankindex("+newBlankindex+")");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @param newBlanknumber java.lang.String
 */
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
    log("setBlanknumber("+newBlanknumber+")");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:04:10)
 * @param newDocument java.lang.Integer
 */
public void setDocument(int newDocument) {
	document = newDocument;
    log("setDocument("+newDocument+")");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @param newOwner java.lang.Integer
 */
public void setOwner(java.lang.Integer newOwner) {
	owner = newOwner;
    log("setOwner("+newOwner+")");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @param newOwnername java.lang.String
 */
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
    log("setOwnername("+newOwnername+")");
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 12:14:42)
 * @param newReadonly boolean
 */
public void setReadonly(boolean newReadonly) {
	readonly = newReadonly;
    log("setReadonly("+newReadonly+")");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @param newStorage java.lang.Integer
 */
public void setStorage(java.lang.Integer newStorage) {
	storage = newStorage;
    log("setStorage("+newStorage+")");
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:41:42)
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
/**
 * Insert the method's description here.
 * Creation date: (22.05.2002 16:07:40)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
}
