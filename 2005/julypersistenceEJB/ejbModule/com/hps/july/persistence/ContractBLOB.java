package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ContractBLOB extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return byte []
 * @exception String The exception description.
 */
byte [] getText() throws java.rmi.RemoteException;
/**
 * 
 * @return byte []
 * @exception String The exception description.
 */
byte [] getTimeline() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue byte []
 * @exception String The exception description.
 */
void setText(byte [] newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue byte []
 * @exception String The exception description.
 */
void setTimeline(byte [] newValue) throws java.rmi.RemoteException;
}
