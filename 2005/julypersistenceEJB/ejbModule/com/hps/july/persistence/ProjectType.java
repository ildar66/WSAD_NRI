package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProjectType extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addProjectDivColumns(com.hps.july.persistence.ProjectDivColumns aProjectDivColumns) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProtoActions(com.hps.july.persistence.ProtoAction aProtoActions) throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getProjectDivColumns() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjects() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getProjecttype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProtoActions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddProjectDivColumns(com.hps.july.persistence.ProjectDivColumns aProjectDivColumns) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProtoActions(com.hps.july.persistence.ProtoAction aProtoActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveProjectDivColumns(com.hps.july.persistence.ProjectDivColumns aProjectDivColumns) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjects(com.hps.july.persistence.Project aProjects) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProtoAction2projecttype.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProtoActions(com.hps.july.persistence.ProtoAction aProtoActions) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
}
