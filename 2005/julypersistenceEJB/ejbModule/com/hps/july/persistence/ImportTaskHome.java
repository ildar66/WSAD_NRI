package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ImportTaskHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ImportTask
 * @param argImptaskid int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ImportTask create(int argImptaskid, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ImportTask
 * @param key com.hps.july.persistence.ImportTaskKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ImportTask findByPrimaryKey(com.hps.july.persistence.ImportTaskKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
