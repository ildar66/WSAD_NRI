package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * FaultReportFactory
 * @generated
 */
public class FaultReportFactory extends AbstractEJBFactory {
	/**
	 * FaultReportFactory
	 * @generated
	 */
	public FaultReportFactory() {
		super();
	}
	/**
	 * _acquireFaultReportHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.FaultReportHome _acquireFaultReportHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.FaultReportHome) _acquireEJBHome();
	}
	/**
	 * acquireFaultReportHome
	 * @generated
	 */
	public com.hps.july.persistence.FaultReportHome acquireFaultReportHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.FaultReportHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/FaultReport";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.FaultReportHome.class;
	}
	/**
	 * resetFaultReportHome
	 * @generated
	 */
	public void resetFaultReportHome() {
		resetEJBHome();
	}
	/**
	 * setFaultReportHome
	 * @generated
	 */
	public void setFaultReportHome(
		com.hps.july.persistence.FaultReportHome home) {
		setEJBHome(home);
	}
	/**
	 * findFaultReports2ByStoragecardFrom
	 * @generated
	 */
	public java.util.Enumeration findFaultReports2ByStoragecardFrom(
		com.hps.july.persistence.StorageCardKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireFaultReportHome().findFaultReports2ByStoragecardFrom(
			inKey);
	}
	/**
	 * findFaultReportByTechStuff
	 * @generated
	 */
	public java.util.Enumeration findFaultReportByTechStuff(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireFaultReportHome().findFaultReportByTechStuff(inKey);
	}
	/**
	 * findFaultReportByEquipment
	 * @generated
	 */
	public java.util.Enumeration findFaultReportByEquipment(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireFaultReportHome().findFaultReportByEquipment(inKey);
	}
	/**
	 * findFaultReportByDivision
	 * @generated
	 */
	public java.util.Enumeration findFaultReportByDivision(
		com.hps.july.persistence.DivisionKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireFaultReportHome().findFaultReportByDivision(inKey);
	}
	/**
	 * findFaultReports1ByOldagregate
	 * @generated
	 */
	public java.util.Enumeration findFaultReports1ByOldagregate(
		com.hps.july.persistence.StorageCardKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireFaultReportHome().findFaultReports1ByOldagregate(inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.FaultReport findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireFaultReportHome().findByPrimaryKey(key);
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
		return _acquireFaultReportHome().findDocumentByQBE(
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
	public com.hps.july.persistence.FaultReport create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireFaultReportHome().create(
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
	public com.hps.july.persistence.FaultReport create(
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
		java.lang.Integer argDivision,
		java.lang.Integer argTechStuff,
		java.lang.String argEqPlace,
		java.lang.String argOldSerial)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireFaultReportHome().create(
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
			argDivision,
			argTechStuff,
			argEqPlace,
			argOldSerial);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean useDate,
		java.sql.Date datefrom,
		java.sql.Date dateto,
		java.lang.Boolean useOwner,
		java.lang.Integer owner,
		java.lang.Boolean useDivision,
		java.lang.Integer division,
		java.lang.Boolean useWorker,
		java.lang.Integer worker,
		java.lang.Boolean usePosition,
		java.lang.Integer position,
		java.lang.Boolean useResource,
		java.lang.Integer resource,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireFaultReportHome().findByQBE(
			useDate,
			datefrom,
			dateto,
			useOwner,
			owner,
			useDivision,
			division,
			useWorker,
			worker,
			usePosition,
			position,
			useResource,
			resource,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.FaultReport create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireFaultReportHome().create(argDocument);
	}
}
