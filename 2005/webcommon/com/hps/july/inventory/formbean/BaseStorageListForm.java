package com.hps.july.inventory.formbean;

import com.hps.july.web.util.*;
import com.hps.july.persistence.*;
import org.apache.struts.action.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Базовая форма списка документов по складам.
 */
public abstract class BaseStorageListForm 
	extends com.hps.july.web.util.BrowseForm
{
	private StringAndSqlDateProperty datefrom;
	private StringAndSqlDateProperty dateto;
	private java.lang.Boolean isowner;
	private StringAndIntegerProperty owner;
	private String ownername;
	private java.lang.Boolean isstorage;
	private StringAndIntegerProperty storage;
	private String storagename;

	private Integer sortType = new Integer(1);

	private Boolean _isadmin;
	private String _username;

	private java.util.Vector storages = new java.util.Vector();
	private boolean useStorageCombo;
public BaseStorageListForm() {
	setLastVisited(true);
	datefrom = new StringAndSqlDateProperty();
	java.util.Calendar c = java.util.Calendar.getInstance();
	c.setTime(new java.util.Date());
	c.set(java.util.Calendar.DAY_OF_MONTH,1);
	datefrom.setSqlDate(new java.sql.Date(c.getTime().getTime()));
	dateto = new StringAndSqlDateProperty();
	dateto.setSqlDate(new java.sql.Date(new java.util.Date().getTime()));
	isowner = Boolean.FALSE;
	isstorage = Boolean.FALSE;
	storage = new StringAndIntegerProperty();
	storagename = "";
	owner = new StringAndIntegerProperty();
	ownername = "";
	try {
		java.util.Enumeration eno = getOwners();
		if (eno.hasMoreElements()) {
			try {
				OrganizationAccessBean org = (OrganizationAccessBean)eno.nextElement();
				owner.setInteger(new Integer(org.getOrganization()));
			} catch (Exception ex) {
			}
		}
	} catch(Exception e) {
	}

	try {	
		java.util.Enumeration en = getStorages();
		if (en.hasMoreElements()) {
			try {
				StorageAccessBean stor = (StorageAccessBean)en.nextElement();
				storage.setInteger(new Integer(stor.getStorageplace()));
			} catch (Exception ex) {
			}
		}
	} catch(Exception e) {
	}
	sortType = new Integer(1);
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean get_isadmin() {
	return _isadmin;
}
public java.lang.String get_username() {
	return (_username == null)?"":_username;
}
public String getBrowseBeanName() {
	return "com.hps.july.cdbc.objects.CDBCDocuments";
}
public java.sql.Date getDatefrom() {
	return datefrom.getSqlDate();
}
public String getDatefromstr() {
	return datefrom.getString();
}
public java.sql.Date getDateto() {
	return dateto.getSqlDate();
}
public String getDatetostr() {
	return dateto.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.09.2002 11:48:56)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("StorageManager");
	return roles;
}
public java.lang.Boolean getIsowner() {
	return isowner;
}
public java.lang.Boolean getIsstorage() {
	return isstorage;
}
public Integer getOrderBy() {
	if(sortType == null) {
		sortType = new Integer(1);
	}
	return sortType;
}
public StringAndIntegerProperty getOwner() {
	return owner;
}
public String getOwnercode() {
	return owner.getString();
}
public java.lang.String getOwnername() {
	return ownername;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 16:12:47)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getOwners() {
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		return bean.findOurOrganizations();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
public StringAndIntegerProperty getStorage() {
	return storage;
}
public String getStoragecode() {
	return storage.getString();
}
public java.lang.String getStoragename() {
	return storagename;
}
/**
 * Insert the method's description here.
 * Creation date: (18.06.2002 16:12:27)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getStorages() {
	return storages.elements();
}
public boolean getUseStorageCombo() {
	return useStorageCombo;
}
public ActionForward initBrowse(ActionMapping mapping, HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException
{
	String s = super.getFinderMethodName();
	try {
		sortType = Integer.valueOf(s);
	} catch (NumberFormatException e) {
	}

	_isadmin = new Boolean(request.isUserInRole("administrator"));
	_username = request.getRemoteUser();
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
		com.hps.july.cdbc.lib.CDBCResultSet rs = d.listStoragesFor(_isadmin,_username);
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
public void setDatefrom(java.sql.Date newDate) {
	datefrom.setSqlDate(newDate);
}
public void setDatefromstr(String newDate) {
	datefrom.setString(newDate);
}
public void setDateto(java.sql.Date newDate) {
	dateto.setSqlDate(newDate);
}
public void setDatetostr(String newDate) {
	dateto.setString(newDate);
}
public void setIsowner(java.lang.Boolean newIsowner) {
	isowner = newIsowner;
}
public void setIsstorage(java.lang.Boolean newIsstorage) {
	isstorage = newIsstorage;
}
public void setOwnercode(String newOwner) {
	owner.setString(newOwner);
}
public void setOwnername(java.lang.String newOwnername) {
	ownername = newOwnername;
}
public void setStoragecode(java.lang.String newNumber) {
	storage.setString(newNumber);
}
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
}
