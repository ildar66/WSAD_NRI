package com.hps.july.persistence;

/**
 * EJSFinderRoleBean
 */
public interface EJSFinderRoleBean {
	/**
	 * findAll
	 */
	public com.ibm.ejs.persistence.EJSFinder findAll() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
