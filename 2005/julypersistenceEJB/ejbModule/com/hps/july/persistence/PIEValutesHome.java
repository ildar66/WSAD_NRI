package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEValutesHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEValutes
 * @param argIdvaluteplatinum java.lang.String
 * @param argPStatus java.lang.String
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEValutes create(java.lang.String argIdvaluteplatinum, java.lang.String argPStatus, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByidvalutenriOrderByCodeAsc(Integer argCurrency) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEValutes
 * @param key com.hps.july.persistence.PIEValutesKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEValutes findByPrimaryKey(com.hps.july.persistence.PIEValutesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
