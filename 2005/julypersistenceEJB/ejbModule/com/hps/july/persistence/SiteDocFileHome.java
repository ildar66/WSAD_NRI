package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SiteDocFileHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.SiteDocFile
 * @param argSitedocfile int
 * @param siteDoc int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SiteDocFile create(int argSitedocfile, int siteDoc) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SiteDocFile
 * @param key com.hps.july.persistence.SiteDocFileKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SiteDocFile findByPrimaryKey(com.hps.july.persistence.SiteDocFileKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findBySitedocOrderBySitedocAsc(Integer siteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findBySitedocOrderBySitedocDesc(Integer siteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findBySitedocsOrderByPKAsc(Integer siteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findBySitedocsOrderByPKDesc(Integer siteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findSiteDocFilesBySiteDoc(com.hps.july.persistence.SiteDocKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
