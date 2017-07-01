package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgStoragecardFactory
 * @generated
 */
public class CfgStoragecardFactory extends AbstractEJBFactory {
	/**
	 * CfgStoragecardFactory
	 * @generated
	 */
	public CfgStoragecardFactory() {
		super();
	}
	/**
	 * _acquireCfgStoragecardHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgStoragecardHome _acquireCfgStoragecardHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.config.beans.CfgStoragecardHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgStoragecardHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgStoragecardHome acquireCfgStoragecardHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgStoragecardHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgStoragecardHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgStoragecardHome.class;
	}
	/**
	 * resetCfgStoragecardHome
	 * @generated
	 */
	public void resetCfgStoragecardHome() {
		resetEJBHome();
	}
	/**
	 * setCfgStoragecardHome
	 * @generated
	 */
	public void setCfgStoragecardHome(
		com.hps.july.config.beans.CfgStoragecardHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgStoragecard findByPrimaryKey(
		com.hps.july.config.beans.CfgStoragecardKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgStoragecardHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgStoragecard create(
		int savconfigid,
		int storagecard,
		int resource,
		java.sql.Date dateopened,
		int owner,
		java.lang.String policy,
		java.lang.String closed,
		java.math.BigDecimal qty,
		java.math.BigDecimal price,
		boolean isfictserial,
		boolean isapproved,
		java.lang.String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgStoragecardHome().create(
			savconfigid,
			storagecard,
			resource,
			dateopened,
			owner,
			policy,
			closed,
			qty,
			price,
			isfictserial,
			isapproved,
			objectstatus);
	}
}
