package com.hps.july.persistence2;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * UserRequestsFactory
 * @generated
 */
public class UserRequestsFactory extends AbstractEJBFactory {
	/**
	 * UserRequestsFactory
	 * @generated
	 */
	public UserRequestsFactory() {
		super();
	}
	/**
	 * _acquireUserRequestsHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence2
		.UserRequestsHome _acquireUserRequestsHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence2.UserRequestsHome) _acquireEJBHome();
	}
	/**
	 * acquireUserRequestsHome
	 * @generated
	 */
	public com.hps.july.persistence2.UserRequestsHome acquireUserRequestsHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence2.UserRequestsHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence2/UserRequestsHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence2.UserRequestsHome.class;
	}
	/**
	 * resetUserRequestsHome
	 * @generated
	 */
	public void resetUserRequestsHome() {
		resetEJBHome();
	}
	/**
	 * setUserRequestsHome
	 * @generated
	 */
	public void setUserRequestsHome(
		com.hps.july.persistence2.UserRequestsHome home) {
		setEJBHome(home);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence2.UserRequests findByPrimaryKey(
		com.hps.july.persistence2.UserRequestsKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireUserRequestsHome().findByPrimaryKey(primaryKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence2.UserRequests create(
		int argRequest,
		java.sql.Date argDatetimein,
		int argRequesttype,
		int argFilialtype,
		int argWorker,
		int argModule,
		java.lang.String argDescr,
		java.lang.String argStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireUserRequestsHome().create(
			argRequest,
			argDatetimein,
			argRequesttype,
			argFilialtype,
			argWorker,
			argModule,
			argDescr,
			argStatus);
	}
}
