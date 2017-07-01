package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEBudjet extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for idbudjet
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdbudjet() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdbudjetnri() throws java.rmi.RemoteException;
/**
 * Getter method for iddirect
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIddirect() throws java.rmi.RemoteException;
/**
 * Getter method for idproject
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdproject() throws java.rmi.RemoteException;
/**
 * Getter method for namebudjet
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNamebudjet() throws java.rmi.RemoteException;
/**
 * Getter method for namedirect
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNamedirect() throws java.rmi.RemoteException;
/**
 * Getter method for nameproject
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNameproject() throws java.rmi.RemoteException;
/**
 * Getter method for owner
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOwner() throws java.rmi.RemoteException;
/**
 * Getter method for recordstatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRecordstatus() throws java.rmi.RemoteException;
/**
 * Setter method for idbudjet
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdbudjet(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for iddirect
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIddirect(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idproject
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdproject(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for namebudjet
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNamebudjet(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for namedirect
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNamedirect(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nameproject
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNameproject(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for owner
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOwner(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for recordstatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRecordstatus(java.lang.String newValue) throws java.rmi.RemoteException;
}
