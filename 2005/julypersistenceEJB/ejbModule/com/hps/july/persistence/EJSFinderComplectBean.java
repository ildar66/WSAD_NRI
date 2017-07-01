package com.hps.july.persistence;

/**
 * EJSFinderComplectBean
 */
public interface EJSFinderComplectBean {
	/**
	 * findComplectsByComplect
	 */
	public com.ibm.ejs.persistence.EJSFinder findComplectsByComplect(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
	/**
	 * findComplectpartsByParts
	 */
	public com.ibm.ejs.persistence.EJSFinder findComplectpartsByParts(com.hps.july.persistence.ResourceKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
