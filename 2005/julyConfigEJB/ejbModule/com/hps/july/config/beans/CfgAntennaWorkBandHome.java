package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgAntennaWorkBand
 */
public interface CfgAntennaWorkBandHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgAntennaWorkBand
	 */
	public com.hps.july.config.beans.CfgAntennaWorkBand findByPrimaryKey(
		com.hps.july.config.beans.CfgAntennaWorkBandKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgAntennaWorkBand create(
		int savconfigid,
		int idanten,
		short band,
		String objectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
