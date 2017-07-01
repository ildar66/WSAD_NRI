package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface I13nActResourceSetHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.I13nActResourceSet
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.I13nActResourceSet create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.I13nActResourceSet
 * @param argDocument java.lang.Integer
 * @param argResource java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.I13nActResourceSet create(java.lang.Integer argDocument, java.lang.Integer argResource) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.I13nActResourceSet
 * @param key com.hps.july.persistence.I13nActResourceSetKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.I13nActResourceSet findBlockingRecord(Integer argResource, Integer argStorage, 
	java.sql.Date docDate, Integer argCurrentDocument ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.I13nActResourceSet
 * @param key com.hps.july.persistence.I13nActResourceSetKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.I13nActResourceSet findByPrimaryKey(com.hps.july.persistence.I13nActResourceSetKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nActResourceSet2I13nAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findI13nActResourceSetByI13nAct(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nActResourceSet2Resource.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findI13nActResourceSetByResource(com.hps.july.persistence.ResourceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
