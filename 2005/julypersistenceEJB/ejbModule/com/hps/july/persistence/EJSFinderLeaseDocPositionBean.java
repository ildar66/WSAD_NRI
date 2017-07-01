package com.hps.july.persistence;

/**
 * EJSFinderLeaseDocPositionBean
 */
public interface EJSFinderLeaseDocPositionBean {
	/**
	 * findLeaseDocPositionByLeaseContract
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseDocPositionByLeaseContract(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Integer leaseContract, java.lang.Integer resource, java.sql.Date date, java.lang.String docposvid) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE5
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE5(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isDocposvid, java.lang.String[] docposvid, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseDocPositionsByCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseDocPositionsByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseDocPositionsByAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseDocPositionsByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseDocPositionsByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseDocPositionsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
