package com.hps.july.journal.beans;

/**
 * This is a Home interface for the Session Bean
 */
public interface JournalHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.journal.beans.Journal
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.journal.beans.Journal create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
