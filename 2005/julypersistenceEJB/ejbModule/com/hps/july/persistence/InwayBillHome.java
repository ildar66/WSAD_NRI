package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface InwayBillHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.InwayBill
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.InwayBill create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.InwayBill
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
 * @param argCurrency java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.InwayBill create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Integer argCurrency) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.InwayBill
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
 * @param argCurrency java.lang.Integer
 * @param argRepresentativeType java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.InwayBill create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Integer argCurrency, java.lang.String argRepresentativeType) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.InwayBill
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankNumber java.lang.String
 * @param argState java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.InwayBill create(int argDocument, Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, String argState) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.InwayBill
 * @param key com.hps.july.persistence.DocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.InwayBill findByPrimaryKey(DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findByQBE(Boolean isStorage, Integer storage, java.sql.Date
startDate, java.sql.Date endDate, Boolean isCordocnum, String cordocnum, Boolean isOwner, Integer owner, Boolean
isSupplier, Integer supplier, Boolean isDActOnly, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2Currency.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findInwayBillByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2repres.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findInwayBillsByRepresentative(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2StorageManagers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findInwayBillstorManagersByDActStorManager(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named InwayBill2dActTechStuff.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findInwayBilltechstufByDActTechStuf(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
