package com.hps.july.inventory.sessionbean;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ChangeActProcessor extends javax.ejb.EJBObject {

/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param actCode java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException applyChangeAct(java.lang.Integer actCode) throws java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.inventory.sessionbean.DocumentProcessingException
 * @param argAct java.lang.Integer
 * @exception String The exception description.
 */
com.hps.july.inventory.sessionbean.DocumentProcessingException cancelChangeAct(java.lang.Integer argAct) throws java.rmi.RemoteException;
}
