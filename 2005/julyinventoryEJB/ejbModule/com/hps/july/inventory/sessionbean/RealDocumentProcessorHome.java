package com.hps.july.inventory.sessionbean;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface RealDocumentProcessorHome extends javax.ejb.EJBHome {
	com.hps.july.inventory.sessionbean.RealDocumentProcessor create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
