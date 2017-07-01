package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseTaskStartHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.LeaseTaskStart
 * @param argTaskstart int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.LeaseTaskStart create(int argTaskstart) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseTaskStart
 * @param argTaskStart int
 * @param argStartDate java.sql.Timestamp
 * @param argWorker int
 * @param argTaskType java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseTaskStart create(int argTaskStart, java.sql.Timestamp argStartDate, int argWorker, java.lang.String argTaskType) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseTaskStart
 * @param key com.hps.july.persistence.LeaseTaskStartKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseTaskStart findByPrimaryKey(com.hps.july.persistence.LeaseTaskStartKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 15:00:32)
 */
public java.util.Enumeration findByQBE(java.lang.Boolean isStartDate, java.sql.Date beginStartDate, 
	java.sql.Date endStartDate, // период
        java.lang.Boolean isWorker, java.lang.Integer worker,
        java.lang.Boolean isTaskType, java.lang.String taskType,
        java.lang.Integer order)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Insert the method's description here.
 * Creation date: (19.09.2002 15:00:32)
 */
public java.util.Enumeration findByQBE2(
        java.lang.Boolean isTaskType, java.lang.String taskType,
        java.lang.Boolean isDocument, java.lang.Integer document,
        java.lang.Integer order)  throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Economist.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseTaskStartEconomistsByEconomistWorker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2document.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseTaskStartsByLeasedocument(com.hps.july.persistence.LeaseDocumentKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseTaskStart2Operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findLeaseTaskStartsByStartOperator(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
