package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface InternalOutBillHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.InternalOutBill
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.InternalOutBill create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.InternalOutBill
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
 * @param argFixing java.lang.Boolean
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.InternalOutBill create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Boolean argFixing) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.InternalOutBill
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankNumber java.lang.String
 * @param argState java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.InternalOutBill create(int argDocument, Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, String argState) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.InternalOutBill
 * @param key com.hps.july.persistence.DocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.InternalOutBill findByPrimaryKey(DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE2(Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto,
	Boolean isOwner, Integer owner,
	Boolean isPosition, Integer position,
	Boolean isProvider, Integer provider,
	Boolean isWorker, Integer worker,
	Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalOutBill2Monter.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findInternalOutBillByMonter(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findInternalOutBillByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InternalOutBill2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findInternalOutBillByQBE(Boolean isDate, java.sql.Date dateFrom, java.sql.Date dateTo,
    Boolean isOwner, Integer owner,
    Boolean isStorage, Integer storage,
    Boolean isContragent, Integer contragent,
    Boolean isWorker, Integer worker,
    Integer order
) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
