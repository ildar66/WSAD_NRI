package com.hps.july.arenda.formbean;

import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.objects.CDBC_RateTypes_Object;
import com.hps.july.commonbean.*;
import java.sql.*;
import java.util.ArrayList;

import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма "Правила отчетов".
 * Creation date: (10.07.2002 12:52:32)
 * @author: Sergey Gourov
 */
public class MutualRuleForm extends com.hps.july.web.util.EditForm {
	private com.hps.july.persistence.LeaseMutualReglamentAccessBean reglament;
	private int reglamentcode;

	private StringAndSqlDateProperty documentDate;
	private java.lang.String documentNumber;
	private java.lang.String mutualPeriod;
	private Boolean commonRate;
	private java.lang.String actType;
	private java.lang.String calcRateType;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private com.hps.july.web.util.StringAndIntegerProperty resourcecode;
	private java.lang.String resourcename;
	private java.lang.String chargedaterule;
	private java.lang.String paydaterule;
	protected java.lang.String whereForm;
	private java.lang.String additionalCurrency;
	private java.lang.String mainCurrency;
	private boolean dopchargdatrul;
	private Integer rateType;
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 17:31:41)
 */
public MutualRuleForm() {
	documentDate = new StringAndSqlDateProperty();
	documentDate.setSqlDate(new Date(System.currentTimeMillis()));

	resourcecode = new StringAndIntegerProperty();
	resourcecode.setInteger(new Integer(0));

	setChargedaterule("A");
	setPaydaterule("A");

	whereForm = "MutualRulesListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
/* @param argReglament java.lang.Integer
 * @param argResource java.lang.Integer
 * @param argChargeDateRule java.lang.String
 * @param argPayDateRule java.lang.String
 * @param argDopChargeDateRule boolean*/
 	
	return new LeaseMutualRuleNewAccessBean(new Integer(getReglamentcode()), getResourcecode(), 
		getChargedaterule(), getPaydaterule(), getDopchargdatrul(), getRateType().intValue());
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:06:31)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseMutualReglamentAccessBean constructReglament() throws java.lang.Exception {
	if (reglament == null) {
		if (getReglamentcode() != 0) {
			reglament = new LeaseMutualReglamentAccessBean();
			reglament.setInitKey_leaseDocument(getReglamentcode());
			reglament.refreshCopyHelper();
		}
	}
	return reglament;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:56:14)
 * @return com.hps.july.persistence.ResourceAccessBean
 * @exception java.lang.Exception The exception description.
 */
private ResourceAccessBean constructResource() throws java.lang.Exception {
	if (resource == null) {
		if (!resourcecode.isEmpty() && resourcecode.isOk()) {
			resource = new ResourceAccessBean();
			resource.setInitKey_resource(resourcecode.getInteger().intValue());
			resource.refreshCopyHelper();
		}
	}
	return resource;
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
 * Creation date: (10.12.2002 14:29:27)
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
 * Creation date: (06.12.2002 10:51:03)
 * @return java.lang.String
 */
public java.lang.String getChargedaterule() {
	return chargedaterule;
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
	MutualRulesListForm form = (MutualRulesListForm) request.getSession().getAttribute(whereForm);
	setReglamentcode(form.getLeaseDocument());
	setActType(form.getActType());
	setCalcRateType(form.getCalcRateType());
	setCommonRate(form.getCommonRate());
	setDocumentDate(form.getDocumentDate());
	setDocumentNumber(form.getDocumentNumber());
	setMutualPeriod(form.getMutualPeriod());
	
	LeaseMutualRuleNewAccessBean bean = new LeaseMutualRuleNewAccessBean();
	bean.setInitKey_reglament_leaseDocument(new Integer(getReglamentcode()));
	bean.setInitKey_resource_resource(getResourcecode());
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
 * Creation date: (11.12.2002 15:49:16)
 * @return boolean
 */
public boolean getDopchargdatrul() {
	return dopchargdatrul;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 14:29:27)
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
 * Creation date: (06.12.2002 10:55:11)
 * @return java.lang.String
 */
public java.lang.String getPaydaterule() {
	return paydaterule;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:01:22)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public com.hps.july.persistence.LeaseMutualReglament getReglament() throws Exception {
	LeaseMutualReglamentAccessBean bean = constructReglament();
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
public int getReglamentcode() {
	return reglamentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @return com.hps.july.persistence.ResourceAccessBean
 */
public Resource getResource() throws Exception {
    ResourceAccessBean bean = constructResource();
    if (bean != null)
        return (Resource) bean.getEJBRef();
    else
        return null;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:21:49)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getResourcecode() {
	return resourcecode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:21:49)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getResourcecodeFrm() {
	return resourcecode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2002 19:12:29)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
public java.util.Enumeration getResources() {
	try {
		/*NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();
		
		return new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));*/
		
		return new ResourceAccessBean().findResourceByReglamentOrderByCodeAsc(new Integer(getReglamentcode()));
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.MUTUAL_RULE_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    MutualRulesListForm form = (MutualRulesListForm) request.getSession().getAttribute(whereForm);
	setReglamentcode(form.getLeaseDocument());
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
 * Creation date: (10.12.2002 14:29:27)
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
 * Creation date: (06.12.2002 10:51:03)
 * @param newChargedaterule java.lang.String
 */
public void setChargedaterule(java.lang.String newChargedaterule) {
	chargedaterule = newChargedaterule;
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
 * Creation date: (11.12.2002 15:49:16)
 * @param newDopchargdatrul boolean
 */
public void setDopchargdatrul(boolean newDopchargdatrul) {
	dopchargdatrul = newDopchargdatrul;
}
/**
 * Insert the method's description here.
 * Creation date: (10.12.2002 14:29:27)
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
 * Creation date: (06.12.2002 10:55:11)
 * @param newPaydaterule java.lang.String
 */
public void setPaydaterule(java.lang.String newPaydaterule) {
	paydaterule = newPaydaterule;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:01:22)
 * @param newReglament com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public void setReglament(LeaseMutualReglamentAccessBean newReglament) throws Exception {
    if (newReglament == null) {
        setReglamentcode(0);
        setDocumentDate(null);
		setActType("");
		setCalcRateType("");
		setCommonRate(null);
		setDocumentNumber("");
		setMutualPeriod("");
    } else {
        setReglamentcode(newReglament.getLeaseDocument());
        setDocumentNumber(newReglament.getDocumentNumber());
        setDocumentDate(newReglament.getDocumentDate());
		setActType(newReglament.getActType());
		setCalcRateType(newReglament.getCalcRateType());
		setCommonRate(newReglament.getCommonRate());
		setMutualPeriod(newReglament.getMutualPeriod());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @param newReglamentcode int
 */
public void setReglamentcode(int newReglamentcode) {
	reglamentcode = newReglamentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @param newResource com.hps.july.persistence.ResourceAccessBean
 */
public void setResource(com.hps.july.persistence.ResourceAccessBean newResource) throws Exception {
    if (newResource == null) {
        resourcecode.setInteger(null);
        resourcename = "";
    } else {
        resourcecode.setInteger(new Integer(newResource.getResource()));
        resourcename = newResource.getName();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:21:49)
 * @param newResourcecode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setResourcecode(Integer newResourcecode) {
	resourcecode.setInteger(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:21:49)
 * @param newResourcecode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setResourcecodeFrm(String newResourcecode) {
	resourcecode.setString(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (12.07.2002 19:12:29)
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
public void validateValues(ActionErrors errors) throws Exception {
	if (resourcecode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.empty.mutualerule.resource"));
	} else if (!resourcecode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.invalid.mutualerule.resource"));
	} else {
		try {
			constructResource();
		} catch(Exception e) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mutualerule.resource"));
			}
		}
	}
	if (rateType == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Выберите тип курса"));
	}	

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
	/**
	 * @return
	 */
	public Integer getRateType() {
		return rateType;
	}

	/**
	 * @param integer
	 */
	public void setRateType(Integer integer) {
		rateType = integer;
	}
	
	public ArrayList getRateTypes(){
		return CDBC_RateTypes_Object.getListRateTypes();
	}

}
