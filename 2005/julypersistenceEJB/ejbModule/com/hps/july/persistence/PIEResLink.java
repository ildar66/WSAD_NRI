package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEResLink extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getFlagMainLink() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdresnri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEResPlatinum getResplatinum() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.PIEResPlatinumKey getResplatinumKey() throws java.rmi.RemoteException;
/**
 * Getter method for vdat
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getVdat() throws java.rmi.RemoteException;
/**
 * Getter method for voper
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getVoper() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setFlagMainLink(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for vdat
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setVdat(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for voper
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setVoper(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
