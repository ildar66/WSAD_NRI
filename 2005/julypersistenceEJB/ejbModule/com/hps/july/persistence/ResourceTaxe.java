package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ResourceTaxe extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDate() throws java.rmi.RemoteException;
/**
 * Getter method for nds
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNds() throws java.rmi.RemoteException;
/**
 * Getter method for nsp
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getNsp() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Resource getResource() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getResource_resource() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ResourceTaxes2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ResourceKey getResourceKey() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nds
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNds(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for nsp
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setNsp(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newResource_resource java.lang.Integer
 * @exception String The exception description.
 */
void setResource_resource(java.lang.Integer newResource_resource) throws java.rmi.RemoteException;
}
