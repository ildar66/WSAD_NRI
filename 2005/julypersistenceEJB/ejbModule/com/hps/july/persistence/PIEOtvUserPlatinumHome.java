package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEOtvUserPlatinumHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEOtvUserPlatinum
 * @param argOtvuserplatinum java.lang.String
 * @param argPStatus java.lang.String
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEOtvUserPlatinum create(java.lang.String argOtvuserplatinum, java.lang.String argPStatus, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEOtvUserPlatinum
 * @param key com.hps.july.persistence.PIEOtvUserPlatinumKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByNameOrderByNameAsc(String argName) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEOtvUserPlatinum
 * @param key com.hps.july.persistence.PIEOtvUserPlatinumKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByOtvuserPlatinumOrderByNameAsc(String argOtvuser) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEOtvUserPlatinum
 * @param key com.hps.july.persistence.PIEOtvUserPlatinumKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEOtvUserPlatinum findByPrimaryKey(com.hps.july.persistence.PIEOtvUserPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
