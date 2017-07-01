package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AntennaCable extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for cableres
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getCableres() throws java.rmi.RemoteException;
/**
 * Getter method for groundcnt
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getGroundcnt() throws java.rmi.RemoteException;
/**
 * Getter method for groundresource
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getGroundresource() throws java.rmi.RemoteException;
/**
 * Getter method for idanten
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getIdanten() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdcable() throws java.rmi.RemoteException;
/**
 * Getter method for lencable
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLencable() throws java.rmi.RemoteException;
/**
 * Setter method for cableres
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setCableres(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for groundcnt
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setGroundcnt(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for groundresource
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setGroundresource(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idanten
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdanten(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for lencable
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLencable(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
