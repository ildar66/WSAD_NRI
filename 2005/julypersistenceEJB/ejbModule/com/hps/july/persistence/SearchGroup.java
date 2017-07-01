package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SearchGroup extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addSearchGroupping(com.hps.july.persistence.SearchGroupping aSearchGroupping) throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getSearches() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSearchgroup() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getSearchGroupping() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddSearches(com.hps.july.persistence.Searches aSearches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddSearchGroupping(com.hps.july.persistence.SearchGroupping aSearchGroupping) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Searches2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveSearches(com.hps.july.persistence.Searches aSearches) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SearchGroupping2Group.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveSearchGroupping(com.hps.july.persistence.SearchGroupping aSearchGroupping) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSearchgroup int
 * @exception String The exception description.
 */
void setSearchgroup(int newSearchgroup) throws java.rmi.RemoteException;
}
