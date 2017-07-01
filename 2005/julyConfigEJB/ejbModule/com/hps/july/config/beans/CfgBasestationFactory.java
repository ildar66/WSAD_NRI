package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgBasestationFactory
 * @generated
 */
public class CfgBasestationFactory extends AbstractEJBFactory {
	/**
	 * CfgBasestationFactory
	 * @generated
	 */
	public CfgBasestationFactory() {
		super();
	}
	/**
	 * _acquireCfgBasestationHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgBasestationHome _acquireCfgBasestationHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.config.beans.CfgBasestationHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgBasestationHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgBasestationHome acquireCfgBasestationHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgBasestationHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgBasestationHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgBasestationHome.class;
	}
	/**
	 * resetCfgBasestationHome
	 * @generated
	 */
	public void resetCfgBasestationHome() {
		resetEJBHome();
	}
	/**
	 * setCfgBasestationHome
	 * @generated
	 */
	public void setCfgBasestationHome(
		com.hps.july.config.beans.CfgBasestationHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgBasestation findByPrimaryKey(
		com.hps.july.config.beans.CfgBasestationKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgBasestationHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgBasestation create(
		int argSavconfigid,
		int argEquipment,
		java.lang.String argType,
		boolean argRepeater,
		int argNumber,
		java.lang.String argName,
		java.lang.String argObjectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgBasestationHome().create(
			argSavconfigid,
			argEquipment,
			argType,
			argRepeater,
			argNumber,
			argName,
			argObjectStatus);
	}
}
