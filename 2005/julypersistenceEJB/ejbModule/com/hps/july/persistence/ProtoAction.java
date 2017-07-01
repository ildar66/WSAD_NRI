package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProtoAction extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for duration
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getDuration() throws java.rmi.RemoteException;
/**
 * Getter method for order
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getOrder() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getProjectaction() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectActionType getProjectActionType() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectActionTypeKey getProjectActionTypeKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectType getProjectType() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectTypeKey getProjectTypeKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getStepbefore() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetProjectActionTypeKey(com.hps.july.persistence.ProjectActionTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetProjectTypeKey(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetProjectActionType(com.hps.july.persistence.ProjectActionType aProjectActionType) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetProjectType(com.hps.july.persistence.ProjectType aProjectType) throws java.rmi.RemoteException;
/**
 * Setter method for duration
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setDuration(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for order
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setOrder(int newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2actiontype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setProjectActionType(com.hps.july.persistence.ProjectActionType aProjectActionType) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setProjectType(com.hps.july.persistence.ProjectType aProjectType) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setStepbefore(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
