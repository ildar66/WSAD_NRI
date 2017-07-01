package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgTrx2Sector
 */
public interface CfgTrx2SectorHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgTrx2Sector
	 */
	public com.hps.july.config.beans.CfgTrx2Sector findByPrimaryKey(
		com.hps.july.config.beans.CfgTrx2SectorKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgTrx2Sector create(
		int savconfigid,
		int trxid,
		int id_sect,
		String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
