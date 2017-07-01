package com.hps.july.persistence;

/**
 * EJSFinderPositionResponsibleWorkersBean
 */
public interface EJSFinderPositionResponsibleWorkersBean {
	/**
	 * findByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPosition(java.lang.Integer argStoragePlace) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isStorageplace, java.lang.Integer storageplace, java.lang.Boolean isType, java.lang.Integer type, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPositionResponsibleWorkerByOrganization
	 */
	public com.ibm.ejs.persistence.EJSFinder findPositionResponsibleWorkerByOrganization(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPositionResponsibleWorkersByType
	 */
	public com.ibm.ejs.persistence.EJSFinder findPositionResponsibleWorkersByType(com.hps.july.persistence.ResponsibilityTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPositionResponsibleWorkersByPosition
	 */
	public com.ibm.ejs.persistence.EJSFinder findPositionResponsibleWorkersByPosition(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPositionResptype
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPositionResptype(java.lang.Integer argStoragePlace, java.lang.String argResptype) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByCodeAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByCodeAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPositionResponsibleWorkersByWorker
	 */
	public com.ibm.ejs.persistence.EJSFinder findPositionResponsibleWorkersByWorker(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByPositionResponseType
	 */
	public com.ibm.ejs.persistence.EJSFinder findByPositionResponseType(java.lang.Integer argStoragePlace, java.lang.Integer argRespType) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
