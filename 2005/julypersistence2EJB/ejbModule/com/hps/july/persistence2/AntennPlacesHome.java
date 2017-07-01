package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AntennPlacesHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.AntennPlaces
 * @param argAntplaceid int
 * @param argName java.lang.String
 * @param argIsVc boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.AntennPlaces create(int argAntplaceid, java.lang.String argName, boolean argIsVc) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.AntennPlaces
 * @param key com.hps.july.persistence2.AntennPlacesKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.AntennPlaces findByPrimaryKey(com.hps.july.persistence2.AntennPlacesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
