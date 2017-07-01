package com.hps.july.inventory.sessionbean;

import com.hps.july.inventory.sessionbean.DocumentProcessingException;
/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProcessorFacade extends javax.ejb.EJBObject {

/**
 * 
 * @return void
 * @param docCode java.lang.Integer
 * @exception String The exception description.
 */
void cancelDocument(java.lang.Integer docCode) 
	throws java.rmi.RemoteException, DocumentProcessingException;
/**
 * 
 * @return void
 * @param docCode java.lang.Integer
 * @param deleteAddInfo boolean
 * @exception String The exception description.
 */
void cancelDocument(java.lang.Integer docCode, boolean deleteAddInfo) 
	throws java.rmi.RemoteException, DocumentProcessingException;
/**
 * 
 * @return boolean
 * @param docCode java.lang.Integer
 * @exception String The exception description.
 */
boolean checkAddInfoModification(java.lang.Integer docCode) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param docCode java.lang.Integer
 * @exception String The exception description.
 */
void processDocument(java.lang.Integer docCode) 
	throws java.rmi.RemoteException, DocumentProcessingException;
/**
 * 
 * @return void
 * @param docCode java.lang.Integer
 * @param deleteAddInfo boolean
 * @exception String The exception description.
 */
void processDocument(java.lang.Integer docCode, boolean deleteAddInfo) 
	throws java.rmi.RemoteException, DocumentProcessingException;
/**
 * 
 * @return void
 * @param docCode java.lang.Integer
 * @param deleteAddInfo boolean
 * @param generateAutoDocs boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
void processDocument(java.lang.Integer docCode, boolean deleteAddInfo, boolean generateAutoDocs) throws com.hps.july.inventory.sessionbean.DocumentProcessingException, java.rmi.RemoteException;
	public void deleteDocument(Integer documentCode)
		throws java.rmi.RemoteException, DocumentProcessingException;
}
