package com.hps.july.persistence;

import java.sql.*;
/**
 * This is a Home interface for the Entity Bean
 */
public interface AbonentBillHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.AbonentBill
 * @param argLeasebill int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.AbonentBill create(int argLeasebill) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.AbonentBill
 * @param argLeaseBill int
 * @param argLeaseDocument int
 * @param argBenSource java.lang.String
 * @param argFlagWorkNRI boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AbonentBill create(int argLeaseBill, int argLeaseDocument, java.lang.String argBenSource, boolean argFlagWorkNRI) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.AbonentBill
 * @param argLeaseBill int
 * @param argLeaseDocument int
 * @param argBenSource java.lang.String
 * @param argFlagWorkNRI boolean
 * @param argRecordStatus java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AbonentBill create(int argLeaseBill, int argLeaseDocument, java.lang.String argBenSource, boolean argFlagWorkNRI, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBill2ban.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAbonentBillsByLeaseabonentban(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByBanStartServDate(Integer argBan, java.sql.Date argStartDate) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByBen(Short argBen) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByFlagWorkNRI(String argFlagWorkNRI) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.AbonentBill
 * @param key com.hps.july.persistence.AbonentBillKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AbonentBill findByPrimaryKey(com.hps.july.persistence.AbonentBillKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(
        Boolean isLeaseDocument, Integer leaseDocument,
        Boolean isBillDate, Date fromBillDate, Date toBillDate, // диапазон дат
        Boolean isBillType, String billType,
        Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE2(
        Boolean isLeaseDocument, Integer leaseDocument,
        Boolean isBillDate, Date fromBillDate, Date toBillDate, // диапазон дат
        Boolean isBillType, String billType,
        Boolean isUseinNRI, Boolean useInNRI,
        Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
