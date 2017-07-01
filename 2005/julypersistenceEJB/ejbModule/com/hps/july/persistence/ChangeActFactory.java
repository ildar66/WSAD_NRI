package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * ChangeActFactory
 * @generated
 */
public class ChangeActFactory extends AbstractEJBFactory {
	/**
	 * ChangeActFactory
	 * @generated
	 */
	public ChangeActFactory() {
		super();
	}
	/**
	 * _acquireChangeActHome
	 * @generated
	 */
	protected com.hps.july.persistence.ChangeActHome _acquireChangeActHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.ChangeActHome) _acquireEJBHome();
	}
	/**
	 * acquireChangeActHome
	 * @generated
	 */
	public com.hps.july.persistence.ChangeActHome acquireChangeActHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.ChangeActHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/ChangeAct";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.ChangeActHome.class;
	}
	/**
	 * resetChangeActHome
	 * @generated
	 */
	public void resetChangeActHome() {
		resetEJBHome();
	}
	/**
	 * setChangeActHome
	 * @generated
	 */
	public void setChangeActHome(com.hps.july.persistence.ChangeActHome home) {
		setEJBHome(home);
	}
	/**
	 * findByQBEPosition2
	 * @generated
	 */
	public java.util.Enumeration findByQBEPosition2(
		java.lang.Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Character requestType,
		java.lang.Boolean isPosition,
		java.lang.Integer position,
		java.lang.Character acttype,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireChangeActHome().findByQBEPosition2(
			isDate,
			datefrom,
			dateto,
			isOwner,
			owner,
			requestType,
			isPosition,
			position,
			acttype,
			order);
	}
	/**
	 * findByQBEPosition
	 * @generated
	 */
	public java.util.Enumeration findByQBEPosition(
		java.lang.Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Character requestType,
		java.lang.Boolean isPosition,
		java.lang.Integer position,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireChangeActHome().findByQBEPosition(
			isDate,
			datefrom,
			dateto,
			isOwner,
			owner,
			requestType,
			isPosition,
			position,
			order);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isContragent,
		java.lang.Integer contragent,
		java.lang.Boolean isExpeditor,
		java.lang.Integer expeditor,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireChangeActHome().findByQBE(
			isDate,
			datefrom,
			dateto,
			isOwner,
			owner,
			isContragent,
			contragent,
			isExpeditor,
			expeditor,
			order);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.ChangeAct findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireChangeActHome().findByPrimaryKey(key);
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
		return _acquireChangeActHome().findDocumentByQBE(
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
	public com.hps.july.persistence.ChangeAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireChangeActHome().create(
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
	public com.hps.july.persistence.ChangeAct create(
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
		java.lang.String argActType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireChangeActHome().create(
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
			argActType);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.ChangeAct create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireChangeActHome().create(argDocument);
	}
}
