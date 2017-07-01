package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgAnten2SectorFactory
 * @generated
 */
public class CfgAnten2SectorFactory extends AbstractEJBFactory {
	/**
	 * CfgAnten2SectorFactory
	 * @generated
	 */
	public CfgAnten2SectorFactory() {
		super();
	}
	/**
	 * _acquireCfgAnten2SectorHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgAnten2SectorHome _acquireCfgAnten2SectorHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.config
			.beans
			.CfgAnten2SectorHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgAnten2SectorHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgAnten2SectorHome acquireCfgAnten2SectorHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgAnten2SectorHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgAnten2SectorHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgAnten2SectorHome.class;
	}
	/**
	 * resetCfgAnten2SectorHome
	 * @generated
	 */
	public void resetCfgAnten2SectorHome() {
		resetEJBHome();
	}
	/**
	 * setCfgAnten2SectorHome
	 * @generated
	 */
	public void setCfgAnten2SectorHome(
		com.hps.july.config.beans.CfgAnten2SectorHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAnten2Sector create(
		int savconfigid,
		int id_anten,
		int id_sect,
		int datasource,
		java.lang.String objectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgAnten2SectorHome().create(
			savconfigid,
			id_anten,
			id_sect,
			datasource,
			objectStatus);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAnten2Sector findByPrimaryKey(
		com.hps.july.config.beans.CfgAnten2SectorKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgAnten2SectorHome().findByPrimaryKey(primaryKey);
	}
}
