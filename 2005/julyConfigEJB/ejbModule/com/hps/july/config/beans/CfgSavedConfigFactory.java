package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgSavedConfigFactory
 * @generated
 */
public class CfgSavedConfigFactory extends AbstractEJBFactory {
	/**
	 * CfgSavedConfigFactory
	 * @generated
	 */
	public CfgSavedConfigFactory() {
		super();
	}
	/**
	 * _acquireCfgSavedConfigHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgSavedConfigHome _acquireCfgSavedConfigHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.config.beans.CfgSavedConfigHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgSavedConfigHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgSavedConfigHome acquireCfgSavedConfigHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgSavedConfigHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgSavedConfigHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgSavedConfigHome.class;
	}
	/**
	 * resetCfgSavedConfigHome
	 * @generated
	 */
	public void resetCfgSavedConfigHome() {
		resetEJBHome();
	}
	/**
	 * setCfgSavedConfigHome
	 * @generated
	 */
	public void setCfgSavedConfigHome(
		com.hps.july.config.beans.CfgSavedConfigHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgSavedConfig create(
		int savconfigid,
		java.lang.String name)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgSavedConfigHome().create(savconfigid, name);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgSavedConfig findByPrimaryKey(
		com.hps.july.config.beans.CfgSavedConfigKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgSavedConfigHome().findByPrimaryKey(primaryKey);
	}
}
