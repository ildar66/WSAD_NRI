package com.hps.july.persistence2;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface EtapDoc extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getEquiplink() throws java.rmi.RemoteException;
/**
 * Getter method for etaptypeid
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getEtaptypeid() throws java.rmi.RemoteException;
/**
 * Getter method for freqpermid
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getFreqpermid() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getHavepay() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getSitedoc() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setEquiplink(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for etaptypeid
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setEtaptypeid(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for freqpermid
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setFreqpermid(int newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setHavepay(java.lang.Boolean newValue) throws java.rmi.RemoteException;
}
