package com.hps.july.dictionary.formbean;

import org.apache.struts.action.ActionErrors;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;

/**
 * Форма списка оборудования
 */
public class ResourceListForm
	extends BrowseForm
{
	public static final String SHOW_ALL = "*";
	public static final String SHOW_NEW = "Y";
	public static final String SHOW_OLD = "N";
	
	private Boolean isResourcetype;
	private StringAndIntegerProperty resourcetype;
	private String resourcetypename;

	private Boolean isResourcesubtype;
	private StringAndIntegerProperty resourcesubtype;
	private String resourcesubtypename;

	private Boolean isModel;
	private String model;

	private Boolean isName;
	private String name;

	private Boolean isManuf;
	private StringAndIntegerProperty manuf;
	private String manufname;

	private Boolean isManucode;
	private String manucode;

	private Boolean isNfscode;
	private String nfscode;

	private Boolean isNricode;
	private String nricode;

	private String showType;

	private int sortmode;
public ResourceListForm()
{
	isResourcetype = Boolean.FALSE;
	resourcetype = new StringAndIntegerProperty();
	resourcetypename = "";
		
	isResourcesubtype = Boolean.FALSE;
	resourcesubtype = new StringAndIntegerProperty();
	resourcesubtypename = "";;

	isModel = Boolean.TRUE;
	model = "";;

	isName = Boolean.FALSE;
	name = "";;

	isManuf = Boolean.FALSE;
	manuf = new StringAndIntegerProperty();
	manufname = "";;

	isManucode = Boolean.FALSE;
	manucode = "";

	isNfscode = Boolean.FALSE;
	nfscode = "";
	
	isNricode = Boolean.FALSE;
	nricode = "";

	showType = SHOW_ALL;

	sortmode = 1;
	super.setFinderMethodName("1");
	
	setLastVisited(true);
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("administrator");
	roles.add("dictResAdmin");
	//roles.add("dictResOperator");
	roles.add("ArendaMainEconomist");
	return roles;
}
public java.lang.Object[] getFilterParams() {
	System.out.println("getIsNfscode() = "+getIsNfscode());
	System.out.println("getNfscode() = "+getNfscode());
	return new Object[] {
		getIsResourcetype(),
		(getResourcetype().getInteger() != null)?getResourcetype().getInteger():new Integer(0),
		getIsResourcesubtype(),
		(getResourcesubtype().getInteger() != null)?getResourcesubtype().getInteger():new Integer(0),
		getIsModel(), getModel(),
		getIsName(),getName(),
		getIsManuf(), (getManuf().getInteger() != null)?getManuf().getInteger():new Integer(0),
		getIsManucode(), getManucode(),
		getIsNfscode(), getNfscode(),
		getIsNricode(), getNricode(),
		getShowType(),
		new Integer(getSortmode())
	};
}
/**
 * Возвращает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @return java.lang.String
 */
public java.lang.String getFinderMethodName() {
	return "findResourcesList";
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManucode() {
	return isManucode;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsManuf() {
	return isManuf;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsModel() {
	return isModel;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsName() {
	return isName;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsResourcesubtype() {
	return isResourcesubtype;
}
/**
 * 
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsResourcetype() {
	return isResourcetype;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManucode() {
	return manucode;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getManuf() {
	return manuf;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getManufname() {
	return manufname;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getResourcesubtype() {
	return resourcesubtype;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcesubtypename() {
	return resourcesubtypename;
}
/**
 * 
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public com.hps.july.web.util.StringAndIntegerProperty getResourcetype() {
	return resourcetype;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
/**
 * 
 * @return java.lang.String
 */
public java.lang.String getShowType() {
	return showType;
}
/**
 * 
 * @return int
 */
public int getSortmode() {
	return sortmode;
}
/**
 * Устанавливает имя метода поиска.
 * Creation date: (22.01.2002 11:20:35)
 * @param newFinderMethodName java.lang.String
 */
public void setFinderMethodName(java.lang.String newFinderMethodName) {
	try {
		System.out.println("@RF@:SORTMODE:"+getSortmode());
		setSortmode(Integer.parseInt(newFinderMethodName));
	} catch(Exception e) {
	}
}
/**
 * 
 * @param newIsManucode java.lang.Boolean
 */
public void setIsManucode(java.lang.Boolean newIsManucode) {
	isManucode = newIsManucode;
}
/**
 * 
 * @param newIsManuf java.lang.Boolean
 */
public void setIsManuf(java.lang.Boolean newIsManuf) {
	isManuf = newIsManuf;
}
/**
 * 
 * @param newIsModel java.lang.Boolean
 */
public void setIsModel(java.lang.Boolean newIsModel) {
	isModel = newIsModel;
}
/**
 * 
 * @param newIsName java.lang.Boolean
 */
public void setIsName(java.lang.Boolean newIsName) {
	isName = newIsName;
}
/**
 * 
 * @param newIsResourcesubtype java.lang.Boolean
 */
public void setIsResourcesubtype(java.lang.Boolean newIsResourcesubtype) {
	isResourcesubtype = newIsResourcesubtype;
}
/**
 * 
 * @param newIsResourcetype java.lang.Boolean
 */
public void setIsResourcetype(java.lang.Boolean newIsResourcetype) {
	isResourcetype = newIsResourcetype;
}
/**
 * 
 * @param newManucode java.lang.String
 */
public void setManucode(java.lang.String newManucode) {
	manucode = newManucode;
}
/**
 * 
 * @param newManufname java.lang.String
 */
public void setManufname(java.lang.String newManufname) {
	manufname = newManufname;
}
/**
 * 
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * 
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * 
 * @param newResourcesubtypename java.lang.String
 */
public void setResourcesubtypename(java.lang.String newResourcesubtypename) {
	resourcesubtypename = newResourcesubtypename;
}
/**
 * 
 * @param newResourcetypename java.lang.String
 */
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
/**
 * 
 * @param newShowType java.lang.String
 */
public void setShowType(java.lang.String newShowType) {
	showType = newShowType;
}
/**
 * 
 * @param newSortmode int
 */
public void setSortmode(int newSortmode) {
	sortmode = newSortmode;
}
public void validateValues(ActionErrors errors)
	throws ValidationException
{
	// update filter here
	if(getIsResourcesubtype() != null && getIsResourcesubtype().booleanValue() && getResourcesubtype().getInteger() != null) {
		try {
			ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
			bean.setInitKey_resourcesubtype(resourcesubtype.getInteger().intValue());
			bean.refreshCopyHelper();
			setResourcesubtypename(bean.getName());
			ResourceTypeAccessBean restype = bean.getResourcetype();
			resourcetype.setInteger(new Integer(restype.getResourcetype()));
			setResourcetypename(restype.getName());
		} catch (Exception e) {
			setResourcesubtypename("");
		}
	} else {
		if(getIsResourcetype() != null && getIsResourcetype().booleanValue()) {
			try {
				ResourceTypeAccessBean bean = new ResourceTypeAccessBean();
				bean.setInitKey_resourcetype(resourcetype.getInteger().intValue());
				bean.refreshCopyHelper();
				setResourcetypename(bean.getName());
			} catch (Exception e) {
				setResourcetypename("");
			}
		}
	}
	try {
		OrganizationAccessBean bean = new OrganizationAccessBean();
		bean.setInitKey_organization(manuf.getInteger().intValue());
		bean.refreshCopyHelper();
		setManufname(bean.getName());
	} catch (Exception e) {
		setManufname("");
	}
}
	/**
	 * @return
	 */
	public Boolean getIsNfscode() {
		return isNfscode;
	}

	/**
	 * @return
	 */
	public String getNfscode() {
		return nfscode;
	}

	/**
	 * @param boolean1
	 */
	public void setIsNfscode(Boolean boolean1) {
		isNfscode = boolean1;
	}

	/**
	 * @param string
	 */
	public void setNfscode(String string) {
		nfscode = string;
	}

	/**
	 * @return
	 */
	public Boolean getIsNricode() {
		return isNricode;
	}

	/**
	 * @return
	 */
	public String getNricode() {
		return nricode;
	}

	/**
	 * @param boolean1
	 */
	public void setIsNricode(Boolean boolean1) {
		isNricode = boolean1;
	}

	/**
	 * @param string
	 */
	public void setNricode(String string) {
		nricode = string;
	}

}
