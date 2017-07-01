package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ComEquipment extends com.hps.july.persistence.EquipmentSet, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getComEquipmentType() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getOsinvname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResourceKey(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setComEquipmentType(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setOsinvname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ComEquipment2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResource(com.hps.july.persistence.Resource aResource) throws java.rmi.RemoteException;
}
