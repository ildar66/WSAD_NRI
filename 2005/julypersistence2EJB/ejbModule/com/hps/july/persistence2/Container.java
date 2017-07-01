package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Container extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getContainer() throws java.rmi.RemoteException;
/**
 * Getter method for height
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getHeight() throws java.rmi.RemoteException;
/**
 * Getter method for length
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getLength() throws java.rmi.RemoteException;
/**
 * Getter method for resource
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getResource() throws java.rmi.RemoteException;
/**
 * Getter method for storageplace
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getStorageplace() throws java.rmi.RemoteException;
/**
 * Getter method for width
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getWidth() throws java.rmi.RemoteException;
/**
 * Getter method for year
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getYear() throws java.rmi.RemoteException;
/**
 * Setter method for height
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setHeight(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for length
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setLength(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for resource
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setResource(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for storageplace
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setStorageplace(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for width
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setWidth(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for year
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setYear(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
