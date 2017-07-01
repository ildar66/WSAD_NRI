package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AbonPays2docpos extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named AbonPays2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPosition getLeasedocposition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2docpos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPositionKey getLeasedocpositionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonentPayment getPaypos() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.AbonentPaymentKey getPayposKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPayposKey(com.hps.july.persistence.AbonentPaymentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPaypos(com.hps.july.persistence.AbonentPayment aPaypos) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonPays2docpos2pays.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPaypos(com.hps.july.persistence.AbonentPayment aPaypos) throws java.rmi.RemoteException;
}
