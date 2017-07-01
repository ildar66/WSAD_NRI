package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PhotoBlobHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.PhotoBlob
 * @param argPhoto int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.PhotoBlob create(int argPhoto) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PhotoBlob
 * @param key com.hps.july.persistence.PhotoBlobKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PhotoBlob findByPrimaryKey(com.hps.july.persistence.PhotoBlobKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
