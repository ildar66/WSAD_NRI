package com.hps.july.platinum.sessionbean;

/**
 * This is a Home interface for the Session Bean
 */
public interface PlatinumProcessorHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.platinum.sessionbean.PlatinumProcessor
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.platinum.sessionbean.PlatinumProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}