package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: ResourceSetClass
 */
public interface ResourceSetClassHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: ResourceSetClass
	 */
	public com.hps.july.persistence2.ResourceSetClass findByPrimaryKey(
		com.hps.july.persistence2.ResourceSetClassKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence2.ResourceSetClass create(
		int argClassid,
		String argClassname)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
