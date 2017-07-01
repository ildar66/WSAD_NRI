package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgEquipObjCfg2SectorFactory
 * @generated
 */
public class CfgEquipObjCfg2SectorFactory extends AbstractEJBFactory {
	/**
	 * CfgEquipObjCfg2SectorFactory
	 * @generated
	 */
	public CfgEquipObjCfg2SectorFactory() {
		super();
	}
	/**
	 * _acquireCfgEquipObjCfg2SectorHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgEquipObjCfg2SectorHome _acquireCfgEquipObjCfg2SectorHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.config
			.beans
			.CfgEquipObjCfg2SectorHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgEquipObjCfg2SectorHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgEquipObjCfg2SectorHome acquireCfgEquipObjCfg2SectorHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.config
			.beans
			.CfgEquipObjCfg2SectorHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgEquipObjCfg2SectorHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgEquipObjCfg2SectorHome.class;
	}
	/**
	 * resetCfgEquipObjCfg2SectorHome
	 * @generated
	 */
	public void resetCfgEquipObjCfg2SectorHome() {
		resetEJBHome();
	}
	/**
	 * setCfgEquipObjCfg2SectorHome
	 * @generated
	 */
	public void setCfgEquipObjCfg2SectorHome(
		com.hps.july.config.beans.CfgEquipObjCfg2SectorHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgEquipObjCfg2Sector create(
		int savconfigid,
		int objcfgid,
		int id_sect,
		java.lang.String objectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgEquipObjCfg2SectorHome().create(
			savconfigid,
			objcfgid,
			id_sect,
			objectStatus);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgEquipObjCfg2Sector findByPrimaryKey(
		com.hps.july.config.beans.CfgEquipObjCfg2SectorKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgEquipObjCfg2SectorHome().findByPrimaryKey(primaryKey);
	}
}
