package com.hps.july.trailcom.beans;

/**
 * EJSFinderAddressSpaceBean
 */
public interface EJSFinderAddressSpaceBean {
	/**
	 * findAddressSpacesByAddressinfo
	 */
	public com.ibm.ejs.persistence.EJSFinder findAddressSpacesByAddressinfo(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByStoragecard
	 */
	public com.ibm.ejs.persistence.EJSFinder findByStoragecard(java.lang.Integer argStoragecard) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
