package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseAbonentDNOPHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseAbonentDNOP
 * @param argIdabonentdnop int
 * @param argLeaseBill int
 * @param argPayPos int
 * @param argSumLinkUSD java.math.BigDecimal
 * @param argFlagWorkNRI boolean
 * @param argRecordStatus java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseAbonentDNOP create(int argIdabonentdnop, int argLeaseBill, int argPayPos, java.math.BigDecimal argSumLinkUSD, boolean argFlagWorkNRI, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByFlagWorkNRI(String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByPayPos(Integer argPayPos) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByPayPosLeaseBill(Integer argPayPos, Integer argLeaseBill) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseAbonentDNOP
 * @param key com.hps.july.persistence.LeaseAbonentDNOPKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseAbonentDNOP findByPrimaryKey(com.hps.july.persistence.LeaseAbonentDNOPKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseAbonentDNOPsByAbonentbill(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseAbonentDNOP2paypos.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseAbonentDNOPsByAbonentpayment(com.hps.july.persistence.AbonentPaymentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
