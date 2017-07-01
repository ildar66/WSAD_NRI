package com.hps.july.persistence;

/**
 * EJSFinderWLANBean
 */
public interface EJSFinderWLANBean {
	/**
	 * findByPlatinumAndStatus
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPlatinumAndStatus(java.lang.Integer position, java.lang.Integer owner, java.lang.String state, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
