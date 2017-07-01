package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ProjectActionDocument extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * 
 * @return byte []
 * @exception String The exception description.
 */
byte [] getDocbody() throws java.rmi.RemoteException;
/**
 * 
 * @return java.sql.Date
 * @exception String The exception description.
 */
java.sql.Date getDocdate() throws java.rmi.RemoteException;
/**
 * Getter method for docname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getDocname() throws java.rmi.RemoteException;
/**
 * 
 * @return java.lang.String
 * @exception String The exception description.
 */
java.lang.String getNotes() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectAction getProjectaction() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getProjectactiondocument() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ProjectActionKey getProjectactionKey() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetProjectactionKey(com.hps.july.persistence.ProjectActionKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetProjectaction(com.hps.july.persistence.ProjectAction aProjectaction) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue byte []
 * @exception String The exception description.
 */
void setDocbody(byte [] newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.sql.Date
 * @exception String The exception description.
 */
void setDocdate(java.sql.Date newValue) throws java.rmi.RemoteException;
/**
 * Setter method for docname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setDocname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * 
 * @return void
 * @param newValue java.lang.String
 * @exception String The exception description.
 */
void setNotes(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ProjectActionDocument2action.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setProjectaction(com.hps.july.persistence.ProjectAction aProjectaction) throws java.rmi.RemoteException;
}
