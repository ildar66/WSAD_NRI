package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Project extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectStates(com.hps.july.persistence.ProjectState aProjectStates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Organization getContructer() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OrganizationKey getContructerKey() throws java.rmi.RemoteException;
/**
 * Getter method for datestart
 * @return java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Date getDatestart() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Short
 * @exception String The exception description.
 */
java.lang.Short getMonthfinish() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNotes() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Position getPosition() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.StoragePlaceKey getPositionKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getProject() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectActions() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColVal2Project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getProjectDivColVals() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectStates() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectType getProjecttype() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectTypeKey getProjecttypeKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Organization getVccontructer() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.OrganizationKey getVccontructerKey() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getVctext() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getYearfinish() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetContructerKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPositionKey(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetProjecttypeKey(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetVccontructerKey(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColVal2Project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddProjectDivColVals(com.hps.july.persistence.ProjectDivColVal aProjectDivColVals) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectStates(com.hps.july.persistence.ProjectState aProjectStates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectActions(com.hps.july.persistence.ProjectAction aProjectActions) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColVal2Project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveProjectDivColVals(com.hps.july.persistence.ProjectDivColVal aProjectDivColVals) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectStates(com.hps.july.persistence.ProjectState aProjectStates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetContructer(com.hps.july.persistence.Organization aContructer) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetProjecttype(com.hps.july.persistence.ProjectType aProjecttype) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetVccontructer(com.hps.july.persistence.Organization aVccontructer) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setContructer(com.hps.july.persistence.Organization aContructer) throws java.rmi.RemoteException;
/**
 * Setter method for datestart
 * @param newValue java.sql.Date
 * @exception java.rmi.RemoteException The exception description.
 */
void setDatestart(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Short
 * @exception String The exception description.
 */
void setMonthfinish(java.lang.Short newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNotes(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPosition(com.hps.july.persistence.Position aPosition) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setProjecttype(com.hps.july.persistence.ProjectType aProjecttype) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Project2vccontructer.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setVccontructer(com.hps.july.persistence.Organization aVccontructer) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setVctext(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Integer
 * @exception String The exception description.
 */
void setYearfinish(java.lang.Integer newValue) throws java.rmi.RemoteException;
}
