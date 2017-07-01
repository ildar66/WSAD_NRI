/*
 * Created on 28.12.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.hps.july.dictionary.formbean;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

import com.hps.july.web.util.*;
import com.hps.july.util.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.KeyGeneratorAccessBean;

/**
 * @author IShaffigulin
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AccountDialogForm extends com.hps.july.web.util.EditForm {
	private int account;
	private java.lang.String accountvalue;
	private java.lang.Boolean active;
	private java.lang.Integer bankcode;
	private java.lang.String bankname;
	private java.lang.Integer orgcode;
	//private java.lang.String orgname;
	private com.hps.july.persistence.BankAccessBean banks;
	private com.hps.july.persistence.OrganizationAccessBean organizations;
	private java.lang.String bankbik;
	//private int account_length;

	private boolean flagOperation;

	/**
	 * Insert the method's description here.
	 * Creation date: (22.02.2002 14:28:36)
	 * @return com.hps.july.security.persistence.WorkersAccessBean
	 */
	public BankAccessBean constructBanks() throws Exception {

		if (banks == null) {
			// Construct organizations bean
			if (getBankcode() != null) {
				banks = new BankAccessBean();
				banks.setInit_primaryKey(getBankcode());
				banks.refreshCopyHelper();
			}
		}
		return banks;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:41:44)
	 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
	 * @param request javax.servlet.http.HttpServletRequest
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws java.lang.Exception {
		KeyGeneratorAccessBean keyGen = new KeyGeneratorAccessBean();
		setAccount(keyGen.getNextKey("tables.accounts"));
		AccountAccessBean bean = new AccountAccessBean(getAccount(), getBankcode(), getOrgcode(), getAccountvalue(), getActive());
		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.02.2002 14:28:36)
	 * @return com.hps.july.security.persistence.WorkersAccessBean
	 */
	public OrganizationAccessBean constructOrganizations() throws Exception {

		if (organizations == null) {
			// Construct organizations bean
			if (getOrgcode() != null) {
				organizations = new OrganizationAccessBean();
				organizations.setInitKey_organization(getOrgcode().intValue());
				organizations.refreshCopyHelper();
			}
		}
		return organizations;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:20:29)
	 * @return int
	 */
	public int getAccount() {
		return account;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:20:49)
	 * @return java.lang.String
	 */
	public java.lang.String getAccountvalue() {
		return accountvalue;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:22:05)
	 * @return java.lang.Boolean
	 */
	public java.lang.Boolean getActive() {
		return active;
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
	 * Creation date: (27.02.2002 11:10:49)
	 * @return com.hps.july.security.persistence.CompaniesAccessBean
	 */
	public com.hps.july.persistence.Bank getBank() throws Exception {
		BankAccessBean bean = constructBanks();
		if (bean != null)
			return (Bank) bean.getEJBRef();
		else
			return null;

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.06.2002 15:06:12)
	 * @return java.lang.String
	 */
	public java.lang.String getBankbik() {
		return bankbik;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:42:01)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getBankcode() {
		return bankcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:42:17)
	 * @return java.lang.String
	 */
	public java.lang.String getBankname() {
		return bankname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (13.02.2002 10:41:44)
	 */
	public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
		AccountAccessBean bean = new AccountAccessBean();
		bean.setInitKey_account(getAccount());
		return bean;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.02.2002 11:10:49)
	 * @return com.hps.july.security.persistence.CompaniesAccessBean
	 */
	public com.hps.july.persistence.Organization getOrganization() throws Exception {
		OrganizationAccessBean bean = constructOrganizations();
		if (bean != null)
			return (Organization) bean.getEJBRef();
		else
			return null;

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:42:42)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getOrgcode() {
		return orgcode;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#getState()
	 */
	public int getState() {
		return com.hps.july.dictionary.APPStates.ACCOUNT_DIALOG;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:20:29)
	 * @param newAccount int
	 */
	public void setAccount(int newAccount) {
		account = newAccount;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:20:49)
	 * @param newAccountvalue java.lang.String
	 */
	public void setAccountvalue(java.lang.String newAccountvalue) {
		accountvalue = newAccountvalue;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:22:05)
	 * @param newActive java.lang.Boolean
	 */
	public void setActive(java.lang.Boolean newActive) {
		active = newActive;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.02.2002 11:10:49)
	 * @param newCompanies com.hps.july.security.persistence.CompaniesAccessBean
	 */
	public void setBank(com.hps.july.persistence.BankAccessBean newOrg) throws Exception {
		if (newOrg == null) {
			bankcode = null;
			bankname = "";
			bankbik = "";
		} else {
			bankcode = (Integer) newOrg.getEJBRef().getPrimaryKey();
			bankbik = newOrg.getBik();
			bankname = newOrg.getName();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (14.06.2002 15:06:12)
	 * @param newBankbik java.lang.String
	 */
	public void setBankbik(java.lang.String newBankbik) {
		bankbik = newBankbik;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:42:01)
	 * @param newBankcode java.lang.Integer
	 */
	public void setBankcode(java.lang.Integer newBankcode) {
		bankcode = newBankcode;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:42:17)
	 * @param newBankname java.lang.String
	 */
	public void setBankname(java.lang.String newBankname) {
		bankname = newBankname;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (27.02.2002 11:10:49)
	 * @param newCompanies com.hps.july.security.persistence.CompaniesAccessBean
	 */
	public void setOrganization(com.hps.july.persistence.OrganizationAccessBean newOrg) throws Exception {
		if (newOrg == null) {
			orgcode = null;
			//orgname = "";
		} else {
			orgcode = new Integer(newOrg.getOrganization());
			//orgname = newOrg.getName();
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (22.05.2002 12:42:42)
	 * @param newOrgcode java.lang.Integer
	 */
	public void setOrgcode(java.lang.Integer newOrgcode) {
		orgcode = newOrgcode;
	}

	/**
	 * Insert the method's description here.
	 * Creation date: (22.02.2002 17:29:04)
	 * @exception com.hps.july.web.util.ValidationException The exception description.
	 */
	public void validateValues(ActionErrors errors) throws Exception {
		if ((getAccountvalue() == null) || (getAccountvalue().length() == 0))
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.account.value"));
		/** Логика построена на возможности ввести BIK произвольно*/
		if (getBankbik() != null && !"".equals(getBankbik().trim())) {
			try {
				//ServiceLocator serviceLocator = new ServiceLocator();
				//BankHome bankHome = (BankHome) serviceLocator.getRemoteHome(JNDINames.BANK, BankHome.class);
				//Bank bank = bankHome.findBankByBik(getBankbik());
				BankAccessBean bankAB = new BankAccessBean();
				BankAccessBean bankFinder = bankAB.findBankByBik(getBankbik());
				if (bankFinder == null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Банк не найден по BIK"));
				} else if(bankFinder.getRecordStatus().equals("D")){
					bankcode = bankFinder.getIdBank();
					bankname = bankFinder.getName();					
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.txt", "Банк удален"));
				}
				else {
					bankcode = bankFinder.getIdBank();
					bankname = bankFinder.getName();
					constructBanks();					
				}
			} catch (Exception e) {
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.account.bank"));
			}
		} else {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.account.bank"));
		}

		try {

			if (getOrgcode() != null)
				constructOrganizations();
		} catch (Exception ex) {
			if (ErrorProcessor.isRecordNotExistException(ex))
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.account.organization"));
		}

		if (!errors.empty())
			throw new ValidationException();
	}

	/**
	 * @return
	 */
	public boolean isFlagOperation() {
		return flagOperation;
	}

	/**
	 * @param b
	 */
	public void setFlagOperation(boolean b) {
		flagOperation = b;
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processDelete(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processDelete(HttpServletRequest request, ActionErrors errors) throws Exception {
		super.processDelete(request, errors);
		setFlagOperation(true);
		return "success";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processInsert(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processInsert(HttpServletRequest request, ActionErrors errors) throws Exception {
		super.processInsert(request, errors);
		setFlagOperation(true);
		return "success";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#processUpdate(javax.servlet.http.HttpServletRequest, org.apache.struts.action.ActionErrors)
	 */
	public String processUpdate(HttpServletRequest request, ActionErrors errors) throws Exception {
		super.processUpdate(request, errors);
		setFlagOperation(true);
		return "success";
	}

	/* (non-Javadoc)
	 * @see com.hps.july.web.util.EditForm#initCollections(javax.servlet.http.HttpServletRequest)
	 */
	public void initCollections(HttpServletRequest request) throws Exception {
		setFlagOperation(false);
	}
}
