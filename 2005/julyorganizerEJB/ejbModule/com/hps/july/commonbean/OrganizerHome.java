package com.hps.july.commonbean;

/**
 * This is a Home interface for the Session Bean
 */
public interface OrganizerHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.commonbean.Organizer
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.commonbean.Organizer create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
