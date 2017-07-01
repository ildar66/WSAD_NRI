package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgAntennaCable
 */
public interface CfgAntennaCableHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgAntennaCable
	 */
	public com.hps.july.config.beans.CfgAntennaCable findByPrimaryKey(
		com.hps.july.config.beans.CfgAntennaCableKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgAntennaCable create(
		int argSavconfigid,
		int argIdCable,
		int argIdAnten,
		int argCableres,
		java.math.BigDecimal argCableLen,
		int argDataSource,
		String argObjectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
