package com.hps.july.persistence;

/**
 * EJSFinderLeaseSaldoBean
 */
public interface EJSFinderLeaseSaldoBean {
	/**
	 * findByLeaseContractAndResourceOrderDateDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseContractAndResourceOrderDateDesc(java.lang.Integer leaseContract, java.lang.Integer resource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeaseContractAndResourceOrderDateAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseContractAndResourceOrderDateAsc(java.lang.Integer leaseContract, java.lang.Integer resource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseSaldoMainsByMaincurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseSaldoMainsByMaincurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseSaldosByAct
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseSaldosByAct(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseSaldoByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseSaldoByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseSaldoAddsByAdditionalcurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseSaldoAddsByAdditionalcurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Integer leaseContract, java.lang.Boolean isDateStart, java.sql.Date fromDateStart, java.sql.Date toDateStart, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
