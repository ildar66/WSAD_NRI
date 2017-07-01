package com.hps.july.persistence2;
/**
 * Home interface for Enterprise Bean: AfsScheme
 */
public interface AfsSchemeHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: AfsScheme
	 */
	public com.hps.july.persistence2.AfsScheme create(
		java.lang.Integer schemeid)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	/**
	 * Finds an instance using a key for Entity Bean: AfsScheme
	 */
	public com.hps.july.persistence2.AfsScheme findByPrimaryKey(
		com.hps.july.persistence2.AfsSchemeKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
}
