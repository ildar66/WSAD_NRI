package com.hps.july.trailcom.beans;

/**
 * This is a Home interface for the Entity Bean
 */
public interface OpticalHopHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.trailcom.beans.OpticalHop
 * @param hopid int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.trailcom.beans.OpticalHop create(int hopid) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.trailcom.beans.OpticalHop
 * @param key com.hps.july.trailcom.beans.OpticalHopKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.trailcom.beans.OpticalHop findByPrimaryKey(com.hps.july.trailcom.beans.OpticalHopKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named OpticalHop2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.OpticalHop findOpticalHopByHopid(com.hps.july.trailcom.beans.HopKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
