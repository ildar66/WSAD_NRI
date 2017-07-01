package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования типа курса валюты
 */
public class RatetypeForm
	extends com.hps.july.web.util.EditForm
{
	private int ratetype;
	private java.lang.String name;
	private StringAndIntegerProperty basecurrency;
	private java.lang.String basecurrencyname;
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 11:48:58)
 */
public RatetypeForm() {
	basecurrency = new StringAndIntegerProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setRatetype(keyGen.getNextKey("tables.ratetype"));
	RateTypeAccessBean bean = new RateTypeAccessBean(getRatetype(), getName(), getBasecurrencycode());
	return bean;
}
public void fillRecord(com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean bean)
{
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.DICTIONARY;
}
public Currency getBasecurrency() {
	try {
		CurrencyAccessBean bean = new CurrencyAccessBean();
		bean.setInitKey_currency(getBasecurrencycode().intValue());
		bean.refreshCopyHelper();
		return (Currency)bean.getEJBRef();
	} catch(Exception e) {
		return null;
	}
}
public java.lang.Integer getBasecurrencycode() {
	return basecurrency.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 11:43:42)
 * @return java.lang.String
 */
public java.lang.String getBasecurrencyname() {
	return basecurrencyname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:42:28)
 * @return java.lang.String
 */
public java.lang.String getBasecurrencystr() {
	return basecurrency.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	RateTypeAccessBean bean = new RateTypeAccessBean();
	bean.setInitKey_ratetype( getRatetype() );
	/*
	try {
		bean.refreshCopyHelper();
		if(bean.getBasecurrency() != null) {
			setBasecurrency(new Integer(bean.getBasecurrency().getCurrency()));
			setBasecurrencyname(bean.getBasecurrency().getName());
		}
	} catch(Exception e) {
		setBasecurrency(new Integer(0));
		setBasecurrencyname("");
	}
	*/
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
 * Creation date: (21.02.2002 12:40:46)
 * @return int
 */
public int getRatetype() {
	return ratetype;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITRATP;
}
/**
 * Insert the method's description here.
 */
public void setBasecurrency(CurrencyAccessBean newBasecurrency) {
	try {
		basecurrency.setInteger(new Integer(newBasecurrency.getCurrency()));
		basecurrencyname = newBasecurrency.getName();
	} catch(Exception e) {
		basecurrency.setInteger(new Integer(0));
		basecurrencyname = "";
	}
}
/**
 * Insert the method's description here.
 */
public void setBasecurrency(java.lang.Integer newBasecurrency) {
	basecurrency.setInteger(newBasecurrency);
}
/**
 * Insert the method's description here.
 */
public void setBasecurrencycode(java.lang.Integer newBasecurrency) {
	basecurrency.setInteger(newBasecurrency);
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 11:43:42)
 * @param newBasecurrencyname java.lang.String
 */
public void setBasecurrencyname(java.lang.String newBasecurrencyname) {
	basecurrencyname = newBasecurrencyname;
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:42:28)
 * @param newShortname java.lang.String
 */
public void setBasecurrencystr(java.lang.String newBasecurrency) {
	basecurrency.setString(newBasecurrency);
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
 */
public void setRatetype(int newRatetype) {
	ratetype = newRatetype;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if ((getName() == null) || (getName().length() == 0))
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.ratetype.name"));
	  
	if (basecurrency.isEmpty())
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.ratetype.basecur"));

	if (!basecurrency.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ratetype.basecur"));
	} else if (!basecurrency.isEmpty()) {
		try {
						
			CurrencyAccessBean bean = new CurrencyAccessBean();
			bean.setInitKey_currency(getBasecurrencycode().intValue());
			bean.refreshCopyHelper();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.ratetype.basecur"));
		}
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
