package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEOtvUserPlatinum extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addPIEOtvUserLinks(com.hps.july.persistence.PIEOtvUserLink aPIEOtvUserLinks) throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getOtvuserplatinum() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getPIEOtvUserLinks() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for pstatus
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPstatus() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddPIEOtvUserLinks(com.hps.july.persistence.PIEOtvUserLink aPIEOtvUserLinks) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEOtvUserLink2otvuser.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemovePIEOtvUserLinks(com.hps.july.persistence.PIEOtvUserLink aPIEOtvUserLinks) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for pstatus
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPstatus(java.lang.String newValue) throws java.rmi.RemoteException;
}
