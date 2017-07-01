package com.hps.july.security.formbean;

import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
/**
 * Форма редактирования подразделения.
 * Creation date: (15.01.2002 14:08:44)
 * @author: Administrator
 */
public class DepartmentForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private java.lang.String shortname;
	private Integer bosscode;
	private java.lang.String bossname;
	private com.hps.july.persistence.WorkerAccessBean workers;
	private int department;
	private int service;
	private java.lang.Boolean isactive;
	private boolean initIsactive;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
	if ("Edit".equals(getAction()) && getInitIsactive() && !getIsactive().booleanValue()) {
		Enumeration e = new GroupAccessBean().findByQBE(new Boolean(true), new Integer(getDepartment()),
			new Boolean(true), new Boolean(true), new Integer(1));
		while (e.hasMoreElements()) {
			GroupAccessBean groupBean = (GroupAccessBean) e.nextElement();
			groupBean.setIsactive(new Boolean(false));
			groupBean.commitCopyHelper();
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) 
  throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	DepartmentListForm aform = (DepartmentListForm)request.getSession().getAttribute( "DepartmentListForm" );
	setService(aform.getService());
	setDepartment(keyGen.getNextKey("tables.divisions"));
    DepartmentAccessBean bean = new DepartmentAccessBean(getDepartment(),  
	    getName(), getShortname(), new Integer(getService()) );	
	return bean; 
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public WorkerAccessBean constructWorkers() throws Exception {

	if (workers == null) {	
		// Construct workers bean
		if (getBosscode() != null) {
			workers = new WorkerAccessBean();
			workers.setInitKey_worker(getBosscode().intValue());
			workers.refreshCopyHelper();
		}
	}
	return workers;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	setInitIsactive(getIsactive().booleanValue());
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
 * Creation date: (22.02.2002 14:28:36)
 * @return com.hps.july.security.persistence.WorkersAccessBean
 */
public Worker getBoss() throws Exception {

	WorkerAccessBean bean = constructWorkers();
	if (bean != null)
	  return (Worker)bean.getEJBRef();
	else
	  return null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:25:12)
 * @return int
 */
public Integer getBosscode() {
	return bosscode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:25:40)
 * @return java.lang.String
 */
public java.lang.String getBossname() {
	return bossname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	DepartmentAccessBean bean = new DepartmentAccessBean();
	bean.setInitKey_division( getDepartment() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2002 11:35:58)
 * @return int
 */
public int getDepartment() {
	return department;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2003 15:15:42)
 * @return boolean
 */
public boolean getInitIsactive() {
	return initIsactive;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2003 18:43:44)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsactive() {
	return isactive;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:41:09)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2002 17:13:35)
 * @return int
 */
public int getService() {
	return service;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:41:34)
 * @return java.lang.String
 */
public java.lang.String getShortname() {
	return shortname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.security.APPStates.EDITDEP;
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
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setBoss(WorkerAccessBean newWorkers) throws Exception {
	if (newWorkers == null) {
	  bosscode = null;
	  bossname = "";
	}
	else {
		bosscode = new Integer(newWorkers.getWorker());
		bossname = newWorkers.getMan().getFullName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:25:12)
 * @param newBoss int
 */
public void setBosscode(Integer newBoss) {
	bosscode = newBoss;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:25:40)
 * @param newBossname java.lang.String
 */
public void setBossname(java.lang.String newBossname) {
	bossname = newBossname;
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2002 11:35:58)
 * @param newDepartment int
 */
public void setDepartment(int newDepartment) {
	department = newDepartment;
}
/**
 * Insert the method's description here.
 * Creation date: (01.08.2003 15:15:42)
 * @param newInitIsactive boolean
 */
public void setInitIsactive(boolean newInitIsactive) {
	initIsactive = newInitIsactive;
}
/**
 * Insert the method's description here.
 * Creation date: (23.07.2003 18:43:44)
 * @param newIsactive java.lang.Boolean
 */
public void setIsactive(java.lang.Boolean newIsactive) {
	isactive = newIsactive;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:41:09)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (16.04.2002 17:13:35)
 * @param newService int
 */
public void setService(int newService) {
	service = newService;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 13:41:34)
 * @param newShortname java.lang.String
 */
public void setShortname(java.lang.String newShortname) {
	shortname = newShortname;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.department.name"));

	if ((getShortname() == null) || (getShortname().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.department.shortname"));

	try {
		
		if (getBosscode() != null)
			constructWorkers();
	} catch (Exception ex) {
		if (ErrorProcessor.isRecordNotExistException(ex))
		  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.department.worker"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
