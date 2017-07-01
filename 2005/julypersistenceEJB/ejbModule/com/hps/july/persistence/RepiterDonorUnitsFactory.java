package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * RepiterDonorUnitsFactory
 * @generated
 */
public class RepiterDonorUnitsFactory extends AbstractEJBFactory {
	/**
	 * RepiterDonorUnitsFactory
	 * @generated
	 */
	public RepiterDonorUnitsFactory() {
		super();
	}
	/**
	 * _acquireRepiterDonorUnitsHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.RepiterDonorUnitsHome _acquireRepiterDonorUnitsHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.RepiterDonorUnitsHome) _acquireEJBHome();
	}
	/**
	 * acquireRepiterDonorUnitsHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.RepiterDonorUnitsHome acquireRepiterDonorUnitsHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.RepiterDonorUnitsHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/RepiterDonorUnitsHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.RepiterDonorUnitsHome.class;
	}
	/**
	 * resetRepiterDonorUnitsHome
	 * @generated
	 */
	public void resetRepiterDonorUnitsHome() {
		resetEJBHome();
	}
	/**
	 * setRepiterDonorUnitsHome
	 * @generated
	 */
	public void setRepiterDonorUnitsHome(
		com.hps.july.persistence.RepiterDonorUnitsHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RepiterDonorUnits create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRepiterDonorUnitsHome().create(
			resource,
			argUnit,
			argSubtype);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.RepiterDonorUnits findByPrimaryKey(
		com.hps.july.persistence.ResourceKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireRepiterDonorUnitsHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.RepiterDonorUnits create(
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
		return _acquireRepiterDonorUnitsHome().create(
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
