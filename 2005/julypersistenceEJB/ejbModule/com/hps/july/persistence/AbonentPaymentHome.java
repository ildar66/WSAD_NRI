package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AbonentPaymentHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.AbonentPayment
 * @param argPaypos int
 * @param argLeaseDocument int
 * @param argNeedPay boolean
 * @param argSumPayUSD java.math.BigDecimal
 * @param argByHand boolean
 * @param argFlagWorkNRI boolean
 * @param argRecordStatus java.lang.String
 * @param argPayDate java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AbonentPayment create(int argPaypos, int argLeaseDocument, boolean argNeedPay, java.math.BigDecimal argSumPayUSD, boolean argByHand, boolean argFlagWorkNRI, java.lang.String argRecordStatus, java.sql.Date argPayDate) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentPayment2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAbonentPaymentsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByBANDate(Integer argBan, java.sql.Date argStartDate) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByDocumentQBE(Integer argDocument, 
	Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate,
	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByDocumentQBE2(Integer argDocument, 
	Boolean isDatePeriod, java.sql.Date argStartDate, java.sql.Date argEndDate,
	Boolean isNeedPay, Boolean needPay,
	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByFlagWorkNRI(String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.AbonentPayment
 * @param key com.hps.july.persistence.AbonentPaymentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AbonentPayment findByPrimaryKey(com.hps.july.persistence.AbonentPaymentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
