package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEDopInfoDoc extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDocument() throws java.rmi.RemoteException;
/**
 * Getter method for flagsyncplatinum
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getFlagsyncplatinum() throws java.rmi.RemoteException;
/**
 * Setter method for flagsyncplatinum
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setFlagsyncplatinum(java.lang.Boolean newValue) throws java.rmi.RemoteException;
}
