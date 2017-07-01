package com.hps.july.persistence;

/**
 * EJSFinderRRLAntParamsBean
 */
public interface EJSFinderRRLAntParamsBean {
	/**
	 * findByResourceAndDiam
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResourceAndDiam(int argResource, java.math.BigDecimal argDiam) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResource(int argResource) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
