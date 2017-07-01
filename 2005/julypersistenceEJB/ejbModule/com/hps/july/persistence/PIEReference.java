package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEReference extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for idplatinum
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdplatinum() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdreference() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * Getter method for owner
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOwner() throws java.rmi.RemoteException;
/**
 * Getter method for pstatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPstatus() throws java.rmi.RemoteException;
/**
 * Getter method for sprav
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSprav() throws java.rmi.RemoteException;
/**
 * Setter method for idplatinum
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdplatinum(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for owner
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOwner(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for pstatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPstatus(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sprav
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSprav(java.lang.String newValue) throws java.rmi.RemoteException;
}
