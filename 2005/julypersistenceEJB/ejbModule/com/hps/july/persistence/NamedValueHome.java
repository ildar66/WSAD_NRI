package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface NamedValueHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.NamedValue
 * @param argId java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.NamedValue create(java.lang.String argId) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.NamedValue
 * @param key com.hps.july.persistence.NamedValueKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.NamedValue findByPrimaryKey(com.hps.july.persistence.NamedValueKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
