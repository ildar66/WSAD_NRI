package com.hps.july.persistence;

/**
 * EJSFinderAfsMountActBean
 */
public interface EJSFinderAfsMountActBean {
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isPosition, java.lang.Integer position, java.lang.Boolean isProvider, java.lang.Integer provider, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isDate, java.sql.Date startDate, java.sql.Date endDate, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isStorage, java.lang.Integer storage, java.lang.Boolean isContractor, java.lang.Integer contractor, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
