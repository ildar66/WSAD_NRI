package com.hps.july.persistence;

/**
 * EJSFinderCurrencyBean
 */
public interface EJSFinderCurrencyBean {
	/**
	 * findByConnectedOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByConnectedOrderByNameAsc(java.lang.Integer argConnected) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
