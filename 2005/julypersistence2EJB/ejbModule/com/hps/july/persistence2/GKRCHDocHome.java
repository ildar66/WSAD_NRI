package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface GKRCHDocHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.GKRCHDoc
 * @param argSitedoc int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.GKRCHDoc create(int argSitedoc) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.GKRCHDoc
 * @param key com.hps.july.persistence2.GKRCHDocKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.GKRCHDoc findByPrimaryKey(com.hps.july.persistence2.GKRCHDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
