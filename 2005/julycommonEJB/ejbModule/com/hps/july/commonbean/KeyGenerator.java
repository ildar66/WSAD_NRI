package com.hps.july.commonbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface KeyGenerator extends javax.ejb.EJBObject {

/**
 * 
 * @return int
 * @param alias java.lang.String
 * @exception String The exception description.
 */
int getNextKey(java.lang.String alias) throws java.rmi.RemoteException;
}
