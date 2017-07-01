package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface FaultReportProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param docCode java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException applyFaultReport(java.lang.Integer docCode) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argDoc java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException cancelFaultReport(java.lang.Integer argDoc) throws java.rmi.RemoteException;
}
