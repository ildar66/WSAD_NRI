package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgAntennaCableFactory
 * @generated
 */
public class CfgAntennaCableFactory extends AbstractEJBFactory {
	/**
	 * CfgAntennaCableFactory
	 * @generated
	 */
	public CfgAntennaCableFactory() {
		super();
	}
	/**
	 * _acquireCfgAntennaCableHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgAntennaCableHome _acquireCfgAntennaCableHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.config
			.beans
			.CfgAntennaCableHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgAntennaCableHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgAntennaCableHome acquireCfgAntennaCableHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgAntennaCableHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgAntennaCableHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgAntennaCableHome.class;
	}
	/**
	 * resetCfgAntennaCableHome
	 * @generated
	 */
	public void resetCfgAntennaCableHome() {
		resetEJBHome();
	}
	/**
	 * setCfgAntennaCableHome
	 * @generated
	 */
	public void setCfgAntennaCableHome(
		com.hps.july.config.beans.CfgAntennaCableHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAntennaCable create(
		int argSavconfigid,
		int argIdCable,
		int argIdAnten,
		int argCableres,
		java.math.BigDecimal argCableLen,
		int argDataSource,
		java.lang.String argObjectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgAntennaCableHome().create(
			argSavconfigid,
			argIdCable,
			argIdAnten,
			argCableres,
			argCableLen,
			argDataSource,
			argObjectStatus);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAntennaCable findByPrimaryKey(
		com.hps.july.config.beans.CfgAntennaCableKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgAntennaCableHome().findByPrimaryKey(primaryKey);
	}
}
