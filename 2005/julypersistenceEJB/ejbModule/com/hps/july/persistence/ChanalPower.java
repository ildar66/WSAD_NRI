package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ChanalPower extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getBand() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.BaseStation getBasestation() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChanalPower2basestation.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.StoragePlaceKey getBasestationKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getChanal() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPolarization() throws java.rmi.RemoteException;
/**
 * Getter method for power
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getPower() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPolarization(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for power
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setPower(int newValue) throws java.rmi.RemoteException;
}
