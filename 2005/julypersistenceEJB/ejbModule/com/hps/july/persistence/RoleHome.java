package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface RoleHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Role
 * @param argRole java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Role create(java.lang.String argRole) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Role
 * @param argRole java.lang.String
 * @param argRoleName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Role create(java.lang.String argRole, java.lang.String argRoleName) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Role
 * @param key com.hps.july.persistence.RoleKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Role findByPrimaryKey(com.hps.july.persistence.RoleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
