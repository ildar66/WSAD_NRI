package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface OporaPlaces extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOplaceid() throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
}
