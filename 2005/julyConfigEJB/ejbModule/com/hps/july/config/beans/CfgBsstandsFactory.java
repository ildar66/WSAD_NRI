package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgBsstandsFactory
 * @generated
 */
public class CfgBsstandsFactory extends AbstractEJBFactory {
	/**
	 * CfgBsstandsFactory
	 * @generated
	 */
	public CfgBsstandsFactory() {
		super();
	}
	/**
	 * _acquireCfgBsstandsHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgBsstandsHome _acquireCfgBsstandsHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.config.beans.CfgBsstandsHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgBsstandsHome
	 * @generated
	 */
	public com.hps.july.config.beans.CfgBsstandsHome acquireCfgBsstandsHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgBsstandsHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgBsstandsHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgBsstandsHome.class;
	}
	/**
	 * resetCfgBsstandsHome
	 * @generated
	 */
	public void resetCfgBsstandsHome() {
		resetEJBHome();
	}
	/**
	 * setCfgBsstandsHome
	 * @generated
	 */
	public void setCfgBsstandsHome(
		com.hps.july.config.beans.CfgBsstandsHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgBsstands findByPrimaryKey(
		com.hps.july.config.beans.CfgBsstandsKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgBsstandsHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgBsstands create(
		int savconfigid,
		int standid,
		int equipment,
		java.lang.String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgBsstandsHome().create(
			savconfigid,
			standid,
			equipment,
			objectstatus);
	}
}
