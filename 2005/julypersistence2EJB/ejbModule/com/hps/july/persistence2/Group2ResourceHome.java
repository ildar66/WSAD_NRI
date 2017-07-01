package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: Group2Resource
 */
public interface Group2ResourceHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: Group2Resource
	 */
	public com.hps.july.persistence2.Group2Resource findByPrimaryKey(
		com.hps.july.persistence2.Group2ResourceKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence2.Group2Resource create(
		int groupid,
		int resource,
		java.math.BigDecimal qty)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
