package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProjectActionType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProtoActions(com.hps.july.persistence.ProtoAction aProtoActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Division getAction2division() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DivisionKey getAction2divisionKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getEquiptype() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectActions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getProjectactiontype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProtoActions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResponsibilityType getResponsibilitytype() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ResponsibilityTypeKey getResponsibilitytypeKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getResult() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetAction2divisionKey(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetResponsibilitytypeKey(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProtoActions(com.hps.july.persistence.ProtoAction aProtoActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProtoActions(com.hps.july.persistence.ProtoAction aProtoActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetAction2division(com.hps.july.persistence.Division anAction2division) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetResponsibilitytype(com.hps.july.persistence.ResponsibilityType aResponsibilitytype) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setAction2division(com.hps.july.persistence.Division anAction2division) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setEquiptype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2responsible.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setResponsibilitytype(com.hps.july.persistence.ResponsibilityType aResponsibilitytype) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setResult(java.lang.String newValue) throws java.rmi.RemoteException;
}
