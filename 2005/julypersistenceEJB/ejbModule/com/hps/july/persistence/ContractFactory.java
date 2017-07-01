package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ContractFactory
 * @generated
 */
public class ContractFactory extends AbstractEJBFactory {
	/**
	 * ContractFactory
	 * @generated
	 */
	public ContractFactory() {
		super();
	}
	/**
	 * _acquireContractHome
	 * @generated
	 */
	protected com.hps.july.persistence.ContractHome _acquireContractHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.ContractHome) _acquireEJBHome();
	}
	/**
	 * acquireContractHome
	 * @generated
	 */
	public com.hps.july.persistence.ContractHome acquireContractHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.ContractHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Contract";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.ContractHome.class;
	}
	/**
	 * resetContractHome
	 * @generated
	 */
	public void resetContractHome() {
		resetEJBHome();
	}
	/**
	 * setContractHome
	 * @generated
	 */
	public void setContractHome(com.hps.july.persistence.ContractHome home) {
		setEJBHome(home);
	}
	/**
	 * findControlledContractByController
	 * @generated
	 */
	public java.util.Enumeration findControlledContractByController(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findControlledContractByController(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Contract create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argBlankNumber,
		java.lang.String argState,
		java.lang.Integer argCurrency,
		java.lang.String argName,
		java.lang.Integer argWorker,
		java.lang.Integer argController,
		java.sql.Date argStartDate,
		java.sql.Date argFinishDate,
		java.math.BigDecimal argSum,
		java.lang.Integer argSupplyType,
		java.lang.Integer argBaseAgreement)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireContractHome().create(
			argDocument,
			argOwner,
			argBlankDate,
			argBlankindex,
			argBlankNumber,
			argState,
			argCurrency,
			argName,
			argWorker,
			argController,
			argStartDate,
			argFinishDate,
			argSum,
			argSupplyType,
			argBaseAgreement);
	}
	/**
	 * findContractBySupplyType
	 * @generated
	 */
	public java.util.Enumeration findContractBySupplyType(
		com.hps.july.persistence.SupplyTypeKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findContractBySupplyType(inKey);
	}
	/**
	 * findContractByCurrency
	 * @generated
	 */
	public java.util.Enumeration findContractByCurrency(
		com.hps.july.persistence.CurrencyKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findContractByCurrency(inKey);
	}
	/**
	 * findContractByQBE2
	 * @generated
	 */
	public java.util.Enumeration findContractByQBE2(
		java.lang.Boolean isSupplyType,
		java.lang.Integer sypplyType,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isContragent,
		java.lang.Integer contragent,
		java.lang.String matchName,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findContractByQBE2(
			isSupplyType,
			sypplyType,
			isOwner,
			owner,
			isContragent,
			contragent,
			matchName,
			order);
	}
	/**
	 * findContractByQBE3
	 * @generated
	 */
	public java.util.Enumeration findContractByQBE3(
		java.lang.Integer argSupplyType,
		java.lang.Boolean isBaseAgreement,
		java.lang.Integer argBaseAgreement,
		java.lang.Boolean isOrganization,
		java.lang.Integer argOrganization,
		java.lang.Boolean isContragent,
		java.lang.Integer argContragent,
		java.sql.Date argBlankDate,
		java.sql.Date argFinishDate,
		java.lang.Boolean isState,
		java.lang.String argState,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findContractByQBE3(
			argSupplyType,
			isBaseAgreement,
			argBaseAgreement,
			isOrganization,
			argOrganization,
			isContragent,
			argContragent,
			argBlankDate,
			argFinishDate,
			isState,
			argState,
			order);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Contract findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findByPrimaryKey(key);
	}
	/**
	 * findWorkedContractByWorker
	 * @generated
	 */
	public java.util.Enumeration findWorkedContractByWorker(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findWorkedContractByWorker(inKey);
	}
	/**
	 * findContractByBaseAgreement
	 * @generated
	 */
	public java.util.Enumeration findContractByBaseAgreement(
		com.hps.july.persistence.BaseAgreementKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findContractByBaseAgreement(inKey);
	}
	/**
	 * findContractByQBE
	 * @generated
	 */
	public java.util.Enumeration findContractByQBE(
		java.lang.Integer argSupplyType,
		java.lang.Boolean isBaseAgreement,
		java.lang.Integer argBaseAgreement,
		java.lang.Boolean isOrganization,
		java.lang.Integer argOrganization,
		java.lang.Boolean isContragent,
		java.lang.Integer argContragent,
		java.sql.Date argStartDate,
		java.sql.Date argFinishDate,
		java.lang.Boolean isState,
		java.lang.String argState,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireContractHome().findContractByQBE(
			argSupplyType,
			isBaseAgreement,
			argBaseAgreement,
			isOrganization,
			argOrganization,
			isContragent,
			argContragent,
			argStartDate,
			argFinishDate,
			isState,
			argState,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Contract create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireContractHome().create(argDocument);
	}
}
