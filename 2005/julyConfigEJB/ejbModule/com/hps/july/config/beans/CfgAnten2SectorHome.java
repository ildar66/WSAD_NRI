package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgAnten2Sector
 */
public interface CfgAnten2SectorHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgAnten2Sector
	 */
	public com.hps.july.config.beans.CfgAnten2Sector findByPrimaryKey(
		com.hps.july.config.beans.CfgAnten2SectorKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgAnten2Sector create(
		int savconfigid,
		int id_anten,
		int id_sect,
		int datasource,
		String objectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
