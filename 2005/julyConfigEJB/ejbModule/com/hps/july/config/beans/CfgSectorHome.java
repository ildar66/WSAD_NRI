package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgSector
 */
public interface CfgSectorHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgSector
	 */
	public com.hps.july.config.beans.CfgSector findByPrimaryKey(
		com.hps.july.config.beans.CfgSectorKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgSector create(
		int savconfigid,
		int id_sect,
		int equipment,
		String name_sect,
		short band,
		String num_sect,
		int datasource,
		String objectstatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
