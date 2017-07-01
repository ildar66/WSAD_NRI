package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * —бойный рапорт
 */
public class FaultReportBean extends DocumentBean {
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer division_division;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink divisionLink = null;
	public java.lang.Integer techStuff_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink techStuffLink = null;
	public java.lang.Integer equipment_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink equipmentLink = null;
	public String eqplace;
	public java.lang.Integer oldagregate_storagecard;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink oldagregateLink = null;
	public java.lang.Integer storagecardFrom_storagecard;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink storagecardFromLink = null;
	public String oldserial;
	public String newserial;
	public String comment;
	public String agregateserial;
	public Integer agregateresource;
	public Integer oldresource;
	public Integer newresource;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("comment", getComment());
		h.put("oldagregateKey", getOldagregateKey());
		h.put("storagecardFromKey", getStoragecardFromKey());
		h.put("divisionKey", getDivisionKey());
		h.put("oldserial", getOldserial());
		h.put("equipmentKey", getEquipmentKey());
		h.put("techStuffKey", getTechStuffKey());
		h.put("oldresource", getOldresource());
		h.put("newresource", getNewresource());
		h.put("eqplace", getEqplace());
		h.put("agregateresource", getAgregateresource());
		h.put("newserial", getNewserial());
		h.put("agregateserial", getAgregateserial());
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
		java.lang.String localComment = (java.lang.String) h.get("comment");
		java.lang.String localOldserial = (java.lang.String) h.get("oldserial");
		java.lang.Integer localOldresource =
			(java.lang.Integer) h.get("oldresource");
		java.lang.Integer localNewresource =
			(java.lang.Integer) h.get("newresource");
		java.lang.String localEqplace = (java.lang.String) h.get("eqplace");
		java.lang.Integer localAgregateresource =
			(java.lang.Integer) h.get("agregateresource");
		java.lang.String localNewserial = (java.lang.String) h.get("newserial");
		java.lang.String localAgregateserial =
			(java.lang.String) h.get("agregateserial");
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

		if (h.containsKey("comment"))
			setComment((localComment));
		if (h.containsKey("oldserial"))
			setOldserial((localOldserial));
		if (h.containsKey("oldresource"))
			setOldresource((localOldresource));
		if (h.containsKey("newresource"))
			setNewresource((localNewresource));
		if (h.containsKey("eqplace"))
			setEqplace((localEqplace));
		if (h.containsKey("agregateresource"))
			setAgregateresource((localAgregateresource));
		if (h.containsKey("newserial"))
			setNewserial((localNewserial));
		if (h.containsKey("agregateserial"))
			setAgregateserial((localAgregateserial));
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
	links.addElement(getEquipmentLink());
	links.addElement(getDivisionLink());
	links.addElement(getTechStuffLink());
	links.addElement(getOldagregateLink());
	links.addElement(getStoragecardFromLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	equipmentLink = null;
	divisionLink = null;
	techStuffLink = null;
	oldagregateLink = null;
	storagecardFromLink = null;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
		int argBlankindex, String argBlankNumber, String argState, Boolean argProcessSource, Boolean argProcessDestination,
		Integer argDivision, Integer argTechStuff, String argEqPlace, String argOldSerial ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	super.ejbCreate(argDocument, argOwner, argFrom, argTo, argBlankDate, 
		argBlankindex, argBlankNumber, argState, argProcessSource, argProcessDestination );
	_initLinks();
	// All CMP fields should be initialized here.
	equipment_storageplace = null;

	division_division = argDivision;
	techStuff_worker = argTechStuff;
	eqplace = argEqPlace;
	oldserial = argOldSerial;
	oldagregate_storagecard = null;
	newserial = null;
	comment = null;
	storagecardFrom_storagecard = null;
	agregateserial = null;
	agregateresource = null;
	oldresource = null;
	newresource = null;
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
 * Getter method for comment
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Division getDivision() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Division)this.getDivisionLink().value();
}
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DivisionKey getDivisionKey() {
	com.hps.july.persistence.DivisionKey temp = null;
	temp = new com.hps.july.persistence.DivisionKey();
	boolean division_NULLTEST = true;
	division_NULLTEST &= (division_division == null);
	temp.division = ((division_division == null) ? 0 : division_division.intValue());
	if (division_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getDivisionLink() {
	if (divisionLink == null)
		divisionLink = new FaultReportToDivisionLink(this);
	return divisionLink;
}
/**
 * Getter method for eqplace
 */
public java.lang.String getEqplace() {
	return eqplace;
}
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.EquipmentSet getEquipment() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.EquipmentSet)this.getEquipmentLink().value();
}
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getEquipmentKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean equipment_NULLTEST = true;
	equipment_NULLTEST &= (equipment_storageplace == null);
	temp.storageplace = ((equipment_storageplace == null) ? 0 : equipment_storageplace.intValue());
	if (equipment_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getEquipmentLink() {
	if (equipmentLink == null)
		equipmentLink = new FaultReportToEquipmentLink(this);
	return equipmentLink;
}
/**
 * Getter method for newresource
 */
public java.lang.Integer getNewresource() {
	return newresource;
}
/**
 * Getter method for newserial
 */
public java.lang.String getNewserial() {
	return newserial;
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getOldagregate() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StorageCard)this.getOldagregateLink().value();
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getOldagregateKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean oldagregate_NULLTEST = true;
	oldagregate_NULLTEST &= (oldagregate_storagecard == null);
	temp.storagecard = ((oldagregate_storagecard == null) ? 0 : oldagregate_storagecard.intValue());
	if (oldagregate_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOldagregateLink() {
	if (oldagregateLink == null)
		oldagregateLink = new FaultReportToOldagregateLink(this);
	return oldagregateLink;
}
/**
 * Getter method for oldresource
 */
public java.lang.Integer getOldresource() {
	return oldresource;
}
/**
 * Getter method for oldserial
 */
public java.lang.String getOldserial() {
	return oldserial;
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getStoragecardFrom() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StorageCard)this.getStoragecardFromLink().value();
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getStoragecardFromKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean storagecardFrom_NULLTEST = true;
	storagecardFrom_NULLTEST &= (storagecardFrom_storagecard == null);
	temp.storagecard = ((storagecardFrom_storagecard == null) ? 0 : storagecardFrom_storagecard.intValue());
	if (storagecardFrom_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getStoragecardFromLink() {
	if (storagecardFromLink == null)
		storagecardFromLink = new FaultReportToStoragecardFromLink(this);
	return storagecardFromLink;
}
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getTechStuff() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getTechStuffLink().value();
}
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
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
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getTechStuffLink() {
	if (techStuffLink == null)
		techStuffLink = new FaultReportToTechStuffLink(this);
	return techStuffLink;
}
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDivisionKey(com.hps.july.persistence.DivisionKey inKey) {
	boolean division_NULLTEST = (inKey == null);
	if (division_NULLTEST) division_division = null; else division_division = (new Integer(inKey.division));
}
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetEquipmentKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean equipment_NULLTEST = (inKey == null);
	if (equipment_NULLTEST) equipment_storageplace = null; else equipment_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOldagregateKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean oldagregate_NULLTEST = (inKey == null);
	if (oldagregate_NULLTEST) oldagregate_storagecard = null; else oldagregate_storagecard = (new Integer(inKey.storagecard));
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetStoragecardFromKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean storagecardFrom_NULLTEST = (inKey == null);
	if (storagecardFrom_NULLTEST) storagecardFrom_storagecard = null; else storagecardFrom_storagecard = (new Integer(inKey.storagecard));
}
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetTechStuffKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean techStuff_NULLTEST = (inKey == null);
	if (techStuff_NULLTEST) techStuff_worker = null; else techStuff_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException {
	this.getDivisionLink().secondarySet(aDivision);
}
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetEquipment(com.hps.july.persistence.EquipmentSet anEquipment) throws java.rmi.RemoteException {
	this.getEquipmentLink().secondarySet(anEquipment);
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOldagregate(com.hps.july.persistence.StorageCard anOldagregate) throws java.rmi.RemoteException {
	this.getOldagregateLink().secondarySet(anOldagregate);
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetStoragecardFrom(com.hps.july.persistence.StorageCard aStoragecardFrom) throws java.rmi.RemoteException {
	this.getStoragecardFromLink().secondarySet(aStoragecardFrom);
}
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetTechStuff(com.hps.july.persistence.Worker aTechStuff) throws java.rmi.RemoteException {
	this.getTechStuffLink().secondarySet(aTechStuff);
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
 * Setter method for comment
 */
public void setComment(java.lang.String newValue) {
	this.comment = newValue;
}
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException {
	this.getDivisionLink().set(aDivision);
}
/**
 * Setter method for eqplace
 */
public void setEqplace(java.lang.String newValue) {
	this.eqplace = newValue;
}
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setEquipment(com.hps.july.persistence.EquipmentSet anEquipment) throws java.rmi.RemoteException {
	this.getEquipmentLink().set(anEquipment);
}
/**
 * Setter method for newresource
 */
public void setNewresource(java.lang.Integer newValue) {
	this.newresource = newValue;
}
/**
 * Setter method for newserial
 */
public void setNewserial(java.lang.String newValue) {
	this.newserial = newValue;
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOldagregate(com.hps.july.persistence.StorageCard anOldagregate) throws java.rmi.RemoteException {
	this.getOldagregateLink().set(anOldagregate);
}
/**
 * Setter method for oldresource
 */
public void setOldresource(java.lang.Integer newValue) {
	this.oldresource = newValue;
}
/**
 * Setter method for oldserial
 */
public void setOldserial(java.lang.String newValue) {
	this.oldserial = newValue;
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setStoragecardFrom(com.hps.july.persistence.StorageCard aStoragecardFrom) throws java.rmi.RemoteException {
	this.getStoragecardFromLink().set(aStoragecardFrom);
}
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setTechStuff(com.hps.july.persistence.Worker aTechStuff) throws java.rmi.RemoteException {
	this.getTechStuffLink().set(aTechStuff);
}
}
