package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEOtvUserLink extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOtvusernri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEOtvUserPlatinum getOtvuserplatinum() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEOtvUserPlatinumKey getOtvuserplatinumKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOtvuserplatinumKey(com.hps.july.persistence.PIEOtvUserPlatinumKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOtvuserplatinum(com.hps.july.persistence.PIEOtvUserPlatinum anOtvuserplatinum) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOtvuserplatinum(com.hps.july.persistence.PIEOtvUserPlatinum anOtvuserplatinum) throws java.rmi.RemoteException;
}
