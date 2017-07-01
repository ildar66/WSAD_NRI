package com.hps.july.persistence;

/**
 * EJSFinderPIEValutesBean
 */
public interface EJSFinderPIEValutesBean {
	/**
	 * findByidvalutenriOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByidvalutenriOrderByCodeAsc(java.lang.Integer argCurrency) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
