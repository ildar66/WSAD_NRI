package com.hps.july.persistence;

/**
 * EJSFinderProtoActionBean
 */
public interface EJSFinderProtoActionBean {
	/**
	 * findProtoActionsByProjectActionType
	 */
	public com.ibm.ejs.persistence.EJSFinder findProtoActionsByProjectActionType(com.hps.july.persistence.ProjectActionTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findStepsBeforeOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findStepsBeforeOrderByOrderAsc(java.lang.Integer argProjectType, java.lang.Integer argProjectAction) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProtoActionsByProjectType
	 */
	public com.ibm.ejs.persistence.EJSFinder findProtoActionsByProjectType(com.hps.july.persistence.ProjectTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByProjectactiontypeOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByProjectactiontypeOrderByOrderAsc(java.lang.Integer projectactiontype) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByProjecttypeOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByProjecttypeOrderByOrderAsc(java.lang.Integer projecttype) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
