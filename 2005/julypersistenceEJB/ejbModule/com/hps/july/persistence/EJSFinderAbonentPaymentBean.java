package com.hps.july.persistence;

/**
 * EJSFinderAbonentPaymentBean
 */
public interface EJSFinderAbonentPaymentBean {
	/**
	 * findByBANDate
	 */
	public com.ibm.ejs.persistence.EJSFinder findByBANDate(java.lang.Integer argBan, java.sql.Date argStartDate) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAbonentPaymentsByLeaseabonentban
	 */
	public com.ibm.ejs.persistence.EJSFinder findAbonentPaymentsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByFlagWorkNRI
	 */
	public com.ibm.ejs.persistence.EJSFinder findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocumentQBE2(java.lang.Integer argDocument, java.lang.Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.Boolean isNeedPay, java.lang.Boolean needPay, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocumentQBE(java.lang.Integer argDocument, java.lang.Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
