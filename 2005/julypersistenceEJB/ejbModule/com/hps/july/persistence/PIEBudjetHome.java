package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEBudjetHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEBudjet
 * @param argIdbudjetnri int
 * @param argOwner int
 * @param argIdBudjet java.lang.String
 * @param argNameBudjet java.lang.String
 * @param argRecordStatus java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEBudjet create(int argIdbudjetnri, int argOwner, java.lang.String argIdBudjet, java.lang.String argNameBudjet, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByOwnerAndRecordstatusOrderByNameAsc(Integer owner, String recordstatus) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEBudjet
 * @param key com.hps.july.persistence.PIEBudjetKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEBudjet findByPrimaryKey(com.hps.july.persistence.PIEBudjetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
