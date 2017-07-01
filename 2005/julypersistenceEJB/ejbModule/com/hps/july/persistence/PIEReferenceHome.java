package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEReferenceHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEReference
 * @param argIdreference int
 * @param argOwner int
 * @param argIdPlatinum java.lang.String
 * @param argPStatus java.lang.String
 * @param argSprav java.lang.String
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEReference create(int argIdreference, int argOwner, java.lang.String argIdPlatinum, java.lang.String argPStatus, java.lang.String argSprav, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByOwnerAndSpravOrderByNameAsc(Integer argOwner, String argSprav) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEReference
 * @param key com.hps.july.persistence.PIEReferenceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEReference findByPrimaryKey(com.hps.july.persistence.PIEReferenceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findBySpravOrderByCodeAsc(String argSprav) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
