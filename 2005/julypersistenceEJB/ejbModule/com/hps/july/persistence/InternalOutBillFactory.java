package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * InternalOutBillFactory
 * @generated
 */
public class InternalOutBillFactory extends AbstractEJBFactory {
	/**
	 * InternalOutBillFactory
	 * @generated
	 */
	public InternalOutBillFactory() {
		super();
	}
	/**
	 * _acquireInternalOutBillHome
	 * @generated
	 */
	protected com
		.hps
		.july
		.persistence
		.InternalOutBillHome _acquireInternalOutBillHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.InternalOutBillHome) _acquireEJBHome();
	}
	/**
	 * acquireInternalOutBillHome
	 * @generated
	 */
	public com
		.hps
		.july
		.persistence
		.InternalOutBillHome acquireInternalOutBillHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.InternalOutBillHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/InternalOutBill";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.InternalOutBillHome.class;
	}
	/**
	 * resetInternalOutBillHome
	 * @generated
	 */
	public void resetInternalOutBillHome() {
		resetEJBHome();
	}
	/**
	 * setInternalOutBillHome
	 * @generated
	 */
	public void setInternalOutBillHome(
		com.hps.july.persistence.InternalOutBillHome home) {
		setEJBHome(home);
	}
	/**
	 * findInternalOutBillByPosition
	 * @generated
	 */
	public java.util.Enumeration findInternalOutBillByPosition(
		com.hps.july.persistence.StoragePlaceKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalOutBillHome().findInternalOutBillByPosition(
			inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InternalOutBill create(
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
		return _acquireInternalOutBillHome().create(
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
		return _acquireInternalOutBillHome().findByQBE2(
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
	 * findInternalOutBillByQBE
	 * @generated
	 */
	public java.util.Enumeration findInternalOutBillByQBE(
		java.lang.Boolean isDate,
		java.sql.Date dateFrom,
		java.sql.Date dateTo,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isStorage,
		java.lang.Integer storage,
		java.lang.Boolean isContragent,
		java.lang.Integer contragent,
		java.lang.Boolean isWorker,
		java.lang.Integer worker,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalOutBillHome().findInternalOutBillByQBE(
			isDate,
			dateFrom,
			dateTo,
			isOwner,
			owner,
			isStorage,
			storage,
			isContragent,
			contragent,
			isWorker,
			worker,
			order);
	}
	/**
	 * findInternalOutBillByMonter
	 * @generated
	 */
	public java.util.Enumeration findInternalOutBillByMonter(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalOutBillHome().findInternalOutBillByMonter(inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.InternalOutBill findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInternalOutBillHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InternalOutBill create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInternalOutBillHome().create(
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
	public com.hps.july.persistence.InternalOutBill create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInternalOutBillHome().create(argDocument);
	}
}
