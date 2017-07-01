package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * SurplusActFactory
 * @generated
 */
public class SurplusActFactory extends AbstractEJBFactory {
	/**
	 * SurplusActFactory
	 * @generated
	 */
	public SurplusActFactory() {
		super();
	}
	/**
	 * _acquireSurplusActHome
	 * @generated
	 */
	protected com.hps.july.persistence.SurplusActHome _acquireSurplusActHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.SurplusActHome) _acquireEJBHome();
	}
	/**
	 * acquireSurplusActHome
	 * @generated
	 */
	public com.hps.july.persistence.SurplusActHome acquireSurplusActHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.SurplusActHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/SurplusAct";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.SurplusActHome.class;
	}
	/**
	 * resetSurplusActHome
	 * @generated
	 */
	public void resetSurplusActHome() {
		resetEJBHome();
	}
	/**
	 * setSurplusActHome
	 * @generated
	 */
	public void setSurplusActHome(
		com.hps.july.persistence.SurplusActHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.SurplusAct create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSurplusActHome().create(argDocument);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.SurplusAct findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireSurplusActHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.SurplusAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSurplusActHome().create(
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
	public com.hps.july.persistence.SurplusAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.lang.Integer argFrom,
		java.lang.Integer argTo,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argBlankNumber,
		java.lang.String argState,
		java.lang.Boolean argProcessSource,
		java.lang.Boolean argProcessDestination)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireSurplusActHome().create(
			argDocument,
			argOwner,
			argFrom,
			argTo,
			argBlankDate,
			argBlankindex,
			argBlankNumber,
			argState,
			argProcessSource,
			argProcessDestination);
	}
}
