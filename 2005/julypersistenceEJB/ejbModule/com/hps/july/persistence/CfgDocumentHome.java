package com.hps.july.persistence;
/**
 * Home interface for Enterprise Bean: CfgDocument
 */
public interface CfgDocumentHome extends javax.ejb.EJBHome {
	/**
	 * Creates an instance from a key for Entity Bean: CfgDocument
	 */
	/*
	public com.hps.july.persistence.CfgDocument create(
		int document,
		com.hps.july.persistence.Organization argOwner,
		com.hps.july.persistence.StoragePlace argTo,
		com.hps.july.persistence.Organization argContragent,
		com.hps.july.persistence.StoragePlace argFrom,
		com.hps.july.persistence.Worker argStorageManager)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
	*/
	/**
	 * Finds an instance using a key for Entity Bean: CfgDocument
	 */
	public com.hps.july.persistence.CfgDocument findByPrimaryKey(
		com.hps.july.persistence.DocumentKey primaryKey)
		throws javax.ejb.FinderException, java.rmi.RemoteException;
		
	public com.hps.july.persistence.CfgDocument create(
		int argDocument,
		Integer argOwner,
		Integer argFrom,
		Integer argTo,
		java.sql.Date argBlankDate,
		int argBlankindex,
		String argBlankNumber,
		String argState,
		Boolean argProcessSource,
		Boolean argProcessDestination,
		int SavconfigIdOld,
		int SavconfigIdNew)
		throws javax.ejb.CreateException, java.rmi.RemoteException;
}
