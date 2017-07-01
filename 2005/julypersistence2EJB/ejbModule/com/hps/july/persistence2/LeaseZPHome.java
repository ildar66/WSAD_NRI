package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseZPHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.LeaseZP
 * @param argIdzpnfs int
 * @param argLeasedocposition int
 * @param argIsActive boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.LeaseZP create(int argIdzpnfs, int argLeasedocposition, boolean argIsActive) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.LeaseZP
 * @param key com.hps.july.persistence2.LeaseZPKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.LeaseZP findByPrimaryKey(com.hps.july.persistence2.LeaseZPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
