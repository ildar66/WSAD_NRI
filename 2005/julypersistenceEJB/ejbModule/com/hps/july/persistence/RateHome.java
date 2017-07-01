package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface RateHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Rate
 * @param argCurrency com.hps.july.persistence.CurrencyKey
 * @param argType com.hps.july.persistence.RateTypeKey
 * @param argDate java.sql.Date
 * @param argValue java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Rate create(com.hps.july.persistence.CurrencyKey argCurrency, com.hps.july.persistence.RateTypeKey argType, java.sql.Date argDate, java.math.BigDecimal argValue) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Rate
 * @param argDate java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Rate create(java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Rate
 * @param key com.hps.july.persistence.RateKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Rate findByPrimaryKey(com.hps.july.persistence.RateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Rate
 * @param key com.hps.july.persistence.RateKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
public java.util.Enumeration findByTypeAndCurrencyOrderByDateDesc(Integer argType, Integer argCurrency ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Rate
 * @param key com.hps.july.persistence.RateKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Rate findByTypeCurrencyForDate(Integer type, Integer currency, java.sql.Date date ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Rate
 * @param key com.hps.july.persistence.RateKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
public java.util.Enumeration findByTypeDate(Integer type, java.sql.Date date ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Rates2RateType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findRateByType(com.hps.july.persistence.RateTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Rate2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findRatesByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
