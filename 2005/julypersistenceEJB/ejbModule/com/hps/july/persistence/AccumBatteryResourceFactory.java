package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AccumBatteryResourceFactory
 * @generated
 */
public class AccumBatteryResourceFactory extends AbstractEJBFactory {
	/**
	 * AccumBatteryResourceFactory
	 * @generated
	 */
	public AccumBatteryResourceFactory() {
		super();
	}
	/**
	 * _acquireAccumBatteryResourceHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.AccumBatteryResourceHome _acquireAccumBatteryResourceHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.AccumBatteryResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireAccumBatteryResourceHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.AccumBatteryResourceHome acquireAccumBatteryResourceHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.AccumBatteryResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/AccumBatteryResourceHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.AccumBatteryResourceHome.class;
	}
	/**
	 * resetAccumBatteryResourceHome
	 * @generated
	 */
	public void resetAccumBatteryResourceHome() {
		resetEJBHome();
	}
	/**
	 * setAccumBatteryResourceHome
	 * @generated
	 */
	public void setAccumBatteryResourceHome(
		com.hps.july.persistence.AccumBatteryResourceHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.AccumBatteryResource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireAccumBatteryResourceHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AccumBatteryResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAccumBatteryResourceHome().create(
			resource,
			argUnit,
			argSubtype);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AccumBatteryResource create(
		int argResource,
		java.lang.String argName,
		java.lang.String argModel,
		java.lang.String argNotes,
		java.lang.Boolean argComplect,
		java.lang.String argCountpolicy,
		java.lang.Boolean argBoxable,
		java.lang.Boolean argPriceable,
		java.lang.Boolean argComplectpart,
		java.lang.Boolean argActive,
		int argSubType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAccumBatteryResourceHome().create(
			argResource,
			argName,
			argModel,
			argNotes,
			argComplect,
			argCountpolicy,
			argBoxable,
			argPriceable,
			argComplectpart,
			argActive,
			argSubType);
	}
}
