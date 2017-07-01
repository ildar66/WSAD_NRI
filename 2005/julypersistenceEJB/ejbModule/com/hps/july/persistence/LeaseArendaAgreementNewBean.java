package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Доп. соглашение аренды позиции
 */
public class LeaseArendaAgreementNewBean extends LeaseContractBean {
	public String calcElectroType;
	public Boolean isActive;
	public Boolean isDogElectro;
	public Integer mainDocument;
	public Integer numberOfPhones;
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseonpositionsLink = null;
	public String dogelectonum;
	public java.sql.Date dogelectrodate;
	public Integer numberofphonestemp;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink mainpositionLink = null;
	public java.lang.Integer mainposition_storageplace;
	public boolean officialdoc;
	public Integer activecontract;
	public Integer mainresource;
	public java.math.BigDecimal sumtrafic;
	public java.math.BigDecimal sumaccept;
	public java.math.BigDecimal sumpay;
	public boolean needofficialdoc;
	public java.sql.Date basestartdate;
	public java.sql.Date baseenddate;
	public Integer customerold;
	/**
	 * Implementation field for persistent attribute: haveioact
	 */
	public boolean haveioact;
	/**
	 * Implementation field for persistent attribute: ioactnumber
	 */
	public java.lang.String ioactnumber;
	/**
	 * Implementation field for persistent attribute: ioactdate
	 */
	public java.sql.Date ioactdate;
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getLeaseonpositionsLink());
	links.addElement(getMainpositionLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	leaseonpositionsLink = null;
	mainpositionLink = null;
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
	String argReportPeriod, Boolean argIsActive, String argHowGivePhones, String argCalcElectroType, 
	Boolean argIsDogElectro, String agrCustname, String argExecname,
	Integer argMainDocument ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	
	super.ejbCreate(argLeaseDocument, argDocDate, argDocNumber,
	argContractType, argContractState, argOrgCustomer, argOrgExecutor, 
	argStartDate, argEndDate, argExtendType, 
	argReportPeriod, agrCustname, argExecname );
	_initLinks();
	// All CMP fields should be initialized here.
	mainDocument = argMainDocument;
	numberOfPhones = null;
	numberofphonestemp = null;

	isActive = argIsActive;
	//howGivePhones = argHowGivePhones;
	calcElectroType = argCalcElectroType;
	isDogElectro = argIsDogElectro;
	dogelectonum = null;
	dogelectrodate = null;
	mainposition_storageplace = null;
	officialdoc = false;
	activecontract = null;
	mainresource = null;
	sumtrafic = null;
	sumaccept = null;
	sumpay = null;
	needofficialdoc = false;
	basestartdate = null;
	baseenddate = null;
	customerold = null;
	
	haveioact = false;
	ioactnumber = null;
	ioactdate = null;
}
/**
 * Getter method for activecontract
 */
public java.lang.Integer getActivecontract() {
	return activecontract;
}
/**
 * Getter method for baseenddate
 */
public java.sql.Date getBaseenddate() {
	return baseenddate;
}
/**
 * Getter method for basestartdate
 */
public java.sql.Date getBasestartdate() {
	return basestartdate;
}
/**
 * Getter method for calcElectroType
 * @return java.lang.String
 */
public java.lang.String getCalcElectroType() {
	return calcElectroType;
}
/**
 * Getter method for customerold
 */
public java.lang.Integer getCustomerold() {
	return customerold;
}
/**
 * Getter method for dogelectonum
 */
public java.lang.String getDogelectonum() {
	return dogelectonum;
}
/**
 * Getter method for dogelectrodate
 */
public java.sql.Date getDogelectrodate() {
	return dogelectrodate;
}
/**
 * Getter method for isActive
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsActive() {
	return isActive;
}
/**
 * Getter method for isDogElectro
 * @return java.lang.Boolean
 */
public java.lang.Boolean getIsDogElectro() {
	return isDogElectro;
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseonpositions() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseonpositionsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseonpositionsLink() {
	if (leaseonpositionsLink == null)
		leaseonpositionsLink = new LeaseArendaAgreementNewToLeaseonpositionsLink(this);
	return leaseonpositionsLink;
}
/**
 * Getter method for mainDocument
 * @return java.lang.Integer
 */
public java.lang.Integer getMainDocument() {
	return mainDocument;
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Position getMainposition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Position)this.getMainpositionLink().value();
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getMainpositionKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean mainposition_NULLTEST = true;
	mainposition_NULLTEST &= (mainposition_storageplace == null);
	temp.storageplace = ((mainposition_storageplace == null) ? 0 : mainposition_storageplace.intValue());
	if (mainposition_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getMainpositionLink() {
	if (mainpositionLink == null)
		mainpositionLink = new LeaseArendaAgreementNewToMainpositionLink(this);
	return mainpositionLink;
}
/**
 * Getter method for mainresource
 */
public java.lang.Integer getMainresource() {
	return mainresource;
}
/**
 * Getter method for needofficialdoc
 */
public boolean getNeedofficialdoc() {
	return needofficialdoc;
}
/**
 * Getter method for numberOfPhones
 * @return java.lang.Integer
 */
public java.lang.Integer getNumberOfPhones() {
	return numberOfPhones;
}
/**
 * Getter method for numberofphonestemp
 */
public java.lang.Integer getNumberofphonestemp() {
	return numberofphonestemp;
}
/**
 * Getter method for officialdoc
 */
public boolean getOfficialdoc() {
	return officialdoc;
}
/**
 * Getter method for sumaccept
 */
public java.math.BigDecimal getSumaccept() {
	return sumaccept;
}
/**
 * Getter method for sumpay
 */
public java.math.BigDecimal getSumpay() {
	return sumpay;
}
/**
 * Getter method for sumtrafic
 */
public java.math.BigDecimal getSumtrafic() {
	return sumtrafic;
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetMainpositionKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean mainposition_NULLTEST = (inKey == null);
	if (mainposition_NULLTEST) mainposition_storageplace = null; else mainposition_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseonpositions(com.hps.july.persistence.LeaseOnPosition aLeaseonpositions) {
	this.getLeaseonpositionsLink().secondaryAddElement(aLeaseonpositions);
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2LeaseOnPositions.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseonpositions(com.hps.july.persistence.LeaseOnPosition aLeaseonpositions) {
	this.getLeaseonpositionsLink().secondaryRemoveElement(aLeaseonpositions);
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetMainposition(com.hps.july.persistence.Position aMainposition) throws java.rmi.RemoteException {
	this.getMainpositionLink().secondarySet(aMainposition);
}
/**
 * Setter method for activecontract
 */
public void setActivecontract(java.lang.Integer newValue) {
	this.activecontract = newValue;
}
/**
 * Setter method for baseenddate
 */
public void setBaseenddate(java.sql.Date newValue) {
	this.baseenddate = newValue;
}
/**
 * Setter method for basestartdate
 */
public void setBasestartdate(java.sql.Date newValue) {
	this.basestartdate = newValue;
}
/**
 * Setter method for calcElectroType
 * @param newValue java.lang.String
 */
public void setCalcElectroType(java.lang.String newValue) {
	this.calcElectroType = newValue;
}
/**
 * Setter method for customerold
 */
public void setCustomerold(java.lang.Integer newValue) {
	this.customerold = newValue;
}
/**
 * Setter method for dogelectonum
 */
public void setDogelectonum(java.lang.String newValue) {
	this.dogelectonum = newValue;
}
/**
 * Setter method for dogelectrodate
 */
public void setDogelectrodate(java.sql.Date newValue) {
	this.dogelectrodate = newValue;
}
/**
 * Setter method for isActive
 * @param newValue java.lang.Boolean
 */
public void setIsActive(java.lang.Boolean newValue) {
	this.isActive = newValue;
}
/**
 * Setter method for isDogElectro
 * @param newValue java.lang.Boolean
 */
public void setIsDogElectro(java.lang.Boolean newValue) {
	this.isDogElectro = newValue;
}
/**
 * Setter method for mainDocument
 * @param newValue java.lang.Integer
 */
public void setMainDocument(java.lang.Integer newValue) {
	this.mainDocument = newValue;
}
/**
 * This method was generated for supporting the association named LeaseArendaAgreementNew2mainpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setMainposition(com.hps.july.persistence.Position aMainposition) throws java.rmi.RemoteException {
	this.getMainpositionLink().set(aMainposition);
}
/**
 * Setter method for mainresource
 */
public void setMainresource(java.lang.Integer newValue) {
	this.mainresource = newValue;
}
/**
 * Setter method for needofficialdoc
 */
public void setNeedofficialdoc(boolean newValue) {
	this.needofficialdoc = newValue;
}
/**
 * Setter method for numberOfPhones
 * @param newValue java.lang.Integer
 */
public void setNumberOfPhones(java.lang.Integer newValue) {
	this.numberOfPhones = newValue;
}
/**
 * Setter method for numberofphonestemp
 */
public void setNumberofphonestemp(java.lang.Integer newValue) {
	this.numberofphonestemp = newValue;
}
/**
 * Setter method for officialdoc
 */
public void setOfficialdoc(boolean newValue) {
	this.officialdoc = newValue;
}
/**
 * Setter method for sumaccept
 */
public void setSumaccept(java.math.BigDecimal newValue) {
	this.sumaccept = newValue;
}
/**
 * Setter method for sumpay
 */
public void setSumpay(java.math.BigDecimal newValue) {
	this.sumpay = newValue;
}
/**
 * Setter method for sumtrafic
 */
public void setSumtrafic(java.math.BigDecimal newValue) {
	this.sumtrafic = newValue;
}
	/**
	 * Get accessor for persistent attribute: haveioact
	 */
	public boolean getHaveioact() {
		return haveioact;
	}
	/**
	 * Set accessor for persistent attribute: haveioact
	 */
	public void setHaveioact(boolean newHaveioact) {
		haveioact = newHaveioact;
	}
	/**
	 * Get accessor for persistent attribute: ioactnumber
	 */
	public java.lang.String getIoactnumber() {
		return ioactnumber;
	}
	/**
	 * Set accessor for persistent attribute: ioactnumber
	 */
	public void setIoactnumber(java.lang.String newIoactnumber) {
		ioactnumber = newIoactnumber;
	}
	/**
	 * Get accessor for persistent attribute: ioactdate
	 */
	public java.sql.Date getIoactdate() {
		return ioactdate;
	}
	/**
	 * Set accessor for persistent attribute: ioactdate
	 */
	public void setIoactdate(java.sql.Date newIoactdate) {
		ioactdate = newIoactdate;
	}
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("numberofphonestemp", getNumberofphonestemp());
		h.put("dogelectrodate", getDogelectrodate());
		h.put("ioactdate", getIoactdate());
		h.put("ioactnumber", getIoactnumber());
		h.put("numberOfPhones", getNumberOfPhones());
		h.put("sumtrafic", getSumtrafic());
		h.put("mainresource", getMainresource());
		h.put("calcElectroType", getCalcElectroType());
		h.put("sumaccept", getSumaccept());
		h.put("basestartdate", getBasestartdate());
		h.put("mainDocument", getMainDocument());
		h.put("needofficialdoc", new Boolean(getNeedofficialdoc()));
		h.put("isDogElectro", getIsDogElectro());
		h.put("dogelectonum", getDogelectonum());
		h.put("customerold", getCustomerold());
		h.put("mainpositionKey", getMainpositionKey());
		h.put("isActive", getIsActive());
		h.put("haveioact", new Boolean(getHaveioact()));
		h.put("activecontract", getActivecontract());
		h.put("officialdoc", new Boolean(getOfficialdoc()));
		h.put("baseenddate", getBaseenddate());
		h.put("sumpay", getSumpay());
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
		java.lang.Integer localNumberofphonestemp =
			(java.lang.Integer) h.get("numberofphonestemp");
		java.sql.Date localDogelectrodate =
			(java.sql.Date) h.get("dogelectrodate");
		java.sql.Date localIoactdate = (java.sql.Date) h.get("ioactdate");
		java.lang.String localIoactnumber =
			(java.lang.String) h.get("ioactnumber");
		java.lang.Integer localNumberOfPhones =
			(java.lang.Integer) h.get("numberOfPhones");
		java.math.BigDecimal localSumtrafic =
			(java.math.BigDecimal) h.get("sumtrafic");
		java.lang.Integer localMainresource =
			(java.lang.Integer) h.get("mainresource");
		java.lang.String localCalcElectroType =
			(java.lang.String) h.get("calcElectroType");
		java.math.BigDecimal localSumaccept =
			(java.math.BigDecimal) h.get("sumaccept");
		java.sql.Date localBasestartdate =
			(java.sql.Date) h.get("basestartdate");
		java.lang.Integer localMainDocument =
			(java.lang.Integer) h.get("mainDocument");
		Boolean localNeedofficialdoc = (Boolean) h.get("needofficialdoc");
		java.lang.Boolean localIsDogElectro =
			(java.lang.Boolean) h.get("isDogElectro");
		java.lang.String localDogelectonum =
			(java.lang.String) h.get("dogelectonum");
		java.lang.Integer localCustomerold =
			(java.lang.Integer) h.get("customerold");
		java.lang.Boolean localIsActive = (java.lang.Boolean) h.get("isActive");
		Boolean localHaveioact = (Boolean) h.get("haveioact");
		java.lang.Integer localActivecontract =
			(java.lang.Integer) h.get("activecontract");
		Boolean localOfficialdoc = (Boolean) h.get("officialdoc");
		java.sql.Date localBaseenddate = (java.sql.Date) h.get("baseenddate");
		java.math.BigDecimal localSumpay =
			(java.math.BigDecimal) h.get("sumpay");
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

		if (h.containsKey("numberofphonestemp"))
			setNumberofphonestemp((localNumberofphonestemp));
		if (h.containsKey("dogelectrodate"))
			setDogelectrodate((localDogelectrodate));
		if (h.containsKey("ioactdate"))
			setIoactdate((localIoactdate));
		if (h.containsKey("ioactnumber"))
			setIoactnumber((localIoactnumber));
		if (h.containsKey("numberOfPhones"))
			setNumberOfPhones((localNumberOfPhones));
		if (h.containsKey("sumtrafic"))
			setSumtrafic((localSumtrafic));
		if (h.containsKey("mainresource"))
			setMainresource((localMainresource));
		if (h.containsKey("calcElectroType"))
			setCalcElectroType((localCalcElectroType));
		if (h.containsKey("sumaccept"))
			setSumaccept((localSumaccept));
		if (h.containsKey("basestartdate"))
			setBasestartdate((localBasestartdate));
		if (h.containsKey("mainDocument"))
			setMainDocument((localMainDocument));
		if (h.containsKey("needofficialdoc"))
			setNeedofficialdoc((localNeedofficialdoc).booleanValue());
		if (h.containsKey("isDogElectro"))
			setIsDogElectro((localIsDogElectro));
		if (h.containsKey("dogelectonum"))
			setDogelectonum((localDogelectonum));
		if (h.containsKey("customerold"))
			setCustomerold((localCustomerold));
		if (h.containsKey("isActive"))
			setIsActive((localIsActive));
		if (h.containsKey("haveioact"))
			setHaveioact((localHaveioact).booleanValue());
		if (h.containsKey("activecontract"))
			setActivecontract((localActivecontract));
		if (h.containsKey("officialdoc"))
			setOfficialdoc((localOfficialdoc).booleanValue());
		if (h.containsKey("baseenddate"))
			setBaseenddate((localBaseenddate));
		if (h.containsKey("sumpay"))
			setSumpay((localSumpay));
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
