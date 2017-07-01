package com.hps.july.arenda.formbean;

import java.util.Vector;
import org.apache.struts.action.*;
import java.sql.Date;
import com.hps.july.persistence.*;
import com.hps.july.web.util.*;
/**
 * Bean-form.
 * Форма "Приоритеты зачета между договорами из контракта".
 * Creation date: (19.12.2002 5:14:23)
 * @author: Sergey Gourov
 */
public class MRCntPriorForm extends com.hps.july.web.util.EditForm {
	private StringAndSqlDateProperty documentDate;
	private java.lang.String documentNumber;
	private java.lang.String mutualPeriod;
	private Boolean commonRate;
	private java.lang.String actType;
	private java.lang.String calcRateType;
	private java.lang.String additionalCurrency;
	private java.lang.String mainCurrency;
	private LeaseMutualReglamentAccessBean reglament;
	private int reglamentcode;
	private LeaseContractAccessBean contract1;
	private StringAndIntegerProperty contractcode1;
	private LeaseContractAccessBean contract2;
	private StringAndIntegerProperty contractcode2;
	private StringAndIntegerProperty priority;
	protected java.lang.String listForm;
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:56:00)
 */
public MRCntPriorForm() {
	super();
	contractcode1 = new StringAndIntegerProperty();
	contractcode2 = new StringAndIntegerProperty();
	priority = new StringAndIntegerProperty();
	documentDate = new StringAndSqlDateProperty();
	listForm = "MRCntPriorsListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:14:23)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
	return new LeaseMRCntPriorAccessBean(new Integer(getReglamentcode()), getContractcode1(), getContractcode2(), getPriority());
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:06:31)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseContractAccessBean constructContract1() throws java.lang.Exception {
	if (contract1 == null) {
		if (!contractcode1.isEmpty() && contractcode1.isOk()) {
			contract1 = new LeaseContractAccessBean();
			contract1.setInitKey_leaseDocument(getContractcode1().intValue());
			contract1.refreshCopyHelper();
		}
	}
	return contract1;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:06:31)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseContractAccessBean constructContract2() throws java.lang.Exception {
	if (contract2 == null) {
		if (!contractcode2.isEmpty() && contractcode2.isOk()) {
			contract2 = new LeaseContractAccessBean();
			contract2.setInitKey_leaseDocument(getContractcode2().intValue());
			contract2.refreshCopyHelper();
		}
	}
	return contract2;
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
 * Creation date: (19.12.2002 6:35:35)
 * @return java.lang.String
 */
public java.lang.String getActType() {
	return actType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @return java.lang.String
 */
public java.lang.String getAdditionalCurrency() {
	return additionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:14:23)
 * @return int
 */
public int getApplication() {
	return com.hps.july.constants.Applications.ARENDA;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @return java.lang.String
 */
public java.lang.String getCalcRateType() {
	return calcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getCommonRate() {
	return commonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 12:14:39)
 * @return com.hps.july.persistence.LeaseContractAccessBean
 */
public com.hps.july.persistence.LeaseContract getContract1() throws Exception {
	LeaseContractAccessBean bean = constructContract1();
    return bean != null ? (LeaseContract) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 12:14:39)
 * @return com.hps.july.persistence.LeaseContractAccessBean
 */
public com.hps.july.persistence.LeaseContract getContract2() throws Exception {
	LeaseContractAccessBean bean = constructContract2();
    return bean != null ? (LeaseContract) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @return int
 */
public Integer getContractcode1() {
	return contractcode1.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @return int
 */
public String getContractcode1Frm() {
	return contractcode1.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @return int
 */
public Integer getContractcode2() {
	return contractcode2.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @return int
 */
public String getContractcode2Frm() {
	return contractcode2.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (21.12.2002 14:29:10)
 */
public java.util.Enumeration getContracts() {
	try {
		return new LeaseContractAccessBean().findLeaseContractsByReglamentOrderByCodeAsc(new Integer(getReglamentcode()));
	} catch (Exception e) {
		e.printStackTrace();
		return new Vector().elements();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:14:23)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	LeaseMRCntPriorAccessBean bean = new LeaseMRCntPriorAccessBean();
	bean.setInitKey_contract1_leaseDocument(getContractcode1());
	bean.setInitKey_contract2_leaseDocument(getContractcode2());
	bean.setInitKey_reglament_leaseDocument(new Integer(getReglamentcode()));
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDocumentDate() {
	return documentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @return java.lang.String
 */
public java.lang.String getMainCurrency() {
	return mainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @return java.lang.String
 */
public java.lang.String getMutualPeriod() {
	return mutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:58:04)
 * @return java.lang.Short
 */
public java.lang.Short getPriority() {
	return new Short(priority.getInteger().shortValue());
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:58:04)
 * @return java.lang.Short
 */
public String getPriorityFrm() {
	return priority.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:01:22)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public com.hps.july.persistence.LeaseMutualReglament getReglament() throws Exception {
	LeaseMutualReglamentAccessBean bean = constructReglament();
    return bean != null ? (LeaseMutualReglament) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:39:17)
 * @return int
 */
public int getReglamentcode() {
	return reglamentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 5:14:23)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.REGLAMENT_CONTRACT_PRIOR_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    MRCntPriorsListForm form = (MRCntPriorsListForm) request.getSession().getAttribute(listForm);
	setReglamentcode(form.getReglamentcode());
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
 * Creation date: (19.12.2002 6:35:35)
 * @param newActType java.lang.String
 */
public void setActType(java.lang.String newActType) {
	actType = newActType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @param newAdditionalCurrency java.lang.String
 */
public void setAdditionalCurrency(java.lang.String newAdditionalCurrency) {
	additionalCurrency = newAdditionalCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @param newCalcRateType java.lang.String
 */
public void setCalcRateType(java.lang.String newCalcRateType) {
	calcRateType = newCalcRateType;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @param newCommonRate java.lang.Boolean
 */
public void setCommonRate(java.lang.Boolean newCommonRate) {
	commonRate = newCommonRate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 12:14:39)
 * @param newLeaseDocument com.hps.july.persistence.LeaseContractAccessBean
 */
public void setContract1(com.hps.july.persistence.LeaseContractAccessBean newContract) throws Exception {
    if (newContract == null) {
        setContractcode1(new Integer(0));
    } else {
        setContractcode1(new Integer(newContract.getLeaseDocument()));
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 12:14:39)
 * @param newLeaseDocument com.hps.july.persistence.LeaseContractAccessBean
 */
public void setContract2(com.hps.july.persistence.LeaseContractAccessBean newContract) throws Exception {
    if (newContract == null) {
        setContractcode2(new Integer(0));
    } else {
        setContractcode2(new Integer(newContract.getLeaseDocument()));
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @param newLeaseDocumentcode int
 */
public void setContractcode1(Integer newContractcode) {
	contractcode1.setInteger(newContractcode);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @param newLeaseDocumentcode int
 */
public void setContractcode1Frm(String newContract) {
	contractcode1.setString(newContract);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @param newLeaseDocumentcode int
 */
public void setContractcode2(Integer newContractcode) {
	contractcode2.setInteger(newContractcode);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @param newLeaseDocumentcode int
 */
public void setContractcode2Frm(String newContract) {
	contractcode2.setString(newContract);
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @param newMainCurrency java.lang.String
 */
public void setMainCurrency(java.lang.String newMainCurrency) {
	mainCurrency = newMainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:35:35)
 * @param newMutualPeriod java.lang.String
 */
public void setMutualPeriod(java.lang.String newMutualPeriod) {
	mutualPeriod = newMutualPeriod;
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:58:04)
 * @param newPriority java.lang.Short
 */
public void setPriority(java.lang.Short newPriority) {
	priority.setInteger(new Integer(newPriority.shortValue()));
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:58:04)
 * @param newPriority java.lang.Short
 */
public void setPriorityFrm(String newPriority) {
	priority.setString(newPriority);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:01:22)
 * @param newLeaseDocument com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public void setReglament(LeaseMutualReglamentAccessBean newReglament) throws Exception {
    if (newReglament == null) {
        setReglamentcode(0);
    } else {
        setReglamentcode(newReglament.getLeaseDocument());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (19.12.2002 6:39:17)
 * @param newReglamentcode int
 */
public void setReglamentcode(int newReglamentcode) {
	reglamentcode = newReglamentcode;
}
/**
 * Insert the method's description here.
 * Creation date: (22.02.2002 17:29:04)
 * @exception com.hps.july.web.util.ValidationException The exception description.
 */
public void validateValues(ActionErrors errors) throws Exception {
/*	if (contractcode.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mutualreglmnts.contract"));
	} else if (!contractcode.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mutualreglmnts.contract"));
	} else {
		try {
			constructContract();
			if (contract.getContractType().equals("A")) {
				LeaseArendaAgreementNewAccessBean bean = new LeaseArendaAgreementNewAccessBean();
				bean.setInitKey_leaseDocument(getContractcode().intValue());
				bean.refreshCopyHelper();

				if (bean.getMainDocument() != null) {
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mutualreglmnts.contract"));
				}
			}
		} catch(Exception ex) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex))
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mutualreglmnts.contract"));
			else throw ex;
		}
	}
*/

	if (priority.isEmpty()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mrcntprior.priority"));
	} else if (!priority.isOk()) {
		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mrcntprior.priority"));
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
