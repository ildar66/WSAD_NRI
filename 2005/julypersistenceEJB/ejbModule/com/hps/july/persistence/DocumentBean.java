package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Документ (учет движения оборудования)
 */
public class DocumentBean implements EntityBean {
	public java.sql.Date blankdate;
	public String blanknumber;
	public int document;
	private javax.ejb.EntityContext entityContext = null;
	private final static long serialVersionUID = 3206093459760846163L;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink documentPositionLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink documentsLinkFromLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink documentsLinkToLink = null;
	public String insuranceact;
	public java.sql.Date insurancedate;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink storageCardLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink cardTrackLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink fromLink = null;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink toLink = null;
	public java.lang.Integer from_storageplace;
	public java.lang.Integer to_storageplace;
	private transient com.ibm.ivj.ejb.associations.interfaces.ManyLink currentStorageCardLink = null;
	public java.lang.Integer contragent_organization;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink contragentLink = null;
	public java.lang.Integer owner_organization;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink ownerLink = null;
	public String documentState;
	public Boolean processSource;
	public Boolean processDestination;
	public java.lang.Integer storageManager_worker;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink storageManagerLink = null;
	public String insuranseMan;
	public int blankindex;
	public boolean showtouser;
	public Integer operator;
	private int tempOperator;
	public Integer parentdocument;
	public boolean isautodoc;
	public Integer to2;
	public boolean needapprove;
	/**
	 * Implementation field for persistent attribute: projectid
	 */
	public java.lang.Integer projectid;
	/**
	 * Implementation field for persistent attribute: prjstatus
	 */
	public java.lang.String prjstatus;
	/**
	 * Implementation field for persistent attribute: visualtype
	 */
	public java.lang.Integer visualtype;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

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
	java.util.Vector links = new java.util.Vector();
	links.addElement(getDocumentsLinkFromLink());
	links.addElement(getCurrentStorageCardLink());
	links.addElement(getCardTrackLink());
	links.addElement(getContragentLink());
	links.addElement(getFromLink());
	links.addElement(getOwnerLink());
	links.addElement(getStorageManagerLink());
	links.addElement(getToLink());
	links.addElement(getDocumentsLinkToLink());
	links.addElement(getDocumentPositionLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	documentsLinkFromLink = null;
	currentStorageCardLink = null;
	cardTrackLink = null;
	contragentLink = null;
	fromLink = null;
	ownerLink = null;
	storageManagerLink = null;
	toLink = null;
	documentsLinkToLink = null;
	documentPositionLink = null;
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
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addCardTrack(com.hps.july.persistence.CardTrack aCardTrack) throws java.rmi.RemoteException {
	this.getCardTrackLink().addElement(aCardTrack);
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addCurrentStorageCard(com.hps.july.persistence.StorageCard aCurrentStorageCard) throws java.rmi.RemoteException {
	this.getCurrentStorageCardLink().addElement(aCurrentStorageCard);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) throws java.rmi.RemoteException {
	this.getDocumentPositionLink().addElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException {
	this.getStorageCardLink().addElement(aStorageCard);
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
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	document = argDocument;
	operator = null;
	setOperator();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, Integer argFrom, Integer argTo, java.sql.Date argBlankDate, 
	int argBlankindex, String argBlankNumber, String argState, 
		Boolean argProcessSource, Boolean argProcessDestination ) throws javax.ejb.CreateException, java.rmi.RemoteException {
	_initLinks();
	// All CMP fields should be initialized here.
	blankdate = null;
	blanknumber = null;
	insuranceact = null;
	insurancedate = null;
	from_storageplace = null;
	to_storageplace = null;
	contragent_organization = null;
	owner_organization = null;
	documentState = null;
	processSource = Boolean.FALSE;
	processDestination = Boolean.FALSE;
	storageManager_worker = null;
	insuranseMan = null;

	
	document = argDocument;
	owner_organization = argOwner;
	from_storageplace = argFrom;
	to_storageplace = argTo;
	blankdate = argBlankDate;
	blankindex = argBlankindex;
	blanknumber = argBlankNumber;
	documentState = argState;
	processSource = argProcessSource;
	processDestination = argProcessDestination;
	showtouser = true;
	operator = null;
	parentdocument = null;
	isautodoc = false;
	to2 = null;
	needapprove = false;
	projectid = null;
	prjstatus = "A";
	visualtype = null;
	setOperator();
}
/**
 * ejbCreate method for a CMP entity bean
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbCreate(int argDocument, Integer argOwner, java.sql.Date argBlankDate, 
	int argBlankindex, String argState ) throws javax.ejb.CreateException, java.rmi.RemoteException {
		
	_initLinks();
	
	// All CMP fields should be initialized here.
	blankdate = null;
	blanknumber = null;
	insuranceact = null;
	insurancedate = null;
	from_storageplace = null;
	to_storageplace = null;
	contragent_organization = null;
	owner_organization = null;
	documentState = null;
	processSource = Boolean.FALSE;
	processDestination = Boolean.FALSE;
	storageManager_worker = null;
	insuranseMan = null;

	document = argDocument;
	owner_organization = argOwner;
	blankdate = argBlankDate;
	documentState = argState;
	showtouser = true;
	operator = null;
	parentdocument = null;
	isautodoc = false;
	to2 = null;
	needapprove = false;
	projectid = null;
	prjstatus = "A";
	visualtype = null;
	setOperator();
}
/**
 * ejbLoad method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbLoad() throws java.rmi.RemoteException {
	_initLinks();
	setOperator();
}
/**
 * ejbPassivate method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPassivate() throws java.rmi.RemoteException {}
/**
 * ejbPostCreate method for a CMP entity bean
 * @param argDocument int
 * @exception java.rmi.RemoteException The exception description.
 */
public void ejbPostCreate(int argDocument) throws java.rmi.RemoteException {}
/**
 * ejbRemove method comment
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.RemoveException The exception description.
 */
public void ejbRemove() throws java.rmi.RemoteException, javax.ejb.RemoveException {
	_removeLinks();
}
public void ejbStore() throws java.rmi.RemoteException {
	//System.out.println("Document_ejbStore operator="+operator);
	if(tempOperator == 0) System.out.println("Document_ejbStore Не определен оператор !!!");
	else
		setOperator(new Integer(tempOperator));
}
/**
 * Getter method for blankdate
 * @return java.sql.Date
 */
public java.sql.Date getBlankdate() {
	return blankdate;
}
/**
 * Getter method for blankindex
 */
public int getBlankindex() {
	return blankindex;
}
/**
 * Getter method for blanknumber
 * @return java.lang.String
 */
public java.lang.String getBlanknumber() {
	return blanknumber;
}
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCardTrack() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getCardTrackLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getCardTrackLink() {
	if (cardTrackLink == null)
		cardTrackLink = new DocumentToCardTrackLink(this);
	return cardTrackLink;
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getContragent() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getContragentLink().value();
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getContragentKey() {
	com.hps.july.persistence.OrganizationKey temp = null;
	temp = new com.hps.july.persistence.OrganizationKey();
	boolean contragent_NULLTEST = true;
	contragent_NULLTEST &= (contragent_organization == null);
	temp.organization = ((contragent_organization == null) ? 0 : contragent_organization.intValue());
	if (contragent_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getContragentLink() {
	if (contragentLink == null)
		contragentLink = new DocumentToContragentLink(this);
	return contragentLink;
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCurrentStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getCurrentStorageCardLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getCurrentStorageCardLink() {
	if (currentStorageCardLink == null)
		currentStorageCardLink = new DocumentToCurrentStorageCardLink(this);
	return currentStorageCardLink;
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 15:29:13)
 * @return int
 */
public int getDocument() {
	return document;
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getDocumentPositionLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getDocumentPositionLink() {
	if (documentPositionLink == null)
		documentPositionLink = new DocumentToDocumentPositionLink(this);
	return documentPositionLink;
}
/**
 * This method was generated for supporting the association named DocumentsLink2FirstDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getDocumentsLinkFrom() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getDocumentsLinkFromLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentsLink2FirstDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getDocumentsLinkFromLink() {
	if (documentsLinkFromLink == null)
		documentsLinkFromLink = new DocumentToDocumentsLinkFromLink(this);
	return documentsLinkFromLink;
}
/**
 * This method was generated for supporting the association named DocumentsLink2DocumentTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getDocumentsLinkTo() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getDocumentsLinkToLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named DocumentsLink2DocumentTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getDocumentsLinkToLink() {
	if (documentsLinkToLink == null)
		documentsLinkToLink = new DocumentToDocumentsLinkToLink(this);
	return documentsLinkToLink;
}
/**
 * Getter method for documentState
 */
public java.lang.String getDocumentState() {
	return documentState;
}
/**
 * getEntityContext method comment
 * @return javax.ejb.EntityContext
 */
public javax.ejb.EntityContext getEntityContext() {
	return entityContext;
}
/**
 * This method was generated for supporting the association named Document2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlace getFrom() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StoragePlace)this.getFromLink().value();
}
/**
 * This method was generated for supporting the association named Document2StrorageFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getFromKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean from_NULLTEST = true;
	from_NULLTEST &= (from_storageplace == null);
	temp.storageplace = ((from_storageplace == null) ? 0 : from_storageplace.intValue());
	if (from_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Document2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getFromLink() {
	if (fromLink == null)
		fromLink = new DocumentToFromLink(this);
	return fromLink;
}
/**
 * Getter method for insuranceact
 */
public java.lang.String getInsuranceact() {
	return insuranceact;
}
/**
 * Getter method for insurancedate
 */
public java.sql.Date getInsurancedate() {
	return insurancedate;
}
/**
 * Getter method for insuranseMan
 */
public java.lang.String getInsuranseMan() {
	return insuranseMan;
}
/**
 * Getter method for isautodoc
 */
public boolean getIsautodoc() {
	return isautodoc;
}
/**
 * Getter method for needapprove
 */
public boolean getNeedapprove() {
	return needapprove;
}
/**
 * Getter method for operator
 */
public java.lang.Integer getOperator() {
	return operator;
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOwner() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Organization)this.getOwnerLink().value();
}
/**
 * This method was generated for supporting the association named Document2Owner.  
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
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getOwnerLink() {
	if (ownerLink == null)
		ownerLink = new DocumentToOwnerLink(this);
	return ownerLink;
}
/**
 * Getter method for parentdocument
 */
public java.lang.Integer getParentdocument() {
	return parentdocument;
}
/**
 * Getter method for processDestination
 */
public java.lang.Boolean getProcessDestination() {
	return processDestination;
}
/**
 * Getter method for processSource
 */
public java.lang.Boolean getProcessSource() {
	return processSource;
}
/**
 * Getter method for showtouser
 */
public boolean getShowtouser() {
	return showtouser;
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return this.getStorageCardLink().enumerationValue();
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.ManyLink getStorageCardLink() {
	if (storageCardLink == null)
		storageCardLink = new DocumentToStorageCardLink(this);
	return storageCardLink;
}
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getStorageManager() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Worker)this.getStorageManagerLink().value();
}
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.WorkerKey getStorageManagerKey() {
	com.hps.july.persistence.WorkerKey temp = null;
	temp = new com.hps.july.persistence.WorkerKey();
	boolean storageManager_NULLTEST = true;
	storageManager_NULLTEST &= (storageManager_worker == null);
	temp.worker = ((storageManager_worker == null) ? 0 : storageManager_worker.intValue());
	if (storageManager_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getStorageManagerLink() {
	if (storageManagerLink == null)
		storageManagerLink = new DocumentToStorageManagerLink(this);
	return storageManagerLink;
}
/**
 * This method was generated for supporting the association named Document2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlace getTo() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.StoragePlace)this.getToLink().value();
}
/**
 * Getter method for to2
 */
public java.lang.Integer getTo2() {
	return to2;
}
/**
 * This method was generated for supporting the association named Document2StoragePlaceTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getToKey() {
	com.hps.july.persistence.StoragePlaceKey temp = null;
	temp = new com.hps.july.persistence.StoragePlaceKey();
	boolean to_NULLTEST = true;
	to_NULLTEST &= (to_storageplace == null);
	temp.storageplace = ((to_storageplace == null) ? 0 : to_storageplace.intValue());
	if (to_NULLTEST) temp = null;
	return temp;
}
/**
 * This method was generated for supporting the association named Document2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getToLink() {
	if (toLink == null)
		toLink = new DocumentToToLink(this);
	return toLink;
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetContragentKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean contragent_NULLTEST = (inKey == null);
	if (contragent_NULLTEST) contragent_organization = null; else contragent_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named Document2StrorageFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetFromKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean from_NULLTEST = (inKey == null);
	if (from_NULLTEST) from_storageplace = null; else from_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetOwnerKey(com.hps.july.persistence.OrganizationKey inKey) {
	boolean owner_NULLTEST = (inKey == null);
	if (owner_NULLTEST) owner_organization = null; else owner_organization = (new Integer(inKey.organization));
}
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetStorageManagerKey(com.hps.july.persistence.WorkerKey inKey) {
	boolean storageManager_NULLTEST = (inKey == null);
	if (storageManager_NULLTEST) storageManager_worker = null; else storageManager_worker = (new Integer(inKey.worker));
}
/**
 * This method was generated for supporting the association named Document2StoragePlaceTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetToKey(com.hps.july.persistence.StoragePlaceKey inKey) {
	boolean to_NULLTEST = (inKey == null);
	if (to_NULLTEST) to_storageplace = null; else to_storageplace = (new Integer(inKey.storageplace));
}
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCardTrack(com.hps.july.persistence.CardTrack aCardTrack) {
	this.getCardTrackLink().secondaryAddElement(aCardTrack);
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCurrentStorageCard(com.hps.july.persistence.StorageCard aCurrentStorageCard) {
	this.getCurrentStorageCardLink().secondaryAddElement(aCurrentStorageCard);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) {
	this.getDocumentPositionLink().secondaryAddElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named DocumentsLink2FirstDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddDocumentsLinkFrom(com.hps.july.persistence.DocumentsLink aDocumentsLinkFrom) {
	this.getDocumentsLinkFromLink().secondaryAddElement(aDocumentsLinkFrom);
}
/**
 * This method was generated for supporting the association named DocumentsLink2DocumentTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddDocumentsLinkTo(com.hps.july.persistence.DocumentsLink aDocumentsLinkTo) {
	this.getDocumentsLinkToLink().secondaryAddElement(aDocumentsLinkTo);
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) {
	this.getStorageCardLink().secondaryAddElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCardTrack(com.hps.july.persistence.CardTrack aCardTrack) {
	this.getCardTrackLink().secondaryRemoveElement(aCardTrack);
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCurrentStorageCard(com.hps.july.persistence.StorageCard aCurrentStorageCard) {
	this.getCurrentStorageCardLink().secondaryRemoveElement(aCurrentStorageCard);
}
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveDocumentPosition(com.hps.july.persistence.DocumentPosition aDocumentPosition) {
	this.getDocumentPositionLink().secondaryRemoveElement(aDocumentPosition);
}
/**
 * This method was generated for supporting the association named DocumentsLink2FirstDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveDocumentsLinkFrom(com.hps.july.persistence.DocumentsLink aDocumentsLinkFrom) {
	this.getDocumentsLinkFromLink().secondaryRemoveElement(aDocumentsLinkFrom);
}
/**
 * This method was generated for supporting the association named DocumentsLink2DocumentTo.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveDocumentsLinkTo(com.hps.july.persistence.DocumentsLink aDocumentsLinkTo) {
	this.getDocumentsLinkToLink().secondaryRemoveElement(aDocumentsLinkTo);
}
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) {
	this.getStorageCardLink().secondaryRemoveElement(aStorageCard);
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetContragent(com.hps.july.persistence.Organization aContragent) throws java.rmi.RemoteException {
	this.getContragentLink().secondarySet(aContragent);
}
/**
 * This method was generated for supporting the association named Document2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetFrom(com.hps.july.persistence.StoragePlace aFrom) throws java.rmi.RemoteException {
	this.getFromLink().secondarySet(aFrom);
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException {
	this.getOwnerLink().secondarySet(anOwner);
}
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetStorageManager(com.hps.july.persistence.Worker aStorageManager) throws java.rmi.RemoteException {
	this.getStorageManagerLink().secondarySet(aStorageManager);
}
/**
 * This method was generated for supporting the association named Document2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetTo(com.hps.july.persistence.StoragePlace aTo) throws java.rmi.RemoteException {
	this.getToLink().secondarySet(aTo);
}
/**
 * Setter method for blankdate
 * @param newValue java.sql.Date
 */
public void setBlankdate(java.sql.Date newValue) {
	this.blankdate = newValue;
}
/**
 * Setter method for blankindex
 */
public void setBlankindex(int newValue) {
	this.blankindex = newValue;
}
/**
 * Setter method for blanknumber
 * @param newValue java.lang.String
 */
public void setBlanknumber(java.lang.String newValue) {
	this.blanknumber = newValue;
}
/**
 * This method was generated for supporting the association named Document2Contragent.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setContragent(com.hps.july.persistence.Organization aContragent) throws java.rmi.RemoteException {
	this.getContragentLink().set(aContragent);
}
/**
 * Insert the method's description here.
 * Creation date: (24.04.2002 15:29:13)
 * @param newDocument int
 */
public void setDocument(int newDocument) {
	document = newDocument;
}
/**
 * Setter method for documentState
 */
public void setDocumentState(java.lang.String newValue) {
	this.documentState = newValue;
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
 * This method was generated for supporting the association named Document2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setFrom(com.hps.july.persistence.StoragePlace aFrom) throws java.rmi.RemoteException {
	this.getFromLink().set(aFrom);
}
/**
 * Setter method for insuranceact
 */
public void setInsuranceact(java.lang.String newValue) {
	this.insuranceact = newValue;
}
/**
 * Setter method for insurancedate
 */
public void setInsurancedate(java.sql.Date newValue) {
	this.insurancedate = newValue;
}
/**
 * Setter method for insuranseMan
 */
public void setInsuranseMan(java.lang.String newValue) {
	this.insuranseMan = newValue;
}
/**
 * Setter method for isautodoc
 */
public void setIsautodoc(boolean newValue) {
	this.isautodoc = newValue;
}
/**
 * Setter method for needapprove
 */
public void setNeedapprove(boolean newValue) {
	this.needapprove = newValue;
}
private void setOperator() throws java.rmi.RemoteException{
	try{
		String operatorName = entityContext.getCallerIdentity().getName();
		int index = operatorName.indexOf("/");
		if(index != -1)
			operatorName = operatorName.substring(index+1);
//System.out.println("Document operatorName="+operatorName+"=");	
			tempOperator = new OperatorAccessBean().findByLogin(operatorName).getOperator();

			setOperator(new Integer(tempOperator));
//System.out.println("Document operatorValue="+operator);
	}catch(Exception e){
		setOperator(null);
		System.out.println("Document Не могу присвоить значение полю operator");
		//e.printStackTrace();
	}
}
/**
 * Setter method for operator
 */
public void setOperator(java.lang.Integer newValue) {
	this.operator = newValue;
}
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException {
	this.getOwnerLink().set(anOwner);
}
/**
 * Setter method for parentdocument
 */
public void setParentdocument(java.lang.Integer newValue) {
	this.parentdocument = newValue;
}
/**
 * Setter method for processDestination
 */
public void setProcessDestination(java.lang.Boolean newValue) {
	this.processDestination = newValue;
}
/**
 * Setter method for processSource
 */
public void setProcessSource(java.lang.Boolean newValue) {
	this.processSource = newValue;
}
/**
 * Setter method for showtouser
 */
public void setShowtouser(boolean newValue) {
	this.showtouser = newValue;
}
/**
 * This method was generated for supporting the association named Document2Storager.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setStorageManager(com.hps.july.persistence.Worker aStorageManager) throws java.rmi.RemoteException {
	this.getStorageManagerLink().set(aStorageManager);
}
/**
 * This method was generated for supporting the association named Document2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setTo(com.hps.july.persistence.StoragePlace aTo) throws java.rmi.RemoteException {
	this.getToLink().set(aTo);
}
/**
 * Setter method for to2
 */
public void setTo2(java.lang.Integer newValue) {
	this.to2 = newValue;
}
/**
 * unsetEntityContext method comment
 * @exception java.rmi.RemoteException The exception description.
 */
public void unsetEntityContext() throws java.rmi.RemoteException {
	entityContext = null;
}
	/**
	 * Get accessor for persistent attribute: projectid
	 */
	public java.lang.Integer getProjectid() {
		return projectid;
	}
	/**
	 * Set accessor for persistent attribute: projectid
	 */
	public void setProjectid(java.lang.Integer newProjectid) {
		projectid = newProjectid;
	}
	/**
	 * Get accessor for persistent attribute: prjstatus
	 */
	public java.lang.String getPrjstatus() {
		return prjstatus;
	}
	/**
	 * Set accessor for persistent attribute: prjstatus
	 */
	public void setPrjstatus(java.lang.String newPrjstatus) {
		prjstatus = newPrjstatus;
	}
	/**
	 * Get accessor for persistent attribute: visualtype
	 */
	public java.lang.Integer getVisualtype() {
		return visualtype;
	}
	/**
	 * Set accessor for persistent attribute: visualtype
	 */
	public void setVisualtype(java.lang.Integer newVisualtype) {
		visualtype = newVisualtype;
	}
}
