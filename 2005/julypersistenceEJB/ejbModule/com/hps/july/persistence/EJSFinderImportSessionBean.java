package com.hps.july.persistence;

/**
 * EJSFinderImportSessionBean
 */
public interface EJSFinderImportSessionBean {
	/**
	 * findImportSessionsByOperator
	 */
	public com.ibm.ejs.persistence.EJSFinder findImportSessionsByOperator(com.hps.july.persistence.OperatorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE2
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE2(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Boolean isTaskid, java.lang.Integer argTaskId, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findImportSessionsByImporttask
	 */
	public com.ibm.ejs.persistence.EJSFinder findImportSessionsByImporttask(com.hps.july.persistence.ImportTaskKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
