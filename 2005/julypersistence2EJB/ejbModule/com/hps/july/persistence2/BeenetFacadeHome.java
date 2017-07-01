package com.hps.july.persistence2;

/**
 * This is a Home interface for the Session Bean
 */
public interface BeenetFacadeHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.persistence2.BeenetFacade
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence2.BeenetFacade create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
