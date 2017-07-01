package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * BaseAgreementFactory
 * @generated
 */
public class BaseAgreementFactory extends AbstractEJBFactory {
	/**
	 * BaseAgreementFactory
	 * @generated
	 */
	public BaseAgreementFactory() {
		super();
	}
	/**
	 * _acquireBaseAgreementHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.BaseAgreementHome _acquireBaseAgreementHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.BaseAgreementHome) _acquireEJBHome();
	}
	/**
	 * acquireBaseAgreementHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.BaseAgreementHome acquireBaseAgreementHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.BaseAgreementHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/BaseAgreement";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.BaseAgreementHome.class;
	}
	/**
	 * resetBaseAgreementHome
	 * @generated
	 */
	public void resetBaseAgreementHome() {
		resetEJBHome();
	}
	/**
	 * setBaseAgreementHome
	 * @generated
	 */
	public void setBaseAgreementHome(
		com.hps.july.persistence.BaseAgreementHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.BaseAgreement findByPrimaryKey(
		com.hps.july.persistence.BaseAgreementKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseAgreementHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.BaseAgreement create(
		int argBaseagreement,
		java.lang.String argName)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireBaseAgreementHome().create(argBaseagreement, argName);
	}
	/**
	 * findAllOrderByNameDesc
	 * @generated
	 */
	public java.util.Enumeration findAllOrderByNameDesc()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseAgreementHome().findAllOrderByNameDesc();
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.BaseAgreement create(int argBaseagreement)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireBaseAgreementHome().create(argBaseagreement);
	}
	/**
	 * findAllOrderByNameAsc
	 * @generated
	 */
	public java.util.Enumeration findAllOrderByNameAsc()
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireBaseAgreementHome().findAllOrderByNameAsc();
	}
}
