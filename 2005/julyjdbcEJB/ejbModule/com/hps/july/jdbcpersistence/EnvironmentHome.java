package com.hps.july.jdbcpersistence;

/**
 * This is a Home interface for the Session Bean
 */
public interface EnvironmentHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.jdbcpersistence.Util
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.jdbcpersistence.Environment create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
