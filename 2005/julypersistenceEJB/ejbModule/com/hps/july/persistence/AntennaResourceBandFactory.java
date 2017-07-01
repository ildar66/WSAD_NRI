package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AntennaResourceBandFactory
 * @generated
 */
public class AntennaResourceBandFactory extends AbstractEJBFactory {
	/**
	 * AntennaResourceBandFactory
	 * @generated
	 */
	public AntennaResourceBandFactory() {
		super();
	}
	/**
	 * _acquireAntennaResourceBandHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.AntennaResourceBandHome _acquireAntennaResourceBandHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence
			.AntennaResourceBandHome) _acquireEJBHome();
	}
	/**
	 * acquireAntennaResourceBandHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.AntennaResourceBandHome acquireAntennaResourceBandHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence
			.AntennaResourceBandHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/AntennaResourceBand";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.AntennaResourceBandHome.class;
	}
	/**
	 * resetAntennaResourceBandHome
	 * @generated
	 */
	public void resetAntennaResourceBandHome() {
		resetEJBHome();
	}
	/**
	 * setAntennaResourceBandHome
	 * @generated
	 */
	public void setAntennaResourceBandHome(
		com.hps.july.persistence.AntennaResourceBandHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AntennaResourceBand create(
		int argResource,
		short argBand)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAntennaResourceBandHome().create(argResource, argBand);
	}
	/**
	 * findAntennaResourceBandsByResource
	 * @generated
	 */
	public java.util.Enumeration findAntennaResourceBandsByResource(
		com.hps.july.persistence.ResourceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAntennaResourceBandHome()
			.findAntennaResourceBandsByResource(
			inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.AntennaResourceBand findByPrimaryKey(
		com.hps.july.persistence.AntennaResourceBandKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAntennaResourceBandHome().findByPrimaryKey(key);
	}
}
