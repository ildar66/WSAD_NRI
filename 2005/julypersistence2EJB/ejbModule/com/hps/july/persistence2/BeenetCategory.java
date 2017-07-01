package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface BeenetCategory extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getCategid() throws java.rmi.RemoteException;
/**
 * Getter method for categname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCategname() throws java.rmi.RemoteException;
/**
 * Getter method for pattern
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPattern() throws java.rmi.RemoteException;
/**
 * Setter method for categname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCategname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for pattern
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPattern(java.lang.String newValue) throws java.rmi.RemoteException;
}
