package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ImportSessionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ImportSession
 * @param argImpsesid int
 * @param argImpTaskid int
 * @param argImportStart java.sql.Timestamp
 * @param argImportEnd java.sql.Timestamp
 * @param argOperator int
 * @param argFilename java.lang.String
 * @param argFilesize int
 * @param argReccount int
 * @param argErrcount int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ImportSession create(int argImpsesid, int argImpTaskid, java.sql.Timestamp argImportStart, java.sql.Timestamp argImportEnd, int argOperator, java.lang.String argFilename, int argFilesize, int argReccount, int argErrcount) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ImportSession
 * @param key com.hps.july.persistence.ImportSessionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ImportSession findByPrimaryKey(com.hps.july.persistence.ImportSessionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(
		Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate,
		Boolean isOperator, Integer operator,
		Boolean isKeyfields, String keyfields,
		Boolean isImpsesid, Integer impsesid,
		Integer order
	) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE2(
		Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate,
		Boolean isOperator, Integer operator,
		Boolean isKeyfields, String keyfields,
		Boolean isImpsesid, Integer impsesid,
		Boolean isTaskid, Integer argTaskId,
		Integer order
	) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findImportSessionsByImporttask(com.hps.july.persistence.ImportTaskKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findImportSessionsByOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
