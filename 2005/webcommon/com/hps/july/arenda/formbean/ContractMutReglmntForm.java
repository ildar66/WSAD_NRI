package com.hps.july.arenda.formbean;

import java.util.Vector;
import java.util.Enumeration;
import org.apache.struts.util.*;
import com.ibm.ivj.ejb.runtime.*;
import org.apache.struts.action.*;
import com.hps.july.persistence.*;
import com.hps.july.commonbean.*;
import java.sql.*;
import com.hps.july.web.util.*;
/**
 * bean-form
 * Контракты-регламенты.
 * Creation date: (10.07.2002 12:52:32)
 * @author: Sergey Gourov
 */
public class ContractMutReglmntForm extends com.hps.july.web.util.EditForm {
	private com.hps.july.persistence.LeaseMutualReglamentAccessBean reglament;
	private int reglamentcode;
	private StringAndSqlDateProperty mainDocumentDate;
	private java.lang.String mainDocumentNumber;
	private java.lang.String mutualPeriod;
	private Boolean commonRate;
	private java.lang.String actType;
	private java.lang.String calcRateType;
	
	private com.hps.july.persistence.LeaseContractAccessBean contract;
	private StringAndIntegerProperty contractcode;
	private StringAndSqlDateProperty documentDate;
	private java.lang.String documentNumber;
	private java.lang.String orgCustomer;
	private java.lang.String orgExecutor;

	private com.hps.july.persistence.ResourceAccessBean resource;
	private com.hps.july.web.util.StringAndIntegerProperty resourcecode;
	private java.lang.String resourcename;
	private java.lang.String additionalCurrency;
	private java.lang.String mainCurrency;
	private java.lang.String contractTypename;
	private org.apache.struts.util.MessageResources messageResources;
	protected java.lang.String whereForm;
	public java.lang.Boolean isAllResources;
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 17:31:41)
 */
public ContractMutReglmntForm() {
	mainDocumentDate = new StringAndSqlDateProperty();
	documentDate = new StringAndSqlDateProperty();
	documentDate.setSqlDate(null);

	contractcode = new StringAndIntegerProperty();
	contractcode.setInteger(new Integer(0));

	resourcecode = new StringAndIntegerProperty();
	resourcecode.setInteger(new Integer(0));

	setIsAllResources(new Boolean(false));

	whereForm = "ContractsMutReglmntListForm";
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 * @param request javax.servlet.http.HttpServletRequest
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean constructBean(javax.servlet.http.HttpServletRequest request) throws Exception {
/* @param argReglament java.lang.Integer
 * @param argContract java.lang.Integer
 * @param argResource java.lang.Integer*/

	if (contract.getContractType().equals("C") && getIsAllResources().booleanValue()) {
		NamedValueAccessBean namedValue = new NamedValueAccessBean();
		namedValue.setInitKey_id("ARENDA_RES_EQUIPMENT");
		namedValue.refreshCopyHelper();
		LeaseMutualContractsAccessBean lmcBean = new LeaseMutualContractsAccessBean(
			new Integer(getReglamentcode()), getContractcode(), new Integer(namedValue.getIntvalue()));
		lmcBean.commitCopyHelper();

		namedValue = new NamedValueAccessBean();
		namedValue.setInitKey_id("ARENDA_RES_CONNECT");
		namedValue.refreshCopyHelper();
		return new LeaseMutualContractsAccessBean(
			new Integer(getReglamentcode()), getContractcode(), new Integer(namedValue.getIntvalue()));
	} else if (contract.getContractType().equals("A") && getIsAllResources().booleanValue()) {
		Vector v = new Vector(1);
		v.addElement(getContractcode());
		boolean isFirst = true;
		Enumeration e = new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
		while (e.hasMoreElements()) {
			ResourceAccessBean rBean = (ResourceAccessBean) e.nextElement();
			if (isFirst) {
				setResourcecode(new Integer(rBean.getResource()));
				isFirst = false;
			} else {
				LeaseMutualContractsAccessBean lmcBean = new LeaseMutualContractsAccessBean(
					new Integer(getReglamentcode()), getContractcode(), new Integer(rBean.getResource()));
				lmcBean.commitCopyHelper();
			}
		}
	}
	return new LeaseMutualContractsAccessBean(new Integer(getReglamentcode()), getContractcode(), getResourcecode());
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:06:31)
 * @return com.hps.july.persistence.LeaseMutualReglamentAccessBean
 * @exception java.lang.Exception The exception description.
 */
private LeaseContractAccessBean constructContract() throws java.lang.Exception {
	if (contract == null) {
		if (!contractcode.isEmpty() && contractcode.isOk()) {
			contract = new LeaseContractAccessBean();
			contract.setInitKey_leaseDocument(getContractcode().intValue());
			contract.refreshCopyHelper();
		}
	}
	return contract;
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
 * Creation date: (13.02.2002 10:27:25)
 * @param bean com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean
 */
public void fillRecord(AbstractEntityAccessBean bean) {
	try {
		LeaseContractAccessBean lcBean = ((LeaseMutualContractsAccessBean) bean).getContract();
		String message = null;
		
		if (lcBean.getContractType().equals("A")) {
			message = messageResources.getMessage("label.contracttype.arenda");
		} else if (lcBean.getContractType().equals("B")) {
			message = messageResources.getMessage("label.contracttype.arendaus");
		} else if (lcBean.getContractType().equals("C")) {
			message = messageResources.getMessage("label.contracttype.user");
		} else if (lcBean.getContractType().equals("D")) {
			message = messageResources.getMessage("label.contracttype.channel");
		}
		setContractTypename(new String(ResponseUtils.filter(message).getBytes("Cp1251")));
	} catch (Exception e) {
		e.printStackTrace();
		setContractTypename("");
	}
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
 * Creation date: (04.12.2002 17:47:45)
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
 * Creation date: (11.07.2002 12:14:39)
 * @return com.hps.july.persistence.LeaseContractAccessBean
 */
public com.hps.july.persistence.LeaseContract getContract() throws Exception {
	LeaseContractAccessBean bean = constructContract();
    return bean != null ? (LeaseContract) bean.getEJBRef() : null;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @return int
 */
public Integer getContractcode() {
	return contractcode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @return int
 */
public String getContractcodeFrm() {
	return contractcode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 9:28:19)
 * @return int
 */
public String getContractTypename() {
	return contractTypename;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 */
public com.ibm.ivj.ejb.runtime.AbstractEntityAccessBean getDataBean(javax.servlet.http.HttpServletRequest request) {
	ActionMapping actionMapping = (ActionMapping) request.getAttribute("org.apache.struts.action.mapping.instance");
	messageResources = new PropertyMessageResourcesFactory().createResources(
		actionMapping.getMappings().getServlet().getInitParameter("application"));
		
    ContractsMutReglmntListForm form = (ContractsMutReglmntListForm) request.getSession().getAttribute(whereForm);
	setReglamentcode(form.getMainLeaseDocument());

	try {
		LeaseContractAccessBean beanContract = new LeaseContractAccessBean();
		beanContract.setInitKey_leaseDocument(getContractcode().intValue());
		beanContract.refreshCopyHelper();

		setDocumentNumber(beanContract.getDocumentNumber());
		setDocumentDate(beanContract.getDocumentDate());
		setOrgCustomer(beanContract.getOrgCustomer().getName());
		setOrgExecutor(beanContract.getOrgExecutor().getName());
	} catch (Exception ex) {
		ex.printStackTrace();
		setDocumentNumber("");
		documentDate.setSqlDate(null);
		setOrgCustomer("");
		setOrgExecutor("");
	}
	
	LeaseMutualContractsAccessBean bean = new LeaseMutualContractsAccessBean();
	bean.setInitKey_reglament_leaseDocument(new Integer(getReglamentcode()));
	bean.setInitKey_contract_leaseDocument(getContractcode());
	bean.setInitKey_resource_resource(getResourcecode());
	return bean;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public Date getDocumentDate() {
	return documentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @return com.hps.july.web.util.StringAndSqlDateProperty
 */
public String getDocumentDateFrm() {
	return documentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @return java.lang.String
 */
public java.lang.String getDocumentNumber() {
	return documentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 12:06:52)
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsAllResources() {
	return isAllResources;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 17:48:14)
 * @return java.lang.String
 */
public java.lang.String getMainCurrency() {
	return mainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.sql.Date
 */
public java.sql.Date getMainDocumentDate() {
	return mainDocumentDate.getSqlDate();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.sql.Date
 */
public String getMainDocumentDateFrm() {
	return mainDocumentDate.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @return java.lang.String
 */
public java.lang.String getMainDocumentNumber() {
	return mainDocumentNumber;
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
 * Creation date: (11.07.2002 13:30:58)
 * @return java.lang.String
 */
public java.lang.String getOrgCustomer() {
	return orgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @return java.lang.String
 */
public java.lang.String getOrgExecutor() {
	return orgExecutor;
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
 * Creation date: (11.07.2002 12:04:04)
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
 * Creation date: (04.12.2002 16:16:03)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public Integer getResourcecode() {
	return resourcecode.getInteger();
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 16:16:03)
 * @return com.hps.july.web.util.StringAndIntegerProperty
 */
public String getResourcecodeFrm() {
	return resourcecode.getString();
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 16:16:03)
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

		return new ResourceAccessBean().findResourcesByQBE(new Boolean(true), new ResourceSubTypeKey(bean.getIntvalue()),
			new Boolean(false), null, new Boolean(false), null, new Integer(3));
	} catch(Exception e) {
		e.printStackTrace();
		return (new java.util.Vector()).elements();	
	}	
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 12:52:32)
 * @return int
 */
public int getState() {
	return com.hps.july.arenda.APPStates.CONTRACT_MUTREGLMNT_EDIT;
}
/**
 * Insert the method's description here.
 * Creation date: (13.02.2002 10:25:36)
 */
public void initCollections(javax.servlet.http.HttpServletRequest request) throws Exception {
    ContractsMutReglmntListForm form = (ContractsMutReglmntListForm) request.getSession().getAttribute(whereForm);
	setReglamentcode(form.getMainLeaseDocument());
	setActType(form.getActType());
	setCalcRateType(form.getCalcRateType());
	setCommonRate(form.getCommonRate());
	setMainDocumentDate(form.getDocumentDate());
	setMainDocumentNumber(form.getDocumentNumber());
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
 * Creation date: (04.12.2002 17:47:45)
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
 * Creation date: (11.07.2002 12:14:39)
 * @param newLeaseDocument com.hps.july.persistence.LeaseContractAccessBean
 */
public void setContract(com.hps.july.persistence.LeaseContractAccessBean newContract) throws Exception {
    if (newContract == null) {
        setContractcode(new Integer(0));
//		setDocumentNumber("");
//		setDocumentDate(null);
    } else {
        setContractcode(new Integer(newContract.getLeaseDocument()));
//		setDocumentNumber(newLeaseDocument.getDocumentNumber());
//		setDocumentDate(newLeaseDocument.getDocumentDate());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @param newLeaseDocumentcode int
 */
public void setContractcode(Integer newContractcode) {
	contractcode.setInteger(newContractcode);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:03:33)
 * @param newLeaseDocumentcode int
 */
public void setContractcodeFrm(String newContract) {
	contractcode.setString(newContract);
}
/**
 * Insert the method's description here.
 * Creation date: (05.12.2002 9:28:19)
 * @param newContractTypename int
 */
public void setContractTypename(String newContractTypename) {
	contractTypename = newContractTypename;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(com.hps.july.web.util.StringAndSqlDateProperty newDocumentDate) {
	documentDate = newDocumentDate;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDate(Date newDocumentDate) {
	documentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @param newDocumentDate com.hps.july.web.util.StringAndSqlDateProperty
 */
public void setDocumentDateFrm(String newDocumentDate) {
	documentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @param newDocumentNumber java.lang.String
 */
public void setDocumentNumber(java.lang.String newDocumentNumber) {
	documentNumber = newDocumentNumber;
}
/**
 * Insert the method's description here.
 * Creation date: (05.01.2003 12:06:52)
 * @param newIsAllResources java.lang.Boolean
 */
public void setIsAllResources(java.lang.Boolean newIsAllResources) {
	isAllResources = newIsAllResources;
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 17:48:14)
 * @param newMainCurrency java.lang.String
 */
public void setMainCurrency(java.lang.String newMainCurrency) {
	mainCurrency = newMainCurrency;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newDocumentDate java.sql.Date
 */
public void setMainDocumentDate(java.sql.Date newDocumentDate) {
	mainDocumentDate.setSqlDate(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newDocumentDate java.sql.Date
 */
public void setMainDocumentDateFrm(String newDocumentDate) {
	mainDocumentDate.setString(newDocumentDate);
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:37:29)
 * @param newDocumentNumber java.lang.String
 */
public void setMainDocumentNumber(java.lang.String newDocumentNumber) {
	mainDocumentNumber = newDocumentNumber;
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
 * Creation date: (11.07.2002 13:30:58)
 * @param newOrgCustomer java.lang.String
 */
public void setOrgCustomer(java.lang.String newOrgCustomer) {
	orgCustomer = newOrgCustomer;
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 13:30:58)
 * @param newOrgExecutor java.lang.String
 */
public void setOrgExecutor(java.lang.String newOrgExecutor) {
	orgExecutor = newOrgExecutor;
}
/**
 * Insert the method's description here.
 * Creation date: (10.07.2002 13:01:22)
 * @param newLeaseDocument com.hps.july.persistence.LeaseMutualReglamentAccessBean
 */
public void setReglament(LeaseMutualReglamentAccessBean newReglament) throws Exception {
    if (newReglament == null) {
        setReglamentcode(0);
		setMainDocumentNumber("");
        setMainDocumentDate(null);
		setActType("");
		setCalcRateType("");
		setCommonRate(null);
		setMutualPeriod("");
    } else {
        setReglamentcode(newReglament.getLeaseDocument());
        setMainDocumentNumber(newReglament.getDocumentNumber());
        setMainDocumentDate(newReglament.getDocumentDate());
		setActType(newReglament.getActType());
		setCalcRateType(newReglament.getCalcRateType());
		setCommonRate(newReglament.getCommonRate());
		setMutualPeriod(newReglament.getMutualPeriod());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.07.2002 12:04:04)
 * @param newMainLeaseDocumentcode int
 */
public void setReglamentcode(int newReglament) {
	reglamentcode = newReglament;
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
 * Creation date: (04.12.2002 16:16:03)
 * @param newResourcecode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setResourcecode(Integer newResourcecode) {
	resourcecode.setInteger(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 16:16:03)
 * @param newResourcecode com.hps.july.web.util.StringAndIntegerProperty
 */
public void setResourcecodeFrm(String newResourcecode) {
	resourcecode.setString(newResourcecode);
}
/**
 * Insert the method's description here.
 * Creation date: (04.12.2002 16:16:03)
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
	if (contractcode.isEmpty()) {
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
				} else if (getAction().equals("Add") && getIsAllResources().booleanValue()) {
					Vector v = new Vector(1);
					v.addElement(getContractcode());
					Enumeration e = new ResourceAccessBean().findResourcesByLeaseChargeRules(v);
					if (!e.hasMoreElements()) {
						errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.mutualreglmnts.nochargerules"));
					}
				}
			}
		} catch(Exception ex) {
			if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex))
				errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mutualreglmnts.contract"));
			else throw ex;
		}
	}
	
	if (!getIsAllResources().booleanValue()) {
		if (resourcecode.isEmpty()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.empty.mutualreglmnts.resource"));
		} else if (!resourcecode.isOk()) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mutualreglmnts.resource"));
		} else {
			try {
				constructResource();
			} catch(Exception ex) {
				if (com.hps.july.util.ErrorProcessor.isRecordNotExistException(ex))
					errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mutualreglmnts.resource"));
				else throw ex;
			}
		}
	} else {
		if (contract.getContractType().equals("B") || contract.getContractType().equals("D")) {
			errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.invalid.mutualreglmnts.allres"));
		}
	}
	
	if (!errors.empty()) {
		throw new ValidationException();
	}
}
}
