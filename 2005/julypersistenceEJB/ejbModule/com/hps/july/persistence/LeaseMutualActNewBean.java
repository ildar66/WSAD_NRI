package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Акт взаимозачета по аренде
 */
public class LeaseMutualActNewBean extends LeaseDocumentBean {
	public String actState;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer leaseMutualReglament_leaseDocument;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink leaseMutualReglamentLink = null;
	public java.sql.Date actstartdate;
	public java.sql.Date actenddate;
	public String header;
	public String footer;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseDocPositionsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseVPaymentsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseCalcRatesLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseDNOPsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseSaldosLink = null;
	public boolean istemp;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leaseSchetFaktsLink = null;
	public Boolean isSchetFakt;
	public String actfilename;
	/**
	 * Implementation field for persistent attribute: mutualNDS
	 */
	public java.lang.Boolean mutualNDS;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h = new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("actenddate", getActenddate());
		h.put("istemp", new Boolean(getIstemp()));
		h.put("actstartdate", getActstartdate());
		h.put("header", getHeader());
		h.put("actfilename", getActfilename());
		h.put("leaseMutualReglamentKey", getLeaseMutualReglamentKey());
		h.put("isSchetFakt", getIsSchetFakt());
		h.put("footer", getFooter());
		h.put("actState", getActState());
		h.put("mutualNDS", getMutualNDS());
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
		java.sql.Date localActenddate = (java.sql.Date) h.get("actenddate");
		Boolean localIstemp = (Boolean) h.get("istemp");
		java.sql.Date localActstartdate = (java.sql.Date) h.get("actstartdate");
		java.lang.String localHeader = (java.lang.String) h.get("header");
		java.lang.Boolean localIsSchetFakt = (java.lang.Boolean) h.get("isSchetFakt");
		java.lang.String localFooter = (java.lang.String) h.get("footer");
		java.lang.String localActState = (java.lang.String) h.get("actState");
		java.lang.Boolean localMutualNDS = (java.lang.Boolean) h.get("mutualNDS");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.sql.Date localDocumentDate = (java.sql.Date) h.get("documentDate");
		Integer localLeaseDocument = (Integer) h.get("leaseDocument");
		java.sql.Timestamp localCreated = (java.sql.Timestamp) h.get("created");
		java.lang.String localDocumentNumber = (java.lang.String) h.get("documentNumber");
		Integer localRegionid = (Integer) h.get("regionid");
		java.sql.Timestamp localModified = (java.sql.Timestamp) h.get("modified");
		java.lang.Integer localCreatedby = (java.lang.Integer) h.get("createdby");
		java.lang.Integer localModifiedby = (java.lang.Integer) h.get("modifiedby");

		if (h.containsKey("actenddate"))
			setActenddate((localActenddate));
		if (h.containsKey("istemp"))
			setIstemp((localIstemp).booleanValue());
		if (h.containsKey("actstartdate"))
			setActstartdate((localActstartdate));
		if (h.containsKey("header"))
			setHeader((localHeader));
		if (h.containsKey("isSchetFakt"))
			setIsSchetFakt((localIsSchetFakt));
		if (h.containsKey("footer"))
			setFooter((localFooter));
		if (h.containsKey("actState"))
			setActState((localActState));
		if (h.containsKey("mutualNDS"))
			setMutualNDS((localMutualNDS));
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
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getLeaseCalcRatesLink());
	links.addElement(getLeaseMutualReglamentLink());
	links.addElement(getLeaseDocPositionsLink());
	links.addElement(getLeaseVPaymentsLink());
	links.addElement(getLeaseSaldosLink());
	links.addElement(getLeaseDNOPsLink());
	links.addElement(getLeaseSchetFaktsLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	leaseCalcRatesLink = null;
	leaseMutualReglamentLink = null;
	leaseDocPositionsLink = null;
	leaseVPaymentsLink = null;
	leaseSaldosLink = null;
	leaseDNOPsLink = null;
	leaseSchetFaktsLink = null;
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException {
	this.getLeaseCalcRatesLink().addElement(aLeaseCalcRates);
}
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException {
	this.getLeaseDNOPsLink().addElement(aLeaseDNOPs);
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
	this.getLeaseDocPositionsLink().addElement(aLeaseDocPositions);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException {
	this.getLeaseSaldosLink().addElement(aLeaseSaldos);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
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
	Integer argLeaseMutualReglament, String argState,
	java.sql.Date actstartdate, java.sql.Date actenddate,
	boolean argIsTemp) throws javax.ejb.CreateException, java.rmi.RemoteException {

		ejbCreate(argLeaseDocument, argDocDate, argDocNumber,	argLeaseMutualReglament, argState,
			actstartdate, actenddate,	argIsTemp, Boolean.FALSE);
		
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argLeaseDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argLeaseDocument, java.sql.Date argDocDate, String argDocNumber,
	Integer argLeaseMutualReglament, String argState,
	java.sql.Date actstartdate, java.sql.Date actenddate,
	boolean argIsTemp, Boolean argIsSchetFakt) throws javax.ejb.CreateException, java.rmi.RemoteException {
		
	super.ejbCreate(argLeaseDocument, argDocDate, argDocNumber );
	_initLinks();
	// All CMP fields should be initialized here.
	leaseMutualReglament_leaseDocument = argLeaseMutualReglament;
	actState = argState;
	this.actstartdate = actstartdate;
	this.actenddate = actenddate;
	header = null;
	footer = null;
	istemp = argIsTemp;
	isSchetFakt = argIsSchetFakt;
	//lastcalctime = null;
	mutualNDS = Boolean.FALSE;
}
/**
 * Getter method for actenddate
 */
public java.sql.Date getActenddate() {
	return actenddate;
}
/**
 * Getter method for actfilename
 */
public java.lang.String getActfilename() {
	return actfilename;
}
/**
 * Getter method for actstartdate
 */
public java.sql.Date getActstartdate() {
	return actstartdate;
}
/**
 * Getter method for actState
 * @return java.lang.String
 */
public java.lang.String getActState() {
	return actState;
}
/**
 * Getter method for footer
 */
public java.lang.String getFooter() {
	return footer;
}
/**
 * Getter method for header
 */
public java.lang.String getHeader() {
	return header;
}
/**
 * Getter method for isSchetFakt
 */
public java.lang.Boolean getIsSchetFakt() {
	return isSchetFakt;
}
/**
 * Getter method for istemp
 */
public boolean getIstemp() {
	return istemp;
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseCalcRates() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseCalcRatesLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseCalcRatesLink() {
	if (leaseCalcRatesLink == null)
		leaseCalcRatesLink = new LeaseMutualActNewToLeaseCalcRatesLink(this);
	return leaseCalcRatesLink;
}
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseDNOPs() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseDNOPsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseDNOPsLink() {
	if (leaseDNOPsLink == null)
		leaseDNOPsLink = new LeaseMutualActNewToLeaseDNOPsLink(this);
	return leaseDNOPsLink;
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseDocPositions() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseDocPositionsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseDocPositionsLink() {
	if (leaseDocPositionsLink == null)
		leaseDocPositionsLink = new LeaseMutualActNewToLeaseDocPositionsLink(this);
	return leaseDocPositionsLink;
}
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseMutualReglament getLeaseMutualReglament() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeaseMutualReglament)this.getLeaseMutualReglamentLink().value();
}
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getLeaseMutualReglamentKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean leaseMutualReglament_NULLTEST = true;
	leaseMutualReglament_NULLTEST &= (leaseMutualReglament_leaseDocument == null);
	temp.leaseDocument = ((leaseMutualReglament_leaseDocument == null) ? 0 : leaseMutualReglament_leaseDocument.intValue());
	if (leaseMutualReglament_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getLeaseMutualReglamentLink() {
	if (leaseMutualReglamentLink == null)
		leaseMutualReglamentLink = new LeaseMutualActNewToLeaseMutualReglamentLink(this);
	return leaseMutualReglamentLink;
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseSaldos() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseSaldosLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseSaldosLink() {
	if (leaseSaldosLink == null)
		leaseSaldosLink = new LeaseMutualActNewToLeaseSaldosLink(this);
	return leaseSaldosLink;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseSchetFaktsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseSchetFaktsLink() {
	if (leaseSchetFaktsLink == null)
		leaseSchetFaktsLink = new LeaseMutualActNewToLeaseSchetFaktsLink(this);
	return leaseSchetFaktsLink;
}
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeaseVPayments() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeaseVPaymentsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeaseVPaymentsLink() {
	if (leaseVPaymentsLink == null)
		leaseVPaymentsLink = new LeaseMutualActNewToLeaseVPaymentsLink(this);
	return leaseVPaymentsLink;
}
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLeaseMutualReglamentKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean leaseMutualReglament_NULLTEST = (inKey == null);
	if (leaseMutualReglament_NULLTEST) leaseMutualReglament_leaseDocument = null; else leaseMutualReglament_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) throws java.rmi.RemoteException {
	this.getLeaseCalcRatesLink().removeElement(aLeaseCalcRates);
}
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) throws java.rmi.RemoteException {
	this.getLeaseDNOPsLink().removeElement(aLeaseDNOPs);
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) throws java.rmi.RemoteException {
	this.getLeaseDocPositionsLink().removeElement(aLeaseDocPositions);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) throws java.rmi.RemoteException {
	this.getLeaseSaldosLink().removeElement(aLeaseSaldos);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) throws java.rmi.RemoteException {
	this.getLeaseSchetFaktsLink().removeElement(aLeaseSchetFakts);
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) {
	this.getLeaseCalcRatesLink().secondaryAddElement(aLeaseCalcRates);
}
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) {
	this.getLeaseDNOPsLink().secondaryAddElement(aLeaseDNOPs);
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) {
	this.getLeaseDocPositionsLink().secondaryAddElement(aLeaseDocPositions);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) {
	this.getLeaseSaldosLink().secondaryAddElement(aLeaseSaldos);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) {
	this.getLeaseSchetFaktsLink().secondaryAddElement(aLeaseSchetFakts);
}
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeaseVPayments(com.hps.july.persistence.LeaseVPayment aLeaseVPayments) {
	this.getLeaseVPaymentsLink().secondaryAddElement(aLeaseVPayments);
}
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseCalcRates(com.hps.july.persistence.LeaseCalcRate aLeaseCalcRates) {
	this.getLeaseCalcRatesLink().secondaryRemoveElement(aLeaseCalcRates);
}
/**
 * This method was generated for supporting the association named LeaseDNOP2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseDNOPs(com.hps.july.persistence.LeaseDNOP aLeaseDNOPs) {
	this.getLeaseDNOPsLink().secondaryRemoveElement(aLeaseDNOPs);
}
/**
 * This method was generated for supporting the association named LeaseDocPosition2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseDocPositions(com.hps.july.persistence.LeaseDocPosition aLeaseDocPositions) {
	this.getLeaseDocPositionsLink().secondaryRemoveElement(aLeaseDocPositions);
}
/**
 * This method was generated for supporting the association named LeaseSaldo2acts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseSaldos(com.hps.july.persistence.LeaseSaldo aLeaseSaldos) {
	this.getLeaseSaldosLink().secondaryRemoveElement(aLeaseSaldos);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseSchetFakts(com.hps.july.persistence.LeaseSchetFakt aLeaseSchetFakts) {
	this.getLeaseSchetFaktsLink().secondaryRemoveElement(aLeaseSchetFakts);
}
/**
 * This method was generated for supporting the association named LeaseVPayment2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeaseVPayments(com.hps.july.persistence.LeaseVPayment aLeaseVPayments) {
	this.getLeaseVPaymentsLink().secondaryRemoveElement(aLeaseVPayments);
}
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetLeaseMutualReglament(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglament) throws java.rmi.RemoteException {
	this.getLeaseMutualReglamentLink().secondarySet(aLeaseMutualReglament);
}
/**
 * Setter method for actenddate
 */
public void setActenddate(java.sql.Date newValue) {
	this.actenddate = newValue;
}
/**
 * Setter method for actstartdate
 */
public void setActstartdate(java.sql.Date newValue) {
	this.actstartdate = newValue;
}
/**
 * Setter method for actState
 * @param newValue java.lang.String
 */
public void setActState(java.lang.String newValue) {
	this.actState = newValue;
}
/**
 * Setter method for footer
 */
public void setFooter(java.lang.String newValue) {
	this.footer = newValue;
}
/**
 * Setter method for header
 */
public void setHeader(java.lang.String newValue) {
	this.header = newValue;
}
/**
 * Setter method for isSchetFakt
 */
public void setIsSchetFakt(java.lang.Boolean newValue) {
	this.isSchetFakt = newValue;
}
/**
 * Setter method for istemp
 */
public void setIstemp(boolean newValue) {
	this.istemp = newValue;
}
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setLeaseMutualReglament(com.hps.july.persistence.LeaseMutualReglament aLeaseMutualReglament) throws java.rmi.RemoteException {
	this.getLeaseMutualReglamentLink().set(aLeaseMutualReglament);
}
	/**
	 * Get accessor for persistent attribute: mutualNDS
	 */
	public java.lang.Boolean getMutualNDS() {
		return mutualNDS;
	}
	/**
	 * Set accessor for persistent attribute: mutualNDS
	 */
	public void setMutualNDS(java.lang.Boolean newMutualNDS) {
		mutualNDS = newMutualNDS;
	}
}
