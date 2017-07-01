package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseRule extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocument getLeaseDocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getLeaseDocumentKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLeaseRule() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLeaseDocumentKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetLeaseDocument(com.hps.july.persistence.LeaseDocument aLeaseDocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseRule2leasedoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setLeaseDocument(com.hps.july.persistence.LeaseDocument aLeaseDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newLeaseRule int
 * @exception String The exception description.
 */
void setLeaseRule(int newLeaseRule) throws java.rmi.RemoteException;
}
