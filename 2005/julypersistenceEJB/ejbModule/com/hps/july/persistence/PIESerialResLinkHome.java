package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIESerialResLinkHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIESerialResLink
 * @param argStoragecard int
 * @param argOwner int
 * @param argSerial java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIESerialResLink create(int argStoragecard, int argOwner, java.lang.String argSerial) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PIESerialResLink
 * @param argStoragecard int
 * @param argOwner int
 * @param argSerial java.lang.String
 * @param argIdResPlatinum java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIESerialResLink create(int argStoragecard, int argOwner, java.lang.String argSerial, java.lang.String argIdResPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIESerialResLink
 * @param key com.hps.july.persistence.PIESerialResLinkKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIESerialResLink findByPrimaryKey(com.hps.july.persistence.PIESerialResLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
