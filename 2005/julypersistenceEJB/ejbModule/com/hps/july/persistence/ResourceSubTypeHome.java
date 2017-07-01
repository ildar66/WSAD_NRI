package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ResourceSubTypeHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.ResourceSubType
 * @param argResourcesubtype int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.ResourceSubType create(int argResourcesubtype) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.ResourceSubType
 * @param argResourcesubtype int
 * @param argName java.lang.String
 * @param argResourceType java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ResourceSubType create(int argResourcesubtype, java.lang.String argName, java.lang.Integer argResourceType) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ResourceSubType
 * @param key com.hps.july.persistence.ResourceSubTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ResourceSubType findByPrimaryKey(com.hps.july.persistence.ResourceSubTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ResourceSubTypes2resourcetype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findResourceSubTypeByResourcetype(com.hps.july.persistence.ResourceTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
