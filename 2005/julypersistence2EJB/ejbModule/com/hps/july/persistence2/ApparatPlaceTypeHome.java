package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ApparatPlaceTypeHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.ApparatPlaceType
 * @param argApplacetypeid int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.ApparatPlaceType create(int argApplacetypeid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.ApparatPlaceType
 * @param key com.hps.july.persistence2.ApparatPlaceTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.ApparatPlaceType findByPrimaryKey(com.hps.july.persistence2.ApparatPlaceTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
