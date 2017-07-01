package com.hps.july.persistence2;

/**
 * EJSFinderSitedoc2RegionBean
 */
public interface EJSFinderSitedoc2RegionBean {
	/**
	 * findAllBySitedoc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllBySitedoc(int argSiteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
