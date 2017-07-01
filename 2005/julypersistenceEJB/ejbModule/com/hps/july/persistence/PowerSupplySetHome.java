package com.hps.july.persistence;
/**
 * Home interface for Enterprise Bean: PowerSupplySet
 */
public interface PowerSupplySetHome extends javax.ejb.EJBHome {

	/**
	 * Finds an instance using a key for Entity Bean: PowerSupplySet
	 */
	public com.hps.july.persistence.PowerSupplySet findByPrimaryKey(
		com.hps.july.persistence.ResourceSetKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
		
	public com.hps.july.persistence.PowerSupplySet create(
		int argResourceset,
		String argName,
		Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		String argType,
		java.math.BigDecimal argPower)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
