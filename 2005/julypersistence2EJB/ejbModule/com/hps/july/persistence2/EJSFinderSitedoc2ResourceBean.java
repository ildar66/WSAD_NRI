package com.hps.july.persistence2;

/**
 * EJSFinderSitedoc2ResourceBean
 */
public interface EJSFinderSitedoc2ResourceBean {
	/**
	 * findAllBySitedoc
	 */
	public com.ibm.ejs.persistence.EJSFinder findAllBySitedoc(int argSiteDoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
