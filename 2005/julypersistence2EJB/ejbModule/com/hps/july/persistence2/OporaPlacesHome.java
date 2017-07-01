package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface OporaPlacesHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.OporaPlaces
 * @param argOplaceid int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.OporaPlaces create(int argOplaceid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.OporaPlaces
 * @param key com.hps.july.persistence2.OporaPlacesKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.OporaPlaces findByPrimaryKey(com.hps.july.persistence2.OporaPlacesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
