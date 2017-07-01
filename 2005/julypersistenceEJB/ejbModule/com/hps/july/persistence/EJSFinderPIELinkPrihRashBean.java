package com.hps.july.persistence;

/**
 * EJSFinderPIELinkPrihRashBean
 */
public interface EJSFinderPIELinkPrihRashBean {
	/**
	 * findByDocposPrihod
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocposPrihod(java.lang.Integer argDocpos) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByDocposRashod
	 */
	public com.ibm.ejs.persistence.EJSFinder findByDocposRashod(java.lang.Integer argDocpos) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
