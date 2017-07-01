package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface CounterHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.Counter
 * @param argCounterid int
 * @param argCounterInfoId int
 * @param argPositionId int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.Counter create(int argCounterid, int argCounterInfoId, int argPositionId) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.Counter
 * @param key com.hps.july.persistence2.CounterKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.Counter findByPrimaryKey(com.hps.july.persistence2.CounterKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
