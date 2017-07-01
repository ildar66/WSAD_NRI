package com.hps.july.platinum.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PlatinumProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
void cancelDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean isProcessingEnabled() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argQueryId java.lang.Integer
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
void processDocument(java.lang.Integer argQueryId, java.lang.Integer argDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer processVirtualDocument(java.lang.Integer argDocument) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer requestPlatinumResources() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer requestPlatinumStorageplaces() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer requestPlatinumUsers() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @param argStartDate java.sql.Timestamp
 * @exception String The exception description.
 */
java.lang.Integer requestPlatinumValutes(java.sql.Timestamp argStartDate) throws java.rmi.RemoteException;
}
