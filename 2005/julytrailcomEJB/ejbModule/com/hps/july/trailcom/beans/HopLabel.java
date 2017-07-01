package com.hps.july.trailcom.beans;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface HopLabel extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.trailcom.beans.Hop getHopid() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.trailcom.beans.HopKey getHopidKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getHopslabelid() throws java.rmi.RemoteException;
/**
 * Getter method for hopsname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getHopsname() throws java.rmi.RemoteException;
/**
 * Getter method for hopsnamecomments
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getHopsnamecomments() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetHopidKey(com.hps.july.trailcom.beans.HopKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetHopid(com.hps.july.trailcom.beans.Hop aHopid) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named HopLabel2Hop.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setHopid(com.hps.july.trailcom.beans.Hop aHopid) throws java.rmi.RemoteException;
/**
 * Setter method for hopsname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setHopsname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for hopsnamecomments
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setHopsnamecomments(java.lang.String newValue) throws java.rmi.RemoteException;
}
