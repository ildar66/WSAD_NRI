package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * LeaseArendaAgreementNewAccessBean
 * @generated
 */
public class LeaseArendaAgreementNewAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence.LeaseArendaAgreementNewAccessBeanData {
	/**
	 * @generated
	 */
	private LeaseArendaAgreementNew __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_leaseDocument;
	/**
	 * getNumberofphonestemp
	 * @generated
	 */
	public java.lang.Integer getNumberofphonestemp()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("numberofphonestemp")));
	}
	/**
	 * setNumberofphonestemp
	 * @generated
	 */
	public void setNumberofphonestemp(java.lang.Integer newValue) {
		__setCache("numberofphonestemp", newValue);
	}
	/**
	 * getDogelectrodate
	 * @generated
	 */
	public java.sql.Date getDogelectrodate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("dogelectrodate")));
	}
	/**
	 * setDogelectrodate
	 * @generated
	 */
	public void setDogelectrodate(java.sql.Date newValue) {
		__setCache("dogelectrodate", newValue);
	}
	/**
	 * getIoactdate
	 * @generated
	 */
	public java.sql.Date getIoactdate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("ioactdate")));
	}
	/**
	 * setIoactdate
	 * @generated
	 */
	public void setIoactdate(java.sql.Date newValue) {
		__setCache("ioactdate", newValue);
	}
	/**
	 * getIoactnumber
	 * @generated
	 */
	public java.lang.String getIoactnumber()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("ioactnumber")));
	}
	/**
	 * setIoactnumber
	 * @generated
	 */
	public void setIoactnumber(java.lang.String newValue) {
		__setCache("ioactnumber", newValue);
	}
	/**
	 * getNumberOfPhones
	 * @generated
	 */
	public java.lang.Integer getNumberOfPhones()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("numberOfPhones")));
	}
	/**
	 * setNumberOfPhones
	 * @generated
	 */
	public void setNumberOfPhones(java.lang.Integer newValue) {
		__setCache("numberOfPhones", newValue);
	}
	/**
	 * getSumtrafic
	 * @generated
	 */
	public java.math.BigDecimal getSumtrafic()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("sumtrafic")));
	}
	/**
	 * setSumtrafic
	 * @generated
	 */
	public void setSumtrafic(java.math.BigDecimal newValue) {
		__setCache("sumtrafic", newValue);
	}
	/**
	 * getMainresource
	 * @generated
	 */
	public java.lang.Integer getMainresource()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("mainresource")));
	}
	/**
	 * setMainresource
	 * @generated
	 */
	public void setMainresource(java.lang.Integer newValue) {
		__setCache("mainresource", newValue);
	}
	/**
	 * getCalcElectroType
	 * @generated
	 */
	public java.lang.String getCalcElectroType()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("calcElectroType")));
	}
	/**
	 * setCalcElectroType
	 * @generated
	 */
	public void setCalcElectroType(java.lang.String newValue) {
		__setCache("calcElectroType", newValue);
	}
	/**
	 * getSumaccept
	 * @generated
	 */
	public java.math.BigDecimal getSumaccept()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("sumaccept")));
	}
	/**
	 * setSumaccept
	 * @generated
	 */
	public void setSumaccept(java.math.BigDecimal newValue) {
		__setCache("sumaccept", newValue);
	}
	/**
	 * getBasestartdate
	 * @generated
	 */
	public java.sql.Date getBasestartdate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("basestartdate")));
	}
	/**
	 * setBasestartdate
	 * @generated
	 */
	public void setBasestartdate(java.sql.Date newValue) {
		__setCache("basestartdate", newValue);
	}
	/**
	 * getMainDocument
	 * @generated
	 */
	public java.lang.Integer getMainDocument()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("mainDocument")));
	}
	/**
	 * setMainDocument
	 * @generated
	 */
	public void setMainDocument(java.lang.Integer newValue) {
		__setCache("mainDocument", newValue);
	}
	/**
	 * getNeedofficialdoc
	 * @generated
	 */
	public boolean getNeedofficialdoc()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("needofficialdoc")).booleanValue());
	}
	/**
	 * setNeedofficialdoc
	 * @generated
	 */
	public void setNeedofficialdoc(boolean newValue) {
		__setCache("needofficialdoc", new Boolean(newValue));
	}
	/**
	 * getIsDogElectro
	 * @generated
	 */
	public java.lang.Boolean getIsDogElectro()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("isDogElectro")));
	}
	/**
	 * setIsDogElectro
	 * @generated
	 */
	public void setIsDogElectro(java.lang.Boolean newValue) {
		__setCache("isDogElectro", newValue);
	}
	/**
	 * getDogelectonum
	 * @generated
	 */
	public java.lang.String getDogelectonum()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("dogelectonum")));
	}
	/**
	 * setDogelectonum
	 * @generated
	 */
	public void setDogelectonum(java.lang.String newValue) {
		__setCache("dogelectonum", newValue);
	}
	/**
	 * getCustomerold
	 * @generated
	 */
	public java.lang.Integer getCustomerold()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("customerold")));
	}
	/**
	 * setCustomerold
	 * @generated
	 */
	public void setCustomerold(java.lang.Integer newValue) {
		__setCache("customerold", newValue);
	}
	/**
	 * getMainpositionKey
	 * @generated
	 */
	public com.hps.july.persistence.StoragePlaceKey getMainpositionKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.StoragePlaceKey) __getCache("mainpositionKey")));
	}
	/**
	 * getIsActive
	 * @generated
	 */
	public java.lang.Boolean getIsActive()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("isActive")));
	}
	/**
	 * setIsActive
	 * @generated
	 */
	public void setIsActive(java.lang.Boolean newValue) {
		__setCache("isActive", newValue);
	}
	/**
	 * getHaveioact
	 * @generated
	 */
	public boolean getHaveioact()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("haveioact")).booleanValue());
	}
	/**
	 * setHaveioact
	 * @generated
	 */
	public void setHaveioact(boolean newValue) {
		__setCache("haveioact", new Boolean(newValue));
	}
	/**
	 * getActivecontract
	 * @generated
	 */
	public java.lang.Integer getActivecontract()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("activecontract")));
	}
	/**
	 * setActivecontract
	 * @generated
	 */
	public void setActivecontract(java.lang.Integer newValue) {
		__setCache("activecontract", newValue);
	}
	/**
	 * getOfficialdoc
	 * @generated
	 */
	public boolean getOfficialdoc()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("officialdoc")).booleanValue());
	}
	/**
	 * setOfficialdoc
	 * @generated
	 */
	public void setOfficialdoc(boolean newValue) {
		__setCache("officialdoc", new Boolean(newValue));
	}
	/**
	 * getBaseenddate
	 * @generated
	 */
	public java.sql.Date getBaseenddate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("baseenddate")));
	}
	/**
	 * setBaseenddate
	 * @generated
	 */
	public void setBaseenddate(java.sql.Date newValue) {
		__setCache("baseenddate", newValue);
	}
	/**
	 * getSumpay
	 * @generated
	 */
	public java.math.BigDecimal getSumpay()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("sumpay")));
	}
	/**
	 * setSumpay
	 * @generated
	 */
	public void setSumpay(java.math.BigDecimal newValue) {
		__setCache("sumpay", newValue);
	}
	/**
	 * getCurrency1Key
	 * @generated
	 */
	public com.hps.july.persistence.CurrencyKey getCurrency1Key()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.CurrencyKey) __getCache("currency1Key")));
	}
	/**
	 * getBuchdocnumber
	 * @generated
	 */
	public java.lang.String getBuchdocnumber()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("buchdocnumber")));
	}
	/**
	 * setBuchdocnumber
	 * @generated
	 */
	public void setBuchdocnumber(java.lang.String newValue) {
		__setCache("buchdocnumber", newValue);
	}
	/**
	 * getStartDate
	 * @generated
	 */
	public java.sql.Date getStartDate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("startDate")));
	}
	/**
	 * setStartDate
	 * @generated
	 */
	public void setStartDate(java.sql.Date newValue) {
		__setCache("startDate", newValue);
	}
	/**
	 * getManagerKey
	 * @generated
	 */
	public com.hps.july.persistence.WorkerKey getManagerKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com.hps.july.persistence.WorkerKey) __getCache("managerKey")));
	}
	/**
	 * getReportPeriod
	 * @generated
	 */
	public java.lang.String getReportPeriod()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("reportPeriod")));
	}
	/**
	 * setReportPeriod
	 * @generated
	 */
	public void setReportPeriod(java.lang.String newValue) {
		__setCache("reportPeriod", newValue);
	}
	/**
	 * getRatedelta
	 * @generated
	 */
	public java.math.BigDecimal getRatedelta()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("ratedelta")));
	}
	/**
	 * setRatedelta
	 * @generated
	 */
	public void setRatedelta(java.math.BigDecimal newValue) {
		__setCache("ratedelta", newValue);
	}
	/**
	 * getContractState
	 * @generated
	 */
	public java.lang.String getContractState()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("contractState")));
	}
	/**
	 * setContractState
	 * @generated
	 */
	public void setContractState(java.lang.String newValue) {
		__setCache("contractState", newValue);
	}
	/**
	 * getHavedocsigned
	 * @generated
	 */
	public java.lang.Boolean getHavedocsigned()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("havedocsigned")));
	}
	/**
	 * setHavedocsigned
	 * @generated
	 */
	public void setHavedocsigned(java.lang.Boolean newValue) {
		__setCache("havedocsigned", newValue);
	}
	/**
	 * getDateclose
	 * @generated
	 */
	public java.sql.Date getDateclose()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("dateclose")));
	}
	/**
	 * setDateclose
	 * @generated
	 */
	public void setDateclose(java.sql.Date newValue) {
		__setCache("dateclose", newValue);
	}
	/**
	 * getRatecalcruleday
	 * @generated
	 */
	public java.lang.Short getRatecalcruleday()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("ratecalcruleday")));
	}
	/**
	 * setRatecalcruleday
	 * @generated
	 */
	public void setRatecalcruleday(java.lang.Short newValue) {
		__setCache("ratecalcruleday", newValue);
	}
	/**
	 * getRateLimitMax
	 * @generated
	 */
	public java.math.BigDecimal getRateLimitMax()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("rateLimitMax")));
	}
	/**
	 * setRateLimitMax
	 * @generated
	 */
	public void setRateLimitMax(java.math.BigDecimal newValue) {
		__setCache("rateLimitMax", newValue);
	}
	/**
	 * getEndDate
	 * @generated
	 */
	public java.sql.Date getEndDate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("endDate")));
	}
	/**
	 * setEndDate
	 * @generated
	 */
	public void setEndDate(java.sql.Date newValue) {
		__setCache("endDate", newValue);
	}
	/**
	 * getCurrency2Key
	 * @generated
	 */
	public com.hps.july.persistence.CurrencyKey getCurrency2Key()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.CurrencyKey) __getCache("currency2Key")));
	}
	/**
	 * getContractType
	 * @generated
	 */
	public java.lang.String getContractType()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("contractType")));
	}
	/**
	 * setContractType
	 * @generated
	 */
	public void setContractType(java.lang.String newValue) {
		__setCache("contractType", newValue);
	}
	/**
	 * getRatecalcrule
	 * @generated
	 */
	public java.lang.String getRatecalcrule()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("ratecalcrule")));
	}
	/**
	 * setRatecalcrule
	 * @generated
	 */
	public void setRatecalcrule(java.lang.String newValue) {
		__setCache("ratecalcrule", newValue);
	}
	/**
	 * getExecname
	 * @generated
	 */
	public java.lang.String getExecname()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("execname")));
	}
	/**
	 * setExecname
	 * @generated
	 */
	public void setExecname(java.lang.String newValue) {
		__setCache("execname", newValue);
	}
	/**
	 * getExtendmonthes
	 * @generated
	 */
	public java.lang.Short getExtendmonthes()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("extendmonthes")));
	}
	/**
	 * setExtendmonthes
	 * @generated
	 */
	public void setExtendmonthes(java.lang.Short newValue) {
		__setCache("extendmonthes", newValue);
	}
	/**
	 * getOrgowner
	 * @generated
	 */
	public java.lang.Integer getOrgowner()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("orgowner")));
	}
	/**
	 * setOrgowner
	 * @generated
	 */
	public void setOrgowner(java.lang.Integer newValue) {
		__setCache("orgowner", newValue);
	}
	/**
	 * getExtendType
	 * @generated
	 */
	public java.lang.String getExtendType()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("extendType")));
	}
	/**
	 * setExtendType
	 * @generated
	 */
	public void setExtendType(java.lang.String newValue) {
		__setCache("extendType", newValue);
	}
	/**
	 * getNalogAgent
	 * @generated
	 */
	public boolean getNalogAgent()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("nalogAgent")).booleanValue());
	}
	/**
	 * setNalogAgent
	 * @generated
	 */
	public void setNalogAgent(boolean newValue) {
		__setCache("nalogAgent", new Boolean(newValue));
	}
	/**
	 * getOrgCustomerKey
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationNfsKey getOrgCustomerKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.OrganizationNfsKey) __getCache("orgCustomerKey")));
	}
	/**
	 * getChargeNds
	 * @generated
	 */
	public boolean getChargeNds()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("chargeNds")).booleanValue());
	}
	/**
	 * setChargeNds
	 * @generated
	 */
	public void setChargeNds(boolean newValue) {
		__setCache("chargeNds", new Boolean(newValue));
	}
	/**
	 * getExtendPeriod
	 * @generated
	 */
	public java.lang.String getExtendPeriod()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("extendPeriod")));
	}
	/**
	 * setExtendPeriod
	 * @generated
	 */
	public void setExtendPeriod(java.lang.String newValue) {
		__setCache("extendPeriod", newValue);
	}
	/**
	 * getSumm2
	 * @generated
	 */
	public java.math.BigDecimal getSumm2()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("summ2")));
	}
	/**
	 * setSumm2
	 * @generated
	 */
	public void setSumm2(java.math.BigDecimal newValue) {
		__setCache("summ2", newValue);
	}
	/**
	 * getSumm1
	 * @generated
	 */
	public java.math.BigDecimal getSumm1()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("summ1")));
	}
	/**
	 * setSumm1
	 * @generated
	 */
	public void setSumm1(java.math.BigDecimal newValue) {
		__setCache("summ1", newValue);
	}
	/**
	 * getHavedocsignedcustomer
	 * @generated
	 */
	public java.lang.Boolean getHavedocsignedcustomer()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Boolean) __getCache("havedocsignedcustomer")));
	}
	/**
	 * setHavedocsignedcustomer
	 * @generated
	 */
	public void setHavedocsignedcustomer(java.lang.Boolean newValue) {
		__setCache("havedocsignedcustomer", newValue);
	}
	/**
	 * getIsRateLimit
	 * @generated
	 */
	public boolean getIsRateLimit()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("isRateLimit")).booleanValue());
	}
	/**
	 * setIsRateLimit
	 * @generated
	 */
	public void setIsRateLimit(boolean newValue) {
		__setCache("isRateLimit", new Boolean(newValue));
	}
	/**
	 * getOrgExecutorKey
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationNfsKey getOrgExecutorKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com
				.hps
				.july
				.persistence
				.OrganizationNfsKey) __getCache("orgExecutorKey")));
	}
	/**
	 * getDocFileName
	 * @generated
	 */
	public java.lang.String getDocFileName()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("docFileName")));
	}
	/**
	 * setDocFileName
	 * @generated
	 */
	public void setDocFileName(java.lang.String newValue) {
		__setCache("docFileName", newValue);
	}
	/**
	 * getRateLimitMin
	 * @generated
	 */
	public java.math.BigDecimal getRateLimitMin()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("rateLimitMin")));
	}
	/**
	 * setRateLimitMin
	 * @generated
	 */
	public void setRateLimitMin(java.math.BigDecimal newValue) {
		__setCache("rateLimitMin", newValue);
	}
	/**
	 * getExtendyears
	 * @generated
	 */
	public java.lang.Short getExtendyears()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("extendyears")));
	}
	/**
	 * setExtendyears
	 * @generated
	 */
	public void setExtendyears(java.lang.Short newValue) {
		__setCache("extendyears", newValue);
	}
	/**
	 * getCustname
	 * @generated
	 */
	public java.lang.String getCustname()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("custname")));
	}
	/**
	 * setCustname
	 * @generated
	 */
	public void setCustname(java.lang.String newValue) {
		__setCache("custname", newValue);
	}
	/**
	 * getEconomistKey
	 * @generated
	 */
	public com.hps.july.persistence.WorkerKey getEconomistKey()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (
			((com.hps.july.persistence.WorkerKey) __getCache("economistKey")));
	}
	/**
	 * getRateNDS
	 * @generated
	 */
	public java.math.BigDecimal getRateNDS()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("rateNDS")));
	}
	/**
	 * setRateNDS
	 * @generated
	 */
	public void setRateNDS(java.math.BigDecimal newValue) {
		__setCache("rateNDS", newValue);
	}
	/**
	 * getExtenddays
	 * @generated
	 */
	public java.lang.Short getExtenddays()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Short) __getCache("extenddays")));
	}
	/**
	 * setExtenddays
	 * @generated
	 */
	public void setExtenddays(java.lang.Short newValue) {
		__setCache("extenddays", newValue);
	}
	/**
	 * getChangeenddate
	 * @generated
	 */
	public java.lang.String getChangeenddate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("changeenddate")));
	}
	/**
	 * setChangeenddate
	 * @generated
	 */
	public void setChangeenddate(java.lang.String newValue) {
		__setCache("changeenddate", newValue);
	}
	/**
	 * getOperator
	 * @generated
	 */
	public java.lang.Integer getOperator()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("operator")));
	}
	/**
	 * setOperator
	 * @generated
	 */
	public void setOperator(java.lang.Integer newValue) {
		__setCache("operator", newValue);
	}
	/**
	 * getDocumentDate
	 * @generated
	 */
	public java.sql.Date getDocumentDate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("documentDate")));
	}
	/**
	 * setDocumentDate
	 * @generated
	 */
	public void setDocumentDate(java.sql.Date newValue) {
		__setCache("documentDate", newValue);
	}
	/**
	 * getLeaseDocument
	 * @generated
	 */
	public int getLeaseDocument()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("leaseDocument")).intValue());
	}
	/**
	 * setLeaseDocument
	 * @generated
	 */
	public void setLeaseDocument(int newValue) {
		__setCache("leaseDocument", new Integer(newValue));
	}
	/**
	 * getCreated
	 * @generated
	 */
	public java.sql.Timestamp getCreated()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Timestamp) __getCache("created")));
	}
	/**
	 * setCreated
	 * @generated
	 */
	public void setCreated(java.sql.Timestamp newValue) {
		__setCache("created", newValue);
	}
	/**
	 * getDocumentNumber
	 * @generated
	 */
	public java.lang.String getDocumentNumber()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("documentNumber")));
	}
	/**
	 * setDocumentNumber
	 * @generated
	 */
	public void setDocumentNumber(java.lang.String newValue) {
		__setCache("documentNumber", newValue);
	}
	/**
	 * getRegionid
	 * @generated
	 */
	public int getRegionid()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("regionid")).intValue());
	}
	/**
	 * setRegionid
	 * @generated
	 */
	public void setRegionid(int newValue) {
		__setCache("regionid", new Integer(newValue));
	}
	/**
	 * getModified
	 * @generated
	 */
	public java.sql.Timestamp getModified()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Timestamp) __getCache("modified")));
	}
	/**
	 * setModified
	 * @generated
	 */
	public void setModified(java.sql.Timestamp newValue) {
		__setCache("modified", newValue);
	}
	/**
	 * getCreatedby
	 * @generated
	 */
	public java.lang.Integer getCreatedby()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("createdby")));
	}
	/**
	 * setCreatedby
	 * @generated
	 */
	public void setCreatedby(java.lang.Integer newValue) {
		__setCache("createdby", newValue);
	}
	/**
	 * getModifiedby
	 * @generated
	 */
	public java.lang.Integer getModifiedby()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("modifiedby")));
	}
	/**
	 * setModifiedby
	 * @generated
	 */
	public void setModifiedby(java.lang.Integer newValue) {
		__setCache("modifiedby", newValue);
	}
	/**
	 * setInitKey_leaseDocument
	 * @generated
	 */
	public void setInitKey_leaseDocument(int newValue) {
		this.initKey_leaseDocument = (newValue);
	}
	/**
	 * LeaseArendaAgreementNewAccessBean
	 * @generated
	 */
	public LeaseArendaAgreementNewAccessBean() {
		super();
	}
	/**
	 * LeaseArendaAgreementNewAccessBean
	 * @generated
	 */
	public LeaseArendaAgreementNewAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/persistence/LeaseArendaAgreementNew";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.LeaseArendaAgreementNewHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence
				.LeaseArendaAgreementNewHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence.LeaseArendaAgreementNewHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.LeaseArendaAgreementNew ejbRef()
		throws java.rmi.RemoteException {
		if (ejbRef == null)
			return null;
		if (__ejbRef == null)
			__ejbRef =
				(
					com
						.hps
						.july
						.persistence
						.LeaseArendaAgreementNew) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence.LeaseArendaAgreementNew.class);

		return __ejbRef;
	}
	/**
	 * instantiateEJB
	 * @generated
	 */
	protected void instantiateEJB()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		if (ejbRef() != null)
			return;

		com.hps.july.persistence.LeaseDocumentKey key =
			keyFromFields(initKey_leaseDocument);
		ejbRef = ejbHome().findByPrimaryKey(key);
	}
	/**
	 * instantiateEJBByPrimaryKey
	 * @generated
	 */
	protected boolean instantiateEJBByPrimaryKey()
		throws
			javax.ejb.CreateException,
			java.rmi.RemoteException,
			javax.naming.NamingException {
		boolean result = false;

		if (ejbRef() != null)
			return true;

		try {
			com.hps.july.persistence.LeaseDocumentKey pKey =
				(com.hps.july.persistence.LeaseDocumentKey) this.__getKey();
			if (pKey != null) {
				ejbRef = ejbHome().findByPrimaryKey(pKey);
				result = true;
			}
		} catch (javax.ejb.FinderException e) {
		}
		return result;
	}
	/**
	 * keyFromFields
	 * @generated
	 */
	private com.hps.july.persistence.LeaseDocumentKey keyFromFields(int f0) {
		com.hps.july.persistence.LeaseDocumentKey keyClass =
			new com.hps.july.persistence.LeaseDocumentKey();
		keyClass.leaseDocument = f0;
		return keyClass;
	}
	/**
	 * refreshCopyHelper
	 * @generated
	 */
	public void refreshCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		refreshCopyHelper(ejbRef());
	}
	/**
	 * commitCopyHelper
	 * @generated
	 */
	public void commitCopyHelper()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		commitCopyHelper(ejbRef());
	}
	/**
	 * findByQBE4
	 * @generated
	 */
	public java.util.Enumeration findByQBE4(
		java.lang.Boolean isEconomist,
		java.lang.Integer economist)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseArendaAgreementNewHome localHome =
			ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE4(isEconomist, economist);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByContractAndResource
	 * @generated
	 */
	public java.util.Enumeration findByContractAndResource(
		java.lang.Integer contract,
		java.lang.Integer resource,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseArendaAgreementNewHome localHome =
			ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByContractAndResource(contract, resource, order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findLeaseArendaAgreementNewsByMainposition
	 * @generated
	 */
	public java.util.Enumeration findLeaseArendaAgreementNewsByMainposition(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseArendaAgreementNewHome localHome =
			ejbHome();
		java.util.Enumeration ejbs =
			localHome.findLeaseArendaAgreementNewsByMainposition(inKey);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isOrgCustomer,
		java.lang.Integer orgCustomer,
		java.lang.Boolean isOrgExecutor,
		java.lang.Integer orgExecutor,
		java.lang.Boolean isMainEconomist,
		java.lang.Integer mainEconomist,
		java.lang.Boolean isPosition,
		java.lang.Integer position,
		java.lang.Boolean isDocNumber,
		java.lang.String docNumber,
		java.lang.Boolean isState,
		java.lang.String state,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseArendaAgreementNewHome localHome =
			ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE(
				isOrgCustomer,
				orgCustomer,
				isOrgExecutor,
				orgExecutor,
				isMainEconomist,
				mainEconomist,
				isPosition,
				position,
				isDocNumber,
				docNumber,
				isState,
				state,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByQBE3
	 * @generated
	 */
	public java.util.Enumeration findByQBE3(
		java.lang.Boolean isEndDate,
		java.sql.Date startEndDate,
		java.sql.Date finishEndDate,
		java.lang.Boolean isIsActive,
		java.lang.Boolean isActive,
		java.lang.Boolean isContractState,
		java.lang.String ContractState,
		java.lang.Boolean isExtendType,
		java.lang.String ExtendType,
		java.lang.Boolean isEconomist,
		java.lang.Integer economist)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseArendaAgreementNewHome localHome =
			ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE3(
				isEndDate,
				startEndDate,
				finishEndDate,
				isIsActive,
				isActive,
				isContractState,
				ContractState,
				isExtendType,
				ExtendType,
				isEconomist,
				economist);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByQBE5
	 * @generated
	 */
	public java.util.Enumeration findByQBE5(
		java.lang.Boolean isOrgCustomer,
		java.lang.Integer orgCustomer,
		java.lang.Boolean isOrgExecutor,
		java.lang.Integer orgExecutor,
		java.lang.Boolean isMainEconomist,
		java.lang.Integer mainEconomist,
		java.lang.Boolean isPosition,
		java.lang.Integer position,
		java.lang.Boolean isDocNumber,
		java.lang.String docNumber,
		java.lang.Boolean isState,
		java.lang.String state,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseArendaAgreementNewHome localHome =
			ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE5(
				isOrgCustomer,
				orgCustomer,
				isOrgExecutor,
				orgExecutor,
				isMainEconomist,
				mainEconomist,
				isPosition,
				position,
				isDocNumber,
				docNumber,
				isState,
				state,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * LeaseArendaAgreementNewAccessBean
	 * @generated
	 */
	public LeaseArendaAgreementNewAccessBean(
		int argLeaseDocument,
		java.sql.Date argDocDate,
		java.lang.String argDocNumber,
		java.lang.String argContractType,
		java.lang.String argContractState,
		java.lang.Integer argOrgCustomer,
		java.lang.Integer argOrgExecutor,
		java.sql.Date argStartDate,
		java.sql.Date argEndDate,
		java.lang.String argExtendType,
		java.lang.String argReportPeriod,
		java.lang.Boolean argIsActive,
		java.lang.String argHowGivePhones,
		java.lang.String argCalcElectroType,
		java.lang.Boolean argIsDogElectro,
		java.lang.String agrCustname,
		java.lang.String argExecname,
		java.lang.Integer argMainDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef =
			ejbHome().create(
				argLeaseDocument,
				argDocDate,
				argDocNumber,
				argContractType,
				argContractState,
				argOrgCustomer,
				argOrgExecutor,
				argStartDate,
				argEndDate,
				argExtendType,
				argReportPeriod,
				argIsActive,
				argHowGivePhones,
				argCalcElectroType,
				argIsDogElectro,
				agrCustname,
				argExecname,
				argMainDocument);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(
		java.lang.Integer mainLeaseDocument,
		java.lang.Boolean isIsActive,
		java.lang.Boolean isActive,
		java.lang.Boolean isContractState,
		java.lang.String contractState,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseArendaAgreementNewHome localHome =
			ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE2(
				mainLeaseDocument,
				isIsActive,
				isActive,
				isContractState,
				contractState,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * setEconomist
	 * @generated
	 */
	public void setEconomist(com.hps.july.persistence.Worker anEconomist)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setEconomist(anEconomist);
	}
	/**
	 * getLeaseTaskStarts
	 * @generated
	 */
	public java.util.Enumeration getLeaseTaskStarts()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseTaskStarts();
	}
	/**
	 * secondaryRemoveLeaseMRCntPriors1
	 * @generated
	 */
	public void secondaryRemoveLeaseMRCntPriors1(
		com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors1)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseMRCntPriors1(aLeaseMRCntPriors1);
	}
	/**
	 * setManager
	 * @generated
	 */
	public void setManager(com.hps.july.persistence.Worker aManager)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setManager(aManager);
	}
	/**
	 * secondaryAddLeaseMRCntPriors2
	 * @generated
	 */
	public void secondaryAddLeaseMRCntPriors2(
		com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors2)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseMRCntPriors2(aLeaseMRCntPriors2);
	}
	/**
	 * secondaryRemoveLeaseSchetFakts
	 * @generated
	 */
	public void secondaryRemoveLeaseSchetFakts(
		com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseSchetFakts(aLeaseSchetFakts);
	}
	/**
	 * secondaryAddLeaseDocPosition
	 * @generated
	 */
	public void secondaryAddLeaseDocPosition(
		com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseDocPosition(aLeaseDocPosition);
	}
	/**
	 * secondarySetOrgExecutor
	 * @generated
	 */
	public void secondarySetOrgExecutor(
		com.hps.july.persistence.OrganizationNfs anOrgExecutor)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetOrgExecutor(anOrgExecutor);
	}
	/**
	 * addLeaseRules
	 * @generated
	 */
	public void addLeaseRules(com.hps.july.persistence.LeaseRule aLeaseRules)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseRules(aLeaseRules);
	}
	/**
	 * setMainposition
	 * @generated
	 */
	public void setMainposition(
		com.hps.july.persistence.Position aMainposition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setMainposition(aMainposition);
	}
	/**
	 * addLeaseSchetFakts
	 * @generated
	 */
	public void addLeaseSchetFakts(
		com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseSchetFakts(aLeaseSchetFakts);
	}
	/**
	 * getLeaseMRCntPriors1
	 * @generated
	 */
	public java.util.Enumeration getLeaseMRCntPriors1()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseMRCntPriors1();
	}
	/**
	 * getOrgCustomer
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationNfsAccessBean getOrgCustomer()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.OrganizationNfs localEJBRef =
			ejbRef().getOrgCustomer();
		if (localEJBRef != null)
			return new com.hps.july.persistence.OrganizationNfsAccessBean(
				localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryRemoveLeaseMutualContracts
	 * @generated
	 */
	public void secondaryRemoveLeaseMutualContracts(
		com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseMutualContracts(aLeaseMutualContracts);
	}
	/**
	 * getLeaseMutualContracts
	 * @generated
	 */
	public java.util.Enumeration getLeaseMutualContracts()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseMutualContracts();
	}
	/**
	 * secondarySetOrgCustomer
	 * @generated
	 */
	public void secondarySetOrgCustomer(
		com.hps.july.persistence.OrganizationNfs anOrgCustomer)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetOrgCustomer(anOrgCustomer);
	}
	/**
	 * getOrgExecutor
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationNfsAccessBean getOrgExecutor()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.OrganizationNfs localEJBRef =
			ejbRef().getOrgExecutor();
		if (localEJBRef != null)
			return new com.hps.july.persistence.OrganizationNfsAccessBean(
				localEJBRef);
		else
			return null;
	}
	/**
	 * getLeaseonpositions
	 * @generated
	 */
	public java.util.Enumeration getLeaseonpositions()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseonpositions();
	}
	/**
	 * secondaryAddLeaseMRCntPriors1
	 * @generated
	 */
	public void secondaryAddLeaseMRCntPriors1(
		com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors1)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseMRCntPriors1(aLeaseMRCntPriors1);
	}
	/**
	 * secondaryRemoveLeaseRules
	 * @generated
	 */
	public void secondaryRemoveLeaseRules(
		com.hps.july.persistence.LeaseRule aLeaseRules)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseRules(aLeaseRules);
	}
	/**
	 * getCurrency1
	 * @generated
	 */
	public com.hps.july.persistence.CurrencyAccessBean getCurrency1()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Currency localEJBRef = ejbRef().getCurrency1();
		if (localEJBRef != null)
			return new com.hps.july.persistence.CurrencyAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * setOrgExecutor
	 * @generated
	 */
	public void setOrgExecutor(
		com.hps.july.persistence.OrganizationNfs anOrgExecutor)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setOrgExecutor(anOrgExecutor);
	}
	/**
	 * getManager
	 * @generated
	 */
	public com.hps.july.persistence.WorkerAccessBean getManager()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Worker localEJBRef = ejbRef().getManager();
		if (localEJBRef != null)
			return new com.hps.july.persistence.WorkerAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryAddLeaseVPaymentDs
	 * @generated
	 */
	public void secondaryAddLeaseVPaymentDs(
		com.hps.july.persistence.LeaseVPayment aLeaseVPaymentDs)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseVPaymentDs(aLeaseVPaymentDs);
	}
	/**
	 * getMainposition
	 * @generated
	 */
	public com.hps.july.persistence.PositionAccessBean getMainposition()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Position localEJBRef =
			ejbRef().getMainposition();
		if (localEJBRef != null)
			return new com.hps.july.persistence.PositionAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryAddLeaseVPaymentCs
	 * @generated
	 */
	public void secondaryAddLeaseVPaymentCs(
		com.hps.july.persistence.LeaseVPayment aLeaseVPaymentCs)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseVPaymentCs(aLeaseVPaymentCs);
	}
	/**
	 * setCurrency1
	 * @generated
	 */
	public void setCurrency1(com.hps.july.persistence.Currency aCurrency1)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setCurrency1(aCurrency1);
	}
	/**
	 * getLeaseVPaymentCs
	 * @generated
	 */
	public java.util.Enumeration getLeaseVPaymentCs()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseVPaymentCs();
	}
	/**
	 * privateSetManagerKey
	 * @generated
	 */
	public void privateSetManagerKey(com.hps.july.persistence.WorkerKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetManagerKey(inKey);
	}
	/**
	 * privateSetEconomistKey
	 * @generated
	 */
	public void privateSetEconomistKey(
		com.hps.july.persistence.WorkerKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetEconomistKey(inKey);
	}
	/**
	 * removeLeaseTaskStarts
	 * @generated
	 */
	public void removeLeaseTaskStarts(
		com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().removeLeaseTaskStarts(aLeaseTaskStarts);
	}
	/**
	 * privateSetOrgExecutorKey
	 * @generated
	 */
	public void privateSetOrgExecutorKey(
		com.hps.july.persistence.OrganizationNfsKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetOrgExecutorKey(inKey);
	}
	/**
	 * secondaryAddLeaseRules
	 * @generated
	 */
	public void secondaryAddLeaseRules(
		com.hps.july.persistence.LeaseRule aLeaseRules)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseRules(aLeaseRules);
	}
	/**
	 * getLeaseRules
	 * @generated
	 */
	public java.util.Enumeration getLeaseRules()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseRules();
	}
	/**
	 * getLeaseSchetFakts
	 * @generated
	 */
	public java.util.Enumeration getLeaseSchetFakts()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseSchetFakts();
	}
	/**
	 * setCurrency2
	 * @generated
	 */
	public void setCurrency2(com.hps.july.persistence.Currency aCurrency2)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setCurrency2(aCurrency2);
	}
	/**
	 * setOrgCustomer
	 * @generated
	 */
	public void setOrgCustomer(
		com.hps.july.persistence.OrganizationNfs anOrgCustomer)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().setOrgCustomer(anOrgCustomer);
	}
	/**
	 * secondarySetMainposition
	 * @generated
	 */
	public void secondarySetMainposition(
		com.hps.july.persistence.Position aMainposition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetMainposition(aMainposition);
	}
	/**
	 * privateSetOrgCustomerKey
	 * @generated
	 */
	public void privateSetOrgCustomerKey(
		com.hps.july.persistence.OrganizationNfsKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetOrgCustomerKey(inKey);
	}
	/**
	 * secondaryAddLeaseTaskStarts
	 * @generated
	 */
	public void secondaryAddLeaseTaskStarts(
		com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseTaskStarts(aLeaseTaskStarts);
	}
	/**
	 * getLeaseMRCntPriors2
	 * @generated
	 */
	public java.util.Enumeration getLeaseMRCntPriors2()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseMRCntPriors2();
	}
	/**
	 * getLeaseVPaymentDs
	 * @generated
	 */
	public java.util.Enumeration getLeaseVPaymentDs()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseVPaymentDs();
	}
	/**
	 * secondarySetManager
	 * @generated
	 */
	public void secondarySetManager(com.hps.july.persistence.Worker aManager)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetManager(aManager);
	}
	/**
	 * getLeaseDocPosition
	 * @generated
	 */
	public java.util.Enumeration getLeaseDocPosition()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseDocPosition();
	}
	/**
	 * secondarySetCurrency1
	 * @generated
	 */
	public void secondarySetCurrency1(
		com.hps.july.persistence.Currency aCurrency1)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetCurrency1(aCurrency1);
	}
	/**
	 * privateSetCurrency2Key
	 * @generated
	 */
	public void privateSetCurrency2Key(
		com.hps.july.persistence.CurrencyKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetCurrency2Key(inKey);
	}
	/**
	 * secondaryRemoveLeaseMRCntPriors2
	 * @generated
	 */
	public void secondaryRemoveLeaseMRCntPriors2(
		com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors2)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseMRCntPriors2(aLeaseMRCntPriors2);
	}
	/**
	 * secondaryRemoveLeaseonpositions
	 * @generated
	 */
	public void secondaryRemoveLeaseonpositions(
		com.hps.july.persistence.LeaseOnPosition aLeaseonpositions)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseonpositions(aLeaseonpositions);
	}
	/**
	 * privateSetCurrency1Key
	 * @generated
	 */
	public void privateSetCurrency1Key(
		com.hps.july.persistence.CurrencyKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetCurrency1Key(inKey);
	}
	/**
	 * secondaryRemoveLeaseTaskStarts
	 * @generated
	 */
	public void secondaryRemoveLeaseTaskStarts(
		com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseTaskStarts(aLeaseTaskStarts);
	}
	/**
	 * secondarySetEconomist
	 * @generated
	 */
	public void secondarySetEconomist(
		com.hps.july.persistence.Worker anEconomist)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetEconomist(anEconomist);
	}
	/**
	 * secondaryAddLeaseonpositions
	 * @generated
	 */
	public void secondaryAddLeaseonpositions(
		com.hps.july.persistence.LeaseOnPosition aLeaseonpositions)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseonpositions(aLeaseonpositions);
	}
	/**
	 * addLeaseDocPosition
	 * @generated
	 */
	public void addLeaseDocPosition(
		com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseDocPosition(aLeaseDocPosition);
	}
	/**
	 * secondaryRemoveLeaseVPaymentDs
	 * @generated
	 */
	public void secondaryRemoveLeaseVPaymentDs(
		com.hps.july.persistence.LeaseVPayment aLeaseVPaymentDs)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseVPaymentDs(aLeaseVPaymentDs);
	}
	/**
	 * getCurrency2
	 * @generated
	 */
	public com.hps.july.persistence.CurrencyAccessBean getCurrency2()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Currency localEJBRef = ejbRef().getCurrency2();
		if (localEJBRef != null)
			return new com.hps.july.persistence.CurrencyAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * secondaryRemoveLeaseDocPosition
	 * @generated
	 */
	public void secondaryRemoveLeaseDocPosition(
		com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseDocPosition(aLeaseDocPosition);
	}
	/**
	 * secondaryRemoveLeaseVPaymentCs
	 * @generated
	 */
	public void secondaryRemoveLeaseVPaymentCs(
		com.hps.july.persistence.LeaseVPayment aLeaseVPaymentCs)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseVPaymentCs(aLeaseVPaymentCs);
	}
	/**
	 * addLeaseTaskStarts
	 * @generated
	 */
	public void addLeaseTaskStarts(
		com.hps.july.persistence.LeaseTaskStart aLeaseTaskStarts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addLeaseTaskStarts(aLeaseTaskStarts);
	}
	/**
	 * secondaryAddLeaseMutualContracts
	 * @generated
	 */
	public void secondaryAddLeaseMutualContracts(
		com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseMutualContracts(aLeaseMutualContracts);
	}
	/**
	 * secondarySetCurrency2
	 * @generated
	 */
	public void secondarySetCurrency2(
		com.hps.july.persistence.Currency aCurrency2)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondarySetCurrency2(aCurrency2);
	}
	/**
	 * getEconomist
	 * @generated
	 */
	public com.hps.july.persistence.WorkerAccessBean getEconomist()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		com.hps.july.persistence.Worker localEJBRef = ejbRef().getEconomist();
		if (localEJBRef != null)
			return new com.hps.july.persistence.WorkerAccessBean(localEJBRef);
		else
			return null;
	}
	/**
	 * privateSetMainpositionKey
	 * @generated
	 */
	public void privateSetMainpositionKey(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().privateSetMainpositionKey(inKey);
	}
	/**
	 * secondaryAddLeaseSchetFakts
	 * @generated
	 */
	public void secondaryAddLeaseSchetFakts(
		com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseSchetFakts(aLeaseSchetFakts);
	}
}
