package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEDogovorLink extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIddogovornri() throws java.rmi.RemoteException;
/**
 * Getter method for iddogovorplatinum
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIddogovorplatinum() throws java.rmi.RemoteException;
/**
 * Getter method for owner
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOwner() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getTypedogovornri() throws java.rmi.RemoteException;
/**
 * Setter method for iddogovorplatinum
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIddogovorplatinum(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for owner
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOwner(int newValue) throws java.rmi.RemoteException;
}
