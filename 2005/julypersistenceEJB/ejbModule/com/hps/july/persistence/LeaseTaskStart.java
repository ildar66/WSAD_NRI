package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface LeaseTaskStart extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addStart2journal(com.hps.july.persistence.LeaseTaskJournal aStart2journal) throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDate1() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDate2() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getEconomistWorker() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getEconomistWorkerKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getEnddate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocument getLeasedocument() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.LeaseDocumentKey getLeasedocumentKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getStart2journal() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getStartdate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Operator getStartOperator() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OperatorKey getStartOperatorKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getTaskstart() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getTasktype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetEconomistWorkerKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetLeasedocumentKey(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetStartOperatorKey(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddStart2journal(com.hps.july.persistence.LeaseTaskJournal aStart2journal) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskJournal2TaskStart.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveStart2journal(com.hps.july.persistence.LeaseTaskJournal aStart2journal) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetEconomistWorker(com.hps.july.persistence.Worker anEconomistWorker) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetLeasedocument(com.hps.july.persistence.LeaseDocument aLeasedocument) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetStartOperator(com.hps.july.persistence.Operator aStartOperator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDate1(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDate2(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setEconomistWorker(com.hps.july.persistence.Worker anEconomistWorker) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setEnddate(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setLeasedocument(com.hps.july.persistence.LeaseDocument aLeasedocument) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setStartdate(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setStartOperator(com.hps.july.persistence.Operator aStartOperator) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setTasktype(java.lang.String newValue) throws java.rmi.RemoteException;
}
