package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface SupplyType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSupplyType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Contract2SupplyTypes.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newSupplyType int
 * @exception String The exception description.
 */
void setSupplyType(int newSupplyType) throws java.rmi.RemoteException;
}
