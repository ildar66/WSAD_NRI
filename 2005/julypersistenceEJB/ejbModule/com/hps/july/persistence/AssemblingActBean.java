package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Шапка документа "Акт монтажа"
 */
public class AssemblingActBean extends DocumentBean {
	public String newConfiguration;
	public String oldConfiguration;
	public String operationType;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer monter_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink monterLink = null;
	public java.lang.Integer agregat_storagecard;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink agregatLink = null;
	public String agregateserial;
	public Boolean unmountblocks;
	public Integer agregateresource;
	/**
	 * Implementation field for persistent attribute: inventserial
	 */
	public java.lang.String inventserial;
	/**
	 * Implementation field for persistent attribute: localserial
	 */
	public java.lang.String localserial;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("unmountblocks", getUnmountblocks());
		h.put("agregateserial", getAgregateserial());
		h.put("operationType", getOperationType());
		h.put("oldConfiguration", getOldConfiguration());
		h.put("agregatKey", getAgregatKey());
		h.put("newConfiguration", getNewConfiguration());
		h.put("agregateresource", getAgregateresource());
		h.put("monterKey", getMonterKey());
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
		h.put("localserial", getLocalserial());
		h.put("inventserial", getInventserial());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.Boolean localUnmountblocks =
			(java.lang.Boolean) h.get("unmountblocks");
		java.lang.String localAgregateserial =
			(java.lang.String) h.get("agregateserial");
		java.lang.String localOperationType =
			(java.lang.String) h.get("operationType");
		java.lang.String localOldConfiguration =
			(java.lang.String) h.get("oldConfiguration");
		java.lang.String localNewConfiguration =
			(java.lang.String) h.get("newConfiguration");
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
		java.lang.String localLocalserial =
			(java.lang.String) h.get("localserial");
		java.lang.String localInventserial =
			(java.lang.String) h.get("inventserial");

		if (h.containsKey("unmountblocks"))
			setUnmountblocks((localUnmountblocks));
		if (h.containsKey("agregateserial"))
			setAgregateserial((localAgregateserial));
		if (h.containsKey("operationType"))
			setOperationType((localOperationType));
		if (h.containsKey("oldConfiguration"))
			setOldConfiguration((localOldConfiguration));
		if (h.containsKey("newConfiguration"))
			setNewConfiguration((localNewConfiguration));
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
		if (h.containsKey("localserial"))
			setLocalserial((localLocalserial));
		if (h.containsKey("inventserial"))
			setInventserial((localInventserial));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getMonterLink());
	links.addElement(getAgregatLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	monterLink = null;
	agregatLink = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, Boolean argProcessDestination,
		Integer argAgregat, String argType ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination );
	_initLinks();
	// All CMP fields should be initialized here.
	oldConfiguration = null;
	newConfiguration = null;
	agregat_storagecard = argAgregat;
	operationType = argType;
	agregateserial = null;
	unmountblocks = null;
	agregateresource = null;
	inventserial = null;
	localserial = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, Boolean argProcessDestination,
		String argAgregatSerial, String argType ) throws javax.ejb.CreateException, java.rmi.RemoteException {
			
	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination );
	_initLinks();
	// All CMP fields should be initialized here.
	oldConfiguration = null;
	newConfiguration = null;
	agregat_storagecard = null;
	operationType = argType;
	agregateserial = argAgregatSerial;
	unmountblocks = null;
	agregateresource = null;
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getAgregat() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StorageCard)this.getAgregatLink().value();
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
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getAgregatKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean agregat_NULLTEST = true;
	agregat_NULLTEST &= (agregat_storagecard == null);
	temp.storagecard = ((agregat_storagecard == null) ? 0 : agregat_storagecard.intValue());
	if (agregat_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getAgregatLink() {
	if (agregatLink == null)
		agregatLink = new AssemblingActToAgregatLink(this);
	return agregatLink;
}
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getMonter() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getMonterLink().value();
}
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
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
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getMonterLink() {
	if (monterLink == null)
		monterLink = new AssemblingActToMonterLink(this);
	return monterLink;
}
/**
 * Getter method for newConfiguration
 * @return java.lang.String
 */
public java.lang.String getNewConfiguration() {
	return newConfiguration;
}
/**
 * Getter method for oldConfiguration
 * @return java.lang.String
 */
public java.lang.String getOldConfiguration() {
	return oldConfiguration;
}
/**
 * Getter method for operationType
 * @return java.lang.String
 */
public java.lang.String getOperationType() {
	return operationType;
}
/**
 * Getter method for unmountblocks
 */
public java.lang.Boolean getUnmountblocks() {
	return unmountblocks;
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAgregatKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean agregat_NULLTEST = (inKey == null);
	if (agregat_NULLTEST) agregat_storagecard = null; else agregat_storagecard = (new Integer(inKey.storagecard));
}
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetMonterKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean monter_NULLTEST = (inKey == null);
	if (monter_NULLTEST) monter_worker = null; else monter_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAgregat(com.hps.july.persistence.StorageCard anAgregat) throws java.rmi.RemoteException {
	this.getAgregatLink().secondarySet(anAgregat);
}
/**
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetMonter(com.hps.july.persistence.Worker aMonter) throws java.rmi.RemoteException {
	this.getMonterLink().secondarySet(aMonter);
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAgregat(com.hps.july.persistence.StorageCard anAgregat) throws java.rmi.RemoteException {
	this.getAgregatLink().set(anAgregat);
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
 * This method was generated for supporting the association named AssemblingAct2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setMonter(com.hps.july.persistence.Worker aMonter) throws java.rmi.RemoteException {
	this.getMonterLink().set(aMonter);
}
/**
 * Setter method for newConfiguration
 * @param newValue java.lang.String
 */
public void setNewConfiguration(java.lang.String newValue) {
	this.newConfiguration = newValue;
}
/**
 * Setter method for oldConfiguration
 * @param newValue java.lang.String
 */
public void setOldConfiguration(java.lang.String newValue) {
	this.oldConfiguration = newValue;
}
/**
 * Setter method for operationType
 * @param newValue java.lang.String
 */
public void setOperationType(java.lang.String newValue) {
	this.operationType = newValue;
}
/**
 * Setter method for unmountblocks
 */
public void setUnmountblocks(java.lang.Boolean newValue) {
	this.unmountblocks = newValue;
}
	/**
	 * Get accessor for persistent attribute: inventserial
	 */
	public java.lang.String getInventserial() {
		return inventserial;
	}
	/**
	 * Set accessor for persistent attribute: inventserial
	 */
	public void setInventserial(java.lang.String newInventserial) {
		inventserial = newInventserial;
	}
	/**
	 * Get accessor for persistent attribute: localserial
	 */
	public java.lang.String getLocalserial() {
		return localserial;
	}
	/**
	 * Set accessor for persistent attribute: localserial
	 */
	public void setLocalserial(java.lang.String newLocalserial) {
		localserial = newLocalserial;
	}
}
