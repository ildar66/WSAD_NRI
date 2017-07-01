package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Etap2HopHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.Etap2Hop
 * @param argHopsid int
 * @param argSitedoc int
 * @param argFreqpermid int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.Etap2Hop create(int argHopsid, int argSitedoc, int argFreqpermid) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.Etap2Hop
 * @param key com.hps.july.persistence2.Etap2HopKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.Etap2Hop findByPrimaryKey(com.hps.july.persistence2.Etap2HopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findBySitedocAndPermid(Integer argSiteDoc, Integer argPermid) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
