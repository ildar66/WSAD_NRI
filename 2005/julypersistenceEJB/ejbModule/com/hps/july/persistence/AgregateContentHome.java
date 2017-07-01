package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface AgregateContentHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.AgregateContent
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.AgregateContent create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.AgregateContent
 * @param argAgregate java.lang.Integer
 * @param argPart java.lang.Integer
 * @param argQty java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.AgregateContent create(java.lang.Integer argAgregate, java.lang.Integer argPart, java.math.BigDecimal argQty) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.AgregateContent findAgregateAndPart(Integer argAgregate, Integer argPart ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AgregateContent2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAgregateByParts(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named AgregateContent2Agregate.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAgregateContentByAgregate(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.AgregateContent
 * @param key com.hps.july.persistence.AgregateContentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.AgregateContent findByPrimaryKey(com.hps.july.persistence.AgregateContentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
