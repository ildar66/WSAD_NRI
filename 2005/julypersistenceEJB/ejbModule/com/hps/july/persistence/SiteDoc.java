package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SiteDoc extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addSiteDocFiles(com.hps.july.persistence.SiteDocFile aSiteDocFiles) throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getBlankdate() throws java.rmi.RemoteException;
/**
 * Getter method for blanknumber
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBlanknumber() throws java.rmi.RemoteException;
/**
 * Getter method for comment
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getComment() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getExpiredate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.People getMan() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PeopleKey getManKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectAction getProjectAction() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectActionKey getProjectActionKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedoc() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sitedoc2Splace2SiteDoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSitedoc2Splaces() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSiteDocFiles() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SiteDocType getSiteDocType() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SiteDocTypeKey getSiteDocTypeKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetManKey(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetProjectActionKey(com.hps.july.persistence.ProjectActionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSiteDocTypeKey(com.hps.july.persistence.SiteDocTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sitedoc2Splace2SiteDoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSitedoc2Splaces(com.hps.july.persistence.Sitedoc2Splace aSitedoc2Splaces) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSiteDocFiles(com.hps.july.persistence.SiteDocFile aSiteDocFiles) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Sitedoc2Splace2SiteDoc.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSitedoc2Splaces(com.hps.july.persistence.Sitedoc2Splace aSitedoc2Splaces) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSiteDocFiles(com.hps.july.persistence.SiteDocFile aSiteDocFiles) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetProjectAction(com.hps.july.persistence.ProjectAction aProjectAction) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSiteDocType(com.hps.july.persistence.SiteDocType aSiteDocType) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setBlankdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for blanknumber
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBlanknumber(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for comment
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setComment(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setExpiredate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2ProjectAction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setProjectAction(com.hps.july.persistence.ProjectAction aProjectAction) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSiteDocType(com.hps.july.persistence.SiteDocType aSiteDocType) throws java.rmi.RemoteException;
}
