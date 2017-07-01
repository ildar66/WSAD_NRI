package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк документа "Акт демонтажа блоков на позиции"
 */
public class DAssactposBListForm
	extends com.hps.july.web.util.BrowseForm
{
	private Integer document;

	private String blanknumber;
	private int blankindex;
	private java.sql.Date blankdate;

	private Integer owner;
	private String ownername;

	private Integer position;
	private String positionname;
	private String positionid;
	private Integer complect;
	private String complectname;

	private String type;
	
	private java.lang.Boolean readonly;
	private java.lang.Integer agregate;
	private String agregateserial;
	private java.lang.String agregatename;
	private Integer storageplace;
public DAssactposBListForm() {
	document = new Integer(0);
	blanknumber = "";
	blankindex = 0;
	owner = new Integer(0);
	ownername = "";
	position = new Integer(0);
	positionname = "";
	positionid = "";
	complect = new Integer(0);
	complectname = "";
	storageplace = new Integer(0);

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
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAgregateserial() {
	return agregateserial;
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
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:03:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getComplect() {
	return complect;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:03:08)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
public Integer getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:14:32)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("TechStuff");
	roles.add("siteExploitor");
	roles.add("siteStation");
	roles.add("siteTransport");
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
 * Creation date: (15.08.2002 17:03:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getPosition() {
	return position;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:03:08)
 * @return java.lang.String
 */
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:03:08)
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
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getStorageplace() {
	return storageplace;
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
/**
 * 
 * @param newAgregateserial java.lang.String
 */
public void setAgregateserial(java.lang.String newAgregateserial) {
	agregateserial = newAgregateserial;
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
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:03:08)
 * @param newComplect java.lang.Integer
 */
public void setComplect(java.lang.Integer newComplect) {
	complect = newComplect;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:03:08)
 * @param newComplectname java.lang.String
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
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
 * Creation date: (15.08.2002 17:03:08)
 * @param newPosition java.lang.Integer
 */
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:03:08)
 * @param newPositionid java.lang.String
 */
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
/**
 * Insert the method's description here.
 * Creation date: (15.08.2002 17:03:08)
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
/**
 * 
 * @param newStorageplace java.lang.Integer
 */
public void setStorageplace(java.lang.Integer newStorageplace) {
	storageplace = newStorageplace;
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
