package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * RequestFactory
 * @generated
 */
public class RequestFactory extends AbstractEJBFactory {
	/**
	 * RequestFactory
	 * @generated
	 */
	public RequestFactory() {
		super();
	}
	/**
	 * _acquireRequestHome
	 * @generated
	 */
	protected com.hps.july.persistence.RequestHome _acquireRequestHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.RequestHome) _acquireEJBHome();
	}
	/**
	 * acquireRequestHome
	 * @generated
	 */
	public com.hps.july.persistence.RequestHome acquireRequestHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.RequestHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Request";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.RequestHome.class;
	}
	/**
	 * resetRequestHome
	 * @generated
	 */
	public void resetRequestHome() {
		resetEJBHome();
	}
	/**
	 * setRequestHome
	 * @generated
	 */
	public void setRequestHome(com.hps.july.persistence.RequestHome home) {
		setEJBHome(home);
	}
	/**
	 * findRequestSenderBySender
	 * @generated
	 */
	public java.util.Enumeration findRequestSenderBySender(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRequestHome().findRequestSenderBySender(inKey);
	}
	/**
	 * findRequestByChecker
	 * @generated
	 */
	public java.util.Enumeration findRequestByChecker(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRequestHome().findRequestByChecker(inKey);
	}
	/**
	 * findRequestByDivisionRequester
	 * @generated
	 */
	public java.util.Enumeration findRequestByDivisionRequester(
		com.hps.july.persistence.DivisionKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRequestHome().findRequestByDivisionRequester(inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Request findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRequestHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Request create(
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
		java.lang.Integer argDivisionRequester)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRequestHome().create(
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
			argDivisionRequester);
	}
	/**
	 * findRequestByPosition
	 * @generated
	 */
	public java.util.Enumeration findRequestByPosition(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRequestHome().findRequestByPosition(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Request create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRequestHome().create(
			argDocument,
			argOwner,
			argBlankDate,
			argBlankindex,
			argState);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean useDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		java.lang.Boolean useDivision,
		java.lang.Integer division,
		java.lang.Boolean usePosition,
		java.lang.Integer position,
		java.lang.String requestType,
		java.lang.Boolean useOrganization,
		java.lang.Integer organization,
		java.lang.Boolean useWorker,
		java.lang.Integer worker,
		java.lang.Boolean hasNoLink)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireRequestHome().findByQBE(
			useDate,
			datefrom,
			dateto,
			useDivision,
			division,
			usePosition,
			position,
			requestType,
			useOrganization,
			organization,
			useWorker,
			worker,
			hasNoLink);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Request create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireRequestHome().create(argDocument);
	}
}
