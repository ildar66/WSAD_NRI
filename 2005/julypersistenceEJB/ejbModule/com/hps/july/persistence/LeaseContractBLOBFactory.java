package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseContractBLOBFactory
 * @generated
 */
public class LeaseContractBLOBFactory extends AbstractEJBFactory {
	/**
	 * LeaseContractBLOBFactory
	 * @generated
	 */
	public LeaseContractBLOBFactory() {
		super();
	}
	/**
	 * _acquireLeaseContractBLOBHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.LeaseContractBLOBHome _acquireLeaseContractBLOBHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.LeaseContractBLOBHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseContractBLOBHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseContractBLOBHome acquireLeaseContractBLOBHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.LeaseContractBLOBHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeaseContractBLOB";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseContractBLOBHome.class;
	}
	/**
	 * resetLeaseContractBLOBHome
	 * @generated
	 */
	public void resetLeaseContractBLOBHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseContractBLOBHome
	 * @generated
	 */
	public void setLeaseContractBLOBHome(
		com.hps.july.persistence.LeaseContractBLOBHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseContractBLOB create(
		int argLeaseDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseContractBLOBHome().create(argLeaseDocument);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseContractBLOB findByPrimaryKey(
		com.hps.july.persistence.LeaseContractBLOBKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseContractBLOBHome().findByPrimaryKey(key);
	}
}
