package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SuperRegionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.SuperRegion
 * @param argSupregid int
 * @param argSupregname java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SuperRegion create(int argSupregid, java.lang.String argSupregname) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.SuperRegion
 * @param argSupregid int
 * @param argSupregname java.lang.String
 * @param argSupregcode int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SuperRegion create(int argSupregid, java.lang.String argSupregname, int argSupregcode) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SuperRegion
 * @param key com.hps.july.persistence.SuperRegionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SuperRegion findByPrimaryKey(com.hps.july.persistence.SuperRegionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
