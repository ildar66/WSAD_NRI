package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEQueryHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEQuery
 * @param argIdquery int
 * @param argTypeQuery java.lang.String
 * @param argOperation java.lang.String
 * @param argStatus java.lang.String
 * @param argStatusop java.lang.String
 * @param argVdat java.sql.Timestamp
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEQuery create(int argIdquery, java.lang.String argTypeQuery, java.lang.String argOperation, java.lang.String argStatus, java.lang.String argStatusop, java.sql.Timestamp argVdat) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEQuery
 * @param key com.hps.july.persistence.PIEQueryKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEQuery findByPrimaryKey(com.hps.july.persistence.PIEQueryKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByTypeStatusOrderByCodeAsc(String argType, String argStatus) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
