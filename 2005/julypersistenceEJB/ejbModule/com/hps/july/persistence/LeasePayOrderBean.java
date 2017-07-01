package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Служебная записка аренды
 */
public class LeasePayOrderBean extends LeasePaymentBean {
	public java.sql.Date billDate;
	public String billNumber;
	public String payPurpose;
	public String ppType;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer orgAcc_account;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink orgAccLink = null;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("payPurpose", getPayPurpose());
		h.put("ppType", getPpType());
		h.put("billNumber", getBillNumber());
		h.put("orgAccKey", getOrgAccKey());
		h.put("billDate", getBillDate());
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
		java.lang.String localPayPurpose = (java.lang.String) h.get("payPurpose");
		java.lang.String localPpType = (java.lang.String) h.get("ppType");
		java.lang.String localBillNumber = (java.lang.String) h.get("billNumber");
		java.sql.Date localBillDate = (java.sql.Date) h.get("billDate");
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

		if (h.containsKey("payPurpose"))
			setPayPurpose((localPayPurpose));
		if (h.containsKey("ppType"))
			setPpType((localPpType));
		if (h.containsKey("billNumber"))
			setBillNumber((localBillNumber));
		if (h.containsKey("billDate"))
			setBillDate((localBillDate));
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
	links.addElement(getOrgAccLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	orgAccLink = null;
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
	String argPaymentType, String argPaymentState, Integer argOrgAcc,
	String argPayPurpoise, String argppType ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	
	super.ejbCreate(argLeaseDocPosition, argDate, argLeaseContract, 
		argSource, argVid, argSDate, argEDate,
		argResource, argSumm, argCurrency,
		argSumNds,
		argPaymentType, argPaymentState);
	_initLinks();
	// All CMP fields should be initialized here.
	billDate = null;
	billNumber = null;
	orgAcc_account = argOrgAcc;
	payPurpose = argPayPurpoise;
	ppType = argppType;
}
/**
 * Getter method for billDate
 * @return java.sql.Date
 */
public java.sql.Date getBillDate() {
	return billDate;
}
/**
 * Getter method for billNumber
 * @return java.lang.String
 */
public java.lang.String getBillNumber() {
	return billNumber;
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Account getOrgAcc() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Account)this.getOrgAccLink().value();
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AccountKey getOrgAccKey() {
	com.hps.july.persistence.AccountKey temp = null;
	temp = new com.hps.july.persistence.AccountKey();
	boolean orgAcc_NULLTEST = true;
	orgAcc_NULLTEST &= (orgAcc_account == null);
	temp.account = ((orgAcc_account == null) ? 0 : orgAcc_account.intValue());
	if (orgAcc_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOrgAccLink() {
	if (orgAccLink == null)
		orgAccLink = new LeasePayOrderToOrgAccLink(this);
	return orgAccLink;
}
/**
 * Getter method for payPurpose
 * @return java.lang.String
 */
public java.lang.String getPayPurpose() {
	return payPurpose;
}
/**
 * Getter method for ppType
 * @return java.lang.String
 */
public java.lang.String getPpType() {
	return ppType;
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOrgAccKey(com.hps.july.persistence.AccountKey inKey) {
	boolean orgAcc_NULLTEST = (inKey == null);
	if (orgAcc_NULLTEST) orgAcc_account = null; else orgAcc_account = (new Integer(inKey.account));
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOrgAcc(com.hps.july.persistence.Account anOrgAcc) throws java.rmi.RemoteException {
	this.getOrgAccLink().secondarySet(anOrgAcc);
}
/**
 * Setter method for billDate
 * @param newValue java.sql.Date
 */
public void setBillDate(java.sql.Date newValue) {
	this.billDate = newValue;
}
/**
 * Setter method for billNumber
 * @param newValue java.lang.String
 */
public void setBillNumber(java.lang.String newValue) {
	this.billNumber = newValue;
}
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOrgAcc(com.hps.july.persistence.Account anOrgAcc) throws java.rmi.RemoteException {
	this.getOrgAccLink().set(anOrgAcc);
}
/**
 * Setter method for payPurpose
 * @param newValue java.lang.String
 */
public void setPayPurpose(java.lang.String newValue) {
	this.payPurpose = newValue;
}
/**
 * Setter method for ppType
 * @param newValue java.lang.String
 */
public void setPpType(java.lang.String newValue) {
	this.ppType = newValue;
}
}
