package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Требование на передачу оборудования
 */
public class RequestBean extends DocumentBean {
	public String nAvto;
	public String requeststate;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer divisionRequester_division;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink divisionRequesterLink = null;
	public java.lang.Integer checker_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink checkerLink = null;
	public java.lang.Integer sender_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink senderLink = null;
	public java.lang.Integer position_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink positionLink = null;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("divisionRequesterKey", getDivisionRequesterKey());
		h.put("checkerKey", getCheckerKey());
		h.put("requeststate", getRequeststate());
		h.put("senderKey", getSenderKey());
		h.put("NAvto", getNAvto());
		h.put("positionKey", getPositionKey());
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
		java.lang.String localRequeststate =
			(java.lang.String) h.get("requeststate");
		java.lang.String localNAvto = (java.lang.String) h.get("NAvto");
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

		if (h.containsKey("requeststate"))
			setRequeststate((localRequeststate));
		if (h.containsKey("NAvto"))
			setNAvto((localNAvto));
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
	links.addElement(getDivisionRequesterLink());
	links.addElement(getCheckerLink());
	links.addElement(getSenderLink());
	links.addElement(getPositionLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	divisionRequesterLink = null;
	checkerLink = null;
	senderLink = null;
	positionLink = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, 
		Boolean argProcessDestination,
		Integer argDivisionRequester ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination );
	
	_initLinks();
	// All CMP fields should be initialized here.
	checker_worker = null;
	sender_worker = null;
	position_storageplace = null;
	nAvto = null;
	requeststate = "I";

	divisionRequester_division = argDivisionRequester;
}
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getChecker() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getCheckerLink().value();
}
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getCheckerKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean checker_NULLTEST = true;
	checker_NULLTEST &= (checker_worker == null);
	temp.worker = ((checker_worker == null) ? 0 : checker_worker.intValue());
	if (checker_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCheckerLink() {
	if (checkerLink == null)
		checkerLink = new RequestToCheckerLink(this);
	return checkerLink;
}
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Division getDivisionRequester() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Division)this.getDivisionRequesterLink().value();
}
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DivisionKey getDivisionRequesterKey() {
	com.hps.july.persistence.DivisionKey temp = null;
	temp = new com.hps.july.persistence.DivisionKey();
	boolean divisionRequester_NULLTEST = true;
	divisionRequester_NULLTEST &= (divisionRequester_division == null);
	temp.division = ((divisionRequester_division == null) ? 0 : divisionRequester_division.intValue());
	if (divisionRequester_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getDivisionRequesterLink() {
	if (divisionRequesterLink == null)
		divisionRequesterLink = new RequestToDivisionRequesterLink(this);
	return divisionRequesterLink;
}
/**
 * Getter method for nAvto
 * @return java.lang.String
 */
public java.lang.String getNAvto() {
	return nAvto;
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Position)this.getPositionLink().value();
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getPositionKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean position_NULLTEST = true;
	position_NULLTEST &= (position_storageplace == null);
	temp.storageplace = ((position_storageplace == null) ? 0 : position_storageplace.intValue());
	if (position_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getPositionLink() {
	if (positionLink == null)
		positionLink = new RequestToPositionLink(this);
	return positionLink;
}
/**
 * Getter method for requeststate
 * @return java.lang.String
 */
public java.lang.String getRequeststate() {
	return requeststate;
}
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getSender() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getSenderLink().value();
}
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getSenderKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean sender_NULLTEST = true;
	sender_NULLTEST &= (sender_worker == null);
	temp.worker = ((sender_worker == null) ? 0 : sender_worker.intValue());
	if (sender_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getSenderLink() {
	if (senderLink == null)
		senderLink = new RequestToSenderLink(this);
	return senderLink;
}
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCheckerKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean checker_NULLTEST = (inKey == null);
	if (checker_NULLTEST) checker_worker = null; else checker_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDivisionRequesterKey(com.hps.july.persistence.DivisionKey inKey) {
	boolean divisionRequester_NULLTEST = (inKey == null);
	if (divisionRequester_NULLTEST) divisionRequester_division = null; else divisionRequester_division = (new Integer(inKey.division));
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean position_NULLTEST = (inKey == null);
	if (position_NULLTEST) position_storageplace = null; else position_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSenderKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean sender_NULLTEST = (inKey == null);
	if (sender_NULLTEST) sender_worker = null; else sender_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetChecker(com.hps.july.persistence.Worker aChecker) throws java.rmi.RemoteException {
	this.getCheckerLink().secondarySet(aChecker);
}
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetDivisionRequester(com.hps.july.persistence.Division aDivisionRequester) throws java.rmi.RemoteException {
	this.getDivisionRequesterLink().secondarySet(aDivisionRequester);
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException {
	this.getPositionLink().secondarySet(aPosition);
}
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSender(com.hps.july.persistence.Worker aSender) throws java.rmi.RemoteException {
	this.getSenderLink().secondarySet(aSender);
}
/**
 * This method was generated for supporting the association named Request2Checker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setChecker(com.hps.july.persistence.Worker aChecker) throws java.rmi.RemoteException {
	this.getCheckerLink().set(aChecker);
}
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setDivisionRequester(com.hps.july.persistence.Division aDivisionRequester) throws java.rmi.RemoteException {
	this.getDivisionRequesterLink().set(aDivisionRequester);
}
/**
 * Setter method for nAvto
 * @param newValue java.lang.String
 */
public void setNAvto(java.lang.String newValue) {
	this.nAvto = newValue;
}
/**
 * This method was generated for supporting the association named Request2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException {
	this.getPositionLink().set(aPosition);
}
/**
 * Setter method for requeststate
 * @param newValue java.lang.String
 */
public void setRequeststate(java.lang.String newValue) {
	this.requeststate = newValue;
}
/**
 * This method was generated for supporting the association named Request2Sender.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSender(com.hps.july.persistence.Worker aSender) throws java.rmi.RemoteException {
	this.getSenderLink().set(aSender);
}
}
