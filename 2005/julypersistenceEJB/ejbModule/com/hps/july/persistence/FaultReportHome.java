package com.hps.july.persistence;

/**
 * This is a Home interface for the Enterprise JavaBean
 */
public interface FaultReportHome extends javax.ejb.EJBHome {

/**
 * 
 * @return com.hps.july.persistence.FaultReport
 * @param argDocument int
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.FaultReport create(int argDocument) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.FaultReport
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
 * @param argDivision java.lang.Integer
 * @param argTechStuff java.lang.Integer
 * @param argEqPlace java.lang.String
 * @param argOldSerial java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.FaultReport create(int argDocument, java.lang.Integer argOwner, java.lang.Integer argFrom, java.lang.Integer argTo, java.sql.Date argBlankDate, int argBlankindex, java.lang.String argBlankNumber, java.lang.String argState, java.lang.Boolean argProcessSource, java.lang.Boolean argProcessDestination, java.lang.Integer argDivision, java.lang.Integer argTechStuff, java.lang.String argEqPlace, java.lang.String argOldSerial) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.FaultReport
 * @param argDocument int
 * @param argOwner java.lang.Integer
 * @param argBlankDate java.sql.Date
 * @param argBlankNumber java.lang.String
 * @param argState java.lang.String
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.FaultReport create(int argDocument, Integer argOwner, java.sql.Date argBlankDate, int argBlankindex, String argState) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.FaultReport
 * @param key com.hps.july.persistence.DocumentKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.FaultReport findByPrimaryKey(DocumentKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param isDate java.lang.Boolean
 * @param datefrom java.sql.Date
 * @param dateto java.sql.Date
 * @param isOrganization java.lang.Boolean
 * @param organization java.lang.Integer
 * @param isStorageFrom java.lang.Boolean
 * @param storageFrom java.lang.Integer
 * @param isStorageTo java.lang.Boolean
 * @param storageTo java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findByQBE(Boolean useDate, java.sql.Date datefrom, java.sql.Date dateto, // поиск по
  Boolean useOwner, Integer owner, // поиск по owner
  Boolean useDivision, Integer division, // поиск по division
  Boolean useWorker, Integer worker,
  Boolean usePosition, Integer position,
  Boolean useResource, Integer resource,
  Integer order // сортировка по blankdate, blanknumber
) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * 
 * @return java.util.Enumeration
 * @param isDate java.lang.Boolean
 * @param datefrom java.sql.Date
 * @param dateto java.sql.Date
 * @param isOrganization java.lang.Boolean
 * @param organization java.lang.Integer
 * @param isStorageFrom java.lang.Boolean
 * @param storageFrom java.lang.Integer
 * @param isStorageTo java.lang.Boolean
 * @param storageTo java.lang.Integer
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
java.util.Enumeration findDocumentByQBE(Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, Boolean isOrganization, Integer organization, Boolean isStorageFrom, Integer storageFrom, Boolean isStorageTo, Integer storageTo) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named FaultReport2Division.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findFaultReportByDivision(com.hps.july.persistence.DivisionKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named FaultReport2Equipment.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findFaultReportByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named FaultReport2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findFaultReportByTechStuff(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named FaultReport2scard1.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findFaultReports1ByOldagregate(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named FaultReport2scard2.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findFaultReports2ByStoragecardFrom(com.hps.july.persistence.StorageCardKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
