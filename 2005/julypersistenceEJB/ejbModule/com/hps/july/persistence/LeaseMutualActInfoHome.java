package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseMutualActInfoHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.LeaseMutualActInfo
 * @param argLeasedocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseMutualActInfo create(int argLeasedocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseMutualActInfo
 * @param key com.hps.july.persistence.LeaseMutualActInfoKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseMutualActInfo findByPrimaryKey(com.hps.july.persistence.LeaseMutualActInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
