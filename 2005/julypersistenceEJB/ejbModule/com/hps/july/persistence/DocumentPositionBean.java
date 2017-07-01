package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Обобщенные позиции документа (учет движения оборудования)
 */
public class DocumentPositionBean implements EntityBean {
	public int docposition;
	private javax.ejb.EntityContext entityContext = null;
	public int order;
	public String party;
	public java.math.BigDecimal price;
	public java.math.BigDecimal qty;
	public String serialnumber;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer document_document;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink documentLink = null;
	public java.lang.Integer resource_resource;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink resourceLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink ownerLink = null;
	public java.lang.Integer owner_organization;
	public String configuration;
	public Boolean sourceBoxed;
	public Boolean resultBoxed;
	public Boolean sourceBroken;
	public Boolean resultBroken;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink agregatePartsLink = null;
	public java.lang.Integer agregate_docposition;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink agregateLink = null;
	public java.lang.Integer cardFrom_storagecard;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink cardFromLink = null;
	public java.lang.Integer cardTo_storagecard;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink cardToLink = null;
	public Boolean sourceClosed;
	public Boolean resultClosed;
	public String agregateSerial;
	public String oldAgregateSerial;
	public String notes;
	public String oldplace;
	public String newplace;
	public String manufserial;
	public String comment;
	public boolean isfictserial;
	public String realserial;
	public Integer agregateresource;
	public Integer oldagregateresource;
	/**
	 * Implementation field for persistent attribute: visualtagid
	 */
	public java.lang.Integer visualtagid;
	/**
	 * Implementation field for persistent attribute: localserial
	 */
	public java.lang.String localserial;
	/**
	 * Implementation field for persistent attribute: agrmanufserial
	 */
	public java.lang.String agrmanufserial;
	/**
	 * Implementation field for persistent attribute: agrlocserial
	 */
	public java.lang.String agrlocserial;
	/**
	 * Implementation field for persistent attribute: oldagrmanufserial
	 */
	public java.lang.String oldagrmanufserial;
	/**
	 * Implementation field for persistent attribute: oldagrlocserial
	 */
	public java.lang.String oldagrlocserial;
	/**
	 * Implementation field for persistent attribute: parentbtsdocpos
	 */
	public java.lang.Integer parentbtsdocpos;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("resourceKey", getResourceKey());
		h.put("documentKey", getDocumentKey());
		h.put("realserial", getRealserial());
		h.put("sourceBroken", getSourceBroken());
		h.put("cardFromKey", getCardFromKey());
		h.put("resultClosed", getResultClosed());
		h.put("visualtagid", getVisualtagid());
		h.put("isfictserial", new Boolean(getIsfictserial()));
		h.put("cardToKey", getCardToKey());
		h.put("serialnumber", getSerialnumber());
		h.put("isReadOnly", new Boolean(getIsReadOnly()));
		h.put("agregateKey", getAgregateKey());
		h.put("sum", getSum());
		h.put("newplace", getNewplace());
		h.put("sourceClosed", getSourceClosed());
		h.put("agregateSerial", getAgregateSerial());
		h.put("manufserial", getManufserial());
		h.put("price", getPrice());
		h.put("resultBoxed", getResultBoxed());
		h.put("comment", getComment());
		h.put("docposition", new Integer(getDocposition()));
		h.put("oldplace", getOldplace());
		h.put("oldAgregateSerial", getOldAgregateSerial());
		h.put("order", new Integer(getOrder()));
		h.put("agregateresource", getAgregateresource());
		h.put("qty", getQty());
		h.put("party", getParty());
		h.put("configuration", getConfiguration());
		h.put("notes", getNotes());
		h.put("resultBroken", getResultBroken());
		h.put("oldagregateresource", getOldagregateresource());
		h.put("ownerKey", getOwnerKey());
		h.put("sourceBoxed", getSourceBoxed());
		h.put("oldagrlocserial", getOldagrlocserial());
		h.put("oldagrmanufserial", getOldagrmanufserial());
		h.put("agrlocserial", getAgrlocserial());
		h.put("localserial", getLocalserial());
		h.put("agrmanufserial", getAgrmanufserial());
		h.put("parentbtsdocpos", getParentbtsdocpos());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localRealserial =
			(java.lang.String) h.get("realserial");
		java.lang.Boolean localSourceBroken =
			(java.lang.Boolean) h.get("sourceBroken");
		java.lang.Boolean localResultClosed =
			(java.lang.Boolean) h.get("resultClosed");
		java.lang.Integer localVisualtagid =
			(java.lang.Integer) h.get("visualtagid");
		Boolean localIsfictserial = (Boolean) h.get("isfictserial");
		java.lang.String localSerialnumber =
			(java.lang.String) h.get("serialnumber");
		java.lang.String localNewplace = (java.lang.String) h.get("newplace");
		java.lang.Boolean localSourceClosed =
			(java.lang.Boolean) h.get("sourceClosed");
		java.lang.String localAgregateSerial =
			(java.lang.String) h.get("agregateSerial");
		java.lang.String localManufserial =
			(java.lang.String) h.get("manufserial");
		java.math.BigDecimal localPrice = (java.math.BigDecimal) h.get("price");
		java.lang.Boolean localResultBoxed =
			(java.lang.Boolean) h.get("resultBoxed");
		java.lang.String localComment = (java.lang.String) h.get("comment");
		Integer localDocposition = (Integer) h.get("docposition");
		java.lang.String localOldplace = (java.lang.String) h.get("oldplace");
		java.lang.String localOldAgregateSerial =
			(java.lang.String) h.get("oldAgregateSerial");
		Integer localOrder = (Integer) h.get("order");
		java.lang.Integer localAgregateresource =
			(java.lang.Integer) h.get("agregateresource");
		java.math.BigDecimal localQty = (java.math.BigDecimal) h.get("qty");
		java.lang.String localParty = (java.lang.String) h.get("party");
		java.lang.String localConfiguration =
			(java.lang.String) h.get("configuration");
		java.lang.String localNotes = (java.lang.String) h.get("notes");
		java.lang.Boolean localResultBroken =
			(java.lang.Boolean) h.get("resultBroken");
		java.lang.Integer localOldagregateresource =
			(java.lang.Integer) h.get("oldagregateresource");
		java.lang.Boolean localSourceBoxed =
			(java.lang.Boolean) h.get("sourceBoxed");
		java.lang.String localOldagrlocserial =
			(java.lang.String) h.get("oldagrlocserial");
		java.lang.String localOldagrmanufserial =
			(java.lang.String) h.get("oldagrmanufserial");
		java.lang.String localAgrlocserial =
			(java.lang.String) h.get("agrlocserial");
		java.lang.String localLocalserial =
			(java.lang.String) h.get("localserial");
		java.lang.String localAgrmanufserial =
			(java.lang.String) h.get("agrmanufserial");
		java.lang.Integer localParentbtsdocpos =
			(java.lang.Integer) h.get("parentbtsdocpos");

		if (h.containsKey("realserial"))
			setRealserial((localRealserial));
		if (h.containsKey("sourceBroken"))
			setSourceBroken((localSourceBroken));
		if (h.containsKey("resultClosed"))
			setResultClosed((localResultClosed));
		if (h.containsKey("visualtagid"))
			setVisualtagid((localVisualtagid));
		if (h.containsKey("isfictserial"))
			setIsfictserial((localIsfictserial).booleanValue());
		if (h.containsKey("serialnumber"))
			setSerialnumber((localSerialnumber));
		if (h.containsKey("newplace"))
			setNewplace((localNewplace));
		if (h.containsKey("sourceClosed"))
			setSourceClosed((localSourceClosed));
		if (h.containsKey("agregateSerial"))
			setAgregateSerial((localAgregateSerial));
		if (h.containsKey("manufserial"))
			setManufserial((localManufserial));
		if (h.containsKey("price"))
			setPrice((localPrice));
		if (h.containsKey("resultBoxed"))
			setResultBoxed((localResultBoxed));
		if (h.containsKey("comment"))
			setComment((localComment));
		if (h.containsKey("docposition"))
			setDocposition((localDocposition).intValue());
		if (h.containsKey("oldplace"))
			setOldplace((localOldplace));
		if (h.containsKey("oldAgregateSerial"))
			setOldAgregateSerial((localOldAgregateSerial));
		if (h.containsKey("order"))
			setOrder((localOrder).intValue());
		if (h.containsKey("agregateresource"))
			setAgregateresource((localAgregateresource));
		if (h.containsKey("qty"))
			setQty((localQty));
		if (h.containsKey("party"))
			setParty((localParty));
		if (h.containsKey("configuration"))
			setConfiguration((localConfiguration));
		if (h.containsKey("notes"))
			setNotes((localNotes));
		if (h.containsKey("resultBroken"))
			setResultBroken((localResultBroken));
		if (h.containsKey("oldagregateresource"))
			setOldagregateresource((localOldagregateresource));
		if (h.containsKey("sourceBoxed"))
			setSourceBoxed((localSourceBoxed));
		if (h.containsKey("oldagrlocserial"))
			setOldagrlocserial((localOldagrlocserial));
		if (h.containsKey("oldagrmanufserial"))
			setOldagrmanufserial((localOldagrmanufserial));
		if (h.containsKey("agrlocserial"))
			setAgrlocserial((localAgrlocserial));
		if (h.containsKey("localserial"))
			setLocalserial((localLocalserial));
		if (h.containsKey("agrmanufserial"))
			setAgrmanufserial((localAgrmanufserial));
		if (h.containsKey("parentbtsdocpos"))
			setParentbtsdocpos((localParentbtsdocpos));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = new java.util.Vector();
	links.addElement(getCardToLink());
	links.addElement(getOwnerLink());
	links.addElement(getResourceLink());
	links.addElement(getDocumentLink());
	links.addElement(getCardFromLink());
	links.addElement(getAgregatePartsLink());
	links.addElement(getAgregateLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	cardToLink = null;
	ownerLink = null;
	resourceLink = null;
	documentLink = null;
	cardFromLink = null;
	agregatePartsLink = null;
	agregateLink = null;
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
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAgregateParts(com.hps.july.persistence.DocumentPosition anAgregateParts) throws java.rmi.RemoteException {
	this.getAgregatePartsLink().addElement(anAgregateParts);
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
 * @param argDocposition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	docposition = argDocposition;
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocposition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocposition, Integer argResource, Integer argOwner, Integer argDocument, 
	int argOrder, java.math.BigDecimal argQty, java.math.BigDecimal argPrice, 
	Boolean argSourceBoxed, Boolean argResultBoxed, Boolean argSourceBroken , Boolean argResultBroken, 
	Boolean argSourceClosed, Boolean argResultClosed ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	party = null;
	price = null;
	qty = null;
	serialnumber = null;
	document_document = null;
	resource_resource = null;
	owner_organization = null;
	configuration = null;
	sourceBoxed = null;
	resultBoxed = null;
	sourceBroken = null;
	resultBroken = null;
	agregate_docposition = null;
	cardFrom_storagecard = null;
	cardTo_storagecard = null;
	sourceClosed = null;
	resultClosed = null;
	agregateSerial = null;
	oldAgregateSerial = null;
	notes = null;
	oldplace = null;
	newplace = null;
	
	docposition = argDocposition;
	resource_resource = argResource;
	document_document = argDocument;
	order = argOrder;
	qty = PersistenceUtil.dec(argQty, 3);
	owner_organization = argOwner;
	price = PersistenceUtil.dec(argPrice, 2);
	sourceBoxed = argSourceBoxed;
	resultBoxed = argResultBoxed;
	sourceBroken = argSourceBroken;
	resultBroken = argResultBroken;
	sourceClosed = argSourceClosed;
	resultClosed = argResultClosed;
	manufserial = null;
	comment = null;
	isfictserial = false;
	realserial = null;
	agregateresource = null;
	oldagregateresource = null;
	visualtagid = null;
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
 * @param argDocposition int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argDocposition) throws java.rmi.RemoteException {}
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
public void ejbStore() throws java.rmi.RemoteException {
	int i= 0;
	}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentPosition getAgregate() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.DocumentPosition)this.getAgregateLink().value();
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentPositionKey getAgregateKey() {
	com.hps.july.persistence.DocumentPositionKey temp = null;
	temp = new com.hps.july.persistence.DocumentPositionKey();
	boolean agregate_NULLTEST = true;
	agregate_NULLTEST &= (agregate_docposition == null);
	temp.docposition = ((agregate_docposition == null) ? 0 : agregate_docposition.intValue());
	if (agregate_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getAgregateLink() {
	if (agregateLink == null)
		agregateLink = new DocumentPositionToAgregateLink(this);
	return agregateLink;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAgregateParts() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getAgregatePartsLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getAgregatePartsLink() {
	if (agregatePartsLink == null)
		agregatePartsLink = new DocumentPositionToAgregatePartsLink(this);
	return agregatePartsLink;
}
/**
 * Getter method for agregateresource
 */
public java.lang.Integer getAgregateresource() {
	return agregateresource;
}
/**
 * Getter method for agregateSerial
 */
public java.lang.String getAgregateSerial() {
	return agregateSerial;
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getCardFrom() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StorageCard)this.getCardFromLink().value();
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getCardFromKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean cardFrom_NULLTEST = true;
	cardFrom_NULLTEST &= (cardFrom_storagecard == null);
	temp.storagecard = ((cardFrom_storagecard == null) ? 0 : cardFrom_storagecard.intValue());
	if (cardFrom_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCardFromLink() {
	if (cardFromLink == null)
		cardFromLink = new DocumentPositionToCardFromLink(this);
	return cardFromLink;
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getCardTo() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StorageCard)this.getCardToLink().value();
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getCardToKey() {
	com.hps.july.persistence.StorageCardKey temp = null;
	temp = new com.hps.july.persistence.StorageCardKey();
	boolean cardTo_NULLTEST = true;
	cardTo_NULLTEST &= (cardTo_storagecard == null);
	temp.storagecard = ((cardTo_storagecard == null) ? 0 : cardTo_storagecard.intValue());
	if (cardTo_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getCardToLink() {
	if (cardToLink == null)
		cardToLink = new DocumentPositionToCardToLink(this);
	return cardToLink;
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
 * Insert the method's description here.
 * Creation date: (24.04.2002 18:05:24)
 * @return int
 */
public int getDocposition() {
	return docposition;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Document getDocument() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Document)this.getDocumentLink().value();
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getDocumentKey() {
	com.hps.july.persistence.DocumentKey temp = null;
	temp = new com.hps.july.persistence.DocumentKey();
	boolean document_NULLTEST = true;
	document_NULLTEST &= (document_document == null);
	temp.document = ((document_document == null) ? 0 : document_document.intValue());
	if (document_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getDocumentLink() {
	if (documentLink == null)
		documentLink = new DocumentPositionToDocumentLink(this);
	return documentLink;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * Getter method for isfictserial
 */
public boolean getIsfictserial() {
	return isfictserial;
}
/**
 * Insert the method's description here.
 * Creation date: (24.05.2002 10:10:01)
 * @return boolean
 */
public boolean getIsReadOnly() {
	return false;
}
/**
 * Getter method for manufserial
 */
public java.lang.String getManufserial() {
	return manufserial;
}
/**
 * Getter method for newplace
 */
public java.lang.String getNewplace() {
	return newplace;
}
/**
 * Getter method for notes
 */
public java.lang.String getNotes() {
	return notes;
}
/**
 * Getter method for oldagregateresource
 */
public java.lang.Integer getOldagregateresource() {
	return oldagregateresource;
}
/**
 * Getter method for oldAgregateSerial
 */
public java.lang.String getOldAgregateSerial() {
	return oldAgregateSerial;
}
/**
 * Getter method for oldplace
 */
public java.lang.String getOldplace() {
	return oldplace;
}
/**
 * Getter method for order
 * @return int
 */
public int getOrder() {
	return order;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOwner() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getOwnerLink().value();
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
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
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOwnerLink() {
	if (ownerLink == null)
		ownerLink = new DocumentPositionToOwnerLink(this);
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
 * Getter method for realserial
 */
public java.lang.String getRealserial() {
	return realserial;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Resource)this.getResourceLink().value();
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
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
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getResourceLink() {
	if (resourceLink == null)
		resourceLink = new DocumentPositionToResourceLink(this);
	return resourceLink;
}
/**
 * Getter method for resultBoxed
 */
public java.lang.Boolean getResultBoxed() {
	return resultBoxed;
}
/**
 * Getter method for resultBroken
 */
public java.lang.Boolean getResultBroken() {
	return resultBroken;
}
/**
 * Getter method for resultClosed
 */
public java.lang.Boolean getResultClosed() {
	return resultClosed;
}
/**
 * Getter method for serialnumber
 * @return java.lang.String
 */
public java.lang.String getSerialnumber() {
	return serialnumber;
}
/**
 * Getter method for sourceBoxed
 */
public java.lang.Boolean getSourceBoxed() {
	return sourceBoxed;
}
/**
 * Getter method for sourceBroken
 */
public java.lang.Boolean getSourceBroken() {
	return sourceBroken;
}
/**
 * Getter method for sourceClosed
 */
public java.lang.Boolean getSourceClosed() {
	return sourceClosed;
}
/**
 * Insert the method's description here.
 * Creation date: (28.05.2002 18:13:04)
 * @return java.math.BigDecimal
 */
public java.math.BigDecimal getSum() {
	return qty.multiply( price ).setScale( 2, java.math.BigDecimal.ROUND_HALF_UP );
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetAgregateKey(com.hps.july.persistence.DocumentPositionKey inKey) {
	boolean agregate_NULLTEST = (inKey == null);
	if (agregate_NULLTEST) agregate_docposition = null; else agregate_docposition = (new Integer(inKey.docposition));
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCardFromKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean cardFrom_NULLTEST = (inKey == null);
	if (cardFrom_NULLTEST) cardFrom_storagecard = null; else cardFrom_storagecard = (new Integer(inKey.storagecard));
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetCardToKey(com.hps.july.persistence.StorageCardKey inKey) {
	boolean cardTo_NULLTEST = (inKey == null);
	if (cardTo_NULLTEST) cardTo_storagecard = null; else cardTo_storagecard = (new Integer(inKey.storagecard));
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDocumentKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean document_NULLTEST = (inKey == null);
	if (document_NULLTEST) document_document = null; else document_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOwnerKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean owner_NULLTEST = (inKey == null);
	if (owner_NULLTEST) owner_organization = null; else owner_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) {
	boolean resource_NULLTEST = (inKey == null);
	if (resource_NULLTEST) resource_resource = null; else resource_resource = (new Integer(inKey.resource));
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAgregateParts(com.hps.july.persistence.DocumentPosition anAgregateParts) {
	this.getAgregatePartsLink().secondaryAddElement(anAgregateParts);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAgregateParts(com.hps.july.persistence.DocumentPosition anAgregateParts) {
	this.getAgregatePartsLink().secondaryRemoveElement(anAgregateParts);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetAgregate(com.hps.july.persistence.DocumentPosition anAgregate) throws java.rmi.RemoteException {
	this.getAgregateLink().secondarySet(anAgregate);
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCardFrom(com.hps.july.persistence.StorageCard aCardFrom) throws java.rmi.RemoteException {
	this.getCardFromLink().secondarySet(aCardFrom);
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCardTo(com.hps.july.persistence.StorageCard aCardTo) throws java.rmi.RemoteException {
	this.getCardToLink().secondarySet(aCardTo);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetDocument(com.hps.july.persistence.Document aDocument) throws java.rmi.RemoteException {
	this.getDocumentLink().secondarySet(aDocument);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException {
	this.getOwnerLink().secondarySet(anOwner);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().secondarySet(aResource);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setAgregate(com.hps.july.persistence.DocumentPosition anAgregate) throws java.rmi.RemoteException {
	this.getAgregateLink().set(anAgregate);
}
/**
 * Setter method for agregateresource
 */
public void setAgregateresource(java.lang.Integer newValue) {
	this.agregateresource = newValue;
}
/**
 * Setter method for agregateSerial
 */
public void setAgregateSerial(java.lang.String newValue) {
	this.agregateSerial = newValue;
}
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCardFrom(com.hps.july.persistence.StorageCard aCardFrom) throws java.rmi.RemoteException {
	this.getCardFromLink().set(aCardFrom);
}
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCardTo(com.hps.july.persistence.StorageCard aCardTo) throws java.rmi.RemoteException {
	this.getCardToLink().set(aCardTo);
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
 * Insert the method's description here.
 * Creation date: (24.04.2002 18:05:24)
 * @param newDocposition int
 */
public void setDocposition(int newDocposition) {
	docposition = newDocposition;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setDocument(com.hps.july.persistence.Document aDocument) throws java.rmi.RemoteException {
	this.getDocumentLink().set(aDocument);
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
 * Setter method for isfictserial
 */
public void setIsfictserial(boolean newValue) {
	this.isfictserial = newValue;
}
/**
 * Setter method for manufserial
 */
public void setManufserial(java.lang.String newValue) {
	this.manufserial = newValue;
}
/**
 * Setter method for newplace
 */
public void setNewplace(java.lang.String newValue) {
	this.newplace = newValue;
}
/**
 * Setter method for notes
 */
public void setNotes(java.lang.String newValue) {
	this.notes = newValue;
}
/**
 * Setter method for oldagregateresource
 */
public void setOldagregateresource(java.lang.Integer newValue) {
	this.oldagregateresource = newValue;
}
/**
 * Setter method for oldAgregateSerial
 */
public void setOldAgregateSerial(java.lang.String newValue) {
	this.oldAgregateSerial = newValue;
}
/**
 * Setter method for oldplace
 */
public void setOldplace(java.lang.String newValue) {
	this.oldplace = newValue;
}
/**
 * Setter method for order
 * @param newValue int
 */
public void setOrder(int newValue) {
	this.order = newValue;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
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
 * Setter method for price
 * @param newValue java.math.BigDecimal
 */
public void setPrice(java.math.BigDecimal newValue) {
	this.price = PersistenceUtil.dec(newValue,2);
}
/**
 * Setter method for qty
 * @param newValue java.math.BigDecimal
 */
public void setQty(java.math.BigDecimal newValue) {
	this.qty = PersistenceUtil.dec(newValue,3);
}
/**
 * Setter method for realserial
 */
public void setRealserial(java.lang.String newValue) {
	this.realserial = newValue;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException {
	this.getResourceLink().set(aResource);
}
/**
 * Setter method for resultBoxed
 */
public void setResultBoxed(java.lang.Boolean newValue) {
	this.resultBoxed = newValue;
}
/**
 * Setter method for resultBroken
 */
public void setResultBroken(java.lang.Boolean newValue) {
	this.resultBroken = newValue;
}
/**
 * Setter method for resultClosed
 */
public void setResultClosed(java.lang.Boolean newValue) {
	this.resultClosed = newValue;
}
/**
 * Setter method for serialnumber
 * @param newValue java.lang.String
 */
public void setSerialnumber(java.lang.String newValue) {
	this.serialnumber = newValue;
}
/**
 * Setter method for sourceBoxed
 */
public void setSourceBoxed(java.lang.Boolean newValue) {
	this.sourceBoxed = newValue;
}
/**
 * Setter method for sourceBroken
 */
public void setSourceBroken(java.lang.Boolean newValue) {
	this.sourceBroken = newValue;
}
/**
 * Setter method for sourceClosed
 */
public void setSourceClosed(java.lang.Boolean newValue) {
	this.sourceClosed = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: visualtagid
	 */
	public java.lang.Integer getVisualtagid() {
		return visualtagid;
	}
	/**
	 * Set accessor for persistent attribute: visualtagid
	 */
	public void setVisualtagid(java.lang.Integer newVisualtagid) {
		visualtagid = newVisualtagid;
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
	/**
	 * Get accessor for persistent attribute: agrmanufserial
	 */
	public java.lang.String getAgrmanufserial() {
		return agrmanufserial;
	}
	/**
	 * Set accessor for persistent attribute: agrmanufserial
	 */
	public void setAgrmanufserial(java.lang.String newAgrmanufserial) {
		agrmanufserial = newAgrmanufserial;
	}
	/**
	 * Get accessor for persistent attribute: agrlocserial
	 */
	public java.lang.String getAgrlocserial() {
		return agrlocserial;
	}
	/**
	 * Set accessor for persistent attribute: agrlocserial
	 */
	public void setAgrlocserial(java.lang.String newAgrlocserial) {
		agrlocserial = newAgrlocserial;
	}
	/**
	 * Get accessor for persistent attribute: oldagrmanufserial
	 */
	public java.lang.String getOldagrmanufserial() {
		return oldagrmanufserial;
	}
	/**
	 * Set accessor for persistent attribute: oldagrmanufserial
	 */
	public void setOldagrmanufserial(java.lang.String newOldagrmanufserial) {
		oldagrmanufserial = newOldagrmanufserial;
	}
	/**
	 * Get accessor for persistent attribute: oldagrlocserial
	 */
	public java.lang.String getOldagrlocserial() {
		return oldagrlocserial;
	}
	/**
	 * Set accessor for persistent attribute: oldagrlocserial
	 */
	public void setOldagrlocserial(java.lang.String newOldagrlocserial) {
		oldagrlocserial = newOldagrlocserial;
	}
	/**
	 * Get accessor for persistent attribute: parentbtsdocpos
	 */
	public java.lang.Integer getParentbtsdocpos() {
		return parentbtsdocpos;
	}
	/**
	 * Set accessor for persistent attribute: parentbtsdocpos
	 */
	public void setParentbtsdocpos(java.lang.Integer newParentbtsdocpos) {
		parentbtsdocpos = newParentbtsdocpos;
	}
}
