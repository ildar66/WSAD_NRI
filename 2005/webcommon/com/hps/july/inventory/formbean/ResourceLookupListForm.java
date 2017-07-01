package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора оборудования из справочника
 */
public class ResourceLookupListForm extends com.hps.july.web.util.BrowseForm {
	protected Integer resourcesubtype;
	private String resourcesubtypename;
	private Integer resourcetype;
	protected Boolean isResourcetype;
	private String resourcetypename;
	protected String searchtype;
	protected Boolean isSign;
	private String sign;
	protected Boolean isName;
	private String name;
	protected Boolean isManufid;
	protected Integer manufid;
	private String manufacturername;
	protected Boolean isManucode;
	private String manucode;
	private Boolean isNfscode;
	private String nfscode;
	
public ResourceLookupListForm() {
//	this.setFinderMethodName( "findResourcesByQBE2" );
	this.setFinderMethodName("findResources");
	searchtype = "C";
	isManucode = Boolean.FALSE;
	isManufid = Boolean.FALSE;
	isName = Boolean.FALSE;
	isResourcetype = Boolean.FALSE;
	isSign = Boolean.TRUE;
	isNfscode = Boolean.FALSE;
	nfscode = "";
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		isResourcetype.booleanValue()?Boolean.TRUE:Boolean.FALSE, (resourcesubtype != null)?new ResourceSubTypeKey(resourcesubtype.intValue()):new ResourceSubTypeKey(0),
		isSign.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getSign() != null)?getSign():"",
		isName.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getName() != null)?getName():"",
		isManufid.booleanValue() ? Boolean.TRUE : Boolean.FALSE, (manufid != null) ? manufid : new Integer(0),
		isManucode.booleanValue() ? Boolean.TRUE : Boolean.FALSE, (getManucode() != null) ? getManucode() : "",
		new Integer(1),
		isNfscode, nfscode
	};
	/*
	if("S".equals(searchtype)) {
		return new Object[] { 
			Boolean.FALSE, new ResourceSubTypeKey(0),
			Boolean.TRUE, (getSign() != null)?getSign():"",
			Boolean.FALSE, "",
			new Integer(1)
		};
	} else
	if("N".equals(searchtype)) {
		return new Object[] { 
			Boolean.FALSE, new ResourceSubTypeKey(0),
			Boolean.FALSE, "",
			Boolean.TRUE, (getName() != null)?getName():"",
			new Integer(1)
		};
	} else {
		return new Object[] { 
			Boolean.TRUE, new ResourceSubTypeKey(getResourcesubtype().intValue()),
			Boolean.FALSE, "",
			Boolean.FALSE, "",
			new Integer(1)
		};
	}
	*/
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManucode() {
	return isManucode;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManufid() {
	return isManufid;
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
public java.lang.Integer getManufid() {
	return manufid;
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
public void setIsManufid(java.lang.Boolean newIsManufid) {
	isManufid = newIsManufid;
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
public void setManufid(java.lang.Integer newManufid) {
	manufid = newManufid;
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

/**
 * @return
 */
public Boolean getIsNfscode() {
	return isNfscode;
}

/**
 * @return
 */
public String getNfscode() {
	return nfscode;
}

/**
 * @param boolean1
 */
public void setIsNfscode(Boolean boolean1) {
	isNfscode = boolean1;
}

/**
 * @param string
 */
public void setNfscode(String string) {
	nfscode = string;
}

}
