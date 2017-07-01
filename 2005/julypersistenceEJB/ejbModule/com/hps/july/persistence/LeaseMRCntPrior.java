package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseMRCntPrior extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseContract getContract1() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getContract1Key() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseContract getContract2() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2contract2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getContract2Key() throws java.rmi.RemoteException;
/**
 * Getter method for priority
 * @return java.lang.Short
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Short getPriority() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseMutualReglament getReglament() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMRCntPrior2reglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocumentKey getReglamentKey() throws java.rmi.RemoteException;
/**
 * Setter method for priority
 * @param newValue java.lang.Short
 * @exception java.rmi.RemoteException The exception description.
 */
void setPriority(java.lang.Short newValue) throws java.rmi.RemoteException;
}
