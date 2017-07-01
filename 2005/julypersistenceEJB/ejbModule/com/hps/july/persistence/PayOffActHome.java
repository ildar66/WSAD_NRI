package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface PayOffActHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.PayOffAct
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.PayOffAct create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PayOffAct
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argFrom java.lang.Integer
 * @param argTo java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankindex int
 * @param argBlankNumber java.lang.String
 * @param argState java.lang.String
 * @param argProcessSource java.lang.Boolean
 * @param argProcessDestination java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PayOffAct create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PayOffAct
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankNumber java.lang.String
 * @param argState java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.PayOffAct create(int argDocument, Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, String argState) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PayOffAct
 * @param key com.hps.july.persistence.DocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PayOffAct findByPrimaryKey(DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named Document2Owner.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findDocumentByQBE(Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto,
    Boolean isOrganization, Integer organization,
    Boolean isStorageFrom, Integer storageFrom,
    Boolean isStorageTo, Integer storageTo
) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PayOffAct2Chairman.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPayOffActChairManByChairMan(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PayOffAct2Member2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPayOffActMember2ByMember2(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PayOffAct2WorkerMember.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPayOffActMemberByMember1(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
