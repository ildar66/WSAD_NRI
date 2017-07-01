package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEExpence extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for idexpence
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdexpence() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdexpencenri() throws java.rmi.RemoteException;
/**
 * Getter method for idgrpexpence
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdgrpexpence() throws java.rmi.RemoteException;
/**
 * Getter method for iditem
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIditem() throws java.rmi.RemoteException;
/**
 * Getter method for nameexpence
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNameexpence() throws java.rmi.RemoteException;
/**
 * Getter method for namegrpexpence
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNamegrpexpence() throws java.rmi.RemoteException;
/**
 * Getter method for nameitem
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNameitem() throws java.rmi.RemoteException;
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
 * Setter method for idexpence
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdexpence(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idgrpexpence
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdgrpexpence(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for iditem
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIditem(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nameexpence
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNameexpence(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for namegrpexpence
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNamegrpexpence(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nameitem
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNameitem(java.lang.String newValue) throws java.rmi.RemoteException;
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
