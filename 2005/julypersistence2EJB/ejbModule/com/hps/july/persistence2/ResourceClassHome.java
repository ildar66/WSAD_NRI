package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: ResourceClass
 */
public interface ResourceClassHome extends javax.ejb.EJBHome {
	/**
	 * Finds an instance using a key for Entity Bean: ResourceClass
	 */
	public com.hps.july.persistence2.ResourceClass findByPrimaryKey(
		com.hps.july.persistence2.ResourceClassKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * ejbCreate method for a CMP entity bean.
	 */
	public com.hps.july.persistence2.ResourceClass create(
		int argClassid,
		String argClassname)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
