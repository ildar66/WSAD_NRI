package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SiteDocHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.SiteDoc
 * @param argSitedoc int
 * @param siteDocType int
 * @param man int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SiteDoc create(int argSitedoc, int siteDocType, int man) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByEquipment(Integer position, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByHop(Integer hopid, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByPosition(Integer position, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SiteDoc
 * @param key com.hps.july.persistence.SiteDocKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SiteDoc findByPrimaryKey(com.hps.july.persistence.SiteDocKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByProjectaction(Integer projectaction) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByProjectactions_Project(Integer project) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findSiteDocsByMan(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findSiteDocsByProjectAction(com.hps.july.persistence.ProjectActionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findSiteDocsBySiteDocType(com.hps.july.persistence.SiteDocTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
