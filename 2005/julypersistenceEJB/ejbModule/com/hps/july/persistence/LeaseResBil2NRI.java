package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseResBil2NRI extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for billresname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getBillresname() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdrecord() throws java.rmi.RemoteException;
/**
 * Getter method for idresbilling
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdresbilling() throws java.rmi.RemoteException;
/**
 * 
 * @return boolean
 * @exception String The exception description.
 */
boolean getIsactive() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getLeaseResBil() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getLeaseResBilKey() throws java.rmi.RemoteException;
/**
 * Getter method for record_status
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRecord_status() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getTyperes() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLeaseResBilKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetLeaseResBil(com.hps.july.persistence.Resource aLeaseResBil) throws java.rmi.RemoteException;
/**
 * Setter method for billresname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setBillresname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idresbilling
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdresbilling(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue boolean
 * @exception String The exception description.
 */
void setIsactive(boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseResBil2NRI2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setLeaseResBil(com.hps.july.persistence.Resource aLeaseResBil) throws java.rmi.RemoteException;
/**
 * Setter method for record_status
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRecord_status(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setTyperes(java.lang.String newValue) throws java.rmi.RemoteException;
}
