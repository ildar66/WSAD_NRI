package com.hps.july.persistence;

/**
 * EJSFinderDivisionBean
 */
public interface EJSFinderDivisionBean {
	/**
	 * findAllByProjectActionTypeOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllByProjectActionTypeOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findChildsByParent
	 */
	public com.ibm.ejs.persistence.EJSFinder findChildsByParent(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByParentOrderByNameDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByParentOrderByNameDesc(java.lang.Integer parent) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDivisionsByCompany
	 */
	public com.ibm.ejs.persistence.EJSFinder findDivisionsByCompany(com.hps.july.persistence.CompanyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findControlleddivisionsByBoss
	 */
	public com.ibm.ejs.persistence.EJSFinder findControlleddivisionsByBoss(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByParentOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByParentOrderByNameAsc(java.lang.Integer parent) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllByProjectCommsByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllByProjectCommsByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByParentCompany
	 */
	public com.ibm.ejs.persistence.EJSFinder findByParentCompany(java.lang.Integer parent, java.lang.Integer company, java.lang.Boolean isRoot, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isParent, java.lang.Integer parent, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllByProjectColumnsOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllByProjectColumnsOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
