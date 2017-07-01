package com.hps.july.persistence;

/**
 * EJSFinderInternalWayBillBean
 */
public interface EJSFinderInternalWayBillBean {
	/**
	 * findInternalWayBillByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findInternalWayBillByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInternalWayBillByMonter
	 */
	public com.ibm.ejs.persistence.EJSFinder findInternalWayBillByMonter(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isProvider, java.lang.Integer provider, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDate, java.sql.Date startDate, java.sql.Date endDate, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isStorage, java.lang.Integer storage, java.lang.Boolean isContractor, java.lang.Integer contractor, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
