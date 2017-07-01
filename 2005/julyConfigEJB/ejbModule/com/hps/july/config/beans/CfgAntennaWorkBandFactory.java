package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgAntennaWorkBandFactory
 * @generated
 */
public class CfgAntennaWorkBandFactory extends AbstractEJBFactory {
	/**
	 * CfgAntennaWorkBandFactory
	 * @generated
	 */
	public CfgAntennaWorkBandFactory() {
		super();
	}
	/**
	 * _acquireCfgAntennaWorkBandHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgAntennaWorkBandHome _acquireCfgAntennaWorkBandHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.config
			.beans
			.CfgAntennaWorkBandHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgAntennaWorkBandHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgAntennaWorkBandHome acquireCfgAntennaWorkBandHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.config
			.beans
			.CfgAntennaWorkBandHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgAntennaWorkBandHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgAntennaWorkBandHome.class;
	}
	/**
	 * resetCfgAntennaWorkBandHome
	 * @generated
	 */
	public void resetCfgAntennaWorkBandHome() {
		resetEJBHome();
	}
	/**
	 * setCfgAntennaWorkBandHome
	 * @generated
	 */
	public void setCfgAntennaWorkBandHome(
		com.hps.july.config.beans.CfgAntennaWorkBandHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAntennaWorkBand findByPrimaryKey(
		com.hps.july.config.beans.CfgAntennaWorkBandKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgAntennaWorkBandHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAntennaWorkBand create(
		int savconfigid,
		int idanten,
		short band,
		java.lang.String objectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgAntennaWorkBandHome().create(
			savconfigid,
			idanten,
			band,
			objectStatus);
	}
}
