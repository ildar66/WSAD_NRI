package com.hps.july.dictionary.formbean;

/**
 * Форма списка автомобилей дирекции (отдела, группы)
 */
public class CarsList extends com.hps.july.web.util.BrowseForm {
	private int organization;
	private String organizationname;
/**
 * DirectionCarsList constructor comment.
 */
public CarsList() {
	setFinderMethodName("findByQBE");
}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictPartAdmin");
	roles.add("dictPartOperator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (21.07.2003 18:29:27)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { new Boolean(true), new Integer(getOrganization()), new Boolean(false), new Integer(0), new Integer(1) };
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 15:26:31)
 * @return int
 */
public int getOrganization() {
	return organization;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 15:27:06)
 * @return java.lang.String
 */
public java.lang.String getOrganizationname() {
	return organizationname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 15:26:31)
 * @param newOrganization int
 */
public void setOrganization(int newOrganization) {
	organization = newOrganization;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 15:27:06)
 * @param newOrganizationname java.lang.String
 */
public void setOrganizationname(java.lang.String newOrganizationname) {
	organizationname = newOrganizationname;
}
}
