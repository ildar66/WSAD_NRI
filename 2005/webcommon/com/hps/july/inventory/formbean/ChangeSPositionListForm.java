package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;

/**
 * Форма списка строк документа "Акт замены/модернизации на складе"
 */
public class ChangeSPositionListForm
	extends AbstractChangePositionListForm
{
	private String storagename;
	private int storage;
public ChangeSPositionListForm() {
	storagename = null;
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
/**
 * 
 * @return int
 */
public int getStorage() {
	return storage;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
/**
 * 
 * @param newStorage int
 */
public void setStorage(int newStorage) {
	storage = newStorage;
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
}
