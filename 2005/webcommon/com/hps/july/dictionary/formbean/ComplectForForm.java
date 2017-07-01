package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * ‘орма добавлени€/удалени€ оборудование в набор
 */
public class ComplectForForm extends com.hps.july.web.util.EditForm {
	private int complect;
	private int part;
	private java.lang.String complectname;
	private java.lang.String partname;
	private java.lang.String modelname;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	ComplectForListForm aform = (ComplectForListForm)request.getSession().getAttribute( "ComplectForListForm" );
	setPartcode(aform.getResource());
	setPartname(aform.getResourcename());
    ComplectAccessBean bean = new ComplectAccessBean(
	    new Integer(getComplectcode()), new Integer(getPartcode()) );
	return bean;
}
/**
 * Insert the method's description here.
 */
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean)
{
	try {
		ComplectAccessBean nbean = (ComplectAccessBean)bean;
		setComplectname(nbean.getComplect().getName());
		setModelname(nbean.getComplect().getModel());
	} catch(Exception e) {
		setComplectname("");
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
 * Creation date: (06.05.2002 12:54:10)
 * @return java.lang.Integer
 */
public int getComplectcode() {
	return complect;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 12:57:55)
 * @return java.lang.String
 */
public java.lang.String getComplectname() {
	return complectname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ComplectForListForm aform = (ComplectForListForm)request.getSession().getAttribute( "ComplectForListForm" );
	setPartcode(aform.getResource());
	setPartname(aform.getResourcename());
	ComplectAccessBean bean = new ComplectAccessBean();
	bean.setInitKey_complect_resource( new Integer(getComplectcode()) );
	bean.setInitKey_parts_resource( new Integer(getPartcode()) );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 8:52:14)
 * @return java.lang.String
 */
public java.lang.String getModelname() {
	return modelname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 12:54:33)
 * @return java.lang.Integer
 */
public int getPartcode() {
	return part;
}
/**
 * Insert the method's description here.
 * Creation date: (06.05.2002 12:58:10)
 * @return java.lang.String
 */
public java.lang.String getPartname() {
	return partname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITCPF;
}
/**
 * Insert the method's description here.
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	ComplectForListForm aform = (ComplectForListForm)request.getSession().getAttribute( "ComplectForListForm" );
	setPartcode(aform.getResource());
	setPartname(aform.getResourcename());
}
/**
 * Insert the method's description here.
 */
public void setComplectcode(int newComplect) {
	complect = newComplect;
}
/**
 * Insert the method's description here.
 */
public void setComplectname(java.lang.String newComplectname) {
	complectname = newComplectname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 8:52:14)
 * @param newModelname java.lang.String
 */
public void setModelname(java.lang.String newModelname) {
	modelname = newModelname;
}
/**
 * Insert the method's description here.
 */
public void setPartcode(int newPart) {
	part = newPart;
}
/**
 * Insert the method's description here.
 */
public void setPartname(java.lang.String newPartname) {
	partname = newPartname;
}
/**
 * Insert the method's description here.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if (complect <= 0)
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.complectfor.complect"));
	
	if (!errors.empty())
		throw new ValidationException();
}
}
