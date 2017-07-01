package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface LeaseMutualActNewHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.LeaseMutualActNew
 * @param argLeaseDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseMutualActNew
 * @param key com.hps.july.persistence.LeaseDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseMutualActNew findByPrimaryKey(LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseMutualActNew2LeaseMutualReglament.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseMutualActNewByLeaseMutualReglament(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;

java.util.Enumeration findByQBE(
	java.lang.Boolean isMutualReglament, 			java.lang.Integer mutualReglament, 
	java.lang.Boolean isDate, 						java.sql.Date fromDate, 
	java.sql.Date toDate, 
	java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * 
 * @return com.hps.july.persistence.LeaseMutualActNew
 * @param argLeaseDocument int
 * @param argDocDate java.sql.Date
 * @param argDocNumber java.lang.String
 * @param argLeaseMutualReglament java.lang.Integer
 * @param argState java.lang.String
 * @param actstartdate java.sql.Date
 * @param actenddate java.sql.Date
 * @param argIsTemp boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.Integer argLeaseMutualReglament, java.lang.String argState, java.sql.Date actstartdate, java.sql.Date actenddate, boolean argIsTemp) throws javax.ejb.CreateException, java.rmi.RemoteException;

/**
 * 
 * @return com.hps.july.persistence.LeaseMutualActNew
 * @param argLeaseDocument int
 * @param argDocDate java.sql.Date
 * @param argDocNumber java.lang.String
 * @param argLeaseMutualReglament java.lang.Integer
 * @param argState java.lang.String
 * @param actstartdate java.sql.Date
 * @param actenddate java.sql.Date
 * @param argIsTemp boolean
 * @param argIsSchetFakt java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseMutualActNew create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber, java.lang.Integer argLeaseMutualReglament, java.lang.String argState, java.sql.Date actstartdate, java.sql.Date actenddate, boolean argIsTemp, java.lang.Boolean argIsSchetFakt) throws javax.ejb.CreateException, java.rmi.RemoteException;

java.util.Enumeration findByQBE2(
    Integer mutualReglament, 
    Boolean isEdit, 
    Boolean isRun, 
    Boolean isClose, 
    Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;

}
