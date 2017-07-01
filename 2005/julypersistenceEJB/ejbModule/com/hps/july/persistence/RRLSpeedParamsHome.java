package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface RRLSpeedParamsHome extends javax.ejb.EJBHome {
/**
 * 
 * @return com.hps.july.persistence.RRLSpeedParams
 * @param argRrlspeedid int
 * @param argResource int
 * @param argStreamSpeed java.lang.String
 * @param argRadiationClass java.lang.String
 * @param argRecvSensitivity java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.RRLSpeedParams create(int argRrlspeedid, int argResource, java.lang.String argStreamSpeed, java.lang.String argRadiationClass, java.math.BigDecimal argRecvSensitivity) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.RRLSpeedParams
 * @param key com.hps.july.persistence.RRLSpeedParamsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.RRLSpeedParams findByPrimaryKey(com.hps.july.persistence.RRLSpeedParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
	public java.util.Enumeration findByResource(int argResource) throws java.rmi.RemoteException, javax.ejb.FinderException;
	public java.util.Enumeration findByResourceAndSpeed(int argResource, String argStreamSpeed) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
