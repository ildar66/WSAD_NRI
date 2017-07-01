package com.hps.july.persistence2;

/**
 * This is a Home interface for the Entity Bean
 */
public interface EtapTypeHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence2.EtapType
 * @param argEtaptypeid int
 * @param argEttypename java.lang.String
 * @param argHaveEndTime boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence2.EtapType create(int argEtaptypeid, java.lang.String argEttypename, boolean argHaveEndTime) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence2.EtapType
 * @param key com.hps.july.persistence2.EtapTypeKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence2.EtapType findByPrimaryKey(com.hps.july.persistence2.EtapTypeKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
