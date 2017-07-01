package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора оборудования репитера
 */
public class RepeaterResLookupList
	extends com.hps.july.web.util.BrowseForm
{
	private Integer resourcesubtype;
	private String resourcesubtypename;
	private Integer resourcetype;
	private Boolean isResourcetype;
	private String resourcetypename;
	private String searchtype;
	private Boolean isSign;
	private String sign;
	private Boolean isName;
	private String name;
	private Boolean isManufacturer;
	private Integer manufacturer;
	private String manufacturername;
	private Boolean isManucode;
	private String manucode;
	private java.lang.Boolean islinear;
public RepeaterResLookupList() {
	this.setFinderMethodName("findResourcesByQBE4");
	searchtype = "C";
	isManucode = Boolean.FALSE;
	isManufacturer = Boolean.FALSE;
	isName = Boolean.FALSE;
	isResourcetype = Boolean.FALSE;
	isSign = Boolean.TRUE;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		isResourcetype.booleanValue()?Boolean.TRUE:Boolean.FALSE, (resourcesubtype != null)?new ResourceSubTypeKey(resourcesubtype.intValue()):new ResourceSubTypeKey(0),
		isSign.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getSign() != null)?getSign():"",
		isName.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getName() != null)?getName():"",
		isManufacturer.booleanValue()?Boolean.TRUE:Boolean.FALSE, (manufacturer != null)?manufacturer:new Integer(0),
		isManucode.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getManucode() != null)?getManucode():"",
		Boolean.TRUE, getIslinear(), new Integer(1)	};
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 14:56:27)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIslinear() {
	return islinear;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManucode() {
	return isManucode;
}
public java.lang.Boolean getIsManufacturer() {
	return isManufacturer;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsName() {
	return isName;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsResourcetype() {
	return isResourcetype;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSign() {
	return isSign;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManucode() {
	return manucode;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getManufacturer() {
	return manufacturer;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufacturername() {
	return manufacturername;
}
public java.lang.String getName() {
	return name;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getResourcesubtype() {
	return resourcesubtype;
}
public java.lang.String getResourcesubtypename() {
	return resourcesubtypename;
}
/**
 * 
 * @return java.lang.Integer
 */
public java.lang.Integer getResourcetype() {
	return resourcetype;
}
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
public java.lang.String getSearchtype() {
	return searchtype;
}
public java.lang.String getSign() {
	return sign;
}
/**
 * Insert the method's description here.
 * Creation date: (05.09.2003 14:56:27)
 * @param newIslinear java.lang.Boolean
 */
public void setIslinear(java.lang.Boolean newIslinear) {
	islinear = newIslinear;
}
/**
 * 
 * @param newIsManucode java.lang.Boolean
 */
public void setIsManucode(java.lang.Boolean newIsManucode) {
	isManucode = newIsManucode;
}
/**
 * 
 * @param newIsManufacturer java.lang.Boolean
 */
public void setIsManufacturer(java.lang.Boolean newIsManufacturer) {
	isManufacturer = newIsManufacturer;
}
/**
 * 
 * @param newIsName java.lang.Boolean
 */
public void setIsName(java.lang.Boolean newIsName) {
	isName = newIsName;
}
/**
 * 
 * @param newIsResourcetype java.lang.Boolean
 */
public void setIsResourcetype(java.lang.Boolean newIsResourcetype) {
	isResourcetype = newIsResourcetype;
}
/**
 * 
 * @param newIsSign java.lang.Boolean
 */
public void setIsSign(java.lang.Boolean newIsSign) {
	isSign = newIsSign;
}
/**
 * 
 * @param newManucode java.lang.String
 */
public void setManucode(java.lang.String newManucode) {
	manucode = newManucode;
}
/**
 * 
 * @param newManufacturer java.lang.Integer
 */
public void setManufacturer(java.lang.Integer newManufacturer) {
	manufacturer = newManufacturer;
}
/**
 * 
 * @param newManufacturername java.lang.String
 */
public void setManufacturername(java.lang.String newManufacturername) {
	manufacturername = newManufacturername;
}
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * 
 * @param newResourcesubtype java.lang.Integer
 */
public void setResourcesubtype(java.lang.Integer newResourcesubtype) {
	resourcesubtype = newResourcesubtype;
}
public void setResourcesubtypename(java.lang.String newResourcesubtypename) {
	resourcesubtypename = newResourcesubtypename;
}
/**
 * 
 * @param newResourcetype java.lang.Integer
 */
public void setResourcetype(java.lang.Integer newResourcetype) {
	resourcetype = newResourcetype;
}
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
public void setSearchtype(java.lang.String newSearchtype) {
	searchtype = newSearchtype;
}
public void setSign(java.lang.String newSign) {
	sign = newSign;
}
}
