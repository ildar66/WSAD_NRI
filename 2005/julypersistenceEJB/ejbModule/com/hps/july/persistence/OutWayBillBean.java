package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Ўапка документа "¬нешн€€ расходна€ накладна€"
 */
public class OutWayBillBean extends DocumentBean {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer currency_currency;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink currencyLink = null;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("currencyKey", getCurrencyKey());
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
		h.put("projectid", getProjectid());
		h.put("prjstatus", getPrjstatus());
		h.put("visualtype", getVisualtype());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
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
		java.lang.Integer localProjectid =
			(java.lang.Integer) h.get("projectid");
		java.lang.String localPrjstatus = (java.lang.String) h.get("prjstatus");
		java.lang.Integer localVisualtype =
			(java.lang.Integer) h.get("visualtype");

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
		if (h.containsKey("projectid"))
			setProjectid((localProjectid));
		if (h.containsKey("prjstatus"))
			setPrjstatus((localPrjstatus));
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
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	currencyLink = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
	int argBlankindex, String argBlankNumber, String argState, int argCurrency, 
		Boolean argProcessSource, Boolean argProcessDestination ) throws javax.ejb.CreateException, java.rmi.RemoteException {

	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState,  
		argProcessSource, argProcessDestination);
	
	_initLinks();
	currency_currency = new Integer(argCurrency);
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, java.sql.Date argBlankDate, 
	int argBlankindex, String argState, int argCurrency ) throws javax.ejb.CreateException, java.rmi.RemoteException {

	super.ejbCreate(argDocument, argOwner, argBlankDate, argBlankindex, argState);
	
	_initLinks();
	
	// All CMP fields should be initialized here.
	currency_currency = new Integer(argCurrency);
}
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Currency)this.getCurrencyLink().value();
}
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
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
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCurrencyLink() {
	if (currencyLink == null)
		currencyLink = new OutWayBillToCurrencyLink(this);
	return currencyLink;
}
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) {
	boolean currency_NULLTEST = (inKey == null);
	if (currency_NULLTEST) currency_currency = null; else currency_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException {
	this.getCurrencyLink().secondarySet(aCurrency);
}
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException {
	this.getCurrencyLink().set(aCurrency);
}
}
