package com.hps.july.persistence;

/**
 * EJSFinderPIEResLinkBean
 */
public interface EJSFinderPIEResLinkBean {
	/**
	 * findByIdresnriAndOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findByIdresnriAndOwner(java.lang.Integer argIdresNri, java.lang.Integer argOwner) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPIEResLinksByResplatinum
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEResLinksByResplatinum(com.hps.july.persistence.PIEResPlatinumKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
