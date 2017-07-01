package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AbonentBillPosHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.AbonentBillPos
 * @param argBillpos int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.AbonentBillPos create(int argBillpos) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.AbonentBillPos
 * @param argBillPos int
 * @param argLeaseBill int
 * @param argResource int
 * @param argQty java.math.BigDecimal
 * @param argCurrency int
 * @param argSummPure java.math.BigDecimal
 * @param argSumPureNRI java.math.BigDecimal
 * @param argSumm java.math.BigDecimal
 * @param argSummNRI java.math.BigDecimal
 * @param argNDSSumm java.math.BigDecimal
 * @param argNDSSummNRI java.math.BigDecimal
 * @param argNSPSumm java.math.BigDecimal
 * @param argNSPSummNRI java.math.BigDecimal
 * @param argRecordStatus java.lang.String
 * @param argSumByHand boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AbonentBillPos create(int argBillPos, int argLeaseBill, int argResource, java.math.BigDecimal argQty, int argCurrency, java.math.BigDecimal argSummPure, java.math.BigDecimal argSumPureNRI, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNRI, java.math.BigDecimal argNDSSumm, java.math.BigDecimal argNDSSummNRI, java.math.BigDecimal argNSPSumm, java.math.BigDecimal argNSPSummNRI, java.lang.String argRecordStatus, boolean argSumByHand) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AbonentBillPos2bill.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAbonentBillPosesByPos2bill(com.hps.july.persistence.AbonentBillKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentBillPos2currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAbonentBillPosesByPos2currency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAbonentBillPosesByPos2resource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AbonentBillPos2resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByLeaseBill(Integer leaseBill) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.AbonentBillPos
 * @param key com.hps.july.persistence.AbonentBillPosKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AbonentBillPos findByPrimaryKey(com.hps.july.persistence.AbonentBillPosKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
