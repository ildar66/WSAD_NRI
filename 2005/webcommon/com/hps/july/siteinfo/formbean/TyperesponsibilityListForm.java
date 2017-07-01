package com.hps.july.siteinfo.formbean;

/**
 * Форма списка типов ответственности
 */
public class TyperesponsibilityListForm extends com.hps.july.web.util.BrowseForm {
	/**
	 * Insert the method's description here.
	 * Creation date: (22.01.2002 13:30:34)
	 */
	public TyperesponsibilityListForm() {
		this.setFinderMethodName( "findAllOrderByCodeAsc" );
		setLastVisited(true);
	}
/**
 * Insert the method's description here.
 * Creation date: (27.06.2002 16:47:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("supregAdmin");
	roles.add("regionAdmin");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] { };
}
}
