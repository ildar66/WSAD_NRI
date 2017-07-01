package com.hps.july.persistence;

/**
 * EJSFinderRoles2TasksBean
 */
public interface EJSFinderRoles2TasksBean {
	/**
	 * findRoles2TasksByRoleString
	 */
	public com.ibm.ejs.persistence.EJSFinder findRoles2TasksByRoleString(java.lang.String role) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findTasksByRole
	 */
	public com.ibm.ejs.persistence.EJSFinder findTasksByRole(com.hps.july.persistence.RoleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRoleByTask
	 */
	public com.ibm.ejs.persistence.EJSFinder findRoleByTask(com.hps.july.persistence.TaskKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
