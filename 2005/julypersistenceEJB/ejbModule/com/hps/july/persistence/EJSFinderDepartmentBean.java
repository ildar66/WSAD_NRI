package com.hps.july.persistence;

/**
 * EJSFinderDepartmentBean
 */
public interface EJSFinderDepartmentBean {
	/**
	 * findByParentOrderByNameDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByParentOrderByNameDesc(java.lang.Integer parent) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByParentOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByParentOrderByNameAsc(java.lang.Integer parent) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isParent, java.lang.Integer parent, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
