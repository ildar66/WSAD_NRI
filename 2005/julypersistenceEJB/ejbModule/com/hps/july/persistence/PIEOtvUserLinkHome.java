package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEOtvUserLinkHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEOtvUserLink
 * @param argOtvusernri int
 * @param argOtvUserPlatinum java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEOtvUserLink create(int argOtvusernri, java.lang.String argOtvUserPlatinum) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEOtvUserLink
 * @param key com.hps.july.persistence.PIEOtvUserLinkKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEOtvUserLink findByPrimaryKey(com.hps.july.persistence.PIEOtvUserLinkKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPIEOtvUserLinksByOtvuserplatinum(com.hps.july.persistence.PIEOtvUserPlatinumKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
