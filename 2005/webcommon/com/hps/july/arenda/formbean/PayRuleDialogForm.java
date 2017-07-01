package com.hps.july.arenda.formbean;

import java.util.Vector;
import java.util.Enumeration;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import java.sql.*;
import com.hps.july.persistence.*;
import com.hps.july.cdbc.objects.CDBC_VendorSite_Object;
import com.hps.july.commonbean.*;
import java.math.*;

import com.hps.july.valueobject.VendorSite_VO;
import com.hps.july.web.util.*;
/**
 * Bean-form
 * Форма "Правила платежа".
 * Creation date: (05.07.2002 14:02:29)
 * @author: Ildar
 */
public class PayRuleDialogForm extends com.hps.july.web.util.EditForm {
	private Integer leaseDocumentcode; //код документа
	private java.lang.Integer leaseRule; //код правила оплаты
	private StringAndIntegerProperty resourcecode; //Услуга(код)
	private java.lang.Integer currencycode; //Валюта
	private com.hps.july.jdbcpersistence.lib.StringAndBigDecimal sum; //Годовая сумма оплаты:
	private java.lang.String payPeriod; //Периодичность оплаты
	private java.lang.String payType; //Тип расчетов
	private java.lang.String ppType; //Тип платежного поручения
	//private StringAndIntegerProperty orgToPaycode;//Получатель платежа(код)
	private StringAndIntegerProperty orgAcccode; //Номер расчетного счета(код)
	private java.lang.String orgToPayName; //Получатель платежа(имя)
	private StringAndIntegerProperty payBeforeDate; //Оплатить за ? дней ... 
	private com.hps.july.persistence.CurrencyAccessBean currency;
	private com.hps.july.persistence.ResourceAccessBean resource;
	private java.lang.String orgAccname; //Номер расчетного счета(имя)
	private com.hps.july.persistence.AccountAccessBean orgAcc;
	//private com.hps.july.persistence.OrganizationAccessBean orgToPay;
	private java.lang.String bank; //Банк
	private java.lang.String coraccount; //Корсчет банка
	private java.lang.String bik; //БИК банка
	private java.lang.String payPurpose; //Назначение платежа
	private String payTerms; //Дополнительные условия платежа
	private Boolean separateNdsPay; //Оплачивать НДС отдельным платежом
	private boolean flagOperation;
	private java.lang.String validdatepay; //Срок оплаты

	// Получатель платежа(VendorSite)
	private Integer orgExecutorcode = new Integer(-1);
	private String orgExecutorname = "";
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 18:10:27)
	 */
	public PayRuleDialogForm() {
		payBeforeDate = new StringAndIntegerProperty();

		resourcecode = new StringAndIntegerProperty();
		resourcecode.setInteger(new Integer(0));

		// инициализировать все поля
		//orgToPaycode = new StringAndIntegerProperty();
		//orgToPaycode.setInteger(new Integer(0));

		setPayType("P");
		//setPayDateRule("A");
		//setPayBeforeDate((short) 1);

		sum = new com.hps.july.jdbcpersistence.lib.StringAndBigDecimal(15, 2);
		sum.setBigDecimal(new BigDecimal(0));

		orgAcccode = new StringAndIntegerProperty();
		orgAcccode.setInteger(new Integer(0));

		//rateDelta = new StringAndBigDecimalProperty();

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
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {

		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setLeaseRule(new Integer(keyGen.getNextKey("tables.leaserules")));

		return new LeasePayRuleAccessBean(getLeaseRule(), getLeaseDocumentcode(), getCurrencycode(), getSum(), getPayType());
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
	 */
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
				//получаем из VendorSite:
				VendorSite_VO vendorSite_VO = CDBC_VendorSite_Object.find(getOrgAcc().getIdVendorSite());
				if (vendorSite_VO != null) {
					setOrgExecutorcode(vendorSite_VO.getIdVendorSite());
					setOrgExecutorname(vendorSite_VO.getName());
				} else {
					setOrgExecutorcode(new Integer(-1));
					setOrgExecutorname("");
				}
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
	public java.util.Enumeration getCurrencies() {
		try {
			return (new CurrencyAccessBean()).findAllOrderByNameAsc();
		} catch (Exception e) {
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
		} else
			return null;
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
		/*
		  * уже установлены из request:
		PayRulesListForm form = (PayRulesListForm) request.getSession().getAttribute("listForm");
		
		 setOrgToPaycode(new Integer(form.getOrgExecutorcode()));
		 setOrgToPayName(form.getOrgExecutor());
		
		 setLeaseDocumentcode(new Integer(form.getLeaseDocument()));
		*/
		LeasePayRuleAccessBean bean = new LeasePayRuleAccessBean();
		bean.setInitKey_leaseRule(getLeaseRule().intValue());
		return bean;
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
	 * Creation date: (17.07.2002 12:32:12)
	 * @return com.hps.july.persistence.OrganizationAccessBean
	
	public Organization getOrgToPay() throws Exception {
		if (getPayType().equals("P")) {
		    OrganizationAccessBean bean = constructOrganization();
		    return bean != null ? (Organization) bean.getEJBRef() : null;
		} else {
			return null;
		}
	}
	 */
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 16:19:27)
	 * @return java.lang.Integer
	
	public java.lang.Integer getOrgToPaycode() {
		return orgToPaycode.getInteger();
	}
	 */
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 16:19:27)
	 * @return java.lang.Integer
	
	public String getOrgToPaycodeFrm() {
		return orgToPaycode.getString();
	}
	 */
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
	public Enumeration getResources() {
		try {
			Vector v = new Vector();

			Enumeration e = new LeaseChargeRuleAccessBean().findByLeaseDocument(getLeaseDocumentcode(), new Integer(1));
			while (e.hasMoreElements()) {
				LeaseChargeRuleAccessBean lcrBean = (LeaseChargeRuleAccessBean) e.nextElement();
				v.addElement(lcrBean.getResource());
			}

			return v.elements();
		} catch (Exception e) {
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
	 * Creation date: (05.07.2002 14:02:29)
	 * @return int
	 */
	public int getState() {
		return com.hps.july.arenda.APPStates.PAY_RULE_DIALOG_EDIT;
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
	 * Creation date: (12.05.2005 12:08:29)
	 * @return java.lang.String
	 */
	public java.lang.String getValiddatepay() {
		return validdatepay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:25:36)
	 */
	public void initRecord(javax.servlet.http.HttpServletRequest request) throws Exception {
		setPpType("A");
		setPayPeriod("M");

		/*
		 * уже установлены из request:
		 
		PayRulesListForm form = (PayRulesListForm) request.getSession().getAttribute("listForm");
		
		setOrgToPaycode(new Integer(form.getOrgExecutorcode()));
		setOrgToPayName(form.getOrgExecutor());
		 */
		/**
		    // если один рассчетный счет, то его показывать
		    int count = 0;
		    AccountAccessBean account = null;
		
		    java.util.Enumeration e =
		        (new AccountAccessBean()).findAccountByOrganization(new OrganizationKey(getOrgToPaycode().intValue()));
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
		*/
		//setOrgExecutorcode(new Integer(-1));
		//setOrgExecutorname("");
		initOrgExecutor(getLeaseDocumentcode());
		setOrgAcccode(null);
		setOrgAccname("");
		setBank("");
		setCoraccount("");
		setBik("");

		// если одна услуга в правилах начислений (одна услуга, а не одно начисление), то ее и показывать
		ResourceAccessBean resBean = null;
		int resCode = -1;
		boolean isOnlyAloneRes = false;

		java.util.Enumeration e = (new LeaseChargeRuleAccessBean()).findByLeaseDocument(getLeaseDocumentcode(), new Integer(1));
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
			//setResourcename(resBean.getName());
		}
	}

	/**
	 * 
	 * @param aleaseDocument
	 */
	private void initOrgExecutor(Integer aLeaseDocument) {
		try {
			LeaseArendaAgreementNewAccessBean loanBean = new LeaseArendaAgreementNewAccessBean();
			loanBean.setInitKey_leaseDocument(aLeaseDocument.intValue());
			OrganizationNfsAccessBean orgBean = loanBean.getOrgExecutor();

			setOrgExecutorcode(new Integer(orgBean.getOrganization()));
			setOrgExecutorname(orgBean.getName());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ошибка инициализации PayRuleDialogForm.OrgExecutorcode для aLeaseDocument=" + aLeaseDocument);
			setOrgExecutorcode(new Integer(-1));
			setOrgExecutorname("");
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (25.04.2005 13:38:32)
	 * @return boolean
	 */
	public boolean isFlagOperation() {
		return flagOperation;
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
	public String processUpdate(javax.servlet.http.HttpServletRequest request, ActionErrors errors) throws Exception {
		super.processUpdate(request, errors);
		setFlagOperation(true);
		return "success";
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
	 * Creation date: (25.04.2005 13:38:32)
	 * @param newFlagOperation boolean
	 */
	public void setFlagOperation(boolean newFlagOperation) {
		flagOperation = newFlagOperation;
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
	 * Creation date: (17.07.2002 12:32:12)
	 * @param newOrgToPay com.hps.july.persistence.OrganizationAccessBean
	
	public void setOrgToPay(com.hps.july.persistence.OrganizationAccessBean newOrgToPay) throws Exception {
	    if (newOrgToPay == null) {
	        orgToPaycode.setInteger(null);
	        orgToPayName = "";
	    } else {
	        orgToPaycode.setInteger(new Integer(newOrgToPay.getOrganization()));
	        orgToPayName = newOrgToPay.getName();
	    }
	}
	*/
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 16:19:27)
	 * @param newOrgToPay java.lang.Integer
	
	public void setOrgToPaycode(java.lang.Integer newOrgToPaycode) {
		orgToPaycode.setInteger(newOrgToPaycode);
	}
	*/
	/**
	 * Insert the method's description here.
	 * Creation date: (06.07.2002 16:19:27)
	 * @param newOrgToPay java.lang.Integer
	
	public void setOrgToPaycodeFrm(String newOrgToPaycode) {
		orgToPaycode.setString(newOrgToPaycode);
	}
	 */
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
	 * Creation date: (08.07.2002 11:54:08)
	 * @param newResource com.hps.july.persistence.ResourceAccessBean
	 */
	public void setResource(com.hps.july.persistence.ResourceAccessBean newResource) throws Exception {
		if (newResource == null) {
			resourcecode.setInteger(null);
			//resourcename = "";
		} else {
			resourcecode.setInteger(new Integer(newResource.getResource()));
			//resourcename = newResource.getName();
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
	 * Creation date: (14.05.2004 14:52:02)
	 * @param newSeparateNdsPay boolean
	 */
	public void setSeparateNdsPay(Boolean newSeparateNdsPay) {
		separateNdsPay = newSeparateNdsPay;
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
	 * Creation date: (12.05.2005 12:08:29)
	 * @param newValiddatepay java.lang.String
	 */
	public void setValiddatepay(java.lang.String newValiddatepay) {
		validdatepay = newValiddatepay;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException The exception description.
	 */
	public void validateValues(ActionErrors errors) throws Exception {

		if (getPayType().equals("P")) {
			/**		
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
			*/
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
		/**
		 * закоментировано (Борцов 19.03.2006)
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
		*/
		//Если поле тип расчетов: "взаимозачет" , то признак disable и в базу записывается null
		if (getPayType().equals("M")) {
			setSeparateNdsPay(null);
		}

		if (!errors.empty()) {
			throw new ValidationException();
		}
	}
	/**
	 * @return
	 */
	public Integer getOrgExecutorcode() {
		return orgExecutorcode;
	}

	/**
	 * @return
	 */
	public String getOrgExecutorname() {
		return orgExecutorname;
	}

	/**
	 * @param integer
	 */
	public void setOrgExecutorcode(Integer integer) {
		orgExecutorcode = integer;
	}

	/**
	 * @param string
	 */
	public void setOrgExecutorname(String string) {
		orgExecutorname = string;
	}

}
