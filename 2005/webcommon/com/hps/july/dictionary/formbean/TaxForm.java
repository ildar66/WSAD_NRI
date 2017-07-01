package com.hps.july.dictionary.formbean;

import java.math.*;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import com.hps.july.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования налога
 */
public class TaxForm extends com.hps.july.web.util.EditForm {
	private StringAndSqlDateProperty date;
	private StringAndBigDecimalProperty nds;
	private StringAndBigDecimalProperty nsp;
	private java.lang.String resourcename;
	private StringAndIntegerProperty resourcecode;
	private java.lang.String resourcemodel;
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:38:00)
 */
public TaxForm() {
	nds = new StringAndBigDecimalProperty();
	nsp = new StringAndBigDecimalProperty();
	date = new StringAndSqlDateProperty();
	resourcecode = new StringAndIntegerProperty();
	resourcecode.setInteger(new Integer(0));
	resourcename = "";
	resourcemodel = "";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
    ResourceTaxeAccessBean bean = new ResourceTaxeAccessBean(
	    getDate(),getResourcecode(),getNds(),getNsp());	
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
	
	ResourceTaxeAccessBean bean = new ResourceTaxeAccessBean();
	bean.setInitKey_resource_resource(getResourcecode());
	bean.setInitKey_date(getDate());
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
 * Creation date: (25.04.2002 11:07:45)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNds() {
	return nds.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:11:18)
 * @return java.lang.String
 */
public String getNdsstr() {
	return nds.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:08:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getNsp() {
	return nsp.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:11:36)
 * @return java.lang.String
 */
public String getNspstr() {
	return nsp.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 15:16:25)
 * @return java.lang.Integer
 */
public java.lang.Integer getResourcecode() {
	return resourcecode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 15:16:42)
 * @return java.lang.String
 */
public java.lang.String getResourcecodestr() {
	return resourcecode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 10:38:16)
 * @return java.lang.String
 */
public java.lang.String getResourcemodel() {
	return resourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 17:46:30)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITTAX;
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
 * Creation date: (25.04.2002 11:08:13)
 * @param newNds java.math.BigDecimal
 */
public void setNds(java.math.BigDecimal newNds) {
	nds.setBigDecimal(newNds);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:12:03)
 * @param newNds java.lang.String
 */
public void setNdsstr(String newNds) {
	nds.setString(newNds);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:08:13)
 * @param newNds java.math.BigDecimal
 */
public void setNsp(java.math.BigDecimal newNsp) {
	nsp.setBigDecimal(newNsp);
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 11:12:46)
 * @param newNsp java.lang.String
 */
public void setNspstr(String newNsp) {
	nsp.setString(newNsp);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 14:28:36)
 * @param newWorkers com.hps.july.security.persistence.WorkersAccessBean
 */
public void setResource(ResourceAccessBean newResource) throws Exception {
	if (newResource == null) {
	  resourcecode.setInteger(null);
	  resourcename = "";
	  resourcemodel = "";
	}
	else {
		resourcecode.setInteger(new Integer(newResource.getResource()));
		resourcename = newResource.getName();
		resourcemodel = newResource.getModel();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 15:16:25)
 * @param newResourcecode java.lang.Integer
 */
public void setResourcecode(java.lang.Integer newResourcecode) {
	resourcecode.setInteger(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (29.05.2002 15:16:42)
 * @param newResourcecodestr java.lang.String
 */
public void setResourcecodestr(java.lang.String newResourcecodestr) {
	resourcecode.setString(newResourcecodestr);
}
/**
 * Insert the method's description here.
 * Creation date: (30.05.2002 10:38:16)
 * @param newResourcemodel java.lang.String
 */
public void setResourcemodel(java.lang.String newResourcemodel) {
	resourcemodel = newResourcemodel;
}
/**
 * Insert the method's description here.
 * Creation date: (25.04.2002 17:46:30)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	// check resource
	if (resourcecode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.restax.resource"));
	} else if (!resourcecode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.restax.resource"));
	} else {
		try {
			
			ResourceAccessBean bean = new ResourceAccessBean();
			bean.setInitKey_resource(getResourcecode().intValue());
			bean.refreshCopyHelper();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
			  errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.restax.resource"));
		}
	}
	
	if(date.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.restax.date"));
	}
	if(!date.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.restax.date"));
	}

	if(nds.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.restax.nds"));
	} else if(!nds.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.restax.nds"));
	} else {
		if ( (nds.getBigDecimal().compareTo(new BigDecimal(100)) > 0) || 
			(nds.getBigDecimal().compareTo(new BigDecimal(0)) < 0) )
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.restax.nds"));
	}

	if(nsp.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.restax.nsp"));
	} else if(!nsp.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.restax.nsp"));
	} else {
		if ( (nsp.getBigDecimal().compareTo(new BigDecimal(100)) > 0) || 
			(nsp.getBigDecimal().compareTo(new BigDecimal(0)) < 0) )
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.restax.nsp"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
