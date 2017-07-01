package com.hps.july.persistence;

/**
 * EJSFinderDocumentPositionBean
 */
public interface EJSFinderDocumentPositionBean {
	/**
	 * findByStorageAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByStorageAfterDate(java.lang.Integer argStorage, java.sql.Date argDate) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByResourceSetAndStorageAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByResourceSetAndStorageAfterDate(java.lang.Integer argDocument, java.lang.Integer argStorage, java.sql.Date argDate) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocumentQBE(java.lang.Integer argDocument, java.lang.String argPolicy, java.lang.String argNumber, java.lang.Boolean isResource, java.lang.Integer argResource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentPositionByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentPositionByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentPositionByDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentPositionByDocument(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.DocumentPosition findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Integer argResource, java.lang.Integer argOwner, java.lang.Boolean isSerial, java.lang.String argSerial, java.lang.Boolean isParty, java.lang.String argParty, java.lang.Boolean isTo, java.lang.Integer argTo, java.lang.Boolean isFrom, java.lang.Integer argFrom, java.lang.String argDocType, java.lang.Boolean isAddDoc, java.lang.Integer argAddDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByAgregateAfterDate
	 */
	public com.hps.july.persistence.DocumentPosition findByAgregateAfterDate(java.lang.String argAgregatSerial, java.sql.Date argDate) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentPositionByOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentPositionByOwner(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocumentQBE2(java.lang.Integer argDocument, java.lang.String argPolicy, java.lang.String argNumber, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isResource, java.lang.Integer argResource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBadAgregatesByDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findBadAgregatesByDocument(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAgregatePartsByAgregate
	 */
	public com.ibm.ejs.persistence.EJSFinder findAgregatePartsByAgregate(com.hps.july.persistence.DocumentPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.DocumentPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInDocumentPositionByCardTo
	 */
	public com.ibm.ejs.persistence.EJSFinder findInDocumentPositionByCardTo(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocOrderByAgregateAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocOrderByAgregateAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOutDocumentPositionByCardFrom
	 */
	public com.ibm.ejs.persistence.EJSFinder findOutDocumentPositionByCardFrom(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocOrderByAgregateDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocOrderByAgregateDesc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByRequestResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByRequestResource(java.lang.Integer requestId, java.lang.Integer resourceId) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
