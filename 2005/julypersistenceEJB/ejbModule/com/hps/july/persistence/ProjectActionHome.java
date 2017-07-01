package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectActionHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ProjectAction
 * @param argProjectaction int
 * @param argProject int
 * @param argProjectactiontype int
 * @param argOrder int
 * @param argHasproblems boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProjectAction create(int argProjectaction, int argProject, int argProjectactiontype, int argOrder, boolean argHasproblems) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProjectAction
 * @param key com.hps.july.persistence.ProjectActionKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProjectAction findByPrimaryKey(com.hps.july.persistence.ProjectActionKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByProjectAndOrder(Integer Project, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByProjectAndProjectActionType(Integer project, Integer projectActionType) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByProjectOrderByOrderAsc(Integer project) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectAction2equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectActionsByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectAction2project.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectActionsByProject(com.hps.july.persistence.ProjectKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectAction2type.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectActionsByProjectactiontype(com.hps.july.persistence.ProjectActionTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
