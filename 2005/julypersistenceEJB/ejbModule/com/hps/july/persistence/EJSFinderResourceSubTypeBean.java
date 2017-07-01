package com.hps.july.persistence;

/**
 * EJSFinderResourceSubTypeBean
 */
public interface EJSFinderResourceSubTypeBean {
	/**
	 * findResourceSubTypeByResourcetype
	 */
	public com.ibm.ejs.persistence.EJSFinder findResourceSubTypeByResourcetype(com.hps.july.persistence.ResourceTypeKey inKey) throws javax.ejb.FinderException, java.rmi.RemoteException;
}
