package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Карточка хранения оборудования
 */
public class StorageCardBean implements EntityBean {
	public Boolean boxed;
	public Boolean broken;
	public Boolean closed;
	public java.sql.Date dateclosed;
	public java.sql.Date dateopened;
	private javax.ejb.EntityContext entityContext = null;
	public String notes;
	public String party;
	public String policy;
	public java.math.BigDecimal price;
	public java.math.BigDecimal qty;
	public String serialnumber;
	private final static long serialVersionUID = 3206093459760846163L;
	public int storagecard;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	public java.lang.Integer currentstorage_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink currentstorageLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink lastDocumentLink = null;
	public java.sql.Date i13nDate;
	public java.math.BigDecimal qtyBroken;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink equipmentLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink agregateContentsLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink agregatorLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink cardTrackLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink ownerLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink contractLink = null;
	public java.lang.Integer lastDocument_document;
	public java.lang.Integer owner_organization;
	public java.lang.Integer contract_document;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink agregatePartsLink = null;
	public String configuration;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink i13nActLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink agregateContentLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink agregateLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink outDocumentPositionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink inDocumentPositionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink i13nDateSavingLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink assemblingActLink = null;
	public String place;
	public String manufserial;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink faultReports1Link = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink faultReports2Link = null;
	public String comment;
	public boolean isfictserial;
	/**
	 * Implementation field for persistent attribute: isapproved
	 */
	public boolean isapproved;
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

		h.put("resourceKey", getResourceKey());
		h.put("policy", getPolicy());
		h.put("place", getPlace());
		h.put("isapproved", new Boolean(isIsapproved()));
		h.put("contractKey", getContractKey());
		h.put("dateclosed", getDateclosed());
		h.put("isfictserial", new Boolean(getIsfictserial()));
		h.put("serialnumber", getSerialnumber());
		h.put("i13nDate", getI13nDate());
		h.put("storagecard", new Integer(getStoragecard()));
		h.put("qtyBroken", getQtyBroken());
		h.put("broken", getBroken());
		h.put("manufserial", getManufserial());
		h.put("price", getPrice());
		h.put("comment", getComment());
		h.put("currentstorageKey", getCurrentstorageKey());
		h.put("dateopened", getDateopened());
		h.put("closed", getClosed());
		h.put("qty", getQty());
		h.put("localserial", getLocalserial());
		h.put("boxed", getBoxed());
		h.put("party", getParty());
		h.put("configuration", getConfiguration());
		h.put("notes", getNotes());
		h.put("ownerKey", getOwnerKey());
		h.put("lastDocumentKey", getLastDocumentKey());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localPolicy = (java.lang.String) h.get("policy");
		java.lang.String localPlace = (java.lang.String) h.get("place");
		Boolean localIsapproved = (Boolean) h.get("isapproved");
		java.sql.Date localDateclosed = (java.sql.Date) h.get("dateclosed");
		Boolean localIsfictserial = (Boolean) h.get("isfictserial");
		java.lang.String localSerialnumber =
			(java.lang.String) h.get("serialnumber");
		java.sql.Date localI13nDate = (java.sql.Date) h.get("i13nDate");
		Integer localStoragecard = (Integer) h.get("storagecard");
		java.math.BigDecimal localQtyBroken =
			(java.math.BigDecimal) h.get("qtyBroken");
		java.lang.Boolean localBroken = (java.lang.Boolean) h.get("broken");
		java.lang.String localManufserial =
			(java.lang.String) h.get("manufserial");
		java.math.BigDecimal localPrice = (java.math.BigDecimal) h.get("price");
		java.lang.String localComment = (java.lang.String) h.get("comment");
		java.sql.Date localDateopened = (java.sql.Date) h.get("dateopened");
		java.lang.Boolean localClosed = (java.lang.Boolean) h.get("closed");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");
		java.lang.String localLocalserial =
			(java.lang.String) h.get("localserial");
		java.lang.Boolean localBoxed = (java.lang.Boolean) h.get("boxed");
		java.lang.String localParty = (java.lang.String) h.get("party");
		java.lang.String localConfiguration =
			(java.lang.String) h.get("configuration");
		java.lang.String localNotes = (java.lang.String) h.get("notes");

		if (h.containsKey("policy"))
			setPolicy((localPolicy));
		if (h.containsKey("place"))
			setPlace((localPlace));
		if (h.containsKey("isapproved"))
			setIsapproved((localIsapproved).booleanValue());
		if (h.containsKey("dateclosed"))
			setDateclosed((localDateclosed));
		if (h.containsKey("isfictserial"))
			setIsfictserial((localIsfictserial).booleanValue());
		if (h.containsKey("serialnumber"))
			setSerialnumber((localSerialnumber));
		if (h.containsKey("i13nDate"))
			setI13nDate((localI13nDate));
		if (h.containsKey("storagecard"))
			setStoragecard((localStoragecard).intValue());
		if (h.containsKey("qtyBroken"))
			setQtyBroken((localQtyBroken));
		if (h.containsKey("broken"))
			setBroken((localBroken));
		if (h.containsKey("manufserial"))
			setManufserial((localManufserial));
		if (h.containsKey("price"))
			setPrice((localPrice));
		if (h.containsKey("comment"))
			setComment((localComment));
		if (h.containsKey("dateopened"))
			setDateopened((localDateopened));
		if (h.containsKey("closed"))
			setClosed((localClosed));
		if (h.containsKey("qty"))
			setQty((localQty));
		if (h.containsKey("localserial"))
			setLocalserial((localLocalserial));
		if (h.containsKey("boxed"))
			setBoxed((localBoxed));
		if (h.containsKey("party"))
			setParty((localParty));
		if (h.containsKey("configuration"))
			setConfiguration((localConfiguration));
		if (h.containsKey("notes"))
			setNotes((localNotes));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getInDocumentPositionLink());
	links.addElement(getFaultReports1Link());
	links.addElement(getCardTrackLink());
	links.addElement(getResourceLink());
	links.addElement(getAgregateLink());
	links.addElement(getLastDocumentLink());
	links.addElement(getAgregateContentLink());
	links.addElement(getI13nActLink());
	links.addElement(getContractLink());
	links.addElement(getAssemblingActLink());
	links.addElement(getFaultReports2Link());
	links.addElement(getOutDocumentPositionLink());
	links.addElement(getCurrentstorageLink());
	links.addElement(getOwnerLink());
	links.addElement(getI13nDateSavingLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	inDocumentPositionLink = null;
	faultReports1Link = null;
	cardTrackLink = null;
	resourceLink = null;
	agregateLink = null;
	lastDocumentLink = null;
	agregateContentLink = null;
	i13nActLink = null;
	contractLink = null;
	assemblingActLink = null;
	faultReports2Link = null;
	outDocumentPositionLink = null;
	currentstorageLink = null;
	ownerLink = null;
	i13nDateSavingLink = null;
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
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException {
	this.getAssemblingActLink().addElement(anAssemblingAct);
}
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addCardTrack(com.hps.july.persistence.CardTrack aCardTrack) throws java.rmi.RemoteException {
	this.getCardTrackLink().addElement(aCardTrack);
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addFaultReports1(com.hps.july.persistence.FaultReport aFaultReports1) throws java.rmi.RemoteException {
	this.getFaultReports1Link().addElement(aFaultReports1);
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addFaultReports2(com.hps.july.persistence.FaultReport aFaultReports2) throws java.rmi.RemoteException {
	this.getFaultReports2Link().addElement(aFaultReports2);
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addI13nAct(com.hps.july.persistence.I13nAct anI13nAct) throws java.rmi.RemoteException {
	this.getI13nActLink().addElement(anI13nAct);
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addInDocumentPosition(com.hps.july.persistence.DocumentPosition anInDocumentPosition) throws java.rmi.RemoteException {
	this.getInDocumentPositionLink().addElement(anInDocumentPosition);
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addOutDocumentPosition(com.hps.july.persistence.DocumentPosition anOutDocumentPosition) throws java.rmi.RemoteException {
	this.getOutDocumentPositionLink().addElement(anOutDocumentPosition);
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
 * @param argStoragecard int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStoragecard) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	storagecard = argStoragecard;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argStoragecard int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argStoragecard, Integer argResource, java.sql.Date argDateOpened, Integer argOwner,
	String argPolicy, Boolean argClosed, java.math.BigDecimal argQty, java.math.BigDecimal argPrice ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	//initial clearing
	boxed = Boolean.FALSE;
	broken = Boolean.FALSE;
	closed = Boolean.FALSE;
	dateclosed = null;
	dateopened = null;
	notes = null;
	party = null;
	policy = null;
	price = null;
	qty = null;
	serialnumber = null;
	resource_resource = null;
	currentstorage_storageplace = null;
	i13nDate = null;
	qtyBroken = null;
	lastDocument_document = null;
	owner_organization = null;
	contract_document = null;
	configuration = null;
	place = null;

	//init real arguments
	storagecard = argStoragecard;
	resource_resource = argResource;
	dateopened = argDateOpened;
	owner_organization = argOwner;
	policy = argPolicy;
	closed = argClosed;
	qty = PersistenceUtil.dec(argQty, 3);
	price = PersistenceUtil.dec(argPrice, 2);
	manufserial = null;
	comment = null;
	isfictserial = false;
	//isapp
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
 * @param argStoragecard int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argStoragecard) throws java.rmi.RemoteException {}
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
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAgregate() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAgregateLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAgregateContent() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAgregateContentLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAgregateContentLink() {
	if (agregateContentLink == null)
		agregateContentLink = new StorageCardToAgregateContentLink(this);
	return agregateContentLink;
}
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAgregateLink() {
	if (agregateLink == null)
		agregateLink = new StorageCardToAgregateLink(this);
	return agregateLink;
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAssemblingAct() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAssemblingActLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAssemblingActLink() {
	if (assemblingActLink == null)
		assemblingActLink = new StorageCardToAssemblingActLink(this);
	return assemblingActLink;
}
/**
 * Getter method for boxed
 * @return java.lang.Boolean
 */
public java.lang.Boolean getBoxed() {
	return boxed;
}
/**
 * Getter method for broken
 * @return java.lang.Boolean
 */
public java.lang.Boolean getBroken() {
	return broken;
}
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCardTrack() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getCardTrackLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getCardTrackLink() {
	if (cardTrackLink == null)
		cardTrackLink = new StorageCardToCardTrackLink(this);
	return cardTrackLink;
}
/**
 * Getter method for closed
 * @return java.lang.Boolean
 */
public java.lang.Boolean getClosed() {
	return closed;
}
/**
 * Getter method for comment
 */
public java.lang.String getComment() {
	return comment;
}
/**
 * Getter method for configuration
 */
public java.lang.String getConfiguration() {
	return configuration;
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Contract getContract() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Contract)this.getContractLink().value();
}
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getContractKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean contract_NULLTEST = true;
	contract_NULLTEST &= (contract_document == null);
	temp.document = ((contract_document == null) ? 0 : contract_document.intValue());
	if (contract_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getContractLink() {
	if (contractLink == null)
		contractLink = new StorageCardToContractLink(this);
	return contractLink;
}
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlace getCurrentstorage() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StoragePlace)this.getCurrentstorageLink().value();
}
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getCurrentstorageKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean currentstorage_NULLTEST = true;
	currentstorage_NULLTEST &= (currentstorage_storageplace == null);
	temp.storageplace = ((currentstorage_storageplace == null) ? 0 : currentstorage_storageplace.intValue());
	if (currentstorage_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCurrentstorageLink() {
	if (currentstorageLink == null)
		currentstorageLink = new StorageCardToCurrentstorageLink(this);
	return currentstorageLink;
}
/**
 * Getter method for dateclosed
 * @return java.sql.Date
 */
public java.sql.Date getDateclosed() {
	return dateclosed;
}
/**
 * Getter method for dateopened
 * @return java.sql.Date
 */
public java.sql.Date getDateopened() {
	return dateopened;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getFaultReports1() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getFaultReports1Link().enumerationValue();
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getFaultReports1Link() {
	if (faultReports1Link == null)
		faultReports1Link = new StorageCardToFaultReports1Link(this);
	return faultReports1Link;
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getFaultReports2() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getFaultReports2Link().enumerationValue();
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getFaultReports2Link() {
	if (faultReports2Link == null)
		faultReports2Link = new StorageCardToFaultReports2Link(this);
	return faultReports2Link;
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nAct() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getI13nActLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getI13nActLink() {
	if (i13nActLink == null)
		i13nActLink = new StorageCardToI13nActLink(this);
	return i13nActLink;
}
/**
 * Getter method for i13nDate
 */
public java.sql.Date getI13nDate() {
	return i13nDate;
}
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nDateSaving() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getI13nDateSavingLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getI13nDateSavingLink() {
	if (i13nDateSavingLink == null)
		i13nDateSavingLink = new StorageCardToI13nDateSavingLink(this);
	return i13nDateSavingLink;
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getInDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getInDocumentPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getInDocumentPositionLink() {
	if (inDocumentPositionLink == null)
		inDocumentPositionLink = new StorageCardToInDocumentPositionLink(this);
	return inDocumentPositionLink;
}
/**
 * Getter method for isfictserial
 */
public boolean getIsfictserial() {
	return isfictserial;
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Document getLastDocument() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Document)this.getLastDocumentLink().value();
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getLastDocumentKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean lastDocument_NULLTEST = true;
	lastDocument_NULLTEST &= (lastDocument_document == null);
	temp.document = ((lastDocument_document == null) ? 0 : lastDocument_document.intValue());
	if (lastDocument_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getLastDocumentLink() {
	if (lastDocumentLink == null)
		lastDocumentLink = new StorageCardToLastDocumentLink(this);
	return lastDocumentLink;
}
/**
 * Getter method for manufserial
 */
public java.lang.String getManufserial() {
	return manufserial;
}
/**
 * Getter method for notes
 * @return java.lang.String
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOutDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getOutDocumentPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getOutDocumentPositionLink() {
	if (outDocumentPositionLink == null)
		outDocumentPositionLink = new StorageCardToOutDocumentPositionLink(this);
	return outDocumentPositionLink;
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOwner() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getOwnerLink().value();
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getOwnerKey() {
	com.hps.july.persistence.OrganizationKey temp = null;
	temp = new com.hps.july.persistence.OrganizationKey();
	boolean owner_NULLTEST = true;
	owner_NULLTEST &= (owner_organization == null);
	temp.organization = ((owner_organization == null) ? 0 : owner_organization.intValue());
	if (owner_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOwnerLink() {
	if (ownerLink == null)
		ownerLink = new StorageCardToOwnerLink(this);
	return ownerLink;
}
/**
 * Getter method for party
 * @return java.lang.String
 */
public java.lang.String getParty() {
	return party;
}
/**
 * Getter method for place
 */
public java.lang.String getPlace() {
	return place;
}
/**
 * Getter method for policy
 * @return java.lang.String
 */
public java.lang.String getPolicy() {
	return policy;
}
/**
 * Getter method for price
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getPrice() {
	return price;
}
/**
 * Getter method for qty
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getQty() {
	return qty;
}
/**
 * Getter method for qtyBroken
 */
public java.math.BigDecimal getQtyBroken() {
	return qtyBroken;
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getResourceLink().value();
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() {
	com.hps.july.persistence.ResourceKey temp = null;
	temp = new com.hps.july.persistence.ResourceKey();
	boolean resource_NULLTEST = true;
	resource_NULLTEST &= (resource_resource == null);
	temp.resource = ((resource_resource == null) ? 0 : resource_resource.intValue());
	if (resource_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new StorageCardToResourceLink(this);
	return resourceLink;
}
/**
 * Getter method for serialnumber
 * @return java.lang.String
 */
public java.lang.String getSerialnumber() {
	return serialnumber;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 17:05:26)
 * @return int
 */
public int getStoragecard() {
	return storagecard;
}
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetContractKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean contract_NULLTEST = (inKey == null);
	if (contract_NULLTEST) contract_document = null; else contract_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCurrentstorageKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean currentstorage_NULLTEST = (inKey == null);
	if (currentstorage_NULLTEST) currentstorage_storageplace = null; else currentstorage_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetLastDocumentKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean lastDocument_NULLTEST = (inKey == null);
	if (lastDocument_NULLTEST) lastDocument_document = null; else lastDocument_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOwnerKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean owner_NULLTEST = (inKey == null);
	if (owner_NULLTEST) owner_organization = null; else owner_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException {
	this.getAssemblingActLink().removeElement(anAssemblingAct);
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeFaultReports1(com.hps.july.persistence.FaultReport aFaultReports1) throws java.rmi.RemoteException {
	this.getFaultReports1Link().removeElement(aFaultReports1);
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeFaultReports2(com.hps.july.persistence.FaultReport aFaultReports2) throws java.rmi.RemoteException {
	this.getFaultReports2Link().removeElement(aFaultReports2);
}
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAgregate(com.hps.july.persistence.AgregateContent anAgregate) {
	this.getAgregateLink().secondaryAddElement(anAgregate);
}
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAgregateContent(com.hps.july.persistence.AgregateContent anAgregateContent) {
	this.getAgregateContentLink().secondaryAddElement(anAgregateContent);
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) {
	this.getAssemblingActLink().secondaryAddElement(anAssemblingAct);
}
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCardTrack(com.hps.july.persistence.CardTrack aCardTrack) {
	this.getCardTrackLink().secondaryAddElement(aCardTrack);
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddFaultReports1(com.hps.july.persistence.FaultReport aFaultReports1) {
	this.getFaultReports1Link().secondaryAddElement(aFaultReports1);
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddFaultReports2(com.hps.july.persistence.FaultReport aFaultReports2) {
	this.getFaultReports2Link().secondaryAddElement(aFaultReports2);
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nAct(com.hps.july.persistence.I13nAct anI13nAct) {
	this.getI13nActLink().secondaryAddElement(anI13nAct);
}
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) {
	this.getI13nDateSavingLink().secondaryAddElement(anI13nDateSaving);
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddInDocumentPosition(com.hps.july.persistence.DocumentPosition anInDocumentPosition) {
	this.getInDocumentPositionLink().secondaryAddElement(anInDocumentPosition);
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOutDocumentPosition(com.hps.july.persistence.DocumentPosition anOutDocumentPosition) {
	this.getOutDocumentPositionLink().secondaryAddElement(anOutDocumentPosition);
}
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAgregate(com.hps.july.persistence.AgregateContent anAgregate) {
	this.getAgregateLink().secondaryRemoveElement(anAgregate);
}
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAgregateContent(com.hps.july.persistence.AgregateContent anAgregateContent) {
	this.getAgregateContentLink().secondaryRemoveElement(anAgregateContent);
}
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) {
	this.getAssemblingActLink().secondaryRemoveElement(anAssemblingAct);
}
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCardTrack(com.hps.july.persistence.CardTrack aCardTrack) {
	this.getCardTrackLink().secondaryRemoveElement(aCardTrack);
}
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveFaultReports1(com.hps.july.persistence.FaultReport aFaultReports1) {
	this.getFaultReports1Link().secondaryRemoveElement(aFaultReports1);
}
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveFaultReports2(com.hps.july.persistence.FaultReport aFaultReports2) {
	this.getFaultReports2Link().secondaryRemoveElement(aFaultReports2);
}
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nAct(com.hps.july.persistence.I13nAct anI13nAct) {
	this.getI13nActLink().secondaryRemoveElement(anI13nAct);
}
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) {
	this.getI13nDateSavingLink().secondaryRemoveElement(anI13nDateSaving);
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveInDocumentPosition(com.hps.july.persistence.DocumentPosition anInDocumentPosition) {
	this.getInDocumentPositionLink().secondaryRemoveElement(anInDocumentPosition);
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOutDocumentPosition(com.hps.july.persistence.DocumentPosition anOutDocumentPosition) {
	this.getOutDocumentPositionLink().secondaryRemoveElement(anOutDocumentPosition);
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException {
	this.getContractLink().secondarySet(aContract);
}
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCurrentstorage(com.hps.july.persistence.StoragePlace aCurrentstorage) throws java.rmi.RemoteException {
	this.getCurrentstorageLink().secondarySet(aCurrentstorage);
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetLastDocument(com.hps.july.persistence.Document aLastDocument) throws java.rmi.RemoteException {
	this.getLastDocumentLink().secondarySet(aLastDocument);
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException {
	this.getOwnerLink().secondarySet(anOwner);
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().secondarySet(aResource);
}
/**
 * Setter method for boxed
 * @param newValue java.lang.Boolean
 */
public void setBoxed(java.lang.Boolean newValue) {
	this.boxed = newValue;
}
/**
 * Setter method for broken
 * @param newValue java.lang.Boolean
 */
public void setBroken(java.lang.Boolean newValue) {
	this.broken = newValue;
}
/**
 * Setter method for closed
 * @param newValue java.lang.Boolean
 */
public void setClosed(java.lang.Boolean newValue) {
	this.closed = newValue;
}
/**
 * Setter method for comment
 */
public void setComment(java.lang.String newValue) {
	this.comment = newValue;
}
/**
 * Setter method for configuration
 */
public void setConfiguration(java.lang.String newValue) {
	this.configuration = newValue;
}
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException {
	this.getContractLink().set(aContract);
}
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCurrentstorage(com.hps.july.persistence.StoragePlace aCurrentstorage) throws java.rmi.RemoteException {
	this.getCurrentstorageLink().set(aCurrentstorage);
}
/**
 * Setter method for dateclosed
 * @param newValue java.sql.Date
 */
public void setDateclosed(java.sql.Date newValue) {
	this.dateclosed = newValue;
}
/**
 * Setter method for dateopened
 * @param newValue java.sql.Date
 */
public void setDateopened(java.sql.Date newValue) {
	this.dateopened = newValue;
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
 * Setter method for i13nDate
 */
public void setI13nDate(java.sql.Date newValue) {
	this.i13nDate = newValue;
}
/**
 * Setter method for isfictserial
 */
public void setIsfictserial(boolean newValue) {
	this.isfictserial = newValue;
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setLastDocument(com.hps.july.persistence.Document aLastDocument) throws java.rmi.RemoteException {
	this.getLastDocumentLink().set(aLastDocument);
}
/**
 * Setter method for manufserial
 */
public void setManufserial(java.lang.String newValue) {
	this.manufserial = newValue;
}
/**
 * Setter method for notes
 * @param newValue java.lang.String
 */
public void setNotes(java.lang.String newValue) {
	this.notes = newValue;
}
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException {
	this.getOwnerLink().set(anOwner);
}
/**
 * Setter method for party
 * @param newValue java.lang.String
 */
public void setParty(java.lang.String newValue) {
	this.party = newValue;
}
/**
 * Setter method for place
 */
public void setPlace(java.lang.String newValue) {
	this.place = newValue;
}
/**
 * Setter method for policy
 * @param newValue java.lang.String
 */
public void setPolicy(java.lang.String newValue) {
	this.policy = newValue;
}
/**
 * Setter method for price
 * @param newValue java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newValue) {
	this.price = PersistenceUtil.dec(newValue, 2);
}
/**
 * Setter method for qty
 * @param newValue java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newValue) {
	this.qty = PersistenceUtil.dec(newValue, 3);
}
/**
 * Setter method for qtyBroken
 */
public void setQtyBroken(java.math.BigDecimal newValue) {
	this.qtyBroken = newValue;
}
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * Setter method for serialnumber
 * @param newValue java.lang.String
 */
public void setSerialnumber(java.lang.String newValue) {
	this.serialnumber = newValue;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 17:05:26)
 * @param newStoragecard int
 */
public void setStoragecard(int newStoragecard) {
	storagecard = newStoragecard;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: isapproved
	 */
	public boolean isIsapproved() {
		return isapproved;
	}
	/**
	 * Set accessor for persistent attribute: isapproved
	 */
	public void setIsapproved(boolean newIsapproved) {
		isapproved = newIsapproved;
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
