package com.hps.july.persistence;

/**
 * EJSFinderAntennaResourceBandBean
 */
public interface EJSFinderAntennaResourceBandBean {
	/**
	 * findAntennaResourceBandsByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findAntennaResourceBandsByResource(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
