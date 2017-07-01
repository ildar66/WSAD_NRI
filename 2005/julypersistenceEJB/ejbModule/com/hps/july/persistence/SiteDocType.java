package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SiteDocType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSiteDocs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedoctype() throws java.rmi.RemoteException;
/**
 * Getter method for sitedoctypename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSitedoctypename() throws java.rmi.RemoteException;
/**
 * Getter method for sitedoctypetxt
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getSitedoctypetxt() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2SiteDocType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * Setter method for sitedoctypename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSitedoctypename(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for sitedoctypetxt
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setSitedoctypetxt(java.lang.String newValue) throws java.rmi.RemoteException;
}
