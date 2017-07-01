package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface BaseAgreementHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.BaseAgreement
 * @param argBaseagreement int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.BaseAgreement create(int argBaseagreement) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.BaseAgreement
 * @param argBaseagreement int
 * @param argName java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.BaseAgreement create(int argBaseagreement, java.lang.String argName) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Roles2tasks fk_relation__32 Roles.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return java.util.Enumeration
 * @param inKey com.hps.july.security.persistence.RolesKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Roles2tasks fk_relation__32 Roles.  
 * 	It will be deleted/edited when the association is deleted/edited.
 * @return java.util.Enumeration
 * @param inKey com.hps.july.security.persistence.RolesKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findAllOrderByNameDesc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.BaseAgreement
 * @param key com.hps.july.persistence.BaseAgreementKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.BaseAgreement findByPrimaryKey(com.hps.july.persistence.BaseAgreementKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}