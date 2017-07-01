package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectDivColValHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ProjectDivColVal
 * @param divcolid int
 * @param project int
 * @param argColvalue java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProjectDivColVal create(int divcolid, int project, java.lang.String argColvalue) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProjectDivColVal
 * @param key com.hps.july.persistence.ProjectDivColValKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProjectDivColVal findByPrimaryKey(com.hps.july.persistence.ProjectDivColValKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColVal2Project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findProjectDivColValsByProject(com.hps.july.persistence.ProjectKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectDivColumns2ProjectDivColVal.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findProjectDivColValsByProjectDivColumn(com.hps.july.persistence.ProjectDivColumnsKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
