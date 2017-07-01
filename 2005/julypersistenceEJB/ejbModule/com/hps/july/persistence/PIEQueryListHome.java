package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PIEQueryListHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PIEQueryList
 * @param argIdquerylist int
 * @param argQuery int
 * @param argTypeobjnri java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PIEQueryList create(int argIdquerylist, int argQuery, java.lang.String argTypeobjnri) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PIEQueryList
 * @param key com.hps.july.persistence.PIEQueryListKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PIEQueryList findByPrimaryKey(com.hps.july.persistence.PIEQueryListKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPIEQueryListsByQuery(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
