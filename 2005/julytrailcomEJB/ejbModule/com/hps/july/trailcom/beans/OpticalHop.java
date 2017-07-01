package com.hps.july.trailcom.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface OpticalHop extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named OpticalHop2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.Hop getHopid() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named OpticalHop2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.trailcom.beans.HopKey getHopidKey() throws java.rmi.RemoteException;
/**
 * Getter method for hopscomment
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getHopscomment() throws java.rmi.RemoteException;
/**
 * Setter method for hopscomment
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setHopscomment(java.lang.String newValue) throws java.rmi.RemoteException;
}
