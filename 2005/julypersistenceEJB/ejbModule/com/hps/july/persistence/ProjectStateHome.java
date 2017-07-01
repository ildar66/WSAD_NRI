package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectStateHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ProjectState
 * @param argProjectstate int
 * @param argState java.lang.String
 * @param argMan int
 * @param argWhen java.sql.Timestamp
 * @param argProject int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProjectState create(int argProjectstate, java.lang.String argState, int argMan, java.sql.Timestamp argWhen, int argProject) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProjectState
 * @param key com.hps.july.persistence.ProjectStateKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProjectState findByPrimaryKey(com.hps.july.persistence.ProjectStateKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
com.hps.july.persistence.ProjectState findCurrentForProject(Integer argProject) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectState2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectStatesByMan(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectState2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectStatesByProject(com.hps.july.persistence.ProjectKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
