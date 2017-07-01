package com.hps.july.persistence;

/**
 * EJSFinderRRLSpeedParamsBean
 */
public interface EJSFinderRRLSpeedParamsBean {
	/**
	 * findByResourceAndSpeed
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResourceAndSpeed(int argResource, java.lang.String argStreamSpeed) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findByResource
	 */
	public com.ibm.ejs.persistence.EJSFinder findByResource(int argResource) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
