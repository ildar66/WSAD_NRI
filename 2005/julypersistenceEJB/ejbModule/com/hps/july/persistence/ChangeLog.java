package com.hps.july.persistence;

/**
 * This is an Enterprise Java Bean Remote Interface
 */
public interface ChangeLog extends com.ibm.ivj.ejb.runtime.CopyHelper, javax.ejb.EJBObject {
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void addChangeLogDetailses(com.hps.july.persistence.ChangeLogDetails aChangeLogDetailses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration getChangeLogDetailses() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * Getter method for eventtype
 * @return java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
java.lang.String getEventtype() throws java.rmi.RemoteException;
/**
 * 
 * @return int
 * @exception String The exception description.
 */
int getLogid() throws java.rmi.RemoteException;
/**
 * Getter method for objid
 * @return int
 * @exception java.rmi.RemoteException The exception description.
 */
int getObjid() throws java.rmi.RemoteException;
/**
 * Getter method for objtype
 * @return short
 * @exception java.rmi.RemoteException The exception description.
 */
short getObjtype() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.People getPeople() throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
com.hps.july.persistence.PeopleKey getPeopleKey() throws java.rmi.RemoteException;
/**
 * Getter method for recdate
 * @return java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
java.sql.Timestamp getRecdate() throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void privateSetPeopleKey(com.hps.july.persistence.PeopleKey inKey) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryAddChangeLogDetailses(com.hps.july.persistence.ChangeLogDetails aChangeLogDetailses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondaryRemoveChangeLogDetailses(com.hps.july.persistence.ChangeLogDetails aChangeLogDetailses) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void secondarySetPeople(com.hps.july.persistence.People aPeople) throws java.rmi.RemoteException;
/**
 * Setter method for eventtype
 * @param newValue java.lang.String
 * @exception java.rmi.RemoteException The exception description.
 */
void setEventtype(java.lang.String newValue) throws java.rmi.RemoteException;
/**
 * Setter method for objid
 * @param newValue int
 * @exception java.rmi.RemoteException The exception description.
 */
void setObjid(int newValue) throws java.rmi.RemoteException;
/**
 * Setter method for objtype
 * @param newValue short
 * @exception java.rmi.RemoteException The exception description.
 */
void setObjtype(short newValue) throws java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named ChangeLog2people.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
void setPeople(com.hps.july.persistence.People aPeople) throws java.rmi.RemoteException;
/**
 * Setter method for recdate
 * @param newValue java.sql.Timestamp
 * @exception java.rmi.RemoteException The exception description.
 */
void setRecdate(java.sql.Timestamp newValue) throws java.rmi.RemoteException;
}
