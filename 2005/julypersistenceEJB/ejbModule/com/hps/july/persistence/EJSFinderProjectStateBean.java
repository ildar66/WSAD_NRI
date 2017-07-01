package com.hps.july.persistence;

/**
 * EJSFinderProjectStateBean
 */
public interface EJSFinderProjectStateBean {
	/**
	 * findCurrentForProject
	 */
	public com.hps.july.persistence.ProjectState findCurrentForProject(java.lang.Integer argProject) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectStatesByProject
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectStatesByProject(com.hps.july.persistence.ProjectKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectStatesByMan
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectStatesByMan(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
