package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEPayLinkHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEPayLink
 * @param argIdPayPlatinum java.lang.String
 * @param argOwner int
 * @param argDocposition int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEPayLink create(java.lang.String argIdPayPlatinum, int argOwner, int argDocposition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PIEPayLink
 * @param argIdPayPlatinum java.lang.String
 * @param argDocposition int
 * @param argFlagMain java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEPayLink create(java.lang.String argIdPayPlatinum, int argDocposition, java.lang.String argFlagMain) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEPayLink
 * @param key com.hps.july.persistence.PIEPayLinkKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEPayLink findByPrimaryKey(com.hps.july.persistence.PIEPayLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEPayLink2pay.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findPIEPayLinksByPiepayplatinum(com.hps.july.persistence.PIEPayPlatinumKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
