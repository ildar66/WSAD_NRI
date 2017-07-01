package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SiteDocFile extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getFilecreated() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getFilemodified() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getFilesize() throws java.rmi.RemoteException;
/**
 * Getter method for note
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNote() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SiteDoc getSiteDoc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedocfile() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getSitedocfiledate() throws java.rmi.RemoteException;
/**
 * Getter method for sitedocfilename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSitedocfilename() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SiteDocKey getSiteDocKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetSiteDocKey(com.hps.july.persistence.SiteDocKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetSiteDoc(com.hps.july.persistence.SiteDoc aSiteDoc) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setFilecreated(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setFilemodified(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setFilesize(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for note
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNote(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDocFile2SiteDocs.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setSiteDoc(com.hps.july.persistence.SiteDoc aSiteDoc) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setSitedocfiledate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sitedocfilename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSitedocfilename(java.lang.String newValue) throws java.rmi.RemoteException;
}
