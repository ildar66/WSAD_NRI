package com.hps.july.inventory.formbean;

import com.hps.july.persistence.StorageAccessBean;

/**
 * Форма выбора устройств из строк документа для включения в агрегат.
 */
public class AgregateLookupListForm extends com.hps.july.web.util.BrowseForm {
	public static final String SERIAL = "S";
	public static final String PARTIAL = "P";
	public static final String BULK = "B";
	
	private Integer restype;
	private String restypename;
	private Integer ressbtype;
	private String ressbtypename;
	private String serialnum;
	private Integer order;
	private Integer storage;
	private String storagename;
	private Integer documentcode;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public AgregateLookupListForm() {
	this.setFinderMethodName( "findDocPositionsByDocAndPolicyOrderByOrderAsc" );
	restype = new Integer(0);
	restypename = "";
	ressbtype = new Integer(0);
	ressbtypename = "";
	storage = new Integer(0);
	storagename = "";	
	serialnum = "";
	order = new Integer(1);
	documentcode = new Integer(0);
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 17:21:55)
 * @return java.lang.Integer
 */
public java.lang.Integer getDocumentcode() {
	return documentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	return new Object[] {
		getDocumentcode(),
		SERIAL
	};
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:06)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrder() {
	return order;
}
/**
 * Insert the method's description here.
 */
public Integer getRessbtype() {
	return ressbtype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:53:28)
 * @return java.lang.String
 */
public java.lang.String getRessbtypename() {
	return ressbtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:33)
 * @return int
 */
public Integer getRestype() {
	return restype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:46)
 * @return java.lang.String
 */
public java.lang.String getRestypename() {
	return restypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:54:42)
 * @return java.lang.String
 */
public java.lang.String getSerialnum() {
	return serialnum;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:32)
 * @return java.lang.Integer
 */
public java.lang.Integer getStorage() {
	return storage;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:50)
 * @return java.lang.String
 */
public java.lang.String getStoragename() {
	return storagename;
}
/**
 * Insert the method's description here.
 */
public java.util.Enumeration getStorages() {
	try {
		StorageAccessBean bean = new StorageAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (27.05.2002 17:21:55)
 * @param newDocumentcode java.lang.Integer
 */
public void setDocumentcode(java.lang.Integer newDocumentcode) {
	documentcode = newDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:06)
 * @param newOrder java.lang.Integer
 */
public void setOrder(java.lang.Integer newOrder) {
	order = newOrder;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:58)
 * @param newRessbtype int
 */
public void setRessbtype(Integer newRessbtype) {
	ressbtype = newRessbtype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:53:28)
 * @param newRessbtypename java.lang.String
 */
public void setRessbtypename(java.lang.String newRessbtypename) {
	ressbtypename = newRessbtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:33)
 * @param newRestype int
 */
public void setRestype(Integer newRestype) {
	restype = newRestype;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:46)
 * @param newRestypename java.lang.String
 */
public void setRestypename(java.lang.String newRestypename) {
	restypename = newRestypename;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:54:42)
 * @param newSerialnum java.lang.String
 */
public void setSerialnum(java.lang.String newSerialnum) {
	serialnum = newSerialnum;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:32)
 * @param newStorage java.lang.Integer
 */
public void setStorage(java.lang.Integer newStorage) {
	storage = newStorage;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 16:17:50)
 * @param newStoragename java.lang.String
 */
public void setStoragename(java.lang.String newStoragename) {
	storagename = newStoragename;
}
}
