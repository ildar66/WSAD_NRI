package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования единицы измерения
 */
public class UnitForm extends com.hps.july.web.util.EditForm {
	private int unit;
	private java.lang.String name;
	private java.lang.String shortname;
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setUnit(keyGen.getNextKey("tables.units"));
    UnitAccessBean bean = new UnitAccessBean(getUnit(), getName(), getShortname() );	
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
	UnitAccessBean bean = new UnitAccessBean();
	bean.setInitKey_unit( getUnit() );
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
 * Creation date: (21.02.2002 12:42:28)
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
	return com.hps.july.dictionary.APPStates.EDITUNIT;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:40:46)
 * @return int
 */
public int getUnit() {
	return unit;
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
 * Creation date: (21.02.2002 12:42:28)
 * @param newShortname java.lang.String
 */
public void setShortname(java.lang.String newShortname) {
	shortname = newShortname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:40:46)
 * @param newCompany int
 */
public void setUnit(int newUnit) {
	unit = newUnit;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getName() == null) || (getName().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.unit.name"));
	  
	if ((getShortname() == null) || (getShortname().length() == 0))
	  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.unit.shortname"));
	
	if (!errors.empty())
		throw new ValidationException();
}
}
