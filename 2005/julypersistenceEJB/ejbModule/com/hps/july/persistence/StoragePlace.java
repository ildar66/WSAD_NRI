package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface StoragePlace extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named CardTrack2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addCardTrackFrom(com.hps.july.persistence.CardTrack aCardTrackFrom) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addCardTrackTo(com.hps.july.persistence.CardTrack aCardTrackTo) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addInDocument(com.hps.july.persistence.Document anInDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addOutDocument(com.hps.july.persistence.Document anOutDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * Getter method for address
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getAddress() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCardTrackFrom() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named CardTrack2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getCardTrackTo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for closedate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getClosedate() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getCreated() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getCreatedby() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Division getDivision() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DivisionKey getDivisionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getInDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getModified() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getModifiedby() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOperator() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOutDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Sitedoc2Splace2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSitedoc2Splaces() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getStorageplace() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetDivisionKey(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCardTrackFrom(com.hps.july.persistence.CardTrack aCardTrackFrom) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddCardTrackTo(com.hps.july.persistence.CardTrack aCardTrackTo) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddInDocument(com.hps.july.persistence.Document anInDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOutDocument(com.hps.july.persistence.Document anOutDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sitedoc2Splace2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSitedoc2Splaces(com.hps.july.persistence.Sitedoc2Splace aSitedoc2Splaces) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCardTrackFrom(com.hps.july.persistence.CardTrack aCardTrackFrom) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named CardTrack2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveCardTrackTo(com.hps.july.persistence.CardTrack aCardTrackTo) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2To.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveInDocument(com.hps.july.persistence.Document anInDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Document2From.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOutDocument(com.hps.july.persistence.Document anOutDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sitedoc2Splace2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSitedoc2Splaces(com.hps.july.persistence.Sitedoc2Splace aSitedoc2Splaces) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StorageCard2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveStorageCard(com.hps.july.persistence.StorageCard aStorageCard) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException;
/**
 * Setter method for address
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setAddress(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for closedate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setClosedate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setCreated(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setCreatedby(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setModified(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setModifiedby(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newOperator java.lang.Integer
 * @exception String The exception description.
 */
void setOperator(java.lang.Integer newOperator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newStorageplace int
 * @exception String The exception description.
 */
void setStorageplace(int newStorageplace) throws java.rmi.RemoteException;
}
