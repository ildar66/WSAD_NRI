package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeasePay2BillHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeasePay2Bill
 * @param argLeasemutualact int
 * @param argLeaseContract int
 * @param argSumUSD java.math.BigDecimal
 * @param argFlagWorkPIE boolean
 * @param argRecordStatus java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeasePay2Bill create(int argLeasemutualact, int argLeaseContract, java.math.BigDecimal argSumUSD, boolean argFlagWorkPIE, java.lang.String argRecordStatus) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeasePay2Bill
 * @param key com.hps.july.persistence.LeasePay2BillKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByAct(Integer argAct) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeasePay2Bill
 * @param key com.hps.july.persistence.LeasePay2BillKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByFlagWorkPIE(String argFlagWorkPIE) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeasePay2Bill
 * @param key com.hps.july.persistence.LeasePay2BillKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeasePay2Bill findByPrimaryKey(com.hps.july.persistence.LeasePay2BillKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
