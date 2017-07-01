package com.hps.july.persistence;

/**
 * EJSFinderAbonentBillBean
 */
public interface EJSFinderAbonentBillBean {
	/**
	 * findByBen
	 */
	public com.ibm.ejs.persistence.EJSFinder findByBen(java.lang.Short argBen) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByFlagWorkNRI
	 */
	public com.ibm.ejs.persistence.EJSFinder findByFlagWorkNRI(java.lang.String argFlagWorkNRI) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isLeaseDocument, java.lang.Integer leaseDocument, java.lang.Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, java.lang.Boolean isBillType, java.lang.String billType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isLeaseDocument, java.lang.Integer leaseDocument, java.lang.Boolean isBillDate, java.sql.Date fromBillDate, java.sql.Date toBillDate, java.lang.Boolean isBillType, java.lang.String billType, java.lang.Boolean isUseinNRI, java.lang.Boolean useInNRI, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByBanStartServDate
	 */
	public com.ibm.ejs.persistence.EJSFinder findByBanStartServDate(java.lang.Integer argBan, java.sql.Date argStartDate) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAbonentBillsByLeaseabonentban
	 */
	public com.ibm.ejs.persistence.EJSFinder findAbonentBillsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
