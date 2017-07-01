package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Perm2HopHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence2.Perm2Hop
 * @param argFreqpermid int
 * @param argHopsid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence2.Perm2Hop create(int argFreqpermid, int argHopsid) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.Perm2Hop
 * @param key com.hps.july.persistence2.Perm2HopKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.Perm2Hop findByPrimaryKey(com.hps.july.persistence2.Perm2HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
