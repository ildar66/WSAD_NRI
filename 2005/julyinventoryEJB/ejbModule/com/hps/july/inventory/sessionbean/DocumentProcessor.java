package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface DocumentProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return com.hps.july.inventory.sessionbean.ProcessingPositionError
 * @param argPosition java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.ProcessingPositionError addPosition2Document(java.lang.Integer argPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argDoc java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException applyDocument(java.lang.Integer argDoc) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argDoc java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException cancelDocument(java.lang.Integer argDoc) throws java.rmi.RemoteException;
/**
 * 
 * @return java.math.BigDecimal
 * @param argDocument java.lang.Integer
 * @exception String The exception description.
 */
java.math.BigDecimal getDocumentSum(java.lang.Integer argDocument) throws java.rmi.RemoteException;
}
