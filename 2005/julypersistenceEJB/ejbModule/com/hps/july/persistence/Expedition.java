package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Expedition extends com.hps.july.persistence.StoragePlace, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Worker getExpeditor() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getExpeditorKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Expedition2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OrganizationKey getOrganizationKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetExpeditorKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOrganizationKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetExpeditor(com.hps.july.persistence.Worker anExpeditor) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2Expeditor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setExpeditor(com.hps.july.persistence.Worker anExpeditor) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Expedition2ExpeditionOrg.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setOrganization(com.hps.july.persistence.Organization anOrganization) throws java.rmi.RemoteException;
}
