package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgTrx
 */
public interface CfgTrxHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgTrx
	 */
	public com.hps.july.config.beans.CfgTrx findByPrimaryKey(
		com.hps.july.config.beans.CfgTrxKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgTrx create(
		int argSavconfigid,
		int argEquipment,
		int argTrxid,
		int argResource,
		int argStandid,
		String argObjectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
