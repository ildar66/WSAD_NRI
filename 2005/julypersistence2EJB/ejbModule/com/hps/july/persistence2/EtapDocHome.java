package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface EtapDocHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.EtapDoc
 * @param argSitedoc int
 * @param argEtapTypeId int
 * @param argFreqPermId int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.EtapDoc create(int argSitedoc, int argEtapTypeId, int argFreqPermId) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.EtapDoc
 * @param key com.hps.july.persistence2.EtapDocKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.EtapDoc findByPrimaryKey(com.hps.july.persistence2.EtapDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
