package com.hps.july.persistence;

/**
 * EJSFinderChangeActBean
 */
public interface EJSFinderChangeActBean {
	/**
	 * findByQBEPosition2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBEPosition2(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Character requestType, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Character acttype, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBEPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBEPosition(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Character requestType, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isContragent, java.lang.Integer contragent, java.lang.Boolean isExpeditor, java.lang.Integer expeditor, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentByQBE(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorageFrom, java.lang.Integer storageFrom, java.lang.Boolean isStorageTo, java.lang.Integer storageTo) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
