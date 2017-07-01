package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Operators2RolesHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Operators2Roles
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Operators2Roles create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Operators2Roles
 * @param argOperator java.lang.Integer
 * @param argRole java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Operators2Roles create(java.lang.Integer argOperator, java.lang.String argRole) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Operators2Roles
 * @param key com.hps.july.persistence.Operators2RolesKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Operators2Roles findByPrimaryKey(com.hps.july.persistence.Operators2RolesKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named operators2roles2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findOperators2RolesByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named operators2roles2role.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findOperators2RolesByRole(com.hps.july.persistence.RoleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
