package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEDocInfoDocPosHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEDocInfoDocPos
 * @param argDocposition int
 * @param argFlagFullLink boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEDocInfoDocPos create(int argDocposition, boolean argFlagFullLink) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEDocInfoDocPos
 * @param key com.hps.july.persistence.PIEDocInfoDocPosKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEDocInfoDocPos findByPrimaryKey(com.hps.july.persistence.PIEDocInfoDocPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
