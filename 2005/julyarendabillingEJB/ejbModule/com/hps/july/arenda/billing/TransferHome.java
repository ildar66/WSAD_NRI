package com.hps.july.arenda.billing;

/**
 * This is a Home interface for the Session Bean
 */
public interface TransferHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.arenda.billing.Transfer
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.arenda.billing.Transfer create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
