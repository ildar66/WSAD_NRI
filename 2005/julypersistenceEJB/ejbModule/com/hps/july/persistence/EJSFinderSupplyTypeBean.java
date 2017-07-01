package com.hps.july.persistence;

/**
 * EJSFinderSupplyTypeBean
 */
public interface EJSFinderSupplyTypeBean {
	/**
	 * findAllOrderByNameDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameDesc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
