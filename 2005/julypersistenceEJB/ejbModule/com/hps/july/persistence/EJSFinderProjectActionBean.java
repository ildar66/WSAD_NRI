package com.hps.july.persistence;

/**
 * EJSFinderProjectActionBean
 */
public interface EJSFinderProjectActionBean {
	/**
	 * findByProjectAndOrder
	 */
	public com.ibm.ejs.persistence.EJSFinder findByProjectAndOrder(java.lang.Integer Project, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectActionsByProjectactiontype
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectActionsByProjectactiontype(com.hps.july.persistence.ProjectActionTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectActionsByProject
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectActionsByProject(com.hps.july.persistence.ProjectKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findProjectActionsByEquipment
	 */
	public com.ibm.ejs.persistence.EJSFinder findProjectActionsByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByProjectOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByProjectOrderByOrderAsc(java.lang.Integer project) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByProjectAndProjectActionType
	 */
	public com.ibm.ejs.persistence.EJSFinder findByProjectAndProjectActionType(java.lang.Integer project, java.lang.Integer projectActionType) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
