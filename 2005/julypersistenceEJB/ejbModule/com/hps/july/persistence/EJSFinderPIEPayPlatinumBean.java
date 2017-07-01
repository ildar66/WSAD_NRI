package com.hps.july.persistence;

/**
 * EJSFinderPIEPayPlatinumBean
 */
public interface EJSFinderPIEPayPlatinumBean {
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDateStart, java.sql.Date argDateStart, java.lang.Boolean isDateEnd, java.sql.Date argDateEnd, java.lang.Boolean isIdDogovNri, java.lang.Integer argIdDogovNri, java.lang.Boolean isFlagWorkNri, java.lang.String argFlagWorkNri, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
