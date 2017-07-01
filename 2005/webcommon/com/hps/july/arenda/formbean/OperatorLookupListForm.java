package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Форма "поиск операторов".
 * Creation date: (27.09.2002 12:53:16)
 * @author: Sergey Gourov
 */
public class OperatorLookupListForm extends com.hps.july.web.util.BrowseForm {
	private java.lang.String lastname;
/**
 * OperatorLookupListForm constructor comment.
 */
public OperatorLookupListForm() {
	super();
	this.setFinderMethodName("findOperatorByLastNameOrderByLoginAsc");
	lastname = "";
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2002 12:53:16)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { lastname };
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2002 12:55:04)
 * @return java.lang.String
 */
public java.lang.String getLastname() {
	return lastname;
}
/**
 * Insert the method's description here.
 * Creation date: (27.09.2002 12:55:04)
 * @param newLastname java.lang.String
 */
public void setLastname(java.lang.String newLastname) {
	lastname = newLastname;
}
}
