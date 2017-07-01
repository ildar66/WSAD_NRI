package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProjectActionComments extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for comment
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getComment() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionComments2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.Division getDivision() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionComments2division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.DivisionKey getDivisionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionComments2projectaction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectAction getProjectaction() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ProjectActionComments2projectaction.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public com.hps.july.persistence.ProjectActionKey getProjectactionKey() throws java.rmi.RemoteException;
/**
 * Setter method for comment
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setComment(java.lang.String newValue) throws java.rmi.RemoteException;
}
