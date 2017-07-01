package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.constants.Resources;

/**
 * Форма редактирования основных параметров набора оборудования
 */
public class ComplectForm extends com.hps.july.web.util.EditForm {
	public static final String TYPE_SET = "S";
	public static final String TYPE_AGREGATE = "A";
	
	private int resourceset;
	private String name;
	private int mainpart;
	private String mainpartname;
	private StringAndBigDecimalProperty mainpartqty;
	private String type;
	private int resourcetype;
	private String resourcetypename;
	private String resourcesubtypename;
	public int resourcesubtype;
	private java.lang.String mainpartmodel;
	private java.lang.String mainpartunit;
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 11:24:55)
 */
public ComplectForm() {
	mainpartqty = new StringAndBigDecimalProperty();
	mainpartunit = "";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setResourceset(keyGen.getNextKey("tables.resourceset"));
	setType("S");
    ResourceSetAccessBean bean = new ResourceSetAccessBean(
	    getResourceset(),
	    getName(),
	    new Integer(getMainpartcode()),
	    getMainpartqty(),
	    getType()
	);
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:56:32)
 */
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean)
{
	try {
		ResourceSetAccessBean nbean = (ResourceSetAccessBean)bean;
		setResourcesubtype(nbean.getMainpart().getSubtype().getResourcesubtype());
		setResourcesubtypename(nbean.getMainpart().getSubtype().getName());
		setResourcetype(nbean.getMainpart().getSubtype().getResourcetype().getResourcetype());
		setResourcetypename(nbean.getMainpart().getSubtype().getResourcetype().getName());
		setMainpartcode(nbean.getMainpart().getResource());
		setMainpartname(nbean.getMainpart().getName());
		setMainpartmodel(nbean.getMainpart().getModel());
		if (nbean.getMainpart().getUnit() != null)
			setMainpartunit(nbean.getMainpart().getUnit().getShortname());
	} catch(Exception e) {
		setResourcesubtype(0);
		setResourcesubtypename("");
		setResourcetype(0);
		setResourcetypename("");
		setMainpartname("");
		setMainpartmodel("");
		setMainpartunit("");
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ResourceSetAccessBean bean = new ResourceSetAccessBean();
	bean.setInitKey_resourceset(getResourceset());
	setType("S");
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 16:23:00)
 * @return int
 */
public int getMainpartcode() {
	return mainpart;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 10:08:20)
 * @return java.lang.String
 */
public java.lang.String getMainpartmodel() {
	return mainpartmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 16:23:00)
 * @return java.lang.String
 */
public java.lang.String getMainpartname() {
	return mainpartname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @return java.lang.String
 */
public java.math.BigDecimal getMainpartqty() {
	return mainpartqty.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @return java.lang.String
 */
public String getMainpartqtystr() {
	return mainpartqty.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 12:30:15)
 * @return java.lang.String
 */
public java.lang.String getMainpartunit() {
	return mainpartunit;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 16:23:00)
 * @return int
 */
public int getResourceset() {
	return resourceset;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 10:57:52)
 * @return int
 */
public int getResourcesubtype() {
	return resourcesubtype;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 10:57:21)
 * @return String
 */
public String getResourcesubtypename() {
	return resourcesubtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 10:56:37)
 * @return int
 */
public int getResourcetype() {
	return resourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 10:57:00)
 * @return java.lang.String
 */
public java.lang.String getResourcetypename() {
	return resourcetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITCP;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 16:23:00)
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:55:30)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	/*
	ComplectListForm f = (ComplectListForm)request.getSession().getAttribute( "ComplectListForm" );

	setResourcetype(f.getResourcetypeInt());
	setResourcetypename(f.getResourcetypename());
	setResourcesubtype(f.getResourcesubtypeInt());
	setResourcesubtypename(f.getResourcesubtypename());
	*/
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 16:23:00)
 * @param newMainpart int
 */
public void setMainpartcode(int newMainpart) {
	mainpart = newMainpart;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 10:08:20)
 * @param newMainpartmodel java.lang.String
 */
public void setMainpartmodel(java.lang.String newMainpartmodel) {
	mainpartmodel = newMainpartmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 16:23:00)
 * @param newMainpartname java.lang.String
 */
public void setMainpartname(java.lang.String newMainpartname) {
	mainpartname = newMainpartname;
}
/**
 * Insert the method's description here.
 */
public void setMainpartqty(java.math.BigDecimal newMainpartqty) {
	mainpartqty.setBigDecimal(newMainpartqty);
}
/**
 * Insert the method's description here.
 */
public void setMainpartqtystr(String newMainpartqty) {
	mainpartqty.setString(newMainpartqty);
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 12:30:15)
 * @param newMainpartunit java.lang.String
 */
public void setMainpartunit(java.lang.String newMainpartunit) {
	mainpartunit = newMainpartunit;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:41:08)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 16:23:00)
 * @param newResourceset int
 */
public void setResourceset(int newResourceset) {
	resourceset = newResourceset;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 10:57:52)
 * @param newResourcesubtype int
 */
public void setResourcesubtype(int newResourcesubtype) {
	resourcesubtype = newResourcesubtype;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 10:57:21)
 * @param newResourcesubtypename int
 */
public void setResourcesubtypename(String newResourcesubtypename) {
	resourcesubtypename = newResourcesubtypename;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 10:56:37)
 * @param newResourcetype int
 */
public void setResourcetype(int newResourcetype) {
	resourcetype = newResourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 10:57:00)
 * @param newResourcetypename java.lang.String
 */
public void setResourcetypename(java.lang.String newResourcetypename) {
	resourcetypename = newResourcetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 16:23:00)
 * @param newType java.lang.String
 */
public void setType(java.lang.String newType) {
	type = newType;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
    if ((getName() == null) || (getName().length() == 0))
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.complect.name"));

    if (getMainpartcode() <= 0)
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.complect.mainpart"));

    //-da 7feb2003 check if resource exists
    
    try {
        ResourceAccessBean res = new ResourceAccessBean();
        res.setInitKey_resource(getMainpartcode());
        res.refreshCopyHelper();
        } catch (Exception ex) {
	            errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.absent.complect.mainpart"));
	            System.out.println("+++complect from,3=excn,getMainpartcode()"+getMainpartcode());	    
    } //catch

    /*
    if ((getType() == null) || (getType().length() == 0))
    	errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.complect.type"));
    */

    if (mainpartqty.isEmpty())
        errors.add(
            ActionErrors.GLOBAL_ERROR,
            new ActionError("error.empty.complect.mainpartqty"));
    else
        if (!mainpartqty.isOk())
            errors.add(
                ActionErrors.GLOBAL_ERROR,
                new ActionError("error.invalid.complect.mainpartqty"));

    if (!errors.empty())
        throw new ValidationException();
}
}
