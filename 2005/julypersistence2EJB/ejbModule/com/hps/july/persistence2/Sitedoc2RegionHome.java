package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Sitedoc2RegionHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence2.Sitedoc2Region
 * @param argRegion int
 * @param argSitedoc int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence2.Sitedoc2Region create(int argRegion, int argSitedoc) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * Найти все связи по документу
 * @return Enumeration
 * @param key com.hps.july.persistence2.Sitedoc2RegionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findAllBySitedoc(int argSiteDoc) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.Sitedoc2Region
 * @param key com.hps.july.persistence2.Sitedoc2RegionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.Sitedoc2Region findByPrimaryKey(com.hps.july.persistence2.Sitedoc2RegionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
