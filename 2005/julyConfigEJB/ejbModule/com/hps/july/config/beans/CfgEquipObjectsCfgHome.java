package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgEquipObjectsCfg
 */
public interface CfgEquipObjectsCfgHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgEquipObjectsCfg
	 */
	public com.hps.july.config.beans.CfgEquipObjectsCfg findByPrimaryKey(
		com.hps.july.config.beans.CfgEquipObjectsCfgKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgEquipObjectsCfg create(
		int savconfigid,
		int objcfgid,
		int equipment,
		String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
