package com.hps.july.siteinfo.formbean;

/**
 * Форма выбора сотрудника
 */
public class WorkerLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String lastname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerLookupListForm() {
	this.setFinderMethodName( "findByLastNameOrderByLastNameAsc" );
	lastname = "";
	}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { lastname };
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
