package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgTrxFactory
 * @generated
 */
public class CfgTrxFactory extends AbstractEJBFactory {
	/**
	 * CfgTrxFactory
	 * @generated
	 */
	public CfgTrxFactory() {
		super();
	}
	/**
	 * _acquireCfgTrxHome
	 * @generated
	 */
	protected com.hps.july.config.beans.CfgTrxHome _acquireCfgTrxHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.config.beans.CfgTrxHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgTrxHome
	 * @generated
	 */
	public com.hps.july.config.beans.CfgTrxHome acquireCfgTrxHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgTrxHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgTrxHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgTrxHome.class;
	}
	/**
	 * resetCfgTrxHome
	 * @generated
	 */
	public void resetCfgTrxHome() {
		resetEJBHome();
	}
	/**
	 * setCfgTrxHome
	 * @generated
	 */
	public void setCfgTrxHome(com.hps.july.config.beans.CfgTrxHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgTrx findByPrimaryKey(
		com.hps.july.config.beans.CfgTrxKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgTrxHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgTrx create(
		int argSavconfigid,
		int argEquipment,
		int argTrxid,
		int argResource,
		int argStandid,
		java.lang.String argObjectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgTrxHome().create(
			argSavconfigid,
			argEquipment,
			argTrxid,
			argResource,
			argStandid,
			argObjectstatus);
	}
}
