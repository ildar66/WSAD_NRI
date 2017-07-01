package com.hps.july.persistence;

/**
 * EJSFinderLeaseTaskStartBean
 */
public interface EJSFinderLeaseTaskStartBean {
	/**
	 * findLeaseTaskStartsByLeasedocument
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseTaskStartsByLeasedocument(com.hps.july.persistence.LeaseDocumentKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isStartDate, java.sql.Date beginStartDate, java.sql.Date endStartDate, java.lang.Boolean isWorker, java.lang.Integer worker, java.lang.Boolean isTaskType, java.lang.String taskType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseTaskStartsByStartOperator
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseTaskStartsByStartOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findLeaseTaskStartEconomistsByEconomistWorker
	 */
	public com.ibm.ejs.persistence.EJSFinder findLeaseTaskStartEconomistsByEconomistWorker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isTaskType, java.lang.String taskType, java.lang.Boolean isDocument, java.lang.Integer document, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
