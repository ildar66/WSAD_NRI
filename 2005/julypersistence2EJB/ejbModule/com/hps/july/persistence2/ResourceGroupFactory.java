package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ResourceGroupFactory
 * @generated
 */
public class ResourceGroupFactory extends AbstractEJBFactory {
	/**
	 * ResourceGroupFactory
	 * @generated
	 */
	public ResourceGroupFactory() {
		super();
	}
	/**
	 * _acquireResourceGroupHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence2
		.ResourceGroupHome _acquireResourceGroupHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence2.ResourceGroupHome) _acquireEJBHome();
	}
	/**
	 * acquireResourceGroupHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence2
		.ResourceGroupHome acquireResourceGroupHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence2.ResourceGroupHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/ResourceGroupHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.ResourceGroupHome.class;
	}
	/**
	 * resetResourceGroupHome
	 * @generated
	 */
	public void resetResourceGroupHome() {
		resetEJBHome();
	}
	/**
	 * setResourceGroupHome
	 * @generated
	 */
	public void setResourceGroupHome(
		com.hps.july.persistence2.ResourceGroupHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.ResourceGroup create(int groupid)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireResourceGroupHome().create(groupid);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.ResourceGroup findByPrimaryKey(
		com.hps.july.persistence2.ResourceGroupKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireResourceGroupHome().findByPrimaryKey(primaryKey);
	}
}
