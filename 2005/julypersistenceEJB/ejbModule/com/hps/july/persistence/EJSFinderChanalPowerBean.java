package com.hps.july.persistence;

/**
 * EJSFinderChanalPowerBean
 */
public interface EJSFinderChanalPowerBean {
	/**
	 * findChanalPowersByBasestation
	 */
	public com.ibm.ejs.persistence.EJSFinder findChanalPowersByBasestation(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
