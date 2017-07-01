package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEMxranLink extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getMxrannri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEMxranLink2mxran.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEMxranPlatinum getMxranplatinum() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEMxranLink2mxran.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEMxranPlatinumKey getMxranplatinumKey() throws java.rmi.RemoteException;
}
