package com.hps.july.dictionary.formbean;

/**
 * Форма списка наборов в которых используется указанное оборудование
 */
public class ComplectForListForm extends com.hps.july.web.util.BrowseForm {
	private int resource;
	private java.lang.String resourcename;
	private java.lang.String resourcemodel;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ComplectForListForm() {
	this.setFinderMethodName( "findComplectpartsByParts" );
	}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	//roles.add("dictResOperator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new com.hps.july.persistence.ResourceKey(getResource()) };
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 12:00:06)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 9:02:50)
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 13:10:14)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 12:00:06)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 9:02:50)
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 13:10:14)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
}
