package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SiteDocTypeHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.SiteDocType
 * @param argSitedoctype int
 * @param sitedoctypename java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.SiteDocType create(int argSitedoctype, java.lang.String sitedoctypename) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAll()  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SiteDocType
 * @param key com.hps.july.persistence.SiteDocTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SiteDocType findByPrimaryKey(com.hps.july.persistence.SiteDocTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
