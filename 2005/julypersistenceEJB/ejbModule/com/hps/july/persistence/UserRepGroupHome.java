package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface UserRepGroupHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.UserRepGroup
 * @param argUsrgrpid int
 * @param argUsrgrpname java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.UserRepGroup create(int argUsrgrpid, java.lang.String argUsrgrpname) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.UserRepGroup
 * @param key com.hps.july.persistence.UserRepGroupKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.UserRepGroup
 * @param key com.hps.july.persistence.UserRepGroupKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.UserRepGroup findByPrimaryKey(com.hps.july.persistence.UserRepGroupKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
