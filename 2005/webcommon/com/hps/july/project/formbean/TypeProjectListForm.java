package com.hps.july.project.formbean;

/**
 * Форма списка типов проектов.
 * Creation date: (25.09.2002 19:26:04)
 * @author: Maksim Gerasimov
 */
public class TypeProjectListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String dateFrm;
/**
 * TypeProjectListForm constructor comment.
 */
public TypeProjectListForm() {
	setFinderMethodName("findAllOrderByCodeAsc");
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2002 18:26:15)
 * @return java.lang.String
 */
public java.lang.String getDateFrm() {
	return dateFrm;
}
/**
 * Insert the method's description here.
 * Creation date: (25.09.2002 19:26:04)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
/**
 * Insert the method's description here.
 * Creation date: (24.10.2002 18:26:15)
 * @param newDateFrm java.lang.String
 */
public void setDateFrm(java.lang.String newDateFrm) {
	dateFrm = newDateFrm;
}
}
