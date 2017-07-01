package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface DocumentPreprocessor extends javax.ejb.EJBObject {

/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argDoc int
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException preprocessDocument(int argDoc) throws java.rmi.RemoteException;
}
