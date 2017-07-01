package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface StorageCard extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addCardTrack(com.hps.july.persistence.CardTrack aCardTrack) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addFaultReports1(com.hps.july.persistence.FaultReport aFaultReports1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addFaultReports2(com.hps.july.persistence.FaultReport aFaultReports2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addI13nAct(com.hps.july.persistence.I13nAct anI13nAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addInDocumentPosition(com.hps.july.persistence.DocumentPosition anInDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addOutDocumentPosition(com.hps.july.persistence.DocumentPosition anOutDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAgregate() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAgregateContent() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getAssemblingAct() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for boxed
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getBoxed() throws java.rmi.RemoteException;
/**
 * Getter method for broken
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getBroken() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCardTrack() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for closed
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getClosed() throws java.rmi.RemoteException;
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
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Contract getContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getContractKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlace getCurrentstorage() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getCurrentstorageKey() throws java.rmi.RemoteException;
/**
 * Getter method for dateclosed
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDateclosed() throws java.rmi.RemoteException;
/**
 * Getter method for dateopened
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDateopened() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getFaultReports1() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getFaultReports2() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getI13nAct() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getI13nDate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getI13nDateSaving() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getInDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getIsfictserial() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Document getLastDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DocumentKey getLastDocumentKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getManufserial() throws java.rmi.RemoteException;
/**
 * Getter method for notes
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNotes() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getOutDocumentPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOwner() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
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
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPlace() throws java.rmi.RemoteException;
/**
 * Getter method for policy
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPolicy() throws java.rmi.RemoteException;
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
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getQtyBroken() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * Getter method for serialnumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSerialnumber() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getStoragecard() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetContractKey(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCurrentstorageKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLastDocumentKey(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOwnerKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeFaultReports1(com.hps.july.persistence.FaultReport aFaultReports1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeFaultReports2(com.hps.july.persistence.FaultReport aFaultReports2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAgregate(com.hps.july.persistence.AgregateContent anAgregate) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAgregateContent(com.hps.july.persistence.AgregateContent anAgregateContent) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCardTrack(com.hps.july.persistence.CardTrack aCardTrack) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddFaultReports1(com.hps.july.persistence.FaultReport aFaultReports1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddFaultReports2(com.hps.july.persistence.FaultReport aFaultReports2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddI13nAct(com.hps.july.persistence.I13nAct anI13nAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddInDocumentPosition(com.hps.july.persistence.DocumentPosition anInDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddOutDocumentPosition(com.hps.july.persistence.DocumentPosition anOutDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAgregate(com.hps.july.persistence.AgregateContent anAgregate) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAgregateContent(com.hps.july.persistence.AgregateContent anAgregateContent) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AssemblingAct2Agregat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveAssemblingAct(com.hps.july.persistence.AssemblingAct anAssemblingAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCardTrack(com.hps.july.persistence.CardTrack aCardTrack) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveFaultReports1(com.hps.july.persistence.FaultReport aFaultReports1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveFaultReports2(com.hps.july.persistence.FaultReport aFaultReports2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nAct2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveI13nAct(com.hps.july.persistence.I13nAct anI13nAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveI13nDateSaving(com.hps.july.persistence.I13nDateSaving anI13nDateSaving) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveInDocumentPosition(com.hps.july.persistence.DocumentPosition anInDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named DocumentPosition2CardFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveOutDocumentPosition(com.hps.july.persistence.DocumentPosition anOutDocumentPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCurrentstorage(com.hps.july.persistence.StoragePlace aCurrentstorage) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetLastDocument(com.hps.july.persistence.Document aLastDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOwner(com.hps.july.persistence.Organization anOwner) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * Setter method for boxed
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setBoxed(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for broken
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setBroken(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for closed
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setClosed(java.lang.Boolean newValue) throws java.rmi.RemoteException;
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
 * This method was generated for supporting the association named Contract2StorageCards.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCurrentstorage(com.hps.july.persistence.StoragePlace aCurrentstorage) throws java.rmi.RemoteException;
/**
 * Setter method for dateclosed
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDateclosed(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dateopened
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDateopened(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setI13nDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setIsfictserial(boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2LastDocument.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setLastDocument(com.hps.july.persistence.Document aLastDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setManufserial(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for notes
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNotes(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Owner.  
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
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPlace(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for policy
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPolicy(java.lang.String newValue) throws java.rmi.RemoteException;
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
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setQtyBroken(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * Setter method for serialnumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSerialnumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newStoragecard int
 * @exception String The exception description.
 */
void setStoragecard(int newStoragecard) throws java.rmi.RemoteException;
	/**
	 * Get accessor for persistent attribute: isapproved
	 */
	public boolean isIsapproved() throws java.rmi.RemoteException;
	/**
	 * Set accessor for persistent attribute: isapproved
	 */
	public void setIsapproved(boolean newIsapproved)
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
}
