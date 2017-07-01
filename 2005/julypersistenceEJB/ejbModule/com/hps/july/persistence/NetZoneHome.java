package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface NetZoneHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.NetZone
 * @param argNetzone int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.NetZone create(int argNetzone) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.NetZone
 * @param argNetzone int
 * @param argName java.lang.String
 * @param argZonecode java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.NetZone create(int argNetzone, java.lang.String argName, java.lang.String argZonecode) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.NetZone
 * @param argNetzone int
 * @param argName java.lang.String
 * @param argZonecode java.lang.String
 * @param argRegionId int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.NetZone create(int argNetzone, java.lang.String argName, java.lang.String argZonecode, int argRegionId) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findAllOrderByNameAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.NetZone
 * @param key com.hps.july.persistence.NetZoneKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.NetZone findByPrimaryKey(com.hps.july.persistence.NetZoneKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
	public com.hps.july.persistence.NetZone create(
		int argNetzone,
		String argName,
		String argZonecode,
		int argRegionId,
		java.math.BigDecimal argTCode)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
