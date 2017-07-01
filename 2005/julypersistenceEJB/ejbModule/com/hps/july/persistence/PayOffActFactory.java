package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * PayOffActFactory
 * @generated
 */
public class PayOffActFactory extends AbstractEJBFactory {
	/**
	 * PayOffActFactory
	 * @generated
	 */
	public PayOffActFactory() {
		super();
	}
	/**
	 * _acquirePayOffActHome
	 * @generated
	 */
	protected com.hps.july.persistence.PayOffActHome _acquirePayOffActHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.PayOffActHome) _acquireEJBHome();
	}
	/**
	 * acquirePayOffActHome
	 * @generated
	 */
	public com.hps.july.persistence.PayOffActHome acquirePayOffActHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.PayOffActHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/PayOffAct";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.PayOffActHome.class;
	}
	/**
	 * resetPayOffActHome
	 * @generated
	 */
	public void resetPayOffActHome() {
		resetEJBHome();
	}
	/**
	 * setPayOffActHome
	 * @generated
	 */
	public void setPayOffActHome(com.hps.july.persistence.PayOffActHome home) {
		setEJBHome(home);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.PayOffAct create(
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
		return _acquirePayOffActHome().create(
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
	/**
	 * findPayOffActMemberByMember1
	 * @generated
	 */
	public java.util.Enumeration findPayOffActMemberByMember1(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePayOffActHome().findPayOffActMemberByMember1(inKey);
	}
	/**
	 * findPayOffActChairManByChairMan
	 * @generated
	 */
	public java.util.Enumeration findPayOffActChairManByChairMan(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePayOffActHome().findPayOffActChairManByChairMan(inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.PayOffAct findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePayOffActHome().findByPrimaryKey(key);
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
		return _acquirePayOffActHome().findDocumentByQBE(
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
	public com.hps.july.persistence.PayOffAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquirePayOffActHome().create(
			argDocument,
			argOwner,
			argBlankDate,
			argBlankindex,
			argState);
	}
	/**
	 * findPayOffActMember2ByMember2
	 * @generated
	 */
	public java.util.Enumeration findPayOffActMember2ByMember2(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquirePayOffActHome().findPayOffActMember2ByMember2(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.PayOffAct create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquirePayOffActHome().create(argDocument);
	}
}
