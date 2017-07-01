package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface EtapType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getEtaptypeid() throws java.rmi.RemoteException;
/**
 * Getter method for ettypename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getEttypename() throws java.rmi.RemoteException;
/**
 * Getter method for haveendtime
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getHaveendtime() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getHavehopslink() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getHavepaycheck() throws java.rmi.RemoteException;
/**
 * Setter method for ettypename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setEttypename(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for haveendtime
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setHaveendtime(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setHavehopslink(boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setHavepaycheck(boolean newValue) throws java.rmi.RemoteException;
}
