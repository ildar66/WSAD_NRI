package com.hps.july.security.formbean;

/**
 * Форма множественного выбора ролей.
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class RoleMultiListForm extends com.hps.july.web.util.BrowseForm {
	private String[] selectedRole;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public RoleMultiListForm() {
	this.setFinderMethodName( "findAll" );
	selectedRole = new String [0];	
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	return roles;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {  };
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 10:22:48)
 * @return int[]
 */
public String[] getSelectedRole() {
	return selectedRole;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 10:22:48)
 * @param newSelectedOrg int[]
 */
public void setSelectedRole(String[] newSelectedRole) {
	selectedRole = newSelectedRole;
}
}
