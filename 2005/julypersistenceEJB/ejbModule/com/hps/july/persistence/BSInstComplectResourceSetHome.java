package com.hps.july.persistence;
/**
 * Home interface for Enterprise Bean: BSInstComplectResourceSet
 */
public interface BSInstComplectResourceSetHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: BSInstComplectResourceSet
	 */
	public com.hps.july.persistence.BSInstComplectResourceSet findByPrimaryKey(
		com.hps.july.persistence.ResourceSetKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	public com.hps.july.persistence.BSInstComplectResourceSet create(
		int argResourceset,
		String argName,
		Integer argMainPart,
		java.math.BigDecimal argMainPartQty,
		String argType)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
