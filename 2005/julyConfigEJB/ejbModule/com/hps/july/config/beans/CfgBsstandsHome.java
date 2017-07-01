package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgBsstands
 */
public interface CfgBsstandsHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgBsstands
	 */
	public com.hps.july.config.beans.CfgBsstands findByPrimaryKey(
		com.hps.july.config.beans.CfgBsstandsKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgBsstands create(
		int savconfigid,
		int standid,
		int equipment,
		String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
