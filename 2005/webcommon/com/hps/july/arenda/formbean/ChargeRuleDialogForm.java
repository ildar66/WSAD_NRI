package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.web.util.*;
import java.sql.*;
import java.math.*;
import com.hps.july.util.BeanUtils;
/**
 * form-bean
 * форма для правил начислений
 * Creation date: (05.07.2002 14:02:29)
 * @author: Ildar
 */
public class ChargeRuleDialogForm extends com.hps.july.web.util.EditForm {
	private int leaseDocumentcode;
	private int leaseRule;
	private com.hps.july.web.util.StringAndIntegerProperty resourcecode;
	private java.lang.Integer currencycode;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sum;
	private java.lang.String chargePeriod;
	private java.lang.String chargeDateRule;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private com.hps.july.persistence.CurrencyAccessBean curency;
	private boolean flagOperation;
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:03:45)
 */
public ChargeRuleDialogForm() {
    Date date = new Date(System.currentTimeMillis());

    resourcecode = new StringAndIntegerProperty();
    resourcecode.setInteger(new Integer(0));

    sum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
    sum.setBigDecimal(new BigDecimal(0));

    setChargePeriod("M");
    setChargeDateRule("S");

    flagOperation = false;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setLeaseRule(keyGen.getNextKey("tables.leaserules"));

/* @return com.hps.july.persistence.LeaseChargeRule
 * @param argLeaseRule java.lang.Integer
 * @param argLeaseDocument java.lang.Integer
 * @param argResource java.lang.Integer
 * @param argCurrency java.lang.Integer
 * @param argSum java.math.BigDecimal
 * @param argChargePeriod java.lang.String
 * @param argChargeDateRule java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.*/
	
	return new LeaseChargeRuleAccessBean(new Integer(getLeaseRule()), new Integer(getLeaseDocumentcode()), getResourcecode(),
		getCurrencycode(), getSum(), getChargePeriod(), getChargeDateRule());
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 15:34:33)
 * @return com.hps.july.persistence.CurrencyAccessBean
 * @exception java.lang.Exception The exception description.
 */
private CurrencyAccessBean constructCurrency() throws java.lang.Exception {
	if (curency == null) {
		if (getCurrencycode() != null)
			curency = new CurrencyAccessBean();
			curency.setInitKey_currency(getCurrencycode().intValue());
			curency.refreshCopyHelper();
	}
	return curency;
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
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:36:22)
 * @return java.lang.String
 */
public java.lang.String getChargeDateRule() {
	return chargeDateRule;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:35:38)
 * @return java.lang.String
 */
public java.lang.String getChargePeriod() {
	return chargePeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 15:32:41)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public Currency getCurency() throws Exception {
	CurrencyAccessBean bean = constructCurrency();
	if (bean != null)
		return (Currency) bean.getEJBRef();
	else
		return null;
}
public java.util.Enumeration getCurrencies() {
	try {
		return (new CurrencyAccessBean()).findAllOrderByNameAsc();
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:32:59)
 * @return java.lang.Integer
 */
public java.lang.Integer getCurrencycode() {
	return currencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
    LeaseChargeRuleAccessBean bean = new LeaseChargeRuleAccessBean();
    bean.setInitKey_leaseRule(getLeaseRule());
    return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:16:49)
 * @return int
 */
public int getLeaseDocumentcode() {
	return leaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:09:32)
 * @return int
 */
public int getLeaseRule() {
	return leaseRule;
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
public java.util.Enumeration getResources() {
	try {
		NamedValueAccessBean bean = new NamedValueAccessBean();
		bean.setInitKey_id("ARENDA_TYPE");
		bean.refreshCopyHelper();

		return (new ResourceAccessBean()).findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHARGE_RULE_DIALOG_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:34:24)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return sum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:34:24)
 * @return java.math.BigDecimal
 */
public String getSumFrm() {
	return sum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2005 11:57:44)
 * @return boolean
 */
public boolean isFlagOperation() {
	return flagOperation;
}
/**
 * Этот метод вызывается в режиме удаления записи.
 * Creation date: (10.02.2004 14:01:52)
 */
public String processDelete(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    super.processDelete(request, errors);
	setFlagOperation(true);
    return "success";
}
/**
 * Этот метод вызывается в режиме добавления записи.
 * Creation date: (10.02.2004 14:06:40)
 */
public String processInsert(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
    super.processInsert(request, errors);
	setFlagOperation(true);
    return "success";
}
/**
 * Этот метод вызывается в режиме изменения записи.
 * Creation date: (10.02.2004 14:04:31)
 */
public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors)  throws Exception{
    super.processUpdate(request, errors);
	setFlagOperation(true);
    return "success";
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:36:22)
 * @param newChargeDateRule java.lang.String
 */
public void setChargeDateRule(java.lang.String newChargeDateRule) {
	chargeDateRule = newChargeDateRule;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:35:38)
 * @param newChargePeriod java.lang.String
 */
public void setChargePeriod(java.lang.String newChargePeriod) {
	chargePeriod = newChargePeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 15:32:41)
 * @param newCurency com.hps.july.persistence.CurrencyAccessBean
 */
public void setCurency(com.hps.july.persistence.CurrencyAccessBean newCurency) throws Exception {
	if (newCurency == null) {
		currencycode = new Integer(0);
	}
	else {
		currencycode = new Integer(newCurency.getCurrency());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:32:59)
 * @param newCurrencycode java.lang.Integer
 */
public void setCurrencycode(java.lang.Integer newCurrencycode) {
	currencycode = newCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2005 11:57:44)
 * @param newFlagOperation boolean
 */
private void setFlagOperation(boolean newFlagOperation) {
	flagOperation = newFlagOperation;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:16:49)
 * @param newLeaseDocumentcode int
 */
public void setLeaseDocumentcode(int newLeaseDocumentcode) {
	leaseDocumentcode = newLeaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:09:32)
 * @param newLeaseRule int
 */
public void setLeaseRule(int newLeaseRule) {
	leaseRule = newLeaseRule;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @param newResource com.hps.july.persistence.ResourceAccessBean
 */
public void setResource(com.hps.july.persistence.ResourceAccessBean newResource) throws Exception {
    if (newResource == null) {
        resourcecode.setInteger(null);
     } else {
        resourcecode.setInteger(new Integer(newResource.getResource()));
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
 * Creation date: (08.07.2002 13:34:24)
 * @param newSum java.math.BigDecimal
 */
public void setSum(BigDecimal newSum) {
	sum.setBigDecimal(newSum);
}
/**
 * Insert the method's description here.
 * Creation date: (21.04.2005 17:45:09)
 */
public void setSumFrm(String newSum) {
	sum.setString(newSum);
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
	if (resourcecode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.empty.chargerule.resource"));
	} else if (!resourcecode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.invalid.chargerule.resource"));
	} else {
		try {
			constructResource();
			
			java.util.Enumeration enum = new LeaseChargeRuleAccessBean().findByLeaseDocument(new Integer(getLeaseDocumentcode()), new Integer(1));
			while (enum.hasMoreElements()) {
				LeaseChargeRuleAccessBean bean = (LeaseChargeRuleAccessBean) enum.nextElement();
				if (bean.getLeaseRule() != getLeaseRule() && bean.getResource().getResource() == getResourcecode().intValue()) {
					errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.double.chargerule.resource"));
					break;
				}
			}
		} catch(Exception e) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.chargerule.resource"));
			}
		}
	}
	
	if (sum.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.empty.chargerule.sum"));
	} else if (!sum.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.invalid.chargerule.sum"));
	} else if (sum.getBigDecimal().doubleValue() < 0) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.invalid.chargerule.sum.sign"));
	}
	
	if (currencycode == null) {
		errors.add(ActionErrors.GLOBAL_ERROR,new ActionError("error.empty.chargerule.currency"));
	} else {
		try {
			constructCurrency();
		} catch(Exception e) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.chargerule.currency"));
			}
		}
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
