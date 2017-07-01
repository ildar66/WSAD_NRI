package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: PayOffAct
 */
public interface PayOffAct extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getChairMan() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getChairManKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getMember1() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getMember1Key() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getMember2() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getMember2Key() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetChairManKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetMember1Key(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetMember2Key(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetChairMan(com.hps.july.persistence.Worker aChairMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMember1(com.hps.july.persistence.Worker aMember1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMember2(com.hps.july.persistence.Worker aMember2) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setChairMan(com.hps.july.persistence.Worker aChairMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMember1(com.hps.july.persistence.Worker aMember1) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMember2(com.hps.july.persistence.Worker aMember2) throws java.rmi.RemoteException;
}
