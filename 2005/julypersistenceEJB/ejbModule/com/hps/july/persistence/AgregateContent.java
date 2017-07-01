package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AgregateContent extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getAgregate() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getAgregateKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCard getParts() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StorageCardKey getPartsKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @exception String The exception description.
 */
java.math.BigDecimal getQty() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param anAgregate com.hps.july.persistence.StorageCard
 * @exception String The exception description.
 */
void setAgregate(com.hps.july.persistence.StorageCard anAgregate) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param aParts com.hps.july.persistence.StorageCard
 * @exception String The exception description.
 */
void setParts(com.hps.july.persistence.StorageCard aParts) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.math.BigDecimal
 * @exception String The exception description.
 */
void setQty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
