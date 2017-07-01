package com.hps.july.persistence;

/**
 * EJSFinderInternalOutBillBean
 */
public interface EJSFinderInternalOutBillBean {
	/**
	 * findInternalOutBillByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findInternalOutBillByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isProvider, java.lang.Integer provider, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInternalOutBillByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findInternalOutBillByQBE(java.lang.Boolean isDate, java.sql.Date dateFrom, java.sql.Date dateTo, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isStorage, java.lang.Integer storage, java.lang.Boolean isContragent, java.lang.Integer contragent, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInternalOutBillByMonter
	 */
	public com.ibm.ejs.persistence.EJSFinder findInternalOutBillByMonter(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
