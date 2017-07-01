package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEPartyResLink extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getIdResPlatinum() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getOwner() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getParty() throws java.rmi.RemoteException;
/**
 * Getter method for partyplatinum
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPartyplatinum() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setIdResPlatinum(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for partyplatinum
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPartyplatinum(java.lang.String newValue) throws java.rmi.RemoteException;
}
