package com.hps.july.persistence;

/**
 * EJSFinderOutWayBillBean
 */
public interface EJSFinderOutWayBillBean {
	/**
	 * findOutWayBillsByCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findOutWayBillsByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDate, java.sql.Date dateFrom, java.sql.Date dateTo, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isStorage, java.lang.Integer storage, java.lang.Boolean isContragent, java.lang.Integer contragent, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
