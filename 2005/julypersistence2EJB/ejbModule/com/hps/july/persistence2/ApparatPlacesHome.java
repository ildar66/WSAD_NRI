package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ApparatPlacesHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.ApparatPlaces
 * @param argApplaceid int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.ApparatPlaces create(int argApplaceid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.ApparatPlaces
 * @param key com.hps.july.persistence2.ApparatPlacesKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.ApparatPlaces findByPrimaryKey(com.hps.july.persistence2.ApparatPlacesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
