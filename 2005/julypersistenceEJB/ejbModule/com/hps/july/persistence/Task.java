package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Task extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for context
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getContext() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named task2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getRole() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getTask() throws java.rmi.RemoteException;
/**
 * Getter method for taskname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTaskname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named task2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddRole(com.hps.july.persistence.Roles2Tasks aRole) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named task2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveRole(com.hps.july.persistence.Roles2Tasks aRole) throws java.rmi.RemoteException;
/**
 * Setter method for context
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setContext(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newTask int
 * @exception String The exception description.
 */
void setTask(int newTask) throws java.rmi.RemoteException;
/**
 * Setter method for taskname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTaskname(java.lang.String newValue) throws java.rmi.RemoteException;
}
