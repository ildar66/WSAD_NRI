package com.hps.july.persistence;

/**
 * EJSFinderAssemblingActBean
 */
public interface EJSFinderAssemblingActBean {
	/**
	 * findAssemblingActByMonter
	 */
	public com.ibm.ejs.persistence.EJSFinder findAssemblingActByMonter(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAssemblingActByAgregat
	 */
	public com.ibm.ejs.persistence.EJSFinder findAssemblingActByAgregat(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.sql.Date startDate, java.sql.Date endDate, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isOperationType, java.lang.String operationType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.sql.Date startDate, java.sql.Date endDate, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorage, java.lang.Integer storage, java.lang.Boolean isOperationType, java.lang.String operationType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
