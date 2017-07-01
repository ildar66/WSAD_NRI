package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectActionCommentsHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ProjectActionComments
 * @param argProjectaction int
 * @param argDivision int
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProjectActionComments create(int argProjectaction, int argDivision) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProjectActionComments
 * @param key com.hps.july.persistence.ProjectActionCommentsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProjectActionComments findByPrimaryKey(com.hps.july.persistence.ProjectActionCommentsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionComments2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findProjectActionCommentsByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionComments2projectaction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findProjectActionCommentsByProjectaction(com.hps.july.persistence.ProjectActionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
