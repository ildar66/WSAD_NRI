package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AfsMountActFactory
 * @generated
 */
public class AfsMountActFactory extends AbstractEJBFactory {
	/**
	 * AfsMountActFactory
	 * @generated
	 */
	public AfsMountActFactory() {
		super();
	}
	/**
	 * _acquireAfsMountActHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.AfsMountActHome _acquireAfsMountActHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.AfsMountActHome) _acquireEJBHome();
	}
	/**
	 * acquireAfsMountActHome
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountActHome acquireAfsMountActHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.AfsMountActHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/AfsMountAct";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.AfsMountActHome.class;
	}
	/**
	 * resetAfsMountActHome
	 * @generated
	 */
	public void resetAfsMountActHome() {
		resetEJBHome();
	}
	/**
	 * setAfsMountActHome
	 * @generated
	 */
	public void setAfsMountActHome(
		com.hps.july.persistence.AfsMountActHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.lang.Integer argFrom,
		java.lang.Integer argTo,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argBlankNumber,
		java.lang.String argState,
		java.lang.Boolean argProcessSource,
		java.lang.Boolean argProcessDestination,
		java.lang.Boolean argFixing)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAfsMountActHome().create(
			argDocument,
			argOwner,
			argFrom,
			argTo,
			argBlankDate,
			argBlankindex,
			argBlankNumber,
			argState,
			argProcessSource,
			argProcessDestination,
			argFixing);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(
		java.lang.Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isPosition,
		java.lang.Integer position,
		java.lang.Boolean isProvider,
		java.lang.Integer provider,
		java.lang.Boolean isWorker,
		java.lang.Integer worker,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountActHome().findByQBE2(
			isDate,
			datefrom,
			dateto,
			isOwner,
			owner,
			isPosition,
			position,
			isProvider,
			provider,
			isWorker,
			worker,
			order);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountAct findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountActHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAfsMountActHome().create(
			argDocument,
			argOwner,
			argBlankDate,
			argBlankindex,
			argState);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AfsMountAct create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAfsMountActHome().create(argDocument);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isDate,
		java.sql.Date startDate,
		java.sql.Date endDate,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isStorage,
		java.lang.Integer storage,
		java.lang.Boolean isContractor,
		java.lang.Integer contractor,
		java.lang.Boolean isWorker,
		java.lang.Integer worker,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAfsMountActHome().findByQBE(
			isDate,
			startDate,
			endDate,
			isOwner,
			owner,
			isStorage,
			storage,
			isContractor,
			contractor,
			isWorker,
			worker,
			order);
	}
}
