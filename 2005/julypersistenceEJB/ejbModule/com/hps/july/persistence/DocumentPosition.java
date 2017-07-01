package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface DocumentPosition extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addAgregateParts(com.hps.july.persistence.DocumentPosition anAgregateParts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DocumentPosition getAgregate() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DocumentPositionKey getAgregateKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAgregateParts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getAgregateresource() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getAgregateSerial() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StorageCard getCardFrom() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StorageCardKey getCardFromKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StorageCard getCardTo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StorageCardKey getCardToKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getComment() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getConfiguration() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDocposition() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Document getDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DocumentKey getDocumentKey() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getIsfictserial() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getIsReadOnly() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getManufserial() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNewplace() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNotes() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOldagregateresource() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getOldAgregateSerial() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getOldplace() throws java.rmi.RemoteException;
/**
 * Getter method for order
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOrder() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOwner() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OrganizationKey getOwnerKey() throws java.rmi.RemoteException;
/**
 * Getter method for party
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getParty() throws java.rmi.RemoteException;
/**
 * Getter method for price
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getPrice() throws java.rmi.RemoteException;
/**
 * Getter method for qty
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getQty() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getRealserial() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getResultBoxed() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getResultBroken() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getResultClosed() throws java.rmi.RemoteException;
/**
 * Getter method for serialnumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSerialnumber() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSourceBoxed() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSourceBroken() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getSourceClosed() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getSum() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetAgregateKey(com.hps.july.persistence.DocumentPositionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCardFromKey(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCardToKey(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDocumentKey(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOwnerKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAgregateParts(com.hps.july.persistence.DocumentPosition anAgregateParts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAgregateParts(com.hps.july.persistence.DocumentPosition anAgregateParts) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAgregate(com.hps.july.persistence.DocumentPosition anAgregate) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCardFrom(com.hps.july.persistence.StorageCard aCardFrom) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCardTo(com.hps.july.persistence.StorageCard aCardTo) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDocument(com.hps.july.persistence.Document aDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAgregate(com.hps.july.persistence.DocumentPosition anAgregate) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setAgregateresource(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setAgregateSerial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCardFrom(com.hps.july.persistence.StorageCard aCardFrom) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCardTo(com.hps.july.persistence.StorageCard aCardTo) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setComment(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setConfiguration(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newDocposition int
 * @exception String The exception description.
 */
void setDocposition(int newDocposition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDocument(com.hps.july.persistence.Document aDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setIsfictserial(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setManufserial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNewplace(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNotes(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setOldagregateresource(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setOldAgregateSerial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setOldplace(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for order
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOrder(int newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException;
/**
 * Setter method for party
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setParty(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for price
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setPrice(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for qty
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setQty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setRealserial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setResultBoxed(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setResultBroken(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setResultClosed(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for serialnumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSerialnumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setSourceBoxed(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setSourceBroken(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setSourceClosed(java.lang.Boolean newValue) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: visualtagid
	 */
	public java.lang.Integer getVisualtagid() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: visualtagid
	 */
	public void setVisualtagid(java.lang.Integer newVisualtagid)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: localserial
	 */
	public java.lang.String getLocalserial() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: localserial
	 */
	public void setLocalserial(java.lang.String newLocalserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: agrmanufserial
	 */
	public java.lang.String getAgrmanufserial()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: agrmanufserial
	 */
	public void setAgrmanufserial(java.lang.String newAgrmanufserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: agrlocserial
	 */
	public java.lang.String getAgrlocserial() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: agrlocserial
	 */
	public void setAgrlocserial(java.lang.String newAgrlocserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: oldagrmanufserial
	 */
	public java.lang.String getOldagrmanufserial()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: oldagrmanufserial
	 */
	public void setOldagrmanufserial(java.lang.String newOldagrmanufserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: oldagrlocserial
	 */
	public java.lang.String getOldagrlocserial()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: oldagrlocserial
	 */
	public void setOldagrlocserial(java.lang.String newOldagrlocserial)
		throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: parentbtsdocpos
	 */
	public java.lang.Integer getParentbtsdocpos()
		throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: parentbtsdocpos
	 */
	public void setParentbtsdocpos(java.lang.Integer newParentbtsdocpos)
		throws java.rmi.RemoteException;
}
