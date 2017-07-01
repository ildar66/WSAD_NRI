package com.hps.july.persistence;
import javax.rmi.*;
import com.ibm.ivj.ejb.runtime.*;
/**
 * LeaseAbonentBANAccessBean
 * @generated
 */
public class LeaseAbonentBANAccessBean
	extends AbstractEntityAccessBean
	implements com.hps.july.persistence.LeaseAbonentBANAccessBeanData {
	/**
	 * @generated
	 */
	private LeaseAbonentBAN __ejbRef;
	/**
	 * @generated
	 */
	private int initKey_leaseDocument;
	/**
	 * getUseallben
	 * @generated
	 */
	public boolean getUseallben()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("useallben")).booleanValue());
	}
	/**
	 * setUseallben
	 * @generated
	 */
	public void setUseallben(boolean newValue) {
		__setCache("useallben", new Boolean(newValue));
	}
	/**
	 * getBil_contrstdate
	 * @generated
	 */
	public java.sql.Date getBil_contrstdate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("bil_contrstdate")));
	}
	/**
	 * setBil_contrstdate
	 * @generated
	 */
	public void setBil_contrstdate(java.sql.Date newValue) {
		__setCache("bil_contrstdate", newValue);
	}
	/**
	 * getBil_startservdate
	 * @generated
	 */
	public java.sql.Date getBil_startservdate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("bil_startservdate")));
	}
	/**
	 * setBil_startservdate
	 * @generated
	 */
	public void setBil_startservdate(java.sql.Date newValue) {
		__setCache("bil_startservdate", newValue);
	}
	/**
	 * getBil_contrstatus
	 * @generated
	 */
	public java.lang.String getBil_contrstatus()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bil_contrstatus")));
	}
	/**
	 * setBil_contrstatus
	 * @generated
	 */
	public void setBil_contrstatus(java.lang.String newValue) {
		__setCache("bil_contrstatus", newValue);
	}
	/**
	 * getBil_contrstname
	 * @generated
	 */
	public java.lang.String getBil_contrstname()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bil_contrstname")));
	}
	/**
	 * setBil_contrstname
	 * @generated
	 */
	public void setBil_contrstname(java.lang.String newValue) {
		__setCache("bil_contrstname", newValue);
	}
	/**
	 * getBil_billaddress
	 * @generated
	 */
	public java.lang.String getBil_billaddress()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bil_billaddress")));
	}
	/**
	 * setBil_billaddress
	 * @generated
	 */
	public void setBil_billaddress(java.lang.String newValue) {
		__setCache("bil_billaddress", newValue);
	}
	/**
	 * getProctype
	 * @generated
	 */
	public java.lang.String getProctype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("proctype")));
	}
	/**
	 * setProctype
	 * @generated
	 */
	public void setProctype(java.lang.String newValue) {
		__setCache("proctype", newValue);
	}
	/**
	 * getBil_acctypename
	 * @generated
	 */
	public java.lang.String getBil_acctypename()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bil_acctypename")));
	}
	/**
	 * setBil_acctypename
	 * @generated
	 */
	public void setBil_acctypename(java.lang.String newValue) {
		__setCache("bil_acctypename", newValue);
	}
	/**
	 * getBil_name
	 * @generated
	 */
	public java.lang.String getBil_name()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bil_name")));
	}
	/**
	 * setBil_name
	 * @generated
	 */
	public void setBil_name(java.lang.String newValue) {
		__setCache("bil_name", newValue);
	}
	/**
	 * getBil_inn
	 * @generated
	 */
	public java.lang.String getBil_inn()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("bil_inn")));
	}
	/**
	 * setBil_inn
	 * @generated
	 */
	public void setBil_inn(java.lang.String newValue) {
		__setCache("bil_inn", newValue);
	}
	/**
	 * getBalans
	 * @generated
	 */
	public java.math.BigDecimal getBalans()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.math.BigDecimal) __getCache("balans")));
	}
	/**
	 * setBalans
	 * @generated
	 */
	public void setBalans(java.math.BigDecimal newValue) {
		__setCache("balans", newValue);
	}
	/**
	 * getTechcontract
	 * @generated
	 */
	public boolean getTechcontract()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("techcontract")).booleanValue());
	}
	/**
	 * setTechcontract
	 * @generated
	 */
	public void setTechcontract(boolean newValue) {
		__setCache("techcontract", new Boolean(newValue));
	}
	/**
	 * getUseinacts
	 * @generated
	 */
	public boolean getUseinacts()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("useinacts")).booleanValue());
	}
	/**
	 * setUseinacts
	 * @generated
	 */
	public void setUseinacts(boolean newValue) {
		__setCache("useinacts", new Boolean(newValue));
	}
	/**
	 * getFlagworkpie
	 * @generated
	 */
	public boolean getFlagworkpie()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Boolean) __getCache("flagworkpie")).booleanValue());
	}
	/**
	 * setFlagworkpie
	 * @generated
	 */
	public void setFlagworkpie(boolean newValue) {
		__setCache("flagworkpie", new Boolean(newValue));
	}
	/**
	 * getMainposition
	 * @generated
	 */
	public java.lang.Integer getMainposition()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.Integer) __getCache("mainposition")));
	}
	/**
	 * setMainposition
	 * @generated
	 */
	public void setMainposition(java.lang.Integer newValue) {
		__setCache("mainposition", newValue);
	}
	/**
	 * getBan
	 * @generated
	 */
	public int getBan()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((Integer) __getCache("ban")).intValue());
	}
	/**
	 * setBan
	 * @generated
	 */
	public void setBan(int newValue) {
		__setCache("ban", new Integer(newValue));
	}
	/**
	 * getBil_suspdate
	 * @generated
	 */
	public java.sql.Date getBil_suspdate()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.sql.Date) __getCache("bil_suspdate")));
	}
	/**
	 * setBil_suspdate
	 * @generated
	 */
	public void setBil_suspdate(java.sql.Date newValue) {
		__setCache("bil_suspdate", newValue);
	}
	/**
	 * getAccounttype
	 * @generated
	 */
	public java.lang.String getAccounttype()
		throws
			java.rmi.RemoteException,
			javax.ejb.CreateException,
			javax.ejb.FinderException,
			javax.naming.NamingException {
		return (((java.lang.String) __getCache("accounttype")));
	}
	/**
	 * setAccounttype
	 * @generated
	 */
	public void setAccounttype(java.lang.String newValue) {
		__setCache("accounttype", newValue);
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
	 * LeaseAbonentBANAccessBean
	 * @generated
	 */
	public LeaseAbonentBANAccessBean() {
		super();
	}
	/**
	 * LeaseAbonentBANAccessBean
	 * @generated
	 */
	public LeaseAbonentBANAccessBean(javax.ejb.EJBObject o)
		throws java.rmi.RemoteException {
		super(o);
	}
	/**
	 * defaultJNDIName
	 * @generated
	 */
	public String defaultJNDIName() {
		return "com/hps/july/persistence/LeaseAbonentBAN";
	}
	/**
	 * ejbHome
	 * @generated
	 */
	private com.hps.july.persistence.LeaseAbonentBANHome ejbHome()
		throws java.rmi.RemoteException, javax.naming.NamingException {
		return (
			com
				.hps
				.july
				.persistence
				.LeaseAbonentBANHome) PortableRemoteObject
				.narrow(
			getHome(),
			com.hps.july.persistence.LeaseAbonentBANHome.class);
	}
	/**
	 * ejbRef
	 * @generated
	 */
	private com.hps.july.persistence.LeaseAbonentBAN ejbRef()
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
						.LeaseAbonentBAN) PortableRemoteObject
						.narrow(
					ejbRef,
					com.hps.july.persistence.LeaseAbonentBAN.class);

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
	 * findByBAN
	 * @generated
	 */
	public java.util.Enumeration findByBAN(java.lang.Integer argBan)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseAbonentBANHome localHome = ejbHome();
		java.util.Enumeration ejbs = localHome.findByBAN(argBan);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * LeaseAbonentBANAccessBean
	 * @generated
	 */
	public LeaseAbonentBANAccessBean(
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
		java.lang.String agrCustname,
		java.lang.String argExecname,
		int argBan,
		boolean argFlagWorkPIE)
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
				agrCustname,
				argExecname,
				argBan,
				argFlagWorkPIE);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.String contractType,
		java.lang.Boolean isOrgCustomer,
		java.lang.Integer orgCustomer,
		java.lang.Boolean isOrgExecutor,
		java.lang.Integer orgExecutor,
		java.lang.Boolean isMainEconomist,
		java.lang.Integer mainEconomist,
		java.lang.Boolean isDocNumber,
		java.lang.String docNumber,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseAbonentBANHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE(
				contractType,
				isOrgCustomer,
				orgCustomer,
				isOrgExecutor,
				orgExecutor,
				isMainEconomist,
				mainEconomist,
				isDocNumber,
				docNumber,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByFlagWorkPIE
	 * @generated
	 */
	public java.util.Enumeration findByFlagWorkPIE(
		java.lang.String argFlagWorkPIE)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseAbonentBANHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByFlagWorkPIE(argFlagWorkPIE);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(
		java.lang.Boolean isCustomerName,
		java.lang.String customerName,
		java.lang.Boolean isCustomerInn,
		java.lang.String customerInn,
		java.lang.Boolean isBan,
		java.lang.String ban,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseAbonentBANHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE2(
				isCustomerName,
				customerName,
				isCustomerInn,
				customerInn,
				isBan,
				ban,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * findByQBE3
	 * @generated
	 */
	public java.util.Enumeration findByQBE3(
		java.lang.Boolean isCustomerName,
		java.lang.String customerName,
		java.lang.Boolean isCustomerInn,
		java.lang.String customerInn,
		java.lang.Boolean isBan,
		java.lang.String ban,
		java.lang.Boolean isContractState,
		java.lang.String contractState,
		java.lang.Integer order)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		com.hps.july.persistence.LeaseAbonentBANHome localHome = ejbHome();
		java.util.Enumeration ejbs =
			localHome.findByQBE3(
				isCustomerName,
				customerName,
				isCustomerInn,
				customerInn,
				isBan,
				ban,
				isContractState,
				contractState,
				order);
		return (java.util.Enumeration) createAccessBeans(ejbs);
	}
	/**
	 * LeaseAbonentBANAccessBean
	 * @generated
	 */
	public LeaseAbonentBANAccessBean(int argLeaseDocument)
		throws
			javax.naming.NamingException,
			javax.ejb.CreateException,
			java.rmi.RemoteException {
		ejbRef = ejbHome().create(argLeaseDocument);
	}
	/**
	 * secondaryAddLeaseAbonentBENs
	 * @generated
	 */
	public void secondaryAddLeaseAbonentBENs(
		com.hps.july.persistence.LeaseAbonentBEN aLeaseAbonentBENs)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseAbonentBENs(aLeaseAbonentBENs);
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
	 * secondaryRemoveAbonentPayments
	 * @generated
	 */
	public void secondaryRemoveAbonentPayments(
		com.hps.july.persistence.AbonentPayment anAbonentPayments)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveAbonentPayments(anAbonentPayments);
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
	 * addAbonentPayments
	 * @generated
	 */
	public void addAbonentPayments(
		com.hps.july.persistence.AbonentPayment anAbonentPayments)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addAbonentPayments(anAbonentPayments);
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
	 * addAbonentBills
	 * @generated
	 */
	public void addAbonentBills(
		com.hps.july.persistence.AbonentBill anAbonentBills)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().addAbonentBills(anAbonentBills);
	}
	/**
	 * getAbonentPayments
	 * @generated
	 */
	public java.util.Enumeration getAbonentPayments()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getAbonentPayments();
	}
	/**
	 * getLeaseAbonentBENs
	 * @generated
	 */
	public java.util.Enumeration getLeaseAbonentBENs()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseAbonentBENs();
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
	 * secondaryAddAbonentBills
	 * @generated
	 */
	public void secondaryAddAbonentBills(
		com.hps.july.persistence.AbonentBill anAbonentBills)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddAbonentBills(anAbonentBills);
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
	 * secondaryRemoveLeaseAbonentPhones
	 * @generated
	 */
	public void secondaryRemoveLeaseAbonentPhones(
		com.hps.july.persistence.LeaseAbonentPhone aLeaseAbonentPhones)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseAbonentPhones(aLeaseAbonentPhones);
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
	 * secondaryRemoveAbonentBills
	 * @generated
	 */
	public void secondaryRemoveAbonentBills(
		com.hps.july.persistence.AbonentBill anAbonentBills)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveAbonentBills(anAbonentBills);
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
	 * getLeaseAbonentPhones
	 * @generated
	 */
	public java.util.Enumeration getLeaseAbonentPhones()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getLeaseAbonentPhones();
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
	 * secondaryAddAbonentPayments
	 * @generated
	 */
	public void secondaryAddAbonentPayments(
		com.hps.july.persistence.AbonentPayment anAbonentPayments)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddAbonentPayments(anAbonentPayments);
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
	 * getAbonentBills
	 * @generated
	 */
	public java.util.Enumeration getAbonentBills()
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		return ejbRef().getAbonentBills();
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
	 * secondaryAddLeaseAbonentPhones
	 * @generated
	 */
	public void secondaryAddLeaseAbonentPhones(
		com.hps.july.persistence.LeaseAbonentPhone aLeaseAbonentPhones)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryAddLeaseAbonentPhones(aLeaseAbonentPhones);
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
	 * secondaryRemoveLeaseAbonentBENs
	 * @generated
	 */
	public void secondaryRemoveLeaseAbonentBENs(
		com.hps.july.persistence.LeaseAbonentBEN aLeaseAbonentBENs)
		throws
			javax.naming.NamingException,
			javax.ejb.FinderException,
			java.rmi.RemoteException {
		instantiateEJB();
		ejbRef().secondaryRemoveLeaseAbonentBENs(aLeaseAbonentBENs);
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
