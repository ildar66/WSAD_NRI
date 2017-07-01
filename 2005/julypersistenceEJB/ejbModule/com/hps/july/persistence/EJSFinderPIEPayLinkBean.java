package com.hps.july.persistence;

/**
 * EJSFinderPIEPayLinkBean
 */
public interface EJSFinderPIEPayLinkBean {
	/**
	 * findPIEPayLinksByPiepayplatinum
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEPayLinksByPiepayplatinum(com.hps.july.persistence.PIEPayPlatinumKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
