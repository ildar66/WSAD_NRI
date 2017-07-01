package com.hps.july.dictionary.formbean;

import java.util.StringTokenizer;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.cdbc.objects.*;

/**
 * Форма ввода/редактирования задвоенных кодов оборудования
 */
public class DoubleForm extends com.hps.july.web.util.EditForm {
	private java.lang.Boolean active;
	private int actualcode;
	private java.lang.String actualname;
	private int resource;
	private java.lang.String name;
	private java.lang.String actualmodel;
	private java.lang.String model;
/**
 * Метод вызывается после добавления/изменения основной записи.
 * Creation date: (13.02.2002 10:21:31)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void afterUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
}
public void beforeUpdate(AbstractEntityAccessBean bean,
	javax.servlet.http.HttpServletRequest request) throws Exception {
		ResourceAccessBean rab = (ResourceAccessBean)bean;
		//System.out.println("Resource = " + rab.getResource() + ", actRes = " + rab.getActualcode());
		// Integer res = new CDBCResourcesObject().recodeResource(new Integer(rab.getResource()), new Integer(rab.getActualcode()));
		Object[] res = new CDBCResourcesObject().recodeResource(new Integer(rab.getResource()), new Integer(rab.getActualcode()));
		Integer resInt = (Integer)res[0]; 
		//System.out.println("UPDATE Result = " + res);
		if ( (res != null) && (resInt.intValue() == 1) ) {
			throw new UpdateValidationException("error.resource.double.difftype");
		} else if ( (res != null) && (resInt.intValue() == 2) ) {
			throw new UpdateValidationException("error.resource.double.diffpolicy");
		} else if ( (res != null) && (resInt.intValue() == 3) ) {
			throw new UpdateValidationException("error.resource.double.datatypeConflict");
		} else if ( (res != null) && (resInt.intValue() == 4) ) {
			throw new UpdateValidationException("error.resource.double.confTablesConflict");
		} else if ( (res != null) && (resInt.intValue() == 5) ) {
			throw new UpdateValidationException("error.resource.double.theSameResourceConflict");
		} else if ( (res != null) && (resInt.intValue() == 6) ) {
					throw new UpdateValidationException("error.resource.double.theFakeResourceConflict");
		} else if ( (res != null) && (resInt.intValue() == 7) ) {
					String errStr01 = (String)res[1]; 
					String errStr02 = (String)res[2];
					errStr02 = errStr02.substring(0, errStr02.length()-3);
					StringTokenizer st = new StringTokenizer(errStr02, ",");
					int groupCount = 0;
					while (st.hasMoreTokens()) {
						String ttt = st.nextToken();
						groupCount++; 						
					}
					String subStr02 = ". Группа оборудования номер: ";
					String subStr03 = " содержит консолидируемый и главный ресурсы.";
					if (groupCount > 1) {
						subStr02 = ". Группы оборудования номер: ";
						subStr03 = " содержат консолидируемый и главный ресурсы.";
					}
			        throw new UpdateValidationException(
						"Консолидация невозможна. Класс оборудования: " + errStr01 +
						subStr02 + errStr02 + subStr03);
		} else if ( (res != null) && (resInt.intValue() == 0) ) {
			// All OK
		} else {
			throw new UpdateValidationException("error.resource.double.changeerr");
		}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	/*
	RessbtypeListForm aform = (RessbtypeListForm)request.getSession().getAttribute( "RessbtypeListForm" );
	setResourcetype(aform.getResourcetype());
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setResourcesubtype(keyGen.getNextKey("tables.ressbtypes"));
	ResourceSubTypeAccessBean bean = new ResourceSubTypeAccessBean(getResourcesubtype(), getName(), new Integer(getResourcetype()) );
	*/
	return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.05.2002 13:30:52)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean)
{
	if(getActualcode() > 0) {
		try {
			ResourceAccessBean abean = new ResourceAccessBean();
			abean.setInitKey_resource(getActualcode());
			abean.refreshCopyHelper();
			setActualname(abean.getName());
			setActualmodel(abean.getModel());
		} catch(Exception e) {
			setActualname("");
			setActualmodel("");
		}
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 18:05:05)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getActive() {
	return active;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 18:05:42)
 * @return int
 */
public int getActualcode() {
	return actualcode;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 9:19:06)
 * @return java.lang.String
 */
public java.lang.String getActualmodel() {
	return actualmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 18:05:57)
 * @return java.lang.String
 */
public java.lang.String getActualname() {
	return actualname;
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
	ResourceAccessBean bean = new ResourceAccessBean();
	bean.setInitKey_resource(getResource());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 9:23:51)
 * @return java.lang.String
 */
public java.lang.String getModel() {
	return model;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 15:25:15)
 * @return java.lang.String
 */
public java.lang.String getName() {
	return name;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 15:06:38)
 * @return int
 */
public int getResource() {
	return resource;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITDBL;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 18:05:05)
 * @param newActive java.lang.Boolean
 */
public void setActive(java.lang.Boolean newActive) {
	active = newActive;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 18:05:42)
 * @param newActualcode int
 */
public void setActualcode(int newActualcode) {
	actualcode = newActualcode;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 9:19:06)
 * @param newActualmodel java.lang.String
 */
public void setActualmodel(java.lang.String newActualmodel) {
	actualmodel = newActualmodel;
}
/**
 * Insert the method's description here.
 * Creation date: (29.04.2002 18:05:57)
 * @param newActualname java.lang.String
 */
public void setActualname(java.lang.String newActualname) {
	actualname = newActualname;
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 9:23:51)
 * @param newModel java.lang.String
 */
public void setModel(java.lang.String newModel) {
	model = newModel;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 15:25:15)
 * @param newName java.lang.String
 */
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 15:06:38)
 * @param newResource int
 */
public void setResource(int newResource) {
	resource = newResource;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	setActive(new Boolean(false));
	
	if (!errors.empty())
		throw new ValidationException();
}
}
