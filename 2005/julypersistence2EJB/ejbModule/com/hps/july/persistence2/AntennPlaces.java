package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AntennPlaces extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getAntplaceid() throws java.rmi.RemoteException;
/**
 * Getter method for isvc
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getIsvc() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * Setter method for isvc
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setIsvc(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
}
