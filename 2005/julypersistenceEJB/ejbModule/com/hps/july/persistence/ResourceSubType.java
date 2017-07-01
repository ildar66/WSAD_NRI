package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ResourceSubType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getResourcesubtype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceType getResourcetype() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceTypeKey getResourcetypeKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourcetypeKey(com.hps.july.persistence.ResourceTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named resources2subtype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResourcetype(com.hps.july.persistence.ResourceType aResourcetype) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newResourcesubtype int
 * @exception String The exception description.
 */
void setResourcesubtype(int newResourcesubtype) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResourcetype(com.hps.july.persistence.ResourceType aResourcetype) throws java.rmi.RemoteException;
}
