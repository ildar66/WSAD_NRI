package com.hps.july.dictionary.formbean;

/**
 * ����� ������ ������ ���������
 */
public class UnitListForm extends com.hps.july.web.util.BrowseForm {
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public UnitListForm() {
	this.setFinderMethodName( "findAll" );
	setLastVisited(true);
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
	return new Object[] { };
}
}
