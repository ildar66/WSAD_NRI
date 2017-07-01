package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Абонентский счет
 */
public class LeaseAbonentBANBean extends LeaseContractBean {
	public String accounttype;
	public String bil_acctypename;
	public String bil_billaddress;
	public String bil_contrstatus;
	public String bil_contrstname;
	public String bil_inn;
	public String bil_name;
	public java.sql.Date bil_startservdate;
	public java.sql.Date bil_suspdate;
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseAbonentPhonesLink = null;
	public java.sql.Date bil_contrstdate;
	public int ban;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseAbonentBENsLink = null;
	public boolean flagworkpie;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink abonentPaymentsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink abonentBillsLink = null;
	public boolean useallben;
	public java.math.BigDecimal balans;
	public Integer mainposition;
	public String proctype;
	public boolean useinacts;
	public boolean techcontract;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getLeaseAbonentBENsLink());
	links.addElement(getLeaseAbonentPhonesLink());
	links.addElement(getAbonentPaymentsLink());
	links.addElement(getAbonentBillsLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	leaseAbonentBENsLink = null;
	leaseAbonentPhonesLink = null;
	abonentPaymentsLink = null;
	abonentBillsLink = null;
}
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) throws java.rmi.RemoteException {
	this.getAbonentBillsLink().addElement(anAbonentBills);
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) throws java.rmi.RemoteException {
	this.getAbonentPaymentsLink().addElement(anAbonentPayments);
}
public void ejbCreate(int argLeaseDocument, java.sql.Date argDocDate, String argDocNumber,
	String argContractType, String argContractState, Integer argOrgCustomer, Integer argOrgExecutor, 
	java.sql.Date argStartDate, java.sql.Date argEndDate, String argExtendType, 
	String argReportPeriod, String agrCustname, String argExecname, int argBan, 
	boolean argFlagWorkPIE ) throws javax.ejb.CreateException, java.rmi.RemoteException {

		super.ejbCreate(argLeaseDocument, argDocDate, argDocNumber,
			argContractType, argContractState, argOrgCustomer, argOrgExecutor, 
			argStartDate, argEndDate, argExtendType, 
			argReportPeriod, agrCustname, argExecname );
		
	_initLinks();
	// All CMP fields should be initialized here.
	accounttype = null;
	bil_acctypename = null;
	bil_billaddress = null;
	bil_contrstatus = null;
	bil_contrstname = null;
	bil_inn = null;
	bil_name = null;
	bil_startservdate = null;
	bil_suspdate = null;
	bil_contrstdate = null;
	ban = argBan;
	flagworkpie = argFlagWorkPIE;
	useallben = false;
	balans = null;
	mainposition = null;
	proctype = null;
	useinacts = false;
	techcontract = false;
}
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAbonentBills() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAbonentBillsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAbonentBillsLink() {
	if (abonentBillsLink == null)
		abonentBillsLink = new LeaseAbonentBANToAbonentBillsLink(this);
	return abonentBillsLink;
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAbonentPayments() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAbonentPaymentsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAbonentPaymentsLink() {
	if (abonentPaymentsLink == null)
		abonentPaymentsLink = new LeaseAbonentBANToAbonentPaymentsLink(this);
	return abonentPaymentsLink;
}
/**
 * Getter method for accounttype
 * @return java.lang.String
 */
public java.lang.String getAccounttype() {
	return accounttype;
}
/**
 * Getter method for balans
 */
public java.math.BigDecimal getBalans() {
	return balans;
}
/**
 * Getter method for ban
 */
public int getBan() {
	return ban;
}
/**
 * Getter method for bil_acctypename
 * @return java.lang.String
 */
public java.lang.String getBil_acctypename() {
	return bil_acctypename;
}
/**
 * Getter method for bil_billaddress
 * @return java.lang.String
 */
public java.lang.String getBil_billaddress() {
	return bil_billaddress;
}
/**
 * Getter method for bil_contrstatus
 * @return java.lang.String
 */
public java.lang.String getBil_contrstatus() {
	return bil_contrstatus;
}
/**
 * Getter method for bil_contrstdate
 */
public java.sql.Date getBil_contrstdate() {
	return bil_contrstdate;
}
/**
 * Getter method for bil_contrstname
 * @return java.lang.String
 */
public java.lang.String getBil_contrstname() {
	return bil_contrstname;
}
/**
 * Getter method for bil_inn
 * @return java.lang.String
 */
public java.lang.String getBil_inn() {
	return bil_inn;
}
/**
 * Getter method for bil_name
 * @return java.lang.String
 */
public java.lang.String getBil_name() {
	return bil_name;
}
/**
 * Getter method for bil_startservdate
 * @return java.sql.Date
 */
public java.sql.Date getBil_startservdate() {
	return bil_startservdate;
}
/**
 * Getter method for bil_suspdate
 * @return java.sql.Date
 */
public java.sql.Date getBil_suspdate() {
	return bil_suspdate;
}
/**
 * Getter method for flagworkpie
 */
public boolean getFlagworkpie() {
	return flagworkpie;
}
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseAbonentBENs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseAbonentBENsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseAbonentBENsLink() {
	if (leaseAbonentBENsLink == null)
		leaseAbonentBENsLink = new LeaseAbonentBANToLeaseAbonentBENsLink(this);
	return leaseAbonentBENsLink;
}
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseAbonentPhones() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseAbonentPhonesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseAbonentPhonesLink() {
	if (leaseAbonentPhonesLink == null)
		leaseAbonentPhonesLink = new LeaseAbonentBANToLeaseAbonentPhonesLink(this);
	return leaseAbonentPhonesLink;
}
/**
 * Getter method for mainposition
 */
public java.lang.Integer getMainposition() {
	return mainposition;
}
/**
 * Getter method for proctype
 */
public java.lang.String getProctype() {
	return proctype;
}
/**
 * Getter method for techcontract
 */
public boolean getTechcontract() {
	return techcontract;
}
/**
 * Getter method for useallben
 */
public boolean getUseallben() {
	return useallben;
}
/**
 * Getter method for useinacts
 */
public boolean getUseinacts() {
	return useinacts;
}
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) {
	this.getAbonentBillsLink().secondaryAddElement(anAbonentBills);
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) {
	this.getAbonentPaymentsLink().secondaryAddElement(anAbonentPayments);
}
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseAbonentBENs(com.hps.july.persistence.LeaseAbonentBEN aLeaseAbonentBENs) {
	this.getLeaseAbonentBENsLink().secondaryAddElement(aLeaseAbonentBENs);
}
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseAbonentPhones(com.hps.july.persistence.LeaseAbonentPhone aLeaseAbonentPhones) {
	this.getLeaseAbonentPhonesLink().secondaryAddElement(aLeaseAbonentPhones);
}
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAbonentBills(com.hps.july.persistence.AbonentBill anAbonentBills) {
	this.getAbonentBillsLink().secondaryRemoveElement(anAbonentBills);
}
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAbonentPayments(com.hps.july.persistence.AbonentPayment anAbonentPayments) {
	this.getAbonentPaymentsLink().secondaryRemoveElement(anAbonentPayments);
}
/**
 * This method was generated for supporting the association named LeaseAbonentBEN2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseAbonentBENs(com.hps.july.persistence.LeaseAbonentBEN aLeaseAbonentBENs) {
	this.getLeaseAbonentBENsLink().secondaryRemoveElement(aLeaseAbonentBENs);
}
/**
 * This method was generated for supporting the association named LeaseAbonentPhone2BAN.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseAbonentPhones(com.hps.july.persistence.LeaseAbonentPhone aLeaseAbonentPhones) {
	this.getLeaseAbonentPhonesLink().secondaryRemoveElement(aLeaseAbonentPhones);
}
/**
 * Setter method for accounttype
 * @param newValue java.lang.String
 */
public void setAccounttype(java.lang.String newValue) {
	this.accounttype = newValue;
}
/**
 * Setter method for balans
 */
public void setBalans(java.math.BigDecimal newValue) {
	this.balans = newValue;
}
/**
 * Setter method for ban
 */
public void setBan(int newValue) {
	this.ban = newValue;
}
/**
 * Setter method for bil_acctypename
 * @param newValue java.lang.String
 */
public void setBil_acctypename(java.lang.String newValue) {
	this.bil_acctypename = newValue;
}
/**
 * Setter method for bil_billaddress
 * @param newValue java.lang.String
 */
public void setBil_billaddress(java.lang.String newValue) {
	this.bil_billaddress = newValue;
}
/**
 * Setter method for bil_contrstatus
 * @param newValue java.lang.String
 */
public void setBil_contrstatus(java.lang.String newValue) {
	this.bil_contrstatus = newValue;
}
/**
 * Setter method for bil_contrstdate
 */
public void setBil_contrstdate(java.sql.Date newValue) {
	this.bil_contrstdate = newValue;
}
/**
 * Setter method for bil_contrstname
 * @param newValue java.lang.String
 */
public void setBil_contrstname(java.lang.String newValue) {
	this.bil_contrstname = newValue;
}
/**
 * Setter method for bil_inn
 * @param newValue java.lang.String
 */
public void setBil_inn(java.lang.String newValue) {
	this.bil_inn = newValue;
}
/**
 * Setter method for bil_name
 * @param newValue java.lang.String
 */
public void setBil_name(java.lang.String newValue) {
	this.bil_name = newValue;
}
/**
 * Setter method for bil_startservdate
 * @param newValue java.sql.Date
 */
public void setBil_startservdate(java.sql.Date newValue) {
	this.bil_startservdate = newValue;
}
/**
 * Setter method for bil_suspdate
 * @param newValue java.sql.Date
 */
public void setBil_suspdate(java.sql.Date newValue) {
	this.bil_suspdate = newValue;
}
/**
 * Setter method for flagworkpie
 */
public void setFlagworkpie(boolean newValue) {
	this.flagworkpie = newValue;
}
/**
 * Setter method for mainposition
 */
public void setMainposition(java.lang.Integer newValue) {
	this.mainposition = newValue;
}
/**
 * Setter method for proctype
 */
public void setProctype(java.lang.String newValue) {
	this.proctype = newValue;
}
/**
 * Setter method for techcontract
 */
public void setTechcontract(boolean newValue) {
	this.techcontract = newValue;
}
/**
 * Setter method for useallben
 */
public void setUseallben(boolean newValue) {
	this.useallben = newValue;
}
/**
 * Setter method for useinacts
 */
public void setUseinacts(boolean newValue) {
	this.useinacts = newValue;
}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("useallben", new Boolean(getUseallben()));
		h.put("bil_contrstdate", getBil_contrstdate());
		h.put("bil_startservdate", getBil_startservdate());
		h.put("bil_contrstatus", getBil_contrstatus());
		h.put("bil_contrstname", getBil_contrstname());
		h.put("bil_billaddress", getBil_billaddress());
		h.put("proctype", getProctype());
		h.put("bil_acctypename", getBil_acctypename());
		h.put("bil_name", getBil_name());
		h.put("bil_inn", getBil_inn());
		h.put("balans", getBalans());
		h.put("techcontract", new Boolean(getTechcontract()));
		h.put("useinacts", new Boolean(getUseinacts()));
		h.put("flagworkpie", new Boolean(getFlagworkpie()));
		h.put("mainposition", getMainposition());
		h.put("ban", new Integer(getBan()));
		h.put("bil_suspdate", getBil_suspdate());
		h.put("accounttype", getAccounttype());
		h.put("currency1Key", getCurrency1Key());
		h.put("buchdocnumber", getBuchdocnumber());
		h.put("startDate", getStartDate());
		h.put("managerKey", getManagerKey());
		h.put("reportPeriod", getReportPeriod());
		h.put("ratedelta", getRatedelta());
		h.put("contractState", getContractState());
		h.put("havedocsigned", getHavedocsigned());
		h.put("dateclose", getDateclose());
		h.put("ratecalcruleday", getRatecalcruleday());
		h.put("rateLimitMax", getRateLimitMax());
		h.put("endDate", getEndDate());
		h.put("currency2Key", getCurrency2Key());
		h.put("contractType", getContractType());
		h.put("ratecalcrule", getRatecalcrule());
		h.put("execname", getExecname());
		h.put("extendmonthes", getExtendmonthes());
		h.put("orgowner", getOrgowner());
		h.put("extendType", getExtendType());
		h.put("nalogAgent", new Boolean(getNalogAgent()));
		h.put("orgCustomerKey", getOrgCustomerKey());
		h.put("chargeNds", new Boolean(getChargeNds()));
		h.put("extendPeriod", getExtendPeriod());
		h.put("summ2", getSumm2());
		h.put("summ1", getSumm1());
		h.put("havedocsignedcustomer", getHavedocsignedcustomer());
		h.put("isRateLimit", new Boolean(getIsRateLimit()));
		h.put("orgExecutorKey", getOrgExecutorKey());
		h.put("docFileName", getDocFileName());
		h.put("rateLimitMin", getRateLimitMin());
		h.put("extendyears", getExtendyears());
		h.put("custname", getCustname());
		h.put("economistKey", getEconomistKey());
		h.put("rateNDS", getRateNDS());
		h.put("extenddays", getExtenddays());
		h.put("changeenddate", getChangeenddate());
		h.put("operator", getOperator());
		h.put("documentDate", getDocumentDate());
		h.put("leaseDocument", new Integer(getLeaseDocument()));
		h.put("created", getCreated());
		h.put("documentNumber", getDocumentNumber());
		h.put("regionid", new Integer(getRegionid()));
		h.put("modified", getModified());
		h.put("createdby", getCreatedby());
		h.put("modifiedby", getModifiedby());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Boolean localUseallben = (Boolean) h.get("useallben");
		java.sql.Date localBil_contrstdate =
			(java.sql.Date) h.get("bil_contrstdate");
		java.sql.Date localBil_startservdate =
			(java.sql.Date) h.get("bil_startservdate");
		java.lang.String localBil_contrstatus =
			(java.lang.String) h.get("bil_contrstatus");
		java.lang.String localBil_contrstname =
			(java.lang.String) h.get("bil_contrstname");
		java.lang.String localBil_billaddress =
			(java.lang.String) h.get("bil_billaddress");
		java.lang.String localProctype = (java.lang.String) h.get("proctype");
		java.lang.String localBil_acctypename =
			(java.lang.String) h.get("bil_acctypename");
		java.lang.String localBil_name = (java.lang.String) h.get("bil_name");
		java.lang.String localBil_inn = (java.lang.String) h.get("bil_inn");
		java.math.BigDecimal localBalans =
			(java.math.BigDecimal) h.get("balans");
		Boolean localTechcontract = (Boolean) h.get("techcontract");
		Boolean localUseinacts = (Boolean) h.get("useinacts");
		Boolean localFlagworkpie = (Boolean) h.get("flagworkpie");
		java.lang.Integer localMainposition =
			(java.lang.Integer) h.get("mainposition");
		Integer localBan = (Integer) h.get("ban");
		java.sql.Date localBil_suspdate = (java.sql.Date) h.get("bil_suspdate");
		java.lang.String localAccounttype =
			(java.lang.String) h.get("accounttype");
		java.lang.String localBuchdocnumber =
			(java.lang.String) h.get("buchdocnumber");
		java.sql.Date localStartDate = (java.sql.Date) h.get("startDate");
		java.lang.String localReportPeriod =
			(java.lang.String) h.get("reportPeriod");
		java.math.BigDecimal localRatedelta =
			(java.math.BigDecimal) h.get("ratedelta");
		java.lang.String localContractState =
			(java.lang.String) h.get("contractState");
		java.lang.Boolean localHavedocsigned =
			(java.lang.Boolean) h.get("havedocsigned");
		java.sql.Date localDateclose = (java.sql.Date) h.get("dateclose");
		java.lang.Short localRatecalcruleday =
			(java.lang.Short) h.get("ratecalcruleday");
		java.math.BigDecimal localRateLimitMax =
			(java.math.BigDecimal) h.get("rateLimitMax");
		java.sql.Date localEndDate = (java.sql.Date) h.get("endDate");
		java.lang.String localContractType =
			(java.lang.String) h.get("contractType");
		java.lang.String localRatecalcrule =
			(java.lang.String) h.get("ratecalcrule");
		java.lang.String localExecname = (java.lang.String) h.get("execname");
		java.lang.Short localExtendmonthes =
			(java.lang.Short) h.get("extendmonthes");
		java.lang.Integer localOrgowner = (java.lang.Integer) h.get("orgowner");
		java.lang.String localExtendType =
			(java.lang.String) h.get("extendType");
		Boolean localNalogAgent = (Boolean) h.get("nalogAgent");
		Boolean localChargeNds = (Boolean) h.get("chargeNds");
		java.lang.String localExtendPeriod =
			(java.lang.String) h.get("extendPeriod");
		java.math.BigDecimal localSumm2 = (java.math.BigDecimal) h.get("summ2");
		java.math.BigDecimal localSumm1 = (java.math.BigDecimal) h.get("summ1");
		java.lang.Boolean localHavedocsignedcustomer =
			(java.lang.Boolean) h.get("havedocsignedcustomer");
		Boolean localIsRateLimit = (Boolean) h.get("isRateLimit");
		java.lang.String localDocFileName =
			(java.lang.String) h.get("docFileName");
		java.math.BigDecimal localRateLimitMin =
			(java.math.BigDecimal) h.get("rateLimitMin");
		java.lang.Short localExtendyears =
			(java.lang.Short) h.get("extendyears");
		java.lang.String localCustname = (java.lang.String) h.get("custname");
		java.math.BigDecimal localRateNDS =
			(java.math.BigDecimal) h.get("rateNDS");
		java.lang.Short localExtenddays = (java.lang.Short) h.get("extenddays");
		java.lang.String localChangeenddate =
			(java.lang.String) h.get("changeenddate");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.sql.Date localDocumentDate = (java.sql.Date) h.get("documentDate");
		Integer localLeaseDocument = (Integer) h.get("leaseDocument");
		java.sql.Timestamp localCreated = (java.sql.Timestamp) h.get("created");
		java.lang.String localDocumentNumber =
			(java.lang.String) h.get("documentNumber");
		Integer localRegionid = (Integer) h.get("regionid");
		java.sql.Timestamp localModified =
			(java.sql.Timestamp) h.get("modified");
		java.lang.Integer localCreatedby =
			(java.lang.Integer) h.get("createdby");
		java.lang.Integer localModifiedby =
			(java.lang.Integer) h.get("modifiedby");

		if (h.containsKey("useallben"))
			setUseallben((localUseallben).booleanValue());
		if (h.containsKey("bil_contrstdate"))
			setBil_contrstdate((localBil_contrstdate));
		if (h.containsKey("bil_startservdate"))
			setBil_startservdate((localBil_startservdate));
		if (h.containsKey("bil_contrstatus"))
			setBil_contrstatus((localBil_contrstatus));
		if (h.containsKey("bil_contrstname"))
			setBil_contrstname((localBil_contrstname));
		if (h.containsKey("bil_billaddress"))
			setBil_billaddress((localBil_billaddress));
		if (h.containsKey("proctype"))
			setProctype((localProctype));
		if (h.containsKey("bil_acctypename"))
			setBil_acctypename((localBil_acctypename));
		if (h.containsKey("bil_name"))
			setBil_name((localBil_name));
		if (h.containsKey("bil_inn"))
			setBil_inn((localBil_inn));
		if (h.containsKey("balans"))
			setBalans((localBalans));
		if (h.containsKey("techcontract"))
			setTechcontract((localTechcontract).booleanValue());
		if (h.containsKey("useinacts"))
			setUseinacts((localUseinacts).booleanValue());
		if (h.containsKey("flagworkpie"))
			setFlagworkpie((localFlagworkpie).booleanValue());
		if (h.containsKey("mainposition"))
			setMainposition((localMainposition));
		if (h.containsKey("ban"))
			setBan((localBan).intValue());
		if (h.containsKey("bil_suspdate"))
			setBil_suspdate((localBil_suspdate));
		if (h.containsKey("accounttype"))
			setAccounttype((localAccounttype));
		if (h.containsKey("buchdocnumber"))
			setBuchdocnumber((localBuchdocnumber));
		if (h.containsKey("startDate"))
			setStartDate((localStartDate));
		if (h.containsKey("reportPeriod"))
			setReportPeriod((localReportPeriod));
		if (h.containsKey("ratedelta"))
			setRatedelta((localRatedelta));
		if (h.containsKey("contractState"))
			setContractState((localContractState));
		if (h.containsKey("havedocsigned"))
			setHavedocsigned((localHavedocsigned));
		if (h.containsKey("dateclose"))
			setDateclose((localDateclose));
		if (h.containsKey("ratecalcruleday"))
			setRatecalcruleday((localRatecalcruleday));
		if (h.containsKey("rateLimitMax"))
			setRateLimitMax((localRateLimitMax));
		if (h.containsKey("endDate"))
			setEndDate((localEndDate));
		if (h.containsKey("contractType"))
			setContractType((localContractType));
		if (h.containsKey("ratecalcrule"))
			setRatecalcrule((localRatecalcrule));
		if (h.containsKey("execname"))
			setExecname((localExecname));
		if (h.containsKey("extendmonthes"))
			setExtendmonthes((localExtendmonthes));
		if (h.containsKey("orgowner"))
			setOrgowner((localOrgowner));
		if (h.containsKey("extendType"))
			setExtendType((localExtendType));
		if (h.containsKey("nalogAgent"))
			setNalogAgent((localNalogAgent).booleanValue());
		if (h.containsKey("chargeNds"))
			setChargeNds((localChargeNds).booleanValue());
		if (h.containsKey("extendPeriod"))
			setExtendPeriod((localExtendPeriod));
		if (h.containsKey("summ2"))
			setSumm2((localSumm2));
		if (h.containsKey("summ1"))
			setSumm1((localSumm1));
		if (h.containsKey("havedocsignedcustomer"))
			setHavedocsignedcustomer((localHavedocsignedcustomer));
		if (h.containsKey("isRateLimit"))
			setIsRateLimit((localIsRateLimit).booleanValue());
		if (h.containsKey("docFileName"))
			setDocFileName((localDocFileName));
		if (h.containsKey("rateLimitMin"))
			setRateLimitMin((localRateLimitMin));
		if (h.containsKey("extendyears"))
			setExtendyears((localExtendyears));
		if (h.containsKey("custname"))
			setCustname((localCustname));
		if (h.containsKey("rateNDS"))
			setRateNDS((localRateNDS));
		if (h.containsKey("extenddays"))
			setExtenddays((localExtenddays));
		if (h.containsKey("changeenddate"))
			setChangeenddate((localChangeenddate));
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("documentDate"))
			setDocumentDate((localDocumentDate));
		if (h.containsKey("leaseDocument"))
			setLeaseDocument((localLeaseDocument).intValue());
		if (h.containsKey("created"))
			setCreated((localCreated));
		if (h.containsKey("documentNumber"))
			setDocumentNumber((localDocumentNumber));
		if (h.containsKey("regionid"))
			setRegionid((localRegionid).intValue());
		if (h.containsKey("modified"))
			setModified((localModified));
		if (h.containsKey("createdby"))
			setCreatedby((localCreatedby));
		if (h.containsKey("modifiedby"))
			setModifiedby((localModifiedby));
	}
}
