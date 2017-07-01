package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgBasestation
 */
public interface CfgBasestationHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgBasestation
	 */
	public com.hps.july.config.beans.CfgBasestation findByPrimaryKey(
		com.hps.july.config.beans.CfgBasestationKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgBasestation create(
		int argSavconfigid,
		int argEquipment,
		String argType,
		boolean argRepeater,
		int argNumber,
		String argName,
		String argObjectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
