package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.ibm.ivj.ejb.runtime.*;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
import java.math.*;
import java.sql.Date;
/**
 * "Оплаты начислений"
 * Form-Bean.
 * Creation date: (25.01.2003 15:12:14)
 * @author: Sergey Gourov
 */
public class ChargeDnopForm extends com.hps.july.web.util.EditForm {
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
	private java.lang.String sumonn;
	
	protected java.lang.String listForm;
	private int leaseChargecode;
	private StringAndIntegerProperty leasePaymentcode;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal chargesum;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal payrursum;
	private java.lang.String source;
	private java.lang.Boolean byhandchangeraterur;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal chargerurrate;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal chargerursum;
	private java.lang.String actcode;
	private com.hps.july.web.util.StringAndSqlDateProperty paymentDate;
	private java.lang.String paymentNumber;
	private java.lang.String paymentSumrub;
	private java.lang.String paymentRurremainder;
	private java.lang.String paymentDisplayonly;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal paymentRate;
	private int leaseContract;
	private int currencycode;
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:20:09)
 */
public ChargeDnopForm() {
	super();
	startDate = new StringAndSqlDateProperty();
	endDate = new StringAndSqlDateProperty();
	leasePaymentcode = new StringAndIntegerProperty();
	chargedate = new StringAndSqlDateProperty();
	chargesum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	payrursum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	chargerurrate = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);
	chargerursum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	paymentRate = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);
	paymentDate = new StringAndSqlDateProperty();
	setSource("H");
	listForm = "ChargeDnopListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:12:14)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
/* @param argLeaseCharge java.lang.Integer
 * @param argLeasePayment java.lang.Integer
 * @param argChargeSum java.math.BigDecimal
 * @param argPayRurSum java.math.BigDecimal
 * @param argSource java.lang.String
 * @param argByHandChargeRateRur java.lang.Boolean*/
	return new LeaseDNOPAccessBean(new Integer(getLeaseChargecode()), getLeasePaymentcode(), getChargesum(), getPayrursum(),
		getSource(), getByhandchangeraterur());
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
		lpBean.setInitKey_leaseDocPosition(getLeasePaymentcode().intValue());
		lpBean.refreshCopyHelper();

		setPaymentDate(lpBean.getDate());
		setPaymentNumber(lpBean.getDocNumber());
		setPaymentSumrub(lpBean.getSumRub() != null ? lpBean.getSumRub().toString() : "");
		setPaymentRurremainder(lpBean.getRurremainder().toString());
	} catch (Exception e) {
		e.printStackTrace();
		setPaymentDate(null);
		setPaymentNumber("");
		setPaymentSumrub("");
		setPaymentRurremainder("");
	}

	try {	
		LeaseCalcRateAccessBean lcrBean = new LeaseCalcRateAccessBean();
		lcrBean.setInitKey_docposition_leaseDocPosition(getLeasePaymentcode());
		lcrBean.setInitKey_currency_currency(new Integer(getCurrencycode()));
		lcrBean.refreshCopyHelper();
		
		setPaymentRate(lcrBean.getRate());
	} catch (Exception e) {
		e.printStackTrace();
		setPaymentRate(null);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:37:43)
 * @return java.lang.String
 */
public java.lang.String getActcode() {
	return actcode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:12:14)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:47:42)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getByhandchangeraterur() {
	return byhandchangeraterur;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
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
 * Creation date: (25.01.2003 17:24:44)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getChargerurrate() {
	return chargerurrate.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:24:44)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getChargerurrateFrm() {
	return chargerurrate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:27:37)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getChargerursum() {
	return chargerursum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:27:37)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getChargerursumFrm() {
	return chargerursum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:41:21)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getChargesum() {
	return chargesum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:41:21)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getChargesumFrm() {
	return chargesum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @return java.lang.String
 */
public java.lang.String getCurrency1() {
	return currency1;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @return java.lang.String
 */
public java.lang.String getCurrency2() {
	return currency2;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:22:02)
 * @return int
 */
public int getCurrencycode() {
	return currencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:12:14)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseDNOPAccessBean bean = new LeaseDNOPAccessBean();
	bean.setInitKey_leaseCharge_leaseDocPosition(new Integer(getLeaseChargecode()));
	bean.setInitKey_leasePayment_leaseDocPosition(getLeasePaymentcode());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
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
 * Creation date: (25.01.2003 15:37:48)
 * @return int
 */
public int getLeaseChargecode() {
	return leaseChargecode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:12:00)
 * @return int
 */
public int getLeaseContract() {
	return leaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:40:12)
 * @return int
 */
public Integer getLeasePaymentcode() {
	return leasePaymentcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:40:12)
 * @return int
 */
public String getLeasePaymentcodeFrm() {
	return leasePaymentcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:45:45)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getPaymentDate() {
	return paymentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:45:45)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getPaymentDateFrm() {
	return paymentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:56:34)
 * @return java.lang.String
 */
public java.lang.String getPaymentDisplayonly() {
	return paymentDisplayonly;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:53:44)
 * @return java.lang.String
 */
public java.lang.String getPaymentNumber() {
	return paymentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:57:04)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getPaymentRate() {
	return paymentRate.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:57:04)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getPaymentRateFrm() {
	return paymentRate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:55:18)
 * @return java.lang.String
 */
public java.lang.String getPaymentRurremainder() {
	return paymentRurremainder;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:54:23)
 * @return java.lang.String
 */
public java.lang.String getPaymentSumrub() {
	return paymentSumrub;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:44:54)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public BigDecimal getPayrursum() {
	return payrursum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:44:54)
 * @return com.hps.july.web.util.StringAndBigDecimalProperty
 */
public String getPayrursumFrm() {
	return payrursum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:46:48)
 * @return java.lang.String
 */
public java.lang.String getSource() {
	return source;
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
 * Creation date: (25.01.2003 15:12:14)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHARGE_DNOP_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @return java.lang.String
 */
public java.lang.String getSum() {
	return sum;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:51:38)
 * @return java.lang.String
 */
public java.lang.String getSumonn() {
	return sumonn;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	ChargeDnopListForm oform = (ChargeDnopListForm) request.getSession().getAttribute(listForm);

	setLeaseChargecode(oform.getLeaseDocPosition());
	setDocumentNumber(oform.getDocumentNumber());
	setStartDate(oform.getStartDate());
	setEndDate(oform.getEndDate());
	setOrgCustomer(oform.getOrgCustomer());
	setOrgExecutor(oform.getOrgExecutor());
	setCurrency1(oform.getCurrency1() != null ? oform.getCurrency1().toString() : null);
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

	LeaseChargesAccessBean lcBean = new LeaseChargesAccessBean();
	lcBean.setInitKey_leaseDocPosition(getLeaseChargecode());
	lcBean.refreshCopyHelper();
	setSumonn(lcBean.getRemaindersum().toString());
	setLeaseContract(lcBean.getLeaseContractKey().leaseDocument);
	setCurrencycode(lcBean.getCurrencyKey().currency);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:37:43)
 * @param newActcode java.lang.String
 */
public void setActcode(java.lang.String newActcode) {
	actcode = newActcode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:47:42)
 * @param newByhandchangeraterur java.lang.Boolean
 */
public void setByhandchangeraterur(java.lang.Boolean newByhandchangeraterur) {
	byhandchangeraterur = newByhandchangeraterur;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
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
 * Creation date: (25.01.2003 17:24:44)
 * @param newChargerurrate com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setChargerurrate(BigDecimal newChargerurrate) {
	chargerurrate.setBigDecimal(newChargerurrate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:24:44)
 * @param newChargerurrate com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setChargerurrateFrm(String newChargerurrate) {
	chargerurrate.setString(newChargerurrate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:27:37)
 * @param newChargerursum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setChargerursum(BigDecimal newChargerursum) {
	chargerursum.setBigDecimal(newChargerursum);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:27:37)
 * @param newChargerursum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setChargerursumFrm(String newChargerursum) {
	chargerursum.setString(newChargerursum);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:41:21)
 * @param newChargesum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setChargesum(BigDecimal newChargesum) {
	chargesum.setBigDecimal(newChargesum);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:41:21)
 * @param newChargesum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setChargesumFrm(String newChargesum) {
	chargesum.setString(newChargesum);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @param newCurrency1 java.lang.String
 */
public void setCurrency1(java.lang.String newCurrency1) {
	currency1 = newCurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @param newCurrency2 java.lang.String
 */
public void setCurrency2(java.lang.String newCurrency2) {
	currency2 = newCurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:22:02)
 * @param newCurrencycode int
 */
public void setCurrencycode(int newCurrencycode) {
	currencycode = newCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
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
 * Creation date: (25.01.2003 15:37:48)
 * @param newLeaseChargecode int
 */
public void setLeaseChargecode(int newLeaseChargecode) {
	leaseChargecode = newLeaseChargecode;
}
/**
 * Insert the method's description here.
 * Creation date: (27.01.2003 17:12:00)
 * @param newLeaseContract int
 */
public void setLeaseContract(int newLeaseContract) {
	leaseContract = newLeaseContract;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:40:12)
 * @param newLeasePaymentcode int
 */
public void setLeasePaymentcode(Integer newLeasePaymentcode) {
	leasePaymentcode.setInteger(newLeasePaymentcode);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:40:12)
 * @param newLeasePaymentcode int
 */
public void setLeasePaymentcodeFrm(String newLeasePaymentcode) {
	leasePaymentcode.setString(newLeasePaymentcode);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:45:45)
 * @param newPaymentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setPaymentDate(Date newPaymentDate) {
	paymentDate.setSqlDate(newPaymentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:45:45)
 * @param newPaymentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setPaymentDateFrm(String newPaymentDate) {
	paymentDate.setString(newPaymentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:56:34)
 * @param newPaymentDisplayonly java.lang.String
 */
public void setPaymentDisplayonly(java.lang.String newPaymentDisplayonly) {
	paymentDisplayonly = newPaymentDisplayonly;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:53:44)
 * @param newPaymentNumber java.lang.String
 */
public void setPaymentNumber(java.lang.String newPaymentNumber) {
	paymentNumber = newPaymentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:57:04)
 * @param newPaymentRate com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setPaymentRate(BigDecimal newPaymentRate) {
	paymentRate.setBigDecimal(newPaymentRate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:57:04)
 * @param newPaymentRate com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setPaymentRateFrm(String newPaymentRate) {
	paymentRate.setString(newPaymentRate);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:55:18)
 * @param newPaymentRurremainder java.lang.String
 */
public void setPaymentRurremainder(java.lang.String newPaymentRurremainder) {
	paymentRurremainder = newPaymentRurremainder;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 17:54:23)
 * @param newPaymentSumrub java.lang.String
 */
public void setPaymentSumrub(java.lang.String newPaymentSumrub) {
	paymentSumrub = newPaymentSumrub;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:44:54)
 * @param newPayrursum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setPayrursum(BigDecimal newPayrursum) {
	payrursum.setBigDecimal(newPayrursum);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:44:54)
 * @param newPayrursum com.hps.july.web.util.StringAndBigDecimalProperty
 */
public void setPayrursumFrm(String newPayrursum) {
	payrursum.setString(newPayrursum);
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:27:49)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:46:48)
 * @param newSource java.lang.String
 */
public void setSource(java.lang.String newSource) {
	source = newSource;
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
 * Creation date: (25.01.2003 15:27:49)
 * @param newSum java.lang.String
 */
public void setSum(java.lang.String newSum) {
	sum = newSum;
}
/**
 * Insert the method's description here.
 * Creation date: (25.01.2003 15:51:38)
 * @param newSumonn java.lang.String
 */
public void setSumonn(java.lang.String newSumonn) {
	sumonn = newSumonn;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {

	if(leasePaymentcode.isEmpty()){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.chargednop.paynumber.empty"));
	}
	if(!leasePaymentcode.isEmpty() && !leasePaymentcode.isOk()){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.chargednop.paynumber.error"));
	}
	if(!leasePaymentcode.isEmpty() && leasePaymentcode.isOk() && leasePaymentcode.getInteger().intValue() < 0){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.chargednop.paynumber.error"));
	}
	if(!leasePaymentcode.isEmpty() && leasePaymentcode.isOk() && leasePaymentcode.getInteger().intValue() > 0){
		try {		
			LeasePaymentAccessBean lpBean = new LeasePaymentAccessBean();
			lpBean.setInitKey_leaseDocPosition(getLeasePaymentcode().intValue());
			lpBean.refreshCopyHelper();
		} catch (Exception e) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.chargednop.paynumber.errornum"));
		}
	}
	
/**
	chargesum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	payrursum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	chargerurrate = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);///
	chargerursum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	paymentRate = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 4);///
	paymentDate = new StringAndSqlDateProperty();

*/
	if(!chargesum.isEmpty() && !chargesum.isOk()){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.chargesum"));
	}
	if(!payrursum.isEmpty() && !payrursum.isOk()){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrursum"));
	}
	if(!chargerursum.isEmpty() && !chargerursum.isOk()){
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.chargerursum"));
	}
	
	if (paymentRate.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.chargednop.paymentrate"));
	} else if (!paymentRate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.chargednop.paymentrate"));
	}
	
	if (!chargerurrate.isEmpty() && !chargerurrate.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.chargednop.chargerurrate"));
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
