package com.hps.july.persistence;

/**
 * EJSFinderResourceSetPartBean
 */
public interface EJSFinderResourceSetPartBean {
	/**
	 * findSetPartsBySet
	 */
	public com.ibm.ejs.persistence.EJSFinder findSetPartsBySet(com.hps.july.persistence.ResourceSetKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findResourceSetPartsByPart
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourceSetPartsByPart(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
