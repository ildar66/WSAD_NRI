package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface KzlAntennes2NRI extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getAntposantennid() throws java.rmi.RemoteException;
/**
 * Getter method for resource
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getResource() throws java.rmi.RemoteException;
/**
 * Setter method for resource
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setResource(int newValue) throws java.rmi.RemoteException;
}
