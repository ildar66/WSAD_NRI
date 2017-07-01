package com.hps.july.inventory.sessionbean;

/**
 * This is a Home interface for the Session Bean
 */
public interface ChangeActProcessorHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.inventory.sessionbean.ChangeActProcessor
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.inventory.sessionbean.ChangeActProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
