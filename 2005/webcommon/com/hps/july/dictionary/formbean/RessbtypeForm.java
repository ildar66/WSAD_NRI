package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования типа оборудования
 */
public class RessbtypeForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private int resourcetype;
	private int resourcesubtype;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	RessbtypeListForm aform = (RessbtypeListForm)request.getSession().getAttribute( "RessbtypeListForm" );
	setResourcetype(aform.getResourcetype());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setResourcesubtype(keyGen.getNextKey("tables.resourcesubtypes"));
    ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean(getResourcesubtype(), getName(), new Integer(getResourcetype()) );
	return bean;
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
	ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean();
	bean.setInitKey_resourcesubtype( getResourcesubtype() );
	return bean;
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
 * Creation date: (24.04.2002 17:06:09)
 * @return int
 */
public int getResourcesubtype() {
	return resourcesubtype;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 12:00:04)
 * @return int
 */
public int getResourcetype() {
	return resourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITRSTP;
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
 * Creation date: (24.04.2002 17:06:09)
 * @param newResourcesubtype int
 */
public void setResourcesubtype(int newResourcesubtype) {
	resourcesubtype = newResourcesubtype;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 12:00:04)
 * @param newResourcetype int
 */
public void setResourcetype(int newResourcetype) {
	resourcetype = newResourcetype;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if(getName() != null)
		setName(getName().trim());
		
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.subtype.name"));
	  
	if (!errors.empty())
		throw new ValidationException();
}
}
