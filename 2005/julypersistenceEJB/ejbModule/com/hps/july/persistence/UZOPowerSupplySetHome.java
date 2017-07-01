package com.hps.july.persistence;
/**
 * Home interface for Enterprise Bean: UZOPowerSupplySet
 */
public interface UZOPowerSupplySetHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: UZOPowerSupplySet
	 */
	public com.hps.july.persistence.UZOPowerSupplySet create(
		int argResourceset,
		String argName,
		Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Finds an instance using a key for Entity Bean: UZOPowerSupplySet
	 */
	public com.hps.july.persistence.UZOPowerSupplySet findByPrimaryKey(
		com.hps.july.persistence.ResourceSetKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
}
