package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Sitedoc2Resource extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFreqrange() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getResource() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedoc() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFreqrange(java.lang.String newValue) throws java.rmi.RemoteException;
}
