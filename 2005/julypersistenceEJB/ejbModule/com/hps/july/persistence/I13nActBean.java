package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Акт инвентаризации
 */
public class I13nActBean extends DocumentBean {
	private final static long serialVersionUID = 3206093459760846163L;
	public String type;
	public java.lang.Integer agregate_storagecard;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink agregateLink = null;
	public java.lang.Integer techStuff_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink techStuffLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink i13nActResourceSetLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink i13nDateSavingLink = null;
	public String agregateserial;
	public Boolean recalcagrprice;
	public Integer agregateresource;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("techStuffKey", getTechStuffKey());
		h.put("recalcagrprice", getRecalcagrprice());
		h.put("agregateKey", getAgregateKey());
		h.put("agregateserial", getAgregateserial());
		h.put("type", getType());
		h.put("agregateresource", getAgregateresource());
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
		java.lang.Boolean localRecalcagrprice =
			(java.lang.Boolean) h.get("recalcagrprice");
		java.lang.String localAgregateserial =
			(java.lang.String) h.get("agregateserial");
		java.lang.String localType = (java.lang.String) h.get("type");
		java.lang.Integer localAgregateresource =
			(java.lang.Integer) h.get("agregateresource");
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

		if (h.containsKey("recalcagrprice"))
			setRecalcagrprice((localRecalcagrprice));
		if (h.containsKey("agregateserial"))
			setAgregateserial((localAgregateserial));
		if (h.containsKey("type"))
			setType((localType));
		if (h.containsKey("agregateresource"))
			setAgregateresource((localAgregateresource));
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
	links.addElement(getI13nActResourceSetLink());
	links.addElement(getI13nDateSavingLink());
	links.addElement(getTechStuffLink());
	links.addElement(getAgregateLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	i13nActResourceSetLink = null;
	i13nDateSavingLink = null;
	techStuffLink = null;
	agregateLink = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Integer argStorageManager, String argType ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, argBlankindex, argBlankNumber, 
		argState, Boolean.FALSE, Boolean.FALSE);
	
	_initLinks();
	// All CMP fields should be initialized here.
	type = null;
	agregate_storagecard = null;
	techStuff_worker = null;
	storageManager_worker = null;

	storageManager_worker = argStorageManager;
	type = argType;
	agregateserial = null;
	recalcagrprice = null;
	agregateresource = null;
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getAgregate() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StorageCard)this.getAgregateLink().value();
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getAgregateKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean agregate_NULLTEST = true;
	agregate_NULLTEST &= (agregate_storagecard == null);
	temp.storagecard = ((agregate_storagecard == null) ? 0 : agregate_storagecard.intValue());
	if (agregate_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getAgregateLink() {
	if (agregateLink == null)
		agregateLink = new I13nActToAgregateLink(this);
	return agregateLink;
}
/**
 * Getter method for agregateresource
 */
public java.lang.Integer getAgregateresource() {
	return agregateresource;
}
/**
 * Getter method for agregateserial
 */
public java.lang.String getAgregateserial() {
	return agregateserial;
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nActResourceSet() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getI13nActResourceSetLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getI13nActResourceSetLink() {
	if (i13nActResourceSetLink == null)
		i13nActResourceSetLink = new I13nActToI13nActResourceSetLink(this);
	return i13nActResourceSetLink;
}
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nDateSaving() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getI13nDateSavingLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getI13nDateSavingLink() {
	if (i13nDateSavingLink == null)
		i13nDateSavingLink = new I13nActToI13nDateSavingLink(this);
	return i13nDateSavingLink;
}
/**
 * Getter method for recalcagrprice
 */
public java.lang.Boolean getRecalcagrprice() {
	return recalcagrprice;
}
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getTechStuff() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getTechStuffLink().value();
}
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getTechStuffKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean techStuff_NULLTEST = true;
	techStuff_NULLTEST &= (techStuff_worker == null);
	temp.worker = ((techStuff_worker == null) ? 0 : techStuff_worker.intValue());
	if (techStuff_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getTechStuffLink() {
	if (techStuffLink == null)
		techStuffLink = new I13nActToTechStuffLink(this);
	return techStuffLink;
}
/**
 * Getter method for type
 * @return java.lang.String
 */
public java.lang.String getType() {
	return type;
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAgregateKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean agregate_NULLTEST = (inKey == null);
	if (agregate_NULLTEST) agregate_storagecard = null; else agregate_storagecard = (new Integer(inKey.storagecard));
}
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetTechStuffKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean techStuff_NULLTEST = (inKey == null);
	if (techStuff_NULLTEST) techStuff_worker = null; else techStuff_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) {
	this.getI13nActResourceSetLink().secondaryAddElement(anI13nActResourceSet);
}
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) {
	this.getI13nDateSavingLink().secondaryAddElement(anI13nDateSaving);
}
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nActResourceSet(com.hps.july.persistence.I13nActResourceSet anI13nActResourceSet) {
	this.getI13nActResourceSetLink().secondaryRemoveElement(anI13nActResourceSet);
}
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) {
	this.getI13nDateSavingLink().secondaryRemoveElement(anI13nDateSaving);
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAgregate(com.hps.july.persistence.StorageCard anAgregate) throws java.rmi.RemoteException {
	this.getAgregateLink().secondarySet(anAgregate);
}
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetTechStuff(com.hps.july.persistence.Worker aTechStuff) throws java.rmi.RemoteException {
	this.getTechStuffLink().secondarySet(aTechStuff);
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAgregate(com.hps.july.persistence.StorageCard anAgregate) throws java.rmi.RemoteException {
	this.getAgregateLink().set(anAgregate);
}
/**
 * Setter method for agregateresource
 */
public void setAgregateresource(java.lang.Integer newValue) {
	this.agregateresource = newValue;
}
/**
 * Setter method for agregateserial
 */
public void setAgregateserial(java.lang.String newValue) {
	this.agregateserial = newValue;
}
/**
 * Setter method for recalcagrprice
 */
public void setRecalcagrprice(java.lang.Boolean newValue) {
	this.recalcagrprice = newValue;
}
/**
 * This method was generated for supporting the association named I13nAct2Techstuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setTechStuff(com.hps.july.persistence.Worker aTechStuff) throws java.rmi.RemoteException {
	this.getTechStuffLink().set(aTechStuff);
}
/**
 * Setter method for type
 * @param newValue java.lang.String
 */
public void setType(java.lang.String newValue) {
	this.type = newValue;
}
}
