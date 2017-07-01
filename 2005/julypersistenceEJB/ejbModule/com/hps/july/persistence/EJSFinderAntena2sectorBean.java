package com.hps.july.persistence;

/**
 * EJSFinderAntena2sectorBean
 */
public interface EJSFinderAntena2sectorBean {
	/**
	 * findAntena2sectorsByAntenna
	 */
	public com.ibm.ejs.persistence.EJSFinder findAntena2sectorsByAntenna(com.hps.july.persistence.AntennaKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findAntena2sectorsBySector
	 */
	public com.ibm.ejs.persistence.EJSFinder findAntena2sectorsBySector(com.hps.july.persistence.SectorKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
