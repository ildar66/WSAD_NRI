package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface KzlAntennes2NRIHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.KzlAntennes2NRI
 * @param argAntposantennid int
 * @param argResource int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.KzlAntennes2NRI create(int argAntposantennid, int argResource) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.KzlAntennes2NRI
 * @param key com.hps.july.persistence2.KzlAntennes2NRIKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.KzlAntennes2NRI findByPrimaryKey(com.hps.july.persistence2.KzlAntennes2NRIKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
