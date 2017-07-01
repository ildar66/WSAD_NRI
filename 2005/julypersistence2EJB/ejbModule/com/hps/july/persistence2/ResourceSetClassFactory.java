package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ResourceSetClassFactory
 * @generated
 */
public class ResourceSetClassFactory extends AbstractEJBFactory {
	/**
	 * ResourceSetClassFactory
	 * @generated
	 */
	public ResourceSetClassFactory() {
		super();
	}
	/**
	 * _acquireResourceSetClassHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence2
		.ResourceSetClassHome _acquireResourceSetClassHome()
		throws java.rmi.RemoteException {
		return (
			com
			.hps
			.july
			.persistence2
			.ResourceSetClassHome) _acquireEJBHome();
	}
	/**
	 * acquireResourceSetClassHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence2
		.ResourceSetClassHome acquireResourceSetClassHome()
		throws javax.naming.NamingException {
		return (
			com
			.hps
			.july
			.persistence2
			.ResourceSetClassHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/ResourceSetClassHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.ResourceSetClassHome.class;
	}
	/**
	 * resetResourceSetClassHome
	 * @generated
	 */
	public void resetResourceSetClassHome() {
		resetEJBHome();
	}
	/**
	 * setResourceSetClassHome
	 * @generated
	 */
	public void setResourceSetClassHome(
		com.hps.july.persistence2.ResourceSetClassHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.ResourceSetClass create(
		int argClassid,
		java.lang.String argClassname)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireResourceSetClassHome().create(argClassid, argClassname);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.ResourceSetClass findByPrimaryKey(
		com.hps.july.persistence2.ResourceSetClassKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireResourceSetClassHome().findByPrimaryKey(primaryKey);
	}
}
