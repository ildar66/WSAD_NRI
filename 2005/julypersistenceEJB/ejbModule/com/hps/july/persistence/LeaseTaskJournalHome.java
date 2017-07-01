package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseTaskJournalHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.LeaseTaskJournal
 * @param argTaskjournal int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseTaskJournal create(int argTaskjournal) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseTaskJournal
 * @param argTaskJournal int
 * @param argTaskStart int
 * @param argJrnDate java.sql.Timestamp
 * @param argJrnAction int
 * @param argJrnType java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseTaskJournal create(int argTaskJournal, int argTaskStart, java.sql.Timestamp argJrnDate, int argJrnAction, java.lang.String argJrnType) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseTaskJournal
 * @param key com.hps.july.persistence.LeaseTaskJournalKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseTaskJournal findByPrimaryKey(com.hps.july.persistence.LeaseTaskJournalKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByQBE(java.lang.Integer taskStart, 
	Boolean isError, Boolean isWarning, Boolean isSuccess, Integer order)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByTaskStartOrderByJrnDate(java.lang.Integer taskStart, java.lang.Integer order)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findByTaskStartOrderByJrndateAscAndTaskjournalAsc(java.lang.Integer taskStart, 
	Boolean isError, Boolean isWarning, Boolean isSuccess)  throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByTaskStartType(java.lang.Integer taskStart,
	Boolean isJrnType, String jrnType,
	java.lang.Integer order)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findStart2journalByJournal2start(com.hps.july.persistence.LeaseTaskStartKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
