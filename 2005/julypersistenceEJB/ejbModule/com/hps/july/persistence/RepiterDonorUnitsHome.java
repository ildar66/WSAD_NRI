package com.hps.july.persistence;
/**
 * Home interface for Enterprise Bean: RepiterDonorUnits
 */
public interface RepiterDonorUnitsHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: RepiterDonorUnits
	 */
	public com.hps.july.persistence.RepiterDonorUnits findByPrimaryKey(
		com.hps.july.persistence.ResourceKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	public com.hps.july.persistence.RepiterDonorUnits create(
		int argResource,
		String argName,
		String argModel,
		String argNotes,
		Boolean argComplect,
		String argCountpolicy,
		Boolean argBoxable,
		Boolean argPriceable,
		Boolean argComplectpart,
		Boolean argActive,
		int argSubType)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Creates an instance from a key for Entity Bean: RepiterDonorUnits
	 */
	public com.hps.july.persistence.RepiterDonorUnits create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
