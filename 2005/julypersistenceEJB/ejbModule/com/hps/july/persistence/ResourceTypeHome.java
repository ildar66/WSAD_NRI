package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ResourceTypeHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.ResourceType
 * @param argResourcetype int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ResourceType create(int argResourcetype) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ResourceType
 * @param argResourcetype int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ResourceType create(int argResourcetype, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAll() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ResourceType
 * @param key com.hps.july.persistence.ResourceTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ResourceType findByPrimaryKey(com.hps.july.persistence.ResourceTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
