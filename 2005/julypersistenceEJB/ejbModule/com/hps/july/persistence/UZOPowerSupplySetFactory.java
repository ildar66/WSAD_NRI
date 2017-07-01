package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * UZOPowerSupplySetFactory
 * @generated
 */
public class UZOPowerSupplySetFactory extends AbstractEJBFactory {
	/**
	 * UZOPowerSupplySetFactory
	 * @generated
	 */
	public UZOPowerSupplySetFactory() {
		super();
	}
	/**
	 * _acquireUZOPowerSupplySetHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.UZOPowerSupplySetHome _acquireUZOPowerSupplySetHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.UZOPowerSupplySetHome) _acquireEJBHome();
	}
	/**
	 * acquireUZOPowerSupplySetHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.UZOPowerSupplySetHome acquireUZOPowerSupplySetHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.UZOPowerSupplySetHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/UZOPowerSupplySetHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.UZOPowerSupplySetHome.class;
	}
	/**
	 * resetUZOPowerSupplySetHome
	 * @generated
	 */
	public void resetUZOPowerSupplySetHome() {
		resetEJBHome();
	}
	/**
	 * setUZOPowerSupplySetHome
	 * @generated
	 */
	public void setUZOPowerSupplySetHome(
		com.hps.july.persistence.UZOPowerSupplySetHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.UZOPowerSupplySet create(
		int argResourceset,
		java.lang.String argName,
		java.lang.Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		java.lang.String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireUZOPowerSupplySetHome().create(
			argResourceset,
			argName,
			argMainPart,
			argMainPartQty,
			argType);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.UZOPowerSupplySet findByPrimaryKey(
		com.hps.july.persistence.ResourceSetKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireUZOPowerSupplySetHome().findByPrimaryKey(primaryKey);
	}
}
