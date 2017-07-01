package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ImportSession extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addImportRecords(com.hps.july.persistence.ImportRecord anImportRecords) throws java.rmi.RemoteException;
/**
 * Getter method for errcount
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getErrcount() throws java.rmi.RemoteException;
/**
 * Getter method for filename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFilename() throws java.rmi.RemoteException;
/**
 * Getter method for filesize
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getFilesize() throws java.rmi.RemoteException;
/**
 * Getter method for filetime
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getFiletime() throws java.rmi.RemoteException;
/**
 * Getter method for importend
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getImportend() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getImportRecords() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for importstart
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getImportstart() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ImportTask getImporttask() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ImportTaskKey getImporttaskKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getImpsesid() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Operator getOperator() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OperatorKey getOperatorKey() throws java.rmi.RemoteException;
/**
 * Getter method for reccount
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getReccount() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetImporttaskKey(com.hps.july.persistence.ImportTaskKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetOperatorKey(com.hps.july.persistence.OperatorKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddImportRecords(com.hps.july.persistence.ImportRecord anImportRecords) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveImportRecords(com.hps.july.persistence.ImportRecord anImportRecords) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetImporttask(com.hps.july.persistence.ImportTask anImporttask) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException;
/**
 * Setter method for errcount
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setErrcount(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for filename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFilename(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for filesize
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setFilesize(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for filetime
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setFiletime(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for importend
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setImportend(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for importstart
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setImportstart(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setImporttask(com.hps.july.persistence.ImportTask anImporttask) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2operator.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setOperator(com.hps.july.persistence.Operator anOperator) throws java.rmi.RemoteException;
/**
 * Setter method for reccount
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setReccount(int newValue) throws java.rmi.RemoteException;
}
