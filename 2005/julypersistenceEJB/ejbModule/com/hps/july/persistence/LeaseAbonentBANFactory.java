package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseAbonentBANFactory
 * @generated
 */
public class LeaseAbonentBANFactory extends AbstractEJBFactory {
	/**
	 * LeaseAbonentBANFactory
	 * @generated
	 */
	public LeaseAbonentBANFactory() {
		super();
	}
	/**
	 * _acquireLeaseAbonentBANHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.LeaseAbonentBANHome _acquireLeaseAbonentBANHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.LeaseAbonentBANHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseAbonentBANHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseAbonentBANHome acquireLeaseAbonentBANHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.LeaseAbonentBANHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeaseAbonentBAN";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseAbonentBANHome.class;
	}
	/**
	 * resetLeaseAbonentBANHome
	 * @generated
	 */
	public void resetLeaseAbonentBANHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseAbonentBANHome
	 * @generated
	 */
	public void setLeaseAbonentBANHome(
		com.hps.july.persistence.LeaseAbonentBANHome home) {
		setEJBHome(home);
	}
	/**
	 * findByBAN
	 * @generated
	 */
	public java.util.Enumeration findByBAN(java.lang.Integer argBan)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseAbonentBANHome().findByBAN(argBan);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseAbonentBAN create(
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
		java.lang.String argExecname,
		int argBan,
		boolean argFlagWorkPIE)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseAbonentBANHome().create(
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
			argExecname,
			argBan,
			argFlagWorkPIE);
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
		return _acquireLeaseAbonentBANHome().findByQBE(
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
	 * findByFlagWorkPIE
	 * @generated
	 */
	public java.util.Enumeration findByFlagWorkPIE(
		java.lang.String argFlagWorkPIE)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseAbonentBANHome().findByFlagWorkPIE(argFlagWorkPIE);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseAbonentBAN findByPrimaryKey(
		com.hps.july.persistence.LeaseDocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseAbonentBANHome().findByPrimaryKey(key);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(
		java.lang.Boolean isCustomerName,
		java.lang.String customerName,
		java.lang.Boolean isCustomerInn,
		java.lang.String customerInn,
		java.lang.Boolean isBan,
		java.lang.String ban,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseAbonentBANHome().findByQBE2(
			isCustomerName,
			customerName,
			isCustomerInn,
			customerInn,
			isBan,
			ban,
			order);
	}
	/**
	 * findByQBE3
	 * @generated
	 */
	public java.util.Enumeration findByQBE3(
		java.lang.Boolean isCustomerName,
		java.lang.String customerName,
		java.lang.Boolean isCustomerInn,
		java.lang.String customerInn,
		java.lang.Boolean isBan,
		java.lang.String ban,
		java.lang.Boolean isContractState,
		java.lang.String contractState,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseAbonentBANHome().findByQBE3(
			isCustomerName,
			customerName,
			isCustomerInn,
			customerInn,
			isBan,
			ban,
			isContractState,
			contractState,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseAbonentBAN create(
		int argLeaseDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseAbonentBANHome().create(argLeaseDocument);
	}
}
