package com.hps.july.persistence;

/**
 * EJSFinderLeaseMutualActNewBean
 */
public interface EJSFinderLeaseMutualActNewBean {
	/**
	 * findLeaseMutualActNewByLeaseMutualReglament
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseMutualActNewByLeaseMutualReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isMutualReglament, java.lang.Integer mutualReglament, java.lang.Boolean isDate, java.sql.Date fromDate, java.sql.Date toDate, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Integer mutualReglament, java.lang.Boolean isEdit, java.lang.Boolean isRun, java.lang.Boolean isClose, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
