package com.hps.july.arenda.sessionbean;

/**
 * This is a Home interface for the Session Bean
 */
public interface ArendaDocumentTransactionMethodHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethod
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.arenda.sessionbean.ArendaDocumentTransactionMethod create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
