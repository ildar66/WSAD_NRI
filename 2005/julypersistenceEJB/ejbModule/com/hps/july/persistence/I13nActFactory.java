package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * I13nActFactory
 * @generated
 */
public class I13nActFactory extends AbstractEJBFactory {
	/**
	 * I13nActFactory
	 * @generated
	 */
	public I13nActFactory() {
		super();
	}
	/**
	 * _acquireI13nActHome
	 * @generated
	 */
	protected com.hps.july.persistence.I13nActHome _acquireI13nActHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.I13nActHome) _acquireEJBHome();
	}
	/**
	 * acquireI13nActHome
	 * @generated
	 */
	public com.hps.july.persistence.I13nActHome acquireI13nActHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.I13nActHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/I13nAct";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.I13nActHome.class;
	}
	/**
	 * resetI13nActHome
	 * @generated
	 */
	public void resetI13nActHome() {
		resetEJBHome();
	}
	/**
	 * setI13nActHome
	 * @generated
	 */
	public void setI13nActHome(com.hps.july.persistence.I13nActHome home) {
		setEJBHome(home);
	}
	/**
	 * findI13nActByQBE
	 * @generated
	 */
	public java.util.Enumeration findI13nActByQBE(
		java.lang.Boolean isDate,
		java.sql.Date argDateFrom,
		java.sql.Date argDateTo,
		java.lang.Boolean isOrganization,
		java.lang.Integer argOrganization,
		java.lang.Boolean isStorage,
		java.lang.Integer argStorage,
		java.lang.Boolean isStorageType,
		java.lang.String storageType,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActHome().findI13nActByQBE(
			isDate,
			argDateFrom,
			argDateTo,
			isOrganization,
			argOrganization,
			isStorage,
			argStorage,
			isStorageType,
			storageType,
			order);
	}
	/**
	 * findFullByStorageAfterDate
	 * @generated
	 */
	public com.hps.july.persistence.I13nAct findFullByStorageAfterDate(
		java.lang.Integer storage,
		java.sql.Date date,
		java.lang.Integer butDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActHome().findFullByStorageAfterDate(
			storage,
			date,
			butDocument);
	}
	/**
	 * findI13nActByAgregate
	 * @generated
	 */
	public java.util.Enumeration findI13nActByAgregate(
		com.hps.july.persistence.StorageCardKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActHome().findI13nActByAgregate(inKey);
	}
	/**
	 * findI13nActTechByTechStuff
	 * @generated
	 */
	public java.util.Enumeration findI13nActTechByTechStuff(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActHome().findI13nActTechByTechStuff(inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.I13nAct findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActHome().findByPrimaryKey(key);
	}
	/**
	 * findAssortimentByStorageProductAfterDate
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.I13nAct findAssortimentByStorageProductAfterDate(
			java.lang.Integer storage,
			java.lang.Integer product,
			java.sql.Date date,
			java.lang.Integer butDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActHome().findAssortimentByStorageProductAfterDate(
			storage,
			product,
			date,
			butDocument);
	}
	/**
	 * findAgregateByStorageSerialAfterDate
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.I13nAct findAgregateByStorageSerialAfterDate(
		java.lang.String serial,
		java.sql.Date date,
		java.lang.Integer butDocument)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireI13nActHome().findAgregateByStorageSerialAfterDate(
			serial,
			date,
			butDocument);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.I13nAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireI13nActHome().create(
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
	public com.hps.july.persistence.I13nAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.lang.Integer argFrom,
		java.lang.Integer argTo,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argBlankNumber,
		java.lang.String argState,
		java.lang.Integer argStorageManager,
		java.lang.String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireI13nActHome().create(
			argDocument,
			argOwner,
			argFrom,
			argTo,
			argBlankDate,
			argBlankindex,
			argBlankNumber,
			argState,
			argStorageManager,
			argType);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.I13nAct create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireI13nActHome().create(argDocument);
	}
}
