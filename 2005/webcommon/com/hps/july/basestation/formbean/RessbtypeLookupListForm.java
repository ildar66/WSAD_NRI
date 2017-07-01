package com.hps.july.basestation.formbean;

import com.hps.july.persistence.*;

/**
 * Форма выбора типа оборудования
 */
public class RessbtypeLookupListForm extends com.hps.july.web.util.BrowseForm {
	private int resourcetype;
	private java.lang.String resourcetypename;
	private int resourcesubtype;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public RessbtypeLookupListForm() {
	this.setFinderMethodName( "findResourceSubTypeByResourcetype" );
	resourcetype = 0;
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new ResourceTypeKey(resourcetype) };
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 16:00:01)
 * @return int
 */
public int getResourcesubtype() {
	return resourcesubtype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 15:39:06)
 * @return java.lang.Integer
 */
public int getResourcetype() {
	return resourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 15:46:21)
 * @return java.lang.String
 */
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 16:00:01)
 * @param newResourcesubtype int
 */
public void setResourcesubtype(int newResourcesubtype) {
	resourcesubtype = newResourcesubtype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 15:39:06)
 * @param newResourcetype java.lang.Integer
 */
public void setResourcetype(int newResourcetype) {
	resourcetype = newResourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 15:46:21)
 * @param newResourcetypename java.lang.String
 */
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
}
