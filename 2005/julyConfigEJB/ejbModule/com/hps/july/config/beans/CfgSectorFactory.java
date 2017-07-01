package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgSectorFactory
 * @generated
 */
public class CfgSectorFactory extends AbstractEJBFactory {
	/**
	 * CfgSectorFactory
	 * @generated
	 */
	public CfgSectorFactory() {
		super();
	}
	/**
	 * _acquireCfgSectorHome
	 * @generated
	 */
	protected com.hps.july.config.beans.CfgSectorHome _acquireCfgSectorHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.config.beans.CfgSectorHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgSectorHome
	 * @generated
	 */
	public com.hps.july.config.beans.CfgSectorHome acquireCfgSectorHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgSectorHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgSectorHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgSectorHome.class;
	}
	/**
	 * resetCfgSectorHome
	 * @generated
	 */
	public void resetCfgSectorHome() {
		resetEJBHome();
	}
	/**
	 * setCfgSectorHome
	 * @generated
	 */
	public void setCfgSectorHome(
		com.hps.july.config.beans.CfgSectorHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgSector findByPrimaryKey(
		com.hps.july.config.beans.CfgSectorKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgSectorHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgSector create(
		int savconfigid,
		int id_sect,
		int equipment,
		java.lang.String name_sect,
		short band,
		java.lang.String num_sect,
		int datasource,
		java.lang.String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgSectorHome().create(
			savconfigid,
			id_sect,
			equipment,
			name_sect,
			band,
			num_sect,
			datasource,
			objectstatus);
	}
}
