package com.hps.july.arenda.formbean;

import java.util.Vector;
import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import java.sql.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import java.math.*;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма "Правила платежа".
 * Creation date: (05.07.2002 14:02:29)
 * @author: Sergey Gourov
 */
public class PayRuleForm extends com.hps.july.web.util.EditForm {
	private Integer leaseDocumentcode;
	private java.lang.String documentNumber;
	private java.lang.Integer leaseRule;
	private StringAndIntegerProperty resourcecode;
	private java.lang.Integer currencycode;
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sum;
	private java.lang.String payPeriod;
	private java.lang.String payType;
	private java.lang.String ppType;
	private StringAndIntegerProperty orgToPaycode;
	private StringAndIntegerProperty orgAcccode;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;
	private String costcurrency1;
	private String costcurrency2;
	private StringAndSqlDateProperty startDate;
	private StringAndSqlDateProperty endDate;
	private java.lang.String orgToPayName;
	private StringAndIntegerProperty payBeforeDate;
	private java.lang.String resourcename;
	private com.hps.july.persistence.CurrencyAccessBean currency;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private java.lang.String orgAccname;
	private com.hps.july.persistence.AccountAccessBean orgAcc;
	private com.hps.july.persistence.OrganizationAccessBean orgToPay;
	private java.lang.String curr1;
	private java.lang.String curr2;
	private java.lang.String bank;
	private java.lang.String coraccount;
	private java.lang.String bik;
	protected java.lang.String listForm;
	private java.lang.String rateCalcRule;
	private java.lang.Short rateCalcRuleDay;
	private StringAndBigDecimalProperty rateDelta;
	private java.lang.String payPurpose;
	private String payTerms;
	private Boolean separateNdsPay;
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 18:10:27)
 */
public PayRuleForm() {
	startDate = new StringAndSqlDateProperty();
	endDate = new StringAndSqlDateProperty();
	payBeforeDate = new StringAndIntegerProperty();
	
	resourcecode = new StringAndIntegerProperty();
	resourcecode.setInteger(new Integer(0));
	
	// инициализировать все поля
	orgToPaycode = new StringAndIntegerProperty();
	orgToPaycode.setInteger(new Integer(0));

	setPayType("P");
	//setPayDateRule("A");
	//setPayBeforeDate((short) 1);

	sum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
	sum.setBigDecimal(new BigDecimal(0));

	orgAcccode = new StringAndIntegerProperty();
	orgAcccode.setInteger(new Integer(0));

	rateDelta = new StringAndBigDecimalProperty();
	
	costcurrency1 = "";
	costcurrency2 = "";

	listForm = "PayRulesListForm";
	payTerms = "";
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:56:14)
 * @return com.hps.july.persistence.ResourceAccessBean
 * @exception java.lang.Exception The exception description.
 */
private AccountAccessBean constructAccount() throws java.lang.Exception {
	if (orgAcc == null) {
		if (!orgAcccode.isEmpty() && orgAcccode.isOk()) {
			orgAcc = new AccountAccessBean();
			orgAcc.setInitKey_account(orgAcccode.getInteger().intValue());
			orgAcc.refreshCopyHelper();
		}
	}
	return orgAcc;
}
/**
 * Insert the method's description here.
 * Creation date: (05.07.2002 14:02:29)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(
	javax.servlet.http.HttpServletRequest request) throws Exception {

	KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
	setLeaseRule(new Integer(keyGen.getNextKey("tables.leaserules")));

	return new LeasePayRuleAccessBean(
		getLeaseRule(), getLeaseDocumentcode(), getCurrencycode(), getSum(), getPayType());
}
private com.hps.july.persistence.CurrencyAccessBean constructCurrency() throws Exception {
	if (currency == null) {	
		if (getCurrencycode() != null) {
			currency = new com.hps.july.persistence.CurrencyAccessBean();
			currency.setInitKey_currency(getCurrencycode().intValue());
			currency.refreshCopyHelper();
		}
	}
	return currency;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:56:14)
 * @return com.hps.july.persistence.ResourceAccessBean
 * @exception java.lang.Exception The exception description.
 */
private OrganizationAccessBean constructOrganization() throws java.lang.Exception {
	if (orgToPay == null) {
		if (!orgToPaycode.isEmpty() && orgToPaycode.isOk()) {
			orgToPay = new OrganizationAccessBean();
			orgToPay.setInitKey_organization(orgToPaycode.getInteger().intValue());
			orgToPay.refreshCopyHelper();
		}
	}
	return orgToPay;
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
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		if (getOrgAcc() != null) {
			AccountAccessBean beanAccount = new AccountAccessBean();
			beanAccount.setInitKey_account(getOrgAcc().getAccount());
			beanAccount.refreshCopyHelper();

			setBank(beanAccount.getBank().getName());
			setBik(beanAccount.getBank().getBik());
			setCoraccount(beanAccount.getBank().getKoraccount());
		}
	} catch (Exception ex) {
		ex.printStackTrace();
		setBank("");
		setBik("");
		setCoraccount("");
	}
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
 * Creation date: (06.08.2002 15:58:44)
 * @return java.lang.String
 */
public java.lang.String getBank() {
	return bank;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:58:44)
 * @return java.lang.String
 */
public java.lang.String getBik() {
	return bik;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:58:44)
 * @return java.lang.String
 */
public java.lang.String getCoraccount() {
	return coraccount;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 13:15:34)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency1() {
	return costcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 13:15:34)
 * @return java.lang.String
 */
public java.lang.String getCostcurrency2() {
	return costcurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 13:18:34)
 * @return java.lang.String
 */
public java.lang.String getCurr1() {
	return curr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 13:18:47)
 * @return java.lang.String
 */
public java.lang.String getCurr2() {
	return curr2;
}
public java.util.Enumeration getCurrencies() {
	try {
		/**
		LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
		bean.setInitKey_leaseDocument(getLeaseDocumentcode().intValue());
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
 * Creation date: (08.07.2002 11:24:23)
 * @return com.hps.july.persistence.CurrencyAccessBean
 */
public com.hps.july.persistence.Currency getCurrency() throws Exception {
    com.hps.july.persistence.CurrencyAccessBean bean = constructCurrency();
    if (bean != null) {
        return (com.hps.july.persistence.Currency) bean.getEJBRef();
    }
    else return null;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:13:44)
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
    PayRulesListForm form = (PayRulesListForm) request.getSession().getAttribute(listForm);
    setDocumentNumber(form.getDocumentNumber());
    setOrgCustomer(form.getOrgCustomer());
    setOrgExecutor(form.getOrgExecutor());
    setOrgToPaycode(new Integer(form.getOrgExecutorcode()));
    setOrgToPayName(form.getOrgExecutor());
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
	setLeaseDocumentcode(new Integer(form.getLeaseDocument()));

	LeasePayRuleAccessBean bean = new LeasePayRuleAccessBean();
	bean.setInitKey_leaseRule(getLeaseRule().intValue());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 15:48:31)
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
 * Creation date: (05.07.2002 20:07:24)
 * @return int
 */
public Integer getLeaseDocumentcode() {
	return leaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:06:08)
 * @return java.lang.Integer
 */
public java.lang.Integer getLeaseRule() {
	return leaseRule;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 10:48:40)
 * @return com.hps.july.persistence.AccountAccessBean
 */
public Account getOrgAcc() throws Exception {
	if (getPayType().equals("P")) {
	    AccountAccessBean bean = constructAccount();
	    return bean != null ? (Account) bean.getEJBRef() : null;
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 10:43:50)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrgAcccode() {
	return orgAcccode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 10:43:50)
 * @return java.lang.Integer
 */
public String getOrgAcccodeFrm() {
	return orgAcccode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 10:47:55)
 * @return java.lang.String
 */
public java.lang.String getOrgAccname() {
	return orgAccname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:33:01)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:34:57)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 12:32:12)
 * @return com.hps.july.persistence.OrganizationAccessBean
 */
public Organization getOrgToPay() throws Exception {
	if (getPayType().equals("P")) {
	    OrganizationAccessBean bean = constructOrganization();
	    return bean != null ? (Organization) bean.getEJBRef() : null;
	} else {
		return null;
	}
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:19:27)
 * @return java.lang.Integer
 */
public java.lang.Integer getOrgToPaycode() {
	return orgToPaycode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:19:27)
 * @return java.lang.Integer
 */
public String getOrgToPaycodeFrm() {
	return orgToPaycode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:21:20)
 * @return java.lang.String
 */
public java.lang.String getOrgToPayName() {
	return orgToPayName;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 18:00:16)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Short getPayBeforeDate() {
	return getPayType().equals("P") ? new Short(payBeforeDate.getInteger().shortValue()) : null;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 18:00:16)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getPayBeforeDateFrm() {
	return payBeforeDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:15:30)
 * @return java.lang.String
 */
public java.lang.String getPayPeriod() {
	//return getPayType().equals("P") ? payPeriod : null;
	return payPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 12:35:31)
 * @return java.lang.String
 */
public java.lang.String getPayPurpose() {
	return getPayType().equals("P") ? payPurpose : null;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 19:24:10)
 * @return java.lang.String
 */
public java.lang.String getPayTerms() {
	return payTerms;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:18:17)
 * @return java.lang.String
 */
public java.lang.String getPayType() {
	return payType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:18:46)
 * @return java.lang.String
 */
public java.lang.String getPpType() {
	return getPayType().equals("P") ? ppType : null;
}
/**
 * Insert the method's description here.
 * Creation date: (30.11.2002 11:44:40)
 * @return java.lang.String
 */
public java.lang.String getRateCalcRule() {
	return rateCalcRule;
}
/**
 * Insert the method's description here.
 * Creation date: (30.11.2002 11:44:40)
 * @return java.lang.Short
 */
public java.lang.Short getRateCalcRuleDay() {
	return rateCalcRuleDay;
}
/**
 * Insert the method's description here.
 * Creation date: (30.11.2002 11:44:40)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getRateDelta() {
	return rateDelta.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (30.11.2002 11:44:40)
 * @return java.math.BigDecimal
 */
public String getRateDeltaFrm() {
	return rateDelta.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:54:08)
 * @return com.hps.july.persistence.ResourceAccessBean
 */
public Resource getResource() throws Exception {
	ResourceAccessBean bean = constructResource();
	return bean != null ? (Resource) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:13:04)
 * @return java.lang.Integer
 */
public java.lang.Integer getResourcecode() {
	return resourcecode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:13:04)
 * @return java.lang.Integer
 */
public String getResourcecodeFrm() {
	return resourcecode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:16:27)
 * @return java.lang.String
 */
public java.lang.String getResourcename() {
	return resourcename;
}
public Enumeration getResources() {
	try {
		Vector v = new Vector();
		
		Enumeration e = new LeaseChargeRuleAccessBean().findByLeaseDocument(getLeaseDocumentcode(), new Integer(1));
		while (e.hasMoreElements()) {
			LeaseChargeRuleAccessBean lcrBean = (LeaseChargeRuleAccessBean) e.nextElement();
			v.addElement(lcrBean.getResource());
		}
		
		return v.elements();
	} catch(Exception e) {
		e.printStackTrace();
		return new java.util.Vector().elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2004 14:52:02)
 * @return boolean
 */
public Boolean getSeparateNdsPay() {
	return separateNdsPay;
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
	return com.hps.july.arenda.APPStates.PAY_RULE_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:14:41)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return sum.getBigDecimal();
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:14:41)
 * @return java.math.BigDecimal
 */
public String getSumFrm() {
	return sum.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
	PayRulesListForm form = (PayRulesListForm) request.getSession().getAttribute(listForm);
	setRateCalcRule(form.getRateCalcRule());
	setRateCalcRuleDay(form.getRateCalcRuleDay());
	setRateDelta(form.getRateDelta());

}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
	setPpType("A");
	setPayPeriod("M");
	
    PayRulesListForm form = (PayRulesListForm) request.getSession().getAttribute(listForm);

    setDocumentNumber(form.getDocumentNumber());
    setOrgCustomer(form.getOrgCustomer());
    setOrgExecutor(form.getOrgExecutor());

    setOrgToPaycode(new Integer(form.getOrgExecutorcode()));
    setOrgToPayName(form.getOrgExecutor());
    
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
	setLeaseDocumentcode(new Integer(form.getLeaseDocument()));

	// если один рассчетный счет, то его показывать
	int count = 0;
	AccountAccessBean account = null;
	
	java.util.Enumeration e = (new AccountAccessBean()).findAccountByOrganization(new OrganizationKey(getOrgToPaycode().intValue()));
	while (e.hasMoreElements()) {
		if (++count > 1) {
			break;
		}
		account = (AccountAccessBean) e.nextElement();
	}
	
	if (count == 1) {
		orgAcccode.setInteger(new Integer(account.getAccount()));
		setOrgAccname(account.getAccountvalue());
		setBank(account.getBank().getName());
		setBik(account.getBank().getBik());
		setCoraccount(account.getBank().getKoraccount());
	}

	// если одна услуга в правилах начислений (одна услуга, а не одно начисление), то ее и показывать
	ResourceAccessBean resBean = null;
	int resCode = -1;
	boolean isOnlyAloneRes = false;
	
	e = (new LeaseChargeRuleAccessBean()).findByLeaseDocument(getLeaseDocumentcode(), new Integer(1));
	while (e.hasMoreElements()) {
		resBean = ((LeaseChargeRuleAccessBean) e.nextElement()).getResource();
		if (resCode == -1) {
			isOnlyAloneRes = true;
			resCode = resBean.getResource();
		} else if (resCode != resBean.getResource()) {
			isOnlyAloneRes = false;
			break;
		}
	}

	if (isOnlyAloneRes) {
		setResourcecode(new Integer(resCode));
		setResourcename(resBean.getName());
	}
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2004 14:52:02)
 * @return boolean
 */
public Boolean isSeparateNdsPay() {
	return separateNdsPay;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:58:44)
 * @param newBank java.lang.String
 */
public void setBank(java.lang.String newBank) {
	bank = newBank;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:58:44)
 * @param newBik java.lang.String
 */
public void setBik(java.lang.String newBik) {
	bik = newBik;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 15:58:44)
 * @param newCoraccount java.lang.String
 */
public void setCoraccount(java.lang.String newCoraccount) {
	coraccount = newCoraccount;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 13:15:34)
 * @param newCostcurrency1 java.lang.String
 */
public void setCostcurrency1(java.lang.String newCostcurrency1) {
	costcurrency1 = newCostcurrency1;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 13:15:34)
 * @param newCostcurrency2 java.lang.String
 */
public void setCostcurrency2(java.lang.String newCostcurrency2) {
	costcurrency2 = newCostcurrency2;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 13:18:34)
 * @param newCurr1 java.lang.String
 */
public void setCurr1(java.lang.String newCurr1) {
	curr1 = newCurr1;
}
/**
 * Insert the method's description here.
 * Creation date: (06.08.2002 13:18:47)
 * @param newCurr2 java.lang.String
 */
public void setCurr2(java.lang.String newCurr2) {
	curr2 = newCurr2;
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:24:23)
 * @param newCurrency com.hps.july.persistence.CurrencyAccessBean
 */
public void setCurrency(com.hps.july.persistence.CurrencyAccessBean newCurrency) throws Exception {
    if (newCurrency == null) {
        currencycode = null;
    } else {
        currencycode = new Integer(newCurrency.getCurrency());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:13:44)
 * @param newCurrency java.lang.Integer
 */
public void setCurrencycode(java.lang.Integer newCurrencycode) {
	currencycode = newCurrencycode;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 15:48:31)
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
 * Creation date: (05.07.2002 20:07:24)
 * @param newLeaseDocument int
 */
public void setLeaseDocumentcode(Integer newLeaseDocumentcode) {
	leaseDocumentcode = newLeaseDocumentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:06:08)
 * @param newLeaseRule java.lang.Integer
 */
public void setLeaseRule(java.lang.Integer newLeaseRule) {
	leaseRule = newLeaseRule;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 10:48:40)
 * @param newOrgAcc com.hps.july.persistence.AccountAccessBean
 */
public void setOrgAcc(com.hps.july.persistence.AccountAccessBean newOrgAcc) throws Exception {
    if (newOrgAcc == null) {
        orgAcccode.setInteger(null);
        orgAccname = "";
    } else {
        orgAcccode.setInteger(new Integer(newOrgAcc.getAccount()));
        orgAccname = newOrgAcc.getAccountvalue();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 10:43:50)
 * @param newOrgAcccode java.lang.Integer
 */
public void setOrgAcccode(java.lang.Integer newOrgAcccode) {
	orgAcccode.setInteger(newOrgAcccode);
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 10:43:50)
 * @param newOrgAcccode java.lang.Integer
 */
public void setOrgAcccodeFrm(String newOrgAcccode) {
	orgAcccode.setString(newOrgAcccode);
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 10:47:55)
 * @param newOrgAccname java.lang.String
 */
public void setOrgAccname(java.lang.String newOrgAccname) {
	orgAccname = newOrgAccname;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:33:01)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:34:57)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (17.07.2002 12:32:12)
 * @param newOrgToPay com.hps.july.persistence.OrganizationAccessBean
 */
public void setOrgToPay(com.hps.july.persistence.OrganizationAccessBean newOrgToPay) throws Exception {
    if (newOrgToPay == null) {
        orgToPaycode.setInteger(null);
        orgToPayName = "";
    } else {
        orgToPaycode.setInteger(new Integer(newOrgToPay.getOrganization()));
        orgToPayName = newOrgToPay.getName();
    }
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:19:27)
 * @param newOrgToPay java.lang.Integer
 */
public void setOrgToPaycode(java.lang.Integer newOrgToPaycode) {
	orgToPaycode.setInteger(newOrgToPaycode);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:19:27)
 * @param newOrgToPay java.lang.Integer
 */
public void setOrgToPaycodeFrm(String newOrgToPaycode) {
	orgToPaycode.setString(newOrgToPaycode);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 17:21:20)
 * @param newOrgToPayName java.lang.String
 */
public void setOrgToPayName(java.lang.String newOrgToPayName) {
	orgToPayName = newOrgToPayName;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 18:00:16)
 * @param newPayBeforeDate com.hps.july.web.util.StringAndIntegerProperty
 */
public void setPayBeforeDate(Short newPayBeforeDate) {
	if (newPayBeforeDate != null) {
		payBeforeDate.setInteger(new Integer(newPayBeforeDate.intValue()));
	} else {
		payBeforeDate.setInteger(null);
	}
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 18:00:16)
 * @param newPayBeforeDate com.hps.july.web.util.StringAndIntegerProperty
 */
public void setPayBeforeDateFrm(String newPayBeforeDate) {
	payBeforeDate.setString(newPayBeforeDate);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:15:30)
 * @param newPayPeriod java.lang.String
 */
public void setPayPeriod(java.lang.String newPayPeriod) {
	payPeriod = newPayPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (18.02.2003 12:35:31)
 * @param newPayPurpose java.lang.String
 */
public void setPayPurpose(java.lang.String newPayPurpose) {
	payPurpose = newPayPurpose;
}
/**
 * Insert the method's description here.
 * Creation date: (22.10.2003 19:24:10)
 * @param newPayTerms java.lang.String
 */
public void setPayTerms(java.lang.String newPayTerms) {
	payTerms = newPayTerms;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:18:17)
 * @param newPayType java.lang.String
 */
public void setPayType(java.lang.String newPayType) {
	payType = newPayType;
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:18:46)
 * @param newPPType java.lang.String
 */
public void setPpType(java.lang.String newPpType) {
	ppType = newPpType;
}
/**
 * Insert the method's description here.
 * Creation date: (30.11.2002 11:44:40)
 * @param newRateCalcRule java.lang.String
 */
public void setRateCalcRule(java.lang.String newRateCalcRule) {
	rateCalcRule = newRateCalcRule;
}
/**
 * Insert the method's description here.
 * Creation date: (30.11.2002 11:44:40)
 * @param newRateCalcRuleDay java.lang.Short
 */
public void setRateCalcRuleDay(java.lang.Short newRateCalcRuleDay) {
	rateCalcRuleDay = newRateCalcRuleDay;
}
/**
 * Insert the method's description here.
 * Creation date: (30.11.2002 11:44:40)
 * @param newRateDelta java.math.BigDecimal
 */
public void setRateDelta(java.math.BigDecimal newRateDelta) {
	rateDelta.setBigDecimal(newRateDelta);
}
/**
 * Insert the method's description here.
 * Creation date: (30.11.2002 11:44:40)
 * @param newRateDelta java.math.BigDecimal
 */
public void setRateDeltaFrm(String newRateDelta) {
	rateDelta.setString(newRateDelta);
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
 * Creation date: (06.07.2002 16:13:04)
 * @param newResource java.lang.Integer
 */
public void setResourcecode(java.lang.Integer newResourcecode) {
	resourcecode.setInteger(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:13:04)
 * @param newResource java.lang.Integer
 */
public void setResourcecodeFrm(String newResourcecode) {
	resourcecode.setString(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (08.07.2002 11:16:27)
 * @param newResourcename java.lang.String
 */
public void setResourcename(java.lang.String newResourcename) {
	resourcename = newResourcename;
}
/**
 * Insert the method's description here.
 * Creation date: (14.05.2004 14:52:02)
 * @param newSeparateNdsPay boolean
 */
public void setSeparateNdsPay(Boolean newSeparateNdsPay) {
	separateNdsPay = newSeparateNdsPay;
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
 * Creation date: (06.07.2002 16:14:41)
 * @param newSum java.math.BigDecimal
 */
public void setSum(java.math.BigDecimal newSum) {
	sum.setBigDecimal(newSum);
}
/**
 * Insert the method's description here.
 * Creation date: (06.07.2002 16:14:41)
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
	if (getPayType().equals("P")) {
		if (orgToPaycode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payrule.orgtopay"));
		} else if (!orgToPaycode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.orgtopay"));
		} else {
			try {
				constructOrganization();
			} catch (Exception e) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.orgtopay"));
				}
			}
		}
		if (orgAcccode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payrule.orgacc"));
		} else if (!orgAcccode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.orgacc"));
		} else {
			try {
				constructAccount();
			} catch (Exception e) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.orgacc"));
				}
			}
		}
	}

	if (sum.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payrule.sum"));
	} else if (!sum.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.sum"));
	} else if (sum.getBigDecimal().doubleValue() < 0) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.sum.sign"));
	}

	if (currencycode == null) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payrule.currency"));
	} else {
		try {
			constructCurrency();
		} catch (Exception e) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.currency"));
			}
		}
	}

	if (resourcecode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payrule.resource"));
	} else if (!resourcecode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.resource"));
	} else {
		try {
			constructResource();
		} catch (Exception e) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(e)) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.resource"));
			}
		}
	}

	if (getPayType().equals("P")) {
		if (getPpType() == null) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payrule.pptype"));
		}
		if (getPayPeriod() == null) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payrule.payperiod"));
		}
		if (payBeforeDate.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.payrule.paybeforedate"));
		} else if (!payBeforeDate.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.paybeforedate"));
		}
		if (getPayPurpose() == null || "".equals(getPayPurpose())) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.payrule.paypurpose"));
		}
	}

	// уникальность для правил оплаты - тип платежа, услуга, договор
	Enumeration e =
		new LeasePayRuleAccessBean().findByLeasedocumentResourcePaytype(
			getLeaseDocumentcode(),
			getResourcecode(),
			getPayType());
	while (e.hasMoreElements()) {
		LeasePayRuleAccessBean lprBean = (LeasePayRuleAccessBean) e.nextElement();
		if (getLeaseRule() == null || lprBean.getLeaseRule() != getLeaseRule().intValue()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.payrule.notuniq.leasedocumentresourcepaytype"));
			break;
		}
	}
	//Если поле тип расчетов: "взаимозачет" , то признак disable и в базу записывается null
	if (getPayType().equals("M")) {
		setSeparateNdsPay(null);
	}

	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
