package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface UnitHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Unit
 * @param argUnit int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Unit create(int argUnit) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Unit
 * @param argUnit int
 * @param argName java.lang.String
 * @param argShortName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Unit create(int argUnit, java.lang.String argName, java.lang.String argShortName) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Unit
 * @param key com.hps.july.persistence.UnitKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Unit findByPrimaryKey(com.hps.july.persistence.UnitKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
