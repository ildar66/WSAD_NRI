package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PhotoBlob extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for filename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFilename() throws java.rmi.RemoteException;
/**
 * Getter method for image
 * @return byte[]
 * @exception java.rmi.RemoteException The exception description.
 */
byte[] getImage() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getPhoto() throws java.rmi.RemoteException;
/**
 * Setter method for filename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFilename(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for image
 * @param newValue byte[]
 * @exception java.rmi.RemoteException The exception description.
 */
void setImage(byte[] newValue) throws java.rmi.RemoteException;
}
