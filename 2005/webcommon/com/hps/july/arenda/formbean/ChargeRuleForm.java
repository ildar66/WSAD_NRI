package com.hps.july.arenda.formbean;

import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import com.hps.july.web.util.*;
import java.sql.*;
import java.math.*;
/**
 * form-bean
 * форма для правил начислений
 * Creation date: (05.07.2002 14:02:29)
 * @author: Sergey Gourov
 */
public class ChargeRuleForm extends com.hps.july.web.util.EditForm {
	private int leaseDocumentcode;
	private java.lang.String documentNumber;
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private String costcurrency1;
	private String costcurrency2;
	private int leaseRule;
	private com.hps.july.web.util.StringAndIntegerProperty resourcecode;
	private java.lang.Integer currencycode;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sum;
	private java.lang.String chargePeriod;
	private java.lang.String chargeDateRule;
	private java.lang.String resourcename;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private com.hps.july.persistence.CurrencyAccessBean curency;
	private java.lang.String curr1;
	private java.lang.String curr2;
	protected java.lang.String listForm;
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 13:03:45)
 */
public ChargeRuleForm() {
	Date date=new Date(System.currentTimeMillis());

	startDate = new StringAndSqlDateProperty();
	startDate.setSqlDate(date);
	
	endDate = new StringAndSqlDateProperty();
	endDate.setSqlDate(date);

	resourcecode = new StringAndIntegerProperty();
	resourcecode.setInteger(new Integer(0));

	sum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	sum.setBigDecimal(new BigDecimal(0));

	setChargePeriod("M");
	setChargeDateRule("S");

	costcurrency1 = "";
	costcurrency2 = "";

	listForm = "ChargeRulesListForm";
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
 * Creation date: (08.07.2002 17:14:54)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency1() {
	return costcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 17:14:54)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency2() {
	return costcurrency2;
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
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 13:08:41)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 13:08:57)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
public java.util.Enumeration getCurrencies() {
	try {
		/**
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(getLeaseDocumentcode());
		bean.refreshCopyHelper();

		java.util.Vector v = new java.util.Vector();
		v.addElement(bean.getCurrency1());

		if (bean.getCurrency2() != null && bean.getCurrency1().getCurrency() != bean.getCurrency2().getCurrency()) {
			v.addElement(bean.getCurrency2());
		}
		
		return v.elements();
		*/	
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
    ChargeRulesListForm form = (ChargeRulesListForm) request.getSession().getAttribute(listForm);
    setDocumentNumber(form.getDocumentNumber());
    setOrgCustomer(form.getOrgCustomer());
    setOrgExecutor(form.getOrgExecutor());
    setStartDate(form.getStartDate());
    setEndDate(form.getEndDate());
	if (form.getCurrency1() != null) {
	    setCostcurrency1(form.getCurrency1().toString());
	    setCurr1(form.getCurr1());
	}
	if (form.getCurrency2() != null) {
	    setCostcurrency2(form.getCurrency2().toString());
	    setCurr2(form.getCurr2());
	}
	setLeaseDocumentcode(form.getLeaseDocument());
	
	LeaseChargeRuleAccessBean bean = new LeaseChargeRuleAccessBean();
	bean.setInitKey_leaseRule(getLeaseRule());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 15:38:36)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getEndDate() {
	return endDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getEndDateFrm() {
	return endDate.getString();
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
 * Creation date: (08.07.2002 12:33:54)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 12:33:54)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
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
 * Creation date: (08.07.2002 13:47:54)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
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
 * Creation date: (06.07.2002 17:01:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getStartDate() {
	return startDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getStartDateFrm() {
	return startDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CHARGE_RULE_EDIT;
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
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
    ChargeRulesListForm form = (ChargeRulesListForm) request.getSession().getAttribute(listForm);
    setDocumentNumber(form.getDocumentNumber());
    setOrgCustomer(form.getOrgCustomer());
    setOrgExecutor(form.getOrgExecutor());
    setStartDate(form.getStartDate());
    setEndDate(form.getEndDate());
	if (form.getCurrency1() != null) {
	    setCostcurrency1(form.getCurrency1().toString());
	    setCurr1(form.getCurr1());
	    setSum(form.getCurrency1());
	    setCurrencycode(form.getCurrencyCode1());
	}
	if (form.getCurrency2() != null) {
	    setCostcurrency2(form.getCurrency2().toString());
	    setCurr2(form.getCurr2());
	}
	setLeaseDocumentcode(form.getLeaseDocument());

	setCurrencycode(form.getCurrencyCode1());
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
 * Creation date: (08.07.2002 17:14:54)
 * @param newCostcurrency1 java.lang.String
 */
public void setCostcurrency1(java.lang.String newCostcurrency1) {
	costcurrency1 = newCostcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 17:14:54)
 * @param newCostcurrency2 java.lang.String
 */
public void setCostcurrency2(java.lang.String newCostcurrency2) {
	costcurrency2 = newCostcurrency2;
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
 * Creation date: (06.08.2002 13:08:41)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 13:08:57)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
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
 * Creation date: (06.07.2002 15:38:36)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDate(Date newEndDate) {
	endDate.setSqlDate(newEndDate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:07:12)
 * @param newEndDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setEndDateFrm(String newEndDate) {
	endDate.setString(newEndDate);
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
 * Creation date: (08.07.2002 12:33:54)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 12:33:54)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
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
 * Creation date: (08.07.2002 13:47:54)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDate(Date newStartDate) {
	startDate.setSqlDate(newStartDate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:01:33)
 * @param newStartDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setStartDateFrm(String newStartDate) {
	startDate.setString(newStartDate);
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
 * Creation date: (08.07.2002 13:34:24)
 * @param newSum java.math.BigDecimal
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
