package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface People extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addChangeLogs(com.hps.july.persistence.ChangeLog aChangeLogs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addOperators(com.hps.july.persistence.Operator anOperators) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectStates(com.hps.july.persistence.ProjectState aProjectStates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getChangeLogs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for firstname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFirstname() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getFullName() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getIsActive() throws java.rmi.RemoteException;
/**
 * Getter method for lastname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getLastname() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getMan() throws java.rmi.RemoteException;
/**
 * Getter method for middlename
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getMiddlename() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getOperators() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getPassportDate() throws java.rmi.RemoteException;
/**
 * Getter method for passportser
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getPassportser() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getPassportWhom() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectStates() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getSiteDocs() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddChangeLogs(com.hps.july.persistence.ChangeLog aChangeLogs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddOperators(com.hps.july.persistence.Operator anOperators) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectStates(com.hps.july.persistence.ProjectState aProjectStates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveChangeLogs(com.hps.july.persistence.ChangeLog aChangeLogs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named operators2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveOperators(com.hps.july.persistence.Operator anOperators) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectStates(com.hps.july.persistence.ProjectState aProjectStates) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named SiteDoc2People.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveSiteDocs(com.hps.july.persistence.SiteDoc aSiteDocs) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * Setter method for firstname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFirstname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setIsActive(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for lastname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setLastname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newMan int
 * @exception String The exception description.
 */
void setMan(int newMan) throws java.rmi.RemoteException;
/**
 * Setter method for middlename
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setMiddlename(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setPassportDate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for passportser
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setPassportser(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setPassportWhom(java.lang.String newValue) throws java.rmi.RemoteException;
}
