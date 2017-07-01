package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgEquipObjectsCfgFactory
 * @generated
 */
public class CfgEquipObjectsCfgFactory extends AbstractEJBFactory {
	/**
	 * CfgEquipObjectsCfgFactory
	 * @generated
	 */
	public CfgEquipObjectsCfgFactory() {
		super();
	}
	/**
	 * _acquireCfgEquipObjectsCfgHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgEquipObjectsCfgHome _acquireCfgEquipObjectsCfgHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.config
			.beans
			.CfgEquipObjectsCfgHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgEquipObjectsCfgHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgEquipObjectsCfgHome acquireCfgEquipObjectsCfgHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.config
			.beans
			.CfgEquipObjectsCfgHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgEquipObjectsCfgHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgEquipObjectsCfgHome.class;
	}
	/**
	 * resetCfgEquipObjectsCfgHome
	 * @generated
	 */
	public void resetCfgEquipObjectsCfgHome() {
		resetEJBHome();
	}
	/**
	 * setCfgEquipObjectsCfgHome
	 * @generated
	 */
	public void setCfgEquipObjectsCfgHome(
		com.hps.july.config.beans.CfgEquipObjectsCfgHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgEquipObjectsCfg findByPrimaryKey(
		com.hps.july.config.beans.CfgEquipObjectsCfgKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgEquipObjectsCfgHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgEquipObjectsCfg create(
		int savconfigid,
		int objcfgid,
		int equipment,
		java.lang.String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgEquipObjectsCfgHome().create(
			savconfigid,
			objcfgid,
			equipment,
			objectstatus);
	}
}
