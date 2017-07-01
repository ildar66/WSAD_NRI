package com.hps.july.persistence;

/**
 * EJSFinderAfsMountPosBean
 */
public interface EJSFinderAfsMountPosBean {
	/**
	 * findDocPositionsByDocOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocOrderByOrderAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.AfsMountPos findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByAfs
	 */
	public com.ibm.ejs.persistence.EJSFinder findByAfs(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAfsMountPosesByGroundresource
	 */
	public com.ibm.ejs.persistence.EJSFinder findAfsMountPosesByGroundresource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBadAgregatesByDocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findBadAgregatesByDocument(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocAndPolicyOrderByOrderAsc(java.lang.Integer argDocument, java.lang.String argPolicy) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.AfsMountPos findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocOrderByAgregateAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocOrderByAgregateAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findChildrenByParent
	 */
	public com.ibm.ejs.persistence.EJSFinder findChildrenByParent(java.lang.Integer parentAfsPosition) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findChildByParent
	 */
	public com.hps.july.persistence.AfsMountPos findChildByParent(java.lang.Integer parentAfsPosition) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocOrderByOrderDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocOrderByOrderDesc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocPositionsByDocAndPolicyOrderByOrderDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocPositionsByDocAndPolicyOrderByOrderDesc(java.lang.Integer argDocument, java.lang.String argPolicy) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocOrderByAgregateDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocOrderByAgregateDesc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
