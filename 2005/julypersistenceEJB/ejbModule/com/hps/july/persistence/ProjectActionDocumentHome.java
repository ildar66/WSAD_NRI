package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ProjectActionDocumentHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ProjectActionDocument
 * @param argProjectactiondocument int
 * @param argProjectAction int
 * @param argDate java.sql.Date
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ProjectActionDocument create(int argProjectactiondocument, int argProjectAction, java.sql.Date argDate) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ProjectActionDocument
 * @param key com.hps.july.persistence.ProjectActionDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ProjectActionDocument findByPrimaryKey(com.hps.july.persistence.ProjectActionDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
java.util.Enumeration findByQBE(Integer argProject, Boolean isProjectAction, Integer argProjectaction,
	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findProjectActionDocumentsByProjectaction(com.hps.july.persistence.ProjectActionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
