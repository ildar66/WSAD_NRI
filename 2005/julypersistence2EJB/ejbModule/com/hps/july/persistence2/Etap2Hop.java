package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Etap2Hop extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for freqpermid
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getFreqpermid() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getHopsid() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedoc() throws java.rmi.RemoteException;
/**
 * Setter method for freqpermid
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setFreqpermid(int newValue) throws java.rmi.RemoteException;
}
