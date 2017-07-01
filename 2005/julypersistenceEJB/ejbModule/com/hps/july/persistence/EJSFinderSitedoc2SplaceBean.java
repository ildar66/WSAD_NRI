package com.hps.july.persistence;

/**
 * EJSFinderSitedoc2SplaceBean
 */
public interface EJSFinderSitedoc2SplaceBean {
	/**
	 * findSitedoc2SplacesByStoragePlace
	 */
	public com.ibm.ejs.persistence.EJSFinder findSitedoc2SplacesByStoragePlace(com.hps.july.persistence.StoragePlaceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSitedoc2SplacesBySiteDoc
	 */
	public com.ibm.ejs.persistence.EJSFinder findSitedoc2SplacesBySiteDoc(com.hps.july.persistence.SiteDocKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
