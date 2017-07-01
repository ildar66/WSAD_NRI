package com.hps.july.dictionary.formbean;

import com.hps.july.inventory.sessionbean.DocumentProcessorAccessBean;
import com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean;
import com.hps.july.web.util.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * Форма ввода и редактирования системной константы
 */
public class SysconstForm extends com.hps.july.web.util.EditForm {
	private static final java.text.SimpleDateFormat dateFormatter = new java.text.SimpleDateFormat("dd.MM.yyyy");
	
	private String id;
	private StringAndIntegerProperty intvalue;
	private java.lang.String charvalue;
	private java.sql.Timestamp datevalue;
	private java.lang.String datevaluestr;
	private StringAndBigDecimalProperty decimalvalue;
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 12:38:00)
 */
public SysconstForm() {
	decimalvalue = new StringAndBigDecimalProperty();
	intvalue = new StringAndIntegerProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
    NamedValueAccessBean bean = new NamedValueAccessBean(getId());	
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 17:33:04)
 */
public void fillRecord(AbstractEntityAccessBean bean)
{
	if(datevalue != null) {
		setDatevaluestr(dateFormatter.format(new java.util.Date(datevalue.getTime())));
	}
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
 * Creation date: (22.04.2002 12:54:33)
 * @return java.lang.String
 */
public java.lang.String getCharvalue() {
	return charvalue;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	NamedValueAccessBean bean = new NamedValueAccessBean();
	bean.setInitKey_id( getId() );
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 12:57:58)
 * @return java.sql.Timestamp
 */
public java.sql.Timestamp getDatevalue() {
	return datevalue;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 12:59:07)
 * @return java.lang.String
 */
public java.lang.String getDatevaluestr() {
	return datevaluestr;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 13:00:32)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getDecimalvalue() {
	return decimalvalue.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 16:43:44)
 * @return java.lang.String
 */
public java.lang.String getDecimalvaluestr() {
	return decimalvalue.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:40:46)
 * @return int
 */
public String getId() {
	return id;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 12:51:07)
 * @return int
 */
public int getIntvalue() {
	if(intvalue.getInteger() != null) {
		return intvalue.getInteger().intValue();
	} else {
		return 0;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 13:44:59)
 * @return java.lang.String
 */
public String getIntvaluestr() {
	return intvalue.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:41:44)
 * @return int
 */
public int getState() {
	return com.hps.july.dictionary.APPStates.EDITSYSC;
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 17:37:36)
 * @param request javax.servlet.http.HttpServletRequest
 * @exception java.lang.Exception The exception description.
 */
public void initRecord(javax.servlet.http.HttpServletRequest request)
	throws java.lang.Exception
{
	if(datevalue != null) {
		setDatevaluestr(dateFormatter.format(new java.util.Date(datevalue.getTime())));
	}
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 12:54:33)
 * @param newCharvalue java.lang.String
 */
public void setCharvalue(java.lang.String newCharvalue) {
	charvalue = newCharvalue;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 12:57:58)
 * @param newDatevalue java.sql.Timestamp
 */
public void setDatevalue(java.sql.Timestamp newDatevalue) {
	datevalue = newDatevalue;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 12:59:07)
 * @param newDatevaluestr java.lang.String
 */
public void setDatevaluestr(java.lang.String newDatevaluestr) {
	datevaluestr = newDatevaluestr;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 13:00:32)
 * @param newDecimalvalue java.math.BigDecimal
 */
public void setDecimalvalue(java.math.BigDecimal newDecimalvalue) {
	decimalvalue.setBigDecimal(newDecimalvalue);
}
/**
 * Insert the method's description here.
 * Creation date: (23.04.2002 16:43:44)
 * @param newDecimalvaluestr java.lang.String
 */
public void setDecimalvaluestr(java.lang.String newDecimalvaluestr) {
	decimalvalue.setString(newDecimalvaluestr);
}
/**
 * Insert the method's description here.
 * Creation date: (21.02.2002 12:40:46)
 * @param newCompany int
 */
public void setId(String newId) {
	id = newId;
}
/**
 * Insert the method's description here.
 * Creation date: (22.04.2002 12:51:07)
 * @param newIntvalue int
 */
public void setIntvalue(int newIntvalue) {
	intvalue.setInteger(new Integer(newIntvalue));
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 13:38:45)
 * @param newValue java.lang.String
 */
public void setIntvaluestr(String newValue) {
	intvalue.setString(newValue);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception 
{
	if(getDatevaluestr() != null && !"".equals(getDatevaluestr())) {
		try {
			datevalue = new java.sql.Timestamp(dateFormatter.parse(getDatevaluestr()).getTime());
		} catch(java.text.ParseException pe) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.sysconst.datevalue"));
		}
	}

	if ((getId() == null) || (getId().length() == 0)) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.sysconst.id"));
	}
	else {
		for (int i=0; i < getId().length(); i++) {
			if ( ( new Character('z').compareTo(new Character(getId().charAt(i))) < 0) || 
				( new Character('0').compareTo(new Character(getId().charAt(i))) > 0 ) ) {
	  			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.sysconst.id"));
	  			break;
			}
		}
	}
	

	if(!intvalue.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.sysconst.intvalue"));
	}

	// ******** TEMP - CALL Beans
	/*
	if (getIntvalue() != 0) {
		try {
			System.out.println("CALLING applyDocument");
			DocumentProcessorAccessBean abean = new DocumentProcessorAccessBean();
			abean.applyDocument(new Integer(getIntvalue()));
		} catch (Exception e) {
			e.printStackTrace(System.out);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.sysconst.intvalue1"));
		}
	}
	*/

	if(!decimalvalue.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.sysconst.decimalvalue"));
	}

	if (!errors.empty())
		throw new ValidationException();
}
}
