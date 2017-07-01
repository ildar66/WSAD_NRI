package com.hps.july.security.formbean;

import java.util.*;
import com.hps.july.persistence.*;
import com.ibm.ivj.ejb.runtime.*;
import java.sql.Date;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.hps.july.persistence.PeopleAccessBean;
/**
 * Форма редактирования физического лица.
 * Creation date: (15.01.2002 14:08:44)
 * @author: Administrator
 */
public class PeopleForm extends com.hps.july.web.util.EditForm {
	private int man;
	private java.lang.String firstname;
	private java.lang.String middlename;
	private java.lang.String passportser;
	private java.lang.String lastname;
	private java.lang.String passportWhom;
	private StringAndSqlDateProperty passportDate = new StringAndSqlDateProperty();
	private java.lang.Boolean isActive = new Boolean(false);
	private java.lang.Boolean initialState;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	if ("Edit".equals(getAction()) && getInitialState().booleanValue() && !getIsActive().booleanValue()) {
		
		Enumeration e = new WorkerAccessBean().findWorkersByMan(new PeopleKey(getMan()));
		while (e.hasMoreElements()) {
			WorkerAccessBean workerBean = (WorkerAccessBean) e.nextElement();
			workerBean.setActive(new Boolean(false));
			workerBean.commitCopyHelper();
		}
		
		e = new OperatorAccessBean().findOperatorsByMan(new PeopleKey(getMan()));
		while (e.hasMoreElements()) {
			OperatorAccessBean operatorBean = (OperatorAccessBean) e.nextElement();
			operatorBean.setEnabled(new Boolean(false));
			operatorBean.commitCopyHelper();
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
    PeopleAccessBean bean = new PeopleAccessBean( keyGen.getNextKey("tables.people"),  getFirstname(),
    	getMiddlename(), getLastname(), getPassportser() );	
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	setInitialState(getIsActive());
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
	PeopleAccessBean bean = new PeopleAccessBean();
	bean.setInitKey_man( getMan() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 15:46:58)
 * @return java.lang.String
 */
public java.lang.String getFirstname() {
	return firstname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2003 11:19:41)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getInitialState() {
	return initialState;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 18:36:20)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsActive() {
	return isActive;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:49:18)
 * @return java.lang.String
 */
public java.lang.String getLastname() {
	return lastname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 15:46:05)
 * @return int
 */
public int getMan() {
	return man;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 15:48:57)
 * @return java.lang.String
 */
public java.lang.String getMiddlename() {
	return middlename;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 18:27:20)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getPassportDate() {
	return passportDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 18:27:20)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getPassportDateFrm() {
	return passportDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 15:49:46)
 * @return java.lang.String
 */
public java.lang.String getPassportser() {
	return passportser;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 18:25:12)
 * @return java.lang.String
 */
public java.lang.String getPassportWhom() {
	return passportWhom;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITPPL;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setIsActive(new Boolean(true));
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 15:46:58)
 * @param newFirstname java.lang.String
 */
public void setFirstname(java.lang.String newFirstname) {
	firstname = newFirstname;
}
/**
 * Insert the method's description here.
 * Creation date: (15.07.2003 11:19:41)
 * @param newInitialState java.lang.Boolean
 */
public void setInitialState(java.lang.Boolean newInitialState) {
	initialState = newInitialState;
}
/**
 * Insert the method's description here.
 * Creation date: (14.07.2003 18:36:20)
 * @param newIsActive java.lang.Boolean
 */
public void setIsActive(java.lang.Boolean newIsActive) {
	isActive = newIsActive;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 16:49:18)
 * @param newLastname java.lang.String
 */
public void setLastname(java.lang.String newLastname) {
	lastname = newLastname;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 15:46:05)
 * @param newMan int
 */
public void setMan(int newMan) {
	man = newMan;
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 15:48:57)
 * @param newMiddlename java.lang.String
 */
public void setMiddlename(java.lang.String newMiddlename) {
	middlename = newMiddlename;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 18:27:20)
 * @param newPassportDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setPassportDate(Date newPassportDate) {
	passportDate.setSqlDate(newPassportDate);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 18:27:20)
 * @param newPassportDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setPassportDateFrm(String newPassportDate) {
	passportDate.setString(newPassportDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.02.2002 15:49:46)
 * @param newPassportser java.lang.String
 */
public void setPassportser(java.lang.String newPassportser) {
	passportser = newPassportser;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2003 18:25:12)
 * @param newPassportWhom java.lang.String
 */
public void setPassportWhom(java.lang.String newPassportWhom) {
	passportWhom = newPassportWhom;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getFirstname() == null) || (getFirstname().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.people.firstname"));

	if ((getLastname() == null) || (getLastname().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.people.lastname"));

	if ((getMiddlename() == null) || (getMiddlename().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.people.middlename"));

	if ((getPassportser() == null) || (getPassportser().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.people.passportser"));


	if (!errors.empty())
		throw new ValidationException();
}
}
