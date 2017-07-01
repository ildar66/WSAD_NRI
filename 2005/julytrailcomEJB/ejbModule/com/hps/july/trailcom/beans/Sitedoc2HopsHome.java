package com.hps.july.trailcom.beans;

/**
 * This is a Home interface for the Entity Bean
 */
public interface Sitedoc2HopsHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.trailcom.beans.Sitedoc2Hops
 * @param argSitedoc int
 * @param argHopsid int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.trailcom.beans.Sitedoc2Hops create(int argSitedoc, int argHopsid) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.trailcom.beans.Sitedoc2Hops
 * @param key com.hps.july.trailcom.beans.Sitedoc2HopsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.trailcom.beans.Sitedoc2Hops findByPrimaryKey(com.hps.july.trailcom.beans.Sitedoc2HopsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Sitedoc2Hops2hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findSitedoc2HopsByHop(com.hps.july.trailcom.beans.HopKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findSitedoc2HopsBySitedoc(Integer sitedoc) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
