package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка набора оборудования по которому производится инвентаризация на позиции
 */
public class I13nRessetListForm extends com.hps.july.web.util.BrowseForm {
	private int document;
	private java.lang.String type;
	private StringAndSqlDateProperty blankdate;
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	private Integer owner;
	private String ownername;
	private java.lang.Integer position;
	private java.lang.String positionname;
	private java.lang.Integer complect;
	private java.lang.String complectname;
	private boolean readonly;
public I13nRessetListForm() {
	this.setFinderMethodName( "findI13nActResourceSetByI13nAct" );
	blankdate = new StringAndSqlDateProperty();
	blankindex = new StringAndIntegerProperty();
	type = "F";
	readonly = false;
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
public java.lang.String getBlanknumber() {
	return blanknumber;
}
public java.lang.Integer getComplect() {
	return complect;
}
public java.lang.String getComplectname() {
	return complectname;
}
public int getDocument() {
	return document;
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:49:06)
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
	return new Object[] { new com.hps.july.persistence.DocumentKey(getDocument()) };
}
public java.lang.Integer getOwner() {
	return owner;
}
public java.lang.String getOwnername() {
	return ownername;
}
public java.lang.Integer getPosition() {
	return position;
}
public java.lang.String getPositionname() {
	return positionname;
}
public java.lang.String getType() {
	if(type == null)
		return "F";
	else 
		return type;
}
public boolean isReadonly() {
	return readonly;
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
public void setBlanknumber(java.lang.String newBlanknumber) {
	blanknumber = newBlanknumber;
}
public void setComplect(java.lang.Integer newComplect) {
	complect = newComplect;
}
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
public void setDocument(int newDocument) {
	document = newDocument;
}
public void setOwner(java.lang.Integer newOwner) {
	owner = newOwner;
}
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
public void setPosition(java.lang.Integer newPosition) {
	position = newPosition;
}
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
public void setReadonly(boolean newReadonly) {
	readonly = newReadonly;
}
public void setType(java.lang.String newType) {
	type = newType;
}
}
