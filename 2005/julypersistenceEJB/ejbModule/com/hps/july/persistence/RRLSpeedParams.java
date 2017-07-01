package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface RRLSpeedParams extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for radiationclass
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRadiationclass() throws java.rmi.RemoteException;
/**
 * Getter method for recvsensitivity
 * @return java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
java.math.BigDecimal getRecvsensitivity() throws java.rmi.RemoteException;
/**
 * Getter method for resource
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getResource() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getRrlspeedid() throws java.rmi.RemoteException;
/**
 * Getter method for streamspeed
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getStreamspeed() throws java.rmi.RemoteException;
/**
 * Setter method for radiationclass
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRadiationclass(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for recvsensitivity
 * @param newValue java.math.BigDecimal
 * @exception java.rmi.RemoteException The exception description.
 */
void setRecvsensitivity(java.math.BigDecimal newValue) throws java.rmi.RemoteException;
/**
 * Setter method for resource
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setResource(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for streamspeed
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setStreamspeed(java.lang.String newValue) throws java.rmi.RemoteException;
}
