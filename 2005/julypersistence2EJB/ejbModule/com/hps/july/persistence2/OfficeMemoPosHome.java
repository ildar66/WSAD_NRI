package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface OfficeMemoPosHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.OfficeMemoPos
 * @param argIdpos int
 * @param argIdHeader int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.OfficeMemoPos create(int argIdpos, int argIdHeader) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.OfficeMemoPos
 * @param key com.hps.july.persistence2.OfficeMemoPosKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.OfficeMemoPos findByPrimaryKey(com.hps.july.persistence2.OfficeMemoPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
