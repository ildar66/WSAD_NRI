package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface CurrencyHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Currency
 * @param argCurrency int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Currency create(int argCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Currency
 * @param argCurrency int
 * @param argName java.lang.String
 * @param argShortName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Currency create(int argCurrency, java.lang.String argName, java.lang.String argShortName) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByConnectedOrderByNameAsc(Integer argConnected) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Currency
 * @param key com.hps.july.persistence.CurrencyKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Currency findByPrimaryKey(com.hps.july.persistence.CurrencyKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
