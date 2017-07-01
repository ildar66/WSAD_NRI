package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;

/**
 * Форма редактирования данных об автомашинах дирекции (отдела, группы и т.п.)
 */
public class CarForm extends com.hps.july.web.util.EditForm {
	private int car;
	private java.lang.String car_model;
	private java.lang.String car_number;
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:35:04)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	setCar(new KeyGeneratorAccessBean().getNextKey("tables.cars"));
	CarAccessBean bean = new CarAccessBean(getCar(), new Boolean(false), getCar_model(), getCar_number());
	
	OrganizationAccessBean orgBean = new OrganizationAccessBean();
	orgBean.setInitKey_organization(((CarsList) request.getSession().getAttribute("CarsList")).getOrganization());
	orgBean.refreshCopyHelper();
	
	bean.setOrganization((Organization) orgBean.getEJBRef());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:35:04)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:36:03)
 * @return int
 */
public int getCar() {
	return car;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:41:00)
 * @return java.lang.String
 */
public java.lang.String getCar_model() {
	return car_model;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:41:11)
 * @return java.lang.String
 */
public java.lang.String getCar_number() {
	return car_number;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:35:04)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	CarAccessBean bean = new CarAccessBean();
	bean.setInitKey_car(getCar());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:35:04)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.CAR_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:36:03)
 * @param newCar int
 */
public void setCar(int newCar) {
	car = newCar;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:41:00)
 * @param newCar_model java.lang.String
 */
public void setCar_model(java.lang.String newCar_model) {
	car_model = newCar_model;
}
/**
 * Insert the method's description here.
 * Creation date: (22.07.2003 11:41:11)
 * @param newCar_number java.lang.String
 */
public void setCar_number(java.lang.String newCar_number) {
	car_number = newCar_number;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (getCar_model() == null || getCar_model().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.car.model"));
	}
	
	if (getCar_number() == null || getCar_number().length() == 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.car.number"));
	}
	
	if (!errors.empty()) throw new ValidationException();
}
}
