package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PeopleHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.People
 * @param argMan int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.People create(int argMan) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.People
 * @param argMan int
 * @param argFirstName java.lang.String
 * @param argMiddleName java.lang.String
 * @param argLastName java.lang.String
 * @param argPassportSer java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.People create(int argMan, java.lang.String argFirstName, java.lang.String argMiddleName, java.lang.String argLastName, java.lang.String argPassportSer) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.People
 * @param argMan int
 * @param argFirstName java.lang.String
 * @param argMiddleName java.lang.String
 * @param argLastName java.lang.String
 * @param argPassportSer java.lang.String
 * @param argIsActive java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.People create(int argMan, java.lang.String argFirstName, java.lang.String argMiddleName, java.lang.String argLastName, java.lang.String argPassportSer, java.lang.Boolean argIsActive) throws javax.ejb.CreateException, java.rmi.RemoteException;
public java.util.Enumeration findByConnectedOrderByNameAsc( Integer argConnected ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByNameOrderByNameAsc( String name ) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByNameOrderByNameDesc( String name ) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.People
 * @param key com.hps.july.persistence.PeopleKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.People findByPrimaryKey(com.hps.july.persistence.PeopleKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByQBE(
	Boolean isLastName, String lastName, 
	Integer argConnected,
	Boolean isIsActive, Boolean isActive,
	Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findMaxKeyValue() throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findWorkerByLastNameOrderByLastNameAsc( String name ) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
