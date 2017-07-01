package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProjectState extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.People getMan() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PeopleKey getManKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Project getProject() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectKey getProjectKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getProjectstate() throws java.rmi.RemoteException;
/**
 * Getter method for state
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getState() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Timestamp
 * @exception String The exception description.
 */
java.sql.Timestamp getWhen() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetManKey(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetProjectKey(com.hps.july.persistence.ProjectKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetProject(com.hps.july.persistence.Project aProject) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setMan(com.hps.july.persistence.People aMan) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setProject(com.hps.july.persistence.Project aProject) throws java.rmi.RemoteException;
/**
 * Setter method for state
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setState(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Timestamp
 * @exception String The exception description.
 */
void setWhen(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
}
