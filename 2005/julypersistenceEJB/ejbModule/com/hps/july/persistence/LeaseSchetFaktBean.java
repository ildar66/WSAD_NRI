package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * —чет-фактура по договору аренды
 */
public class LeaseSchetFaktBean implements EntityBean {
	public java.sql.Date baseDocDate;
	public String baseDocNumber;
	public java.sql.Date dateSchetFakt;
	private javax.ejb.EntityContext entityContext = null;
	public int idSchetFakt;
	public String numberSchetFakt;
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink leasePosSchetFaktsLink = null;
	public java.lang.Integer idAct_leaseDocument;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink idActLink = null;
	public java.lang.Integer idCurrency_currency;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink idCurrencyLink = null;
	public java.lang.Integer idContract_leaseDocument;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink idContractLink = null;
	public String docfilename;
	public byte[] doctext;
	/**
	 * Implementation field for persistent attribute: dateStartSf
	 */
	public java.sql.Date dateStartSf;
	/**
	 * Implementation field for persistent attribute: dateEndSf
	 */
	public java.sql.Date dateEndSf;
	/**
	 * Implementation field for persistent attribute: created
	 */
	public java.sql.Timestamp created;
	/**
	 * Implementation field for persistent attribute: createdBy
	 */
	public java.lang.Integer createdBy;
	/**
	 * Implementation field for persistent attribute: modified
	 */
	public java.sql.Timestamp modified;
	/**
	 * Implementation field for persistent attribute: modifiedBy
	 */
	public java.lang.Integer modifiedBy;
	/**
	 * Implementation field for persistent attribute: state
	 */
	public java.lang.String state;
	/**
	 * Implementation field for persistent attribute: idRegistryDoc
	 */
	public java.lang.Integer idRegistryDoc;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("docfilename", getDocfilename());
		h.put("idRegistryDoc", getIdRegistryDoc());
		h.put("state", getState());
		h.put("idSchetFakt", new Integer(getIdSchetFakt()));
		h.put("dateEndSf", getDateEndSf());
		h.put("created", getCreated());
		h.put("doctext", getDoctext());
		h.put("modified", getModified());
		h.put("idContractKey", getIdContractKey());
		h.put("numberSchetFakt", getNumberSchetFakt());
		h.put("idCurrencyKey", getIdCurrencyKey());
		h.put("dateSchetFakt", getDateSchetFakt());
		h.put("modifiedBy", getModifiedBy());
		h.put("createdBy", getCreatedBy());
		h.put("dateStartSf", getDateStartSf());
		h.put("baseDocNumber", getBaseDocNumber());
		h.put("baseDocDate", getBaseDocDate());
		h.put("idActKey", getIdActKey());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localDocfilename =
			(java.lang.String) h.get("docfilename");
		java.lang.Integer localIdRegistryDoc =
			(java.lang.Integer) h.get("idRegistryDoc");
		java.lang.String localState = (java.lang.String) h.get("state");
		java.sql.Date localDateEndSf = (java.sql.Date) h.get("dateEndSf");
		java.sql.Timestamp localCreated = (java.sql.Timestamp) h.get("created");
		byte[] localDoctext = (byte[]) h.get("doctext");
		java.sql.Timestamp localModified =
			(java.sql.Timestamp) h.get("modified");
		java.lang.String localNumberSchetFakt =
			(java.lang.String) h.get("numberSchetFakt");
		java.sql.Date localDateSchetFakt =
			(java.sql.Date) h.get("dateSchetFakt");
		java.lang.Integer localModifiedBy =
			(java.lang.Integer) h.get("modifiedBy");
		java.lang.Integer localCreatedBy =
			(java.lang.Integer) h.get("createdBy");
		java.sql.Date localDateStartSf = (java.sql.Date) h.get("dateStartSf");
		java.lang.String localBaseDocNumber =
			(java.lang.String) h.get("baseDocNumber");
		java.sql.Date localBaseDocDate = (java.sql.Date) h.get("baseDocDate");

		if (h.containsKey("docfilename"))
			setDocfilename((localDocfilename));
		if (h.containsKey("idRegistryDoc"))
			setIdRegistryDoc((localIdRegistryDoc));
		if (h.containsKey("state"))
			setState((localState));
		if (h.containsKey("dateEndSf"))
			setDateEndSf((localDateEndSf));
		if (h.containsKey("created"))
			setCreated((localCreated));
		if (h.containsKey("doctext"))
			setDoctext((localDoctext));
		if (h.containsKey("modified"))
			setModified((localModified));
		if (h.containsKey("numberSchetFakt"))
			setNumberSchetFakt((localNumberSchetFakt));
		if (h.containsKey("dateSchetFakt"))
			setDateSchetFakt((localDateSchetFakt));
		if (h.containsKey("modifiedBy"))
			setModifiedBy((localModifiedBy));
		if (h.containsKey("createdBy"))
			setCreatedBy((localCreatedBy));
		if (h.containsKey("dateStartSf"))
			setDateStartSf((localDateStartSf));
		if (h.containsKey("baseDocNumber"))
			setBaseDocNumber((localBaseDocNumber));
		if (h.containsKey("baseDocDate"))
			setBaseDocDate((localBaseDocDate));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getLeasePosSchetFaktsLink());
	links.addElement(getIdActLink());
	links.addElement(getIdCurrencyLink());
	links.addElement(getIdContractLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	leasePosSchetFaktsLink = null;
	idActLink = null;
	idCurrencyLink = null;
	idContractLink = null;
}
/**
 * This method was generated for supporting the associations.
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _removeLinks() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	java.util.Enumeration links = _getLinks().elements();
	while (links.hasMoreElements()) {
		try {
			((com.ibm.ivj.ejb.associations.interfaces.Link) (links.nextElement())).remove();
		}
		catch (javax.ejb.FinderException e) {} //Consume Finder error since I am going away
	}
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakts) throws java.rmi.RemoteException {
	this.getLeasePosSchetFaktsLink().addElement(aLeasePosSchetFakts);
}
/**
 * ejbActivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbActivate() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argIdSchetFakt int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(Integer argIdSchetFakt, Integer idContract, Integer idCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	idSchetFakt = argIdSchetFakt.intValue();
	idContract_leaseDocument = idContract;
	idCurrency_currency = idCurrency;
	baseDocDate = null;
	baseDocNumber = null;
	dateSchetFakt = null;
	numberSchetFakt = null;
	idAct_leaseDocument = null;
	doctext = null;
	docfilename = null;
}
/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argIdSchetFakt int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argIdSchetFakt) throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	_removeLinks();
}
/**
 * ejbStore method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbStore() throws java.rmi.RemoteException {}
/**
 * Getter method for baseDocDate
 * @return java.sql.Date
 */
public java.sql.Date getBaseDocDate() {
	return baseDocDate;
}
/**
 * Getter method for baseDocNumber
 * @return java.lang.String
 */
public java.lang.String getBaseDocNumber() {
	return baseDocNumber;
}
/**
 * Getter method for dateSchetFakt
 * @return java.sql.Date
 */
public java.sql.Date getDateSchetFakt() {
	return dateSchetFakt;
}
/**
 * Getter method for docfilename
 */
public java.lang.String getDocfilename() {
	return docfilename;
}
/**
 * Getter method for doctext
 */
public byte[] getDoctext() {
	return doctext;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseMutualActNew getIdAct() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeaseMutualActNew)this.getIdActLink().value();
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getIdActKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean idAct_NULLTEST = true;
	idAct_NULLTEST &= (idAct_leaseDocument == null);
	temp.leaseDocument = ((idAct_leaseDocument == null) ? 0 : idAct_leaseDocument.intValue());
	if (idAct_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getIdActLink() {
	if (idActLink == null)
		idActLink = new LeaseSchetFaktToIdActLink(this);
	return idActLink;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseContract getIdContract() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.LeaseContract)this.getIdContractLink().value();
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getIdContractKey() {
	com.hps.july.persistence.LeaseDocumentKey temp = null;
	temp = new com.hps.july.persistence.LeaseDocumentKey();
	boolean idContract_NULLTEST = true;
	idContract_NULLTEST &= (idContract_leaseDocument == null);
	temp.leaseDocument = ((idContract_leaseDocument == null) ? 0 : idContract_leaseDocument.intValue());
	if (idContract_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getIdContractLink() {
	if (idContractLink == null)
		idContractLink = new LeaseSchetFaktToIdContractLink(this);
	return idContractLink;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getIdCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Currency)this.getIdCurrencyLink().value();
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getIdCurrencyKey() {
	com.hps.july.persistence.CurrencyKey temp = null;
	temp = new com.hps.july.persistence.CurrencyKey();
	boolean idCurrency_NULLTEST = true;
	idCurrency_NULLTEST &= (idCurrency_currency == null);
	temp.currency = ((idCurrency_currency == null) ? 0 : idCurrency_currency.intValue());
	if (idCurrency_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getIdCurrencyLink() {
	if (idCurrencyLink == null)
		idCurrencyLink = new LeaseSchetFaktToIdCurrencyLink(this);
	return idCurrencyLink;
}
/**
 * Insert the method's description here.
 * Creation date: (19.05.2003 20:01:47)
 * @return int
 */
public int getIdSchetFakt() {
	return idSchetFakt;
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getLeasePosSchetFakts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getLeasePosSchetFaktsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getLeasePosSchetFaktsLink() {
	if (leasePosSchetFaktsLink == null)
		leasePosSchetFaktsLink = new LeaseSchetFaktToLeasePosSchetFaktsLink(this);
	return leasePosSchetFaktsLink;
}
/**
 * Getter method for numberSchetFakt
 * @return java.lang.String
 */
public java.lang.String getNumberSchetFakt() {
	return numberSchetFakt;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetIdActKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean idAct_NULLTEST = (inKey == null);
	if (idAct_NULLTEST) idAct_leaseDocument = null; else idAct_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetIdContractKey(com.hps.july.persistence.LeaseDocumentKey inKey) {
	boolean idContract_NULLTEST = (inKey == null);
	if (idContract_NULLTEST) idContract_leaseDocument = null; else idContract_leaseDocument = (new Integer(inKey.leaseDocument));
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetIdCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) {
	boolean idCurrency_NULLTEST = (inKey == null);
	if (idCurrency_NULLTEST) idCurrency_currency = null; else idCurrency_currency = (new Integer(inKey.currency));
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakts) {
	this.getLeasePosSchetFaktsLink().secondaryAddElement(aLeasePosSchetFakts);
}
/**
 * This method was generated for supporting the association named LeasePosSchetFakt2leaseSchetFact.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveLeasePosSchetFakts(com.hps.july.persistence.LeasePosSchetFakt aLeasePosSchetFakts) {
	this.getLeasePosSchetFaktsLink().secondaryRemoveElement(aLeasePosSchetFakts);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetIdAct(com.hps.july.persistence.LeaseMutualActNew anIdAct) throws java.rmi.RemoteException {
	this.getIdActLink().secondarySet(anIdAct);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetIdContract(com.hps.july.persistence.LeaseContract anIdContract) throws java.rmi.RemoteException {
	this.getIdContractLink().secondarySet(anIdContract);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetIdCurrency(com.hps.july.persistence.Currency anIdCurrency) throws java.rmi.RemoteException {
	this.getIdCurrencyLink().secondarySet(anIdCurrency);
}
/**
 * Setter method for baseDocDate
 * @param newValue java.sql.Date
 */
public void setBaseDocDate(java.sql.Date newValue) {
	this.baseDocDate = newValue;
}
/**
 * Setter method for baseDocNumber
 * @param newValue java.lang.String
 */
public void setBaseDocNumber(java.lang.String newValue) {
	this.baseDocNumber = newValue;
}
/**
 * Setter method for dateSchetFakt
 * @param newValue java.sql.Date
 */
public void setDateSchetFakt(java.sql.Date newValue) {
	this.dateSchetFakt = newValue;
}
/**
 * Setter method for docfilename
 */
public void setDocfilename(java.lang.String newValue) {
	this.docfilename = newValue;
}
/**
 * Setter method for doctext
 */
public void setDoctext(byte[] newValue) {
	this.doctext = newValue;
}
/**
 * setEntityContext method comment
 * @param ctx javax.ejb.EntityContext
 * @exception java.rmi.RemoteException The exception description.
 */
public void setEntityContext(javax.ejb.EntityContext ctx) throws java.rmi.RemoteException {
	entityContext = ctx;
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseMutualAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setIdAct(com.hps.july.persistence.LeaseMutualActNew anIdAct) throws java.rmi.RemoteException {
	this.getIdActLink().set(anIdAct);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2LeaseContract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setIdContract(com.hps.july.persistence.LeaseContract anIdContract) throws java.rmi.RemoteException {
	this.getIdContractLink().set(anIdContract);
}
/**
 * This method was generated for supporting the association named LeaseSchetFakt2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setIdCurrency(com.hps.july.persistence.Currency anIdCurrency) throws java.rmi.RemoteException {
	this.getIdCurrencyLink().set(anIdCurrency);
}
/**
 * Setter method for numberSchetFakt
 * @param newValue java.lang.String
 */
public void setNumberSchetFakt(java.lang.String newValue) {
	this.numberSchetFakt = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: dateStartSf
	 */
	public java.sql.Date getDateStartSf() {
		return dateStartSf;
	}
	/**
	 * Set accessor for persistent attribute: dateStartSf
	 */
	public void setDateStartSf(java.sql.Date newDateStartSf) {
		dateStartSf = newDateStartSf;
	}
	/**
	 * Get accessor for persistent attribute: dateEndSf
	 */
	public java.sql.Date getDateEndSf() {
		return dateEndSf;
	}
	/**
	 * Set accessor for persistent attribute: dateEndSf
	 */
	public void setDateEndSf(java.sql.Date newDateEndSf) {
		dateEndSf = newDateEndSf;
	}
	/**
	 * Get accessor for persistent attribute: created
	 */
	public java.sql.Timestamp getCreated() {
		return created;
	}
	/**
	 * Set accessor for persistent attribute: created
	 */
	public void setCreated(java.sql.Timestamp newCreated) {
		created = newCreated;
	}
	/**
	 * Get accessor for persistent attribute: createdBy
	 */
	public java.lang.Integer getCreatedBy() {
		return createdBy;
	}
	/**
	 * Set accessor for persistent attribute: createdBy
	 */
	public void setCreatedBy(java.lang.Integer newCreatedBy) {
		createdBy = newCreatedBy;
	}
	/**
	 * Get accessor for persistent attribute: modified
	 */
	public java.sql.Timestamp getModified() {
		return modified;
	}
	/**
	 * Set accessor for persistent attribute: modified
	 */
	public void setModified(java.sql.Timestamp newModified) {
		modified = newModified;
	}
	/**
	 * Get accessor for persistent attribute: modifiedBy
	 */
	public java.lang.Integer getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * Set accessor for persistent attribute: modifiedBy
	 */
	public void setModifiedBy(java.lang.Integer newModifiedBy) {
		modifiedBy = newModifiedBy;
	}
	/**
	 * Get accessor for persistent attribute: state
	 */
	public java.lang.String getState() {
		return state;
	}
	/**
	 * Set accessor for persistent attribute: state
	 */
	public void setState(java.lang.String newState) {
		state = newState;
	}
	/**
	 * Get accessor for persistent attribute: idRegistryDoc
	 */
	public java.lang.Integer getIdRegistryDoc() {
		return idRegistryDoc;
	}
	/**
	 * Set accessor for persistent attribute: idRegistryDoc
	 */
	public void setIdRegistryDoc(java.lang.Integer newIdRegistryDoc) {
		idRegistryDoc = newIdRegistryDoc;
	}
}
