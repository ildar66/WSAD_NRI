package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface InventoryNumbers extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for serdate
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getSerdate() throws java.rmi.RemoteException;
/**
 * Getter method for serend
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSerend() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSerid() throws java.rmi.RemoteException;
/**
 * Getter method for serprefix
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSerprefix() throws java.rmi.RemoteException;
/**
 * Getter method for serstart
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSerstart() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getSerworker() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getSerworkerKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSerworkerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetSerworker(com.hps.july.persistence.Worker aSerworker) throws java.rmi.RemoteException;
/**
 * Setter method for serdate
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setSerdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for serend
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSerend(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for serprefix
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSerprefix(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for serstart
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSerstart(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named InventoryNumbers2Worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setSerworker(com.hps.july.persistence.Worker aSerworker) throws java.rmi.RemoteException;
}
