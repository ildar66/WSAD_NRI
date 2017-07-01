package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * LeaseMutualRuleNewFactory
 * @generated
 */
public class LeaseMutualRuleNewFactory extends AbstractEJBFactory {
	/**
	 * LeaseMutualRuleNewFactory
	 * @generated
	 */
	public LeaseMutualRuleNewFactory() {
		super();
	}
	/**
	 * _acquireLeaseMutualRuleNewHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.LeaseMutualRuleNewHome _acquireLeaseMutualRuleNewHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.LeaseMutualRuleNewHome) _acquireEJBHome();
	}
	/**
	 * acquireLeaseMutualRuleNewHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.LeaseMutualRuleNewHome acquireLeaseMutualRuleNewHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.LeaseMutualRuleNewHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/LeaseMutualRuleNew";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.LeaseMutualRuleNewHome.class;
	}
	/**
	 * resetLeaseMutualRuleNewHome
	 * @generated
	 */
	public void resetLeaseMutualRuleNewHome() {
		resetEJBHome();
	}
	/**
	 * setLeaseMutualRuleNewHome
	 * @generated
	 */
	public void setLeaseMutualRuleNewHome(
		com.hps.july.persistence.LeaseMutualRuleNewHome home) {
		setEJBHome(home);
	}
	/**
	 * findLeaseMutualRuleNewsByReglamentOrderByResourceAsc
	 * @generated
	 */
	public java
		.util
		.Enumeration findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(
			java.lang.Integer argreglament)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualRuleNewHome()
			.findLeaseMutualRuleNewsByReglamentOrderByResourceAsc(
			argreglament);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualRuleNew create()
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseMutualRuleNewHome().create();
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualRuleNew findByPrimaryKey(
		com.hps.july.persistence.LeaseMutualRuleNewKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualRuleNewHome().findByPrimaryKey(key);
	}
	/**
	 * findLeaseMutualRuleNewsByResource
	 * @generated
	 */
	public java.util.Enumeration findLeaseMutualRuleNewsByResource(
		com.hps.july.persistence.ResourceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualRuleNewHome()
			.findLeaseMutualRuleNewsByResource(
			inKey);
	}
	/**
	 * findLeaseMutualRulesByReglament
	 * @generated
	 */
	public java.util.Enumeration findLeaseMutualRulesByReglament(
		com.hps.july.persistence.LeaseDocumentKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireLeaseMutualRuleNewHome()
			.findLeaseMutualRulesByReglament(
			inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.LeaseMutualRuleNew create(
		java.lang.Integer argReglament,
		java.lang.Integer argResource,
		java.lang.String argChargeDateRule,
		java.lang.String argPayDateRule,
		boolean argDopChargeDateRule,
		int argRateType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireLeaseMutualRuleNewHome().create(
			argReglament,
			argResource,
			argChargeDateRule,
			argPayDateRule,
			argDopChargeDateRule,
			argRateType);
	}
}
