package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AssemblingActFactory
 * @generated
 */
public class AssemblingActFactory extends AbstractEJBFactory {
	/**
	 * AssemblingActFactory
	 * @generated
	 */
	public AssemblingActFactory() {
		super();
	}
	/**
	 * _acquireAssemblingActHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.AssemblingActHome _acquireAssemblingActHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.AssemblingActHome) _acquireEJBHome();
	}
	/**
	 * acquireAssemblingActHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.AssemblingActHome acquireAssemblingActHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.AssemblingActHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/AssemblingAct";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.AssemblingActHome.class;
	}
	/**
	 * resetAssemblingActHome
	 * @generated
	 */
	public void resetAssemblingActHome() {
		resetEJBHome();
	}
	/**
	 * setAssemblingActHome
	 * @generated
	 */
	public void setAssemblingActHome(
		com.hps.july.persistence.AssemblingActHome home) {
		setEJBHome(home);
	}
	/**
	 * findAssemblingActByMonter
	 * @generated
	 */
	public java.util.Enumeration findAssemblingActByMonter(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAssemblingActHome().findAssemblingActByMonter(inKey);
	}
	/**
	 * findAssemblingActByAgregat
	 * @generated
	 */
	public java.util.Enumeration findAssemblingActByAgregat(
		com.hps.july.persistence.StorageCardKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAssemblingActHome().findAssemblingActByAgregat(inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.AssemblingAct findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAssemblingActHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AssemblingAct create(
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
		java.lang.String argAgregatSerial,
		java.lang.String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAssemblingActHome().create(
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
			argAgregatSerial,
			argType);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AssemblingAct create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAssemblingActHome().create(
			argDocument,
			argOwner,
			argBlankDate,
			argBlankindex,
			argState);
	}
	/**
	 * findByQBE2
	 * @generated
	 */
	public java.util.Enumeration findByQBE2(
		java.sql.Date startDate,
		java.sql.Date endDate,
		java.lang.Boolean isOrganization,
		java.lang.Integer organization,
		java.lang.Boolean isPosition,
		java.lang.Integer position,
		java.lang.Boolean isOperationType,
		java.lang.String operationType,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAssemblingActHome().findByQBE2(
			startDate,
			endDate,
			isOrganization,
			organization,
			isPosition,
			position,
			isOperationType,
			operationType,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AssemblingAct create(
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
		java.lang.Integer argAgregat,
		java.lang.String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAssemblingActHome().create(
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
			argAgregat,
			argType);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AssemblingAct create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAssemblingActHome().create(argDocument);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.sql.Date startDate,
		java.sql.Date endDate,
		java.lang.Boolean isOrganization,
		java.lang.Integer organization,
		java.lang.Boolean isStorage,
		java.lang.Integer storage,
		java.lang.Boolean isOperationType,
		java.lang.String operationType,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAssemblingActHome().findByQBE(
			startDate,
			endDate,
			isOrganization,
			organization,
			isStorage,
			storage,
			isOperationType,
			operationType,
			order);
	}
}
