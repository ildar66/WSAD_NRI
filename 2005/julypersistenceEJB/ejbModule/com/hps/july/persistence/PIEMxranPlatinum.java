package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEMxranPlatinum extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getMxranplatinum() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Organization getOwner() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEMxranPlatinum2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.OrganizationKey getOwnerKey() throws java.rmi.RemoteException;
/**
 * Getter method for p_status
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getP_status() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEMxranLink2mxran.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPIEMxranLinks() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEMxranLink2mxran.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPIEMxranLinks(com.hps.july.persistence.PIEMxranLink aPIEMxranLinks) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEMxranLink2mxran.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePIEMxranLinks(com.hps.july.persistence.PIEMxranLink aPIEMxranLinks) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for p_status
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setP_status(java.lang.String newValue) throws java.rmi.RemoteException;
}
