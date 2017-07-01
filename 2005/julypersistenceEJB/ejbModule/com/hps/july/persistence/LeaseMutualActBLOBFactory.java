package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseMutualActBLOBFactory
 * @generated
 */
public class LeaseMutualActBLOBFactory extends AbstractEJBFactory {
	/**
	 * LeaseMutualActBLOBFactory
	 * @generated
	 */
	public LeaseMutualActBLOBFactory() {
		super();
	}
	/**
	 * _acquireLeaseMutualActBLOBHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.LeaseMutualActBLOBHome _acquireLeaseMutualActBLOBHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.LeaseMutualActBLOBHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseMutualActBLOBHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseMutualActBLOBHome acquireLeaseMutualActBLOBHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.LeaseMutualActBLOBHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeaseMutualActBLOB";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseMutualActBLOBHome.class;
	}
	/**
	 * resetLeaseMutualActBLOBHome
	 * @generated
	 */
	public void resetLeaseMutualActBLOBHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseMutualActBLOBHome
	 * @generated
	 */
	public void setLeaseMutualActBLOBHome(
		com.hps.july.persistence.LeaseMutualActBLOBHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualActBLOB findByPrimaryKey(
		com.hps.july.persistence.LeaseMutualActBLOBKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualActBLOBHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualActBLOB create(
		int argLeasedocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseMutualActBLOBHome().create(argLeasedocument);
	}
}
