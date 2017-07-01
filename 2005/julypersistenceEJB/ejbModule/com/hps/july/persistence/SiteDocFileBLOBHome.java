package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface SiteDocFileBLOBHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.SiteDocFileBLOB
 * @param argSitedocfile int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.SiteDocFileBLOB create(int argSitedocfile) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.SiteDocFileBLOB
 * @param key com.hps.july.persistence.SiteDocFileBLOBKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.SiteDocFileBLOB findByPrimaryKey(com.hps.july.persistence.SiteDocFileBLOBKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
