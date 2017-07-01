package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEBankPlatinumHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEBankPlatinum
 * @param argIdbankplatinum java.lang.String
 * @param argOwner int
 * @param argPStatus java.lang.String
 * @param argName java.lang.String
 * @param argBik java.lang.String
 * @param argFlagWorkNri java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEBankPlatinum create(java.lang.String argIdbankplatinum, int argOwner, java.lang.String argPStatus, java.lang.String argName, java.lang.String argBik, java.lang.String argFlagWorkNri) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEBankPlatinum
 * @param key com.hps.july.persistence.PIEBankPlatinumKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEBankPlatinum findByPrimaryKey(com.hps.july.persistence.PIEBankPlatinumKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findNotWorkedByOwner(Integer argOwner) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
