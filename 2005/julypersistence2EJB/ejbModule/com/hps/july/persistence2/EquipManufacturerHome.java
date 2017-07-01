package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: EquipManufacturer
 */
public interface EquipManufacturerHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: EquipManufacturer
	 */
	//public com.hps.july.persistence2.EquipManufacturer create(
	//	java.lang.Integer manufid)
	//	throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Finds an instance using a key for Entity Bean: EquipManufacturer
	 */
	public com.hps.july.persistence2.EquipManufacturer findByPrimaryKey(
		java.lang.Integer primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence2.EquipManufacturer create(
		java.lang.Integer manufid,
		String name,
		String shortname)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
