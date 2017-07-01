package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface AfsActProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param argDocument java.lang.Integer
 * @param recreateAddInfo boolean
 * @exception String The exception description.
 */
void applyAFSInfo(java.lang.Integer argDocument, boolean recreateAddInfo) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argDocument java.lang.Integer
 * @param recreateAddInfo boolean
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException applyDocument(java.lang.Integer argDocument, boolean recreateAddInfo) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param argDocument java.lang.Integer
 * @param deleteAddInfo boolean
 * @exception String The exception description.
 */
void cancelAFSInfo(java.lang.Integer argDocument, boolean deleteAddInfo) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argDocument java.lang.Integer
 * @param deleteAddInfo boolean
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException cancelDocument(java.lang.Integer argDocument, boolean deleteAddInfo) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
boolean checkAddInfoModification(java.lang.Integer argDocument) throws java.rmi.RemoteException;
}
