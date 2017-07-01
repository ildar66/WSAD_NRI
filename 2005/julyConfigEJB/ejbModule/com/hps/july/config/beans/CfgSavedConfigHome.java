package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgSavedConfig
 */
public interface CfgSavedConfigHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgSavedConfig
	 */
	public com.hps.july.config.beans.CfgSavedConfig findByPrimaryKey(
		com.hps.july.config.beans.CfgSavedConfigKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgSavedConfig create(
		int savconfigid,
		String name)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
