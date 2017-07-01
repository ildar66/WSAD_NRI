package com.hps.july.persistence;

/**
 * EJSFinderLeaseChargesBean
 */
public interface EJSFinderLeaseChargesBean {
	/**
	 * findLeaseChargesByLeaseRule
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseChargesByLeaseRule(com.hps.july.persistence.LeaseRuleKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE4
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE4(java.lang.Integer contract, java.lang.Boolean isStartDate, java.sql.Date actStartDate, java.lang.Boolean isEndDate, java.sql.Date actEndDate, java.lang.Boolean isRemainder, java.math.BigDecimal remainder, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isCalcPosOnly, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Integer leaseRule, java.sql.Date startDate, java.sql.Date finishDate, java.lang.Boolean isSource, java.lang.String source) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByLeaseContract
	 */
	public com.ibm.ejs.persistence.EJSFinder findByLeaseContract(java.lang.Integer argContract) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE5
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE5(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Boolean isDocposvid, java.lang.String[] docposvid, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE3
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE3(java.lang.Integer leaseContract, java.lang.Integer resource, java.sql.Date startInterval, java.sql.Date finishInterval) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isLeaseContract, java.lang.Integer leaseContract, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Boolean isResource, java.lang.Integer resource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
