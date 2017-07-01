package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ComplectHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.Complect
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.Complect create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.Complect
 * @param argComplect java.lang.Integer
 * @param argPart java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.Complect create(java.lang.Integer argComplect, java.lang.Integer argPart) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.Complect
 * @param key com.hps.july.persistence.ComplectKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.Complect findByPrimaryKey(com.hps.july.persistence.ComplectKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Complect2Parts.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findComplectpartsByParts(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Complects2MainResource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findComplectsByComplect(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
