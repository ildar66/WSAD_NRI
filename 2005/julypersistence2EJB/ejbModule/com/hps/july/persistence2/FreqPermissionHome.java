package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface FreqPermissionHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence2.FreqPermission
 * @param argFreqpermid int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence2.FreqPermission create(int argFreqpermid) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.FreqPermission
 * @param key com.hps.july.persistence2.FreqPermissionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.FreqPermission findByPrimaryKey(com.hps.july.persistence2.FreqPermissionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
