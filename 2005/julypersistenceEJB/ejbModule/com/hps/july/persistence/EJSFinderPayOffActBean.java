package com.hps.july.persistence;

/**
 * EJSFinderPayOffActBean
 */
public interface EJSFinderPayOffActBean {
	/**
	 * findPayOffActMemberByMember1
	 */
	public com.ibm.ejs.persistence.EJSFinder findPayOffActMemberByMember1(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPayOffActChairManByChairMan
	 */
	public com.ibm.ejs.persistence.EJSFinder findPayOffActChairManByChairMan(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findDocumentByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findDocumentByQBE(java.lang.Boolean isDate, java.sql.Date datefrom, java.sql.Date dateto, java.lang.Boolean isOrganization, java.lang.Integer organization, java.lang.Boolean isStorageFrom, java.lang.Integer storageFrom, java.lang.Boolean isStorageTo, java.lang.Integer storageTo) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPayOffActMember2ByMember2
	 */
	public com.ibm.ejs.persistence.EJSFinder findPayOffActMember2ByMember2(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
