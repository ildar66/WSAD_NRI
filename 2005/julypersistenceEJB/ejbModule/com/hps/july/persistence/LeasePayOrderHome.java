package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeasePayOrderHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeasePayOrder
 * @param argLeaseDocPosition int
 * @param argDate java.sql.Date
 * @param argLeaseContract java.lang.Integer
 * @param argSource java.lang.String
 * @param argVid java.lang.String
 * @param argSDate java.sql.Date
 * @param argEDate java.sql.Date
 * @param argResource java.lang.Integer
 * @param argSumm java.math.BigDecimal
 * @param argCurrency java.lang.Integer
 * @param argSumNds java.math.BigDecimal
 * @param argPaymentType java.lang.String
 * @param argPaymentState java.lang.String
 * @param argOrgAcc java.lang.Integer
 * @param argPayPurpoise java.lang.String
 * @param argppType java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeasePayOrder create(int argLeaseDocPosition, java.sql.Date argDate, java.lang.Integer argLeaseContract, java.lang.String argSource, java.lang.String argVid, java.sql.Date argSDate, java.sql.Date argEDate, java.lang.Integer argResource, java.math.BigDecimal argSumm, java.lang.Integer argCurrency, java.math.BigDecimal argSumNds, java.lang.String argPaymentType, java.lang.String argPaymentState, java.lang.Integer argOrgAcc, java.lang.String argPayPurpoise, java.lang.String argppType) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeasePayOrder
 * @param key com.hps.july.persistence.LeaseDocPositionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeasePayOrder findByPrimaryKey(LeaseDocPositionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeasePayOrder2Accounts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findLeasePayOrderByOrgAcc(com.hps.july.persistence.AccountKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
