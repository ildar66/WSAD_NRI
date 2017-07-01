package com.hps.july.persistence;
/**
 * Home interface for Enterprise Bean: TRXResource
 */
public interface TRXResourceHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: TRXResource
	 */
	public com.hps.july.persistence.TRXResource findByPrimaryKey(
		com.hps.july.persistence.ResourceKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean
	 * @param argResource int
	 * @exception javax.ejb.CreateException The exception description.
	 * @exception java.rmi.RemoteException The exception description.
	 */
	public com.hps.july.persistence.TRXResource create(
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
		int argSubType,
		boolean argDoubletrx)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Creates an instance from a key for Entity Bean: TRXResource
	 */
	public com.hps.july.persistence.TRXResource create(
		int resource,
		com.hps.july.persistence.Unit argUnit,
		com.hps.july.persistence.ResourceSubType argSubtype)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
