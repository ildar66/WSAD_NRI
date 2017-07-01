package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SearchGroupping extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addSearches(com.hps.july.persistence.Searches aSearches) throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getSearches() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SearchGroup getSearchGroup() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.SearchGroupKey getSearchGroupKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSearchGroupping() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetSearchGroupKey(com.hps.july.persistence.SearchGroupKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddSearches(com.hps.july.persistence.Searches aSearches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Groupping.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveSearches(com.hps.july.persistence.Searches aSearches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetSearchGroup(com.hps.july.persistence.SearchGroup aSearchGroup) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setSearchGroup(com.hps.july.persistence.SearchGroup aSearchGroup) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSearchGroupping int
 * @exception String The exception description.
 */
void setSearchGroupping(int newSearchGroupping) throws java.rmi.RemoteException;
}
