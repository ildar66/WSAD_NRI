package com.hps.july.persistence;

/**
 * EJSFinderPIEOtvUserLinkBean
 */
public interface EJSFinderPIEOtvUserLinkBean {
	/**
	 * findPIEOtvUserLinksByOtvuserplatinum
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEOtvUserLinksByOtvuserplatinum(com.hps.july.persistence.PIEOtvUserPlatinumKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
