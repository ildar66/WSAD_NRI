package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface BeenetCategoryHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.BeenetCategory
 * @param argCategid int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.BeenetCategory create(int argCategid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.BeenetCategory
 * @param key com.hps.july.persistence2.BeenetCategoryKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.BeenetCategory findByPrimaryKey(com.hps.july.persistence2.BeenetCategoryKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
