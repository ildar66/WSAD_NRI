package com.hps.july.siteinfo.formbean;

import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import com.hps.july.util.*;
import com.hps.july.web.util.*;
import com.hps.july.siteinfo.*;
import com.hps.july.constants.*;
import com.hps.july.commonbean.*;
import com.hps.july.persistence.*;
import com.hps.july.persistence2.*;

/**
 * Форма редактирования мест размещения антенн.
 */
public class AntennaPlacesForm extends com.hps.july.web.util.EditForm {
	private java.lang.String name;
	private int antplaceid;
	private boolean isvc;
/**
 * Создание новой записи.
 * Creation date: (29.04.2004 12:25:27)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setAntplaceid(keyGen.getNextKey("tables.antennplaces"));
    AntennPlacesAccessBean bean = new AntennPlacesAccessBean(getAntplaceid(), getName(), isIsvc());
	return bean;
}
public int getAntplaceid() {
	return antplaceid;
}
/**
 * Текущее приложение.
 * Creation date: (29.04.2004 12:25:27)
 * @return int
 */
public int getApplication() {
	return Applications.SITEINFO;
}
/**
 * Считывание существующей записи.
 * Creation date: (29.04.2004 12:25:27)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	AntennPlacesAccessBean bean = new AntennPlacesAccessBean();
	bean.setInitKey_antplaceid( getAntplaceid() );
	return bean;
}
public boolean getIsvc() {
	return isvc;
}
public java.lang.String getName() {
	return name;
}
/**
 * Текущее состояние приложения.
 * Creation date: (29.04.2004 12:25:27)
 * @return int
 */
public int getState() {
	return APPStates.EDITANTENNAPLACE;
}
public boolean isIsvc() {
	return isvc;
}
public void setAntplaceid(int newAntplaceid) {
	antplaceid = newAntplaceid;
}
public void setIsvc(boolean newIsvc) {
	isvc = newIsvc;
}
public void setName(java.lang.String newName) {
	name = newName;
}
/**
 * Проверка введенных пользователем значений.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if ( (getName() == null) || (getName().length() == 0) )
	    errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.antennplaces.name"));
	if (!errors.empty())
		throw new ValidationException();
}
}
