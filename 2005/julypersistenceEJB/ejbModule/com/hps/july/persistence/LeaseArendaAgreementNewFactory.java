package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseArendaAgreementNewFactory
 * @generated
 */
public class LeaseArendaAgreementNewFactory extends AbstractEJBFactory {
	/**
	 * LeaseArendaAgreementNewFactory
	 * @generated
	 */
	public LeaseArendaAgreementNewFactory() {
		super();
	}
	/**
	 * _acquireLeaseArendaAgreementNewHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.LeaseArendaAgreementNewHome _acquireLeaseArendaAgreementNewHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.LeaseArendaAgreementNewHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseArendaAgreementNewHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseArendaAgreementNewHome acquireLeaseArendaAgreementNewHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.LeaseArendaAgreementNewHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeaseArendaAgreementNew";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseArendaAgreementNewHome.class;
	}
	/**
	 * resetLeaseArendaAgreementNewHome
	 * @generated
	 */
	public void resetLeaseArendaAgreementNewHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseArendaAgreementNewHome
	 * @generated
	 */
	public void setLeaseArendaAgreementNewHome(
		com.hps.july.persistence.LeaseArendaAgreementNewHome home) {
		setEJBHome(home);
	}
	/**
	 * findByQBE4
	 * @generated
	 */
	public java.util.Enumeration findByQBE4(
		java.lang.Boolean isEconomist,
		java.lang.Integer economist)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseArendaAgreementNewHome().findByQBE4(
			isEconomist,
			economist);
	}
	/**
	 * findByContractAndResource
	 * @generated
	 */
	public java.util.Enumeration findByContractAndResource(
		java.lang.Integer contract,
		java.lang.Integer resource,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseArendaAgreementNewHome().findByContractAndResource(
			contract,
			resource,
			order);
	}
	/**
	 * findLeaseArendaAgreementNewsByMainposition
	 * @generated
	 */
	public java.util.Enumeration findLeaseArendaAgreementNewsByMainposition(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseArendaAgreementNewHome()
			.findLeaseArendaAgreementNewsByMainposition(
			inKey);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isOrgCustomer,
		java.lang.Integer orgCustomer,
		java.lang.Boolean isOrgExecutor,
		java.lang.Integer orgExecutor,
		java.lang.Boolean isMainEconomist,
		java.lang.Integer mainEconomist,
		java.lang.Boolean isPosition,
		java.lang.Integer position,
		java.lang.Boolean isDocNumber,
		java.lang.String docNumber,
		java.lang.Boolean isState,
		java.lang.String state,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseArendaAgreementNewHome().findByQBE(
			isOrgCustomer,
			orgCustomer,
			isOrgExecutor,
			orgExecutor,
			isMainEconomist,
			mainEconomist,
			isPosition,
			position,
			isDocNumber,
			docNumber,
			isState,
			state,
			order);
	}
	/**
	 * findByQBE3
	 * @generated
	 */
	public java.util.Enumeration findByQBE3(
		java.lang.Boolean isEndDate,
		java.sql.Date startEndDate,
		java.sql.Date finishEndDate,
		java.lang.Boolean isIsActive,
		java.lang.Boolean isActive,
		java.lang.Boolean isContractState,
		java.lang.String ContractState,
		java.lang.Boolean isExtendType,
		java.lang.String ExtendType,
		java.lang.Boolean isEconomist,
		java.lang.Integer economist)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseArendaAgreementNewHome().findByQBE3(
			isEndDate,
			startEndDate,
			finishEndDate,
			isIsActive,
			isActive,
			isContractState,
			ContractState,
			isExtendType,
			ExtendType,
			isEconomist,
			economist);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew findByPrimaryKey(
		com.hps.july.persistence.LeaseDocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseArendaAgreementNewHome().findByPrimaryKey(key);
	}
	/**
	 * findByQBE5
	 * @generated
	 */
	public java.util.Enumeration findByQBE5(
		java.lang.Boolean isOrgCustomer,
		java.lang.Integer orgCustomer,
		java.lang.Boolean isOrgExecutor,
		java.lang.Integer orgExecutor,
		java.lang.Boolean isMainEconomist,
		java.lang.Integer mainEconomist,
		java.lang.Boolean isPosition,
		java.lang.Integer position,
		java.lang.Boolean isDocNumber,
		java.lang.String docNumber,
		java.lang.Boolean isState,
		java.lang.String state,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseArendaAgreementNewHome().findByQBE5(
			isOrgCustomer,
			orgCustomer,
			isOrgExecutor,
			orgExecutor,
			isMainEconomist,
			mainEconomist,
			isPosition,
			position,
			isDocNumber,
			docNumber,
			isState,
			state,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseArendaAgreementNew create(
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
		java.lang.Boolean argIsActive,
		java.lang.String argHowGivePhones,
		java.lang.String argCalcElectroType,
		java.lang.Boolean argIsDogElectro,
		java.lang.String agrCustname,
		java.lang.String argExecname,
		java.lang.Integer argMainDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseArendaAgreementNewHome().create(
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
			argIsActive,
			argHowGivePhones,
			argCalcElectroType,
			argIsDogElectro,
			agrCustname,
			argExecname,
			argMainDocument);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(
		java.lang.Integer mainLeaseDocument,
		java.lang.Boolean isIsActive,
		java.lang.Boolean isActive,
		java.lang.Boolean isContractState,
		java.lang.String contractState,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseArendaAgreementNewHome().findByQBE2(
			mainLeaseDocument,
			isIsActive,
			isActive,
			isContractState,
			contractState,
			order);
	}
}
