package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseContractFactory
 * @generated
 */
public class LeaseContractFactory extends AbstractEJBFactory {
	/**
	 * LeaseContractFactory
	 * @generated
	 */
	public LeaseContractFactory() {
		super();
	}
	/**
	 * _acquireLeaseContractHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.LeaseContractHome _acquireLeaseContractHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.LeaseContractHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseContractHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseContractHome acquireLeaseContractHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.LeaseContractHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeaseContract";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseContractHome.class;
	}
	/**
	 * resetLeaseContractHome
	 * @generated
	 */
	public void resetLeaseContractHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseContractHome
	 * @generated
	 */
	public void setLeaseContractHome(
		com.hps.july.persistence.LeaseContractHome home) {
		setEJBHome(home);
	}
	/**
	 * findLeaseContract2ByCurrency2
	 * @generated
	 */
	public java.util.Enumeration findLeaseContract2ByCurrency2(
		com.hps.july.persistence.CurrencyKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome().findLeaseContract2ByCurrency2(inKey);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.String contractType,
		java.lang.Boolean isOrgCustomer,
		java.lang.Integer orgCustomer,
		java.lang.Boolean isOrgExecutor,
		java.lang.Integer orgExecutor,
		java.lang.Boolean isMainEconomist,
		java.lang.Integer mainEconomist,
		java.lang.Boolean isDocNumber,
		java.lang.String docNumber,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome().findByQBE(
			contractType,
			isOrgCustomer,
			orgCustomer,
			isOrgExecutor,
			orgExecutor,
			isMainEconomist,
			mainEconomist,
			isDocNumber,
			docNumber,
			order);
	}
	/**
	 * findLeaseContractExecutorByOrgExecutor
	 * @generated
	 */
	public java.util.Enumeration findLeaseContractExecutorByOrgExecutor(
		com.hps.july.persistence.OrganizationNfsKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome()
			.findLeaseContractExecutorByOrgExecutor(
			inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseContract create(
		int argLeaseDocument,
		java.sql.Date argDocDate,
		java.lang.String argDocNumber,
		java.lang.String argContractType,
		java.lang.String argContractState,
		java.lang.Integer argOrgCustomer,
		java.lang.Integer argOrgExecutor,
		java.sql.Date argStartDate,
		java.sql.Date argEndDate,
		java.lang.String argExtendType,
		java.lang.String argReportPeriod,
		java.lang.String agrCustname,
		java.lang.String argExecname)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseContractHome().create(
			argLeaseDocument,
			argDocDate,
			argDocNumber,
			argContractType,
			argContractState,
			argOrgCustomer,
			argOrgExecutor,
			argStartDate,
			argEndDate,
			argExtendType,
			argReportPeriod,
			agrCustname,
			argExecname);
	}
	/**
	 * findLeaseContractsByReglamentOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findLeaseContractsByReglamentOrderByCodeAsc(
		java.lang.Integer argReglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome()
			.findLeaseContractsByReglamentOrderByCodeAsc(
			argReglament);
	}
	/**
	 * findLeaseContractsByManager
	 * @generated
	 */
	public java.util.Enumeration findLeaseContractsByManager(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome().findLeaseContractsByManager(inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseContract findByPrimaryKey(
		com.hps.july.persistence.LeaseDocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome().findByPrimaryKey(key);
	}
	/**
	 * findLeaseContractByCurrency1
	 * @generated
	 */
	public java.util.Enumeration findLeaseContractByCurrency1(
		com.hps.july.persistence.CurrencyKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome().findLeaseContractByCurrency1(inKey);
	}
	/**
	 * findLeaseContractEconomistByEconomist
	 * @generated
	 */
	public java.util.Enumeration findLeaseContractEconomistByEconomist(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome()
			.findLeaseContractEconomistByEconomist(
			inKey);
	}
	/**
	 * findLeaseContractCustomerByOrgCustomer
	 * @generated
	 */
	public java.util.Enumeration findLeaseContractCustomerByOrgCustomer(
		com.hps.july.persistence.OrganizationNfsKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractHome()
			.findLeaseContractCustomerByOrgCustomer(
			inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseContract create(int argLeaseDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseContractHome().create(argLeaseDocument);
	}
}
