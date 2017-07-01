package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseMutualActBLOB extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for actfilename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getActfilename() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLeasedocument() throws java.rmi.RemoteException;
/**
 * Setter method for actfilename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setActfilename(java.lang.String newValue) throws java.rmi.RemoteException;
}
