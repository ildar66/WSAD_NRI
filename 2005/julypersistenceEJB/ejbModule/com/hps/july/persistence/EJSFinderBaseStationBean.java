package com.hps.july.persistence;

/**
 * EJSFinderBaseStationBean
 */
public interface EJSFinderBaseStationBean {
	/**
	 * findBaseStationBySwitch
	 */
	public com.ibm.ejs.persistence.EJSFinder findBaseStationBySwitch(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findBaseStationByController
	 */
	public com.ibm.ejs.persistence.EJSFinder findBaseStationByController(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByBSNumber
	 */
	public com.ibm.ejs.persistence.EJSFinder findByBSNumber(java.lang.Integer argBSNumber) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
