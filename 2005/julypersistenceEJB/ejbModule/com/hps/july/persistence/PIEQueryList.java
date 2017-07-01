package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface PIEQueryList extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * Getter method for idobjnriint
 * @return java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.Integer getIdobjnriint() throws java.rmi.RemoteException;
/**
 * Getter method for idobjnristr
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getIdobjnristr() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getIdquerylist() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQuery getQuery() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PIEQueryKey getQueryKey() throws java.rmi.RemoteException;
/**
 * Getter method for typeobjnri
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getTypeobjnri() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetQueryKey(com.hps.july.persistence.PIEQueryKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException;
/**
 * Setter method for idobjnriint
 * @param newValue java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdobjnriint(java.lang.Integer newValue) throws java.rmi.RemoteException;
/**
 * Setter method for idobjnristr
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setIdobjnristr(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PIEQueryList2query.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setQuery(com.hps.july.persistence.PIEQuery aQuery) throws java.rmi.RemoteException;
/**
 * Setter method for typeobjnri
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setTypeobjnri(java.lang.String newValue) throws java.rmi.RemoteException;
}
