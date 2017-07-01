package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface RRLDocsHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.RRLDocs
 * @param argSitedoc int
 * @param argOrganization int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.RRLDocs create(int argSitedoc, int argOrganization) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.RRLDocs
 * @param key com.hps.july.persistence2.RRLDocsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.RRLDocs findByPrimaryKey(com.hps.july.persistence2.RRLDocsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
