package com.hps.july.persistence;

/**
 * EJSFinderPIEMxranLinkBean
 */
public interface EJSFinderPIEMxranLinkBean {
	/**
	 * findPIEMxranLinksByMxranplatinum
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEMxranLinksByMxranplatinum(com.hps.july.persistence.PIEMxranPlatinumKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByMxrannriOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findByMxrannriOwner(java.lang.Integer mxrannri, java.lang.Integer owner) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
