package com.hps.july.persistence;

/**
 * This is a Home interface for the Entity Bean
 */
public interface PositionResponsibleWorkersHome extends javax.ejb.EJBHome {

/**
 * create method for a CMP entity bean
 * @return com.hps.july.persistence.PositionResponsibleWorkers
 * @exception javax.ejb.CreateException The exception description.
 * @exception java.rmi.RemoteException The exception description.
 */
com.hps.july.persistence.PositionResponsibleWorkers create() throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PositionResponsibleWorkers
 * @param argType java.lang.Integer
 * @param argWorker java.lang.Integer
 * @param argPosition java.lang.Integer
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PositionResponsibleWorkers create(java.lang.Integer argType, java.lang.Integer argWorker, java.lang.Integer argPosition) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * 
 * @return com.hps.july.persistence.PositionResponsibleWorkers
 * @param argType java.lang.Integer
 * @param argPosition java.lang.Integer
 * @param argResptype java.lang.String
 * @exception String The exception description.
 * @exception String The exception description.
 */
com.hps.july.persistence.PositionResponsibleWorkers create(java.lang.Integer argType, java.lang.Integer argPosition, java.lang.String argResptype) throws javax.ejb.CreateException, java.rmi.RemoteException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findAllOrderByCodeAsc() throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByPosition(Integer argStoragePlace) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByPositionResponseType(Integer argStoragePlace, Integer argRespType) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByPositionResptype(Integer argStoragePlace, String argResptype) throws java.rmi.RemoteException, javax.ejb.FinderException;

/**
 * findByPrimaryKey method comment
 * @return com.hps.july.persistence.PositionResponsibleWorkers
 * @param key com.hps.july.persistence.PositionResponsibleWorkersKey
 * @exception java.rmi.RemoteException The exception description.
 * @exception javax.ejb.FinderException The exception description.
 */
com.hps.july.persistence.PositionResponsibleWorkers findByPrimaryKey(com.hps.july.persistence.PositionResponsibleWorkersKey key) throws java.rmi.RemoteException, javax.ejb.FinderException;
public java.util.Enumeration findByQBE(Boolean isStorageplace, Integer storageplace, Boolean isType, Integer type, Integer order) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Organization.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
java.util.Enumeration findPositionResponsibleWorkerByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Position.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findPositionResponsibleWorkersByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Types.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findPositionResponsibleWorkersByType(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
/**
 * This method was generated for supporting the association named PositionResponsibleWorkers2Workers.  
 * 	It will be deleted/edited when the association is deleted/edited.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public java.util.Enumeration findPositionResponsibleWorkersByWorker(com.hps.july.persistence.WorkerKey inKey) throws java.rmi.RemoteException, javax.ejb.FinderException;
}
