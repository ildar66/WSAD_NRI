package com.hps.july.persistence;

/**
 * EJSFinderLeaseAbonentBANBean
 */
public interface EJSFinderLeaseAbonentBANBean {
	/**
	 * findByBAN
	 */
	public com.ibm.ejs.persistence.EJSFinder findByBAN(java.lang.Integer argBan) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.String contractType, java.lang.Boolean isOrgCustomer, java.lang.Integer orgCustomer, java.lang.Boolean isOrgExecutor, java.lang.Integer orgExecutor, java.lang.Boolean isMainEconomist, java.lang.Integer mainEconomist, java.lang.Boolean isDocNumber, java.lang.String docNumber, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByFlagWorkPIE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByFlagWorkPIE(java.lang.String argFlagWorkPIE) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isCustomerName, java.lang.String customerName, java.lang.Boolean isCustomerInn, java.lang.String customerInn, java.lang.Boolean isBan, java.lang.String ban, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE3
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE3(java.lang.Boolean isCustomerName, java.lang.String customerName, java.lang.Boolean isCustomerInn, java.lang.String customerInn, java.lang.Boolean isBan, java.lang.String ban, java.lang.Boolean isContractState, java.lang.String contractState, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
