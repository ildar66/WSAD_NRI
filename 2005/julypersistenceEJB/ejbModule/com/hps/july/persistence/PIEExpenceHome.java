package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEExpenceHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEExpence
 * @param argIdexpencenri int
 * @param argOwner int
 * @param argIdItem java.lang.String
 * @param argNameItem java.lang.String
 * @param argRecordStatus java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEExpence create(int argIdexpencenri, int argOwner, java.lang.String argIdItem, java.lang.String argNameItem, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByOwnerAndRecordstatusOrderByNameAsc(Integer owner, String recordstatus) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEExpence
 * @param key com.hps.july.persistence.PIEExpenceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEExpence findByPrimaryKey(com.hps.july.persistence.PIEExpenceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
