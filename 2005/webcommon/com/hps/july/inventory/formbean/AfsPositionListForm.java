package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк акта монтажа АФС.
 */
public class AfsPositionListForm 
	extends com.hps.july.web.util.BrowseForm
{
	private StringAndIntegerProperty document;

	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	
	private StringAndSqlDateProperty blankdate;

	private StringAndIntegerProperty owner;
	private String ownername;

	private StringAndIntegerProperty position;
	private String positionid;
	private String positionname;

	private StringAndIntegerProperty complect;
	private String complectmodel;
	private String complectname;

	private String type;
	
	private StringAndIntegerProperty provider;
	private String providername;
	private String insuranseMan;

	private StringAndIntegerProperty worker;
	private String workername;
	private String workertitle;

	private java.lang.Boolean readonly;
	private Integer expedition;

	private String antennaType;
public AfsPositionListForm() {
	document = new StringAndIntegerProperty();
	blanknumber = null;
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	owner = new StringAndIntegerProperty();
	ownername = null;
	position = new StringAndIntegerProperty();
	positionid = null;
	positionname = null;
	provider = new StringAndIntegerProperty();
	providername = null;
	insuranseMan = null;
	worker = new StringAndIntegerProperty();
	complect = new StringAndIntegerProperty();
	complectname = "";
	complectmodel = "";

	readonly = Boolean.FALSE;

	this.setFinderMethodName( "listAfsMountItems" );
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getAntennaType() {
	return antennaType;
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
public java.lang.Integer getComplect() {
	return complect.getInteger();
}
public java.lang.String getComplectname() {
	return complectname;
}
public Integer getDocument() {
	return document.getInteger();
}
public String getDocumentstr() {
	return document.getString();
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("TechStuff");
	roles.add("siteExploitor");
	roles.add("siteStation");
	roles.add("siteTransport");
	return roles;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getExpedition() {
	return expedition;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		document.getInteger()
	};
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
public java.lang.Integer getPosition() {
	return position.getInteger();
}
public java.lang.String getPositionid() {
	return positionid;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 16:56:52)
 * @return java.lang.String
 */
public java.lang.String getPositionname() {
	return positionname;
}
public java.lang.Integer getProvider() {
	return provider.getInteger();
}
public java.lang.String getProvidername() {
	return providername;
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
public java.util.Iterator listCableItems(Integer parentpos)
{
	com.hps.july.cdbc.objects.CDBCDocuments d = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = d.listAfsMountCableItems(parentpos);
	return rs.listIterator();
}
/**
 * 
 * @param newAntennaType java.lang.String
 */
public void setAntennaType(java.lang.String newAntennaType) {
	antennaType = newAntennaType;
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
public void setComplect(java.lang.Integer newStorage) {
	complect.setInteger(newStorage);
}
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
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
 * 
 * @param newExpedition java.lang.Integer
 */
public void setExpedition(java.lang.Integer newExpedition) {
	expedition = newExpedition;
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
public void setPosition(java.lang.Integer newPosition) {
	position.setInteger(newPosition);
}
public void setPositionid(java.lang.String newPositionid) {
	positionid = newPositionid;
}
public void setPositionname(java.lang.String newPositionname) {
	positionname = newPositionname;
}
public void setProvider(java.lang.Integer newProvider) {
	provider.setInteger(newProvider);
}
public void setProvidername(java.lang.String newProvidername) {
	providername = newProvidername;
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
