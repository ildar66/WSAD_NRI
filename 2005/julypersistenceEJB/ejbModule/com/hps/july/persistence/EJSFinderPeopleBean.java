package com.hps.july.persistence;

/**
 * EJSFinderPeopleBean
 */
public interface EJSFinderPeopleBean {
	/**
	 * findMaxKeyValue
	 */
	public com.ibm.ejs.persistence.EJSFinder findMaxKeyValue() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findWorkerByLastNameOrderByLastNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findWorkerByLastNameOrderByLastNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByNameOrderByNameDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByNameOrderByNameDesc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isLastName, java.lang.String lastName, java.lang.Integer argConnected, java.lang.Boolean isIsActive, java.lang.Boolean isActive, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByConnectedOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByConnectedOrderByNameAsc(java.lang.Integer argConnected) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByNameOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByNameOrderByNameAsc(java.lang.String name) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
