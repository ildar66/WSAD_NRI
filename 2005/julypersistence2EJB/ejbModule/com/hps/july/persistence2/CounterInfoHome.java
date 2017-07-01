package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface CounterInfoHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence2.CounterInfo
 * @param argId int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence2.CounterInfo create(int argId) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.CounterInfo
 * @param key com.hps.july.persistence2.CounterInfoKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.CounterInfo findByPrimaryKey(com.hps.july.persistence2.CounterInfoKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
