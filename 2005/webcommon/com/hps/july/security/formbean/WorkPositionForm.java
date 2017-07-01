package com.hps.july.security.formbean;

import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
 * Форма редактирования должности.
 * Creation date: (15.01.2002 14:08:44)
 * @author: Administrator
 */
public class WorkPositionForm extends com.hps.july.web.util.EditForm {
	private int workposition;
	private java.lang.String name;
	private java.lang.Boolean isactive;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    WorkPositionAccessBean bean = new WorkPositionAccessBean( keyGen.getNextKey("tables.workpositions"),  getName());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.SECURITY;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	WorkPositionAccessBean bean = new WorkPositionAccessBean();
	bean.setInitKey_workposition( getWorkposition() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2003 17:50:32)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsactive() {
	return isactive;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:11:26)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITWPOS;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:11:12)
 * @return int
 */
public int getWorkposition() {
	return workposition;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setIsactive(new Boolean(true));
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2003 17:50:32)
 * @param newIsactive java.lang.Boolean
 */
public void setIsactive(java.lang.Boolean newIsactive) {
	isactive = newIsactive;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:11:26)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:11:12)
 * @param newWorkposition int
 */
public void setWorkposition(int newWorkposition) {
	workposition = newWorkposition;
}
}
