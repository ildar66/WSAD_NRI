package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Ўапка документа "¬нутренн€€ приходна€ накладна€"
 */
public class InternalWayBillBean extends DocumentBean {
	public Boolean fixing;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer position_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink positionLink = null;
	public java.lang.Integer monter_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink monterLink = null;
	/**
	 * Implementation field for persistent attribute: equiptype
	 */
	public java.lang.String equiptype;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("positionKey", getPositionKey());
		h.put("monterKey", getMonterKey());
		h.put("fixing", getFixing());
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
		h.put("equiptype", getEquiptype());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Boolean localFixing = (java.lang.Boolean) h.get("fixing");
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
		java.lang.String localEquiptype = (java.lang.String) h.get("equiptype");

		if (h.containsKey("fixing"))
			setFixing((localFixing));
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
		if (h.containsKey("equiptype"))
			setEquiptype((localEquiptype));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getPositionLink());
	links.addElement(getMonterLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	positionLink = null;
	monterLink = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, Boolean argProcessDestination, Boolean argFixing ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination );
	
	_initLinks();
	// All CMP fields should be initialized here.
	position_storageplace = null;
	fixing = argFixing;
	equiptype = null;
}
/**
 * Getter method for fixing
 * @return java.lang.Boolean
 */
public java.lang.Boolean getFixing() {
	return fixing;
}
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getMonter() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getMonterLink().value();
}
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getMonterKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean monter_NULLTEST = true;
	monter_NULLTEST &= (monter_worker == null);
	temp.worker = ((monter_worker == null) ? 0 : monter_worker.intValue());
	if (monter_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getMonterLink() {
	if (monterLink == null)
		monterLink = new InternalWayBillToMonterLink(this);
	return monterLink;
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Position)this.getPositionLink().value();
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
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
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getPositionLink() {
	if (positionLink == null)
		positionLink = new InternalWayBillToPositionLink(this);
	return positionLink;
}
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetMonterKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean monter_NULLTEST = (inKey == null);
	if (monter_NULLTEST) monter_worker = null; else monter_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean position_NULLTEST = (inKey == null);
	if (position_NULLTEST) position_storageplace = null; else position_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetMonter(com.hps.july.persistence.Worker aMonter) throws java.rmi.RemoteException {
	this.getMonterLink().secondarySet(aMonter);
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException {
	this.getPositionLink().secondarySet(aPosition);
}
/**
 * Setter method for fixing
 * @param newValue java.lang.Boolean
 */
public void setFixing(java.lang.Boolean newValue) {
	this.fixing = newValue;
}
/**
 * This method was generated for supporting the association named InternalWayBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setMonter(com.hps.july.persistence.Worker aMonter) throws java.rmi.RemoteException {
	this.getMonterLink().set(aMonter);
}
/**
 * This method was generated for supporting the association named InternalWayBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException {
	this.getPositionLink().set(aPosition);
}
	/**
	 * Get accessor for persistent attribute: equiptype
	 */
	public java.lang.String getEquiptype() {
		return equiptype;
	}
	/**
	 * Set accessor for persistent attribute: equiptype
	 */
	public void setEquiptype(java.lang.String newEquiptype) {
		equiptype = newEquiptype;
	}
}
