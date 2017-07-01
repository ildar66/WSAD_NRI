package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ImportRecordHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ImportRecord
 * @param argImprecid int
 * @param argImpSesid int
 * @param argRecendtime java.sql.Timestamp
 * @param argAction java.lang.String
 * @param argResult java.lang.String
 * @param argErrlabel java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ImportRecord create(int argImprecid, int argImpSesid, java.sql.Timestamp argRecendtime, java.lang.String argAction, java.lang.String argResult, java.lang.String argErrlabel) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ImportRecord
 * @param key com.hps.july.persistence.ImportRecordKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ImportRecord findByPrimaryKey(com.hps.july.persistence.ImportRecordKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate,
	Boolean isOperator, Integer operator,
	Boolean isKeyfields, String keyfields,
	Boolean isImpsesid, Integer impsesid,
	Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE1(Boolean isRecendtime, java.sql.Timestamp beginDate, java.sql.Timestamp endDate,
	Boolean isOperator, Integer operator,
	Boolean isKeyfields, String keyfields,
	Boolean isImpsesid, Integer impsesid,
	Boolean isResult, String result,
	Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findImportRecordsByImportsession(com.hps.july.persistence.ImportSessionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
