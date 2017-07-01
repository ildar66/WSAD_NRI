package com.hps.july.persistence;

/**
 * EJSFinderUnitBean
 */
public interface EJSFinderUnitBean {
	/**
	 * findAll
	 */
	public com.ibm.ejs.persistence.EJSFinder findAll() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
