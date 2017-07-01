package com.hps.july.arenda.formbean;

import java.math.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.sql.Date;
/**
 * Form-Bean.
 * список параметров 1-го отчета "Аренды".
 * Creation date: (20.02.2003 11:15:52)
 * @author: Sergey Gourov
 */
public class ArendaReport1ParamsForm extends ReportForm {
	private com.hps.july.web.util.StringAndSqlDateProperty date;
	private int orgCustomercode;
	private java.lang.String calctype;
	private com.hps.july.web.util.StringAndBigDecimalProperty rate;
/**
 * ArendaReport1ParamsForm constructor comment.
 */
public ArendaReport1ParamsForm() {
	super();
	date = new StringAndSqlDateProperty();
	rate = new StringAndBigDecimalProperty();
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2003 15:16:17)
 * @return java.lang.String
 */
public java.lang.String getCalctype() {
	return calctype;
}
/**
 * Insert the method's description here.
 * Creation date: (03.07.2002 13:06:43)
 * @return java.util.Enumeration
 */
public java.util.Enumeration getCustomers() {
	try {
		return new OrganizationAccessBean().findOurOrganizations();
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();	
	}
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:44:34)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDate() {
	return date.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:44:34)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDateFrm() {
	return date.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:58:15)
 * @return int
 */
public int getOrgCustomercode() {
	return orgCustomercode;
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2003 15:26:07)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getRate() {
	return rate.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2003 15:26:07)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getRateFrm() {
	return rate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:15:52)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.ARENDA_REPORT1_PARAMS;
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2003 15:16:17)
 * @param newCalctype java.lang.String
 */
public void setCalctype(java.lang.String newCalctype) {
	calctype = newCalctype;
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:44:34)
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDate(Date newDate) {
	date.setSqlDate(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:44:34)
 * @param newDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDateFrm(String newDate) {
	date.setString(newDate);
}
/**
 * Insert the method's description here.
 * Creation date: (20.02.2003 11:58:15)
 * @param newOrgCustomercode int
 */
public void setOrgCustomercode(int newOrgCustomercode) {
	orgCustomercode = newOrgCustomercode;
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2003 15:26:07)
 * @param newRate com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRate(BigDecimal newRate) {
	rate.setBigDecimal(newRate);
}
/**
 * Insert the method's description here.
 * Creation date: (26.02.2003 15:26:07)
 * @param newRate com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setRateFrm(String newRate) {
	rate.setString(newRate);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
/*	if (getCalctype().equals("R")) {
		NamedValueAccessBean nvBean = new NamedValueAccessBean();
		nvBean.setInitKey_id("BASE_RATETYPE_ARENDA");
		nvBean.refreshCopyHelper();
		
		java.util.Enumeration e = new RateAccessBean().findByTypeDate(new Integer(nvBean.getIntvalue()), getDate());
		if (e.hasMoreElements()) {
			RateAccessBean bean = (RateAccessBean) e.nextElement();
			setRate(bean.getValue());
			throw new ValidationException();
		} else {
			setRate(null);
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.report.rate"));
			throw new ValidationException();
		}
	}
	
	if (rate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.report.rate"));
	} else if (!rate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.report.rate"));
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}*/
}
}
