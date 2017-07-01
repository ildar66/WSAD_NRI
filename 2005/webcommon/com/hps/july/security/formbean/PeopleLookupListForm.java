package com.hps.july.security.formbean;

/**
 * Форма lookup по выбору физического лица.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class PeopleLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String lastname;
	private int order;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public PeopleLookupListForm() {
	this.setFinderMethodName("1");
	lastname = "";
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	try {
		order = Integer.parseInt(super.getFinderMethodName());
	} catch (NumberFormatException e) {}
	
	return new Object[] { new Boolean(true), getLastname(), new Integer(1),	// Boolean isLastName, String lastName, Integer argConnected
		new Boolean(true), new Boolean(true),	// Boolean isIsActive, Boolean isActive
		new Integer(order) };	// Integer order
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findByQBE";
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 11:20:12)
 * @return java.lang.String
 */
public java.lang.String getLastname() {
	return lastname;
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 11:20:12)
 * @param newLastname java.lang.String
 */
public void setLastname(java.lang.String newLastname) {
	lastname = newLastname;
}
}
