package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Role extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named operators2roles2role.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getOperators2Roles() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getRole() throws java.rmi.RemoteException;
/**
 * Getter method for rolename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRolename() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named role2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getTasks() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named operators2roles2role.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddOperators2Roles(com.hps.july.persistence.Operators2Roles anOperators2Roles) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named role2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddTasks(com.hps.july.persistence.Roles2Tasks aTasks) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2roles2role.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveOperators2Roles(com.hps.july.persistence.Operators2Roles anOperators2Roles) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named role2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveTasks(com.hps.july.persistence.Roles2Tasks aTasks) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newRole java.lang.String
 * @exception String The exception description.
 */
void setRole(java.lang.String newRole) throws java.rmi.RemoteException;
/**
 * Setter method for rolename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRolename(java.lang.String newValue) throws java.rmi.RemoteException;
}
