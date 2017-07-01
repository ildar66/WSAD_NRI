package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProjectDivColumns extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for aftercol
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getAftercol() throws java.rmi.RemoteException;
/**
 * Getter method for colname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getColname() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getDivcolid() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.Division getDivision() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.DivisionKey getDivisionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectDivColVal.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getProjectDivColVals() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectType getProjectType() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectTypeKey getProjectTypeKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetDivisionKey(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void privateSetProjectTypeKey(com.hps.july.persistence.ProjectTypeKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectDivColVal.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddProjectDivColVals(com.hps.july.persistence.ProjectDivColVal aProjectDivColVals) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectDivColVal.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveProjectDivColVals(com.hps.july.persistence.ProjectDivColVal aProjectDivColVals) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondarySetProjectType(com.hps.july.persistence.ProjectType aProjectType) throws java.rmi.RemoteException;
/**
 * Setter method for aftercol
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setAftercol(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for colname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setColname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setDivision(com.hps.july.persistence.Division aDivision) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectType.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void setProjectType(com.hps.july.persistence.ProjectType aProjectType) throws java.rmi.RemoteException;
}
