package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ResourceClassFactory
 * @generated
 */
public class ResourceClassFactory extends AbstractEJBFactory {
	/**
	 * ResourceClassFactory
	 * @generated
	 */
	public ResourceClassFactory() {
		super();
	}
	/**
	 * _acquireResourceClassHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence2
		.ResourceClassHome _acquireResourceClassHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence2.ResourceClassHome) _acquireEJBHome();
	}
	/**
	 * acquireResourceClassHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence2
		.ResourceClassHome acquireResourceClassHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence2.ResourceClassHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/ResourceClassHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.ResourceClassHome.class;
	}
	/**
	 * resetResourceClassHome
	 * @generated
	 */
	public void resetResourceClassHome() {
		resetEJBHome();
	}
	/**
	 * setResourceClassHome
	 * @generated
	 */
	public void setResourceClassHome(
		com.hps.july.persistence2.ResourceClassHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.ResourceClass create(
		int argClassid,
		java.lang.String argClassname)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireResourceClassHome().create(argClassid, argClassname);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.ResourceClass findByPrimaryKey(
		com.hps.july.persistence2.ResourceClassKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireResourceClassHome().findByPrimaryKey(primaryKey);
	}
}
