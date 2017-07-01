package com.hps.july.persistence;
/**
 * Home interface for Enterprise Bean: OrganizationNfs
 */
public interface OrganizationNfsHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: OrganizationNfs
	 */
	public com.hps.july.persistence.OrganizationNfs create(int organization) throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Finds an instance using a key for Entity Bean: OrganizationNfs
	 */
	public com.hps.july.persistence.OrganizationNfs findByPrimaryKey(com.hps.july.persistence.OrganizationNfsKey primaryKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
