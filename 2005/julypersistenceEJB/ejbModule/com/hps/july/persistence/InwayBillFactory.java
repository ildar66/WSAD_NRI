package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * InwayBillFactory
 * @generated
 */
public class InwayBillFactory extends AbstractEJBFactory {
	/**
	 * InwayBillFactory
	 * @generated
	 */
	public InwayBillFactory() {
		super();
	}
	/**
	 * _acquireInwayBillHome
	 * @generated
	 */
	protected com.hps.july.persistence.InwayBillHome _acquireInwayBillHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.InwayBillHome) _acquireEJBHome();
	}
	/**
	 * acquireInwayBillHome
	 * @generated
	 */
	public com.hps.july.persistence.InwayBillHome acquireInwayBillHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.InwayBillHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/InwayBill";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.InwayBillHome.class;
	}
	/**
	 * resetInwayBillHome
	 * @generated
	 */
	public void resetInwayBillHome() {
		resetEJBHome();
	}
	/**
	 * setInwayBillHome
	 * @generated
	 */
	public void setInwayBillHome(com.hps.july.persistence.InwayBillHome home) {
		setEJBHome(home);
	}
	/**
	 * findInwayBilltechstufByDActTechStuf
	 * @generated
	 */
	public java.util.Enumeration findInwayBilltechstufByDActTechStuf(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInwayBillHome().findInwayBilltechstufByDActTechStuf(
			inKey);
	}
	/**
	 * findInwayBillByCurrency
	 * @generated
	 */
	public java.util.Enumeration findInwayBillByCurrency(
		com.hps.july.persistence.CurrencyKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInwayBillHome().findInwayBillByCurrency(inKey);
	}
	/**
	 * findInwayBillstorManagersByDActStorManager
	 * @generated
	 */
	public java.util.Enumeration findInwayBillstorManagersByDActStorManager(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInwayBillHome()
			.findInwayBillstorManagersByDActStorManager(
			inKey);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.InwayBill findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInwayBillHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InwayBill create(
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
		java.lang.Integer argCurrency)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInwayBillHome().create(
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
			argCurrency);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InwayBill create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInwayBillHome().create(
			argDocument,
			argOwner,
			argBlankDate,
			argBlankindex,
			argState);
	}
	/**
	 * findInwayBillsByRepresentative
	 * @generated
	 */
	public java.util.Enumeration findInwayBillsByRepresentative(
		com.hps.july.persistence.WorkerKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInwayBillHome().findInwayBillsByRepresentative(inKey);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isStorage,
		java.lang.Integer storage,
		java.sql.Date startDate,
		java.sql.Date endDate,
		java.lang.Boolean isCordocnum,
		java.lang.String cordocnum,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isSupplier,
		java.lang.Integer supplier,
		java.lang.Boolean isDActOnly,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireInwayBillHome().findByQBE(
			isStorage,
			storage,
			startDate,
			endDate,
			isCordocnum,
			cordocnum,
			isOwner,
			owner,
			isSupplier,
			supplier,
			isDActOnly,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InwayBill create(
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
		java.lang.Integer argCurrency,
		java.lang.String argRepresentativeType)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInwayBillHome().create(
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
			argCurrency,
			argRepresentativeType);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.InwayBill create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireInwayBillHome().create(argDocument);
	}
}
