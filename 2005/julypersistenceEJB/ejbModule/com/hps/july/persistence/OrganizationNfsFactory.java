package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * OrganizationNfsFactory
 * @generated
 */
public class OrganizationNfsFactory extends AbstractEJBFactory {
	/**
	 * OrganizationNfsFactory
	 * @generated
	 */
	public OrganizationNfsFactory() {
		super();
	}
	/**
	 * _acquireOrganizationNfsHome
	 * @generated
	 */
	protected com.hps.july.persistence.OrganizationNfsHome _acquireOrganizationNfsHome() throws java.rmi.RemoteException {
		return (com.hps.july.persistence.OrganizationNfsHome) _acquireEJBHome();
	}
	/**
	 * acquireOrganizationNfsHome
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationNfsHome acquireOrganizationNfsHome() throws javax.naming.NamingException {
		return (com.hps.july.persistence.OrganizationNfsHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/OrganizationNfs";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.OrganizationNfsHome.class;
	}
	/**
	 * resetOrganizationNfsHome
	 * @generated
	 */
	public void resetOrganizationNfsHome() {
		resetEJBHome();
	}
	/**
	 * setOrganizationNfsHome
	 * @generated
	 */
	public void setOrganizationNfsHome(com.hps.july.persistence.OrganizationNfsHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationNfs create(int organization) throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOrganizationNfsHome().create(organization);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.OrganizationNfs findByPrimaryKey(com.hps.july.persistence.OrganizationNfsKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireOrganizationNfsHome().findByPrimaryKey(primaryKey);
	}
}
