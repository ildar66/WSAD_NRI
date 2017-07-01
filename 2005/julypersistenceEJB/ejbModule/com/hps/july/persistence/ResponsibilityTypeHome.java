package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ResponsibilityTypeHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.ResponsibilityType
 * @param argResponsibilityType int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ResponsibilityType create(int argResponsibilityType) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ResponsibilityType
 * @param argResponsibilityType int
 * @param argName java.lang.String
 * @param argIsPrint java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ResponsibilityType create(int argResponsibilityType, java.lang.String argName, java.lang.Boolean argIsPrint) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ResponsibilityType
 * @param key com.hps.july.persistence.ResponsibilityTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ResponsibilityType
 * @param key com.hps.july.persistence.ResponsibilityTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ResponsibilityType findByPrimaryKey(com.hps.july.persistence.ResponsibilityTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
