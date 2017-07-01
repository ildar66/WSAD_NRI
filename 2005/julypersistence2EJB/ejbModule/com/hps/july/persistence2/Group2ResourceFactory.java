package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * Group2ResourceFactory
 * @generated
 */
public class Group2ResourceFactory extends AbstractEJBFactory {
	/**
	 * Group2ResourceFactory
	 * @generated
	 */
	public Group2ResourceFactory() {
		super();
	}
	/**
	 * _acquireGroup2ResourceHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence2
		.Group2ResourceHome _acquireGroup2ResourceHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence2.Group2ResourceHome) _acquireEJBHome();
	}
	/**
	 * acquireGroup2ResourceHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence2
		.Group2ResourceHome acquireGroup2ResourceHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence2.Group2ResourceHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/Group2ResourceHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.Group2ResourceHome.class;
	}
	/**
	 * resetGroup2ResourceHome
	 * @generated
	 */
	public void resetGroup2ResourceHome() {
		resetEJBHome();
	}
	/**
	 * setGroup2ResourceHome
	 * @generated
	 */
	public void setGroup2ResourceHome(
		com.hps.july.persistence2.Group2ResourceHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.Group2Resource create(
		int groupid,
		int resource,
		java.math.BigDecimal qty)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireGroup2ResourceHome().create(groupid, resource, qty);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.Group2Resource findByPrimaryKey(
		com.hps.july.persistence2.Group2ResourceKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireGroup2ResourceHome().findByPrimaryKey(primaryKey);
	}
}
