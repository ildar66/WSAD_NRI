package com.hps.july.config.beans;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgAntennaFactory
 * @generated
 */
public class CfgAntennaFactory extends AbstractEJBFactory {
	/**
	 * CfgAntennaFactory
	 * @generated
	 */
	public CfgAntennaFactory() {
		super();
	}
	/**
	 * _acquireCfgAntennaHome
	 * @generated
	 */
	protected com.hps.july.config.beans.CfgAntennaHome _acquireCfgAntennaHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.config.beans.CfgAntennaHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgAntennaHome
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAntennaHome acquireCfgAntennaHome()
		throws javax.naming.NamingException {
		return (com.hps.july.config.beans.CfgAntennaHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/config/beans/CfgAntennaHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.config.beans.CfgAntennaHome.class;
	}
	/**
	 * resetCfgAntennaHome
	 * @generated
	 */
	public void resetCfgAntennaHome() {
		resetEJBHome();
	}
	/**
	 * setCfgAntennaHome
	 * @generated
	 */
	public void setCfgAntennaHome(
		com.hps.july.config.beans.CfgAntennaHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAntenna create(
		int savconfigid,
		int id_anten,
		int resource,
		java.lang.String num_ant,
		java.lang.String kind_ant,
		java.math.BigDecimal nakl,
		java.math.BigDecimal az_ant,
		java.math.BigDecimal h_set1,
		java.math.BigDecimal len_cable,
		int equipment,
		boolean byhand,
		java.lang.String locationtype,
		int datasource,
		java.lang.String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgAntennaHome().create(
			savconfigid,
			id_anten,
			resource,
			num_ant,
			kind_ant,
			nakl,
			az_ant,
			h_set1,
			len_cable,
			equipment,
			byhand,
			locationtype,
			datasource,
			objectstatus);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.config.beans.CfgAntenna findByPrimaryKey(
		com.hps.july.config.beans.CfgAntennaKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgAntennaHome().findByPrimaryKey(primaryKey);
	}
}
