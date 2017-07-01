package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectTypeHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.ProjectType
 * @param argProjecttype int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ProjectType create(int argProjecttype) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ProjectType
 * @param argProjecttype int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProjectType create(int argProjecttype, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProjectType
 * @param key com.hps.july.persistence.ProjectTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProjectType findByPrimaryKey(com.hps.july.persistence.ProjectTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
