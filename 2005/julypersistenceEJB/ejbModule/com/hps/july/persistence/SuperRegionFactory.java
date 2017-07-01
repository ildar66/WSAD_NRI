package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * SuperRegionFactory
 * @generated
 */
public class SuperRegionFactory extends AbstractEJBFactory {
	/**
	 * SuperRegionFactory
	 * @generated
	 */
	public SuperRegionFactory() {
		super();
	}
	/**
	 * _acquireSuperRegionHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.SuperRegionHome _acquireSuperRegionHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.SuperRegionHome) _acquireEJBHome();
	}
	/**
	 * acquireSuperRegionHome
	 * @generated
	 */
	public com.hps.july.persistence.SuperRegionHome acquireSuperRegionHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.SuperRegionHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/SuperRegion";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.SuperRegionHome.class;
	}
	/**
	 * resetSuperRegionHome
	 * @generated
	 */
	public void resetSuperRegionHome() {
		resetEJBHome();
	}
	/**
	 * setSuperRegionHome
	 * @generated
	 */
	public void setSuperRegionHome(
		com.hps.july.persistence.SuperRegionHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.SuperRegion create(
		int argSupregid,
		java.lang.String argSupregname,
		int argSupregcode)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSuperRegionHome().create(
			argSupregid,
			argSupregname,
			argSupregcode);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.SuperRegion create(
		int argSupregid,
		java.lang.String argSupregname)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSuperRegionHome().create(argSupregid, argSupregname);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.SuperRegion findByPrimaryKey(
		com.hps.july.persistence.SuperRegionKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSuperRegionHome().findByPrimaryKey(key);
	}
	/**
	 * findAllOrderByCodeAsc
	 * @generated
	 */
	public java.util.Enumeration findAllOrderByCodeAsc()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSuperRegionHome().findAllOrderByCodeAsc();
	}
}
