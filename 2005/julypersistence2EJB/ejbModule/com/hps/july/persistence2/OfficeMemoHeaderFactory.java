package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * OfficeMemoHeaderFactory
 * @generated
 */
public class OfficeMemoHeaderFactory extends AbstractEJBFactory {
	/**
	 * OfficeMemoHeaderFactory
	 * @generated
	 */
	public OfficeMemoHeaderFactory() {
		super();
	}
	/**
	 * _acquireOfficeMemoHeaderHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence2
		.OfficeMemoHeaderHome _acquireOfficeMemoHeaderHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence2
			.OfficeMemoHeaderHome) _acquireEJBHome();
	}
	/**
	 * acquireOfficeMemoHeaderHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence2
		.OfficeMemoHeaderHome acquireOfficeMemoHeaderHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence2
			.OfficeMemoHeaderHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence2/OfficeMemoHeader";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.OfficeMemoHeaderHome.class;
	}
	/**
	 * resetOfficeMemoHeaderHome
	 * @generated
	 */
	public void resetOfficeMemoHeaderHome() {
		resetEJBHome();
	}
	/**
	 * setOfficeMemoHeaderHome
	 * @generated
	 */
	public void setOfficeMemoHeaderHome(
		com.hps.july.persistence2.OfficeMemoHeaderHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.OfficeMemoHeader findByPrimaryKey(
		com.hps.july.persistence2.OfficeMemoHeaderKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOfficeMemoHeaderHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.OfficeMemoHeader create(
		int argIdheader,
		int argAbonentContract,
		java.lang.String argNumber,
		java.sql.Date argDate,
		int argMan,
		java.lang.String argType,
		int argTarget)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOfficeMemoHeaderHome().create(
			argIdheader,
			argAbonentContract,
			argNumber,
			argDate,
			argMan,
			argType,
			argTarget);
	}
}
