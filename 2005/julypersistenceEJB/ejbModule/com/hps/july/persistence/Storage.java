package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Storage extends com.hps.july.persistence.StoragePlace, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * Getter method for internalphone
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getInternalphone() throws java.rmi.RemoteException;
/**
 * Getter method for pstnphone
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPstnphone() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getRegionid() throws java.rmi.RemoteException;
/**
 * Setter method for internalphone
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setInternalphone(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for pstnphone
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPstnphone(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setRegionid(int newValue) throws java.rmi.RemoteException;
}
