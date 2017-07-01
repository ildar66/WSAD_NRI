package com.hps.july.persistence;
import com.ibm.etools.ejb.client.runtime.*;
/**
 * AbonentPaymentFactory
 * @generated
 */
public class AbonentPaymentFactory extends AbstractEJBFactory {
	/**
	 * AbonentPaymentFactory
	 * @generated
	 */
	public AbonentPaymentFactory() {
		super();
	}
	/**
	 * _acquireAbonentPaymentHome
	 * @generated
	 */
	protected com.hps.july.persistence.AbonentPaymentHome _acquireAbonentPaymentHome() throws java.rmi.RemoteException {
		return (com.hps.july.persistence.AbonentPaymentHome) _acquireEJBHome();
	}
	/**
	 * acquireAbonentPaymentHome
	 * @generated
	 */
	public com.hps.july.persistence.AbonentPaymentHome acquireAbonentPaymentHome() throws javax.naming.NamingException {
		return (com.hps.july.persistence.AbonentPaymentHome) acquireEJBHome();
	}
	/**
	 * getDefaultJNDIName
	 * @generated
	 */
	public String getDefaultJNDIName() {
		return "com/hps/july/persistence/AbonentPayment";
	}
	/**
	 * getHomeInterface
	 * @generated
	 */
	protected Class getHomeInterface() {
		return com.hps.july.persistence.AbonentPaymentHome.class;
	}
	/**
	 * resetAbonentPaymentHome
	 * @generated
	 */
	public void resetAbonentPaymentHome() {
		resetEJBHome();
	}
	/**
	 * setAbonentPaymentHome
	 * @generated
	 */
	public void setAbonentPaymentHome(com.hps.july.persistence.AbonentPaymentHome home) {
		setEJBHome(home);
	}
	/**
	 * findByBANDate
	 * @generated
	 */
	public java.util.Enumeration findByBANDate(java.lang.Integer argBan, java.sql.Date argStartDate) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAbonentPaymentHome().findByBANDate(argBan, argStartDate);
	}
	/**
	 * findAbonentPaymentsByLeaseabonentban
	 * @generated
	 */
	public java.util.Enumeration findAbonentPaymentsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAbonentPaymentHome().findAbonentPaymentsByLeaseabonentban(inKey);
	}
	/**
	 * findByFlagWorkNRI
	 * @generated
	 */
	public java.util.Enumeration findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAbonentPaymentHome().findByFlagWorkNRI(argFlagWorkNRI);
	}
	/**
	 * create
	 * @generated
	 */
	public com.hps.july.persistence.AbonentPayment create(
		int argPaypos,
		int argLeaseDocument,
		boolean argNeedPay,
		java.math.BigDecimal argSumPayUSD,
		boolean argByHand,
		boolean argFlagWorkNRI,
		java.lang.String argRecordStatus,
		java.sql.Date argPayDate)
		throws javax.ejb.CreateException, java.rmi.RemoteException {
		return _acquireAbonentPaymentHome().create(argPaypos, argLeaseDocument, argNeedPay, argSumPayUSD, argByHand, argFlagWorkNRI, argRecordStatus, argPayDate);
	}
	/**
	 * findByDocumentQBE2
	 * @generated
	 */
	public java.util.Enumeration findByDocumentQBE2(
		java.lang.Integer argDocument,
		java.lang.Boolean isDatePeriod,
		java.sql.Date argStartDate,
		java.sql.Date argEndDate,
		java.lang.Boolean isNeedPay,
		java.lang.Boolean needPay,
		java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAbonentPaymentHome().findByDocumentQBE2(argDocument, isDatePeriod, argStartDate, argEndDate, isNeedPay, needPay, order);
	}
	/**
	 * findByDocumentQBE
	 * @generated
	 */
	public java.util.Enumeration findByDocumentQBE(java.lang.Integer argDocument, java.lang.Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.Integer order)
		throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAbonentPaymentHome().findByDocumentQBE(argDocument, isDatePeriod, argStartDate, argEndDate, order);
	}
	/**
	 * findByPrimaryKey
	 * @generated
	 */
	public com.hps.july.persistence.AbonentPayment findByPrimaryKey(com.hps.july.persistence.AbonentPaymentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException {
		return _acquireAbonentPaymentHome().findByPrimaryKey(key);
	}
}
