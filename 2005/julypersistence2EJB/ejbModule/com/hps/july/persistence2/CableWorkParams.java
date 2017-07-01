package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface CableWorkParams extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return short
 * @exception String The exception description.
 */
short getBand() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getId_anten() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getId_cable() throws java.rmi.RemoteException;
/**
 * Getter method for ksvn
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getKsvn() throws java.rmi.RemoteException;
/**
 * Setter method for ksvn
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setKsvn(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
