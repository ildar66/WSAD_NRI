package com.hps.july.persistence;

/**
 * EJSFinderNamedValueBean
 */
public interface EJSFinderNamedValueBean {
	/**
	 * findAll
	 */
	public com.ibm.ejs.persistence.EJSFinder findAll() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
