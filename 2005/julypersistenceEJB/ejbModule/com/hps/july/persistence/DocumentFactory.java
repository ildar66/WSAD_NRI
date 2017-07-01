package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * DocumentFactory
 * @generated
 */
public class DocumentFactory extends AbstractEJBFactory {
	/**
	 * DocumentFactory
	 * @generated
	 */
	public DocumentFactory() {
		super();
	}
	/**
	 * _acquireDocumentHome
	 * @generated
	 */
	protected com.hps.july.persistence.DocumentHome _acquireDocumentHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.DocumentHome) _acquireEJBHome();
	}
	/**
	 * acquireDocumentHome
	 * @generated
	 */
	public com.hps.july.persistence.DocumentHome acquireDocumentHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.DocumentHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/Document";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.DocumentHome.class;
	}
	/**
	 * resetDocumentHome
	 * @generated
	 */
	public void resetDocumentHome() {
		resetEJBHome();
	}
	/**
	 * setDocumentHome
	 * @generated
	 */
	public void setDocumentHome(com.hps.july.persistence.DocumentHome home) {
		setEJBHome(home);
	}
	/**
	 * findContagentDocumentByContragent
	 * @generated
	 */
	public java.util.Enumeration findContagentDocumentByContragent(
		com.hps.july.persistence.OrganizationKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentHome().findContagentDocumentByContragent(inKey);
	}
	/**
	 * findOutDocumentByFrom
	 * @generated
	 */
	public java.util.Enumeration findOutDocumentByFrom(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentHome().findOutDocumentByFrom(inKey);
	}
	/**
	 * findDocumentforstoragerByStorageManager
	 * @generated
	 */
	public java.util.Enumeration findDocumentforstoragerByStorageManager(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentHome().findDocumentforstoragerByStorageManager(
			inKey);
	}
	/**
	 * findDocumentByParent
	 * @generated
	 */
	public java.util.Enumeration findDocumentByParent(
		java.lang.Integer argParent,
		java.lang.String argType)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentHome().findDocumentByParent(argParent, argType);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.Document findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentHome().findByPrimaryKey(key);
	}
	/**
	 * findInDocumentByTo
	 * @generated
	 */
	public java.util.Enumeration findInDocumentByTo(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentHome().findInDocumentByTo(inKey);
	}
	/**
	 * findDocumentByQBE
	 * @generated
	 */
	public java.util.Enumeration findDocumentByQBE(
		java.lang.Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		java.lang.Boolean isOrganization,
		java.lang.Integer organization,
		java.lang.Boolean isStorageFrom,
		java.lang.Integer storageFrom,
		java.lang.Boolean isStorageTo,
		java.lang.Integer storageTo)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentHome().findDocumentByQBE(
			isDate,
			datefrom,
			dateto,
			isOrganization,
			organization,
			isStorageFrom,
			storageFrom,
			isStorageTo,
			storageTo);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Document create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireDocumentHome().create(
			argDocument,
			argOwner,
			argBlankDate,
			argBlankindex,
			argState);
	}
	/**
	 * findOwnedDocumentByOwner
	 * @generated
	 */
	public java.util.Enumeration findOwnedDocumentByOwner(
		com.hps.july.persistence.OrganizationKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireDocumentHome().findOwnedDocumentByOwner(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.Document create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireDocumentHome().create(argDocument);
	}
}
