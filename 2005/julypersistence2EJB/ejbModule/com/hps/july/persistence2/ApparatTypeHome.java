package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ApparatTypeHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.ApparatType
 * @param argAptypeid int
 * @param argName java.lang.String
 * @param argApType java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.ApparatType create(int argAptypeid, java.lang.String argName, java.lang.String argApType) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.ApparatType
 * @param key com.hps.july.persistence2.ApparatTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.ApparatType findByPrimaryKey(com.hps.july.persistence2.ApparatTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
