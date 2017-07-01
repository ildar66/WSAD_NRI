package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ResponsibilityType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectActionTypes(com.hps.july.persistence.ProjectActionType aProjectActionTypes) throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getIsPrint() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getPositionResponsibleWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectActionTypes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getResponsibilityType() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddPositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectActionTypes(com.hps.july.persistence.ProjectActionType aProjectActionTypes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemovePositionResponsibleWorkers(com.hps.july.persistence.PositionResponsibleWorkers aPositionResponsibleWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectActionTypes(com.hps.july.persistence.ProjectActionType aProjectActionTypes) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setIsPrint(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newResponsibilityType int
 * @exception String The exception description.
 */
void setResponsibilityType(int newResponsibilityType) throws java.rmi.RemoteException;
}
