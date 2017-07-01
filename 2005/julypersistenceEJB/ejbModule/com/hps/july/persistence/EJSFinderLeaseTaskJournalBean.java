package com.hps.july.persistence;

/**
 * EJSFinderLeaseTaskJournalBean
 */
public interface EJSFinderLeaseTaskJournalBean {
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Integer taskStart, java.lang.Boolean isError, java.lang.Boolean isWarning, java.lang.Boolean isSuccess, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByTaskStartOrderByJrndateAscAndTaskjournalAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findByTaskStartOrderByJrndateAscAndTaskjournalAsc(java.lang.Integer taskStart, java.lang.Boolean isError, java.lang.Boolean isWarning, java.lang.Boolean isSuccess) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByTaskStartType
	 */
	public com.ibm.ejs.persistence.EJSFinder findByTaskStartType(java.lang.Integer taskStart, java.lang.Boolean isJrnType, java.lang.String jrnType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findStart2journalByJournal2start
	 */
	public com.ibm.ejs.persistence.EJSFinder findStart2journalByJournal2start(com.hps.july.persistence.LeaseTaskStartKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByTaskStartOrderByJrnDate
	 */
	public com.ibm.ejs.persistence.EJSFinder findByTaskStartOrderByJrnDate(java.lang.Integer taskStart, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
