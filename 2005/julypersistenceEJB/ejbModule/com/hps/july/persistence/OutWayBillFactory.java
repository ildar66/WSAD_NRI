package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * OutWayBillFactory
 * @generated
 */
public class OutWayBillFactory extends AbstractEJBFactory {
	/**
	 * OutWayBillFactory
	 * @generated
	 */
	public OutWayBillFactory() {
		super();
	}
	/**
	 * _acquireOutWayBillHome
	 * @generated
	 */
	protected com.hps.july.persistence.OutWayBillHome _acquireOutWayBillHome()
		throws java.rmi.RemoteException {
		return (com.hps.july.persistence.OutWayBillHome) _acquireEJBHome();
	}
	/**
	 * acquireOutWayBillHome
	 * @generated
	 */
	public com.hps.july.persistence.OutWayBillHome acquireOutWayBillHome()
		throws javax.naming.NamingException {
		return (com.hps.july.persistence.OutWayBillHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/OutWayBill";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.OutWayBillHome.class;
	}
	/**
	 * resetOutWayBillHome
	 * @generated
	 */
	public void resetOutWayBillHome() {
		resetEJBHome();
	}
	/**
	 * setOutWayBillHome
	 * @generated
	 */
	public void setOutWayBillHome(
		com.hps.july.persistence.OutWayBillHome home) {
		setEJBHome(home);
	}
	/**
	 * findOutWayBillsByCurrency
	 * @generated
	 */
	public java.util.Enumeration findOutWayBillsByCurrency(
		com.hps.july.persistence.CurrencyKey inKey)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOutWayBillHome().findOutWayBillsByCurrency(inKey);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.OutWayBill create(
		int argDocument,
		java.lang.Integer argOwner,
		java.lang.Integer argFrom,
		java.lang.Integer argTo,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argBlankNumber,
		java.lang.String argState,
		int argCurrency,
		java.lang.Boolean argProcessSource,
		java.lang.Boolean argProcessDestination)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOutWayBillHome().create(
			argDocument,
			argOwner,
			argFrom,
			argTo,
			argBlankDate,
			argBlankindex,
			argBlankNumber,
			argState,
			argCurrency,
			argProcessSource,
			argProcessDestination);
	}
	/**
	 * findByQBE
	 * @generated
	 */
	public java.util.Enumeration findByQBE(
		java.lang.Boolean isDate,
		java.sql.Date dateFrom,
		java.sql.Date dateTo,
		java.lang.Boolean isOwner,
		java.lang.Integer owner,
		java.lang.Boolean isStorage,
		java.lang.Integer storage,
		java.lang.Boolean isContragent,
		java.lang.Integer contragent,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOutWayBillHome().findByQBE(
			isDate,
			dateFrom,
			dateTo,
			isOwner,
			owner,
			isStorage,
			storage,
			isContragent,
			contragent,
			order);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.OutWayBill create(
		int argDocument,
		java.lang.Integer argOwner,
		java.sql.Date argBlankDate,
		int argBlankindex,
		java.lang.String argState,
		int argCurrency)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOutWayBillHome().create(
			argDocument,
			argOwner,
			argBlankDate,
			argBlankindex,
			argState,
			argCurrency);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.OutWayBill findByPrimaryKey(
		com.hps.july.persistence.DocumentKey key)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireOutWayBillHome().findByPrimaryKey(key);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.OutWayBill create(int argDocument)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireOutWayBillHome().create(argDocument);
	}
}
