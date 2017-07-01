package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface ChangeLogDetailsHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.ChangeLogDetails
 * @param argLogdetid int
 * @param argLogid int
 * @param argFieldLabel java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.ChangeLogDetails create(int argLogdetid, int argLogid, java.lang.String argFieldLabel) throws javax.ejb.CreateException, java.rmi.RemoteException;
java.util.Enumeration findByChangelogOrderByCodeAsc(Integer argLog) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.ChangeLogDetails
 * @param key com.hps.july.persistence.ChangeLogDetailsKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.ChangeLogDetails findByPrimaryKey(com.hps.july.persistence.ChangeLogDetailsKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named ChangeLogDetails2log.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findChangeLogDetailsesByChangelog(com.hps.july.persistence.ChangeLogKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
