package com.hps.july.persistence;

import java.rmi.RemoteException;
import java.security.Identity;
import java.util.Properties;
import javax.ejb.*;
/**
 * This is an Entity Bean class with CMP fields
 * Позиция акта инвентаризации
 */
public class I13nActPositionBean extends DocumentPositionBean {
	public Boolean contentsScanned;
	public String note;
	private final static long serialVersionUID = 3206093459760846163L;
	public java.lang.Integer contract_document;
	private transient com.ibm.ivj.ejb.associations.interfaces.SingleLink contractLink = null;
	public String positionState;
	public String cordocnum;
	/**
	 * _copyFromEJB
	 */
	public java.util.Hashtable _copyFromEJB() {
		com.ibm.ivj.ejb.runtime.AccessBeanHashtable h =
			new com.ibm.ivj.ejb.runtime.AccessBeanHashtable();

		h.put("cordocnum", getCordocnum());
		h.put("note", getNote());
		h.put("contractKey", getContractKey());
		h.put("positionState", getPositionState());
		h.put("contentsScanned", getContentsScanned());
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
		h.put("parentbtsdocpos", getParentbtsdocpos());
		h.put("oldagrmanufserial", getOldagrmanufserial());
		h.put("agrlocserial", getAgrlocserial());
		h.put("localserial", getLocalserial());
		h.put("agrmanufserial", getAgrmanufserial());
		h.put("__Key", getEntityContext().getPrimaryKey());

		return h;
	}
	/**
	 * _copyToEJB
	 */
	public void _copyToEJB(java.util.Hashtable h) {
		java.lang.String localCordocnum = (java.lang.String) h.get("cordocnum");
		java.lang.String localNote = (java.lang.String) h.get("note");
		java.lang.String localPositionState =
			(java.lang.String) h.get("positionState");
		java.lang.Boolean localContentsScanned =
			(java.lang.Boolean) h.get("contentsScanned");
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
		java.lang.Integer localParentbtsdocpos =
			(java.lang.Integer) h.get("parentbtsdocpos");
		java.lang.String localOldagrmanufserial =
			(java.lang.String) h.get("oldagrmanufserial");
		java.lang.String localAgrlocserial =
			(java.lang.String) h.get("agrlocserial");
		java.lang.String localLocalserial =
			(java.lang.String) h.get("localserial");
		java.lang.String localAgrmanufserial =
			(java.lang.String) h.get("agrmanufserial");

		if (h.containsKey("cordocnum"))
			setCordocnum((localCordocnum));
		if (h.containsKey("note"))
			setNote((localNote));
		if (h.containsKey("positionState"))
			setPositionState((localPositionState));
		if (h.containsKey("contentsScanned"))
			setContentsScanned((localContentsScanned));
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
		if (h.containsKey("parentbtsdocpos"))
			setParentbtsdocpos((localParentbtsdocpos));
		if (h.containsKey("oldagrmanufserial"))
			setOldagrmanufserial((localOldagrmanufserial));
		if (h.containsKey("agrlocserial"))
			setAgrlocserial((localAgrlocserial));
		if (h.containsKey("localserial"))
			setLocalserial((localLocalserial));
		if (h.containsKey("agrmanufserial"))
			setAgrmanufserial((localAgrmanufserial));
	}
/**
 * This method was generated for supporting the associations.
 * @return java.util.Vector
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected java.util.Vector _getLinks() {
	java.util.Vector links = super._getLinks();
	links.addElement(getContractLink());
	return links;
}
/**
 * This method was generated for supporting the associations.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected void _initLinks() {
	super._initLinks();
	contractLink = null;
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
	String argState, Boolean argSourceClosed, Boolean argResultClosed ) throws javax.ejb.CreateException, java.rmi.RemoteException {

	super.ejbCreate(argDocposition, argResource, argOwner, argDocument, 
	argOrder, argQty, argPrice, 
	argSourceBoxed, argResultBoxed, argSourceBroken , argResultBroken, argSourceClosed, argResultClosed );
	
	_initLinks();
	// All CMP fields should be initialized here.
	contentsScanned = null;
	note = null;
	contract_document = null;
	positionState = null;
	cordocnum = null;

	positionState = argState;
	
}
/**
 * Getter method for contentsScanned
 * @return java.lang.Boolean
 */
public java.lang.Boolean getContentsScanned() {
	return contentsScanned;
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Contract getContract() throws java.rmi.RemoteException, javax.ejb.FinderException {
	return (com.hps.july.persistence.Contract)this.getContractLink().value();
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
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
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
protected com.ibm.ivj.ejb.associations.interfaces.SingleLink getContractLink() {
	if (contractLink == null)
		contractLink = new I13nActPositionToContractLink(this);
	return contractLink;
}
/**
 * Getter method for cordocnum
 */
public java.lang.String getCordocnum() {
	return cordocnum;
}
/**
 * Getter method for note
 * @return java.lang.String
 */
public java.lang.String getNote() {
	return note;
}
/**
 * Getter method for positionState
 */
public java.lang.String getPositionState() {
	return positionState;
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetContractKey(com.hps.july.persistence.DocumentKey inKey) {
	boolean contract_NULLTEST = (inKey == null);
	if (contract_NULLTEST) contract_document = null; else contract_document = (new Integer(inKey.document));
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException {
	this.getContractLink().secondarySet(aContract);
}
/**
 * Setter method for contentsScanned
 * @param newValue java.lang.Boolean
 */
public void setContentsScanned(java.lang.Boolean newValue) {
	this.contentsScanned = newValue;
}
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException {
	this.getContractLink().set(aContract);
}
/**
 * Setter method for cordocnum
 */
public void setCordocnum(java.lang.String newValue) {
	this.cordocnum = newValue;
}
/**
 * Setter method for note
 * @param newValue java.lang.String
 */
public void setNote(java.lang.String newValue) {
	this.note = newValue;
}
/**
 * Setter method for positionState
 */
public void setPositionState(java.lang.String newValue) {
	this.positionState = newValue;
}
}
