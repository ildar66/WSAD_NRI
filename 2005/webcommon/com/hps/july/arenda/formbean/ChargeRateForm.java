package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.arenda.sessionbean.*;
import java.util.Enumeration;
import org.apache.struts.action.*;
import java.sql.Date;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.math.*;
/**
 * form-bean
 * форма для ставок начислений
 * Creation date: (09.01.2003 16:40:35)
 * @author: Sergey Gourov
 */
public class ChargeRateForm extends com.hps.july.web.util.EditForm {
	private int docpositioncode;
	private int currencycode;
	private StringAndBigDecimalProperty rate;
	private java.lang.Boolean byhand;

	private java.lang.String documentNumber;
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private String currency1;
	private String currency2;
	private java.lang.String curr1;
	private java.lang.String curr2;

	private StringAndSqlDateProperty chargedate;
	private String resourcename;
	private String sum;
	private java.lang.String chargecurrency;
	protected java.lang.String listForm;
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:48:18)
 */
public ChargeRateForm() {
	startDate = new StringAndSqlDateProperty();
	endDate = new StringAndSqlDateProperty();
	chargedate = new StringAndSqlDateProperty();
	rate = new StringAndBigDecimalProperty();
	setByhand(new Boolean(true));
	listForm = "ChargeRatesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:17:02)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void beforeDelete(AbstractEntityAccessBean bean, javax.servlet.http.HttpServletRequest request) throws Exception {
/**
 * "При удалении курса начисления убрать проверку "начисление не в открытом периоде"
	if (!new LeaseArendaAgreementProcessorAccessBean().checkOpenPeriod(getDocpositioncode())) {
		throw new UpdateValidationException("error.rate.chargenotinopenperiod");
	}
*/	
}
/**
 * Insert the method's description here.
 * Creation date: (16.12.2002 16:34:54)
 * @return boolean
 */
private boolean checkOpenPeriod() throws Exception {
	LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
	lpBean.setInitKey_leaseDocPosition(getDocpositioncode());
	lpBean.refreshCopyHelper();
	
	Enumeration e = new LeaseSaldoAccessBean().findByLeaseContractAndResourceOrderDateDesc(
		new Integer(lpBean.getLeaseContractKey().leaseDocument), new Integer(lpBean.getResourceKey().resource));
	if (e.hasMoreElements()) {
		LeaseSaldoAccessBean bean = (LeaseSaldoAccessBean) e.nextElement();
		return lpBean.getDate().after(bean.getSalDate()) ? true : false;
	}
	return true;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
/* @param argDocPosition java.lang.Integer
 * @param argCurrency java.lang.Integer
 * @param argRate java.math.BigDecimal
 * @param argByHand java.lang.Boolean*/
	
	return new LeaseCalcRateAccessBean(new Integer(getDocpositioncode()), new Integer(getCurrencycode()), getRate(), getByhand());
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:39:12)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getByhand() {
	return byhand;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 18:42:02)
 * @return java.lang.String
 */
public java.lang.String getChargecurrency() {
	return chargecurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 18:42:02)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getChargedate() {
	return chargedate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 18:42:02)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getChargedateFrm() {
	return chargedate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
public java.util.Enumeration getCurrencies() {
	try {
		return new CurrencyAccessBean().findAllOrderByNameAsc();
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return BigDecimal
 */
public String getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return BigDecimal
 */
public String getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:35:23)
 * @return int
 */
public int getCurrencycode() {
	return currencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseCalcRateAccessBean bean = new LeaseCalcRateAccessBean();
	bean.setInitKey_docposition_leaseDocPosition(new Integer(getDocpositioncode()));
	bean.setInitKey_currency_currency(new Integer(getCurrencycode()));
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 19:08:15)
 * @return int
 */
public int getDocpositioncode() {
	return docpositioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEndDate() {
	return endDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEndDateFrm() {
	return endDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:38:03)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRate() {
	return rate.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:38:03)
 * @return java.math.BigDecimal
 */
public String getRateFrm() {
	return rate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 18:42:02)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getStartDate() {
	return startDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getStartDateFrm() {
	return startDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:40:35)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHARGE_RATE_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @return java.math.BigDecimal
 */
public String getSum() {
	return sum;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	ChargeRatesListForm oform = (ChargeRatesListForm) request.getSession().getAttribute(listForm);

	setDocpositioncode(oform.getDocpositioncode());
	setDocumentNumber(oform.getDocumentNumber());
	setStartDate(oform.getStartDate());
	setEndDate(oform.getEndDate());
	setOrgCustomer(oform.getOrgCustomer());
	setOrgExecutor(oform.getOrgExecutor());
	setCurrency1(oform.getCurrency1().toString());
	if (oform.getCurrency2() != null) {
		setCurrency2(oform.getCurrency2().toString());
	} else {
		setCurrency2(null);
	}
	setCurr1(oform.getCurr1());
	setCurr2(oform.getCurr2());

	setChargedate(oform.getChargedate());
	setResourcename(oform.getResourcename());
	if (oform.getSum() != null) {
		setSum(oform.getSum().toString());
	} else {
		setSum("");
	}
	setChargecurrency(oform.getChargecurrency());
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:39:12)
 * @param newByhand java.lang.Boolean
 */
public void setByhand(java.lang.Boolean newByhand) {
	byhand = newByhand;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 18:42:02)
 * @param newChargecurrency java.lang.String
 */
public void setChargecurrency(java.lang.String newChargecurrency) {
	chargecurrency = newChargecurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 18:42:02)
 * @param newChargedate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setChargedate(Date newChargedate) {
	chargedate.setSqlDate(newChargedate);
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 18:42:02)
 * @param newChargedate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setChargedateFrm(String newChargedate) {
	chargedate.setString(newChargedate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newCurrency1 BigDecimal
 */
public void setCurrency1(String newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newCurrency2 BigDecimal
 */
public void setCurrency2(String newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:35:23)
 * @param newCurrencycode int
 */
public void setCurrencycode(int newCurrencycode) {
	currencycode = newCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (16.01.2003 19:08:15)
 * @param newDocpositioncode int
 */
public void setDocpositioncode(int newDocpositioncode) {
	docpositioncode = newDocpositioncode;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDate(Date newEndDate) {
	endDate.setSqlDate(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:38:03)
 * @param newRate java.math.BigDecimal
 */
public void setRate(java.math.BigDecimal newRate) {
	rate.setBigDecimal(newRate);
}
/**
 * Insert the method's description here.
 * Creation date: (09.01.2003 16:38:03)
 * @param newRate java.math.BigDecimal
 */
public void setRateFrm(String newRate) {
	rate.setString(newRate);
}
/**
 * Insert the method's description here.
 * Creation date: (22.01.2003 18:42:02)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDate(Date newStartDate) {
	startDate.setSqlDate(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDateFrm(String newStartDate) {
	startDate.setString(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (17.01.2003 11:36:28)
 * @param newSum java.math.BigDecimal
 */
public void setSum(String newSum) {
	sum = newSum;
}
public void validateValues(ActionErrors errors) throws Exception {
	if (rate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.rate.rate"));
	} else if (!rate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.rate.rate"));
	} else if (rate.getBigDecimal().doubleValue() <= 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.rate.rate.sign"));
	}

	// Вместо данной проверки выполнить (если в платеже UsedInAct is not null то выдать "error.rate.chargeapplied")
	if(ChargeForm.isInAct(getDocpositioncode())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.chargerate.applied"));
	}
	
	/*
	if (!new LeaseArendaAgreementProcessorAccessBean().checkOpenPeriod(getDocpositioncode())) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.rate.chargenotinopenperiod"));
	}
	*/
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
