package com.hps.july.persistence;

/**
 * EJSFinderPIEOtvUserPlatinumBean
 */
public interface EJSFinderPIEOtvUserPlatinumBean {
	/**
	 * findByOtvuserPlatinumOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByOtvuserPlatinumOrderByNameAsc(java.lang.String argOtvuser) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByNameOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByNameOrderByNameAsc(java.lang.String argName) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
