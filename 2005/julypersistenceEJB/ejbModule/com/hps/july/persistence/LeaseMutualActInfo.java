package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseMutualActInfo extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for lastcalctime
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getLastcalctime() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLeasedocument() throws java.rmi.RemoteException;
/**
 * Setter method for lastcalctime
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setLastcalctime(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
}
