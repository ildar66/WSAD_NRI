package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeasePay2Bill extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for flagworkpie
 * @return boolean
 * @exception java.rmi.RemoteException The exception description.
 */
boolean getFlagworkpie() throws java.rmi.RemoteException;
/**
 * Getter method for leasecontract
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getLeasecontract() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLeasemutualact() throws java.rmi.RemoteException;
/**
 * Getter method for recordstatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRecordstatus() throws java.rmi.RemoteException;
/**
 * Getter method for sumusd
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getSumusd() throws java.rmi.RemoteException;
/**
 * Setter method for flagworkpie
 * @param newValue boolean
 * @exception java.rmi.RemoteException The exception description.
 */
void setFlagworkpie(boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for recordstatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRecordstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sumusd
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setSumusd(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
