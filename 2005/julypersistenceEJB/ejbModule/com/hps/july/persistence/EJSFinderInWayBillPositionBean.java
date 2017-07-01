package com.hps.july.persistence;

/**
 * EJSFinderInWayBillPositionBean
 */
public interface EJSFinderInWayBillPositionBean {
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.InWayBillPosition findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInWayBillPositionByOuterDocPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findInWayBillPositionByOuterDocPosition(com.hps.july.persistence.OuterDocPositionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.InWayBillPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBadAgregatesByDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findBadAgregatesByDocument(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
