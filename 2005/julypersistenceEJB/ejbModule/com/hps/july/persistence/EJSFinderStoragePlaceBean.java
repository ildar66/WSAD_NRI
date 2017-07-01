package com.hps.july.persistence;

/**
 * EJSFinderStoragePlaceBean
 */
public interface EJSFinderStoragePlaceBean {
	/**
	 * findStoragePlaceByDivision
	 */
	public com.ibm.ejs.persistence.EJSFinder findStoragePlaceByDivision(com.hps.july.persistence.DivisionKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
