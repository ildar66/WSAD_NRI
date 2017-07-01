package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseCalcRate extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseMutualActNew getAct() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getActKey() throws java.rmi.RemoteException;
/**
 * Getter method for byhand
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getByhand() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Currency getCurrency() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.CurrencyKey getCurrencyKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2docposition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPosition getDocposition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2docposition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.LeaseDocPositionKey getDocpositionKey() throws java.rmi.RemoteException;
/**
 * Getter method for rate
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getRate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetActKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAct(com.hps.july.persistence.LeaseMutualActNew anAct) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAct(com.hps.july.persistence.LeaseMutualActNew anAct) throws java.rmi.RemoteException;
/**
 * Setter method for byhand
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setByhand(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for rate
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setRate(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
