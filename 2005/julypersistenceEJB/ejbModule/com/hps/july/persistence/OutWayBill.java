package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: OutWayBill
 */
public interface OutWayBill extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getCurrencyKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named OutWayBill2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCurrency(com.hps.july.persistence.Currency aCurrency) throws java.rmi.RemoteException;
}
