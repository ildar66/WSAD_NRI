package com.hps.july.dictionary.formbean;

/**
 * Форма выбора группы отдела
 */
public class DGroupLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.Integer department;
	private java.lang.String departmentname;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public DGroupLookupListForm() {
	this.setFinderMethodName( "findByParentOrderByNameAsc" );
	department = new Integer(0);
	}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 13:52:48)
 * @return java.lang.Integer
 */
public java.lang.Integer getDepartment() {
	return department;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 18:16:53)
 * @return java.lang.String
 */
public java.lang.String getDepartmentname() {
	return departmentname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { department };
}
/**
 * Insert the method's description here.
 * Creation date: (27.02.2002 13:52:48)
 * @param newDepartment java.lang.Integer
 */
public void setDepartment(java.lang.Integer newDepartment) {
	department = newDepartment;
}
/**
 * Insert the method's description here.
 * Creation date: (19.04.2002 18:16:53)
 * @param newDepartmentname java.lang.String
 */
public void setDepartmentname(java.lang.String newDepartmentname) {
	departmentname = newDepartmentname;
}
}
