package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import java.sql.*;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма "Регламенты(телефоны)".
 * Creation date: (10.07.2002 12:52:32)
 * @author: Sergey Gourov
 */
public class PhoneMutReglmntForm extends com.hps.july.web.util.EditForm {
	private com.hps.july.persistence.LeaseMutualReglamentAccessBean leaseDocument;
	private int leaseDocumentcode;
	private java.lang.String phone;

	private StringAndSqlDateProperty documentDate;
	private java.lang.String documentNumber;
	private java.lang.String mutualPeriod;
	private Boolean commonRate;
	private java.lang.String actType;
	private java.lang.String calcRateType;
	private java.lang.String additionalCurrency;
	private java.lang.String mainCurrency;
	protected java.lang.String listForm;
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 17:31:41)
 */
public PhoneMutReglmntForm() {
	documentDate = new StringAndSqlDateProperty();
	setPhone("");
	listForm = "PhonesMutReglmntListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {

/* @param argDocument java.lang.Integer
 * @param argPhone java.lang.String*/
	
	return new LeaseMutualPhoneAccessBean(new Integer(getLeaseDocumentcode()), getPhone());
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:06:31)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseMutualReglamentAccessBean constructDocument() throws java.lang.Exception {
	if (leaseDocument == null) {
		if (getLeaseDocumentcode() != 0) {
			leaseDocument = new LeaseMutualReglamentAccessBean();
			leaseDocument.setInitKey_leaseDocument(getLeaseDocumentcode());
			leaseDocument.refreshCopyHelper();
		}
	}
	return leaseDocument;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.lang.String
 */
public java.lang.String getActType() {
	return actType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 14:52:01)
 * @return java.lang.String
 */
public java.lang.String getAdditionalCurrency() {
	return additionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.lang.String
 */
public java.lang.String getCalcRateType() {
	return calcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.lang.String
 */
public Boolean getCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
    PhonesMutReglmntListForm form = (PhonesMutReglmntListForm) request.getSession().getAttribute(listForm);
	setLeaseDocumentcode(form.getLeaseDocument());
	
	LeaseMutualPhoneAccessBean bean = new LeaseMutualPhoneAccessBean();
	bean.setInitKey_leaseDocument_leaseDocument(new Integer(getLeaseDocumentcode())); //??? both ???
	bean.setInitKey_phone(getPhone());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.sql.Date
 */
public java.sql.Date getDocumentDate() {
	return documentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.sql.Date
 */
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:01:22)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public com.hps.july.persistence.LeaseMutualReglament getLeaseDocument() throws Exception {
	LeaseMutualReglamentAccessBean bean = constructDocument();
    if (bean != null) {
        return (LeaseMutualReglament) bean.getEJBRef();
    }
    else return null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @return int
 */
public int getLeaseDocumentcode() {
	return leaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 14:52:01)
 * @return java.lang.String
 */
public java.lang.String getMainCurrency() {
	return mainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.lang.String
 */
public java.lang.String getMutualPeriod() {
	return mutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:22:49)
 * @return java.lang.String
 */
public java.lang.String getPhone() {
	return phone;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.PHONE_MUTREGLMNT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    PhonesMutReglmntListForm form = (PhonesMutReglmntListForm) request.getSession().getAttribute(listForm);
	setLeaseDocumentcode(form.getLeaseDocument());
	setActType(form.getActType());
	setCalcRateType(form.getCalcRateType());
	setCommonRate(form.getCommonRate());
	setDocumentDate(form.getDocumentDate());
	setDocumentNumber(form.getDocumentNumber());
	setMutualPeriod(form.getMutualPeriod());
	setMainCurrency(form.getMainCurrency());
	setAdditionalCurrency(form.getAdditionalCurrency());
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newActType java.lang.String
 */
public void setActType(java.lang.String newActType) {
	actType = newActType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 14:52:01)
 * @param newAdditionalCurrency java.lang.String
 */
public void setAdditionalCurrency(java.lang.String newAdditionalCurrency) {
	additionalCurrency = newAdditionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newCalcRateType java.lang.String
 */
public void setCalcRateType(java.lang.String newCalcRateType) {
	calcRateType = newCalcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newCommonRate java.lang.String
 */
public void setCommonRate(Boolean newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newDocumentDate java.sql.Date
 */
public void setDocumentDate(java.sql.Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newDocumentDate java.sql.Date
 */
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:01:22)
 * @param newLeaseDocument com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public void setLeaseDocument(LeaseMutualReglamentAccessBean newLeaseDocument) throws Exception {
    if (newLeaseDocument == null) {
        setLeaseDocumentcode(0);
        setDocumentDate(null);
		setActType("");
		setCalcRateType("");
		setCommonRate(null);
		setDocumentNumber("");
		setMutualPeriod("");
    } else {
        setLeaseDocumentcode(newLeaseDocument.getLeaseDocument());
        setDocumentNumber(newLeaseDocument.getDocumentNumber());
        setDocumentDate(newLeaseDocument.getDocumentDate());
		setActType(newLeaseDocument.getActType());
		setCalcRateType(newLeaseDocument.getCalcRateType());
		setCommonRate(newLeaseDocument.getCommonRate());
		setMutualPeriod(newLeaseDocument.getMutualPeriod());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @param newLeaseDocumentcode int
 */
public void setLeaseDocumentcode(int newLeaseDocumentcode) {
	leaseDocumentcode = newLeaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 14:52:01)
 * @param newMainCurrency java.lang.String
 */
public void setMainCurrency(java.lang.String newMainCurrency) {
	mainCurrency = newMainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newMutualPeriod java.lang.String
 */
public void setMutualPeriod(java.lang.String newMutualPeriod) {
	mutualPeriod = newMutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:22:49)
 * @param newPhone java.lang.String
 */
public void setPhone(java.lang.String newPhone) {
	phone = newPhone;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (getPhone() == null || getPhone().equals("")) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mutualreglmnts.phone"));
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}

	setPhone(getPhone().trim());
}
}
