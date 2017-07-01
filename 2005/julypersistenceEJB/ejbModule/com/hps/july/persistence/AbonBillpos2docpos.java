package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AbonBillpos2docpos extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AbonentBillPos getBillpos() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AbonentBillPosKey getBillposKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPosition getLeasedocposition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPositionKey getLeasedocpositionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetBillposKey(com.hps.july.persistence.AbonentBillPosKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetBillpos(com.hps.july.persistence.AbonentBillPos aBillpos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonBillpos2docpos2billpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setBillpos(com.hps.july.persistence.AbonentBillPos aBillpos) throws java.rmi.RemoteException;
}
