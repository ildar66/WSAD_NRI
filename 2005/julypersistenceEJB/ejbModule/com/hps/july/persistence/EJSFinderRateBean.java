package com.hps.july.persistence;

/**
 * EJSFinderRateBean
 */
public interface EJSFinderRateBean {
	/**
	 * findByTypeDate
	 */
	public com.ibm.ejs.persistence.EJSFinder findByTypeDate(java.lang.Integer type, java.sql.Date date) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRateByType
	 */
	public com.ibm.ejs.persistence.EJSFinder findRateByType(com.hps.july.persistence.RateTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByTypeAndCurrencyOrderByDateDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByTypeAndCurrencyOrderByDateDesc(java.lang.Integer argType, java.lang.Integer argCurrency) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRatesByCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findRatesByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByTypeCurrencyForDate
	 */
	public com.hps.july.persistence.Rate findByTypeCurrencyForDate(java.lang.Integer type, java.lang.Integer currency, java.sql.Date date) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
