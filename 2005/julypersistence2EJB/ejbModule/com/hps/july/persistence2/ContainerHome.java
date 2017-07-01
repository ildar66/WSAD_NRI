package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ContainerHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.Container
 * @param argContainer int
 * @param argStoragePlace int
 * @param argResource int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.Container create(int argContainer, int argStoragePlace, int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.Container
 * @param key com.hps.july.persistence2.ContainerKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.Container findByPrimaryKey(com.hps.july.persistence2.ContainerKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
