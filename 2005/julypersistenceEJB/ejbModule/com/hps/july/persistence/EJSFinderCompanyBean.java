package com.hps.july.persistence;

/**
 * EJSFinderCompanyBean
 */
public interface EJSFinderCompanyBean {
	/**
	 * findOrderByNameDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrderByNameDesc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
