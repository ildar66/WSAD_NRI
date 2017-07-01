package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface WorkPositionHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.WorkPosition
 * @param argWorkposition int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.WorkPosition create(int argWorkposition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.WorkPosition
 * @param argWorkposition int
 * @param argIsactive java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.WorkPosition create(int argWorkposition, java.lang.Boolean argIsactive) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.WorkPosition
 * @param argWorkposition int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.WorkPosition create(int argWorkposition, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.WorkPosition
 * @param key com.hps.july.persistence.WorkPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.WorkPosition findByPrimaryKey(com.hps.july.persistence.WorkPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByQBE(Boolean isIsActive, Boolean isActive, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
