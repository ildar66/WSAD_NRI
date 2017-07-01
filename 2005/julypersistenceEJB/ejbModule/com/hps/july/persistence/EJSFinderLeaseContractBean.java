package com.hps.july.persistence;

/**
 * EJSFinderLeaseContractBean
 */
public interface EJSFinderLeaseContractBean {
	/**
	 * findLeaseContract2ByCurrency2
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseContract2ByCurrency2(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.String contractType, java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseContractExecutorByOrgExecutor
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseContractExecutorByOrgExecutor(com.hps.july.persistence.OrganizationNfsKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseContractsByReglamentOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseContractsByReglamentOrderByCodeAsc(java.lang.Integer argReglament) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseContractsByManager
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseContractsByManager(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseContractByCurrency1
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseContractByCurrency1(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseContractEconomistByEconomist
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseContractEconomistByEconomist(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseContractCustomerByOrgCustomer
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseContractCustomerByOrgCustomer(com.hps.july.persistence.OrganizationNfsKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
