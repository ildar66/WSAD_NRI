package com.hps.july.persistence;

/**
 * EJSFinderInwayBillBean
 */
public interface EJSFinderInwayBillBean {
	/**
	 * findInwayBilltechstufByDActTechStuf
	 */
	public com.ibm.ejs.persistence.EJSFinder findInwayBilltechstufByDActTechStuf(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInwayBillByCurrency
	 */
	public com.ibm.ejs.persistence.EJSFinder findInwayBillByCurrency(com.hps.july.persistence.CurrencyKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInwayBillstorManagersByDActStorManager
	 */
	public com.ibm.ejs.persistence.EJSFinder findInwayBillstorManagersByDActStorManager(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findInwayBillsByRepresentative
	 */
	public com.ibm.ejs.persistence.EJSFinder findInwayBillsByRepresentative(com.hps.july.persistence.WorkerKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByQBE
	 */
	public com.ibm.ejs.persistence.EJSFinder findByQBE(java.lang.Boolean isStorage, java.lang.Integer storage, java.sql.Date startDate, java.sql.Date endDate, java.lang.Boolean isCordocnum, java.lang.String cordocnum, java.lang.Boolean isOwner, java.lang.Integer owner, java.lang.Boolean isSupplier, java.lang.Integer supplier, java.lang.Boolean isDActOnly, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
