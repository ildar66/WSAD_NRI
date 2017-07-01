package com.hps.july.persistence;

/**
 * EJSFinderSiteDocBean
 */
public interface EJSFinderSiteDocBean {
	/**
	 * findSiteDocsBySiteDocType
	 */
	public com.ibm.ejs.persistence.EJSFinder findSiteDocsBySiteDocType(com.hps.july.persistence.SiteDocTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPosition(java.lang.Integer position, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByProjectactions_Project
	 */
	public com.ibm.ejs.persistence.EJSFinder findByProjectactions_Project(java.lang.Integer project) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByProjectaction
	 */
	public com.ibm.ejs.persistence.EJSFinder findByProjectaction(java.lang.Integer projectaction) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByEquipment
	 */
	public com.ibm.ejs.persistence.EJSFinder findByEquipment(java.lang.Integer position, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByHop
	 */
	public com.ibm.ejs.persistence.EJSFinder findByHop(java.lang.Integer hopid, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSiteDocsByMan
	 */
	public com.ibm.ejs.persistence.EJSFinder findSiteDocsByMan(com.hps.july.persistence.PeopleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSiteDocsByProjectAction
	 */
	public com.ibm.ejs.persistence.EJSFinder findSiteDocsByProjectAction(com.hps.july.persistence.ProjectActionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
