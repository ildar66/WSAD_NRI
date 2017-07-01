package com.hps.july.arenda.formbean;

/**
 * Bean-form
 * Контракты-регламенты.
 * Creation date: (22.11.2002 12:00:27)
 * @author: Sergey Gourov
 */
public class CopyReglamentForm extends com.hps.july.web.util.EditForm {
/**
 * Insert the method's description here.
 * Creation date: (22.11.2002 12:00:27)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.11.2002 12:00:27)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (22.11.2002 12:00:27)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.11.2002 12:00:27)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.COPY_REGLAMENT;
}
}
