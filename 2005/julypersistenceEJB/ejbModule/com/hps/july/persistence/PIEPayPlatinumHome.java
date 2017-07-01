package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEPayPlatinumHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEPayPlatinum
 * @param argIdpayplatinum java.lang.String
 * @param argOwner int
 * @param argIdDogovorNri int
 * @param argSumm java.math.BigDecimal
 * @param argSummNds java.math.BigDecimal
 * @param argValute int
 * @param argSummRub java.math.BigDecimal
 * @param argSummNdsRub java.math.BigDecimal
 * @param argDate java.sql.Date
 * @param argFlagWorkNri java.lang.String
 * @param argPurpose java.lang.String
 * @param argPayStatePlatinum int
 * @param argDocNumber java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEPayPlatinum create(java.lang.String argIdpayplatinum, int argOwner, int argIdDogovorNri, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNds, int argValute, java.math.BigDecimal argSummRub, java.math.BigDecimal argSummNdsRub, java.sql.Date argDate, java.lang.String argFlagWorkNri, java.lang.String argPurpose, int argPayStatePlatinum, java.lang.String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PIEPayPlatinum
 * @param argIdpayplatinum java.lang.String
 * @param argIdDogovorNri int
 * @param argSumm java.math.BigDecimal
 * @param argSummNds java.math.BigDecimal
 * @param argValute int
 * @param argSummRub java.math.BigDecimal
 * @param argSummNdsRub java.math.BigDecimal
 * @param argDate java.sql.Date
 * @param argFlagWorkNri java.lang.String
 * @param argPurpose java.lang.String
 * @param argPayStatePlatinum int
 * @param argDocNumber java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEPayPlatinum create(java.lang.String argIdpayplatinum, int argIdDogovorNri, java.math.BigDecimal argSumm, java.math.BigDecimal argSummNds, int argValute, java.math.BigDecimal argSummRub, java.math.BigDecimal argSummNdsRub, java.sql.Date argDate, java.lang.String argFlagWorkNri, java.lang.String argPurpose, int argPayStatePlatinum, java.lang.String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEPayPlatinum
 * @param key com.hps.july.persistence.PIEPayPlatinumKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEPayPlatinum findByPrimaryKey(com.hps.july.persistence.PIEPayPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(Boolean isDateStart, java.sql.Date argDateStart,
	Boolean isDateEnd, java.sql.Date argDateEnd, 
	Boolean isIdDogovNri, Integer argIdDogovNri, 
	Boolean isFlagWorkNri, String argFlagWorkNri, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
