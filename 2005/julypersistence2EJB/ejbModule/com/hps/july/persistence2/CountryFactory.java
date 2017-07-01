package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CountryFactory
 * @generated
 */
public class CountryFactory extends AbstractEJBFactory {
	/**
	 * CountryFactory
	 * @generated
	 */
	public CountryFactory() {
		super();
	}
	/**
	 * _acquireCountryHome
	 * @generated
	 */
	protected com.hps.july.persistence2.CountryHome _acquireCountryHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence2.CountryHome) _acquireEJBHome();
	}
	/**
	 * acquireCountryHome
	 * @generated
	 */
	public com.hps.july.persistence2.CountryHome acquireCountryHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence2.CountryHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/CountryHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.CountryHome.class;
	}
	/**
	 * resetCountryHome
	 * @generated
	 */
	public void resetCountryHome() {
		resetEJBHome();
	}
	/**
	 * setCountryHome
	 * @generated
	 */
	public void setCountryHome(com.hps.july.persistence2.CountryHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.Country create(
		int argCountry,
		java.lang.String argName,
		java.math.BigDecimal argCCode)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCountryHome().create(argCountry, argName, argCCode);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.Country findByPrimaryKey(
		com.hps.july.persistence2.CountryKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCountryHome().findByPrimaryKey(primaryKey);
	}
}
