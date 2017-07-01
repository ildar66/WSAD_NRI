package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface MSUserHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.MSUser
 * @param argMsucode int
 * @param argMsUser java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.MSUser create(int argMsucode, java.lang.String argMsUser) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.MSUser
 * @param key com.hps.july.persistence2.MSUserKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.MSUser findByPrimaryKey(com.hps.july.persistence2.MSUserKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
