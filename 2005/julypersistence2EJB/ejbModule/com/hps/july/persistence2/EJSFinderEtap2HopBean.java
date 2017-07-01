package com.hps.july.persistence2;

/**
 * EJSFinderEtap2HopBean
 */
public interface EJSFinderEtap2HopBean {
	/**
	 * findBySitedocAndPermid
	 */
	public com.ibm.ejs.persistence.EJSFinder findBySitedocAndPermid(java.lang.Integer argSiteDoc, java.lang.Integer argPermid) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
