package com.hps.july.persistence;

/**
 * EJSFinderCableResourceBandBean
 */
public interface EJSFinderCableResourceBandBean {
	/**
	 * findCableResourceBandsByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findCableResourceBandsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByCableResAndAntennaOrderByBand
	 */
	public com.ibm.ejs.persistence.EJSFinder findByCableResAndAntennaOrderByBand(java.lang.Integer cable, java.lang.Integer antenna) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByCableResOrderByBand
	 */
	public com.ibm.ejs.persistence.EJSFinder findByCableResOrderByBand(java.lang.Integer cable) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
