package com.hps.july.persistence;

/**
 * EJSFinderRateTypeBean
 */
public interface EJSFinderRateTypeBean {
	/**
	 * findRateTypeByBasecurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findRateTypeByBasecurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
