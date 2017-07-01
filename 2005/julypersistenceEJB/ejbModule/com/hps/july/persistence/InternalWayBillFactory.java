package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * InternalWayBillFactory
 * @generated
 */
public class InternalWayBillFactory extends AbstractEJBFactory {
	/**
	 * InternalWayBillFactory
	 * @generated
	 */
	public InternalWayBillFactory() {
		super();
	}
	/**
	 * _acquireInternalWayBillHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.InternalWayBillHome _acquireInternalWayBillHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.InternalWayBillHome) _acquireEJBHome();
	}
	/**
	 * acquireInternalWayBillHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.InternalWayBillHome acquireInternalWayBillHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.InternalWayBillHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/InternalWayBill";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.InternalWayBillHome.class;
	}
	/**
	 * resetInternalWayBillHome
	 * @generated
	 */
	public void resetInternalWayBillHome() {
		resetEJBHome();
	}
	/**
	 * setInternalWayBillHome
	 * @generated
	 */
	public void setInternalWayBillHome(
		com.hps.july.persistence.InternalWayBillHome home) {
		setEJBHome(home);
	}
	/**
	 * findInternalWayBillByPosition
	 * @generated
	 */
	public java.util.Enumeration findInternalWayBillByPosition(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillHome().findInternalWayBillByPosition(
			inKey);
	}
	/**
	 * findInternalWayBillByMonter
	 * @generated
	 */
	public java.util.Enumeration findInternalWayBillByMonter(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillHome().findInternalWayBillByMonter(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InternalWayBill create(
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
		return _acquireInternalWayBillHome().create(
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
		return _acquireInternalWayBillHome().findByQBE2(
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
	public com.hps.july.persistence.InternalWayBill findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalWayBillHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InternalWayBill create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInternalWayBillHome().create(
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
	public com.hps.july.persistence.InternalWayBill create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInternalWayBillHome().create(argDocument);
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
		return _acquireInternalWayBillHome().findByQBE(
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
