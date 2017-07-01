package com.hps.july.siteinfo.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * ‘орма редактировани€ типа ответственности
 */
public class TyperesponsibilityForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private int responsibilityType;
	private java.lang.Boolean isPrint;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setResponsibilityType(keyGen.getNextKey("tables.typeresponsibility"));
    ResponsibilityTypeAccessBean bean = new ResponsibilityTypeAccessBean(getResponsibilityType(), getName(),
    	getIsPrint() );	
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SITEINFO;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ResponsibilityTypeAccessBean bean = new ResponsibilityTypeAccessBean();
	bean.setInitKey_responsibilityType( getResponsibilityType() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 13:04:33)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsPrint() {
	return isPrint;
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
 * Creation date: (03.06.2002 13:04:13)
 * @return int
 */
public int getResponsibilityType() {
	return responsibilityType;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.siteinfo.APPStates.EDITTRSP;
}
/**
 * Insert the method's description here.
 * Creation date: (03.06.2002 13:04:33)
 * @param newIsPrint java.lang.Boolean
 */
public void setIsPrint(java.lang.Boolean newIsPrint) {
	isPrint = newIsPrint;
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
 * Creation date: (03.06.2002 13:04:13)
 * @param newResponsibilityType int
 */
public void setResponsibilityType(int newResponsibilityType) {
	responsibilityType = newResponsibilityType;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.typeresponsibility.name"));
	  
	if (!errors.empty())
		throw new ValidationException();
}
}
