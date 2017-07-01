package com.hps.july.persistence;

/**
 * EJSFinderDocumentBean
 */
public interface EJSFinderDocumentBean {
	/**
	 * findContagentDocumentByContragent
	 */
	public com.ibm.ejs.persistence.EJSFinder findContagentDocumentByContragent(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOutDocumentByFrom
	 */
	public com.ibm.ejs.persistence.EJSFinder findOutDocumentByFrom(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentforstoragerByStorageManager
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentforstoragerByStorageManager(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentByParent
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentByParent(java.lang.Integer argParent, java.lang.String argType) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInDocumentByTo
	 */
	public com.ibm.ejs.persistence.EJSFinder findInDocumentByTo(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentByQBE(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorageFrom, java.lang.Integer storageFrom, java.lang.Boolean isStorageTo, java.lang.Integer storageTo) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOwnedDocumentByOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findOwnedDocumentByOwner(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
