package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: ResourceGroup
 */
public interface ResourceGroupHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: ResourceGroup
	 */
	public com.hps.july.persistence2.ResourceGroup create(int groupid)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Finds an instance using a key for Entity Bean: ResourceGroup
	 */
	public com.hps.july.persistence2.ResourceGroup findByPrimaryKey(
		com.hps.july.persistence2.ResourceGroupKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
}
