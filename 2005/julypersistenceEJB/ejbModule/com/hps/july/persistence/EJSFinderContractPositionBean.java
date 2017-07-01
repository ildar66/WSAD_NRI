package com.hps.july.persistence;

/**
 * EJSFinderContractPositionBean
 */
public interface EJSFinderContractPositionBean {
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.ContractPosition findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocOrderByContractPositionOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocOrderByContractPositionOrderAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentSerialnum
	 */
	public com.hps.july.persistence.ContractPosition findByDocumentSerialnum(java.lang.Integer argDocument, java.lang.String argSerial) throws javax.ejb.FinderException, java.rmi.RemoteException;
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
