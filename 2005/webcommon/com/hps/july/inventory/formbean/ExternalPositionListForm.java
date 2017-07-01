package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк документа "Внешний приходный ордер"
 */
public class ExternalPositionListForm extends com.hps.july.web.util.BrowseForm {
	private StringAndIntegerProperty document;
	private StringAndIntegerProperty owner;
	private String ownername;
	private StringAndIntegerProperty storage;
	private String storagename;
	private String blanknumber;
	private StringAndIntegerProperty blankindex;
	private StringAndSqlDateProperty blankdate;
	private String cordocnum;
	private StringAndSqlDateProperty cordocdate;
	private String gtdnumber;
	private StringAndSqlDateProperty gtddate;
	private StringAndIntegerProperty supplier;
	private String suppliername;
	private StringAndBigDecimalProperty byfactsum;
	private StringAndBigDecimalProperty bydocsum;
	private StringAndIntegerProperty currency;
	private String currencyshortname;
	private java.lang.Boolean readonly;
public ExternalPositionListForm() {
	document = new StringAndIntegerProperty();
	owner = new StringAndIntegerProperty();
	ownername = null;
	storage = new StringAndIntegerProperty();
	storagename = null;
	blanknumber = null;
	blankindex = new StringAndIntegerProperty();
	blankdate = new StringAndSqlDateProperty();
	cordocnum = null;
	cordocdate = new StringAndSqlDateProperty();
	gtdnumber = null;
	gtddate = new StringAndSqlDateProperty();
	supplier = new StringAndIntegerProperty();
	suppliername = null;
	byfactsum = new StringAndBigDecimalProperty();
	bydocsum = new StringAndBigDecimalProperty();
	currency = new StringAndIntegerProperty();
	currencyshortname = null;
	this.setFinderMethodName( "findByInWayBillOrderByOrderAsc" );
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
public java.math.BigDecimal getBydocsum() {
	return bydocsum.getBigDecimal();
}
public String getBydocsumstr() {
	return bydocsum.getString();
}
public java.math.BigDecimal getByfactsum() {
	return byfactsum.getBigDecimal();
}
public String getByfactsumstr() {
	return byfactsum.getString();
}
public java.sql.Date getCordocdate() {
	return cordocdate.getSqlDate();
}
public String getCordocdatestr() {
	return cordocdate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getCordocnum() {
	return cordocnum;
}
public java.lang.Integer getCurrecny() {
	return currency.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:59:33)
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
 * Creation date: (10.09.2002 11:17:51)
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
public java.sql.Date getGtddate() {
	return gtddate.getSqlDate();
}
public String getGtddatestr() {
	return gtddate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getGtdnumber() {
	return gtdnumber;
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
public java.lang.Integer getSupplier() {
	return supplier.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @return java.lang.String
 */
public java.lang.String getSuppliername() {
	return suppliername;
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
public void setBydocsum(java.math.BigDecimal newSum)
{
	bydocsum.setBigDecimal(newSum);
}
public void setBydocsumstr(String newSum)
{
	bydocsum.setString(newSum);
}
public void setByfactsum(java.math.BigDecimal newSum)
{
	byfactsum.setBigDecimal(newSum);
}
public void setByfactsumstr(String newSum)
{
	byfactsum.setString(newSum);
}
public void setCordocdate(java.sql.Date newDate)
{
	cordocdate.setSqlDate(newDate);
}
public void setCordocdatestr(String newDate)
{
	cordocdate.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newCordocnum java.lang.String
 */
public void setCordocnum(java.lang.String newCordocnum) {
	cordocnum = newCordocnum;
}
public void setCurrency(Integer newCurrency)
{
	currency.setInteger(newCurrency);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:59:33)
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
public void setGtddate(java.sql.Date newDate)
{
	gtddate.setSqlDate(newDate);
}
public void setGtddatestr(String newDate)
{
	gtddate.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newGtdnumber java.lang.String
 */
public void setGtdnumber(java.lang.String newGtdnumber) {
	gtdnumber = newGtdnumber;
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
public void setSupplier(java.lang.Integer newSupplier) {
	supplier.setInteger(newSupplier);
}
/**
 * Insert the method's description here.
 * Creation date: (25.06.2002 15:37:35)
 * @param newSuppliername java.lang.String
 */
public void setSuppliername(java.lang.String newSuppliername) {
	suppliername = newSuppliername;
}
}
