package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface CardTrack extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getActiontype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getCard() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StorageCardKey getCardKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getConfiguration() throws java.rmi.RemoteException;
/**
 * Getter method for deltaprice
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getDeltaprice() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Document getDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DocumentKey getDocumentKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlace getFrom() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named CardTrack2StrogeFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getFromKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlace getTo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named CardTrack2ToStorage.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getToKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getTrackId() throws java.rmi.RemoteException;
/**
 * Getter method for when
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getWhen() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCardKey(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDocumentKey(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2StrogeFrom.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetFromKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2ToStorage.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetToKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetCard(com.hps.july.persistence.StorageCard aCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetDocument(com.hps.july.persistence.Document aDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetFrom(com.hps.july.persistence.StoragePlace aFrom) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetTo(com.hps.july.persistence.StoragePlace aTo) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setActiontype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Card.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setCard(com.hps.july.persistence.StorageCard aCard) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setConfiguration(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for deltaprice
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setDeltaprice(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2Document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setDocument(com.hps.july.persistence.Document aDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setFrom(com.hps.july.persistence.StoragePlace aFrom) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setTo(com.hps.july.persistence.StoragePlace aTo) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newTrackId int
 * @exception String The exception description.
 */
void setTrackId(int newTrackId) throws java.rmi.RemoteException;
/**
 * Setter method for when
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setWhen(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
}
