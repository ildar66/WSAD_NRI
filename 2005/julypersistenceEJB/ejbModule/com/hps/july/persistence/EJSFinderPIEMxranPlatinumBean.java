package com.hps.july.persistence;

/**
 * EJSFinderPIEMxranPlatinumBean
 */
public interface EJSFinderPIEMxranPlatinumBean {
	/**
	 * findByMxranNameOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findByMxranNameOwner(java.lang.Boolean isMxranPlatinum, java.lang.String mxranplatinum, java.lang.Boolean isName, java.lang.String name, java.lang.Integer owner, java.lang.Integer order) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findPIEMxranPlatinumsByOwner
	 */
	public com.ibm.ejs.persistence.EJSFinder findPIEMxranPlatinumsByOwner(com.hps.july.persistence.OrganizationKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
