package com.hps.july.persistence;

/**
 * Remote interface for Enterprise Bean: I13nActPosition
 */
public interface I13nActPosition extends com.hps.july.persistence.DocumentPosition, com.ibm.ivj.ejb.runtime.CopyHelper {

/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getContentsScanned() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Contract getContract() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DocumentKey getContractKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getCordocnum() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNote() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPositionState() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetContractKey(com.hps.july.persistence.DocumentKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setContentsScanned(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named I13nActPosition2Contract.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setContract(com.hps.july.persistence.Contract aContract) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setCordocnum(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNote(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPositionState(java.lang.String newValue) throws java.rmi.RemoteException;
}
