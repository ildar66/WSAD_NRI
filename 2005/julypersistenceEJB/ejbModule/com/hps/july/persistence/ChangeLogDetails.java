package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ChangeLogDetails extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ChangeLog getChangelog() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.ChangeLogKey getChangelogKey() throws java.rmi.RemoteException;
/**
 * Getter method for fieldlabel
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getFieldlabel() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLogdetid() throws java.rmi.RemoteException;
/**
 * Getter method for newvalue
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getNewvalue() throws java.rmi.RemoteException;
/**
 * Getter method for oldvalue
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getOldvalue() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetChangelogKey(com.hps.july.persistence.ChangeLogKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetChangelog(com.hps.july.persistence.ChangeLog aChangelog) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setChangelog(com.hps.july.persistence.ChangeLog aChangelog) throws java.rmi.RemoteException;
/**
 * Setter method for fieldlabel
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setFieldlabel(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for newvalue
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setNewvalue(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for oldvalue
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setOldvalue(java.lang.String newValue) throws java.rmi.RemoteException;
}
