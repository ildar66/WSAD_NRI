package com.hps.july.inventory.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора оборудования из справочника
 */
public class ResourceLookupBySerialListForm extends ResourceLookupListForm {
	private java.lang.Boolean isSerial;
	private java.lang.String serial;
public ResourceLookupBySerialListForm() {
	this.setFinderMethodName("findResourcesBySerial");
	searchtype = "C";
	isManucode = Boolean.FALSE;
	isManufid = Boolean.FALSE;
	isName = Boolean.FALSE;
	isResourcetype = Boolean.FALSE;
	isSign = Boolean.FALSE;
	isSerial = Boolean.TRUE;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		isResourcetype.booleanValue()?Boolean.TRUE:Boolean.FALSE, (resourcesubtype != null)?new ResourceSubTypeKey(resourcesubtype.intValue()):new ResourceSubTypeKey(0),
		isSign.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getSign() != null)?getSign():"",
		isName.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getName() != null)?getName():"",
		isManufid.booleanValue()?Boolean.TRUE:Boolean.FALSE, (manufid != null) ? manufid : new Integer(0),
		isManucode.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getManucode() != null) ? getManucode() : "",
		isSerial.booleanValue()?Boolean.TRUE:Boolean.FALSE, (getSerial() != null)?getSerial():"",
		new Integer(1)
	};	
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:35:10)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSerial() {
	return isSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:35:38)
 * @return java.lang.String
 */
public java.lang.String getSerial() {
	return serial;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:35:10)
 * @param newIsSerial java.lang.Boolean
 */
public void setIsSerial(java.lang.Boolean newIsSerial) {
	isSerial = newIsSerial;
}
/**
 * Insert the method's description here.
 * Creation date: (21.06.2005 18:35:38)
 * @param newSerial java.lang.String
 */
public void setSerial(java.lang.String newSerial) {
	serial = newSerial;
}
}
