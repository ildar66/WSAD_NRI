package com.hps.july.config.beans;
/**
 * Home interface for Enterprise Bean: CfgEquipObjCfg2Sector
 */
public interface CfgEquipObjCfg2SectorHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: CfgEquipObjCfg2Sector
	 */
	public com.hps.july.config.beans.CfgEquipObjCfg2Sector findByPrimaryKey(
		com.hps.july.config.beans.CfgEquipObjCfg2SectorKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.config.beans.CfgEquipObjCfg2Sector create(
		int savconfigid,
		int objcfgid,
		int id_sect,
		String objectStatus)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
