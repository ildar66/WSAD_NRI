package com.hps.july.persistence;

/**
 * EJSFinderStorageBean
 */
public interface EJSFinderStorageBean {
	/**
	 * findByPlatinumAndStatus
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPlatinumAndStatus(java.lang.Integer owner, java.lang.String state, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
