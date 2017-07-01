package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIELinkPrihRash extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for docposprihod
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getDocposprihod() throws java.rmi.RemoteException;
/**
 * Getter method for docposrashod
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getDocposrashod() throws java.rmi.RemoteException;
/**
 * Getter method for fromstorageprihod
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getFromstorageprihod() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdlinkprihodrashod() throws java.rmi.RemoteException;
/**
 * Getter method for qty
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getQty() throws java.rmi.RemoteException;
/**
 * Setter method for docposprihod
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setDocposprihod(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for docposrashod
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setDocposrashod(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for fromstorageprihod
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setFromstorageprihod(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for qty
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setQty(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
