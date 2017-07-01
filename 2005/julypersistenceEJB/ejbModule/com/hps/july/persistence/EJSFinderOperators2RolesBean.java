package com.hps.july.persistence;

/**
 * EJSFinderOperators2RolesBean
 */
public interface EJSFinderOperators2RolesBean {
	/**
	 * findOperators2RolesByRole
	 */
	public com.ibm.ejs.persistence.EJSFinder findOperators2RolesByRole(com.hps.july.persistence.RoleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOperators2RolesByOperator
	 */
	public com.ibm.ejs.persistence.EJSFinder findOperators2RolesByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
