package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SearchGroupHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.SearchGroup
 * @param argSearchgroup int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.SearchGroup create(int argSearchgroup) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.SearchGroup
 * @param argSearchgroup int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SearchGroup create(int argSearchgroup, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SearchGroup
 * @param key com.hps.july.persistence.SearchGroupKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SearchGroup
 * @param key com.hps.july.persistence.SearchGroupKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SearchGroup findByPrimaryKey(com.hps.july.persistence.SearchGroupKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
