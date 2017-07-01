package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEDocInfoDocPos extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDocposition() throws java.rmi.RemoteException;
/**
 * Getter method for flagfulllink
 * @return java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Boolean getFlagfulllink() throws java.rmi.RemoteException;
/**
 * Setter method for flagfulllink
 * @param newValue java.lang.Boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setFlagfulllink(java.lang.Boolean newValue) throws java.rmi.RemoteException;
}
