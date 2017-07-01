package com.hps.july.trailcom.beans;

/**
 * EJSFinderAddressInfoBean
 */
public interface EJSFinderAddressInfoBean {
	/**
	 * findByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResource(java.lang.Integer argResource) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
