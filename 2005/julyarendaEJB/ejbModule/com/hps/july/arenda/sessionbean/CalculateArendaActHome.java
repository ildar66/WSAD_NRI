package com.hps.july.arenda.sessionbean;

/**
 * This is a Home interface for the Session Bean
 */
public interface CalculateArendaActHome extends javax.ejb.EJBHome {

/**
 * create method for a session bean
 * @return com.hps.july.arenda.sessionbean.CalculateArendaAct
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.arenda.sessionbean.CalculateArendaAct create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
