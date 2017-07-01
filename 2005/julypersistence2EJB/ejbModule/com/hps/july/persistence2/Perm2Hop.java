package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Perm2Hop extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getFreqpermid() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getHopsid() throws java.rmi.RemoteException;
/**
 * Getter method for numberinfile
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getNumberinfile() throws java.rmi.RemoteException;
/**
 * Setter method for numberinfile
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setNumberinfile(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
