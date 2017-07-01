package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface RRLAntParamsHome extends javax.ejb.EJBHome {
/**
 * 
 * @return com.hps.july.persistence.RRLAntParams
 * @param argRrlantid int
 * @param argResource int
 * @param argAntDiam java.math.BigDecimal
 * @param argAmplifKoeff java.math.BigDecimal
 * @param argDNAngleH java.math.BigDecimal
 * @param argDNAngleW java.math.BigDecimal
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.RRLAntParams create(int argRrlantid, int argResource, java.math.BigDecimal argAntDiam, java.math.BigDecimal argAmplifKoeff, java.math.BigDecimal argDNAngleH, java.math.BigDecimal argDNAngleW) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.RRLAntParams
 * @param key com.hps.july.persistence.RRLAntParamsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.RRLAntParams findByPrimaryKey(com.hps.july.persistence.RRLAntParamsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
	public java.util.Enumeration findByResource(int argResource) throws java.rmi.RemoteException, javax.ejb.FinderException;
	public java.util.Enumeration findByResourceAndDiam(int argResource, java.math.BigDecimal argDiam) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
