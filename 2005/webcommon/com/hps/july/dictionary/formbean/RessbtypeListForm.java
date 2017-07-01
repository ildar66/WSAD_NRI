package com.hps.july.dictionary.formbean;

import com.hps.july.persistence.*;

/**
 * Форма списка типов оборудования
 */
public class RessbtypeListForm extends com.hps.july.web.util.BrowseForm {
	private int resourcetype;
	private java.lang.String resourcetypename;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public RessbtypeListForm() {
	this.setFinderMethodName( "findResourceSubTypeByResourcetype" );
	resourcetype = 0;
	}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.ResourceTypeKey(resourcetype) };
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:25:56)
 * @return int
 */
public int getResourcetype() {
	return resourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:25:24)
 * @return java.lang.String
 */
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:25:56)
 * @param newCompany int
 */
public void setResourcetype(int newResourcetype) {
	resourcetype = newResourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:25:24)
 * @param newResourcetypename java.lang.String
 */
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
}
