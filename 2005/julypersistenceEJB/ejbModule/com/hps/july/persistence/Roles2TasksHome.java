package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Roles2TasksHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Roles2Tasks
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Roles2Tasks create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Roles2Tasks
 * @param argRole java.lang.String
 * @param argTask java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Roles2Tasks create(java.lang.String argRole, java.lang.Integer argTask) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Roles2Tasks
 * @param key com.hps.july.persistence.Roles2TasksKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Roles2Tasks findByPrimaryKey(com.hps.july.persistence.Roles2TasksKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named task2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findRoleByTask(com.hps.july.persistence.TaskKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Roles2tasks fk_relation__32 Roles.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return java.util.Enumeration
 * @param inKey com.hps.july.security.persistence.RolesKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findRoles2TasksByRoleString(String role) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named role2roles2tasks.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findTasksByRole(com.hps.july.persistence.RoleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
