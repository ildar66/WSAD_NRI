package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface KzlNetzones2NRIHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.KzlNetzones2NRI
 * @param argKzlregionid int
 * @param argNetzone int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.KzlNetzones2NRI create(int argKzlregionid, int argNetzone) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.KzlNetzones2NRI
 * @param key com.hps.july.persistence2.KzlNetzones2NRIKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.KzlNetzones2NRI findByPrimaryKey(com.hps.july.persistence2.KzlNetzones2NRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
