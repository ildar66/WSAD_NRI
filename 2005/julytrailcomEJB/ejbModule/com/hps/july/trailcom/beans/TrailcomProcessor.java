package com.hps.july.trailcom.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface TrailcomProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param argStorageCard int
 * @exception String The exception description.
 */
void blockAddressSpace(int argStorageCard) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
void cancelDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argStorageCard int
 * @exception String The exception description.
 */
void closeAddressSpace(int argStorageCard) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argStorageCard int
 * @exception String The exception description.
 */
void openAddressSpace(int argStorageCard) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
void processDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException;
}
