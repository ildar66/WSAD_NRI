package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgStoragecard
 */
public interface CfgStoragecardHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgStoragecard
	 */
	public com.hps.july.config.beans.CfgStoragecard findByPrimaryKey(
		com.hps.july.config.beans.CfgStoragecardKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgStoragecard create(
		int savconfigid,
		int storagecard,
		int resource,
		java.sql.Date dateopened,
		int owner,
		String policy,
		String closed,
		java.math.BigDecimal qty,
		java.math.BigDecimal price,
		boolean isfictserial,
		boolean isapproved,
		String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
