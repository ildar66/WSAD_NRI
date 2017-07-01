package com.hps.july.inventory.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.Enumeration;
import java.util.Calendar;
import java.util.Vector;

/**
 * Форма ввода и редактирования шапки документа "Акт замены/модернизации на складе"
 */
public class ChangeSForm
	extends AbstractChangeForm
{
	private StringAndIntegerProperty storage;
	private String storagename;
	private StringAndIntegerProperty storageman;
	private String storagemanname;
	private String storagemantitle;
	private StringAndIntegerProperty techman;
	private String techmanname;
	private String techmantitle;
public ChangeSForm() {
	super();
	storage = new StringAndIntegerProperty();
	storagename = "";
	storageman = new StringAndIntegerProperty();
	storagemanname = "";
	storagemantitle = "";
}
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	super.afterUpdate(bean,request);
	if("Add".equals(getAction())) {
		setAction("Edit");
	}
}
public WorkerAccessBean constructWorkers() {

	WorkerAccessBean workers = null;
	if (!storageman.isEmpty() && storageman.isOk()) {
		try {
			workers = new WorkerAccessBean();
			workers.setInitKey_worker(storageman.getInteger().intValue());
			workers.refreshCopyHelper();
		} catch(Exception e) {
		}
	}
	return workers;
}
public void fillRecord(AbstractEntityAccessBean bean) {
	super.fillRecord(bean);
	ChangeActAccessBean ab = (ChangeActAccessBean)bean;
	try {
		WorkerAccessBean w = ab.getStorageManager();
		if(w != null) {
			try {
				storageman.setInteger(new Integer(w.getWorker()));
				storagemanname = w.getMan().getFullName();
				storagemantitle = w.getPosition().getName();
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}
		// Storage
		StoragePlaceAccessBean s = ab.getFrom(); // to = from
		if(s != null) {
			try {
				StorageAccessBean es = new StorageAccessBean();
				es.setInitKey_storageplace(s.getStorageplace());
				es.refreshCopyHelper();
				storagename = es.getName();
			} catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}
	} catch(Exception e) {
	}
}
/**
 * getFormName method comment.
 */
protected java.lang.String getFormName() {
	return "ChangeSListForm";
}
protected java.lang.Integer getFromKey() {
	return getStorage();
}
public java.util.ListIterator getListItems() {
	com.hps.july.cdbc.objects.CDBCDocuments c = new com.hps.july.cdbc.objects.CDBCDocuments();
	com.hps.july.cdbc.lib.CDBCResultSet rs = c.listChangeActOnStorageItems(new Integer(getDocument()),new Integer(1));
	return rs.listIterator();
}
public int getState() {
	return com.hps.july.inventory.APPStates.EDITCHS;
}
public java.lang.Integer getStorage() {
	return storage.getInteger();
}
public String getStoragecode() {
	return storage.getString();
}
public java.lang.Integer getStorageman() {
	return storageman.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Worker getStorageManager() throws Exception {

	WorkerAccessBean bean = constructWorkers();
	if (bean != null)
	  return (Worker)bean.getEJBRef();
	else
	  return null;
}
public String getStoragemancode() {
	return storageman.getString();
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragemanname() {
	return storagemanname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragemantitle() {
	return storagemantitle;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
public Enumeration getStorages() {
	try {
		StorageAccessBean bean = new StorageAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new Vector()).elements();
	}
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getTechmanname() {
	return techmanname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getTechmantitle() {
	return techmantitle;
}
protected java.lang.Integer getToKey() {
	return getStorage();
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws Exception 
{
	storage = new StringAndIntegerProperty();
	storagename = "";
	storageman = new StringAndIntegerProperty();
	storagemanname = "";
	storagemantitle = "";
	super.initRecord(request);
	ChangeSListForm aform = (ChangeSListForm)request.getSession().getAttribute(getFormName());
	storage.setInteger(aform.getStorage());
	storagename = aform.getStoragename();
}
/**
 * Insert the method's description here.
 * Creation date: (04.09.2002 18:37:08)
 * @return com.hps.july.persistence.StorageCardAccessBean
 */
public void setFrom(StoragePlaceAccessBean newFrom) throws Exception {
	if (newFrom == null) {
	  setStoragecode("");
	  setStoragename("");
	}
	else {
		setStorage(new Integer(newFrom.getStorageplace()));
		setStoragename(newFrom.getName());
	}
}
public void setStorage(Integer number) {
	storage.setInteger(number);
}
public void setStoragecode(String number) {
	storage.setString(number);
}
public void setStorageman(Integer number) {
	storageman.setInteger(number);
}
public void setStoragemancode(String number) {
	storageman.setString(number);
}
/**
 * 
 * @param newStoragemanname java.lang.String
 */
public void setStoragemanname(java.lang.String newStoragemanname) {
	storagemanname = newStoragemanname;
}
/**
 * 
 * @param newStoragemantitle java.lang.String
 */
public void setStoragemantitle(java.lang.String newStoragemantitle) {
	storagemantitle = newStoragemantitle;
}
/**
 * 
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
/**
 * 
 * @param newTechmanname java.lang.String
 */
public void setTechmanname(java.lang.String newTechmanname) {
	techmanname = newTechmanname;
}
/**
 * 
 * @param newTechmantitle java.lang.String
 */
public void setTechmantitle(java.lang.String newTechmantitle) {
	techmantitle = newTechmantitle;
}
protected void specialValidate(org.apache.struts.action.ActionErrors errors)
{
	// check storage
	try {
		StorageAccessBean s = new StorageAccessBean();
		s.setInitKey_storageplace(getStorage().intValue());
		s.refreshCopyHelper();
		storagename = s.getName();
	} catch(Exception e) {
	}
}
}
