package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ContrParams extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ContrAddInfo getContraddinfo() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ContrAddInfoKey getContraddinfoKey() throws java.rmi.RemoteException;
/**
 * Getter method for param_level
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getParam_level() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getParam_type() throws java.rmi.RemoteException;
/**
 * Getter method for param_value
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getParam_value() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getParamid() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetContraddinfoKey(com.hps.july.persistence.ContrAddInfoKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetContraddinfo(com.hps.july.persistence.ContrAddInfo aContraddinfo) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ContrParams2contradd.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setContraddinfo(com.hps.july.persistence.ContrAddInfo aContraddinfo) throws java.rmi.RemoteException;
/**
 * Setter method for param_level
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setParam_level(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue int
 * @exception String The exception description.
 */
void setParam_type(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for param_value
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setParam_value(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
}
