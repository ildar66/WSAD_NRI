package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface RRLDocs extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for organization
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOrganization() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedoc() throws java.rmi.RemoteException;
/**
 * Setter method for organization
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOrganization(int newValue) throws java.rmi.RemoteException;
}
