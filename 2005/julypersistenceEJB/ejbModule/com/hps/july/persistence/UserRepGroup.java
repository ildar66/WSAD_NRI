package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface UserRepGroup extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void addUserReports(com.hps.july.persistence.UserReport anUserReports) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration getUserReports() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getUsrgrpid() throws java.rmi.RemoteException;
/**
 * Getter method for usrgrpname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getUsrgrpname() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryAddUserReports(com.hps.july.persistence.UserReport anUserReports) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public void secondaryRemoveUserReports(com.hps.july.persistence.UserReport anUserReports) throws java.rmi.RemoteException;
/**
 * Setter method for usrgrpname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setUsrgrpname(java.lang.String newValue) throws java.rmi.RemoteException;
}
