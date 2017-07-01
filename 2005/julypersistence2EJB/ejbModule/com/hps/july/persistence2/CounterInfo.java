package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface CounterInfo extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for code
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getCode() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getId() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getVerification_inter() throws java.rmi.RemoteException;
/**
 * Setter method for code
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setCode(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setVerification_inter(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
