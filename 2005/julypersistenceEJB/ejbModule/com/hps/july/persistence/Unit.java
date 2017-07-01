package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Unit extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addResources(com.hps.july.persistence.Resource aResources) throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getResources() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for shortname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getShortname() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getUnit() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddResources(com.hps.july.persistence.Resource aResources) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named rosources2unit.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveResources(com.hps.july.persistence.Resource aResources) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for shortname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setShortname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newUnit int
 * @exception String The exception description.
 */
void setUnit(int newUnit) throws java.rmi.RemoteException;
}
