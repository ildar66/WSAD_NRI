package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface GKRCHDoc extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for restrictions
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRestrictions() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedoc() throws java.rmi.RemoteException;
/**
 * Setter method for restrictions
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRestrictions(java.lang.String newValue) throws java.rmi.RemoteException;
}
