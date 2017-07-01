package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface InWayBillBLOB extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for dActText
 * @return byte[]
 * @exception java.rmi.RemoteException The exception description.
 */
byte[] getDActText() throws java.rmi.RemoteException;
/**
 * Getter method for dActTextFileName
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDActTextFileName() throws java.rmi.RemoteException;
/**
 * Setter method for dActText
 * @param newValue byte[]
 * @exception java.rmi.RemoteException The exception description.
 */
void setDActText(byte[] newValue) throws java.rmi.RemoteException;
/**
 * Setter method for dActTextFileName
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDActTextFileName(java.lang.String newValue) throws java.rmi.RemoteException;
}
