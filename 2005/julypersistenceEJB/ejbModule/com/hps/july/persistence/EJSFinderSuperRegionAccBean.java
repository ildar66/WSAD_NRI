package com.hps.july.persistence;

/**
 * EJSFinderSuperRegionAccBean
 */
public interface EJSFinderSuperRegionAccBean {
	/**
	 * findSuperRegionAccsBySuperregion
	 */
	public com.ibm.ejs.persistence.EJSFinder findSuperRegionAccsBySuperregion(com.hps.july.persistence.SuperRegionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByOperatorAndId
	 */
	public com.ibm.ejs.persistence.EJSFinder findByOperatorAndId(java.lang.Integer argOperator, java.lang.Integer argSregionID) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByOperator
	 */
	public com.ibm.ejs.persistence.EJSFinder findByOperator(java.lang.Integer argOperator) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByCodeAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSuperRegionAccsByOperator
	 */
	public com.ibm.ejs.persistence.EJSFinder findSuperRegionAccsByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
