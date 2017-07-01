package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface FreqPermission extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for comment
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getComment() throws java.rmi.RemoteException;
/**
 * Getter method for etap
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getEtap() throws java.rmi.RemoteException;
/**
 * Getter method for filenumber
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getFilenumber() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getFreqpermid() throws java.rmi.RemoteException;
/**
 * Setter method for comment
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setComment(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for etap
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setEtap(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for filenumber
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setFilenumber(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
