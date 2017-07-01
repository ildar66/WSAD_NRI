package com.hps.july.arenda.billing;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Transfer extends javax.ejb.EJBObject {

/**
 * 
 * @return boolean
 * @param operator int
 * @exception String The exception description.
 */
boolean moveAllBufferNri2Nri(int operator) throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @param operator int
 * @exception String The exception description.
 */
boolean moveAllPie2BufferNri(int operator) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Object []
 * @param operator int
 * @exception String The exception description.
 */
java.lang.Object [] moveAllPie2Nri(int operator) throws java.rmi.RemoteException;
}
