package com.hps.july.persistence;

/**
 * EJSFinderRequestBean
 */
public interface EJSFinderRequestBean {
	/**
	 * findRequestSenderBySender
	 */
	public com.ibm.ejs.persistence.EJSFinder findRequestSenderBySender(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRequestByChecker
	 */
	public com.ibm.ejs.persistence.EJSFinder findRequestByChecker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRequestByDivisionRequester
	 */
	public com.ibm.ejs.persistence.EJSFinder findRequestByDivisionRequester(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findRequestByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findRequestByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean useDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean useDivision, java.lang.Integer division, java.lang.Boolean usePosition, java.lang.Integer position, java.lang.String requestType, java.lang.Boolean useOrganization, java.lang.Integer organization, java.lang.Boolean useWorker, java.lang.Integer worker, java.lang.Boolean hasNoLink) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
