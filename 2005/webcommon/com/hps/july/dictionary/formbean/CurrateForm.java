package com.hps.july.dictionary.formbean;

import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;
import java.util.*;
import com.hps.july.dictionary.valueobject.CurrencyVO;
/**
 * Форма редактирования курса валюты
 */
public class CurrateForm extends com.hps.july.web.util.EditForm {
	private StringAndSqlDateProperty date;
	private int ratetype;
	private StringAndBigDecimalProperty value;
	private java.lang.String currencyname;
	private java.lang.String ratetypename;
	private StringAndIntegerProperty currencycode;
	private java.util.ArrayList currencies;
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:38:00)
 */
public CurrateForm() {
	value = new StringAndBigDecimalProperty();
	ratetype = 0;
	ratetypename = "";
	date = new StringAndSqlDateProperty();
	currencycode = new StringAndIntegerProperty();
	currencycode.setInteger(new Integer(0));
	currencyname = "";
	initCurrencies();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
	CurrateListForm aform = (CurrateListForm)request.getSession().getAttribute( "CurrateListForm" );
	//setRatetype(aform.getRatetype());
    RateAccessBean bean = new RateAccessBean(
	    new CurrencyKey(getCurrencycode().intValue()), new RateTypeKey(getRatetype()), getDate(), getValue());	
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
 * Creation date: (05.04.2005 17:36:41)
 * @return java.util.ArrayList
 */
public java.util.ArrayList getCurrencies() {
	return currencies;
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 16:47:24)
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrencycode() {
	return currencycode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 16:47:41)
 * @return java.lang.String
 */
public java.lang.String getCurrencycodestr() {
	return currencycode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 17:46:30)
 * @return java.lang.String
 */
public java.lang.String getCurrencyname() {
	return currencyname;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	CurrateListForm aform = (CurrateListForm)request.getSession().getAttribute( "CurrateListForm" );
	setRatetype(aform.getRateType().getRatetype().intValue());
	RateAccessBean bean = new RateAccessBean();
	bean.setInitKey_currency_currency(getCurrencycode());
	bean.setInitKey_date(getDate());
	bean.setInitKey_type_ratetype(new Integer(getRatetype()));
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:04:45)
 * @return java.sql.Date
 */
public java.sql.Date getDate() {
	return date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:11:03)
 * @return java.lang.String
 */
public String getDatestr() {
	return date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:06:11)
 * @return int
 */
public int getRatetype() {
	return ratetype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 17:52:35)
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
	return com.hps.july.dictionary.APPStates.EDITCRT;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:07:45)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getValue() {
	return value.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:11:18)
 * @return java.lang.String
 */
public String getValuestr() {
	return value.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2005 17:37:05)
 */
private void initCurrencies() {
    try {
        ArrayList listCurrencies = new ArrayList();
        CurrencyAccessBean bean = new CurrencyAccessBean();
        Enumeration enum = bean.findAllOrderByNameAsc();
        while (enum.hasMoreElements()) {
            CurrencyAccessBean ab = (CurrencyAccessBean) enum.nextElement();
            CurrencyVO vo = new CurrencyVO(new Integer(ab.getCurrency()));
            vo.setName(ab.getName());
            listCurrencies.add(vo);
        }
        setCurrencies(listCurrencies);
    } catch (Exception e) {
        System.out.println("CurrateListForm.initCurrencies(): Ошибка формирования листа валют!!!");
        e.printStackTrace(System.out);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (30.04.2002 12:55:30)
 * @param request javax.servlet.http.HttpServletRequest
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
{
	CurrateListForm f = (CurrateListForm)request.getSession().getAttribute( "CurrateListForm" );
	setRatetype(f.getRateType().getRatetype().intValue());
	setRatetypename(f.getRateType().getName());
}
/**
 * Insert the method's description here.
 * Creation date: (05.04.2005 17:36:41)
 * @param newCurrencies java.util.ArrayList
 */
public void setCurrencies(java.util.ArrayList newCurrencies) {
	currencies = newCurrencies;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setCurrency(CurrencyAccessBean newCurrency) throws Exception {
	if (newCurrency == null) {
		currencycode.setInteger(null);
		currencyname = "";
	}
	else {
		currencycode.setInteger(new Integer(newCurrency.getCurrency()));
		currencyname = newCurrency.getName();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 16:47:24)
 * @param newCurrencycode java.lang.Integer
 */
public void setCurrencycode(java.lang.Integer newCurrencycode) {
	currencycode.setInteger(newCurrencycode);
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 16:47:41)
 * @param newCurrencycodestr java.lang.String
 */
public void setCurrencycodestr(java.lang.String newCurrencycodestr) {
	currencycode.setString(newCurrencycodestr);
}
/**
 * Insert the method's description here.
 */
public void setCurrencyname(String newCurrencyname) {
	currencyname = newCurrencyname;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:05:20)
 * @param newDate java.sql.Date
 */
public void setDate(java.sql.Date newDate) {
	date.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 14:42:09)
 * @param newDatestr java.lang.String
 */
public void setDatestr(String newDatestr) {
	date.setString(newDatestr);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:06:33)
 * @param newResource int
 */
public void setRatetype(int newRatetype) {
	ratetype = newRatetype;
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 17:52:35)
 * @param newRatetypename java.lang.String
 */
public void setRatetypename(java.lang.String newRatetypename) {
	ratetypename = newRatetypename;
}
/**
 * Insert the method's description here.
 * Creation date: (26.04.2002 17:53:05)
 * @param newRateType com.hps.july.persistence.RateTypeAccessBean
 */
public void setType(RateTypeAccessBean newRateType) {
	try {
		ratetype = newRateType.getRatetype();
		ratetypename = newRateType.getName() + " (" + newRateType.getBasecurrency().getShortname() + ")";
	} catch(Exception e) {
		ratetype = 0;
		ratetypename = "";
	}
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
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if (currencycode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currate.currency"));
	}
	
	if (!currencycode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.currate.currency"));
	} else if (!currencycode.isEmpty()) {
		try {
			
			CurrencyAccessBean bean = new CurrencyAccessBean();
			bean.setInitKey_currency(getCurrencycode().intValue());
			bean.refreshCopyHelper();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.currate.currency"));
		}
	}
	
	if(date.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currate.date"));
	}
	if(!date.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.currate.date"));
	}

	if(value.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.currate.value"));
	}
	if(!value.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.currate.value"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
