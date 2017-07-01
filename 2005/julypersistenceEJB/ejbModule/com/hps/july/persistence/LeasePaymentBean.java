package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Платеж аренды
 */
public class LeasePaymentBean extends LeaseDocPositionBean {
	public String docNumber;
	public String paymentType;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.math.BigDecimal sumRub;
	public java.lang.Integer leaseRule_leaseRule;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink leaseRuleLink = null;
	public java.math.BigDecimal ndsRub;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseDNOPPayLink = null;
	public java.math.BigDecimal rurremainder;
	public java.math.BigDecimal payrate;
	public String paymentstate;
	public boolean byautorur;
	public String isSchetFakt;
	public String officememonumber;
	public Integer otvworker;
	/**
	 * Implementation field for persistent attribute: flagOplNds
	 */
	public java.lang.Boolean flagOplNds;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("leaseRuleKey", getLeaseRuleKey());
		h.put("byautorur", new Boolean(getByautorur()));
		h.put("docNumber", getDocNumber());
		h.put("sumRub", getSumRub());
		h.put("payrate", getPayrate());
		h.put("otvworker", getOtvworker());
		h.put("flagOplNds", getFlagOplNds());
		h.put("paymentstate", getPaymentstate());
		h.put("isSchetFakt", getIsSchetFakt());
		h.put("officememonumber", getOfficememonumber());
		h.put("paymentType", getPaymentType());
		h.put("rurremainder", getRurremainder());
		h.put("ndsRub", getNdsRub());
		h.put("begindate", getBegindate());
		h.put("currencyKey", getCurrencyKey());
		h.put("willbeinact", getWillbeinact());
		h.put("resourceKey", getResourceKey());
		h.put("created", getCreated());
		h.put("modified", getModified());
		h.put("operator", getOperator());
		h.put("docposvid", getDocposvid());
		h.put("usedinact", getUsedinact());
		h.put("actKey", getActKey());
		h.put("leaseContractKey", getLeaseContractKey());
		h.put("modifiedby", getModifiedby());
		h.put("enddate", getEnddate());
		h.put("createdby", getCreatedby());
		h.put("summ", getSumm());
		h.put("source", getSource());
		h.put("leaseDocPosition", new Integer(getLeaseDocPosition()));
		h.put("date", getDate());
		h.put("sumnds", getSumnds());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		Boolean localByautorur = (Boolean) h.get("byautorur");
		java.lang.String localDocNumber = (java.lang.String) h.get("docNumber");
		java.math.BigDecimal localSumRub = (java.math.BigDecimal) h.get("sumRub");
		java.math.BigDecimal localPayrate = (java.math.BigDecimal) h.get("payrate");
		java.lang.Integer localOtvworker = (java.lang.Integer) h.get("otvworker");
		java.lang.Boolean localFlagOplNds = (java.lang.Boolean) h.get("flagOplNds");
		java.lang.String localPaymentstate = (java.lang.String) h.get("paymentstate");
		java.lang.String localIsSchetFakt = (java.lang.String) h.get("isSchetFakt");
		java.lang.String localOfficememonumber = (java.lang.String) h.get("officememonumber");
		java.lang.String localPaymentType = (java.lang.String) h.get("paymentType");
		java.math.BigDecimal localRurremainder = (java.math.BigDecimal) h.get("rurremainder");
		java.math.BigDecimal localNdsRub = (java.math.BigDecimal) h.get("ndsRub");
		java.sql.Date localBegindate = (java.sql.Date) h.get("begindate");
		java.lang.Integer localWillbeinact = (java.lang.Integer) h.get("willbeinact");
		java.sql.Timestamp localCreated = (java.sql.Timestamp) h.get("created");
		java.sql.Timestamp localModified = (java.sql.Timestamp) h.get("modified");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.lang.String localDocposvid = (java.lang.String) h.get("docposvid");
		java.lang.Integer localUsedinact = (java.lang.Integer) h.get("usedinact");
		java.lang.Integer localModifiedby = (java.lang.Integer) h.get("modifiedby");
		java.sql.Date localEnddate = (java.sql.Date) h.get("enddate");
		java.lang.Integer localCreatedby = (java.lang.Integer) h.get("createdby");
		java.math.BigDecimal localSumm = (java.math.BigDecimal) h.get("summ");
		java.lang.String localSource = (java.lang.String) h.get("source");
		Integer localLeaseDocPosition = (Integer) h.get("leaseDocPosition");
		java.sql.Date localDate = (java.sql.Date) h.get("date");
		java.math.BigDecimal localSumnds = (java.math.BigDecimal) h.get("sumnds");

		if (h.containsKey("byautorur"))
			setByautorur((localByautorur).booleanValue());
		if (h.containsKey("docNumber"))
			setDocNumber((localDocNumber));
		if (h.containsKey("sumRub"))
			setSumRub((localSumRub));
		if (h.containsKey("payrate"))
			setPayrate((localPayrate));
		if (h.containsKey("otvworker"))
			setOtvworker((localOtvworker));
		if (h.containsKey("flagOplNds"))
			setFlagOplNds((localFlagOplNds));
		if (h.containsKey("paymentstate"))
			setPaymentstate((localPaymentstate));
		if (h.containsKey("isSchetFakt"))
			setIsSchetFakt((localIsSchetFakt));
		if (h.containsKey("officememonumber"))
			setOfficememonumber((localOfficememonumber));
		if (h.containsKey("paymentType"))
			setPaymentType((localPaymentType));
		if (h.containsKey("rurremainder"))
			setRurremainder((localRurremainder));
		if (h.containsKey("ndsRub"))
			setNdsRub((localNdsRub));
		if (h.containsKey("begindate"))
			setBegindate((localBegindate));
		if (h.containsKey("willbeinact"))
			setWillbeinact((localWillbeinact));
		if (h.containsKey("created"))
			setCreated((localCreated));
		if (h.containsKey("modified"))
			setModified((localModified));
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("docposvid"))
			setDocposvid((localDocposvid));
		if (h.containsKey("usedinact"))
			setUsedinact((localUsedinact));
		if (h.containsKey("modifiedby"))
			setModifiedby((localModifiedby));
		if (h.containsKey("enddate"))
			setEnddate((localEnddate));
		if (h.containsKey("createdby"))
			setCreatedby((localCreatedby));
		if (h.containsKey("summ"))
			setSumm((localSumm));
		if (h.containsKey("source"))
			setSource((localSource));
		if (h.containsKey("leaseDocPosition"))
			setLeaseDocPosition((localLeaseDocPosition).intValue());
		if (h.containsKey("date"))
			setDate((localDate));
		if (h.containsKey("sumnds"))
			setSumnds((localSumnds));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getLeaseRuleLink());
	links.addElement(getLeaseDNOPPayLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	leaseRuleLink = null;
	leaseDNOPPayLink = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argLeaseDocPosition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argLeaseDocPosition, java.sql.Date argDate, Integer argLeaseContract, 
	String argSource, String argVid, java.sql.Date argSDate, java.sql.Date argEDate,
	Integer argResource, java.math.BigDecimal argSumm, Integer argCurrency,
	java.math.BigDecimal argSumNds,
	String argPaymentType, String argPaymentState) throws javax.ejb.CreateException, java.rmi.RemoteException {

		ejbCreate(argLeaseDocPosition, argDate, argLeaseContract, argSource, argVid, argSDate, argEDate,
			argResource, argSumm, argCurrency, argSumNds,	argPaymentType, argPaymentState, "N");
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argLeaseDocPosition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argLeaseDocPosition, java.sql.Date argDate, Integer argLeaseContract, 
	String argSource, String argVid, java.sql.Date argSDate, java.sql.Date argEDate,
	Integer argResource, java.math.BigDecimal argSumm, Integer argCurrency,
	java.math.BigDecimal argSumNds,
	String argPaymentType, String argPaymentState, String argIsSchetFakt) throws javax.ejb.CreateException, java.rmi.RemoteException {
		
	super.ejbCreate(argLeaseDocPosition, argDate, argLeaseContract, 
		argSource, argVid, argSDate, argEDate,
		argResource, argSumm, argCurrency,
		argSumNds);
	_initLinks();
	// All CMP fields should be initialized here.
	docNumber = null;
	sumRub = null;
	ndsRub = null;
	leaseRule_leaseRule = null;
	paymentType = argPaymentType;
	rurremainder = null;
	payrate = null;
	paymentstate = argPaymentState;
	byautorur = false;
	isSchetFakt = argIsSchetFakt;
	officememonumber = null;
	otvworker = null;
	flagOplNds = Boolean.FALSE;
}
/**
 * Getter method for byautorur
 */
public boolean getByautorur() {
	return byautorur;
}
/**
 * Getter method for docNumber
 * @return java.lang.String
 */
public java.lang.String getDocNumber() {
	return docNumber;
}
/**
 * Getter method for isSchetFakt
 */
public java.lang.String getIsSchetFakt() {
	return isSchetFakt;
}
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseDNOPPay() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseDNOPPayLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseDNOPPayLink() {
	if (leaseDNOPPayLink == null)
		leaseDNOPPayLink = new LeasePaymentToLeaseDNOPPayLink(this);
	return leaseDNOPPayLink;
}
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeasePayRule getLeaseRule() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeasePayRule)this.getLeaseRuleLink().value();
}
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseRuleKey getLeaseRuleKey() {
	com.hps.july.persistence.LeaseRuleKey temp = null;
	temp = new com.hps.july.persistence.LeaseRuleKey();
	boolean leaseRule_NULLTEST = true;
	leaseRule_NULLTEST &= (leaseRule_leaseRule == null);
	temp.leaseRule = ((leaseRule_leaseRule == null) ? 0 : leaseRule_leaseRule.intValue());
	if (leaseRule_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getLeaseRuleLink() {
	if (leaseRuleLink == null)
		leaseRuleLink = new LeasePaymentToLeaseRuleLink(this);
	return leaseRuleLink;
}
/**
 * Getter method for ndsRub
 */
public java.math.BigDecimal getNdsRub() {
	return ndsRub;
}
/**
 * Getter method for officememonumber
 */
public java.lang.String getOfficememonumber() {
	return officememonumber;
}
/**
 * Getter method for otvworker
 */
public java.lang.Integer getOtvworker() {
	return otvworker;
}
/**
 * Getter method for paymentstate
 */
public java.lang.String getPaymentstate() {
	return paymentstate;
}
/**
 * Getter method for paymentType
 * @return java.lang.String
 */
public java.lang.String getPaymentType() {
	return paymentType;
}
/**
 * Getter method for payrate
 */
public java.math.BigDecimal getPayrate() {
	return payrate;
}
/**
 * Getter method for rurremainder
 */
public java.math.BigDecimal getRurremainder() {
	return rurremainder;
}
/**
 * Getter method for sumRub
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSumRub() {
	return sumRub;
}
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeaseRuleKey(com.hps.july.persistence.LeaseRuleKey inKey) {
	boolean leaseRule_NULLTEST = (inKey == null);
	if (leaseRule_NULLTEST) leaseRule_leaseRule = null; else leaseRule_leaseRule = (new Integer(inKey.leaseRule));
}
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseDNOPPay(com.hps.july.persistence.LeaseDNOP aLeaseDNOPPay) {
	this.getLeaseDNOPPayLink().secondaryAddElement(aLeaseDNOPPay);
}
/**
 * This method was generated for supporting the association named LeaseDNOP2LeasePayment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseDNOPPay(com.hps.july.persistence.LeaseDNOP aLeaseDNOPPay) {
	this.getLeaseDNOPPayLink().secondaryRemoveElement(aLeaseDNOPPay);
}
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetLeaseRule(com.hps.july.persistence.LeasePayRule aLeaseRule) throws java.rmi.RemoteException {
	this.getLeaseRuleLink().secondarySet(aLeaseRule);
}
/**
 * Setter method for byautorur
 */
public void setByautorur(boolean newValue) {
	this.byautorur = newValue;
}
/**
 * Setter method for docNumber
 * @param newValue java.lang.String
 */
public void setDocNumber(java.lang.String newValue) {
	this.docNumber = newValue;
}
/**
 * Setter method for isSchetFakt
 */
public void setIsSchetFakt(java.lang.String newValue) {
	this.isSchetFakt = newValue;
}
/**
 * This method was generated for supporting the association named LeasePayment2LeaseRule.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setLeaseRule(com.hps.july.persistence.LeasePayRule aLeaseRule) throws java.rmi.RemoteException {
	this.getLeaseRuleLink().set(aLeaseRule);
}
/**
 * Setter method for ndsRub
 */
public void setNdsRub(java.math.BigDecimal newValue) {
	this.ndsRub = newValue;
}
/**
 * Setter method for officememonumber
 */
public void setOfficememonumber(java.lang.String newValue) {
	this.officememonumber = newValue;
}
/**
 * Setter method for otvworker
 */
public void setOtvworker(java.lang.Integer newValue) {
	this.otvworker = newValue;
}
/**
 * Setter method for paymentstate
 */
public void setPaymentstate(java.lang.String newValue) {
	this.paymentstate = newValue;
}
/**
 * Setter method for paymentType
 * @param newValue java.lang.String
 */
public void setPaymentType(java.lang.String newValue) {
	this.paymentType = newValue;
}
/**
 * Setter method for payrate
 */
public void setPayrate(java.math.BigDecimal newValue) {
	this.payrate = newValue;
}
/**
 * Setter method for rurremainder
 */
public void setRurremainder(java.math.BigDecimal newValue) {
	this.rurremainder = newValue;
}
/**
 * Setter method for sumRub
 * @param newValue java.math.BigDecimal
 */
public void setSumRub(java.math.BigDecimal newValue) {
	this.sumRub = PersistenceUtil.dec(newValue,2);
}
	/**
	 * Get accessor for persistent attribute: flagOplNds
	 */
	public java.lang.Boolean getFlagOplNds() {
		return flagOplNds;
	}
	/**
	 * Set accessor for persistent attribute: flagOplNds
	 */
	public void setFlagOplNds(java.lang.Boolean newFlagOplNds) {
		flagOplNds = newFlagOplNds;
	}
}
