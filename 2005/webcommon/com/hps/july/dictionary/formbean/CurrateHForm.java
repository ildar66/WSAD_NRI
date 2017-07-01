package com.hps.july.dictionary.formbean;

import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма редактирования курса валюты на указанную дату
 */
public class CurrateHForm extends com.hps.july.web.util.EditForm {
	private int ratetype;
	private StringAndSqlDateProperty date;
	private StringAndBigDecimalProperty value;
	private int currency;
	private java.lang.String ratetypename;
/**
 * Insert the method's description here.
 * Creation date: (27.04.2002 15:33:29)
 */
public CurrateHForm() {
	date = new StringAndSqlDateProperty();
	value = new StringAndBigDecimalProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	CurrateHListForm aform = (CurrateHListForm)request.getSession().getAttribute( "CurrateHListForm" );
	setCurrency(aform.getCurrency());
	//setRatetype(aform.getRatetype());
    RateAccessBean bean = new RateAccessBean(
	    new CurrencyKey(getCurrency()),
	    new RateTypeKey(getRatetype()),
	    getDate(),
	    getValue()
	);
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
 * Creation date: (26.04.2002 14:22:52)
 * @return int
 */
public int getCurrency() {
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	CurrateHListForm aform = (CurrateHListForm)request.getSession().getAttribute( "CurrateHListForm" );
	setCurrency(aform.getCurrency());
	setRatetype(aform.getRatetype());
	RateAccessBean bean = new RateAccessBean();
	bean.setInitKey_type_ratetype(new Integer(getRatetype()));
	bean.setInitKey_currency_currency(new Integer(getCurrency()));
	bean.setInitKey_date(getDate());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @return int
 */
public java.sql.Date getDate() {
	return date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @return int
 */
public String getDatestr() {
	return date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 12:00:04)
 * @return int
 */
public int getRatetype() {
	return ratetype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 15:21:59)
 * @return java.lang.String
 */
public java.lang.String getRatetypename() {
	return ratetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.05.2002 14:05:43)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getRatetypes() {
	try {
		com.hps.july.persistence.RateTypeAccessBean bean = new com.hps.july.persistence.RateTypeAccessBean();
		return bean.findAllOrderByNameAsc();
	} catch(Exception e) {
		return (new java.util.Vector()).elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITCRTH;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @return int
 */
public java.math.BigDecimal getValue() {
	return value.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @return int
 */
public String getValuestr() {
	return value.getString();
}
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	CurrateHListForm f = (CurrateHListForm)request.getSession().getAttribute( "CurrateHListForm" );
	setCurrency(f.getCurrency());
	setRatetype(f.getRatetype());
	setRatetypename(f.getRatetypename());
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 14:22:52)
 * @param newCurrency int
 */
public void setCurrency(int newCurrency) {
	currency = newCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @param newResourcesubtype int
 */
public void setDate(java.sql.Date newDate) {
	date.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 17:06:09)
 * @param newResourcesubtype int
 */
public void setDatestr(String newDate) {
	date.setString(newDate);
}
/**
 * Insert the method's description here.
 */
public void setRatetype(int newRatetype) {
	ratetype = newRatetype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 15:21:59)
 * @param newRatetypename java.lang.String
 */
public void setRatetypename(java.lang.String newRatetypename) {
	ratetypename = newRatetypename;
}
/**
 * Insert the method's description here.
 */
public void setValue(java.math.BigDecimal newValue) {
	value.setBigDecimal(newValue);
}
/**
 * Insert the method's description here.
 */
public void setValuestr(String newValue) {
	value.setString(newValue);
}
public void validateValues(ActionErrors errors) throws Exception 
{
	if(date.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currateh.date"));
	} else if(!date.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.currateh.date"));
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}

	try {
		RateAccessBean bean = new RateAccessBean();
		bean.setInitKey_type_ratetype(new Integer(getRatetype()));
		bean.setInitKey_currency_currency(new Integer(getCurrency()));
		bean.setInitKey_date(getDate());
		bean.refreshCopyHelper();
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.present.currateh.value"));
	} catch(Exception e) {
	}

	if(value.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currateh.value"));
	} else if(!value.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.currateh.value"));
	} else if( getValue().signum()<=0 ) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.notpositive.currateh.value"));
	}
		
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
