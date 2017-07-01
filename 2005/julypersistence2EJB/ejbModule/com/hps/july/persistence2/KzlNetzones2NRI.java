package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface KzlNetzones2NRI extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getKzlregionid() throws java.rmi.RemoteException;
/**
 * Getter method for netzone
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getNetzone() throws java.rmi.RemoteException;
/**
 * Setter method for netzone
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setNetzone(int newValue) throws java.rmi.RemoteException;
}
