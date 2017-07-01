package com.hps.july.dictionary.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * ‘орма добавлени€/удалени€ оборудовани€ в набор
 */
public class ComplectContentForm extends com.hps.july.web.util.EditForm {
	private int resourceset;
	private String resourcesetname;
	private int resourcepart;
	private String resourcepartname;
	private StringAndBigDecimalProperty qty;
	private java.lang.String resourcepartmodel;
	private java.lang.String unitname;
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:38:00)
 */
public ComplectContentForm() {
	qty = new StringAndBigDecimalProperty();
	unitname = "";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ComplectContentListForm f = (ComplectContentListForm)request.getSession().getAttribute( "ComplectContentListForm" );
	setResourceset(f.getResourceset());
	setResourcesetname(f.getResourcesetname());
    ResourceSetPartAccessBean bean = new ResourceSetPartAccessBean(
	    new Integer(getResourceset()), new Integer(getResourcepart()), getQty());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 17:53:47)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean)
{
	try {
		ResourceSetPartAccessBean nbean = (ResourceSetPartAccessBean)bean;
		setResourcepart(nbean.getPart().getResource());
		setResourcepartname(nbean.getPart().getName());
		setResourcepartmodel(nbean.getPart().getModel());
		setResourcesetname(nbean.getSet().getName());
		if (nbean.getPart().getUnit() != null)
			setUnitname(nbean.getPart().getUnit().getShortname());
	} catch(Exception e) {
		setResourcepartname("");
		setResourcesetname("");
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
	ComplectContentListForm aform = (ComplectContentListForm)request.getSession().getAttribute( "ComplectContentListForm" );
	setResourceset(aform.getResourceset());
	setResourcesetname(aform.getResourcesetname());
	ResourceSetPartAccessBean bean = new ResourceSetPartAccessBean();
	bean.setInitKey_set_resourceset(new Integer(getResourceset()));
	bean.setInitKey_part_resource(new Integer(getResourcepart()));
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:11:36)
 * @return java.lang.String
 */
public java.math.BigDecimal getQty() {
	return qty.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:11:36)
 * @return java.lang.String
 */
public String getQtystr() {
	return qty.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:06:11)
 * @return int
 */
public int getResourcepart() {
	return resourcepart;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 10:23:32)
 * @return java.lang.String
 */
public java.lang.String getResourcepartmodel() {
	return resourcepartmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 14:11:32)
 * @return java.lang.String
 */
public java.lang.String getResourcepartname() {
	return resourcepartname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:06:11)
 * @return int
 */
public int getResourceset() {
	return resourceset;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 17:46:30)
 * @return java.lang.String
 */
public String getResourcesetname() {
	return resourcesetname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITCPC;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:09:12)
 * @return java.lang.String
 */
public java.lang.String getUnitname() {
	return unitname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 17:53:26)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ComplectContentListForm f = (ComplectContentListForm)request.getSession().getAttribute( "ComplectContentListForm" );
	setResourceset(f.getResourceset());
	setResourcesetname(f.getResourcesetname());
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:08:13)
 * @param newNds java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newQty) {
	qty.setBigDecimal(newQty);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:12:46)
 * @param newNsp java.lang.String
 */
public void setQtystr(String newQty) {
	qty.setString(newQty);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:06:33)
 * @param newResource int
 */
public void setResourcepart(int newResourcepart) {
	resourcepart = newResourcepart;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 10:23:32)
 * @param newResourcepartmodel java.lang.String
 */
public void setResourcepartmodel(java.lang.String newResourcepartmodel) {
	resourcepartmodel = newResourcepartmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (07.05.2002 14:11:32)
 * @param newResourcepartname java.lang.String
 */
public void setResourcepartname(String newResourcepartname) {
	resourcepartname = newResourcepartname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:06:33)
 * @param newResource int
 */
public void setResourceset(int newResourceset) {
	resourceset = newResourceset;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 17:46:30)
 * @param newResourcename java.lang.String
 */
public void setResourcesetname(java.lang.String newResourcesetname) {
	resourcesetname = newResourcesetname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.06.2002 13:09:12)
 * @param newUnitname java.lang.String
 */
public void setUnitname(java.lang.String newUnitname) {
	unitname = newUnitname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if (qty.isEmpty())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.content.qty"));
	else if (!qty.isOk())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.content.qty"));

	if (resourcepart <= 0)
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.content.resourcepart"));
	
	if (!errors.empty())
		throw new ValidationException();
}
}
