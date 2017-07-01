package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Ўапка документа "¬нешн€€ приходна€ накладна€"
 */
public class InwayBillBean extends DocumentBean {
	public java.sql.Date cordocdate;
	public String cordocnum;
	public java.sql.Date dActDate;
	public String dActNumber;
	public String dActRepresentative;
	public java.sql.Date gtddate;
	public String gtdnumber;
	private final static long serialVersionUID = 3206093459760846163L;
	public String supplyCondition;
	public java.lang.Integer currency_currency;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink currencyLink = null;
	public java.lang.Integer dActStorManager_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink dActStorManagerLink = null;
	public java.lang.Integer dActTechStuf_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink dActTechStufLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink outerDocPositionLink = null;
	public String representtype;
	public java.lang.Integer representative_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink representativeLink = null;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("DActStorManagerKey", getDActStorManagerKey());
		h.put("gtdnumber", getGtdnumber());
		h.put("currencyKey", getCurrencyKey());
		h.put("supplyCondition", getSupplyCondition());
		h.put("representativeKey", getRepresentativeKey());
		h.put("cordocnum", getCordocnum());
		h.put("DActRepresentative", getDActRepresentative());
		h.put("DActDate", getDActDate());
		h.put("DActNumber", getDActNumber());
		h.put("gtddate", getGtddate());
		h.put("DActTechStufKey", getDActTechStufKey());
		h.put("representtype", getRepresenttype());
		h.put("cordocdate", getCordocdate());
		h.put("blankindex", new Integer(getBlankindex()));
		h.put("parentdocument", getParentdocument());
		h.put("blanknumber", getBlanknumber());
		h.put("operator", getOperator());
		h.put("toKey", getToKey());
		h.put("processDestination", getProcessDestination());
		h.put("fromKey", getFromKey());
		h.put("showtouser", new Boolean(getShowtouser()));
		h.put("contragentKey", getContragentKey());
		h.put("storageManagerKey", getStorageManagerKey());
		h.put("document", new Integer(getDocument()));
		h.put("insuranceact", getInsuranceact());
		h.put("isautodoc", new Boolean(getIsautodoc()));
		h.put("blankdate", getBlankdate());
		h.put("documentState", getDocumentState());
		h.put("ownerKey", getOwnerKey());
		h.put("to2", getTo2());
		h.put("processSource", getProcessSource());
		h.put("insuranseMan", getInsuranseMan());
		h.put("insurancedate", getInsurancedate());
		h.put("needapprove", new Boolean(getNeedapprove()));
		h.put("prjstatus", getPrjstatus());
		h.put("projectid", getProjectid());
		h.put("visualtype", getVisualtype());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localGtdnumber = (java.lang.String) h.get("gtdnumber");
		java.lang.String localSupplyCondition =
			(java.lang.String) h.get("supplyCondition");
		java.lang.String localCordocnum = (java.lang.String) h.get("cordocnum");
		java.lang.String localDActRepresentative =
			(java.lang.String) h.get("DActRepresentative");
		java.sql.Date localDActDate = (java.sql.Date) h.get("DActDate");
		java.lang.String localDActNumber =
			(java.lang.String) h.get("DActNumber");
		java.sql.Date localGtddate = (java.sql.Date) h.get("gtddate");
		java.lang.String localRepresenttype =
			(java.lang.String) h.get("representtype");
		java.sql.Date localCordocdate = (java.sql.Date) h.get("cordocdate");
		Integer localBlankindex = (Integer) h.get("blankindex");
		java.lang.Integer localParentdocument =
			(java.lang.Integer) h.get("parentdocument");
		java.lang.String localBlanknumber =
			(java.lang.String) h.get("blanknumber");
		java.lang.Integer localOperator = (java.lang.Integer) h.get("operator");
		java.lang.Boolean localProcessDestination =
			(java.lang.Boolean) h.get("processDestination");
		Boolean localShowtouser = (Boolean) h.get("showtouser");
		Integer localDocument = (Integer) h.get("document");
		java.lang.String localInsuranceact =
			(java.lang.String) h.get("insuranceact");
		Boolean localIsautodoc = (Boolean) h.get("isautodoc");
		java.sql.Date localBlankdate = (java.sql.Date) h.get("blankdate");
		java.lang.String localDocumentState =
			(java.lang.String) h.get("documentState");
		java.lang.Integer localTo2 = (java.lang.Integer) h.get("to2");
		java.lang.Boolean localProcessSource =
			(java.lang.Boolean) h.get("processSource");
		java.lang.String localInsuranseMan =
			(java.lang.String) h.get("insuranseMan");
		java.sql.Date localInsurancedate =
			(java.sql.Date) h.get("insurancedate");
		Boolean localNeedapprove = (Boolean) h.get("needapprove");
		java.lang.String localPrjstatus = (java.lang.String) h.get("prjstatus");
		java.lang.Integer localProjectid =
			(java.lang.Integer) h.get("projectid");
		java.lang.Integer localVisualtype =
			(java.lang.Integer) h.get("visualtype");

		if (h.containsKey("gtdnumber"))
			setGtdnumber((localGtdnumber));
		if (h.containsKey("supplyCondition"))
			setSupplyCondition((localSupplyCondition));
		if (h.containsKey("cordocnum"))
			setCordocnum((localCordocnum));
		if (h.containsKey("DActRepresentative"))
			setDActRepresentative((localDActRepresentative));
		if (h.containsKey("DActDate"))
			setDActDate((localDActDate));
		if (h.containsKey("DActNumber"))
			setDActNumber((localDActNumber));
		if (h.containsKey("gtddate"))
			setGtddate((localGtddate));
		if (h.containsKey("representtype"))
			setRepresenttype((localRepresenttype));
		if (h.containsKey("cordocdate"))
			setCordocdate((localCordocdate));
		if (h.containsKey("blankindex"))
			setBlankindex((localBlankindex).intValue());
		if (h.containsKey("parentdocument"))
			setParentdocument((localParentdocument));
		if (h.containsKey("blanknumber"))
			setBlanknumber((localBlanknumber));
		if (h.containsKey("operator"))
			setOperator((localOperator));
		if (h.containsKey("processDestination"))
			setProcessDestination((localProcessDestination));
		if (h.containsKey("showtouser"))
			setShowtouser((localShowtouser).booleanValue());
		if (h.containsKey("document"))
			setDocument((localDocument).intValue());
		if (h.containsKey("insuranceact"))
			setInsuranceact((localInsuranceact));
		if (h.containsKey("isautodoc"))
			setIsautodoc((localIsautodoc).booleanValue());
		if (h.containsKey("blankdate"))
			setBlankdate((localBlankdate));
		if (h.containsKey("documentState"))
			setDocumentState((localDocumentState));
		if (h.containsKey("to2"))
			setTo2((localTo2));
		if (h.containsKey("processSource"))
			setProcessSource((localProcessSource));
		if (h.containsKey("insuranseMan"))
			setInsuranseMan((localInsuranseMan));
		if (h.containsKey("insurancedate"))
			setInsurancedate((localInsurancedate));
		if (h.containsKey("needapprove"))
			setNeedapprove((localNeedapprove).booleanValue());
		if (h.containsKey("prjstatus"))
			setPrjstatus((localPrjstatus));
		if (h.containsKey("projectid"))
			setProjectid((localProjectid));
		if (h.containsKey("visualtype"))
			setVisualtype((localVisualtype));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getCurrencyLink());
	links.addElement(getOuterDocPositionLink());
	links.addElement(getDActStorManagerLink());
	links.addElement(getDActTechStufLink());
	links.addElement(getRepresentativeLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	currencyLink = null;
	outerDocPositionLink = null;
	dActStorManagerLink = null;
	dActTechStufLink = null;
	representativeLink = null;
}
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) throws java.rmi.RemoteException {
	this.getOuterDocPositionLink().addElement(anOuterDocPosition);
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, 
		Boolean argProcessDestination, Integer argCurrency ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	_initLinks();
	
	super.ejbCreate( argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination);
	
	// All CMP fields should be initialized here.
	cordocdate = null;
	cordocnum = null;
	dActDate = null;
	dActNumber = null;
	dActRepresentative = null;
	gtddate = null;
	gtdnumber = null;
	supplyCondition = null;
	currency_currency = null;
	dActStorManager_worker = null;
	dActTechStuf_worker = null;

	currency_currency = argCurrency;
	representtype = "R";
	representative_worker = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, 
		Boolean argProcessDestination, Integer argCurrency, String argRepresentativeType ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	_initLinks();
	
	super.ejbCreate( argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination);
	
	// All CMP fields should be initialized here.
	cordocdate = null;
	cordocnum = null;
	dActDate = null;
	dActNumber = null;
	dActRepresentative = null;
	gtddate = null;
	gtdnumber = null;
	supplyCondition = null;
	currency_currency = null;
	dActStorManager_worker = null;
	dActTechStuf_worker = null;

	currency_currency = argCurrency;
	representtype = argRepresentativeType;
	representative_worker = null;
}
/**
 * Getter method for cordocdate
 * @return java.sql.Date
 */
public java.sql.Date getCordocdate() {
	return cordocdate;
}
/**
 * Getter method for cordocnum
 * @return java.lang.String
 */
public java.lang.String getCordocnum() {
	return cordocnum;
}
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Currency)this.getCurrencyLink().value();
}
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getCurrencyKey() {
	com.hps.july.persistence.CurrencyKey temp = null;
	temp = new com.hps.july.persistence.CurrencyKey();
	boolean currency_NULLTEST = true;
	currency_NULLTEST &= (currency_currency == null);
	temp.currency = ((currency_currency == null) ? 0 : currency_currency.intValue());
	if (currency_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCurrencyLink() {
	if (currencyLink == null)
		currencyLink = new InwayBillToCurrencyLink(this);
	return currencyLink;
}
/**
 * Getter method for dActDate
 * @return java.sql.Date
 */
public java.sql.Date getDActDate() {
	return dActDate;
}
/**
 * Getter method for dActNumber
 * @return java.lang.String
 */
public java.lang.String getDActNumber() {
	return dActNumber;
}
/**
 * Getter method for dActRepresentative
 * @return java.lang.String
 */
public java.lang.String getDActRepresentative() {
	return dActRepresentative;
}
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getDActStorManager() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getDActStorManagerLink().value();
}
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getDActStorManagerKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean dActStorManager_NULLTEST = true;
	dActStorManager_NULLTEST &= (dActStorManager_worker == null);
	temp.worker = ((dActStorManager_worker == null) ? 0 : dActStorManager_worker.intValue());
	if (dActStorManager_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getDActStorManagerLink() {
	if (dActStorManagerLink == null)
		dActStorManagerLink = new InwayBillToDActStorManagerLink(this);
	return dActStorManagerLink;
}
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getDActTechStuf() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getDActTechStufLink().value();
}
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getDActTechStufKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean dActTechStuf_NULLTEST = true;
	dActTechStuf_NULLTEST &= (dActTechStuf_worker == null);
	temp.worker = ((dActTechStuf_worker == null) ? 0 : dActTechStuf_worker.intValue());
	if (dActTechStuf_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getDActTechStufLink() {
	if (dActTechStufLink == null)
		dActTechStufLink = new InwayBillToDActTechStufLink(this);
	return dActTechStufLink;
}
/**
 * Getter method for gtddate
 * @return java.sql.Date
 */
public java.sql.Date getGtddate() {
	return gtddate;
}
/**
 * Getter method for gtdnumber
 * @return java.lang.String
 */
public java.lang.String getGtdnumber() {
	return gtdnumber;
}
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOuterDocPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getOuterDocPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getOuterDocPositionLink() {
	if (outerDocPositionLink == null)
		outerDocPositionLink = new InwayBillToOuterDocPositionLink(this);
	return outerDocPositionLink;
}
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getRepresentative() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getRepresentativeLink().value();
}
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getRepresentativeKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean representative_NULLTEST = true;
	representative_NULLTEST &= (representative_worker == null);
	temp.worker = ((representative_worker == null) ? 0 : representative_worker.intValue());
	if (representative_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getRepresentativeLink() {
	if (representativeLink == null)
		representativeLink = new InwayBillToRepresentativeLink(this);
	return representativeLink;
}
/**
 * Getter method for representtype
 */
public java.lang.String getRepresenttype() {
	return representtype;
}
/**
 * Getter method for supplyCondition
 * @return java.lang.String
 */
public java.lang.String getSupplyCondition() {
	return supplyCondition;
}
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) {
	boolean currency_NULLTEST = (inKey == null);
	if (currency_NULLTEST) currency_currency = null; else currency_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDActStorManagerKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean dActStorManager_NULLTEST = (inKey == null);
	if (dActStorManager_NULLTEST) dActStorManager_worker = null; else dActStorManager_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDActTechStufKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean dActTechStuf_NULLTEST = (inKey == null);
	if (dActTechStuf_NULLTEST) dActTechStuf_worker = null; else dActTechStuf_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetRepresentativeKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean representative_NULLTEST = (inKey == null);
	if (representative_NULLTEST) representative_worker = null; else representative_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) {
	this.getOuterDocPositionLink().secondaryAddElement(anOuterDocPosition);
}
/**
 * This method was generated for supporting the association named OuterDocPosition2InWayBill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOuterDocPosition(com.hps.july.persistence.OuterDocPosition anOuterDocPosition) {
	this.getOuterDocPositionLink().secondaryRemoveElement(anOuterDocPosition);
}
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException {
	this.getCurrencyLink().secondarySet(aCurrency);
}
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetDActStorManager(com.hps.july.persistence.Worker aDActStorManager) throws java.rmi.RemoteException {
	this.getDActStorManagerLink().secondarySet(aDActStorManager);
}
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetDActTechStuf(com.hps.july.persistence.Worker aDActTechStuf) throws java.rmi.RemoteException {
	this.getDActTechStufLink().secondarySet(aDActTechStuf);
}
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetRepresentative(com.hps.july.persistence.Worker aRepresentative) throws java.rmi.RemoteException {
	this.getRepresentativeLink().secondarySet(aRepresentative);
}
/**
 * Setter method for cordocdate
 * @param newValue java.sql.Date
 */
public void setCordocdate(java.sql.Date newValue) {
	this.cordocdate = newValue;
}
/**
 * Setter method for cordocnum
 * @param newValue java.lang.String
 */
public void setCordocnum(java.lang.String newValue) {
	this.cordocnum = newValue;
}
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException {
	this.getCurrencyLink().set(aCurrency);
}
/**
 * Setter method for dActDate
 * @param newValue java.sql.Date
 */
public void setDActDate(java.sql.Date newValue) {
	this.dActDate = newValue;
}
/**
 * Setter method for dActNumber
 * @param newValue java.lang.String
 */
public void setDActNumber(java.lang.String newValue) {
	this.dActNumber = newValue;
}
/**
 * Setter method for dActRepresentative
 * @param newValue java.lang.String
 */
public void setDActRepresentative(java.lang.String newValue) {
	this.dActRepresentative = newValue;
}
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setDActStorManager(com.hps.july.persistence.Worker aDActStorManager) throws java.rmi.RemoteException {
	this.getDActStorManagerLink().set(aDActStorManager);
}
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setDActTechStuf(com.hps.july.persistence.Worker aDActTechStuf) throws java.rmi.RemoteException {
	this.getDActTechStufLink().set(aDActTechStuf);
}
/**
 * Setter method for gtddate
 * @param newValue java.sql.Date
 */
public void setGtddate(java.sql.Date newValue) {
	this.gtddate = newValue;
}
/**
 * Setter method for gtdnumber
 * @param newValue java.lang.String
 */
public void setGtdnumber(java.lang.String newValue) {
	this.gtdnumber = newValue;
}
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setRepresentative(com.hps.july.persistence.Worker aRepresentative) throws java.rmi.RemoteException {
	this.getRepresentativeLink().set(aRepresentative);
}
/**
 * Setter method for representtype
 */
public void setRepresenttype(java.lang.String newValue) {
	this.representtype = newValue;
}
/**
 * Setter method for supplyCondition
 * @param newValue java.lang.String
 */
public void setSupplyCondition(java.lang.String newValue) {
	this.supplyCondition = newValue;
}
}
