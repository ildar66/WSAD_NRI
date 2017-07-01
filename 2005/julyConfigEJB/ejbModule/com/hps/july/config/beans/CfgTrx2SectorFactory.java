package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgTrx2SectorFactory
 * @generated
 */
public class CfgTrx2SectorFactory extends AbstractEJBFactory {
	/**
	 * CfgTrx2SectorFactory
	 * @generated
	 */
	public CfgTrx2SectorFactory() {
		super();
	}
	/**
	 * _acquireCfgTrx2SectorHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.config
		.beans
		.CfgTrx2SectorHome _acquireCfgTrx2SectorHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.config.beans.CfgTrx2SectorHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgTrx2SectorHome
	 * @generated
	 */
	public com
		.hps
		.july
		.config
		.beans
		.CfgTrx2SectorHome acquireCfgTrx2SectorHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgTrx2SectorHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgTrx2SectorHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgTrx2SectorHome.class;
	}
	/**
	 * resetCfgTrx2SectorHome
	 * @generated
	 */
	public void resetCfgTrx2SectorHome() {
		resetEJBHome();
	}
	/**
	 * setCfgTrx2SectorHome
	 * @generated
	 */
	public void setCfgTrx2SectorHome(
		com.hps.july.config.beans.CfgTrx2SectorHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgTrx2Sector findByPrimaryKey(
		com.hps.july.config.beans.CfgTrx2SectorKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgTrx2SectorHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgTrx2Sector create(
		int savconfigid,
		int trxid,
		int id_sect,
		java.lang.String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgTrx2SectorHome().create(
			savconfigid,
			trxid,
			id_sect,
			objectstatus);
	}
}
