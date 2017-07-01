package com.hps.july.inventory.sessionbean;

/**
 * This is a Home interface for the Session Bean
 */
public interface ContractSuppliesInfoHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.inventory.sessionbean.ContractSuppliesInfo
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.inventory.sessionbean.ContractSuppliesInfo create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}