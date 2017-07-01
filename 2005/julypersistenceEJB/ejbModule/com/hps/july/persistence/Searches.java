package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Searches extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SearchGroup getGroup() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getGroup_searchgroup() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.SearchGroupKey getGroupKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SearchGroupping getGroupping() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SearchGrouppingKey getGrouppingKey() throws java.rmi.RemoteException;
/**
 * Getter method for order
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOrder() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOrganization() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getOrganization_organization() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getOrganizationKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetGrouppingKey(com.hps.july.persistence.SearchGrouppingKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetGroupping(com.hps.july.persistence.SearchGroupping aGroupping) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newGroup_searchgroup java.lang.Integer
 * @exception String The exception description.
 */
void setGroup_searchgroup(java.lang.Integer newGroup_searchgroup) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setGroupping(com.hps.july.persistence.SearchGroupping aGroupping) throws java.rmi.RemoteException;
/**
 * Setter method for order
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOrder(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newOrganization_organization java.lang.Integer
 * @exception String The exception description.
 */
void setOrganization_organization(java.lang.Integer newOrganization_organization) throws java.rmi.RemoteException;
}
