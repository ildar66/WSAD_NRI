package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface BeenetObject extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getBeenetid() throws java.rmi.RemoteException;
/**
 * Getter method for categid
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getCategid() throws java.rmi.RemoteException;
/**
 * Getter method for position
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getPosition() throws java.rmi.RemoteException;
/**
 * Setter method for categid
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setCategid(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for position
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setPosition(int newValue) throws java.rmi.RemoteException;
}
