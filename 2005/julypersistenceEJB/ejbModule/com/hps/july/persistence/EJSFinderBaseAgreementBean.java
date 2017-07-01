package com.hps.july.persistence;

/**
 * EJSFinderBaseAgreementBean
 */
public interface EJSFinderBaseAgreementBean {
	/**
	 * findAllOrderByNameDesc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameDesc() throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAllOrderByNameAsc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllOrderByNameAsc() throws javax.ejb.FinderException, java.rmi.RemoteException;
}
