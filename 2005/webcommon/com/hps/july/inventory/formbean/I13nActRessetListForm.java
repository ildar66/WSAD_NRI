package com.hps.july.inventory.formbean;

/**
 * Форма списка набора оборудования по которому производится инвентаризация на складе
 */
public class I13nActRessetListForm extends I13nRessetListForm {
/**
 * I13nActRessetListForm constructor comment.
 */
public I13nActRessetListForm() {
	super();
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:49:06)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
}
