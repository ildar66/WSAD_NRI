package com.hps.july.persistence;

/**
 * EJSFinderOuterDocPositionBean
 */
public interface EJSFinderOuterDocPositionBean {
	/**
	 * findMaxOrderPosition
	 */
	public com.hps.july.persistence.OuterDocPosition findMaxOrderPosition(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocumentResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocumentResource(java.lang.Integer argDocument, java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByInWayBillOrderByOrderAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByInWayBillOrderByOrderAsc(java.lang.Integer argDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOuterDocPositionByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findOuterDocPositionByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOuterDocPositionByInWayBill
	 */
	public com.ibm.ejs.persistence.EJSFinder findOuterDocPositionByInWayBill(com.hps.july.persistence.DocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
