package com.hps.july.persistence;

/**
 * EJSFinderLeaseDocumentBean
 */
public interface EJSFinderLeaseDocumentBean {
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDocDate, java.sql.Date docDate, java.lang.Boolean isBlank, java.lang.String blank, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
