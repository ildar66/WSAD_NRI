package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * SwitchFactory
 * @generated
 */
public class SwitchFactory extends AbstractEJBFactory {
	/**
	 * SwitchFactory
	 * @generated
	 */
	public SwitchFactory() {
		super();
	}
	/**
	 * _acquireSwitchHome
	 * @generated
	 */
	protected com.hps.july.persistence.SwitchHome _acquireSwitchHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.SwitchHome) _acquireEJBHome();
	}
	/**
	 * acquireSwitchHome
	 * @generated
	 */
	public com.hps.july.persistence.SwitchHome acquireSwitchHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.SwitchHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Switch";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.SwitchHome.class;
	}
	/**
	 * resetSwitchHome
	 * @generated
	 */
	public void resetSwitchHome() {
		resetEJBHome();
	}
	/**
	 * setSwitchHome
	 * @generated
	 */
	public void setSwitchHome(com.hps.july.persistence.SwitchHome home) {
		setEJBHome(home);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isNumber,
		java.lang.Integer argNumber,
		java.lang.Boolean isType,
		java.lang.String argType,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSwitchHome().findByQBE(
			isNumber,
			argNumber,
			isType,
			argType,
			order);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(
		java.lang.Boolean isNumber,
		java.lang.Integer argNumber,
		java.lang.Boolean isType,
		java.lang.String argType,
		java.lang.Boolean isPlanState,
		java.lang.String argPlanState,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSwitchHome().findByQBE2(
			isNumber,
			argNumber,
			isType,
			argType,
			isPlanState,
			argPlanState,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Switch create(
		int argStorageplace,
		java.lang.Integer argDivision,
		java.lang.String argName,
		java.lang.String argAddress)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSwitchHome().create(
			argStorageplace,
			argDivision,
			argName,
			argAddress);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Switch findByPrimaryKey(
		com.hps.july.persistence.StoragePlaceKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSwitchHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Switch create(
		int argStorageplace,
		java.lang.Integer argDivision,
		java.lang.String argName,
		java.lang.String argAddress,
		java.lang.Integer argPosition,
		java.lang.String argType,
		java.lang.Integer argNumber)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSwitchHome().create(
			argStorageplace,
			argDivision,
			argName,
			argAddress,
			argPosition,
			argType,
			argNumber);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Switch create(int argStorageplace)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSwitchHome().create(argStorageplace);
	}
	/**
	 * findSwitchesByResource
	 * @generated
	 */
	public java.util.Enumeration findSwitchesByResource(
		com.hps.july.persistence.ResourceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSwitchHome().findSwitchesByResource(inKey);
	}
	/**
	 * findAllOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findAllOrderByNameAsc()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSwitchHome().findAllOrderByNameAsc();
	}
}
