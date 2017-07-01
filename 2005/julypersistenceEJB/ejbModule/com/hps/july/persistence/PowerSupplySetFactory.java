package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * PowerSupplySetFactory
 * @generated
 */
public class PowerSupplySetFactory extends AbstractEJBFactory {
	/**
	 * PowerSupplySetFactory
	 * @generated
	 */
	public PowerSupplySetFactory() {
		super();
	}
	/**
	 * _acquirePowerSupplySetHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.PowerSupplySetHome _acquirePowerSupplySetHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.PowerSupplySetHome) _acquireEJBHome();
	}
	/**
	 * acquirePowerSupplySetHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.PowerSupplySetHome acquirePowerSupplySetHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.PowerSupplySetHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/PowerSupplySetHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.PowerSupplySetHome.class;
	}
	/**
	 * resetPowerSupplySetHome
	 * @generated
	 */
	public void resetPowerSupplySetHome() {
		resetEJBHome();
	}
	/**
	 * setPowerSupplySetHome
	 * @generated
	 */
	public void setPowerSupplySetHome(
		com.hps.july.persistence.PowerSupplySetHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.PowerSupplySet create(
		int argResourceset,
		java.lang.String argName,
		java.lang.Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		java.lang.String argType,
		java.math.BigDecimal argPower)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquirePowerSupplySetHome().create(
			argResourceset,
			argName,
			argMainPart,
			argMainPartQty,
			argType,
			argPower);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.PowerSupplySet findByPrimaryKey(
		com.hps.july.persistence.ResourceSetKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquirePowerSupplySetHome().findByPrimaryKey(primaryKey);
	}
}
