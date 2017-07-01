package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Sitedoc2SplaceHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.Sitedoc2Splace
 * @param sitedoc int
 * @param storageplace int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Sitedoc2Splace create(int sitedoc, int storageplace) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Sitedoc2Splace
 * @param key com.hps.july.persistence.Sitedoc2SplaceKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Sitedoc2Splace findByPrimaryKey(com.hps.july.persistence.Sitedoc2SplaceKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Sitedoc2Splace2SiteDoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findSitedoc2SplacesBySiteDoc(com.hps.july.persistence.SiteDocKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Sitedoc2Splace2StoragePlace.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findSitedoc2SplacesByStoragePlace(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
