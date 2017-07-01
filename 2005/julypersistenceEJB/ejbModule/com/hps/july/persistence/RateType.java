package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface RateType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Currency getBasecurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CurrencyKey getBasecurrencyKey() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Rates2RateType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRate() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getRatetype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetBasecurrencyKey(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Rates2RateType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRate(com.hps.july.persistence.Rate aRate) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Rates2RateType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRate(com.hps.july.persistence.Rate aRate) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetBasecurrency(com.hps.july.persistence.Currency aBasecurrency) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named RateTypes2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setBasecurrency(com.hps.july.persistence.Currency aBasecurrency) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newRatetype int
 * @exception String The exception description.
 */
void setRatetype(int newRatetype) throws java.rmi.RemoteException;
}
