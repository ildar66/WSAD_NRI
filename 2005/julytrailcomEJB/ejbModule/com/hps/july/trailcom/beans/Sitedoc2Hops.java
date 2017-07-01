package com.hps.july.trailcom.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Sitedoc2Hops extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Sitedoc2Hops2hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.Hop getHop() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Sitedoc2Hops2hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.HopKey getHopKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedoc() throws java.rmi.RemoteException;
}
