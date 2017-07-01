package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AfsSchemeFactory
 * @generated
 */
public class AfsSchemeFactory extends AbstractEJBFactory {
	/**
	 * AfsSchemeFactory
	 * @generated
	 */
	public AfsSchemeFactory() {
		super();
	}
	/**
	 * _acquireAfsSchemeHome
	 * @generated
	 */
	protected com.hps.july.persistence2.AfsSchemeHome _acquireAfsSchemeHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence2.AfsSchemeHome) _acquireEJBHome();
	}
	/**
	 * acquireAfsSchemeHome
	 * @generated
	 */
	public com.hps.july.persistence2.AfsSchemeHome acquireAfsSchemeHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence2.AfsSchemeHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/AfsSchemeHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.AfsSchemeHome.class;
	}
	/**
	 * resetAfsSchemeHome
	 * @generated
	 */
	public void resetAfsSchemeHome() {
		resetEJBHome();
	}
	/**
	 * setAfsSchemeHome
	 * @generated
	 */
	public void setAfsSchemeHome(
		com.hps.july.persistence2.AfsSchemeHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.AfsScheme create(
		java.lang.Integer schemeid)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAfsSchemeHome().create(schemeid);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.AfsScheme findByPrimaryKey(
		com.hps.july.persistence2.AfsSchemeKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireAfsSchemeHome().findByPrimaryKey(primaryKey);
	}
}
