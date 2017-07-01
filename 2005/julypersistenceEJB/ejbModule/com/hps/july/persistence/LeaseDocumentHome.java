package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface LeaseDocumentHome extends javax.ejb.EJBHome {

	/**
	 * Creates an instance from a key for Entity Bean: LeaseDocument
	 */
	public com.hps.july.persistence.LeaseDocument create(int leaseDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.LeaseDocument
 * @param argLeaseDocument int
 * @param argDocDate java.sql.Date
 * @param argDocNumber java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.LeaseDocument create(int argLeaseDocument, java.sql.Date argDocDate, java.lang.String argDocNumber) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.LeaseDocument
 * @param key com.hps.july.persistence.LeaseDocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.LeaseDocument findByPrimaryKey(com.hps.july.persistence.LeaseDocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named LeaseContract2OrgExecutor.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(
	java.lang.Boolean isDocDate, 			java.sql.Date docDate, 
	java.lang.Boolean isBlank, 				String blank, 
	java.lang.Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
