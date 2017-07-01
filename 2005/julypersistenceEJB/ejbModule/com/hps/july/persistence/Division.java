package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface Division extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addChilds(com.hps.july.persistence.Division aChilds) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectActionTypes(com.hps.july.persistence.ProjectActionType aProjectActionTypes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addProjectDivColumns(com.hps.july.persistence.ProjectDivColumns aProjectDivColumns) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addStoragePlace(com.hps.july.persistence.StoragePlace aStoragePlace) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Worker getBoss() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.WorkerKey getBossKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getCars() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getChilds() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Company getCompany() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.CompanyKey getCompanyKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDivision() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getFaultReport() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Boolean
 * @exception String The exception description.
 */
java.lang.Boolean getIsactive() throws java.rmi.RemoteException;
/**
 * Getter method for name
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getName() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Division getParent() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DivisionKey getParentKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionComments2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getProjectActionComments() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectActionTypes() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getProjectDivColumns() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getRequest() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for shortname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getShortname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getStoragePlace() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getWorkers() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetBossKey(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetCompanyKey(com.hps.july.persistence.CompanyKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetParentKey(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void removeCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void removeChilds(com.hps.july.persistence.Division aChilds) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddChilds(com.hps.july.persistence.Division aChilds) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionComments2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddProjectActionComments(com.hps.july.persistence.ProjectActionComments aProjectActionComments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectActionTypes(com.hps.july.persistence.ProjectActionType aProjectActionTypes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddProjectDivColumns(com.hps.july.persistence.ProjectDivColumns aProjectDivColumns) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddStoragePlace(com.hps.july.persistence.StoragePlace aStoragePlace) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Car2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveCars(com.hps.july.persistence.Car aCars) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveChilds(com.hps.july.persistence.Division aChilds) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveFaultReport(com.hps.july.persistence.FaultReport aFaultReport) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionComments2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveProjectActionComments(com.hps.july.persistence.ProjectActionComments aProjectActionComments) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionType2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectActionTypes(com.hps.july.persistence.ProjectActionType aProjectActionTypes) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveProjectDivColumns(com.hps.july.persistence.ProjectDivColumns aProjectDivColumns) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named Request2DivisionRequester.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveRequest(com.hps.july.persistence.Request aRequest) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named StoragePlace2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveStoragePlace(com.hps.july.persistence.StoragePlace aStoragePlace) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named workers2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveWorkers(com.hps.july.persistence.Worker aWorkers) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetBoss(com.hps.july.persistence.Worker aBoss) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetCompany(com.hps.july.persistence.Company aCompany) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetParent(com.hps.july.persistence.Division aParent) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named divisions2worker.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setBoss(com.hps.july.persistence.Worker aBoss) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2company.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setCompany(com.hps.july.persistence.Company aCompany) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newDivision int
 * @exception String The exception description.
 */
void setDivision(int newDivision) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.Boolean
 * @exception String The exception description.
 */
void setIsactive(java.lang.Boolean newValue) throws java.rmi.RemoteException;
/**
 * Setter method for name
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setName(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named division2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setParent(com.hps.july.persistence.Division aParent) throws java.rmi.RemoteException;
/**
 * Setter method for shortname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setShortname(java.lang.String newValue) throws java.rmi.RemoteException;
}
