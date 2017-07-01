package com.hps.july.arenda.formbean;

import com.hps.july.persistence.*;
/**
 * Bean-form
 * Форма "поиск ресурсов".
 * Creation date: (15.01.2002 14:06:31)
 * @author: Administrator
 */
public class ResourceLookupListForm extends com.hps.july.web.util.BrowseForm {
	
	private int restype;
	private java.lang.String restypename;
	private int ressbtype;
	private java.lang.String ressbtypename;
	private java.lang.String model;
	private java.lang.String name;
	private java.lang.Boolean isSubtypekey;
	private java.lang.Boolean isModel;
	private java.lang.Boolean isName;
	private int conditionForFind;
	private Integer sortType;
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 13:30:34)
 */
public ResourceLookupListForm() {
//	this.setFinderMethodName("findResourceByQBE");
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_VID");
		bean.refreshCopyHelper();
		restype = bean.getIntvalue();
	} catch (Exception ex) {
		ex.printStackTrace();
		restype = 0;
		restypename = "";
	}

	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();
		ressbtype = bean.getIntvalue();
	} catch (Exception ex) {
		ex.printStackTrace();	
		ressbtype = 0;
		ressbtypename = "";
	}
	
	isModel = new Boolean(false);
	isName = new Boolean(false);
	isSubtypekey = new Boolean(false);
	model = "";
	name = "";
	sortType = new Integer(1);
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 18:24:28)
 * @return int
 */
public int getConditionForFind() {
	return conditionForFind;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2002 12:00:34)
 * @return java.lang.Object[]
 */
public java.lang.Object[] getFilterParams() {
	String s = super.getFinderMethodName();
	try {
		sortType = Integer.valueOf(s);
	} catch (NumberFormatException e) {
	}
	switch (getConditionForFind()) {
		case 0:
			setIsSubtypekey(new Boolean(true));
			setIsModel(new Boolean(false));
			setIsName(new Boolean(false));
			break;
		case 1:
			setIsSubtypekey(new Boolean(false));
			setIsModel(new Boolean(true));
			setIsName(new Boolean(false));
			break;
		case 2:
			setIsSubtypekey(new Boolean(false));
			setIsModel(new Boolean(false));
			setIsName(new Boolean(true));
			break;
	}
	return new Object[] { getIsSubtypekey(), new ResourceSubTypeKey(getRessbtype()),
		getIsModel(), getModel(), getIsName(), getName(), sortType };
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 18:59:07)
 * @return java.lang.String
 */
public String getFinderMethodName() {
	return "findResourcesByQBE";
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 18:20:21)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsModel() {
	return isModel;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 18:21:12)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsName() {
	return isName;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 18:19:42)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsSubtypekey() {
	return isSubtypekey;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 17:09:33)
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 17:10:17)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 */
public int getRessbtype() {
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
public int getRestype() {
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
 * Creation date: (19.06.2002 18:24:28)
 * @param newConditionForFind int
 */
public void setConditionForFind(int newConditionForFind) {
	conditionForFind = newConditionForFind;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 18:20:21)
 * @param newIsModel java.lang.Boolean
 */
public void setIsModel(java.lang.Boolean newIsModel) {
	isModel = newIsModel;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 18:21:12)
 * @param newIsName java.lang.Boolean
 */
public void setIsName(java.lang.Boolean newIsName) {
	isName = newIsName;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 18:19:42)
 * @param newIsSubtypekey java.lang.Boolean
 */
public void setIsSubtypekey(java.lang.Boolean newIsSubtypekey) {
	isSubtypekey = newIsSubtypekey;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 17:09:33)
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * Insert the method's description here.
 * Creation date: (19.06.2002 17:10:17)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.05.2002 15:52:58)
 * @param newRessbtype int
 */
public void setRessbtype(int newRessbtype) {
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
public void setRestype(int newRestype) {
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
}
