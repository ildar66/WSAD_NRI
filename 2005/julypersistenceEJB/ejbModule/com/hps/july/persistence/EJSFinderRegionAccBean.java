package com.hps.july.persistence;

/**
 * EJSFinderRegionAccBean
 */
public interface EJSFinderRegionAccBean {
	/**
	 * findByOperatorAndId
	 */
	public com.ibm.ejs.persistence.EJSFinder findByOperatorAndId(java.lang.Integer argOperator, java.lang.Integer argRegionID) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRegionAccsByOperator
	 */
	public com.ibm.ejs.persistence.EJSFinder findRegionAccsByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRegionAccsByRegion
	 */
	public com.ibm.ejs.persistence.EJSFinder findRegionAccsByRegion(com.hps.july.persistence.RegionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Integer argOperator, java.lang.Boolean isSuperregion, java.lang.Integer argSupregion, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBySuperregionOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySuperregionOrderByCodeAsc(java.lang.Integer argSupregion) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
