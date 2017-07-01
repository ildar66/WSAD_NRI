package com.hps.july.persistence;

/**
 * EJSFinderImportRecordBean
 */
public interface EJSFinderImportRecordBean {
	/**
	 * findImportRecordsByImportsession
	 */
	public com.ibm.ejs.persistence.EJSFinder findImportRecordsByImportsession(com.hps.july.persistence.ImportSessionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE1
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE1(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Boolean isResult, java.lang.String result, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate, java.lang.Boolean isOperator, java.lang.Integer operator, java.lang.Boolean isKeyfields, java.lang.String keyfields, java.lang.Boolean isImpsesid, java.lang.Integer impsesid, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
