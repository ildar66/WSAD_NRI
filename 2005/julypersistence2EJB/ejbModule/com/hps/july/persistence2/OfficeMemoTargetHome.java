package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface OfficeMemoTargetHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.OfficeMemoTarget
 * @param argIdtarget int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.OfficeMemoTarget create(int argIdtarget, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.OfficeMemoTarget
 * @param key com.hps.july.persistence2.OfficeMemoTargetKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.OfficeMemoTarget findByPrimaryKey(com.hps.july.persistence2.OfficeMemoTargetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
