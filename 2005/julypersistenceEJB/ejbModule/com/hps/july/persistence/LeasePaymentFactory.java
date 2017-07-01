package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeasePaymentFactory
 * @generated
 */
public class LeasePaymentFactory extends AbstractEJBFactory {
	/**
	 * LeasePaymentFactory
	 * @generated
	 */
	public LeasePaymentFactory() {
		super();
	}
	/**
	 * _acquireLeasePaymentHome
	 * @generated
	 */
	protected com.hps.july.persistence.LeasePaymentHome _acquireLeasePaymentHome() throws java.rmi.RemoteException {
		return (com.hps.july.persistence.LeasePaymentHome) _acquireEJBHome();
	}
	/**
	 * acquireLeasePaymentHome
	 * @generated
	 */
	public com.hps.july.persistence.LeasePaymentHome acquireLeasePaymentHome() throws javax.naming.NamingException {
		return (com.hps.july.persistence.LeasePaymentHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeasePayment";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeasePaymentHome.class;
	}
	/**
	 * resetLeasePaymentHome
	 * @generated
	 */
	public void resetLeasePaymentHome() {
		resetEJBHome();
	}
	/**
	 * setLeasePaymentHome
	 * @generated
	 */
	public void setLeasePaymentHome(com.hps.july.persistence.LeasePaymentHome home) {
		setEJBHome(home);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(java.lang.Integer leaseRule, java.sql.Date startDate, java.sql.Date finishDate, java.lang.Boolean isSource, java.lang.String source)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePaymentHome().findByQBE2(leaseRule, startDate, finishDate, isSource, source);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeasePayment findByPrimaryKey(com.hps.july.persistence.LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePaymentHome().findByPrimaryKey(key);
	}
	/**
	 * findByLeaseContract
	 * @generated
	 */
	public java.util.Enumeration findByLeaseContract(java.lang.Integer argContract) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePaymentHome().findByLeaseContract(argContract);
	}
	/**
	 * findByQBE5
	 * @generated
	 */
	public java.util.Enumeration findByQBE5(
		java.lang.Boolean isLeaseContract,
		java.lang.Integer leaseContract,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		java.lang.Boolean isResource,
		java.lang.Integer resource,
		java.lang.Boolean isDocposvid,
		java.lang.String[] docposvid,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePaymentHome().findByQBE5(isLeaseContract, leaseContract, isDate, fromDate, toDate, isResource, resource, isDocposvid, docposvid, order);
	}
	/**
	 * findLeasePaymentByLeaseRule
	 * @generated
	 */
	public java.util.Enumeration findLeasePaymentByLeaseRule(com.hps.july.persistence.LeaseRuleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePaymentHome().findLeasePaymentByLeaseRule(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeasePayment create(
		int argLeaseDocPosition,
		java.sql.Date argDate,
		java.lang.Integer argLeaseContract,
		java.lang.String argSource,
		java.lang.String argVid,
		java.sql.Date argSDate,
		java.sql.Date argEDate,
		java.lang.Integer argResource,
		java.math.BigDecimal argSumm,
		java.lang.Integer argCurrency,
		java.math.BigDecimal argSumNds,
		java.lang.String argPaymentType,
		java.lang.String argPaymentState,
		java.lang.String argIsSchetFakt)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeasePaymentHome().create(
			argLeaseDocPosition,
			argDate,
			argLeaseContract,
			argSource,
			argVid,
			argSDate,
			argEDate,
			argResource,
			argSumm,
			argCurrency,
			argSumNds,
			argPaymentType,
			argPaymentState,
			argIsSchetFakt);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeasePayment create(
		int argLeaseDocPosition,
		java.sql.Date argDate,
		java.lang.Integer argLeaseContract,
		java.lang.String argSource,
		java.lang.String argVid,
		java.sql.Date argSDate,
		java.sql.Date argEDate,
		java.lang.Integer argResource,
		java.math.BigDecimal argSumm,
		java.lang.Integer argCurrency,
		java.math.BigDecimal argSumNds,
		java.lang.String argPaymentType,
		java.lang.String argPaymentState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeasePaymentHome().create(
			argLeaseDocPosition,
			argDate,
			argLeaseContract,
			argSource,
			argVid,
			argSDate,
			argEDate,
			argResource,
			argSumm,
			argCurrency,
			argSumNds,
			argPaymentType,
			argPaymentState);
	}
	/**
	 * findByQBE4
	 * @generated
	 */
	public java.util.Enumeration findByQBE4(
		java.lang.Integer contract,
		java.lang.Boolean isStartDate,
		java.sql.Date actStartDate,
		java.lang.Boolean isEndDate,
		java.sql.Date actEndDate,
		java.lang.Boolean isRemainder,
		java.math.BigDecimal remainder,
		java.lang.Boolean isResource,
		java.lang.Integer resource,
		java.lang.Boolean isCalcPosOnly,
		java.lang.Boolean isAutoRUR,
		java.lang.Boolean autoRUR)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePaymentHome().findByQBE4(contract, isStartDate, actStartDate, isEndDate, actEndDate, isRemainder, remainder, isResource, resource, isCalcPosOnly, isAutoRUR, autoRUR);
	}
	/**
	 * findByQBE3
	 * @generated
	 */
	public java.util.Enumeration findByQBE3(java.lang.Integer leaseContract, java.lang.Integer resource, java.sql.Date startInterval, java.sql.Date finishInterval)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePaymentHome().findByQBE3(leaseContract, resource, startInterval, finishInterval);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isLeaseContract,
		java.lang.Integer leaseContract,
		java.lang.Boolean isDate,
		java.sql.Date fromDate,
		java.sql.Date toDate,
		java.lang.Boolean isResource,
		java.lang.Integer resource,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeasePaymentHome().findByQBE(isLeaseContract, leaseContract, isDate, fromDate, toDate, isResource, resource, order);
	}
}
