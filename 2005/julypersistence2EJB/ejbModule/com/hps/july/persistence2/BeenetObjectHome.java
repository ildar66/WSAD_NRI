package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface BeenetObjectHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.BeenetObject
 * @param argBeenetid java.lang.String
 * @param argCategId int
 * @param argPosition int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.BeenetObject create(java.lang.String argBeenetid, int argCategId, int argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.BeenetObject
 * @param key com.hps.july.persistence2.BeenetObjectKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.BeenetObject findByPrimaryKey(com.hps.july.persistence2.BeenetObjectKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
