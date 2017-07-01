package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface UserReport extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for classname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getClassname() throws java.rmi.RemoteException;
/**
 * Getter method for jspclass
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getJspclass() throws java.rmi.RemoteException;
/**
 * Getter method for jspname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getJspname() throws java.rmi.RemoteException;
/**
 * Getter method for repname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRepname() throws java.rmi.RemoteException;
/**
 * Getter method for rptname
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRptname() throws java.rmi.RemoteException;
/**
 * Getter method for rptparams
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getRptparams() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.UserRepGroup getUserRepGroup() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.UserRepGroupKey getUserRepGroupKey() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getUserrepid() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetUserRepGroupKey(com.hps.july.persistence.UserRepGroupKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetUserRepGroup(com.hps.july.persistence.UserRepGroup anUserRepGroup) throws java.rmi.RemoteException;
/**
 * Setter method for classname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setClassname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for jspclass
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setJspclass(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for jspname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setJspname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for repname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRepname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for rptname
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRptname(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for rptparams
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setRptparams(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named UserReport2UserRepGroup.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setUserRepGroup(com.hps.july.persistence.UserRepGroup anUserRepGroup) throws java.rmi.RemoteException;
}
