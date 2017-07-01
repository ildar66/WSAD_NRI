package com.hps.july.persistence;

/**
 * EJSFinderRegionBean
 */
public interface EJSFinderRegionBean {
	/**
	 * findRegionBySuperregion
	 */
	public com.ibm.ejs.persistence.EJSFinder findRegionBySuperregion(com.hps.july.persistence.SuperRegionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isSuperRegion, java.lang.Integer superRegion, java.lang.Boolean isRegionName, java.lang.String regionName, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
