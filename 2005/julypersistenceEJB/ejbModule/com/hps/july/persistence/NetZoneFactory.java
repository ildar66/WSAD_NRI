package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * NetZoneFactory
 * @generated
 */
public class NetZoneFactory extends AbstractEJBFactory {
	/**
	 * NetZoneFactory
	 * @generated
	 */
	public NetZoneFactory() {
		super();
	}
	/**
	 * _acquireNetZoneHome
	 * @generated
	 */
	protected com.hps.july.persistence.NetZoneHome _acquireNetZoneHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.NetZoneHome) _acquireEJBHome();
	}
	/**
	 * acquireNetZoneHome
	 * @generated
	 */
	public com.hps.july.persistence.NetZoneHome acquireNetZoneHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.NetZoneHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/NetZone";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.NetZoneHome.class;
	}
	/**
	 * resetNetZoneHome
	 * @generated
	 */
	public void resetNetZoneHome() {
		resetEJBHome();
	}
	/**
	 * setNetZoneHome
	 * @generated
	 */
	public void setNetZoneHome(com.hps.july.persistence.NetZoneHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.NetZone create(
		int argNetzone,
		java.lang.String argName,
		java.lang.String argZonecode)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireNetZoneHome().create(argNetzone, argName, argZonecode);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.NetZone create(
		int argNetzone,
		java.lang.String argName,
		java.lang.String argZonecode,
		int argRegionId)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireNetZoneHome().create(
			argNetzone,
			argName,
			argZonecode,
			argRegionId);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.NetZone findByPrimaryKey(
		com.hps.july.persistence.NetZoneKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireNetZoneHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.NetZone create(
		int argNetzone,
		java.lang.String argName,
		java.lang.String argZonecode,
		int argRegionId,
		java.math.BigDecimal argTCode)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireNetZoneHome().create(
			argNetzone,
			argName,
			argZonecode,
			argRegionId,
			argTCode);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.NetZone create(int argNetzone)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireNetZoneHome().create(argNetzone);
	}
	/**
	 * findAllOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findAllOrderByNameAsc()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireNetZoneHome().findAllOrderByNameAsc();
	}
}
