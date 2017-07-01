package com.hps.july.persistence;

/**
 * EJSFinderFaultReportBean
 */
public interface EJSFinderFaultReportBean {
	/**
	 * findFaultReports2ByStoragecardFrom
	 */
	public com.ibm.ejs.persistence.EJSFinder findFaultReports2ByStoragecardFrom(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findFaultReportByTechStuff
	 */
	public com.ibm.ejs.persistence.EJSFinder findFaultReportByTechStuff(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findFaultReportByEquipment
	 */
	public com.ibm.ejs.persistence.EJSFinder findFaultReportByEquipment(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findFaultReportByDivision
	 */
	public com.ibm.ejs.persistence.EJSFinder findFaultReportByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findFaultReports1ByOldagregate
	 */
	public com.ibm.ejs.persistence.EJSFinder findFaultReports1ByOldagregate(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentByQBE(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorageFrom, java.lang.Integer storageFrom, java.lang.Boolean isStorageTo, java.lang.Integer storageTo) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean useDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean useOwner, java.lang.Integer owner, java.lang.Boolean useDivision, java.lang.Integer division, java.lang.Boolean useWorker, java.lang.Integer worker, java.lang.Boolean usePosition, java.lang.Integer position, java.lang.Boolean useResource, java.lang.Integer resource, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
