package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEDopInfoContr extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getDatenritoplatinum() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getDateplatinum() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFlagsync() throws java.rmi.RemoteException;
/**
 * Getter method for idbudjet
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdbudjet() throws java.rmi.RemoteException;
/**
 * Getter method for idexpense
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdexpense() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLeasedocument() throws java.rmi.RemoteException;
/**
 * Getter method for vendor
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getVendor() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setDatenritoplatinum(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setDateplatinum(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setFlagsync(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idbudjet
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdbudjet(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idexpense
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdexpense(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for vendor
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setVendor(java.lang.String newValue) throws java.rmi.RemoteException;
}
