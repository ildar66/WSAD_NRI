package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseZP extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdzpnfs() throws java.rmi.RemoteException;
/**
 * Getter method for isactive
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getIsactive() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLeasedocposition() throws java.rmi.RemoteException;
/**
 * Setter method for isactive
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIsactive(boolean newValue) throws java.rmi.RemoteException;
}
