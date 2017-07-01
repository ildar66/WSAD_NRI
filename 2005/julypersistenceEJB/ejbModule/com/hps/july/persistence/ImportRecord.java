package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ImportRecord extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for errlabel
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getErrlabel() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getIaction() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ImportSession getImportsession() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ImportSessionKey getImportsessionKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getImprecid() throws java.rmi.RemoteException;
/**
 * Getter method for keyfields
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getKeyfields() throws java.rmi.RemoteException;
/**
 * Getter method for param1
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getParam1() throws java.rmi.RemoteException;
/**
 * Getter method for param2
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getParam2() throws java.rmi.RemoteException;
/**
 * Getter method for param3
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getParam3() throws java.rmi.RemoteException;
/**
 * Getter method for recendtime
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getRecendtime() throws java.rmi.RemoteException;
/**
 * Getter method for result
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getResult() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetImportsessionKey(com.hps.july.persistence.ImportSessionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetImportsession(com.hps.july.persistence.ImportSession anImportsession) throws java.rmi.RemoteException;
/**
 * Setter method for errlabel
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setErrlabel(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setIaction(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ImportRecord2session.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setImportsession(com.hps.july.persistence.ImportSession anImportsession) throws java.rmi.RemoteException;
/**
 * Setter method for keyfields
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setKeyfields(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for param1
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setParam1(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for param2
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setParam2(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for param3
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setParam3(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for recendtime
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setRecendtime(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
/**
 * Setter method for result
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setResult(java.lang.String newValue) throws java.rmi.RemoteException;
}
