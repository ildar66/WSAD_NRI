package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProjectDivColVal extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getColvalue() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColVal2Project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Project getProject() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getProject_project() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectDivColVal.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectDivColumns getProjectDivColumn() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.lang.Integer
 * @exception String The exception description.
 */
java.lang.Integer getProjectDivColumn_divcolid() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectDivColVal.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectDivColumnsKey getProjectDivColumnKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectDivColVal2Project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectKey getProjectKey() throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setColvalue(java.lang.String newValue) throws java.rmi.RemoteException;
}
