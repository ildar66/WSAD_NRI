package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface I13nDateSaving extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.I13nAct getI13nAct() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nDateSaving2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DocumentKey getI13nActKey() throws java.rmi.RemoteException;
/**
 * Getter method for oldI13nDate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getOldI13nDate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getStorageCard() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nDateSaving2StorageCard.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getStorageCardKey() throws java.rmi.RemoteException;
/**
 * Setter method for oldI13nDate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setOldI13nDate(java.sql.Date newValue) throws java.rmi.RemoteException;
}
