package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEDopInfoDocHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEDopInfoDoc
 * @param argDocument int
 * @param argFlagSyncPlatinum boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEDopInfoDoc create(int argDocument, boolean argFlagSyncPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEDopInfoDoc
 * @param key com.hps.july.persistence.PIEDopInfoDocKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEDopInfoDoc findByPrimaryKey(com.hps.july.persistence.PIEDopInfoDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
