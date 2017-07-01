package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ResourceType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addResourceSubType(com.hps.july.persistence.ResourceSubType aResourceSubType) throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getResourceSubType() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getResourcetype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddResourceSubType(com.hps.july.persistence.ResourceSubType aResourceSubType) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveResourceSubType(com.hps.july.persistence.ResourceSubType aResourceSubType) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newResourcetype int
 * @exception String The exception description.
 */
void setResourcetype(int newResourcetype) throws java.rmi.RemoteException;
}
