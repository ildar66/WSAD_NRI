package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEResLinkHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEResLink
 * @param argIdresnri int
 * @param argOwner int
 * @param argIdResPlatinum java.lang.String
 * @param argVdat java.sql.Timestamp
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEResLink create(int argIdresnri, int argOwner, java.lang.String argIdResPlatinum, java.sql.Timestamp argVdat) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PIEResLink
 * @param argIdresnri int
 * @param argOwner int
 * @param argIdResPlatinum java.lang.String
 * @param argVdat java.sql.Timestamp
 * @param argFlagMainLink java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEResLink create(int argIdresnri, int argOwner, java.lang.String argIdResPlatinum, java.sql.Timestamp argVdat, java.lang.Boolean argFlagMainLink) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findByIdresnriAndOwner(Integer argIdresNri, Integer argOwner) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEResLink
 * @param key com.hps.july.persistence.PIEResLinkKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEResLink findByPrimaryKey(com.hps.july.persistence.PIEResLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findPIEResLinksByResplatinum(com.hps.july.persistence.PIEResPlatinumKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
