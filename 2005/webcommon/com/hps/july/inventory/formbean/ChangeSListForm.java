package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Форма списка документов "Акты замены/модернизации на складе"
 */
public class ChangeSListForm extends AbstractChangeListForm {
	private Boolean isstorage;
	private StringAndIntegerProperty storage;
	private String storagename;

	private java.util.Vector storages = new java.util.Vector();
	private boolean useStorageCombo;
public ChangeSListForm() {
	super();
	isstorage = Boolean.FALSE;
	storage = new StringAndIntegerProperty();
	storagename = "";
	this.setFinderMethodName( "listChangeActOnStorageDocuments" );
	setLastVisited(true);
}
public java.lang.String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		Boolean.TRUE, getDatefrom(), getDateto(),
		Boolean.TRUE.equals(getIsowner())?Boolean.FALSE:Boolean.TRUE, (getOwner() == null)?new Integer(0):getOwner(),
		Boolean.TRUE.equals(getIsstorage())?Boolean.FALSE:Boolean.TRUE, (getStorage() == null)?new Integer(0):getStorage(),
		(getActtype() != null)?new Character(getActtype().charAt(0)):new Character('A'),
		get_isadmin(),get_username(),
		getOrderBy()
	};
}
public String getFinderMethodName() {
	return "listChangeActOnStorageDocuments";
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsstorage() {
	return isstorage;
}
public java.lang.Integer getStorage() {
	return storage.getInteger();
}
public String getStoragecode() {
	return storage.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
public java.util.Enumeration getStorages() {
	return storages.elements();
}
public boolean getUseStorageCombo() {
	return useStorageCombo;
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	super.initBrowse(mapping,request,response);
    ParamsParser.setState(request, com.hps.july.constants.Applications.INVENTORY, com.hps.july.inventory.APPStates.CHSLIST);
	if(storage.getInteger() != null) {
		try {
			StorageAccessBean bean = new StorageAccessBean();
			bean.setInitKey_storageplace(storage.getInteger().intValue());
			bean.refreshCopyHelper();
			setStoragename(bean.getName());
		} catch(Exception e) {
		}
	}
	try {
		java.util.Vector ar = new java.util.Vector();
		com.hps.july.cdbc.objects.CDBCDocuments d = new com.hps.july.cdbc.objects.CDBCDocuments();
		com.hps.july.cdbc.lib.CDBCResultSet rs = d.listStoragesFor(get_isadmin(),get_username());
		useStorageCombo = false;
		if(rs.getRowsCount() < 32) {
			useStorageCombo = true;
		}
		java.util.Iterator it = rs.listIterator();
		while(it.hasNext()) {
			com.hps.july.cdbc.lib.CDBCRowObject ro = (com.hps.july.cdbc.lib.CDBCRowObject)it.next();
			com.hps.july.inventory.valueobject.StorageVO vo = new com.hps.july.inventory.valueobject.StorageVO(
				ro.getColumn("storageplace").asObject(),
				ro.getColumn("spname").asString()
			);
			ar.add(vo);
		}
		storages = ar;
	} catch(Exception e) {
		storages = new java.util.Vector();
	}
	return null;
}
/**
 * 
 * @param newIsstorage java.lang.Boolean
 */
public void setIsstorage(java.lang.Boolean newIsstorage) {
	isstorage = newIsstorage;
}
public void setStorage(Integer number) {
	storage.setInteger(number);
}
public void setStoragecode(java.lang.String newStorage) {
	storage.setString(newStorage);
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
}
