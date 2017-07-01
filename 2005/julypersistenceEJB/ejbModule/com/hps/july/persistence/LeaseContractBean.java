package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Договор аренды
 */
public class LeaseContractBean extends LeaseDocumentBean {
	public String contractState;
	public String contractType;
	public java.sql.Date endDate;
	public String extendPeriod;
	public String extendType;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.sql.Date startDate;
	public java.lang.Integer economist_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink economistLink = null;
	public String reportPeriod;
	public java.math.BigDecimal summ1;
	public java.math.BigDecimal summ2;
	public java.lang.Integer currency1_currency;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink currency1Link = null;
	public java.lang.Integer currency2_currency;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink currency2Link = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseDocPositionLink = null;
	public String docFileName;
	public String custname;
	public String execname;
	public String ratecalcrule;
	public Short ratecalcruleday;
	public java.math.BigDecimal ratedelta;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseMutualContractsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseMRCntPriors1Link = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseMRCntPriors2Link = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseVPaymentDsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseVPaymentCsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseSchetFaktsLink = null;
	public java.sql.Date dateclose;
	public java.lang.Integer manager_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink managerLink = null;
	public boolean chargeNds;
	public Integer orgowner;
	public String changeenddate;
	public Short extendyears;
	public Short extendmonthes;
	public Short extenddays;
	/**
	 * Implementation field for persistent attribute: RateNDS
	 */
	public java.math.BigDecimal RateNDS;
	/**
	 * Implementation field for persistent attribute: NalogAgent
	 */
	public boolean NalogAgent;
	/**
	 * Implementation field for persistent attribute: orgExecutor_organization
	 */
	public java.lang.Integer orgExecutor_organization;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink orgExecutorLink;
	/**
	 * Implementation field for persistent attribute: orgCustomer_organization
	 */
	public java.lang.Integer orgCustomer_organization;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink orgCustomerLink;
	/**
	 * Implementation field for persistent attribute: isRateLimit
	 */
	public boolean isRateLimit;
	/**
	 * Implementation field for persistent attribute: rateLimitMin
	 */
	public java.math.BigDecimal rateLimitMin;
	/**
	 * Implementation field for persistent attribute: rateLimitMax
	 */
	public java.math.BigDecimal rateLimitMax;
	/**
	 * Implementation field for persistent attribute: buchdocnumber
	 */
	public java.lang.String buchdocnumber;
	/**
	 * Implementation field for persistent attribute: havedocsigned
	 */
	public java.lang.Boolean havedocsigned;
	/**
	 * Implementation field for persistent attribute: havedocsignedcustomer
	 */
	public java.lang.Boolean havedocsignedcustomer;
	/**
	 * This method was generated for supporting the associations.
	 */
	protected java.util.Vector _getLinks() {
		java.util.Vector links = super._getLinks();
		links.add(getManagerLink());
		links.add(getLeaseMRCntPriors2Link());
		links.add(getLeaseMRCntPriors1Link());
		links.add(getLeaseVPaymentCsLink());
		links.add(getLeaseSchetFaktsLink());
		links.add(getLeaseMutualContractsLink());
		links.add(getEconomistLink());
		links.add(getCurrency2Link());
		links.add(getLeaseDocPositionLink());
		links.add(getLeaseVPaymentDsLink());
		links.add(getCurrency1Link());
		links.add(getOrgExecutorLink());
		links.add(getOrgCustomerLink());
		return links;
	}
	/**
	 * This method was generated for supporting the associations.
	 */
	protected void _initLinks() {
		super._initLinks();
		managerLink = null;
		leaseMRCntPriors2Link = null;
		leaseMRCntPriors1Link = null;
		leaseVPaymentCsLink = null;
		leaseSchetFaktsLink = null;
		leaseMutualContractsLink = null;
		economistLink = null;
		currency2Link = null;
		leaseDocPositionLink = null;
		leaseVPaymentDsLink = null;
		currency1Link = null;
		orgExecutorLink = null;
		orgCustomerLink = null;
	}
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) throws java.rmi.RemoteException {
	this.getLeaseDocPositionLink().addElement(aLeaseDocPosition);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
	this.getLeaseSchetFaktsLink().addElement(aLeaseSchetFakts);
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argLeaseDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argLeaseDocument, java.sql.Date argDocDate, String argDocNumber,
	String argContractType, String argContractState, Integer argOrgCustomer, Integer argOrgExecutor, 
	java.sql.Date argStartDate, java.sql.Date argEndDate, String argExtendType, 
	String argReportPeriod, String agrCustname, String argExecname ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate(argLeaseDocument, argDocDate, argDocNumber );
	_initLinks();
	// All CMP fields should be initialized here.
	contractState = null;
	contractType = null;
	endDate = null;
	extendPeriod = null;
	extendType = null;
	startDate = null;
	orgCustomer_organization = null;
	orgExecutor_organization = null;
	economist_worker = null;
	ratecalcrule = null;
	ratecalcruleday = null;
	ratedelta = null;

	contractType = argContractType;
	contractState = argContractState;
	orgCustomer_organization = argOrgCustomer;
	orgExecutor_organization = argOrgExecutor;
	startDate = argStartDate;
	endDate = argEndDate;
	extendType = argExtendType;
	reportPeriod = argReportPeriod;
	custname = agrCustname;
	execname = argExecname;
	chargeNds = true;
	orgowner = null;
	changeenddate = "H";
	extendyears = null;
	extendmonthes = null;
	extenddays = null;
	RateNDS = null;
	NalogAgent = false;
	isRateLimit = false;
	rateLimitMin = null;
	rateLimitMax = null;
	buchdocnumber = null;
	havedocsigned = Boolean.FALSE;
	havedocsignedcustomer = Boolean.FALSE;
}
/**
 * Getter method for changeenddate
 */
public java.lang.String getChangeenddate() {
	return changeenddate;
}
/**
 * Getter method for chargeNds
 */
public boolean getChargeNds() {
	return chargeNds;
}
/**
 * Getter method for contractState
 * @return java.lang.String
 */
public java.lang.String getContractState() {
	return contractState;
}
/**
 * Getter method for contractType
 * @return java.lang.String
 */
public java.lang.String getContractType() {
	return contractType;
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency1() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Currency)this.getCurrency1Link().value();
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getCurrency1Key() {
	com.hps.july.persistence.CurrencyKey temp = null;
	temp = new com.hps.july.persistence.CurrencyKey();
	boolean currency1_NULLTEST = true;
	currency1_NULLTEST &= (currency1_currency == null);
	temp.currency = ((currency1_currency == null) ? 0 : currency1_currency.intValue());
	if (currency1_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCurrency1Link() {
	if (currency1Link == null)
		currency1Link = new LeaseContractToCurrency1Link(this);
	return currency1Link;
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency2() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Currency)this.getCurrency2Link().value();
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getCurrency2Key() {
	com.hps.july.persistence.CurrencyKey temp = null;
	temp = new com.hps.july.persistence.CurrencyKey();
	boolean currency2_NULLTEST = true;
	currency2_NULLTEST &= (currency2_currency == null);
	temp.currency = ((currency2_currency == null) ? 0 : currency2_currency.intValue());
	if (currency2_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCurrency2Link() {
	if (currency2Link == null)
		currency2Link = new LeaseContractToCurrency2Link(this);
	return currency2Link;
}
/**
 * Getter method for custname
 */
public java.lang.String getCustname() {
	return custname;
}
/**
 * Getter method for dateclose
 */
public java.sql.Date getDateclose() {
	return dateclose;
}
/**
 * Getter method for docFileName
 */
public java.lang.String getDocFileName() {
	return docFileName;
}
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getEconomist() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getEconomistLink().value();
}
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getEconomistKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean economist_NULLTEST = true;
	economist_NULLTEST &= (economist_worker == null);
	temp.worker = ((economist_worker == null) ? 0 : economist_worker.intValue());
	if (economist_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getEconomistLink() {
	if (economistLink == null)
		economistLink = new LeaseContractToEconomistLink(this);
	return economistLink;
}
/**
 * Getter method for endDate
 * @return java.sql.Date
 */
public java.sql.Date getEndDate() {
	return endDate;
}
/**
 * Getter method for execname
 */
public java.lang.String getExecname() {
	return execname;
}
/**
 * Getter method for extenddays
 */
public java.lang.Short getExtenddays() {
	return extenddays;
}
/**
 * Getter method for extendmonthes
 */
public java.lang.Short getExtendmonthes() {
	return extendmonthes;
}
/**
 * Getter method for extendPeriod
 * @return java.lang.String
 */
public java.lang.String getExtendPeriod() {
	return extendPeriod;
}
/**
 * Getter method for extendType
 * @return java.lang.String
 */
public java.lang.String getExtendType() {
	return extendType;
}
/**
 * Getter method for extendyears
 */
public java.lang.Short getExtendyears() {
	return extendyears;
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseDocPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseDocPositionLink() {
	if (leaseDocPositionLink == null)
		leaseDocPositionLink = new LeaseContractToLeaseDocPositionLink(this);
	return leaseDocPositionLink;
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMRCntPriors1() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseMRCntPriors1Link().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseMRCntPriors1Link() {
	if (leaseMRCntPriors1Link == null)
		leaseMRCntPriors1Link = new LeaseContractToLeaseMRCntPriors1Link(this);
	return leaseMRCntPriors1Link;
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMRCntPriors2() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseMRCntPriors2Link().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseMRCntPriors2Link() {
	if (leaseMRCntPriors2Link == null)
		leaseMRCntPriors2Link = new LeaseContractToLeaseMRCntPriors2Link(this);
	return leaseMRCntPriors2Link;
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseMutualContracts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseMutualContractsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseMutualContractsLink() {
	if (leaseMutualContractsLink == null)
		leaseMutualContractsLink = new LeaseContractToLeaseMutualContractsLink(this);
	return leaseMutualContractsLink;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseSchetFaktsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseSchetFaktsLink() {
	if (leaseSchetFaktsLink == null)
		leaseSchetFaktsLink = new LeaseContractToLeaseSchetFaktsLink(this);
	return leaseSchetFaktsLink;
}
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseVPaymentCs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseVPaymentCsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseVPaymentCsLink() {
	if (leaseVPaymentCsLink == null)
		leaseVPaymentCsLink = new LeaseContractToLeaseVPaymentCsLink(this);
	return leaseVPaymentCsLink;
}
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseVPaymentDs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseVPaymentDsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseVPaymentDsLink() {
	if (leaseVPaymentDsLink == null)
		leaseVPaymentDsLink = new LeaseContractToLeaseVPaymentDsLink(this);
	return leaseVPaymentDsLink;
}
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getManager() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getManagerLink().value();
}
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getManagerKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean manager_NULLTEST = true;
	manager_NULLTEST &= (manager_worker == null);
	temp.worker = ((manager_worker == null) ? 0 : manager_worker.intValue());
	if (manager_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getManagerLink() {
	if (managerLink == null)
		managerLink = new LeaseContractToManagerLink(this);
	return managerLink;
}
/**
 * Getter method for orgowner
 */
public java.lang.Integer getOrgowner() {
	return orgowner;
}
/**
 * Getter method for ratecalcrule
 */
public java.lang.String getRatecalcrule() {
	return ratecalcrule;
}
/**
 * Getter method for ratecalcruleday
 */
public java.lang.Short getRatecalcruleday() {
	return ratecalcruleday;
}
/**
 * Getter method for ratedelta
 */
public java.math.BigDecimal getRatedelta() {
	return ratedelta;
}
/**
 * Getter method for reportPeriod
 */
public java.lang.String getReportPeriod() {
	return reportPeriod;
}
/**
 * Getter method for startDate
 * @return java.sql.Date
 */
public java.sql.Date getStartDate() {
	return startDate;
}
/**
 * Getter method for summ1
 */
public java.math.BigDecimal getSumm1() {
	return summ1;
}
/**
 * Getter method for summ2
 */
public java.math.BigDecimal getSumm2() {
	return summ2;
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrency1Key(com.hps.july.persistence.CurrencyKey inKey) {
	boolean currency1_NULLTEST = (inKey == null);
	if (currency1_NULLTEST) currency1_currency = null; else currency1_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrency2Key(com.hps.july.persistence.CurrencyKey inKey) {
	boolean currency2_NULLTEST = (inKey == null);
	if (currency2_NULLTEST) currency2_currency = null; else currency2_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetEconomistKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean economist_NULLTEST = (inKey == null);
	if (economist_NULLTEST) economist_worker = null; else economist_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetManagerKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean manager_NULLTEST = (inKey == null);
	if (manager_NULLTEST) manager_worker = null; else manager_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) {
	this.getLeaseDocPositionLink().secondaryAddElement(aLeaseDocPosition);
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMRCntPriors1(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors1) {
	this.getLeaseMRCntPriors1Link().secondaryAddElement(aLeaseMRCntPriors1);
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMRCntPriors2(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors2) {
	this.getLeaseMRCntPriors2Link().secondaryAddElement(aLeaseMRCntPriors2);
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) {
	this.getLeaseMutualContractsLink().secondaryAddElement(aLeaseMutualContracts);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) {
	this.getLeaseSchetFaktsLink().secondaryAddElement(aLeaseSchetFakts);
}
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseVPaymentCs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentCs) {
	this.getLeaseVPaymentCsLink().secondaryAddElement(aLeaseVPaymentCs);
}
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseVPaymentDs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentDs) {
	this.getLeaseVPaymentDsLink().secondaryAddElement(aLeaseVPaymentDs);
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseDocPosition(com.hps.july.persistence.LeaseDocPosition aLeaseDocPosition) {
	this.getLeaseDocPositionLink().secondaryRemoveElement(aLeaseDocPosition);
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMRCntPriors1(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors1) {
	this.getLeaseMRCntPriors1Link().secondaryRemoveElement(aLeaseMRCntPriors1);
}
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMRCntPriors2(com.hps.july.persistence.LeaseMRCntPrior aLeaseMRCntPriors2) {
	this.getLeaseMRCntPriors2Link().secondaryRemoveElement(aLeaseMRCntPriors2);
}
/**
 * This method was generated for supporting the association named LeaseMutualContracts2contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseMutualContracts(com.hps.july.persistence.LeaseMutualContracts aLeaseMutualContracts) {
	this.getLeaseMutualContractsLink().secondaryRemoveElement(aLeaseMutualContracts);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) {
	this.getLeaseSchetFaktsLink().secondaryRemoveElement(aLeaseSchetFakts);
}
/**
 * This method was generated for supporting the association named LeaseVPayment2creditcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseVPaymentCs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentCs) {
	this.getLeaseVPaymentCsLink().secondaryRemoveElement(aLeaseVPaymentCs);
}
/**
 * This method was generated for supporting the association named LeaseVPayment2debetcontract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseVPaymentDs(com.hps.july.persistence.LeaseVPayment aLeaseVPaymentDs) {
	this.getLeaseVPaymentDsLink().secondaryRemoveElement(aLeaseVPaymentDs);
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrency1(com.hps.july.persistence.Currency aCurrency1) throws java.rmi.RemoteException {
	this.getCurrency1Link().secondarySet(aCurrency1);
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrency2(com.hps.july.persistence.Currency aCurrency2) throws java.rmi.RemoteException {
	this.getCurrency2Link().secondarySet(aCurrency2);
}
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetEconomist(com.hps.july.persistence.Worker anEconomist) throws java.rmi.RemoteException {
	this.getEconomistLink().secondarySet(anEconomist);
}
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetManager(com.hps.july.persistence.Worker aManager) throws java.rmi.RemoteException {
	this.getManagerLink().secondarySet(aManager);
}
/**
 * Setter method for changeenddate
 */
public void setChangeenddate(java.lang.String newValue) {
	this.changeenddate = newValue;
}
/**
 * Setter method for chargeNds
 */
public void setChargeNds(boolean newValue) {
	this.chargeNds = newValue;
}
/**
 * Setter method for contractState
 * @param newValue java.lang.String
 */
public void setContractState(java.lang.String newValue) {
	this.contractState = newValue;
}
/**
 * Setter method for contractType
 * @param newValue java.lang.String
 */
public void setContractType(java.lang.String newValue) {
	this.contractType = newValue;
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrency1(com.hps.july.persistence.Currency aCurrency1) throws java.rmi.RemoteException {
	this.getCurrency1Link().set(aCurrency1);
}
/**
 * This method was generated for supporting the association named LeaseContract2Currency2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrency2(com.hps.july.persistence.Currency aCurrency2) throws java.rmi.RemoteException {
	this.getCurrency2Link().set(aCurrency2);
}
/**
 * Setter method for custname
 */
public void setCustname(java.lang.String newValue) {
	this.custname = newValue;
}
/**
 * Setter method for dateclose
 */
public void setDateclose(java.sql.Date newValue) {
	this.dateclose = newValue;
}
/**
 * Setter method for docFileName
 */
public void setDocFileName(java.lang.String newValue) {
	this.docFileName = newValue;
}
/**
 * This method was generated for supporting the association named LeaseContract2WorkerEconomist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setEconomist(com.hps.july.persistence.Worker anEconomist) throws java.rmi.RemoteException {
	this.getEconomistLink().set(anEconomist);
}
/**
 * Setter method for endDate
 * @param newValue java.sql.Date
 */
public void setEndDate(java.sql.Date newValue) {
	this.endDate = newValue;
}
/**
 * Setter method for execname
 */
public void setExecname(java.lang.String newValue) {
	this.execname = newValue;
}
/**
 * Setter method for extenddays
 */
public void setExtenddays(java.lang.Short newValue) {
	this.extenddays = newValue;
}
/**
 * Setter method for extendmonthes
 */
public void setExtendmonthes(java.lang.Short newValue) {
	this.extendmonthes = newValue;
}
/**
 * Setter method for extendPeriod
 * @param newValue java.lang.String
 */
public void setExtendPeriod(java.lang.String newValue) {
	this.extendPeriod = newValue;
}
/**
 * Setter method for extendType
 * @param newValue java.lang.String
 */
public void setExtendType(java.lang.String newValue) {
	this.extendType = newValue;
}
/**
 * Setter method for extendyears
 */
public void setExtendyears(java.lang.Short newValue) {
	this.extendyears = newValue;
}
/**
 * This method was generated for supporting the association named LeaseContract2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setManager(com.hps.july.persistence.Worker aManager) throws java.rmi.RemoteException {
	this.getManagerLink().set(aManager);
}
/**
 * Setter method for orgowner
 */
public void setOrgowner(java.lang.Integer newValue) {
	this.orgowner = newValue;
}
/**
 * Setter method for ratecalcrule
 */
public void setRatecalcrule(java.lang.String newValue) {
	this.ratecalcrule = newValue;
}
/**
 * Setter method for ratecalcruleday
 */
public void setRatecalcruleday(java.lang.Short newValue) {
	this.ratecalcruleday = newValue;
}
/**
 * Setter method for ratedelta
 */
public void setRatedelta(java.math.BigDecimal newValue) {
	this.ratedelta = newValue;
}
/**
 * Setter method for reportPeriod
 */
public void setReportPeriod(java.lang.String newValue) {
	this.reportPeriod = newValue;
}
/**
 * Setter method for startDate
 * @param newValue java.sql.Date
 */
public void setStartDate(java.sql.Date newValue) {
	this.startDate = newValue;
}
/**
 * Setter method for summ1
 */
public void setSumm1(java.math.BigDecimal newValue) {
	this.summ1 = newValue;
}
/**
 * Setter method for summ2
 */
public void setSumm2(java.math.BigDecimal newValue) {
	this.summ2 = newValue;
}
	/**
	 * Get accessor for persistent attribute: RateNDS
	 */
	public java.math.BigDecimal getRateNDS() {
		return RateNDS;
	}
	/**
	 * Set accessor for persistent attribute: RateNDS
	 */
	public void setRateNDS(java.math.BigDecimal newRateNDS) {
		RateNDS = newRateNDS;
	}
	/**
	 * Get accessor for persistent attribute: NalogAgent
	 */
	public boolean getNalogAgent() {
		return NalogAgent;
	}
	/**
	 * Set accessor for persistent attribute: NalogAgent
	 */
	public void setNalogAgent(boolean newNalogAgent) {
		NalogAgent = newNalogAgent;
	}
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setOrgExecutor(com.hps.july.persistence.OrganizationNfs anOrgExecutor) throws java.rmi.RemoteException {
		this.getOrgExecutorLink().set(anOrgExecutor);
	}
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondarySetOrgExecutor(com.hps.july.persistence.OrganizationNfs anOrgExecutor) throws java.rmi.RemoteException {
		this.getOrgExecutorLink().secondarySet(anOrgExecutor);
	}
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOrgExecutorLink() {
		if (orgExecutorLink == null)
			orgExecutorLink = new LeaseContractToOrgExecutorLink(this);
		return orgExecutorLink;
	}
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.OrganizationNfsKey getOrgExecutorKey() {
		com.hps.july.persistence.OrganizationNfsKey temp = new com.hps.july.persistence.OrganizationNfsKey();
		boolean orgExecutor_NULLTEST = true;
		orgExecutor_NULLTEST &= (orgExecutor_organization == null);
		temp.organization = (orgExecutor_organization == null) ? 0 : orgExecutor_organization.intValue();
		if (orgExecutor_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetOrgExecutorKey(com.hps.july.persistence.OrganizationNfsKey inKey) {
		boolean orgExecutor_NULLTEST = (inKey == null);
		orgExecutor_organization = (orgExecutor_NULLTEST) ? null : new Integer(inKey.organization);
	}
	/**
	 * This method was generated for supporting the relationship role named orgExecutor.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.OrganizationNfs getOrgExecutor() throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.OrganizationNfs) this.getOrgExecutorLink().value();
	}
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void setOrgCustomer(com.hps.july.persistence.OrganizationNfs anOrgCustomer) throws java.rmi.RemoteException {
		this.getOrgCustomerLink().set(anOrgCustomer);
	}
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void secondarySetOrgCustomer(com.hps.july.persistence.OrganizationNfs anOrgCustomer) throws java.rmi.RemoteException {
		this.getOrgCustomerLink().secondarySet(anOrgCustomer);
	}
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOrgCustomerLink() {
		if (orgCustomerLink == null)
			orgCustomerLink = new LeaseContractToOrgCustomerLink(this);
		return orgCustomerLink;
	}
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.OrganizationNfsKey getOrgCustomerKey() {
		com.hps.july.persistence.OrganizationNfsKey temp = new com.hps.july.persistence.OrganizationNfsKey();
		boolean orgCustomer_NULLTEST = true;
		orgCustomer_NULLTEST &= (orgCustomer_organization == null);
		temp.organization = (orgCustomer_organization == null) ? 0 : orgCustomer_organization.intValue();
		if (orgCustomer_NULLTEST)
			temp = null;
		return temp;
	}
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public void privateSetOrgCustomerKey(com.hps.july.persistence.OrganizationNfsKey inKey) {
		boolean orgCustomer_NULLTEST = (inKey == null);
		orgCustomer_organization = (orgCustomer_NULLTEST) ? null : new Integer(inKey.organization);
	}
	/**
	 * This method was generated for supporting the relationship role named orgCustomer.
	 * It will be deleted/edited when the relationship is deleted/edited.
	 */
	public com.hps.july.persistence.OrganizationNfs getOrgCustomer() throws java.rmi.RemoteException, javax.ejb.FinderException {
		return (com.hps.july.persistence.OrganizationNfs) this.getOrgCustomerLink().value();
	}
	/**
	 * Get accessor for persistent attribute: isRateLimit
	 */
	public boolean getIsRateLimit() {
		return isRateLimit;
	}
	/**
	 * Set accessor for persistent attribute: isRateLimit
	 */
	public void setIsRateLimit(boolean newIsRateLimit) {
		isRateLimit = newIsRateLimit;
	}
	/**
	 * Get accessor for persistent attribute: rateLimitMin
	 */
	public java.math.BigDecimal getRateLimitMin() {
		return rateLimitMin;
	}
	/**
	 * Set accessor for persistent attribute: rateLimitMin
	 */
	public void setRateLimitMin(java.math.BigDecimal newRateLimitMin) {
		rateLimitMin = newRateLimitMin;
	}
	/**
	 * Get accessor for persistent attribute: rateLimitMax
	 */
	public java.math.BigDecimal getRateLimitMax() {
		return rateLimitMax;
	}
	/**
	 * Set accessor for persistent attribute: rateLimitMax
	 */
	public void setRateLimitMax(java.math.BigDecimal newRateLimitMax) {
		rateLimitMax = newRateLimitMax;
	}
	/**
	 * Get accessor for persistent attribute: buchdocnumber
	 */
	public java.lang.String getBuchdocnumber() {
		return buchdocnumber;
	}
	/**
	 * Set accessor for persistent attribute: buchdocnumber
	 */
	public void setBuchdocnumber(java.lang.String newBuchdocnumber) {
		buchdocnumber = newBuchdocnumber;
	}
	/**
	 * Get accessor for persistent attribute: havedocsigned
	 */
	public java.lang.Boolean getHavedocsigned() {
		return havedocsigned;
	}
	/**
	 * Set accessor for persistent attribute: havedocsigned
	 */
	public void setHavedocsigned(java.lang.Boolean newHavedocsigned) {
		havedocsigned = newHavedocsigned;
	}
	/**
	 * Get accessor for persistent attribute: havedocsignedcustomer
	 */
	public java.lang.Boolean getHavedocsignedcustomer() {
		return havedocsignedcustomer;
	}
	/**
	 * Set accessor for persistent attribute: havedocsignedcustomer
	 */
	public void setHavedocsignedcustomer(
		java.lang.Boolean newHavedocsignedcustomer) {
		havedocsignedcustomer = newHavedocsignedcustomer;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

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
