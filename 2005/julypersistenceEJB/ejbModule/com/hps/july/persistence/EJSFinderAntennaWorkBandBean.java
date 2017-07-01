package com.hps.july.persistence;

/**
 * EJSFinderAntennaWorkBandBean
 */
public interface EJSFinderAntennaWorkBandBean {
	/**
	 * findAntennaWorkBandsByAntenna
	 */
	public com.ibm.ejs.persistence.EJSFinder findAntennaWorkBandsByAntenna(com.hps.july.persistence.AntennaKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
