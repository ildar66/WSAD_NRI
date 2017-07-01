package com.hps.july.trailcom.beans;

/**
 * This is a Home interface for the Session Bean
 */
public interface TrailcomProcessorHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.trailcom.beans.TrailcomProcessor
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.trailcom.beans.TrailcomProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
