package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseCalcRateHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseCalcRate
 * @param argDocPosition java.lang.Integer
 * @param argCurrency java.lang.Integer
 * @param argRate java.math.BigDecimal
 * @param argByHand java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseCalcRate create(java.lang.Integer argDocPosition, java.lang.Integer argCurrency, java.math.BigDecimal argRate, java.lang.Boolean argByHand) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findBy_Hand_LeaseDocPosition(String argByHand, Integer argDocPosition) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseCalcRate
 * @param key com.hps.july.persistence.LeaseCalcRateKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseCalcRate findByPrimaryKey(com.hps.july.persistence.LeaseCalcRateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2act.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseCalcRatesByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseCalcRatesByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseCalcRate2docposition.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeaseCalcRatesByDocposition(com.hps.july.persistence.LeaseDocPositionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
