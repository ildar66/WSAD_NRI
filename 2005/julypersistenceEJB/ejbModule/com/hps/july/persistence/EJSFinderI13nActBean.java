package com.hps.july.persistence;

/**
 * EJSFinderI13nActBean
 */
public interface EJSFinderI13nActBean {
	/**
	 * findI13nActByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findI13nActByQBE(java.lang.Boolean isDate, java.sql.Date argDateFrom, java.sql.Date argDateTo, java.lang.Boolean isOrganization, java.lang.Integer argOrganization, java.lang.Boolean isStorage, java.lang.Integer argStorage, java.lang.Boolean isStorageType, java.lang.String storageType, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findFullByStorageAfterDate
	 */
	public com.hps.july.persistence.I13nAct findFullByStorageAfterDate(java.lang.Integer storage, java.sql.Date date, java.lang.Integer butDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findI13nActByAgregate
	 */
	public com.ibm.ejs.persistence.EJSFinder findI13nActByAgregate(com.hps.july.persistence.StorageCardKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findI13nActTechByTechStuff
	 */
	public com.ibm.ejs.persistence.EJSFinder findI13nActTechByTechStuff(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAssortimentByStorageProductAfterDate
	 */
	public com.hps.july.persistence.I13nAct findAssortimentByStorageProductAfterDate(java.lang.Integer storage, java.lang.Integer product, java.sql.Date date, java.lang.Integer butDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAgregateByStorageSerialAfterDate
	 */
	public com.hps.july.persistence.I13nAct findAgregateByStorageSerialAfterDate(java.lang.String serial, java.sql.Date date, java.lang.Integer butDocument) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
