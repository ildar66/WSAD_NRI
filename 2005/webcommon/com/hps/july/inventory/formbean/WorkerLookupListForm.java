package com.hps.july.inventory.formbean;

/**
 * Форма выбора работника по указанной организации
 * с фильтром по фамилии
 */
public class WorkerLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String lastname;
	private Boolean showdivision;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public WorkerLookupListForm() {
//	this.setFinderMethodName( "findByLastNameOrderByLastNameAsc" );
//	this.setFinderMethodName( "findWorkerByLastNameOrderByLastNameAsc" );
	this.setFinderMethodName( "findWorkerByLastName" );
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
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getShowdivision() {
	return showdivision;
}
/**
 * Insert the method's description here.
 * Creation date: (23.02.2002 11:20:12)
 * @param newLastname java.lang.String
 */
public void setLastname(java.lang.String newLastname) {
	lastname = newLastname;
}
/**
 * 
 * @param newShowdivision java.lang.Boolean
 */
public void setShowdivision(java.lang.Boolean newShowdivision) {
	showdivision = newShowdivision;
}
}
