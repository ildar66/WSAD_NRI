package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEDocNriHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEDocNri
 * @param argIdrecdoc int
 * @param argQuery int
 * @param argTypeDocNri short
 * @param argOwner int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEDocNri create(int argIdrecdoc, int argQuery, short argTypeDocNri, int argOwner) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEDocNri
 * @param key com.hps.july.persistence.PIEDocNriKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEDocNri findByPrimaryKey(com.hps.july.persistence.PIEDocNriKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEDocNri2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPIEDocNrisByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
