package com.hps.july.trailcom.beans;

/**
 * EJSFinderSitedoc2HopsBean
 */
public interface EJSFinderSitedoc2HopsBean {
	/**
	 * findSitedoc2HopsByHop
	 */
	public com.ibm.ejs.persistence.EJSFinder findSitedoc2HopsByHop(com.hps.july.trailcom.beans.HopKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findSitedoc2HopsBySitedoc
	 */
	public com.ibm.ejs.persistence.EJSFinder findSitedoc2HopsBySitedoc(java.lang.Integer sitedoc) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
