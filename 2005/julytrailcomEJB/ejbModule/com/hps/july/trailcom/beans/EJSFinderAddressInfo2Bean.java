package com.hps.july.trailcom.beans;

/**
 * EJSFinderAddressInfo2Bean
 */
public interface EJSFinderAddressInfo2Bean {
	/**
	 * findByResourceTypeport
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResourceTypeport(java.lang.Integer argResource, java.lang.Short argTypeport) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAddressInfo2sByAddressinfo
	 */
	public com.ibm.ejs.persistence.EJSFinder findAddressInfo2sByAddressinfo(com.hps.july.trailcom.beans.AddressInfoKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
