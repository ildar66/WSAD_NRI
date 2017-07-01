package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ImportTask extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addImportSessions(com.hps.july.persistence.ImportSession anImportSessions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getImportSessions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getImptaskid() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return byte []
 * @exception String The exception description.
 */
byte [] getXmlfile() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddImportSessions(com.hps.july.persistence.ImportSession anImportSessions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportSession2task.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveImportSessions(com.hps.july.persistence.ImportSession anImportSessions) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue byte []
 * @exception String The exception description.
 */
void setXmlfile(byte [] newValue) throws java.rmi.RemoteException;
}
