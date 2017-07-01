package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEResPlatinum extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getIdresplatinum() throws java.rmi.RemoteException;
/**
 * Getter method for nameres
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNameres() throws java.rmi.RemoteException;
/**
 * Getter method for owner
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOwner() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEResLinks() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEResLinks(com.hps.july.persistence.PIEResLink aPIEResLinks) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEResLink2resplat.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEResLinks(com.hps.july.persistence.PIEResLink aPIEResLinks) throws java.rmi.RemoteException;
/**
 * Setter method for nameres
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNameres(java.lang.String newValue) throws java.rmi.RemoteException;
}
