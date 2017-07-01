package com.hps.july.arenda.formbean;

import com.hps.july.web.util.*;
/**
 * Bean-form
 * װמנלא "מעקועמג".
 */
public abstract class ReportForm extends EditForm {
public ReportForm() {
	setAction("Add");
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	return null;
}
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	return null;
}
public java.util.ArrayList getEditRoles() {
	java.util.ArrayList roles = new java.util.ArrayList();
	roles.add("AllAuthenticated");
	return roles;
}
}
