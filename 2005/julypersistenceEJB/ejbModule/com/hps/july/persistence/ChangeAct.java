package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ChangeAct extends com.hps.july.persistence.Document, com.ibm.ivj.ejb.runtime.CopyHelper {
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addChangeActPosition(com.hps.july.persistence.ChangeActPosition aChangeActPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getActtype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getChangeActPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddChangeActPosition(com.hps.july.persistence.ChangeActPosition aChangeActPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeActPosition2ChangeAct.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveChangeActPosition(com.hps.july.persistence.ChangeActPosition aChangeActPosition) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setActtype(java.lang.String newValue) throws java.rmi.RemoteException;
}
