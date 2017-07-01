package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * CfgDocumentFactory
 * @generated
 */
public class CfgDocumentFactory extends AbstractEJBFactory {
	/**
	 * CfgDocumentFactory
	 * @generated
	 */
	public CfgDocumentFactory() {
		super();
	}
	/**
	 * _acquireCfgDocumentHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.CfgDocumentHome _acquireCfgDocumentHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.CfgDocumentHome) _acquireEJBHome();
	}
	/**
	 * acquireCfgDocumentHome
	 * @generated
	 */
	public com.hps.july.persistence.CfgDocumentHome acquireCfgDocumentHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.CfgDocumentHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "ejb/com/hps/july/persistence/CfgDocumentHome";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.CfgDocumentHome.class;
	}
	/**
	 * resetCfgDocumentHome
	 * @generated
	 */
	public void resetCfgDocumentHome() {
		resetEJBHome();
	}
	/**
	 * setCfgDocumentHome
	 * @generated
	 */
	public void setCfgDocumentHome(
		com.hps.july.persistence.CfgDocumentHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.CfgDocument create(
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
		int SavconfigIdOld,
		int SavconfigIdNew)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireCfgDocumentHome().create(
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
			SavconfigIdOld,
			SavconfigIdNew);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.CfgDocument findByPrimaryKey(
		com.hps.july.persistence.DocumentKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException {
		return _acquireCfgDocumentHome().findByPrimaryKey(primaryKey);
	}
}
